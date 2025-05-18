package net.pometia.dragonshoard.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.pometia.dragonshoard.DragonsHoard;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_1 = createBlockTag("jan_favored_blocks_value_1");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_2 = createBlockTag("jan_favored_blocks_value_2");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_3 = createBlockTag("jan_favored_blocks_value_3");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_4 = createBlockTag("jan_favored_blocks_value_4");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_5 = createBlockTag("jan_favored_blocks_value_5");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(DragonsHoard.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }

    }

    public static class Items {

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(DragonsHoard.MOD_ID, name));
        }

        private static TagKey<Item> createCommonItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }

    }
}
