package net.marsh.frostbornhorns.effect;

import net.marsh.frostbornhorns.sound.FrostbornHornsSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;

import java.util.Random;

import static net.marsh.frostbornhorns.sound.FrostbornHornsSounds.HORNED_LIAR_AMBIENT;

public class HornedLiarStatusEffect extends StatusEffect {
    private static final Random random = new Random();

    protected HornedLiarStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity playerEntity) {
            if (!entity.isSpectator()) {
                if (Math.random() < 0.000776) {
                    Position pos = playerEntity.getPos();
                    float x = (random.nextFloat(5) + 5.0f) * (random.nextBoolean() ? -1 : 1);
                    float y = random.nextFloat(10) - 5;
                    float z = (random.nextFloat(5) + 5.0f) * (random.nextBoolean() ? -1 : 1);

                    playerEntity.networkHandler.sendPacket(new PlaySoundS2CPacket(Registries.SOUND_EVENT.getEntry(HORNED_LIAR_AMBIENT),
                            SoundCategory.AMBIENT,
                            pos.getX() + x, pos.getY() + 1 + y, pos.getZ() + z,
                            1.0f, 0.776f,
                            playerEntity.getRandom().nextLong()));
                    playerEntity.sendMessage(Text.of(x + " " + y + " " + z), false);
                }
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
