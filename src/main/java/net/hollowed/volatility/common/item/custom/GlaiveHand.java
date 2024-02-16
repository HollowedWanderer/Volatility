package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class GlaiveHand {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() || (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.VANGUARD_SHIELD.get())) {
            if (entity instanceof LivingEntity _entity) {
                if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.VANGUARD_SHIELD.get())) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1, 2, false, false));
                }
            }
        }
    }
}

