package net.marsh.frostbornhorns.entity;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GoatVillagerEntity extends AbstractGoatVillagerEntity {
    private static final TrackedData<Boolean> BABY;
    private static final Identifier BABY_SPEED_BOOST_ID;
    private static final EntityAttributeModifier BABY_SPEED_BOOST;

    public GoatVillagerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public @Nullable EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        this.onGrowUp();
        return super.initialize(world, difficulty, spawnReason, entityData);
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

    protected void onGrowUp() {
        if (this.isBaby()) {
            this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(1.0);
            this.removeHorns();
        } else {
            this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(2.0);
            this.addHorns();
        }
    }

    public boolean isBaby() {
        return this.getDataTracker().get(BABY);
    }

    public static DefaultAttributeContainer.Builder createGoatVillagerAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 15)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.15f)
                .add(EntityAttributes.WATER_MOVEMENT_EFFICIENCY, 2.5f);
    }

    static {
        BABY = DataTracker.registerData(GoatVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        BABY_SPEED_BOOST_ID = Identifier.ofVanilla("baby");
        BABY_SPEED_BOOST = new EntityAttributeModifier(BABY_SPEED_BOOST_ID, 0.20000000298023224, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }
}
