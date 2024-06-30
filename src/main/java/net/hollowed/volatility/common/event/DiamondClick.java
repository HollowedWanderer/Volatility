package net.hollowed.volatility.common.event;

import net.hollowed.volatility.common.client.shader.GlowPostProcessor;
import net.hollowed.volatility.common.client.shader.LightingFx;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.joml.Vector3f;

import static net.hollowed.volatility.Volatility.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class DiamondClick {
    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        if (player.getMainHandItem().getItem() == Items.DIAMOND) {
            float X = (float) player.getX();
            float Y = (float) player.getY();
            float Z = (float) player.getZ();
            GlowPostProcessor.INSTANCE.addFxInstance(new LightingFx(new Vector3f(X, Y, Z), new Vector3f(1, 0, 1)));
        }
    }
}

