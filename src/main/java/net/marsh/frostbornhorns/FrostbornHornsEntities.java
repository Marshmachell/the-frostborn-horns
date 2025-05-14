package net.marsh.frostbornhorns;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.marsh.frostbornhorns.entity.GoatSpearEntity;
import net.marsh.frostbornhorns.entity.AbstractGoatVillagerEntity;
import net.marsh.frostbornhorns.entity.GoatVillagerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.MOD_ID;

public class FrostbornHornsEntities {
    public static final String GOAT_VILLAGER_ID = "goat_villager";
    public static final EntityType<GoatVillagerEntity> GOAT_VILLAGER = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(MOD_ID, GOAT_VILLAGER_ID),
            //FabricEntityType.Builder.createMob(GoatVillagerEntity::new, SpawnGroup.MISC, builder -> builder.spawnRestriction(SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GoatVillagerEntity::canSpawn))
            //        .eyeHeight(0.9F)
            //        .maxTrackingRange(32)
            //        .dimensions(0.85F, 1.75F)
            //        .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, GOAT_VILLAGER_ID)))
            EntityType.Builder.create(GoatVillagerEntity::new, SpawnGroup.MISC)
                    .eyeHeight(0.9f)
                    .maxTrackingRange(32)
                    .dimensions(0.9f, 1.75f)
                    .passengerAttachments(1.425F)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, GOAT_VILLAGER_ID))));

    public static final String GOAT_SPEAR_ID = "goat_spear";
    public static final EntityType<GoatSpearEntity> GOAT_SPEAR = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(MOD_ID, GOAT_SPEAR_ID),
            EntityType.Builder.<GoatSpearEntity>create(GoatSpearEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, GOAT_SPEAR_ID)))
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(GOAT_VILLAGER, GoatVillagerEntity.createGoatVillagerAttributes());
    }
}
