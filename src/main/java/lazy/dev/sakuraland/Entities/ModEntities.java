package lazy.dev.sakuraland.Entities;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import static lazy.dev.sakuraland.Sakuraland.MOD_ID;

public class ModEntities {
    public static final ResourceKey<EntityType<?>> TEST_NPC_KEY =
            ResourceKey.create(
                    Registries.ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(MOD_ID, "test_npc")
            );
    public static final EntityType<TestNpc> TEST_NPC = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MOD_ID, "test_npc"),
            EntityType.Builder.of(TestNpc::new, MobCategory.CREATURE).sized(0.75f, 2f).build(TEST_NPC_KEY)
    );

    public static void init() {}
}
