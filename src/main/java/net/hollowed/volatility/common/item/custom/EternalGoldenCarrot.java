package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class EternalGoldenCarrot extends Item {
    public EternalGoldenCarrot(Properties tab) {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE)
                .food((new FoodProperties.Builder()).nutrition(7).saturationMod(14.4f)

                        .build()));
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        if (isEdible()) {
            if (!world.isClientSide && entity instanceof Player player) {
                player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), 600);
            }
        }
        ItemStack retval = new ItemStack(ModItems.ETERNAL_GOLDEN_CARROT.get());
        super.finishUsingItem(itemstack, world, entity);
        if (itemstack.isEmpty()) {
            return retval;
        } else {
            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                if (!player.getInventory().add(retval))
                    player.drop(retval, false);
            }
            return itemstack;
        }

    }


    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal("Not consumed when eaten").withStyle(ChatFormatting.GRAY));
    }
}
