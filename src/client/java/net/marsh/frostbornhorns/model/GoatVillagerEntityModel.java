package net.marsh.frostbornhorns.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.marsh.frostbornhorns.renderer.GoatVillagerEntityRenderState;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class GoatVillagerEntityModel extends GoatVillagerBaseEntityModel<GoatVillagerEntityRenderState>{
    public GoatVillagerEntityModel(ModelPart root) {
        super(root);
    }

    @Override
    public void setAngles(GoatVillagerEntityRenderState goatVillagerEntityRenderState) {
        this.head.pitch = goatVillagerEntityRenderState.pitch * (float) (Math.PI / 180.0);
        this.head.yaw = goatVillagerEntityRenderState.relativeHeadYaw * (float) (Math.PI / 180.0);

        this.head.getChild("left_horn").visible = goatVillagerEntityRenderState.hasLeftHorn;
        this.head.getChild("right_horn").visible = goatVillagerEntityRenderState.hasRightHorn;

        float g = goatVillagerEntityRenderState.limbSwingAnimationProgress;
        float h = goatVillagerEntityRenderState.limbSwingAmplitude;
        this.rightArm.pitch = MathHelper.cos(g * 0.6662F + 3.1415927F) * 2.0F * h * 0.5F / goatVillagerEntityRenderState.limbAmplitudeInverse;
        this.leftArm.pitch = MathHelper.cos(g * 0.6662F) * 2.0F * h * 0.5F / goatVillagerEntityRenderState.limbAmplitudeInverse;
        this.rightLeg.pitch = MathHelper.cos(g * 0.6662F) * 1.4F * h / goatVillagerEntityRenderState.limbAmplitudeInverse;
        this.leftLeg.pitch = MathHelper.cos(g * 0.6662F + 3.1415927F) * 1.4F * h / goatVillagerEntityRenderState.limbAmplitudeInverse;
        this.rightLeg.yaw = 0.005F;
        this.leftLeg.yaw = -0.005F;
        this.rightLeg.roll = 0.005F;
        this.leftLeg.roll = -0.005F;
    }
}
