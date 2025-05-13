package net.marsh.frostbornhorns.renderer.GoatSpearEntity;

import net.marsh.frostbornhorns.TheFrostbornHornsClient;
import net.marsh.frostbornhorns.entity.GoatSpearEntity;
import net.marsh.frostbornhorns.model.GoatSpearEntityModel;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.TheFrostbornHorns.MOD_ID;

public class GoatSpearEntityRenderer extends EntityRenderer<GoatSpearEntity, GoatSpearEntityRenderState> {
    public static final Identifier TEXTURE = Identifier.of(MOD_ID, "textures/entity/goat_spear_model.png");
    private final GoatSpearEntityModel model;
    protected GoatSpearEntityRenderer(EntityRendererFactory.Context context, GoatSpearEntityModel model) {
        super(context);
        this.model = new GoatSpearEntityModel(context.getPart(TheFrostbornHornsClient.GOAT_SPEAR));
    }

    @Override
    public GoatSpearEntityRenderState createRenderState() {
        return null;
    }
}
