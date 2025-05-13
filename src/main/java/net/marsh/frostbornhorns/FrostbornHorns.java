package net.marsh.frostbornhorns;

import net.fabricmc.api.ModInitializer;

import net.marsh.frostbornhorns.effect.FrostbornHornsStatusEffects;
import net.marsh.frostbornhorns.item.FrostbornHornsItemGroups;
import net.marsh.frostbornhorns.item.FrostbornHornsItems;
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
	}
}