package net.marsh.frostbornhorns;

import net.fabricmc.api.ModInitializer;

import net.marsh.frostbornhorns.item.TheFrostbornHornsItemGroups;
import net.marsh.frostbornhorns.item.TheFrostbornHornsItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheFrostbornHorns implements ModInitializer {
	public static final String MOD_ID = "frostborn-horns";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TheFrostbornHornsItemGroups.register();
		TheFrostbornHornsEntities.register();
		TheFrostbornHornsItems.register();
	}
}