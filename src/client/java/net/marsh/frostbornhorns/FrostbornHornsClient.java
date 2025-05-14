package net.marsh.frostbornhorns;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.marsh.frostbornhorns.model.GoatSpearEntityModel;
import net.marsh.frostbornhorns.model.GoatVillagerBaseEntityModel;
import net.marsh.frostbornhorns.renderer.GoatSpearEntity.GoatSpearEntityRenderer;
import net.marsh.frostbornhorns.renderer.GoatVillagerEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.MOD_ID;
import static net.marsh.frostbornhorns.FrostbornHornsEntities.GOAT_SPEAR_ID;
import static net.marsh.frostbornhorns.FrostbornHornsEntities.GOAT_VILLAGER_ID;

public class FrostbornHornsClient implements ClientModInitializer {
	public static final EntityModelLayer GOAT_VILLAGER = new EntityModelLayer(Identifier.of(MOD_ID, GOAT_VILLAGER_ID), "main");
	public static final EntityModelLayer GOAT_VILLAGER_BABY = new EntityModelLayer(Identifier.of(MOD_ID, createBabyId(GOAT_VILLAGER_ID)), "main");
	public static final EntityModelLayer GOAT_SPEAR = new EntityModelLayer(Identifier.of(MOD_ID, GOAT_SPEAR_ID), "main");

	public static String createBabyId(String parentId) {
		return parentId + "_baby";
	}
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(FrostbornHornsEntities.GOAT_VILLAGER, GoatVillagerEntityRenderer::new);
		EntityRendererRegistry.register(FrostbornHornsEntities.GOAT_SPEAR, GoatSpearEntityRenderer::new);
		//EntityRendererRegistry.register(TheFrostbornHornsEntities.GOAT_SPEAR, GoatSpearEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(GOAT_SPEAR, GoatSpearEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(GOAT_VILLAGER, GoatVillagerBaseEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(GOAT_VILLAGER_BABY, () -> GoatVillagerBaseEntityModel.getTexturedModelData().transform(GoatVillagerBaseEntityModel.BABY_TRANSFORMER));
	}
}