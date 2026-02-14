package lazy.dev.sakuraland.client;
import lazy.dev.sakuraland.Entities.ModEntities;
import lazy.dev.sakuraland.client.EntitiesRenders.TestNpcRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class SakuralandClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBinds.init();
        EntityRendererRegistry.register(ModEntities.TEST_NPC, TestNpcRenderer::new);
    }
}
