package net.marsh.frostbornhorns.renderer.GoatSpearEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.EntityRenderState;

@Environment(EnvType.CLIENT)
public class GoatSpearEntityRenderState extends EntityRenderState {
    public float pitch;
    public float yaw;
    public boolean enchanted;

    public GoatSpearEntityRenderState() {}
}
