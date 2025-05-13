package net.marsh.frostbornhorns.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.*;

public class FrostbornHornsStatusEffects {
    public static final RegistryEntry<StatusEffect> HORNED_LIAR = registerStatusEffect("horned_liar",
            new HornedLiarEffect(StatusEffectCategory.NEUTRAL, 15912297));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, name), statusEffect);
    }

    public static void register() {}
}
