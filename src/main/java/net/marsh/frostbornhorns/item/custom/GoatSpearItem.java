package net.marsh.frostbornhorns.item.custom;

import net.marsh.frostbornhorns.FrostbornHornsEntities;
import net.marsh.frostbornhorns.entity.GoatSpearEntity;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.*;
import net.minecraft.item.consume.UseAction;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

import java.util.List;

public class GoatSpearItem extends Item implements ProjectileItem {
    public GoatSpearItem(Item.Settings settings) {
        super(settings);
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder().add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 7.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.9000000953674316, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2, false);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int var6 = this.getMaxUseTime(stack, user) - remainingUseTicks;
            if (var6 < 10) {
                return false;
            } else {
                playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                if (world instanceof ServerWorld serverWorld) {
                    stack.damage(1, playerEntity);
                    ItemStack itemStack = stack.splitUnlessCreative(1, playerEntity);
                    GoatSpearEntity goatSpearEntity = (GoatSpearEntity) ProjectileEntity.spawnWithVelocity(GoatSpearEntity::new, serverWorld, itemStack, playerEntity, 0.0F, 1.5F, 1.0F);
                    if (playerEntity.isInCreativeMode()) {
                        goatSpearEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                    }
                    world.playSoundFromEntity(null, playerEntity, SoundEvents.ITEM_TRIDENT_THROW.value(), SoundCategory.PLAYERS, 1.0F, 0.776F);
                }
            }
        }
        return true;
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (itemStack.willBreakNextUse()) {
            return ActionResult.FAIL;
        } else {
            user.setCurrentHand(hand);
            return ActionResult.CONSUME;
        }
    }

    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        GoatSpearEntity goatSpearEntity = FrostbornHornsEntities.GOAT_SPEAR.create(world, SpawnReason.SPAWN_ITEM_USE);
        goatSpearEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        world.spawnEntity(goatSpearEntity);
        goatSpearEntity.refreshPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), goatSpearEntity.getYaw(), goatSpearEntity.getPitch());
        return goatSpearEntity;
    }
}
