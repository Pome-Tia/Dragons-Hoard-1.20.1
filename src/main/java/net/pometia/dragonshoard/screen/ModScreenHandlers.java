package net.pometia.dragonshoard.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.pometia.dragonshoard.DragonsHoard;

public class ModScreenHandlers {

    public static final ScreenHandlerType<JanAltarScreenHandler> JAN_ALTAR_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(DragonsHoard.MOD_ID, "jan_altar_screen_handler"), new ExtendedScreenHandlerType<>(JanAltarScreenHandler::new));
    public static final ScreenHandlerType<JanIdolScreenHandler> JAN_IDOL_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(DragonsHoard.MOD_ID, "jan_idol_screen_handler"), new ExtendedScreenHandlerType<>(JanIdolScreenHandler::new));

    public static void registerScreenHandler() {
        DragonsHoard.LOGGER.info("Registering Screen Handlers for " + DragonsHoard.MOD_ID);
    }
}
