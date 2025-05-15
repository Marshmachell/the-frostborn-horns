package net.marsh.frostbornhorns.gamerule;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class FrostbornHornsGamerules {
    public static final GameRules.Key<GameRules.BooleanRule> FROSTBORN_HORNS_FREEZING = registerGamerule("frostbornHornsFreezing", GameRules.Category.PLAYER, true);

    public static GameRules.Key<GameRules.BooleanRule> registerGamerule(String name, GameRules.Category category, boolean bl) {
        return GameRuleRegistry.register(name, category, GameRuleFactory.createBooleanRule(bl));
    }

    public static void register() {}
}
