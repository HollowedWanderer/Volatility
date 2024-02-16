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

import java.util.List;


public class EdibleKeyItem extends Item {
    public EdibleKeyItem(Properties tab) {
        super(new Properties().stacksTo(64).rarity(Rarity.UNCOMMON)
                .food((new FoodProperties.Builder()).nutrition(69).saturationMod(69.420f).alwaysEat()

                        .build()));
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 2));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 0));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 12000, 9));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 12000, 9));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 12000, 3));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 12000, 1));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 12000, 0));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 12000, 1));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 12000, 9));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 12000, 0));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 12000, 9));
        if (!entity.level().isClientSide())
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 12000, 3));

        return retval;
    }



    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal("Wait, this isn't a pay to win server...").withStyle(ChatFormatting.GRAY));
    }
}
