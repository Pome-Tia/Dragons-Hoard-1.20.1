package net.pometia.dragonshoard.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.block.ModBlocks;

import static net.pometia.dragonshoard.block.ModBlocks.*;

public class ModItems {

    //Ingots
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item WHITE_GOLD_INGOT = registerItem("white_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item BLUE_GOLD_INGOT = registerItem("blue_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item STAR_BLUE_GOLD_INGOT = registerItem("star_blue_gold_ingot", new Item(new FabricItemSettings()));
    //Gems
    public static final Item ALEXANDRITE_GEM = registerItem("alexandrite_gem", new Item(new FabricItemSettings()));
    public static final Item AQUAMARINE_GEM = registerItem("aquamarine_gem", new Item(new FabricItemSettings()));
    public static final Item CITRINE_GEM = registerItem("citrine_gem", new Item(new FabricItemSettings()));
    public static final Item IOLITE_GEM = registerItem("iolite_gem", new Item(new FabricItemSettings()));
    public static final Item MOONSTONE_GEM = registerItem("moonstone_gem", new Item(new FabricItemSettings()));
    public static final Item OPAL_GEM = registerItem("opal_gem", new Item(new FabricItemSettings()));
    public static final Item PERIDOT_GEM = registerItem("peridot_gem", new Item(new FabricItemSettings()));
    public static final Item ROSE_QUARTZ_GEM = registerItem("rose_quartz_gem", new Item(new FabricItemSettings()));
    public static final Item VERDELITE_GEM = registerItem("verdelite_gem", new Item(new FabricItemSettings()));
    public static final Item TANZANITE_GEM = registerItem("tanzanite_gem", new Item(new FabricItemSettings()));
    public static final Item RUBY_GEM = registerItem("ruby_gem", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE_GEM = registerItem("sapphire_gem", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DragonsHoard.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        //Altars
        entries.add(JAN_ALTAR);
        //Idols
        entries.add(JAN_IDOL);
        entries.add(FEB_IDOL);
        entries.add(MAR_IDOL);
        entries.add(APR_IDOL);
        entries.add(MAY_IDOL);
        entries.add(JUN_IDOL);
        entries.add(JUL_IDOL);
        entries.add(AUG_IDOL);
        entries.add(SEP_IDOL);
        entries.add(OCT_IDOL);
        entries.add(NOV_IDOL);
        entries.add(DEC_IDOL);
        //Ingots
        entries.add(SILVER_INGOT);
        entries.add(ROSE_GOLD_INGOT);
        entries.add(WHITE_GOLD_INGOT);
        entries.add(BLUE_GOLD_INGOT);
        entries.add(STAR_BLUE_GOLD_INGOT);
        //Gems
        entries.add(ALEXANDRITE_GEM);
        entries.add(AQUAMARINE_GEM);
        entries.add(CITRINE_GEM);
        entries.add(IOLITE_GEM);
        entries.add(MOONSTONE_GEM);
        entries.add(OPAL_GEM);
        entries.add(PERIDOT_GEM);
        entries.add(ROSE_QUARTZ_GEM);
        entries.add(VERDELITE_GEM);
        entries.add(TANZANITE_GEM);
        entries.add(RUBY_GEM);
        entries.add(SAPPHIRE_GEM);
        //Cut Crystals
        entries.add(ModBlocks.CUT_ALEXANDRITE);
        //Raw Crystals
        entries.add(ModBlocks.ALEXANDRITE_CRYSTAL);
        entries.add(ModBlocks.AQUAMARINE_CRYSTAL);
        entries.add(ModBlocks.CITRINE_CRYSTAL);
        entries.add(ModBlocks.IOLITE_CRYSTAL);
        entries.add(ModBlocks.MOONSTONE_CRYSTAL);
        entries.add(ModBlocks.PERIDOT_CRYSTAL);
        entries.add(ModBlocks.ROSE_QUARTZ_CRYSTAL);
        entries.add(ModBlocks.VERDELITE_CRYSTAL);
        entries.add(ModBlocks.TANZANITE_CRYSTAL);
        entries.add(ModBlocks.SAPPHIRE_CRYSTAL);
        entries.add(ModBlocks.RUBY_CRYSTAL);
        entries.add(ModBlocks.OPAL_CRYSTAL);
        //Metal Blocks
        entries.add(ModBlocks.SILVER_BLOCK);
        entries.add(ModBlocks.WHITE_GOLD_BLOCK);
        entries.add(ModBlocks.ROSE_GOLD_BLOCK);
        entries.add(ModBlocks.BLUE_GOLD_BLOCK);
        entries.add(ModBlocks.STAR_BLUE_GOLD_BLOCK);
    }

    public static void registerModItems() {
        DragonsHoard.LOGGER.info("Registering Mod Items for " + DragonsHoard.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);

    }
}
