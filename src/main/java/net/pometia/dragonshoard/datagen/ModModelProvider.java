package net.pometia.dragonshoard.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.item.ModItems;

public class ModModelProvider  extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Raw Crystals
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AQUAMARINE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CITRINE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IOLITE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOONSTONE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OPAL_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PERIDOT_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_QUARTZ_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERDELITE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TANZANITE_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_CRYSTAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_CRYSTAL);
        //Metal Blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STAR_BLUE_GOLD_BLOCK);
        //Altars
//        blockStateModelGenerator.registerSingleton(ModBlocks.JAN_ALTAR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //Ingots
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STAR_BLUE_GOLD_INGOT, Models.GENERATED);
        //Gems
        itemModelGenerator.register(ModItems.ALEXANDRITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.AQUAMARINE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.IOLITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOONSTONE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.OPAL_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PERIDOT_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_QUARTZ_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDELITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TANZANITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_GEM, Models.GENERATED);

    }
}
