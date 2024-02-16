package net.hollowed.volatility.common.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.List;

public class DoubleJumpEnchant extends Enchantment {
    public DoubleJumpEnchant(EquipmentSlot... slots) {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_LEGS, slots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
