package lazy.dev.sakuraland.client.EntitiesRenders;

import lazy.dev.sakuraland.Entities.TestNpc;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

import java.util.Map;

import static lazy.dev.sakuraland.Sakuraland.MOD_ID;

public class TestNpcModel extends GeoModel<TestNpc> implements GeoRenderState {
    @Override
    public @NonNull Identifier getModelResource(@NonNull GeoRenderState geoRenderState) {
        return Identifier.fromNamespaceAndPath(MOD_ID, "npc/npc_base");
    }

    @Override
    public @NonNull Identifier getTextureResource(@NonNull GeoRenderState geoRenderState) {
        return Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/steve.png");
    }

    @Override
    public @NonNull Identifier getAnimationResource(TestNpc testNPC) {
        return Identifier.fromNamespaceAndPath(MOD_ID, "npc/npc_base");
    }

    @Override
    public @NonNull Map<DataTicket<?>, Object> getDataMap() {
        return Map.of();
    }

}
