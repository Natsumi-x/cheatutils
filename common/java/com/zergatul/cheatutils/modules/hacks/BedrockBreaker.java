package com.zergatul.cheatutils.modules.hacks;

import com.mojang.datafixers.util.Pair;
import com.zergatul.cheatutils.common.Events;
import com.zergatul.cheatutils.mixins.common.accessors.ClientLevelAccessor;
import com.zergatul.cheatutils.modules.Module;
import com.zergatul.cheatutils.scripting.api.Root;
import com.zergatul.cheatutils.utils.BlockPlacingMethod;
import com.zergatul.cheatutils.utils.BlockUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.prediction.BlockStatePredictionHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemOnPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Arrays;
import java.util.Comparator;

public class BedrockBreaker implements Module {

    public static final BedrockBreaker instance = new BedrockBreaker();

    private final Minecraft mc = Minecraft.getInstance();
    private final Direction[] horizontal = new Direction[] { Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH };
    private BlockPos bedrockPos;
    private BlockPos torchPos;
    private State state;
    private int tickCount;

    private BedrockBreaker() {
        Events.ClientTickEnd.add(this::onClientTickEnd);
    }

    public void process() {
        if (mc.player == null) {
            return;
        }
        if (mc.level == null) {
            return;
        }
        if (mc.hitResult == null) {
            return;
        }
        if (mc.hitResult.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockHitResult hitResult = (BlockHitResult) mc.hitResult;
        BlockPos pos = hitResult.getBlockPos();
        if (mc.level.getBlockState(pos).getBlock() != Blocks.BEDROCK) {
            return;
        }

        if (bedrockPos != null && bedrockPos.equals(pos)) {
            return;
        }

        bedrockPos = pos;
        state = State.START;
        tickCount = 0;
    }

    private void onClientTickEnd() {
        if (mc.player == null) {
            return;
        }
        if (mc.level == null) {
            return;
        }
        if (bedrockPos == null) {
            return;
        }

        tickCount++;

        switch (state) {
            case START -> {
                int pistonSlot = findItem(Items.PISTON);
                if (pistonSlot < 0) {
                    reset("Cannot find piston on hotbar");
                    return;
                }

                BlockUtils.PlaceBlockPlan plan = BlockUtils.getPlacingPlan(bedrockPos.above(), false, BlockPlacingMethod.FACING_TOP);
                if (plan == null) {
                    reset("Cannot place initial piston");
                    return;
                }

                mc.player.connection.send(new ServerboundSetCarriedItemPacket(pistonSlot));
                mc.player.connection.send(new ServerboundMovePlayerPacket.Rot(
                        mc.player.getYRot(),
                        90, // look down
                        mc.player.onGround()));
                mc.player.connection.send(new ServerboundUseItemOnPacket(
                        InteractionHand.MAIN_HAND,
                        new BlockHitResult(plan.target(), plan.direction(), plan.neighbour(), false),
                        getSequenceNumber()));

                int torchSlot = findItem(Items.REDSTONE_TORCH);
                if (torchSlot < 0) {
                    reset("Cannot find redstone torch on hotbar");
                    return;
                }

                torchPos = null;
                for (Direction direction : sortByDistance(bedrockPos.above(), horizontal)) {
                    BlockPos pos = bedrockPos.above().relative(direction);
                    BlockState state = mc.level.getBlockState(pos);
                    if (Blocks.REDSTONE_TORCH.canSurvive(Blocks.REDSTONE_TORCH.defaultBlockState(), mc.level, pos) && state.canBeReplaced()) {
                        torchPos = pos;
                        break;
                    }
                }

                if (torchPos == null) {
                    reset("Cannot find location to place torch");
                    return;
                }

                plan = BlockUtils.getPlacingPlan(torchPos, false, BlockPlacingMethod.FROM_TOP, Blocks.REDSTONE_TORCH.defaultBlockState());
                if (plan == null) {
                    reset("Cannot place redstone torch");
                    return;
                }

                mc.player.connection.send(new ServerboundSetCarriedItemPacket(torchSlot));
                mc.player.connection.send(new ServerboundUseItemOnPacket(
                        InteractionHand.MAIN_HAND,
                        new BlockHitResult(plan.target(), plan.direction(), plan.neighbour(), false),
                        getSequenceNumber()));

                state = State.WAIT_PISTON_EXTEND;
            }

            case WAIT_PISTON_EXTEND -> {
                if (mc.level.getBlockState(bedrockPos.above().above()).getBlock() == Blocks.PISTON_HEAD) {
                    // destroy torch
                    mc.player.connection.send(new ServerboundPlayerActionPacket(
                            ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK,
                            torchPos,
                            Direction.UP,
                            getSequenceNumber()));

                    mc.level.destroyBlock(torchPos, false);

                    int pickaxeSlot = findItem(Items.NETHERITE_PICKAXE);
                    if (pickaxeSlot < 0) {
                        reset("Cannot select pickaxe");
                        return;
                    }

                    // destroy piston
                    mc.player.connection.send(new ServerboundSetCarriedItemPacket(pickaxeSlot));
                    mc.player.connection.send(new ServerboundPlayerActionPacket(
                            ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK,
                            bedrockPos.above(),
                            Direction.UP,
                            getSequenceNumber()));

                    mc.level.destroyBlock(bedrockPos.above(), false);

                    int pistonSlot = findItem(Items.PISTON);
                    if (pistonSlot < 0) {
                        reset("Cannot select piston");
                        return;
                    }

                    BlockUtils.PlaceBlockPlan plan = BlockUtils.getPlacingPlan(bedrockPos.above(), false, BlockPlacingMethod.FACING_BOTTOM);
                    if (plan == null) {
                        reset("Cannot place reverse piston");
                        return;
                    }

                    mc.player.connection.send(new ServerboundSetCarriedItemPacket(pistonSlot));
                    mc.player.connection.send(new ServerboundMovePlayerPacket.Rot(
                            mc.player.getYRot(),
                            -90, // look up
                            mc.player.onGround()));
                    mc.player.connection.send(new ServerboundUseItemOnPacket(
                            InteractionHand.MAIN_HAND,
                            new BlockHitResult(plan.target(), plan.direction(), plan.neighbour(), false),
                            getSequenceNumber()));

                    state = State.WAIT_BEDROCK_BREAK;
                } else {
                    if (tickCount > 10) {
                        reset("Wait for piston extend timeout");
                    }
                }
            }

            case WAIT_BEDROCK_BREAK -> {
                if (mc.level.getBlockState(bedrockPos).isAir()) {
                    if (mc.level.getBlockState(bedrockPos.above()).is(Blocks.MOVING_PISTON)) {
                        // wait until moving piston converts to normal
                        return;
                    }

                    int pickaxeSlot = findItem(Items.NETHERITE_PICKAXE);
                    if (pickaxeSlot < 0) {
                        reset("Cannot select pickaxe");
                        return;
                    }

                    mc.player.connection.send(new ServerboundSetCarriedItemPacket(pickaxeSlot));
                    mc.player.connection.send(new ServerboundPlayerActionPacket(
                            ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK,
                            bedrockPos.above(),
                            Direction.DOWN,
                            getSequenceNumber()));

                    reset(null);
                } else {
                    if (tickCount > 20) {
                        reset("Wait for bedrock break timeout");
                    }
                }
            }
        }
    }

    private int findItem(Item item) {
        Inventory inventory = mc.player.getInventory();
        for (int i = 0; i < 9; i++) {
            if (inventory.getItem(i).is(item)) {
                return i;
            }
        }

        return -1;
    }

    private int getSequenceNumber() {
        BlockStatePredictionHandler handler = ((ClientLevelAccessor) mc.level).getBlockStatePredictionHandler_CU();
        handler.startPredicting();
        int num = handler.currentSequence();
        handler.close();
        return num;
    }

    private Direction[] sortByDistance(BlockPos origin, Direction[] directions) {
        return Arrays.stream(directions)
                .map(d -> new Pair<>(d, origin.relative(d).distToCenterSqr(mc.player.getEyePosition())))
                .sorted(Comparator.comparingDouble(Pair::getSecond))
                .map(p -> p.getFirst())
                .toArray(Direction[]::new);
    }

    private void reset(String message) {
        bedrockPos = null;
        state = State.START;
        tickCount = 0;

        if (mc.player != null) {
            mc.player.connection.send(new ServerboundSetCarriedItemPacket(mc.player.getInventory().selected));
        }

        if (message != null) {
            Root.main.systemMessage(message);
        }
    }

    private enum State {
        START,
        WAIT_PISTON_EXTEND,
        WAIT_BEDROCK_BREAK
    }
}