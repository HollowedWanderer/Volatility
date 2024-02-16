package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.item.ModItems;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@EventBusSubscriber(value = Dist.CLIENT, modid = Volatility.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModItemProperties {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            addShieldPropertyOverrides(new ResourceLocation(Volatility.MOD_ID, "blocking"),
                    (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F,
                    ModItems.STEEL_GREATSWORD.get(), ModItems.PLATINUM_GREATSWORD.get(), ModItems.WOODEN_GREATSWORD.get(),
                    ModItems.STONE_GREATSWORD.get(), ModItems.IRON_GREATSWORD.get(), ModItems.GOLDEN_GREATSWORD.get(),
                    ModItems.DIAMOND_GREATSWORD.get(), ModItems.NETHERITE_GREATSWORD.get(), ModItems.VANGUARD_SHIELD.get(), ModItems.ILLAGER_KNIGHTS_GREATSWORD.get(), ModItems.VIRIDIS_BLADE.get());
            addStaffPropertyOverrides(new ResourceLocation(Volatility.MOD_ID, "charge"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                if (p_174637_ == null) {
                    return 0.0F;
                } else {
                    return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 30.0F;
                }
            },
                    ModItems.STAFF_OF_THUNDERING.get(),ModItems.ICE_WAND.get());
            addStaffPropertyOverrides(new ResourceLocation(Volatility.MOD_ID, "striking"),
                    (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F,
                    ModItems.STAFF_OF_THUNDERING.get(),ModItems.ICE_WAND.get());
            addCrossbowPropertyOverrides(new ResourceLocation(Volatility.MOD_ID, "pull"), (p_174610_, p_174611_, p_174612_, p_174613_) ->
            {
                if (p_174612_ == null) {
                    return 0.0F;
                } else {
                    return SpeedCrossbowItem.isCharged(p_174610_) ? 0.0F : (float)(p_174610_.getUseDuration() - p_174612_.getUseItemRemainingTicks()) / (float)SpeedCrossbowItem.getChargeDuration(p_174610_);
                }
            },
                    ModItems.SILVER_PLATED_CROSSBOW.get());
            addCrossbowPropertyOverrides(new ResourceLocation(Volatility.MOD_ID,"pulling"), (p_174605_, p_174606_, p_174607_, p_174608_) ->
                    p_174607_ != null && p_174607_.isUsingItem() && p_174607_.getUseItem() == p_174605_ && !SpeedCrossbowItem.isCharged(p_174605_) ? 1.0F : 0.0f,
                    ModItems.SILVER_PLATED_CROSSBOW.get());
            addCrossbowPropertyOverrides(new ResourceLocation(Volatility.MOD_ID,"charged"), (p_275891_, p_275892_, p_275893_, p_275894_) ->
                    SpeedCrossbowItem.isCharged(p_275891_) ? 1.0F : 0.0F,
                    ModItems.SILVER_PLATED_CROSSBOW.get());
            addCrossbowPropertyOverrides(new ResourceLocation(Volatility.MOD_ID,"firework"), (p_275887_, p_275888_, p_275889_, p_275890_) ->
                    SpeedCrossbowItem.isCharged(p_275887_) && SpeedCrossbowItem.containsChargedProjectile(p_275887_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F,
                    ModItems.SILVER_PLATED_CROSSBOW.get());
            addStickPropertyOverrides(new ResourceLocation("brushing"), (p_272332_, p_272333_, p_272334_, p_272335_) -> {
                return p_272334_ != null && p_272334_.getUseItem() == p_272332_ ? (float)(p_272334_.getUseItemRemainingTicks() % 10) / 10.0F : 0.0F;
            }, ModItems.SHARP_STICK.get());
        });
    }
    private static void addShieldPropertyOverrides(ResourceLocation override, ClampedItemPropertyFunction propertyGetter,
                                                   ItemLike... shields) {
        for (ItemLike shield : shields) {
            ItemProperties.register(shield.asItem(), override, propertyGetter);
        }
    }
    private static void addStickPropertyOverrides(ResourceLocation override, ClampedItemPropertyFunction propertyGetter,
                                                   ItemLike... shields) {
        for (ItemLike shield : shields) {
            ItemProperties.register(shield.asItem(), override, propertyGetter);
        }
    }
    private static void addCrossbowPropertyOverrides(ResourceLocation override, ClampedItemPropertyFunction propertyGetter,
                                                   ItemLike... crossbows) {
        for (ItemLike crossbow : crossbows) {
            ItemProperties.register(crossbow.asItem(), override, propertyGetter);
        }
    }
    private static void addStaffPropertyOverrides(ResourceLocation override, ClampedItemPropertyFunction propertyGetter,
                                                     ItemLike... staffs) {
        for (ItemLike staff : staffs) {
            ItemProperties.register(staff.asItem(), override, propertyGetter);
        }
    }
    //ItemProperties
}
