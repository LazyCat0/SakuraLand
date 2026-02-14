package lazy.dev.sakuraland.client.EntitiesRenders;

import com.mojang.blaze3d.vertex.PoseStack;
import lazy.dev.sakuraland.Entities.TestNpc;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.jspecify.annotations.NonNull;
import software.bernie.geckolib.cache.model.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class TestNpcRenderer<R extends LivingEntityRenderState & GeoRenderState>
        extends GeoEntityRenderer<TestNpc, @NonNull R> {
    public TestNpcRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new TestNpcModel());
        this.shadowRadius = 0.5f;
    }
}
