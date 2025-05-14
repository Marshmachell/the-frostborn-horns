package net.marsh.frostbornhorns.renderer.GoatSpearEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.marsh.frostbornhorns.entity.GoatSpearEntity;
import net.marsh.frostbornhorns.model.GoatSpearEntityModel;
import net.marsh.frostbornhorns.renderer.GoatVillagerEntityRenderState;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import static net.marsh.frostbornhorns.FrostbornHorns.MOD_ID;
import static net.marsh.frostbornhorns.FrostbornHornsClient.*;

@Environment(EnvType.CLIENT)
public class GoatSpearEntityRenderer extends EntityRenderer<GoatSpearEntity, GoatSpearEntityRenderState> {
    public static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/goat_spear.png");
    private final GoatSpearEntityModel model;
    public GoatSpearEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new GoatSpearEntityModel(context.getPart(GOAT_SPEAR));
    }

    public void render(GoatSpearEntityRenderState goatSpearEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(goatSpearEntityRenderState.yaw - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(goatSpearEntityRenderState.pitch + 90.0f));
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(TEXTURE), false, goatSpearEntityRenderState.enchanted);
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(goatSpearEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    public GoatSpearEntityRenderState createRenderState() {
        return new GoatSpearEntityRenderState();
    }

    public void updateRenderState(GoatSpearEntity goatSpearEntity, GoatSpearEntityRenderState goatSpearEntityRenderState, float f) {
        super.updateRenderState(goatSpearEntity, goatSpearEntityRenderState, f);
        goatSpearEntityRenderState.yaw = goatSpearEntity.getLerpedYaw(f);
        goatSpearEntityRenderState.pitch = goatSpearEntity.getLerpedPitch(f);
        goatSpearEntityRenderState.enchanted = goatSpearEntity.isEnchanted();
    }
}
