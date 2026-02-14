package lazy.dev.sakuraland.Entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TestNpc extends PathfinderMob implements GeoEntity {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public TestNpc(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.lookControl = new LookControl(this);
    }

    @Override
    public void registerControllers(AnimatableManager.@NonNull ControllerRegistrar controller) {
        controller.add(
                new AnimationController<>("main", 8 ,state -> {
                    double velocity = this.getDeltaMovement().horizontalDistance();
                    if (state.isMoving()) {
                        if (velocity < 0.1) {
                            return state.setAndContinue(RawAnimation.begin().thenLoop("walk"));
                        }
                        if (velocity < 0.3) {
                            return state.setAndContinue(RawAnimation.begin().thenLoop("running"));
                        }
                    }
                    return state.setAndContinue(RawAnimation.begin().thenLoop("idle"));
                })
        );
    }

    @Override
    public @NonNull AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(3,
                new TemptGoal(
                        this,
                        0.3,
                        Ingredient.of(Items.DIAMOND),
                        false
                )
        );
        this.goalSelector.addGoal(2,
                new LookAtPlayerGoal(this, Player.class, 8.0F)
        );
        this.goalSelector.addGoal(2,
                new TemptGoal(
                        this,
                        0.6,
                        Ingredient.of(Items.EMERALD),
                        false
                ));
        this.goalSelector.addGoal(2,
                new RandomLookAroundGoal(this));
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0)
                .add(Attributes.FOLLOW_RANGE, 16.0)
                .add(Attributes.TEMPT_RANGE, 10.0);
    }
}
