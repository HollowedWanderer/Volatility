package net.hollowed.volatility.common.event;

import net.hollowed.volatility.common.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.hollowed.volatility.Volatility.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DamageHandler {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            DamageSource source = event.getSource(); // what caused the damage
            float amount = event.getAmount(); // amount of damage taken
            if (player.hasEffect(ModEffects.SILVER_SHIELD.get()) && silverShieldShouldAffect(source)) {
                event.setAmount(amount * 0.5f); // sets the amount of damage taken to
                // 80% of its original value
            }
        }
    }

    private static boolean silverShieldShouldAffect(DamageSource source) {
        return source.is(DamageTypes.ARROW) ||
                source.is(DamageTypes.FIREBALL) ||
                source.is(DamageTypes.FALLING_STALACTITE) ||
                source.is(DamageTypes.FIREWORKS) ||
                source.is(DamageTypes.INDIRECT_MAGIC) ||
                source.is(DamageTypes.FALLING_ANVIL) ||
                source.is(DamageTypes.DRAGON_BREATH) ||
                source.is(DamageTypes.LIGHTNING_BOLT) ||
                source.is(DamageTypes.SONIC_BOOM) ||
                source.is(DamageTypes.UNATTRIBUTED_FIREBALL) ||
                source.is(DamageTypes.WITHER) ||
                source.is(DamageTypes.WITHER_SKULL) ||
                source.is(DamageTypes.MAGIC); // ...
    }
}