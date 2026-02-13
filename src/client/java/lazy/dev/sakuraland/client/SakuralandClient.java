package lazy.dev.sakuraland.client;
import net.fabricmc.api.ClientModInitializer;

import static lazy.dev.sakuraland.Sakuraland.MOD_ID;

public class SakuralandClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBinds.init();
    }
}
