package net.marsh.frostbornhorns.entity;

import net.marsh.frostbornhorns.FrostbornHornsEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

import static net.marsh.frostbornhorns.item.FrostbornHornsItems.*;

public class GoatSpearEntity extends PersistentProjectileEntity {
    private static final TrackedData<Boolean> ENCHANTED;
    public GoatSpearEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public GoatSpearEntity(World world, PlayerEntity player) {
        super(FrostbornHornsEntities.GOAT_SPEAR, world);
    }

    public ItemStack getWeaponStack() {
        return this.getItemStack();
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(GOAT_SPEAR);
    }

    public boolean isEnchanted() {
        return (Boolean)this.dataTracker.get(ENCHANTED);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
    }

    static {
        ENCHANTED = DataTracker.registerData(TridentEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
