package net.hollowed.volatility.common;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.network.DashMessage;
import net.hollowed.volatility.common.network.DoubleJumpMessage;
import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ModKeymaps {
    public static final KeyMapping DASH_KEY = new KeyMapping("key.e.dash_key", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.movement") {
        private boolean isDownOld = false;

        @Override
        public void setDown(boolean isDown) {
            super.setDown(isDown);
            if (isDownOld != isDown && isDown) {
                DASH_KEY_LASTPRESS = System.currentTimeMillis();
            } else if (isDownOld != isDown && !isDown) {
                int dt = (int) (System.currentTimeMillis() - DASH_KEY_LASTPRESS);
                Volatility.PACKET_HANDLER.sendToServer(new DashMessage(1, dt));
                DashMessage.pressAction(Minecraft.getInstance().player, 1, dt);
            }
            isDownOld = isDown;
        }
    };
    public static final KeyMapping DOUBLE_JUMP_KEY = new KeyMapping("key.e.double_jump_key", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
        private boolean isDownOld = false;

        @Override
        public void setDown(boolean isDown) {
            super.setDown(isDown);
            if (isDownOld != isDown && isDown) {
                Volatility.PACKET_HANDLER.sendToServer(new DoubleJumpMessage(0, 0));
                DoubleJumpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
            }
            isDownOld = isDown;
        }
    };
    private static long DASH_KEY_LASTPRESS = 0;

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(DASH_KEY);
        event.register(DOUBLE_JUMP_KEY);
    }

    @Mod.EventBusSubscriber({Dist.CLIENT})
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (Minecraft.getInstance().screen == null) {
                DASH_KEY.consumeClick();
                DOUBLE_JUMP_KEY.consumeClick();
            }
        }
    }
}
