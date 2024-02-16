package net.hollowed.volatility.common.event;

import net.hollowed.volatility.common.effect.ModEffects;
import net.hollowed.volatility.common.enchantment.ModEnchantments;
import net.hollowed.volatility.common.network.ModVariables;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;


public class Dash {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.DASH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0 && !entity.onGround()
                && !(entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ModVariables.PlayerVariables())).dashCooldown) {
            {
                boolean _setval = true;
                entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.dashCooldown = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 1), (entity.getDeltaMovement().y() + entity.getLookAngle().y * 1), (entity.getDeltaMovement().z() + entity.getLookAngle().z * 1)));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(ModEffects.FEATHER_FALL.get(), 20, 0, false, false));
        }
    }
}
