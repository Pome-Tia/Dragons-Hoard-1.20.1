package net.pometia.dragonshoard.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.pometia.dragonshoard.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Raw Crystals
        addDrop(ModBlocks.ALEXANDRITE_CRYSTAL);
        addDrop(ModBlocks.AQUAMARINE_CRYSTAL);
        addDrop(ModBlocks.CITRINE_CRYSTAL);
        addDrop(ModBlocks.IOLITE_CRYSTAL);
        addDrop(ModBlocks.MOONSTONE_CRYSTAL);
        addDrop(ModBlocks.OPAL_CRYSTAL);
        addDrop(ModBlocks.PERIDOT_CRYSTAL);
        addDrop(ModBlocks.ROSE_QUARTZ_CRYSTAL);
        addDrop(ModBlocks.VERDELITE_CRYSTAL);
        addDrop(ModBlocks.TANZANITE_CRYSTAL);
        addDrop(ModBlocks.RUBY_CRYSTAL);
        addDrop(ModBlocks.SAPPHIRE_CRYSTAL);

    }
}
