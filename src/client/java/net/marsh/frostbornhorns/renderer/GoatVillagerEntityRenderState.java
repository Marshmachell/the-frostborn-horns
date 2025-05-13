package net.marsh.frostbornhorns.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.ItemHolderEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemDisplayContext;

@Environment(EnvType.CLIENT)
public class GoatVillagerEntityRenderState extends BipedEntityRenderState {
    public float limbAmplitudeInverse = 1.0F;
    public boolean hasLeftHorn = true;
    public boolean hasRightHorn = true;
    public float headPitch;

    public GoatVillagerEntityRenderState() {}
}
