package net.hollowed.volatility.common.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import team.lodestar.lodestone.handlers.screenparticle.ParticleEmitterHandler;
import team.lodestar.lodestone.registry.common.particle.LodestoneScreenParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.ScreenParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.screen.ScreenParticleHolder;

import java.awt.*;
import java.util.List;
import java.util.Random;


public class ParticleItem extends Item implements ParticleEmitterHandler.ItemParticleSupplier {
    public ParticleItem(Properties tab) {
        super(new Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
    }

    Color startingColor = new Color(255, 255, 255);
    Color endingColor = new Color(0, 47, 74);

    @Override
    public void spawnLateParticles(ScreenParticleHolder target, Level level, float partialTick, ItemStack stack, float x, float y) {
        Random random = new Random();

        // Reduced frequency control
        if (random.nextInt(10) < 2) { // 20% chance to spawn particles
            float offsetX = generateRandomOffset(random);
            float offsetY = generateRandomOffset(random);

            ScreenParticleBuilder.create(LodestoneScreenParticleRegistry.SPARKLE, target)
                    .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
                    .setScaleData(GenericParticleData.create(0.3f, 0).build())
                    .setGravityStrength(-1)
                    .setLifetime(15)
//                    .setRandomMotion(2)
                    .spawn(x + offsetX, y + offsetY);
        }
    }

    private float generateRandomOffset(Random random) {
        float offset;
        do {
            offset = (random.nextFloat() * 12) - 6; // Random float between -6 and 6
        } while (offset > -2 && offset < 2);
        return offset;
    }



    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal("Fancy Item!!!!!1!1!11!1").withStyle(ChatFormatting.GOLD));
    }
}
