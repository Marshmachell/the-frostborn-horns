package net.marsh.frostbornhorns.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.*;

@Environment(EnvType.CLIENT)
public class GoatSpearEntityModel extends Model {
    public static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/goat_spear.png");
    public GoatSpearEntityModel(ModelPart root) {
        super(root, RenderLayer::getEntitySolid);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData pole = modelPartData.addChild("pole", ModelPartBuilder.create(), ModelTransform.NONE);
        ModelPartData base = pole.addChild("base", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -0.5F, -10.0F, 1.0F, 1.0F, 26.0F, new Dilation(0.0F)), ModelTransform.NONE);
        ModelPartData vertical_spike = pole.addChild("vertical_spike", ModelPartBuilder.create(), ModelTransform.NONE);
        ModelPartData vertical_spike_r1 = vertical_spike.addChild("vertical_spike_r1", ModelPartBuilder.create().uv(24, 27).cuboid(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.75F, 0.7854F, 0.0F, 0.0F));
        ModelPartData horizontal_spike = pole.addChild("horizontal_spike", ModelPartBuilder.create(), ModelTransform.NONE);
        ModelPartData horizontal_spike_r1 = horizontal_spike.addChild("horizontal_spike_r1", ModelPartBuilder.create().uv(0, 27).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -12.75F, 0.0F, -0.7854F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
}
