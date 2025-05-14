package net.marsh.frostbornhorns.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.marsh.frostbornhorns.FrostbornHornsClient;
import net.marsh.frostbornhorns.entity.AbstractGoatVillagerEntity;
import net.marsh.frostbornhorns.entity.GoatVillagerEntity;
import net.marsh.frostbornhorns.feature.GoatVillagerFeatureRenderer;
import net.marsh.frostbornhorns.model.GoatVillagerEntityModel;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.MOD_ID;

@SuppressWarnings("deprecation")
@Environment(EnvType.CLIENT)
public class GoatVillagerEntityRenderer extends AgeableMobEntityRenderer<GoatVillagerEntity, GoatVillagerEntityRenderState, GoatVillagerEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/goat_villager/goat_villager.png");

    public GoatVillagerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GoatVillagerEntityModel(context.getPart(FrostbornHornsClient.GOAT_VILLAGER)), new GoatVillagerEntityModel(context.getPart(FrostbornHornsClient.GOAT_VILLAGER_BABY)), 0.6F);
        this.addFeature(new GoatVillagerFeatureRenderer(this));
    }
    @Override
    public Identifier getTexture(GoatVillagerEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public GoatVillagerEntityRenderState createRenderState() {
        return new GoatVillagerEntityRenderState();
    }
    public void updateRenderState(GoatVillagerEntity goatVillagerEntity, GoatVillagerEntityRenderState goatVillagerEntityRenderState, float f) {
        super.updateRenderState(goatVillagerEntity, goatVillagerEntityRenderState, f);
        goatVillagerEntityRenderState.hasLeftHorn = goatVillagerEntity.hasLeftHorn();
        goatVillagerEntityRenderState.hasRightHorn = goatVillagerEntity.hasRightHorn();
        goatVillagerEntityRenderState.headPitch = goatVillagerEntity.getHeadPitch();
        ArmedEntityRenderState.updateRenderState(goatVillagerEntity, goatVillagerEntityRenderState, this.itemModelResolver);
    }
}
