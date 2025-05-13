package net.marsh.frostbornhorns;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.marsh.frostbornhorns.model.GoatVillagerEntityModel;
import net.marsh.frostbornhorns.renderer.GoatVillagerEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.TheFrostbornHorns.MOD_ID;
import static net.marsh.frostbornhorns.TheFrostbornHornsEntities.GOAT_SPEAR_ID;
import static net.marsh.frostbornhorns.TheFrostbornHornsEntities.GOAT_VILLAGER_ID;

public class TheFrostbornHornsClient implements ClientModInitializer {
	public static final EntityModelLayer GOAT_VILLAGER = new EntityModelLayer(Identifier.of(MOD_ID, GOAT_VILLAGER_ID), "main");
	public static final EntityModelLayer GOAT_VILLAGER_BABY = new EntityModelLayer(Identifier.of(MOD_ID, createBabyId(GOAT_VILLAGER_ID)), "main");
	public static final EntityModelLayer GOAT_SPEAR = new EntityModelLayer(Identifier.of(MOD_ID, GOAT_SPEAR_ID), "main");

	public static String createBabyId(String parentId) {
		return parentId + "_baby";
	}
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(TheFrostbornHornsEntities.GOAT_VILLAGER, GoatVillagerEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(GOAT_VILLAGER, GoatVillagerEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(GOAT_VILLAGER_BABY, () -> GoatVillagerEntityModel.getTexturedModelData().transform(GoatVillagerEntityModel.BABY_TRANSFORMER));
	}
}