package lazy.dev.sakuraland;

import lazy.dev.sakuraland.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.world.item.ItemStack;

public class Sakuraland implements ModInitializer {
    public static String MOD_ID = "sakura_land";

    @Override
    public void onInitialize() {
        ModItems.init();
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            var player = handler.player;
            if (!player.getTags().contains("has_joined_before")) {

                player.getInventory().add(new ItemStack(ModItems.PILL_1, 3));
                player.addTag("has_joined_before");
            }
        });
    }
}
