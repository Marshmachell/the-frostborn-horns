package net.marsh.frostbornhorns;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.marsh.frostbornhorns.effect.FrostbornHornsStatusEffects;
import net.marsh.frostbornhorns.gamerule.FrostbornHornsGamerules;
import net.marsh.frostbornhorns.item.FrostbornHornsItemGroups;
import net.marsh.frostbornhorns.item.FrostbornHornsItems;
import net.marsh.frostbornhorns.sound.FrostbornHornsSounds;
import net.marsh.frostbornhorns.tick.FrostbornHornsFreezing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrostbornHorns implements ModInitializer {
	public static final String MOD_ID = "frostborn-horns";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FrostbornHornsItemGroups.register();
		FrostbornHornsEntities.register();
		FrostbornHornsItems.register();
		FrostbornHornsStatusEffects.register();
		FrostbornHornsSounds.register();
		FrostbornHornsGamerules.register();

		ServerTickEvents.END_SERVER_TICK.register(FrostbornHornsFreezing::tick);
	}
}