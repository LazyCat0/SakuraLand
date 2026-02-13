package lazy.dev.sakuraland.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

import static lazy.dev.sakuraland.Sakuraland.MOD_ID;

public class Pill_1 extends Item {
    public Pill_1(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, Player user, @NotNull InteractionHand hand) {
        user.startUsingItem(hand);
        return InteractionResult.CONSUME;
    }
    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 10;
    }
    @Override
    public @NotNull ItemUseAnimation getUseAnimation(@NotNull ItemStack stack) {
        return ItemUseAnimation.EAT;
    }
    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            stack.shrink(1);
            player.getCooldowns().addCooldown(Identifier.fromNamespaceAndPath(MOD_ID, "pill_1"), 25);
            player.heal(4);
            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP);
        }
        return stack;
    }
    @Override
    public void appendHoverText(@NonNull ItemStack stack, @NonNull TooltipContext context, @NonNull TooltipDisplay displayComponent, Consumer<Component> textConsumer, @NonNull TooltipFlag type) {
        textConsumer.accept(Component.translatable("itemTooltip.sakura_land.pill_1.lvl").withStyle(ChatFormatting.GOLD));
        textConsumer.accept(Component.translatable("itemTooltip.sakura_land.pill_1.heals").withStyle(ChatFormatting.GREEN));
        textConsumer.accept(Component.translatable("itemTooltip.sakura_land.pill.shine").withStyle(ChatFormatting.RED));
    }

}
