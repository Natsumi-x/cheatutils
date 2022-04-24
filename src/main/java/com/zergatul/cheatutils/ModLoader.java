package com.zergatul.cheatutils;

import com.zergatul.cheatutils.controllers.*;
import net.minecraftforge.common.MinecraftForge;

public final class ModLoader {

    public static void setup() {
        KeyBindingsController.instance.setup();
        MinecraftForge.EVENT_BUS.register(KeyBindingsController.instance);
        MinecraftForge.EVENT_BUS.register(ChunkController.instance);
        MinecraftForge.EVENT_BUS.register(FreeCamController.instance);
        MinecraftForge.EVENT_BUS.register(RenderController.instance);
        MinecraftForge.EVENT_BUS.register(NetworkPacketsController.instance);
        MinecraftForge.EVENT_BUS.register(WorldLoadController.instance);
        MinecraftForge.EVENT_BUS.register(TeleportController.instance);
        MinecraftForge.EVENT_BUS.register(ShulkerTooltipController.instance);
        MinecraftForge.EVENT_BUS.register(AutoFishController.instance);
        MinecraftForge.EVENT_BUS.register(HoldUseKeyController.instance);
        MinecraftForge.EVENT_BUS.register(LightLevelController.instance);
        MinecraftForge.EVENT_BUS.register(CustomCommandsController.instance);
        MinecraftForge.EVENT_BUS.register(ClientTickController.instance);
        //MinecraftForge.EVENT_BUS.register(AutoDropController.instance);
        //MinecraftForge.EVENT_BUS.register(LavaCastBuilderController.instance);

        // commands
        /*MinecraftForge.EVENT_BUS.register(GetSpeedCommand.instance);
        MinecraftForge.EVENT_BUS.register(WaitNextTickCommand.instance);
        MinecraftForge.EVENT_BUS.register(GetPositionCommand.instance);
        MinecraftForge.EVENT_BUS.register(WaitWorldLoadCommand.instance);
        MinecraftForge.EVENT_BUS.register(MoveToCommand.instance);*/
    }
}
