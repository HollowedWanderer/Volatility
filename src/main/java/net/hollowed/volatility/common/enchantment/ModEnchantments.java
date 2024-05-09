package net.hollowed.volatility.common.enchantment;

import net.hollowed.volatility.Volatility;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Volatility.MOD_ID);

    public static final RegistryObject<Enchantment> CURSE_OF_SHATTERING = REGISTRY.register("curse_of_shattering", CurseOfShattering::new);
}

