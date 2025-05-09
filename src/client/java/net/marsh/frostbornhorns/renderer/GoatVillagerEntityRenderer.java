package net.marsh.frostbornhorns.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.marsh.frostbornhorns.TheFrostbornHornsClient;
import net.marsh.frostbornhorns.entity.GoatVillagerEntity;
import net.marsh.frostbornhorns.model.GoatVillagerEntityModel;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.TheFrostbornHorns.MOD_ID;

@SuppressWarnings("deprecation")
@Environment(EnvType.CLIENT)
public class GoatVillagerEntityRenderer extends AgeableMobEntityRenderer<GoatVillagerEntity, BipedEntityRenderState, GoatVillagerEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/goat_villager/goat_villager.png");

    public GoatVillagerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GoatVillagerEntityModel(context.getPart(TheFrostbornHornsClient.MODEL_GOAT_VILLAGER_LAYER)), new GoatVillagerEntityModel(context.getPart(TheFrostbornHornsClient.MODEL_GOAT_VILLAGER_BABY_LAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(BipedEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public BipedEntityRenderState createRenderState() {
        return new BipedEntityRenderState();
    }
}
