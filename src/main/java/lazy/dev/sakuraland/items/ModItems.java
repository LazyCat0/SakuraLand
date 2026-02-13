package lazy.dev.sakuraland.items;

import lazy.dev.sakuraland.items.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

import static lazy.dev.sakuraland.Sakuraland.MOD_ID;

public class ModItems {
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
        GenericItem item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static Item PILL_1 = register("pill_1", Pill_1::new, new Item.Properties().stacksTo(16));
    public static Item PILL_2 = register("pill_2", Pill_2::new, new Item.Properties().stacksTo(16));
    public static Item PILL_3 = register("pill_3", Pill_3::new, new Item.Properties().stacksTo(16));
    public static Item MEDKIT = register("medkit", Medkit::new, new Item.Properties().stacksTo(1));
    public static void init() {}
}
