package net.hollowed.volatility.common.item.custom;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import java.util.Objects;

public class RemnantAxe extends SwordItem {
    public RemnantAxe(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        {
            if (!pTarget.level().isClientSide() && pTarget.getServer() != null) {
                pTarget.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, pTarget.position(), pTarget.getRotationVector(), pTarget.level()
                                instanceof ServerLevel ? (ServerLevel) pTarget.level() : null,
                                4, pTarget.getName().getString(), pTarget.getDisplayName(),
                                Objects.requireNonNull(pTarget.level().getServer()), pTarget),
                        "effect give @s enchantify:bleeding 1 1");
            }
        }
        {
            if (!pAttacker.level().isClientSide() && pAttacker.getServer() != null) {
                pAttacker.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, pAttacker.position(), pAttacker.getRotationVector(),
                        pAttacker.level() instanceof ServerLevel ? (ServerLevel) pAttacker.level() : null, 4,
                        pAttacker.getName().getString(), pAttacker.getDisplayName(), Objects.requireNonNull(pAttacker.level().getServer()),
                        pAttacker), "effect give @s minecraft:speed 1 1");
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
