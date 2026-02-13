package lazy.dev.sakuraland;

import lazy.dev.sakuraland.items.ModItems;
import net.fabricmc.api.ModInitializer;

public class Sakuraland implements ModInitializer {
    public static String MOD_ID = "sakura_land";

    @Override
    public void onInitialize() {
        ModItems.init();
    }
}
