package net.hollowed.volatility.common.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DeathItem extends SwordItem {


    public DeathItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        DeathItemKill.execute(pTarget);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level p_43099_, Player p_43100_, @NotNull InteractionHand p_43101_) {
        ItemStack itemstack = p_43100_.getItemInHand(p_43101_);
        p_43100_.startUsingItem(p_43101_);
        DeathItemRightclick.execute(p_43099_, p_43100_, itemstack);
        return InteractionResultHolder.consume(itemstack);
    }
}
