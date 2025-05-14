package net.marsh.frostbornhorns.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.marsh.frostbornhorns.FrostbornHorns.*;
import static net.marsh.frostbornhorns.item.FrostbornHornsItems.*;


public class FrostbornHornsItemGroups {
    public static final ItemGroup THE_FROSTBORN_HORNS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MOD_ID, "the_frostborn_horns_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.GOAT_HORN))
                    .displayName(Text.of("Frostborn Horns"))
                    .entries((displayContext, entries) -> {
                        entries.add(GOAT_SPEAR);
                        entries.add(GOAT_VILLAGER_SPAWN_EGG);
                    })
                    .build());

    public static void register() {}
}
