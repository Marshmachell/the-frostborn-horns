package net.marsh.frostbornhorns.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

import static net.marsh.frostbornhorns.item.TheFrostbornHornsItems.*;

public class GoatSpearEntity extends PersistentProjectileEntity {
    private static final TrackedData<Boolean> ENCHANTED;
    public GoatSpearEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    //public GoatSpearEntity(World world, LivingEntity owner, ItemStack stack) {
    //        super(EntityType.TRIDENT, owner, world, stack, (ItemStack)null);
    //        this.dataTracker.set(ENCHANTED, stack.hasGlint());
    //    }
    //public GoatSpearEntity(World world, double x, double y, double z, ItemStack stack) {
    //        super(EntityType.TRIDENT, x, y, z, world, stack, stack);
    //        this.dataTracker.set(ENCHANTED, stack.hasGlint());
    //    }

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
