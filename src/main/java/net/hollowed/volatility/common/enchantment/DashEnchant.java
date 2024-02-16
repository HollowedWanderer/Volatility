package net.hollowed.volatility.common.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DashEnchant extends Enchantment {
    public DashEnchant(EquipmentSlot... slots) {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, slots);
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
