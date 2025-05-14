package net.marsh.frostbornhorns.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class AbstractGoatVillagerEntity extends HostileEntity implements Angerable {
    private static final TrackedData<Boolean> LEFT_HORN;
    private static final TrackedData<Boolean> RIGHT_HORN;
    private int headPitch;

    @Nullable
    private UUID angryAt;
    public AbstractGoatVillagerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        if (!isBaby() && (double)random.nextFloat() < 0.10000000149011612) {
            TrackedData<Boolean> trackedData = random.nextBoolean() ? LEFT_HORN : RIGHT_HORN;
            this.dataTracker.set(trackedData, false);
        }
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("HasLeftHorn", this.hasLeftHorn());
        nbt.putBoolean("HasRightHorn", this.hasRightHorn());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(LEFT_HORN, nbt.getBoolean("HasLeftHorn", true));
        this.dataTracker.set(RIGHT_HORN, nbt.getBoolean("HasRightHorn", true));
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(LEFT_HORN, true);
        builder.add(RIGHT_HORN, true);
    }

    public void addHorns() {
        this.dataTracker.set(LEFT_HORN, true);
        this.dataTracker.set(RIGHT_HORN, true);
    }

    public void removeHorns() {
        this.dataTracker.set(LEFT_HORN, false);
        this.dataTracker.set(RIGHT_HORN, false);
    }

    public boolean hasLeftHorn() {
        return this.dataTracker.get(LEFT_HORN);
    }

    public boolean hasRightHorn() {
        return this.dataTracker.get(RIGHT_HORN);
    }

    @Override
    public int getAngerTime() {
        return 0;
    }

    @Override
    public void setAngerTime(int angerTime) {}
    protected int computeFallDamage(double fallDistance, float damagePerDistance) {
        return super.computeFallDamage(fallDistance, damagePerDistance) - 10;
    }
    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GOAT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_GOAT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GOAT_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_GOAT_STEP, 0.15F, 1.0F);
    }
    @Nullable
    @Override
    public UUID getAngryAt() {return this.angryAt;}

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {this.angryAt = angryAt;}

    @Override
    public void chooseRandomAngerTime() {}

    public static boolean canSpawn(EntityType<AbstractGoatVillagerEntity> goatVillagerEntityEntityType, ServerWorldAccess serverWorldAccess, SpawnReason spawnReason, BlockPos blockPos, Random random) {
        return true;
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    public float getHeadPitch() {
        return (float)this.headPitch / 20.0F * 30.0F * 0.017453292F;
    }

    static {
        LEFT_HORN = DataTracker.registerData(AbstractGoatVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        RIGHT_HORN = DataTracker.registerData(AbstractGoatVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
