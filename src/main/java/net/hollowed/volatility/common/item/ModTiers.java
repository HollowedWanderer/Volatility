package net.hollowed.volatility.common.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier ModWood = new ForgeTier(0, 81, 1.0f,
            3f, 12, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.OAK_PLANKS));
    public static final ForgeTier ModStone = new ForgeTier(0, 131, 3.0f,
            3f, 12, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.COBBLESTONE));
    public static final ForgeTier ModIron = new ForgeTier(0, 250, 3.0f,
            3f, 12, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static final ForgeTier Illager = new ForgeTier(0, 696, 3.0f,
            3f, 12, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.SILVER_SCRAP.get()));
    public static final ForgeTier ModGold = new ForgeTier(0, 32, 7.0f,
            3f, 12, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.GOLD_INGOT));
    public static final ForgeTier ModDiamond = new ForgeTier(0, 1561, 5.0f,
            3f, 12, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.DIAMOND));
    public static final ForgeTier ModNetherite = new ForgeTier(0, 2031, 12.0f,
            3f, 12, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));
    public static final ForgeTier Steel = new ForgeTier(2, 752, 5.0f,
            3f, 12, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.STEEL_SCRAP.get()));
    public static final ForgeTier Platinum = new ForgeTier(3, 1851, 12.0f,
            3f, 16, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.PLATINUM.get()));
}
