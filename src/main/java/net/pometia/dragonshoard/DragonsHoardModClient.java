package net.pometia.dragonshoard;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.pometia.dragonshoard.screen.JanAltarScreen;
import net.pometia.dragonshoard.screen.JanIdolScreen;
import net.pometia.dragonshoard.screen.ModScreenHandlers;

public class DragonsHoardModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.JAN_ALTAR_SCREEN_HANDLER, JanAltarScreen::new);
        HandledScreens.register(ModScreenHandlers.JAN_IDOL_SCREEN_HANDLER, JanIdolScreen::new);

    }
}
