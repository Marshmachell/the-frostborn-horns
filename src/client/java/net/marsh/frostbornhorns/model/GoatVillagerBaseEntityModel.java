// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.marsh.frostbornhorns.model;

import net.marsh.frostbornhorns.renderer.GoatVillagerEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

import java.util.Set;

public class GoatVillagerBaseEntityModel<S extends GoatVillagerEntityRenderState> extends EntityModel<S> implements ModelWithArms {
	public static final ModelTransformer BABY_TRANSFORMER = new BabyModelTransformer(false, 10.0F, 2.0F, Set.of(EntityModelPartNames.HEAD));
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart head;
	public final ModelPart leftHorn;
	public final ModelPart rightHorn;
	public final ModelPart body;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public GoatVillagerBaseEntityModel(ModelPart root) {
        super(root);
        this.leftEar = root.getChild("head").getChild("left_ear");
		this.rightEar = root.getChild("head").getChild("right_ear");
		this.head = root.getChild("head");
		this.leftHorn = root.getChild("head").getChild("left_horn");
		this.rightHorn = root.getChild("head").getChild("right_horn");
		this.body = root.getChild("body");
		this.rightLeg = root.getChild("right_leg");
		this.leftLeg = root.getChild("left_leg");
		this.rightArm = root.getChild("right_arm");
		this.leftArm = root.getChild("left_arm");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();

		ModelPartData root = modelData.getRoot();

		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(23, 52).cuboid(0.0F, 3.0F, -7.0F, 0.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 3.0F, -4.0F));
		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(36, 54).mirrored().cuboid(2.5F, -21.0F, -10.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.origin(0.0F, 16.0F, 7.0F));
		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(36, 54).cuboid(-5.5F, -21.0F, -10.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 16.0F, 7.0F));
		ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(34, 47).cuboid(-3.0F, -4.0F, -8.0F, 5.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -2.0F, -1.0F, 0.9599F, 0.0F, 0.0F));
		ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create().uv(56, 48).cuboid(0.49F, -9.0F, -3.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -1.0F, 0.0F));
		ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create().uv(56, 48).cuboid(-2.49F, -9.0F, -3.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -1.0F, 0.0F));
		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 53).cuboid(-4.0F, -17.0F, 9.0F, 9.0F, 11.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -17.0F, -7.0F, 9.0F, 11.0F, 18.0F, new Dilation(0.0F))
				.uv(0, 29).cuboid(-5.0F, -18.0F, -8.0F, 11.0F, 13.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 9.0F, -11.5F, -1.5708F, 0.0F, 0.0F));
		ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(0, 9).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(-2.0F, 18.0F, 0.0F));
		ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(2.0F, 18.0F, 0.0F));
		ModelPartData right_arm = root.addChild("right_arm", ModelPartBuilder.create().uv(52, 0).cuboid(-2.0F, -2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(-5.5F, 5.0F, 0.0F));
		ModelPartData left_arm = root.addChild("left_arm", ModelPartBuilder.create().uv(40, 0).cuboid(-1.0F, -2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(5.5F, 5.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	public void setAngles(S goatVillagerEntityRenderState) {
		super.setAngles(goatVillagerEntityRenderState);

		float g = goatVillagerEntityRenderState.limbSwingAnimationProgress;
		float f = goatVillagerEntityRenderState.leaningPitch;

		//if (f > 0.0F) {
		//	float i = g % 26.0F;
		//	Arm arm = goatVillagerEntityRenderState.preferredArm;
		//	float j = arm == Arm.RIGHT && goatVillagerEntityRenderState.handSwingProgress > 0.0F ? 0.0F : f;
		//	float k = arm == Arm.LEFT && goatVillagerEntityRenderState.handSwingProgress > 0.0F ? 0.0F : f;
		//	float l;
		//	if (!goatVillagerEntityRenderState.isUsingItem) {
		//		if (i < 14.0F) {
		//			this.leftArm.pitch = MathHelper.lerpAngleRadians(k, this.leftArm.pitch, 0.0F);
		//			this.rightArm.pitch = MathHelper.lerp(j, this.rightArm.pitch, 0.0F);
		//			this.leftArm.yaw = MathHelper.lerpAngleRadians(k, this.leftArm.yaw, 3.1415927F);
		//			this.rightArm.yaw = MathHelper.lerp(j, this.rightArm.yaw, 3.1415927F);
		//			this.leftArm.roll = MathHelper.lerpAngleRadians(k, this.leftArm.roll, 3.1415927F + 1.8707964F * this.method_2807(i) / this.method_2807(14.0F));
		//			this.rightArm.roll = MathHelper.lerp(j, this.rightArm.roll, 3.1415927F - 1.8707964F * this.method_2807(i) / this.method_2807(14.0F));
		//		} else if (i >= 14.0F && i < 22.0F) {
		//			l = (i - 14.0F) / 8.0F;
		//			this.leftArm.pitch = MathHelper.lerpAngleRadians(k, this.leftArm.pitch, 1.5707964F * l);
		//			this.rightArm.pitch = MathHelper.lerp(j, this.rightArm.pitch, 1.5707964F * l);
		//			this.leftArm.yaw = MathHelper.lerpAngleRadians(k, this.leftArm.yaw, 3.1415927F);
		//			this.rightArm.yaw = MathHelper.lerp(j, this.rightArm.yaw, 3.1415927F);
		//			this.leftArm.roll = MathHelper.lerpAngleRadians(k, this.leftArm.roll, 5.012389F - 1.8707964F * l);
		//			this.rightArm.roll = MathHelper.lerp(j, this.rightArm.roll, 1.2707963F + 1.8707964F * l);
		//		} else if (i >= 22.0F && i < 26.0F) {
		//			l = (i - 22.0F) / 4.0F;
		//			this.leftArm.pitch = MathHelper.lerpAngleRadians(k, this.leftArm.pitch, 1.5707964F - 1.5707964F * l);
		//			this.rightArm.pitch = MathHelper.lerp(j, this.rightArm.pitch, 1.5707964F - 1.5707964F * l);
		//			this.leftArm.yaw = MathHelper.lerpAngleRadians(k, this.leftArm.yaw, 3.1415927F);
		//			this.rightArm.yaw = MathHelper.lerp(j, this.rightArm.yaw, 3.1415927F);
		//			this.leftArm.roll = MathHelper.lerpAngleRadians(k, this.leftArm.roll, 3.1415927F);
		//			this.rightArm.roll = MathHelper.lerp(j, this.rightArm.roll, 3.1415927F);
		//		}
		//	}
		//}
	}

	private float method_2807(float f) {
		return -65.0F * f + f * f;
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {
		boolean bl = arm == Arm.RIGHT;
		ModelPart modelPart = bl ? this.rightArm : this.leftArm;
		float f = 0.5F * (float)(bl ? 1 : -1);
		//modelPart.originX += f;
		modelPart.applyTransform(matrices);
		this.translateForHand(matrices, bl);
	}

	private void translateForHand(MatrixStack matrices, boolean mainHand) {
		float x = 0.05f;
		float y = -0.005f;
		float z = 0.0f;
		if (mainHand) {
			matrices.translate(x, y, z);
		} else {
			matrices.translate(x * -1, y, z);
		}

	}
}