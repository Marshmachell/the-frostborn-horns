package net.marsh.frostbornhorns.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.InventoryOwner;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class GoatVillagerEntity extends HostileEntity implements Angerable {
    private static final TrackedData<Boolean> BABY;
    private static final Identifier BABY_SPEED_BOOST_ID;
    private static final EntityAttributeModifier BABY_SPEED_BOOST;
    @Nullable
    private UUID angryAt;
    public GoatVillagerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("IsBaby", this.isBaby());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setBaby(nbt.getBoolean("IsBaby", false));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(BABY, false);
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
    public void setAngerTime(int angerTime) {

    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public void chooseRandomAngerTime() {

    }

    public static boolean canSpawn(EntityType<GoatVillagerEntity> goatVillagerEntityEntityType, ServerWorldAccess serverWorldAccess, SpawnReason spawnReason, BlockPos blockPos, Random random) {
        return true;
    }
    public void setBaby(boolean baby) {
        this.getDataTracker().set(BABY, baby);
        if (!this.getWorld().isClient) {
            EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
            entityAttributeInstance.removeModifier(BABY_SPEED_BOOST.id());
            if (baby) {
                entityAttributeInstance.addTemporaryModifier(BABY_SPEED_BOOST);
            }
        }

    }
    static {
        BABY = DataTracker.registerData(GoatVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        BABY_SPEED_BOOST_ID = Identifier.ofVanilla("baby");
        BABY_SPEED_BOOST = new EntityAttributeModifier(BABY_SPEED_BOOST_ID, 0.20000000298023224, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }
}
