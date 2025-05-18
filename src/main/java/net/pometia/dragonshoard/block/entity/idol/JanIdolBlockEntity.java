package net.pometia.dragonshoard.block.entity.idol;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.UUID;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.pometia.dragonshoard.block.entity.ImplementedInventory;
import net.pometia.dragonshoard.block.entity.ModBlockEntities;
import net.pometia.dragonshoard.effect.ModEffects;
import net.pometia.dragonshoard.screen.JanIdolScreenHandler;
import net.pometia.dragonshoard.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class JanIdolBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
//    private static final Block[] ACTIVATING_BLOCKS = new Block[]{Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_STAIRS, ModBlocks.JAN_ALTAR};
//    private static final TagKey[] ENHANCING_BLOCKS = new TagKey[]{BlockTags.LOGS, BlockTags.ICE};
//    private static final Block[] ENHANCING_BLOCKS_VAL2 = new Block[]{ModBlocks.SILVER_BLOCK};
//    private static final Block[] ENHANCING_BLOCKS_VAL3 = new Block[]{Blocks.NETHERITE_BLOCK};
    //    private static final Block[] ENHANCING_BLOCKS_VAL1 = new Block[]{Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.SNOW_BLOCK};
    //    private static final Block[] ENHANCING_BLOCKS_VAL2 = new Block[]{ModBlocks.SILVER_BLOCK};
    //    private static final Block[] ENHANCING_BLOCKS_VAL3 = new Block[]{Blocks.NETHERITE_BLOCK};
    public int ticks;
    private float ticksActive;
    private boolean active;
    private boolean eyeOpen;
    public final List<BlockPos> activatingBlocks = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocks = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal1 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal2 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal3 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal4 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal5 = Lists.newArrayList();
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private final int offeringsTotalFinal = offeringsTotal(enhancingBlocksVal1, enhancingBlocksVal2, enhancingBlocksVal3, enhancingBlocksVal4, enhancingBlocksVal5);

    @Nullable
    private LivingEntity targetEntity;
    @Nullable
    private UUID targetUuid;
    private long nextAmbientSoundTime;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 1024;

    public JanIdolBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.JAN_IDOL_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> JanIdolBlockEntity.this.progress;
                    case 1 -> JanIdolBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int offerings) {
                switch (index) {
                    case 0: JanIdolBlockEntity.this.progress = offerings;
                    case 1: JanIdolBlockEntity.this.maxProgress = offerings;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };


    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.containsUuid("Target")) {
            this.targetUuid = nbt.getUuid("Target");
        } else {
            this.targetUuid = null;
        }
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("idol.progress");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.targetEntity != null) {
            nbt.putUuid("Target", this.targetEntity.getUuid());
        }
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("idol.progress", progress);
    }


    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    public static void clientTick(World world, BlockPos pos, BlockState state, JanIdolBlockEntity blockEntity) {
        blockEntity.ticks++;
        long l = world.getTime();
        List<BlockPos> list = blockEntity.activatingBlocks;
        List<BlockPos> list2 = blockEntity.enhancingBlocks;
        List<BlockPos> val1 = blockEntity.enhancingBlocksVal1;
        List<BlockPos> val2 = blockEntity.enhancingBlocksVal2;
        List<BlockPos> val3 = blockEntity.enhancingBlocksVal3;
        List<BlockPos> val4 = blockEntity.enhancingBlocksVal4;
        List<BlockPos> val5 = blockEntity.enhancingBlocksVal5;

        if (l % 40L == 0L) {
            blockEntity.active = updateActivatingBlocks(world, pos, list);
            blockEntity.active = updateEnhancingBlocks(world, pos, list2, val1, val2, val3, val4, val5);
            openEye(blockEntity, list);
        }

        updateTargetEntity(world, pos, blockEntity);
        spawnNautilusParticles(world, pos, list2, blockEntity.targetEntity, blockEntity.ticks);
        if (blockEntity.isActive()) {
            blockEntity.ticksActive++;
        }
    }

    public static void serverTick(World world, BlockPos pos, BlockState state, JanIdolBlockEntity blockEntity) {
        blockEntity.ticks++;
        long l = world.getTime();
        List<BlockPos> list = blockEntity.activatingBlocks;
        List<BlockPos> list2 = blockEntity.enhancingBlocks;
        List<BlockPos> val1 = blockEntity.enhancingBlocksVal1;
        List<BlockPos> val2 = blockEntity.enhancingBlocksVal2;
        List<BlockPos> val3 = blockEntity.enhancingBlocksVal3;
        List<BlockPos> val4 = blockEntity.enhancingBlocksVal4;
        List<BlockPos> val5 = blockEntity.enhancingBlocksVal5;
        if (l % 40L == 0L) {
            boolean bl = updateActivatingBlocks(world, pos, list);
            boolean bl2 = updateEnhancingBlocks(world, pos, list2, val1, val2, val3, val4, val5);
            if (bl != blockEntity.active) {
                SoundEvent soundEvent = bl ? SoundEvents.BLOCK_CONDUIT_ACTIVATE : SoundEvents.BLOCK_CONDUIT_DEACTIVATE;
                world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

            blockEntity.active = bl;
            openEye(blockEntity, list);
            if (bl2) {
                givePlayersEffects(world, pos, val1, val2, val3, val4, val5);
                //attackHostileEntity(world, pos, state, list2, blockEntity);
            }
        }

        if (blockEntity.isActive()) {
            if (l % 80L == 0L) {
                world.playSound(null, pos, SoundEvents.BLOCK_CONDUIT_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

            if (l > blockEntity.nextAmbientSoundTime) {
                blockEntity.nextAmbientSoundTime = l + 60L + (long) world.getRandom().nextInt(40);
                world.playSound(null, pos, SoundEvents.BLOCK_CONDUIT_AMBIENT_SHORT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    private static void openEye(JanIdolBlockEntity blockEntity, List<BlockPos> activatingBlocks) {
        blockEntity.setEyeOpen(activatingBlocks.size() >= 10);
    }

    private static boolean updateActivatingBlocks(World world, BlockPos pos, List<BlockPos> activatingBlocks) {
        activatingBlocks.clear();

        for (int i = -4; i <= 4; i++) {
            for (int j = -4; j <= 4; j++) {
                for (int kx = -4; kx <= 4; kx++) {
                    int l = Math.abs(i);
                    int m = Math.abs(j);
                    int n = Math.abs(kx);
                    BlockPos blockPos2 = pos.add(i, j, kx);
                    BlockState blockState = world.getBlockState(blockPos2);

//                        for (Block block : ACTIVATING_BLOCKS) {
                    if (blockState.isIn(ModTags.Blocks.JAN_FAVORED_BLOCKS_VALUE_1)) {
                        activatingBlocks.add(blockPos2);
                    }
                    //}
                }
            }
        }


        return activatingBlocks.size() >= 10;
    }

    public static boolean updateEnhancingBlocks(World world, BlockPos pos, List<BlockPos> enhancingBlocks, List<BlockPos> enhancingBlocksVal1, List<BlockPos> enhancingBlocksVal2, List<BlockPos> enhancingBlocksVal3, List<BlockPos> enhancingBlocksVal4, List<BlockPos> enhancingBlocksVal5) {
        enhancingBlocks.clear();
        enhancingBlocksVal1.clear();
        enhancingBlocksVal2.clear();
        enhancingBlocksVal3.clear();
        enhancingBlocksVal4.clear();
        enhancingBlocksVal5.clear();

//        offeringsTotal(world, pos, enhancingBlocks, enhancingBlocksVal1, enhancingBlocksVal2, enhancingBlocksVal3, enhancingBlocksVal4, enhancingBlocksVal5);

        for (int i = -4; i <= 4; i++) {
            for (int j = -4; j <= 4; j++) {
                for (int kx = -4; kx <= 4; kx++) {
                    int l = Math.abs(i);
                    int m = Math.abs(j);
                    int n = Math.abs(kx);
                    BlockPos blockPos2 = pos.add(i, j, kx);
                    BlockState blockState = world.getBlockState(blockPos2);

                    if (blockState.isIn(ModTags.Blocks.JAN_FAVORED_BLOCKS_VALUE_1)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal1.add(blockPos2);
                    }

                    if (blockState.isIn(ModTags.Blocks.JAN_FAVORED_BLOCKS_VALUE_2)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal2.add(blockPos2);
                    }

                    if (blockState.isIn(ModTags.Blocks.JAN_FAVORED_BLOCKS_VALUE_3)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal3.add(blockPos2);
                    }
                    if (blockState.isIn(ModTags.Blocks.JAN_FAVORED_BLOCKS_VALUE_4)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal4.add(blockPos2);
                    }
                    if (blockState.isIn(ModTags.Blocks.JAN_FAVORED_BLOCKS_VALUE_5)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal5.add(blockPos2);
                    }

                    }
                }
            }
//            int val1 = Math.abs(enhancingBlocksVal1.size());
//            int val2 = Math.abs(enhancingBlocksVal2.size() * 4);
//            int val3 = Math.abs(enhancingBlocksVal3.size() * 8);
//            int val4 = Math.abs(enhancingBlocksVal4.size() * 16);
//            int val5 = Math.abs(enhancingBlocksVal5.size() * 32);
//
//            int offerings = val1 + val2 + val3 + val4 + val5;

            return offeringsTotal(enhancingBlocksVal1, enhancingBlocksVal2, enhancingBlocksVal3, enhancingBlocksVal4, enhancingBlocksVal5) >= 64;
        }

        public static int offeringsTotal (List<BlockPos> enhancingBlocksVal1, List<BlockPos> enhancingBlocksVal2, List<BlockPos> enhancingBlocksVal3, List<BlockPos> enhancingBlocksVal4, List<BlockPos> enhancingBlocksVal5) {

        int val1 = Math.abs(enhancingBlocksVal1.size());
        int val2 = Math.abs(enhancingBlocksVal2.size() * 4);
        int val3 = Math.abs(enhancingBlocksVal3.size() * 8);
        int val4 = Math.abs(enhancingBlocksVal4.size() * 16);
        int val5 = Math.abs(enhancingBlocksVal5.size() * 32);

        int offerings = val1 + val2 + val3 + val4 + val5;

        return offerings;

        }

        private static void givePlayersEffects (World world, BlockPos pos, List<BlockPos> enhancingBlocksVal1, List<BlockPos> enhancingBlocksVal2, List<BlockPos> enhancingBlocksVal3, List<BlockPos> enhancingBlocksVal4, List<BlockPos> enhancingBlocksVal5){


            int i = offeringsTotal(enhancingBlocksVal1, enhancingBlocksVal2, enhancingBlocksVal3, enhancingBlocksVal4, enhancingBlocksVal5);
            int j = 10 + i / 16;
            int k = pos.getX();
            int l = pos.getY();
            int m = pos.getZ();
            Box box = new Box((double) k, (double) l, (double) m, (double) (k + 1), (double) (l + 1), (double) (m + 1))
                    .expand((double) j)
                    .stretch(0.0, (double) world.getHeight(), 0.0);
            List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, box);
            if (!list.isEmpty()) {
                for (PlayerEntity playerEntity : list) {
                    if (pos.isWithinDistance(playerEntity.getBlockPos(), (double) j)) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 260, 0, true, true));
                    }
                    if (pos.isWithinDistance(playerEntity.getBlockPos(), (double) j) && i >= 256) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 260, 0, true, true));
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 260, 0, true, true));
                    }
                    if (pos.isWithinDistance(playerEntity.getBlockPos(), (double) j) && i >= 512) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 260, 0, true, true));
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 260, 1, true, true));
                    }
                    if (pos.isWithinDistance(playerEntity.getBlockPos(), (double) j) && i >= 768) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 260, 0, true, true));
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 260, 2, true, true));
                    }
                    if (pos.isWithinDistance(playerEntity.getBlockPos(), (double) j) && i >= 1024) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 260, 0, true, true));
                        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 260, 2, true, true));
                        playerEntity.addStatusEffect(new StatusEffectInstance(ModEffects.FLIGHT, 260, 0, true, true));
                    }

                }
            }
        }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Idol");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new JanIdolScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
