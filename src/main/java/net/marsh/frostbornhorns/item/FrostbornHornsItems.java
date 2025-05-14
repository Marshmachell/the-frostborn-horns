package net.marsh.frostbornhorns.item;

import net.marsh.frostbornhorns.FrostbornHornsEntities;
import net.marsh.frostbornhorns.item.custom.GoatSpearItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.WeaponComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.*;

public class FrostbornHornsItems {
    public static final Item GOAT_SPEAR = registerItem("goat_spear", new GoatSpearItem(new Item.Settings()
            .maxCount(1)
            .attributeModifiers(GoatSpearItem.createAttributeModifiers())
            .component(DataComponentTypes.TOOL, GoatSpearItem.createToolComponent())
            .enchantable(1)
            .component(DataComponentTypes.WEAPON, new WeaponComponent(1))
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "goat_spear")))));
    public static final Item GOAT_VILLAGER_SPAWN_EGG = registerItem("goat_villager_spawn_egg",
            new SpawnEggItem(FrostbornHornsEntities.GOAT_VILLAGER, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "goat_villager_spawn_egg")))));
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void register() {}
}
