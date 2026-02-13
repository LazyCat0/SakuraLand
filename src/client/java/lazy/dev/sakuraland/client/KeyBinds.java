package lazy.dev.sakuraland.client;

import com.mojang.blaze3d.platform.InputConstants;
import lazy.dev.sakuraland.Sakuraland;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {
    public static void init() {

        KeyMapping.Category CATEGORY = new KeyMapping.Category(
                Identifier.fromNamespaceAndPath(Sakuraland.MOD_ID, "sakura_land")
        );
        /*
        KeyMapping openQuestsScreen = KeyBindingHelper.registerKeyBinding(
                new KeyMapping(
                        "key.sakura_land.quests.open_screen",
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_G,
                        CATEGORY
                ));
        */
    }
}
