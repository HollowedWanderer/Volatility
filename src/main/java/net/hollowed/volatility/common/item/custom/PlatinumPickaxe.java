package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class PlatinumPickaxe extends PickaxeItem {
    public PlatinumPickaxe() {
        super(new Tier() {
            public int getUses() {
                return 1851;
            }

            public float getSpeed() {
                return 14f;
            }

            public float getAttackDamageBonus() {
                return 5f;
            }

            public int getLevel() {
                return 3;
            }

            public int getEnchantmentValue() {
                return 16;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(ModItems.PLATINUM.get()));
            }
        }, 1, -2.7999999999999998f, new Properties());
    }
}

