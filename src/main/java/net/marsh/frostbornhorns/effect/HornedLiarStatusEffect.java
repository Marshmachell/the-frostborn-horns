package net.marsh.frostbornhorns.effect;

import net.marsh.frostbornhorns.sound.FrostbornHornsSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;

public class HornedLiarStatusEffect extends StatusEffect {
    protected HornedLiarStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
            if (!entity.isSpectator()) {
                if (Math.random() < 0.5) {
                    world.playSound(serverPlayerEntity,
                            serverPlayerEntity.getX(),
                            serverPlayerEntity.getY(),
                            serverPlayerEntity.getZ(),
                            FrostbornHornsSounds.HORNED_LIAR_AMBIENT,
                            SoundCategory.AMBIENT,
                            0.776f,
                            1.0f);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration, amplifier);
    }
}
