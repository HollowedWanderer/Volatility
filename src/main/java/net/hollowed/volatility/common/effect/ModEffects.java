package net.hollowed.volatility.common.effect;

import net.hollowed.volatility.Volatility;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Volatility.MOD_ID);

    public static final RegistryObject<MobEffect> SILVER_SHIELD = MOB_EFFECTS.register("silver_shield",
            () -> new RangedEffect(MobEffectCategory.BENEFICIAL, -7877432));
    public static final RegistryObject<MobEffect> SCYTHE_FROZEN = MOB_EFFECTS.register("scythe_frozen",
            () -> new Frozen(MobEffectCategory.HARMFUL, 5688575));

    public static final RegistryObject<MobEffect> HOOKED = MOB_EFFECTS.register("hooked",
            () -> new Hooked(MobEffectCategory.NEUTRAL, 5688575));

    public static final RegistryObject<MobEffect> KILL_HOOK = MOB_EFFECTS.register("kill_hook",
            () -> new Hooked(MobEffectCategory.NEUTRAL, 5688575));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
