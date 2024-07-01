package net.hollowed.volatility.common.item;

import net.hollowed.volatility.Volatility;
//import net.hollowed.volatility.common.entity.ModEntityTypes;
import net.hollowed.volatility.common.entity.ModEntityTypes;
import net.hollowed.volatility.common.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Volatility.MOD_ID);

    /** Entity Spawn Eggs **/

    public static final RegistryObject<Item> FANCY_ITEM = ITEMS.register("fancy_item",
            () -> new ParticleItem(new Item.Properties().stacksTo(64).fireResistant()));

    public static final RegistryObject<Item> CURSED_REMAINS_SPAWN_EGG = ITEMS.register("cursed_remains_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CURSED_REMAINS, -5785153, -12670032,
                    new Item.Properties()));

    public static final RegistryObject<Item> STAFF_OF_THUNDERING = ITEMS.register("staff_of_thundering",
            StaffOfThundering::new);
    public static final RegistryObject<Item> ICE_WAND = ITEMS.register("ice_wand",
            IceWand::new);
    public static final RegistryObject<Item> ETERNAL_GOLDEN_CARROT = ITEMS.register("eternal_golden_carrot",
            () -> new EternalGoldenCarrot(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STEEL_SCRAP = ITEMS.register("steel_scrap",
            () -> new Item(new Item.Properties().stacksTo(64).fireResistant()));
    public static final RegistryObject<Item> SILVER_SCRAP = ITEMS.register("silver_scrap",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> ECTOPLASM = ITEMS.register("ectoplasm",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> TWISTING_BLADE = ITEMS.register("twisting_blade",
            () -> new TwistingBlade(ModTiers.Steel, 5, -2.8f,
                    new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> GRAPPLING_HOOK = ITEMS.register("remnant_hook",
            () -> new HookItem(new Item.Properties().rarity(ModRarity.LEGENDARY)));


    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> TATTERED_LINEN = ITEMS.register("tattered_linen",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> SILVER_PLATE = ITEMS.register("silver_plate",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> ROCK = ITEMS.register("rock",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> PLANT_FIBER = ITEMS.register("plant_fiber",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> FLINT_SHARD = ITEMS.register("flint_shard",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));
    public static final RegistryObject<Item> TWINE = ITEMS.register("twine",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> REMNANT_BLADE_SHARD = ITEMS.register("remnant_blade_shard",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> ELK_ANTLER = ITEMS.register("elk_antler",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> BOSS_ANTLER = ITEMS.register("boss_antler",
            () -> new Item(new Item.Properties().stacksTo(64)
            ));

    public static final RegistryObject<Item> SHARP_ROCK = ITEMS.register("sharp_rock",
            () -> new AxeItem(ModTiers.ModWood, -1, -3.1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> STONE_AXE = ITEMS.register("stone_axe",
            () -> new AxeItem(ModTiers.ModStone, 2, -3.0f,
                    new Item.Properties()));

    public static final RegistryObject<Item> REMNANT_SCRAP_AXE = ITEMS.register("remnant_scrap_axe",
            () -> new RemnantAxe(ModTiers.ModDiamond, 5, -3.0f,
                    new Item.Properties()));

    public static final RegistryObject<Item> SHARP_STICK = ITEMS.register("sharp_stick",
            () -> new SharpObject(ModTiers.ModWood, -2, -2.6f,
                    new Item.Properties()));
    public static final RegistryObject<Item> SHARP_BONE = ITEMS.register("sharp_bone",
            () -> new SharpObject(ModTiers.ModWood, -1, -2.6f,
                    new Item.Properties()));
    public static final RegistryObject<Item> FLINT_KNIFE = ITEMS.register("flint_knife",
            () -> new SwordItem(ModTiers.ModStone, 1, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BONE_SCYTHE = ITEMS.register("bone_scythe",
            () -> new SwordItem(ModTiers.ModDiamond, 3, -2.4f,
                    new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CRYONIC_SCYTHE = ITEMS.register("cryonic_scythe",
            () -> new CryonicScythe(ModTiers.ModDiamond, 5, -2.4f,
                    new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> SILVER_PLATED_CROSSBOW = ITEMS.register("silver_plated_crossbow",
            () -> new SpeedCrossbowItem(
                    new Item.Properties().durability(654)));

    public static final RegistryObject<Item> ANTLER_PICKAXE = ITEMS.register("antler_pickaxe",
            () -> new PickaxeItem(ModTiers.ModWood, -2, -2.8f,
                    new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> LEGENDARY_KEY = ITEMS.register("legendary_key",
            () -> new EdibleKeyItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> HORNED_DIAMOND_HELMET = ITEMS.register("horned_diamond_helmet",
            () -> new DiamondArmorItem(ModArmorMaterials.DIAMOND, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> CRAB_CLAW = ITEMS.register("crab_claw",
            () -> new CrabClawItem(2,
                    new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PLATINUM = ITEMS.register("platinum",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModTiers.Steel, 2, -2.4f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModTiers.Steel, 0, -2.8f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModTiers.Steel, 5, -3.1f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModTiers.Steel, 1, -3f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModTiers.Steel, -3, -1f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_LEGGING = ITEMS.register("steel_leggings",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new SteelArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_GREATSWORD = ITEMS.register("steel_greatsword",
            () -> new BlockingSword(ModTiers.Steel, 4, -2.8f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> STEEL_GLAIVE = ITEMS.register("steel_glaive",
            () -> new HeavySwordItem(ModTiers.Steel, 1, 0.5f, -2.4f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModTiers.Platinum, 4, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModTiers.Platinum, 2, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModTiers.Platinum, 6, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModTiers.Platinum, 2, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModTiers.Platinum, -2, -1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots",
            () -> new PlatinumArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_GREATSWORD = ITEMS.register("platinum_greatsword",
            () -> new BlockingSword(ModTiers.Platinum, 6, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_GLAIVE = ITEMS.register("platinum_glaive",
            () -> new HeavySwordItem(ModTiers.Platinum, 3, 0.5f, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PLATED_CHESTPIECE = ITEMS.register("silver_plated_chestpiece",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PLATED_LEGGINGS = ITEMS.register("silver_plated_leggings",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> SILVER_TIPPED_BOOTS = ITEMS.register("silver_tipped_boots",
            () -> new SilverArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> GREAT_HAMMER = ITEMS.register("great_hammer",
            () -> new HammerItem(ModTiers.ModStone, 5, -3.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> SMITHING_HAMMER = ITEMS.register("smithing_hammer",
            () -> new SmallHammerItem(ModTiers.ModStone, -1, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BATTLESTAFF = ITEMS.register("battlestaff",
            () -> new SwordItem(ModTiers.ModWood, 1, -2.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> GAUNTLET = ITEMS.register("gauntlet",
            () -> new SwordItem(ModTiers.ModStone, -1, -1.6f,
                    new Item.Properties()));
 public static final RegistryObject<Item> WOODEN_GLAIVE = ITEMS.register("wooden_glaive",
         () -> new HeavySwordItem(ModTiers.ModWood, -1, 0.5f, -2.4f,
                 new Item.Properties()));
 public static final RegistryObject<Item> STONE_GLAIVE = ITEMS.register("stone_glaive",
         () -> new HeavySwordItem(ModTiers.ModStone, 0, 0.5f, -2.4f,
                 new Item.Properties()));
    public static final RegistryObject<Item> IRON_GLAIVE = ITEMS.register("iron_glaive",
            () -> new HeavySwordItem(ModTiers.ModIron, 1, 0.5f, -2.4f,
                    new Item.Properties()));
 public static final RegistryObject<Item> GOLDEN_GLAIVE = ITEMS.register("golden_glaive",
         () -> new HeavySwordItem(ModTiers.ModGold, 1, 0.5f, -2.4f,
                 new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new HeavySwordItem(ModTiers.ModDiamond, 2, 0.5f, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive",
            () -> new HeavySwordItem(ModTiers.ModNetherite, 3, 0.5f, -2.4f,
                    new Item.Properties().fireResistant()));
 public static final RegistryObject<Item> WOODEN_GREATSWORD = ITEMS.register("wooden_greatsword",
         () -> new BlockingSword(ModTiers.ModWood, 2, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> STONE_GREATSWORD = ITEMS.register("stone_greatsword",
         () -> new BlockingSword(ModTiers.ModStone, 3, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword",
         () -> new BlockingSword(ModTiers.ModIron, 4, -2.8f,
                 new Item.Properties()));

    public static final RegistryObject<Item> VIRIDIS_BLADE = ITEMS.register("viridis_blade",
            () -> new ViridisBlade(ModTiers.ModNetherite, 8, -2.8f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLAGER_KNIGHTS_GREATSWORD = ITEMS.register("illager_knights_greatsword",
            () -> new UniqueBlockingSword(ModTiers.Illager, 5, -2.8f,
                    new Item.Properties()));
 public static final RegistryObject<Item> GOLDEN_GREATSWORD = ITEMS.register("golden_greatsword",
         () -> new BlockingSword(ModTiers.ModGold, 4, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> DIAMOND_GREATSWORD = ITEMS.register("diamond_greatsword",
         () -> new BlockingSword(ModTiers.ModDiamond, 5, -2.8f,
                 new Item.Properties()));
 public static final RegistryObject<Item> NETHERITE_GREATSWORD = ITEMS.register("netherite_greatsword",
         () -> new BlockingSword(ModTiers.ModNetherite, 6, -2.8f,
                 new Item.Properties()));
    public static final RegistryObject<Item> VANGUARD_SHIELD = ITEMS.register("vanguard_shield",
            () -> new VanguardShield(
                    new Item.Properties().rarity(Rarity.UNCOMMON).durability(447)));
    public static final RegistryObject<Item> DEATHS_SCYTHE = ITEMS.register("deaths_scythe",
            () -> new DeathItem(ModTiers.Platinum, -3, -2.4f,
                    new Item.Properties().rarity(Rarity.EPIC)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
