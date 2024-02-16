package net.hollowed.volatility.common.item.custom;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StaffOfThundering extends SwordItem {

    public StaffOfThundering() {
        super(new Tier() {
                  public int getUses() {
                      return 250;
                  }

                  public float getSpeed() {
                      return 0f;
                  }

                  public float getAttackDamageBonus() {
                      return 5f;
                  }

                  public int getLevel() {
                      return 0;
                  }

                  public int getEnchantmentValue() {
                      return 15;
                  }

                  public Ingredient getRepairIngredient() {
                      return Ingredient.EMPTY;
                  }
              },

                -4, -2.7999999999999998f,

                new Properties().rarity(Rarity.RARE));
    }


    boolean charged;

    public int getUseDuration(ItemStack p_43107_) {
        return 72000;
    }

    public UseAnim getUseAnimation(ItemStack p_40678_) {
        return UseAnim.TOOT_HORN;
    }

    public InteractionResultHolder<ItemStack> use(Level p_40672_, Player p_40673_, InteractionHand p_40674_) {
        ItemStack itemstack = p_40673_.getItemInHand(p_40674_);
            StaffOfThunderingCharging.execute(p_40672_, p_40673_, itemstack);
            p_40673_.startUsingItem(p_40674_);
            return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int p_40670_) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack) - p_40670_;
            if (i > 30.0) {
                charged = true;
            }
            if (charged) {
                double x = player.getX();
                double y = player.getY();
                double z = player.getZ();

                StaffOfThunderingRightclick.execute(world, player, stack);
                charged = false;
            } else {
                StaffOfThunderingFail.execute(world, player, stack);
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal("Ancient magic imbues this staff with great power").withStyle(ChatFormatting.GOLD));
    }
}

