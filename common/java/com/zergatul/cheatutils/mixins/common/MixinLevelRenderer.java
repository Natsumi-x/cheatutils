package com.zergatul.cheatutils.mixins.common;

import com.mojang.blaze3d.vertex.PoseStack;
import com.zergatul.cheatutils.common.Events;
import com.zergatul.cheatutils.common.events.RenderWorldLastEvent;
import com.zergatul.cheatutils.configs.ConfigStore;
import com.zergatul.cheatutils.entities.FakePlayer;
import com.zergatul.cheatutils.helpers.MixinLevelRendererHelper;
import com.zergatul.cheatutils.modules.esp.FreeCam;
import com.zergatul.cheatutils.render.gl.GlStateTracker;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public abstract class MixinLevelRenderer {

    @Shadow
    @Final
    private RenderBuffers renderBuffers;

    @Shadow
    @Final
    private Minecraft minecraft;

    @Shadow
    protected abstract void renderEntity(Entity p_109518_, double p_109519_, double p_109520_, double p_109521_, float p_109522_, PoseStack p_109523_, MultiBufferSource p_109524_);

    @ModifyArg(
            method = "renderLevel",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;setupRender(Lnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/culling/Frustum;ZZ)V"),
            index = 3)
    private boolean onCallSetupRender(boolean isSpectator) {
        if (FreeCam.instance.isActive()) {
            return true;
        } else {
            return isSpectator;
        }
    }

    @Inject(
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/MultiBufferSource$BufferSource;endLastBatch()V", ordinal = 0),
            method = "renderLevel")
    private void onAfterRenderEntities(
            DeltaTracker delta,
            boolean renderBlockOutline,
            Camera camera,
            GameRenderer gameRenderer,
            LightTexture lightTexture,
            Matrix4f pose,
            Matrix4f projection,
            CallbackInfo info
    ) {
        if (FakePlayer.list.isEmpty()) {
            return;
        }
        LocalPlayer player = this.minecraft.player;
        if (player == null) {
            return;
        }

        MultiBufferSource.BufferSource source = this.renderBuffers.bufferSource();
        Vec3 view = camera.getPosition();
        double x = view.x;
        double y = view.y;
        double z = view.z;
        for (FakePlayer fake : FakePlayer.list) {
            if (fake.distanceToSqr(player) > 1) {
                // is new PoseStack good for compatibility?
                // capture local var?
                this.renderEntity(fake, x, y, z, delta.getGameTimeDeltaPartialTick(true), new PoseStack(), source);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "renderLevel")
    private void onRenderLevelBegin(
            DeltaTracker delta,
            boolean renderBlockOutline,
            Camera camera,
            GameRenderer gameRenderer,
            LightTexture lightTexture,
            Matrix4f pose,
            Matrix4f projection,
            CallbackInfo info
    ) {
        Events.BeforeRenderWorld.trigger();
    }

    @Inject(at = @At("RETURN"), method = "renderLevel")
    private void onRenderLevelEnd(
            DeltaTracker delta,
            boolean renderBlockOutline,
            Camera camera,
            GameRenderer gameRenderer,
            LightTexture lightTexture,
            Matrix4f pose,
            Matrix4f projection,
            CallbackInfo info
    ) {
        GlStateTracker.save();
        Events.AfterRenderWorld.trigger(new RenderWorldLastEvent(pose, projection, delta));
        GlStateTracker.restore();
    }

    @Inject(at = @At("HEAD"), method = "renderSnowAndRain", cancellable = true)
    private void onRenderSnowAndRain(LightTexture p_109704_, float p_109705_, double p_109706_, double p_109707_, double p_109708_, CallbackInfo info) {
        if (ConfigStore.instance.getConfig().noWeatherConfig.enabled) {
            info.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "renderEntity")
    private void onBeforeRenderEntity(Entity entity, double x, double y, double z, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, CallbackInfo info) {
        MixinLevelRendererHelper.current = entity;
    }

    @Inject(at = @At("TAIL"), method = "renderEntity")
    private void onAfterRenderEntity(Entity entity, double x, double y, double z, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, CallbackInfo info) {
        MixinLevelRendererHelper.current = null;
    }
}