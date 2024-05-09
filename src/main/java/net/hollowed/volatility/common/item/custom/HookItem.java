package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.event.HookClicked;
import net.hollowed.volatility.common.item.ModRarity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HookItem extends Item {
    public HookItem(Properties rarity) {
        super(new Item.Properties().stacksTo(1).rarity(ModRarity.LEGENDARY));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack p_41421_, @Nullable Level level, List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        components.add(Component.literal("The Desert Core becomes overstressed in cold biomes").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        HookClicked.execute(world, entity, ar.getObject());
        return ar;
    }
}
