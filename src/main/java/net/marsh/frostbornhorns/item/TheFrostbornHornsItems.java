package net.marsh.frostbornhorns.item;

import net.marsh.frostbornhorns.item.custom.GoatSpearItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.TheFrostbornHorns.*;

public class TheFrostbornHornsItems {
    public static final Item GOAT_SPEAR = registerItem("goat_spear", new GoatSpearItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "goat_spear")))));
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void register() {}
}
