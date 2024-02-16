package net.hollowed.volatility.common.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class CurseOfShattering extends Enchantment {
    public CurseOfShattering(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.BREAKABLE, slots);
    }

    @Override
    protected boolean checkCompatibility(@NotNull Enchantment ench) {
        return this != ench && !Objects.equals(Enchantments.MENDING, ench);
    }

    @Override
    public boolean isCurse() {
        return true;
    }


    @Override
    public boolean isTradeable() {
        return true;
    }
}
