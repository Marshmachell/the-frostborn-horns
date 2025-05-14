package net.marsh.frostbornhorns.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.*;

public class FrostbornHornsSounds {
    public static final SoundEvent HORNED_LIAR_AMBIENT = registerSoundEvent("effect.horned_liar.ambient");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {}
}
