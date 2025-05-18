package net.pometia.dragonshoard;

import net.fabricmc.api.ModInitializer;

import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.block.entity.ModBlockEntities;
import net.pometia.dragonshoard.effect.ModEffects;
import net.pometia.dragonshoard.item.ModItems;
import net.pometia.dragonshoard.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DragonsHoard implements ModInitializer {
	public static final String MOD_ID = "dragonshoard";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntries();
		ModEffects.registerEffects();
		ModScreenHandlers.registerScreenHandler();
	}
}