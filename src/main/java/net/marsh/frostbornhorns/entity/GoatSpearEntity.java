package net.marsh.frostbornhorns.entity;

import net.marsh.frostbornhorns.FrostbornHornsEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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
    public GoatSpearEntity(EntityType<? extends GoatSpearEntity> entityType, World world) {
        super(entityType, world);
    }

    //public GoatSpearEntity(World world, PlayerEntity player) {
    //    super(FrostbornHornsEntities.GOAT_SPEAR, world);
    //}

    public GoatSpearEntity(World world, LivingEntity owner, ItemStack stack) {
        super(FrostbornHornsEntities.GOAT_SPEAR, owner, world, stack, (ItemStack)null);
        this.dataTracker.set(ENCHANTED, stack.hasGlint());
    }

    public GoatSpearEntity(World world, double x, double y, double z, ItemStack stack) {
        super(FrostbornHornsEntities.GOAT_SPEAR, x, y, z, world, stack, stack);
        this.dataTracker.set(ENCHANTED, stack.hasGlint());
    }

    public ItemStack getWeaponStack() {
        return this.getItemStack();
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(GOAT_SPEAR);
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ENCHANTED, false);
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

    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }

    protected float getDragInWater() {
        return 0.99F;
    }

    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    static {
        ENCHANTED = DataTracker.registerData(GoatSpearEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
