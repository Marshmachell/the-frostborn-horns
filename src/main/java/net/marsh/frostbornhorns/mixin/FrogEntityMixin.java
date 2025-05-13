package net.marsh.frostbornhorns.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FrogEntity.class)
public class FrogEntityMixin {
    @Inject(at = @At("HEAD"), method = "getHurtSound", cancellable = true)
    private void test(DamageSource source, CallbackInfoReturnable<SoundEvent> cir) {
        cir.setReturnValue(SoundEvents.ENTITY_WARDEN_HURT);
    }
}
