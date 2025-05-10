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

public class GoatVillagerEntityModel extends EntityModel<GoatVillagerEntityRenderState> implements ModelWithArms {
	public static final ModelTransformer BABY_TRANSFORMER = new BabyModelTransformer(false, 10.0F, 2.0F, Set.of(EntityModelPartNames.HEAD));
	private final ModelPart left_ear;
	private final ModelPart right_ear;
	private final ModelPart head;
	private final ModelPart left_horn;
	private final ModelPart right_horn;
	private final ModelPart body;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	public GoatVillagerEntityModel(ModelPart root) {
        super(root);
        this.left_ear = root.getChild("head").getChild("left_ear");
		this.right_ear = root.getChild("head").getChild("right_ear");
		this.head = root.getChild("head");
		this.left_horn = root.getChild("head").getChild("left_horn");
		this.right_horn = root.getChild("head").getChild("right_horn");
		this.body = root.getChild("body");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();

		ModelPartData root = modelData.getRoot();

		ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(22, 47).cuboid(0.0F, 2.0F, -8.0F, 0.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 3.0F, -3.0F));
		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(2, 61).mirrored().cuboid(2.5F, -21.0F, -10.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.origin(0.0F, 16.0F, 7.0F));
		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(2, 61).cuboid(-5.5F, -21.0F, -10.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 16.0F, 7.0F));
		ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(34, 46).cuboid(-3.0F, -4.0F, -8.0F, 5.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -2.0F, -1.0F, 0.9599F, 0.0F, 0.0F));
		ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create().uv(12, 55).cuboid(0.49F, -9.0F, -3.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -1.0F, 0.0F));
		ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create().uv(12, 55).cuboid(-2.49F, -9.0F, -3.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -1.0F, 0.0F));
		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(1, 1).cuboid(-4.0F, -17.0F, -7.0F, 9.0F, 11.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 28).cuboid(-5.0F, -18.0F, -8.0F, 11.0F, 14.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 9.0F, -11.5F, -1.5708F, 0.0F, 0.0F));
		ModelPartData rightLeg = root.addChild("rightLeg", ModelPartBuilder.create().uv(49, 29).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(-2.0F, 18.0F, 0.0F));
		ModelPartData leftLeg = root.addChild("leftLeg", ModelPartBuilder.create().uv(36, 29).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(2.0F, 18.0F, 0.0F));
		ModelPartData rightArm = root.addChild("rightArm", ModelPartBuilder.create().uv(49, 2).cuboid(-2.0F, -2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(-4.5F, 5.0F, 0.0F));
		ModelPartData leftArm = root.addChild("leftArm", ModelPartBuilder.create().uv(35, 2).cuboid(-1.0F, -2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(4.5F, 5.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(GoatVillagerEntityRenderState goatVillagerEntityRenderState) {
		super.setAngles(goatVillagerEntityRenderState);

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
		/*
		h = goatVillagerEntityRenderState.age / 40.0F;
		ModelPart var10000 = this.head;
		var10000.originX += MathHelper.sin(h * 10.0F);
		var10000 = this.head;
		var10000.originY += MathHelper.sin(h * 40.0F) + 0.4F;
		this.rightArm.roll = 0.017453292F * (120.0F + MathHelper.cos(h * 40.0F) * 10.0F);
		this.leftArm.roll = this.rightArm.roll * -1.0F;
		var10000 = this.rightArm;
		var10000.originY += MathHelper.sin(h * 40.0F) * 0.5F - 0.5F;
		var10000 = this.leftArm;
		var10000.originY += MathHelper.sin(h * 40.0F) * 0.5F + 0.5F;
		var10000 = this.body;
		var10000.originY += MathHelper.sin(h * 40.0F) * 0.35F;
		*/
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {

	}
}