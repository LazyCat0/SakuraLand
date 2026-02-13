package lazy.dev.sakuraland.mixins;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class CancelRegenMixin {
    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z",
            at = @At("HEAD"),
            cancellable = true)
    private void onAddEffect(MobEffectInstance effectInstance, Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (effectInstance.getEffect() == MobEffects.REGENERATION) {
            cir.setReturnValue(false);
        }
        if (effectInstance.getEffect() == MobEffects.INSTANT_HEALTH) {
            cir.setReturnValue(false);
        }
        if (effectInstance.getEffect() == MobEffects.HEALTH_BOOST) {
            cir.setReturnValue(false);
        }
        if (effectInstance.getEffect() == MobEffects.ABSORPTION) {
            cir.setReturnValue(false);
        }
    }
}
