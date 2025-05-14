package net.marsh.frostbornhorns.feature;

import net.marsh.frostbornhorns.model.GoatVillagerBaseEntityModel;
import net.marsh.frostbornhorns.model.GoatVillagerEntityModel;
import net.marsh.frostbornhorns.renderer.GoatVillagerEntityRenderState;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.RotationAxis;

public class GoatVillagerFeatureRenderer extends HeldItemFeatureRenderer<GoatVillagerEntityRenderState, GoatVillagerEntityModel> {
    public GoatVillagerFeatureRenderer(FeatureRendererContext<GoatVillagerEntityRenderState, GoatVillagerEntityModel> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, GoatVillagerEntityRenderState armedEntityRenderState, float f, float g) {
        this.renderItem(armedEntityRenderState, armedEntityRenderState.rightHandItemState, Arm.RIGHT, matrixStack, vertexConsumerProvider, i);
        this.renderItem(armedEntityRenderState, armedEntityRenderState.leftHandItemState, Arm.LEFT, matrixStack, vertexConsumerProvider, i);
    }
    protected void renderItem(GoatVillagerEntityRenderState entityState, ItemRenderState itemState, Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (!itemState.isEmpty()) {
            matrices.push();
            ((ModelWithArms)this.getContextModel()).setArmAngle(arm, matrices);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
            boolean bl = arm == Arm.LEFT;
            matrices.translate((float)(bl ? -1 : 1) / 16.0F, 0.125F, -0.625F);
            itemState.render(matrices, vertexConsumers, light, OverlayTexture.DEFAULT_UV);
            matrices.pop();
        }
    }
}