//    private static void attackHostileEntity(World world, BlockPos pos, BlockState state, List<BlockPos> enhancingBlocks, JanIdolBlockEntity blockEntity) {
//        LivingEntity livingEntity = blockEntity.targetEntity;
//        int i = enhancingBlocks.size();
//        if (i < 16) {
//            blockEntity.targetEntity = null;
//        } else if (blockEntity.targetEntity == null && blockEntity.targetUuid != null) {
//            blockEntity.targetEntity = findTargetEntity(world, pos, blockEntity.targetUuid);
//            blockEntity.targetUuid = null;
//        } else if (blockEntity.targetEntity == null) {
//            List<LivingEntity> list = world.getEntitiesByClass(
//                    LivingEntity.class, getAttackZone(pos), entity -> entity instanceof Monster
//            );
//            if (!list.isEmpty()) {
//                blockEntity.targetEntity = (LivingEntity)list.get(world.random.nextInt(list.size()));
//            }
//        } else if (!blockEntity.targetEntity.isAlive() || !pos.isWithinDistance(blockEntity.targetEntity.getBlockPos(), 8.0)) {
//            blockEntity.targetEntity = null;
//        }
//
//        if (blockEntity.targetEntity != null) {
//            world.playSound(
//                    null,
//                    blockEntity.targetEntity.getX(),
//                    blockEntity.targetEntity.getY(),
//                    blockEntity.targetEntity.getZ(),
//                    SoundEvents.BLOCK_CONDUIT_ATTACK_TARGET,
//                    SoundCategory.BLOCKS,
//                    1.0F,
//                    1.0F
//            );
//            blockEntity.targetEntity.damage(world.getDamageSources().magic(), 4.0F);
//        }
//
//        if (livingEntity != blockEntity.targetEntity) {
//            world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
//        }
//    }

        private static void updateTargetEntity (World world, BlockPos pos, JanIdolBlockEntity blockEntity){
            if (blockEntity.targetUuid == null) {
                blockEntity.targetEntity = null;
            } else if (blockEntity.targetEntity == null || !blockEntity.targetEntity.getUuid().equals(blockEntity.targetUuid)) {
                blockEntity.targetEntity = findTargetEntity(world, pos, blockEntity.targetUuid);
                if (blockEntity.targetEntity == null) {
                    blockEntity.targetUuid = null;
                }
            }
        }

        private static Box getAttackZone (BlockPos pos){
            int i = pos.getX();
            int j = pos.getY();
            int k = pos.getZ();
            return new Box((double) i, (double) j, (double) k, (double) (i + 1), (double) (j + 1), (double) (k + 1)).expand(8.0);
        }

        @Nullable
        private static LivingEntity findTargetEntity (World world, BlockPos pos, UUID uuid){
            List<LivingEntity> list = world.getEntitiesByClass(LivingEntity.class, getAttackZone(pos), entity -> entity.getUuid().equals(uuid));
            return list.size() == 1 ? (LivingEntity) list.get(0) : null;
        }

        private static void spawnNautilusParticles (World world, BlockPos
        pos, List < BlockPos > enhancingBlocks, @Nullable Entity entity,int ticks){
            Random random = world.random;
            double d = (double) (MathHelper.sin((float) (ticks + 35) * 0.1F) / 2.0F + 0.5F);
            d = (d * d + d) * 0.3F;
            Vec3d vec3d = new Vec3d((double) pos.getX() + 0.5, (double) pos.getY() + 1.5 + d, (double) pos.getZ() + 0.5);

            for (BlockPos blockPos : enhancingBlocks) {
                if (random.nextInt(200) == 0) {
                    BlockPos blockPos2 = blockPos.subtract(pos);
                    float f = -0.5F + random.nextFloat() + (float) blockPos2.getX();
                    float g = -2.0F + random.nextFloat() + (float) blockPos2.getY();
                    float h = -0.5F + random.nextFloat() + (float) blockPos2.getZ();
                    world.addParticle(ParticleTypes.ENCHANT, vec3d.x, vec3d.y, vec3d.z, (double) f, (double) g, (double) h);
                }
            }

            if (entity != null) {
                Vec3d vec3d2 = new Vec3d(entity.getX(), entity.getEyeY(), entity.getZ());
                float i = (-0.5F + random.nextFloat()) * (3.0F + entity.getWidth());
                float j = -1.0F + random.nextFloat() * entity.getHeight();
                float f = (-0.5F + random.nextFloat()) * (3.0F + entity.getWidth());
                Vec3d vec3d3 = new Vec3d((double) i, (double) j, (double) f);
                world.addParticle(ParticleTypes.ENCHANT, vec3d2.x, vec3d2.y, vec3d2.z, vec3d3.x, vec3d3.y, vec3d3.z);
            }
        }

        public boolean isActive () {
            return this.active;
        }

        public boolean isEyeOpen () {
            return this.eyeOpen;
        }

        private void setEyeOpen ( boolean eyeOpen){
            this.eyeOpen = eyeOpen;
        }

        public float getRotation ( float tickDelta){
            return (this.ticksActive + tickDelta) * -0.0375F;
        }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }
}

