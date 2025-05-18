package net.pometia.dragonshoard.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.block.entity.altar.JanAltarBlockEntity;
import net.pometia.dragonshoard.block.entity.idol.*;

public class ModBlockEntities {
    //Altar
    public static final BlockEntityType<JanAltarBlockEntity> JAN_ALTAR_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "jan_altar_block_entity"), FabricBlockEntityTypeBuilder.create(JanAltarBlockEntity::new, ModBlocks.JAN_ALTAR).build(null));
    //Idols
    public static final BlockEntityType<JanIdolBlockEntity> JAN_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "jan_idol_block_entity"), FabricBlockEntityTypeBuilder.create(JanIdolBlockEntity::new, ModBlocks.JAN_IDOL).build(null));
    public static final BlockEntityType<FebIdolBlockEntity> FEB_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "feb_idol_block_entity"), FabricBlockEntityTypeBuilder.create(FebIdolBlockEntity::new, ModBlocks.FEB_IDOL).build(null));
    public static final BlockEntityType<MarIdolBlockEntity> MAR_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "mar_idol_block_entity"), FabricBlockEntityTypeBuilder.create(MarIdolBlockEntity::new, ModBlocks.MAR_IDOL).build(null));
    public static final BlockEntityType<AprIdolBlockEntity> APR_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "apr_idol_block_entity"), FabricBlockEntityTypeBuilder.create(AprIdolBlockEntity::new, ModBlocks.APR_IDOL).build(null));
    public static final BlockEntityType<MayIdolBlockEntity> MAY_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "may_idol_block_entity"), FabricBlockEntityTypeBuilder.create(MayIdolBlockEntity::new, ModBlocks.MAY_IDOL).build(null));
    public static final BlockEntityType<JunIdolBlockEntity> JUN_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "jun_idol_block_entity"), FabricBlockEntityTypeBuilder.create(JunIdolBlockEntity::new, ModBlocks.JUN_IDOL).build(null));
    public static final BlockEntityType<JulIdolBlockEntity> JUL_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "jul_idol_block_entity"), FabricBlockEntityTypeBuilder.create(JulIdolBlockEntity::new, ModBlocks.JUL_IDOL).build(null));
    public static final BlockEntityType<AugIdolBlockEntity> AUG_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "aug_idol_block_entity"), FabricBlockEntityTypeBuilder.create(AugIdolBlockEntity::new, ModBlocks.AUG_IDOL).build(null));
    public static final BlockEntityType<SepIdolBlockEntity> SEP_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "sep_idol_block_entity"), FabricBlockEntityTypeBuilder.create(SepIdolBlockEntity::new, ModBlocks.SEP_IDOL).build(null));
    public static final BlockEntityType<OctIdolBlockEntity> OCT_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "oct_idol_block_entity"), FabricBlockEntityTypeBuilder.create(OctIdolBlockEntity::new, ModBlocks.OCT_IDOL).build(null));
    public static final BlockEntityType<NovIdolBlockEntity> NOV_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "nov_idol_block_entity"), FabricBlockEntityTypeBuilder.create(NovIdolBlockEntity::new, ModBlocks.NOV_IDOL).build(null));
    public static final BlockEntityType<DecIdolBlockEntity> DEC_IDOL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DragonsHoard.MOD_ID, "dec_idol_block_entity"), FabricBlockEntityTypeBuilder.create(DecIdolBlockEntity::new, ModBlocks.DEC_IDOL).build(null));


    public static void registerBlockEntries() {
        DragonsHoard.LOGGER.info("Registering Block Entities for " + DragonsHoard.MOD_ID);
    }
}
