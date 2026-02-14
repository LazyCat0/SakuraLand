package lazy.dev.sakuraland;

import lazy.dev.sakuraland.Entities.ModEntities;
import lazy.dev.sakuraland.Entities.TestNpc;
import lazy.dev.sakuraland.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import static lazy.dev.sakuraland.Entities.ModEntities.TEST_NPC;

public class Sakuraland implements ModInitializer {
    public static String MOD_ID = "sakura_land";
    @Override
    public void onInitialize() {
        ModEntities.init();
        ModItems.init();
        FabricDefaultAttributeRegistry.register(TEST_NPC, TestNpc.createAttributes());
    }
}
