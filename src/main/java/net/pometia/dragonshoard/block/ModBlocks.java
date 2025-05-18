package net.pometia.dragonshoard.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.block.custom.altar.JanAltarBlock;
import net.pometia.dragonshoard.block.custom.idol.JanIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.FebIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.MarIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.AprIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.MayIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.JunIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.JulIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.AugIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.SepIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.OctIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.NovIdolBlock;
import net.pometia.dragonshoard.block.custom.idol.DecIdolBlock;

public class ModBlocks {
    //Altars
    public static final Block JAN_ALTAR = registerBlock("jan_altar", new JanAltarBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    //Idols
    public static final Block JAN_IDOL = registerBlock("jan_idol", new JanIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block FEB_IDOL = registerBlock("feb_idol", new FebIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block MAR_IDOL = registerBlock("mar_idol", new MarIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block APR_IDOL = registerBlock("apr_idol", new AprIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block MAY_IDOL = registerBlock("may_idol", new MayIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block JUN_IDOL = registerBlock("jun_idol", new JunIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block JUL_IDOL = registerBlock("jul_idol", new JulIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block AUG_IDOL = registerBlock("aug_idol", new AugIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block SEP_IDOL = registerBlock("sep_idol", new SepIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block OCT_IDOL = registerBlock("oct_idol", new OctIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block NOV_IDOL = registerBlock("nov_idol", new NovIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    public static final Block DEC_IDOL = registerBlock("dec_idol", new DecIdolBlock(FabricBlockSettings.copyOf(Blocks.CONDUIT)));
    //Raw Crystal
    public static final Block ALEXANDRITE_CRYSTAL = registerBlock("alexandrite_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block AQUAMARINE_CRYSTAL = registerBlock("aquamarine_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block CITRINE_CRYSTAL = registerBlock("citrine_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block IOLITE_CRYSTAL = registerBlock("iolite_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block MOONSTONE_CRYSTAL = registerBlock("moonstone_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block OPAL_CRYSTAL = registerBlock("opal_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block PERIDOT_CRYSTAL = registerBlock("peridot_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block ROSE_QUARTZ_CRYSTAL = registerBlock("rose_quartz_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block VERDELITE_CRYSTAL = registerBlock("verdelite_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block TANZANITE_CRYSTAL = registerBlock("tanzanite_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block RUBY_CRYSTAL = registerBlock("ruby_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_CRYSTAL = registerBlock("sapphire_crystal", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    // Cut Crystal
    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    //Metal Blocks
    public static final Block SILVER_BLOCK = registerBlock("silver_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block WHITE_GOLD_BLOCK = registerBlock("white_gold_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block BLUE_GOLD_BLOCK = registerBlock("blue_gold_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block STAR_BLUE_GOLD_BLOCK = registerBlock("star_blue_gold_block", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
//    public static final Block CUT_ALEXANDRITE = registerBlock("cut_alexandrite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DragonsHoard.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DragonsHoard.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        DragonsHoard.LOGGER.info("Registering ModBlocks for " + DragonsHoard.MOD_ID);
    }
}
