package net.marsh.frostbornhorns.entity;

import com.mojang.serialization.Dynamic;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.brain.Brain;
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
import net.minecraft.entity.passive.GoatBrain;
import net.minecraft.entity.passive.GoatEntity;
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

public class GoatVillagerEntity extends HostileEntity implements Angerable {
    private static final TrackedData<Boolean> BABY;
    private static final Identifier BABY_SPEED_BOOST_ID;
    private static final EntityAttributeModifier BABY_SPEED_BOOST;
    private static final TrackedData<Boolean> LEFT_HORN;
    private static final TrackedData<Boolean> RIGHT_HORN;
    private int headPitch;

    @Nullable
    private UUID angryAt;
    public GoatVillagerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        this.onGrowUp();
        if (!this.isBaby() && (double)random.nextFloat() < 0.10000000149011612) {
            TrackedData<Boolean> trackedData = random.nextBoolean() ? LEFT_HORN : RIGHT_HORN;
            this.dataTracker.set(trackedData, false);
        }
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("IsBaby", this.isBaby());
        nbt.putBoolean("HasLeftHorn", this.hasLeftHorn());
        nbt.putBoolean("HasRightHorn", this.hasRightHorn());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setBaby(nbt.getBoolean("IsBaby", false));
        this.dataTracker.set(LEFT_HORN, nbt.getBoolean("HasLeftHorn", true));
        this.dataTracker.set(RIGHT_HORN, nbt.getBoolean("HasRightHorn", true));
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(BABY, false);
        builder.add(LEFT_HORN, true);
        builder.add(RIGHT_HORN, true);
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
        if (BABY.equals(data)) {
            this.calculateDimensions();
        }

    }

    public static DefaultAttributeContainer.Builder createGoatVillagerAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 15)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.15f)
                .add(EntityAttributes.WATER_MOVEMENT_EFFICIENCY, 2.5f);
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
    @Override
    public SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_GOAT_HURT;}
    @Nullable
    @Override
    public SoundEvent getDeathSound() {return SoundEvents.ENTITY_GOAT_DEATH;}
    @Nullable
    @Override
    public UUID getAngryAt() {return this.angryAt;}

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {this.angryAt = angryAt;}

    @Override
    public void chooseRandomAngerTime() {}

    public static boolean canSpawn(EntityType<GoatVillagerEntity> goatVillagerEntityEntityType, ServerWorldAccess serverWorldAccess, SpawnReason spawnReason, BlockPos blockPos, Random random) {
        return true;
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    protected void onGrowUp() {
        if (this.isBaby()) {
            this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(1.0);
            this.removeHorns();
        } else {
            this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(2.0);
            this.addHorns();
        }

    }
    public void addHorns() {
        this.dataTracker.set(LEFT_HORN, true);
        this.dataTracker.set(RIGHT_HORN, true);
    }

    public void removeHorns() {
        this.dataTracker.set(LEFT_HORN, false);
        this.dataTracker.set(RIGHT_HORN, false);
    }
    public void setBaby(boolean baby) {
        this.getDataTracker().set(BABY, baby);
        if (!this.getWorld().isClient) {
            EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
            entityAttributeInstance.removeModifier(BABY_SPEED_BOOST.id());
            if (baby) {
                this.removeHorns();
                entityAttributeInstance.addTemporaryModifier(BABY_SPEED_BOOST);
            }
        }

    }
    public boolean isBaby() {
        return this.getDataTracker().get(BABY);
    }
    public boolean hasLeftHorn() {
        return this.dataTracker.get(LEFT_HORN);
    }

    public boolean hasRightHorn() {
        return this.dataTracker.get(RIGHT_HORN);
    }
    public float getHeadPitch() {
        return (float)this.headPitch / 20.0F * 30.0F * 0.017453292F;
    }
    static {
        BABY = DataTracker.registerData(GoatVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        BABY_SPEED_BOOST_ID = Identifier.ofVanilla("baby");
        BABY_SPEED_BOOST = new EntityAttributeModifier(BABY_SPEED_BOOST_ID, 0.20000000298023224, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        LEFT_HORN = DataTracker.registerData(GoatVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        RIGHT_HORN = DataTracker.registerData(GoatVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
