package net.marsh.frostbornhorns.feature;

import net.marsh.frostbornhorns.model.GoatVillagerEntityModel;
import net.marsh.frostbornhorns.renderer.GoatVillagerEntityRenderState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;

public class GoatVillagerFeatureRenderer extends HeldItemFeatureRenderer<GoatVillagerEntityRenderState, GoatVillagerEntityModel> {
    public GoatVillagerFeatureRenderer(FeatureRendererContext<GoatVillagerEntityRenderState, GoatVillagerEntityModel> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, GoatVillagerEntityRenderState armedEntityRenderState, float f, float g) {
        super.render(matrixStack, vertexConsumerProvider, i, armedEntityRenderState, f, g);
    }
}
