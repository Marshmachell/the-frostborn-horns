package net.marsh.frostbornhorns;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.marsh.frostbornhorns.entity.GoatVillagerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

import static net.marsh.frostbornhorns.TheFrostbornHorns.MOD_ID;

public class TheFrostbornHornsEntities {
    public static final String GOAT_VILLAGER_ID = "goat_villager";
    public static final EntityType<GoatVillagerEntity> GOAT_VILLAGER = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(MOD_ID, GOAT_VILLAGER_ID),
            FabricEntityType.Builder.createMob(GoatVillagerEntity::new, SpawnGroup.MISC, builder -> builder.spawnRestriction(SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GoatVillagerEntity::canSpawn))
                    .eyeHeight(0.9F)
                    .maxTrackingRange(32)
                    .dimensions(0.85F, 1.75F)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, GOAT_VILLAGER_ID)))
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(GOAT_VILLAGER, GoatVillagerEntity.createGoatVillagerAttributes());
    }
}
