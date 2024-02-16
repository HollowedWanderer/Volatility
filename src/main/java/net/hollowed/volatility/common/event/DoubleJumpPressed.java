package net.hollowed.volatility.common.event;

import net.hollowed.volatility.common.effect.ModEffects;
import net.hollowed.volatility.common.enchantment.ModEnchantments;
import net.hollowed.volatility.common.network.ModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import java.util.Objects;

public class DoubleJumpPressed {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.DOUBLE_JUMP.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0 && !entity.onGround()
                && !(entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ModVariables.PlayerVariables())).jumpCooldown) {
            {
                boolean _setval = true;
                entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.jumpCooldown = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 1.8), 0.5, (entity.getDeltaMovement().z() * 1.8)));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(ModEffects.FEATHER_FALL.get(), 20, 0, false, false));
            {
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                            entity.getName().getString(), entity.getDisplayName(), Objects.requireNonNull(entity.level().getServer()), entity), "/particle minecraft:cloud ~ ~ ~ 0 0 0 0.05 10");
                }
            }
            {
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                            entity.getName().getString(), entity.getDisplayName(), Objects.requireNonNull(entity.level().getServer()), entity), "/playsound minecraft:block.moss_carpet.step player @a");
                }
            }
        }
    }
}