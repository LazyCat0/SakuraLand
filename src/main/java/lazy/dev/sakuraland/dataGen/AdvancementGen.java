package lazy.dev.sakuraland.dataGen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
//import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
//import net.minecraft.advancements.AdvancementType;
//import net.minecraft.advancements.criterion.PlayerTrigger;
import net.minecraft.core.HolderLookup;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

//import static lazy.dev.sakuraland.Sakuraland.MOD_ID;
//import static net.minecraft.world.item.Items.*;

public class AdvancementGen extends FabricAdvancementProvider {
    public AdvancementGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(@NotNull HolderLookup.Provider wrapperLookup, @NotNull Consumer<AdvancementHolder> consumer) {
//        AdvancementHolder begin = Advancement.Builder.advancement()
//                .display(
//                        COMMAND_BLOCK,
//                        Component.literal("Вам были выданы рецепты!"),
//                        Component.literal("Проверьте верстак"),
//                        Identifier.withDefaultNamespace("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
//                        AdvancementType.TASK,
//                        true,
//                        false,
//                        true
//                )
//                .addCriterion("begin", PlayerTrigger.TriggerInstance.tick())
//                .save(consumer, MOD_ID + ":begin");

    }
}
