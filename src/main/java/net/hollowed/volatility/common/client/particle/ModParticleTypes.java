package net.hollowed.volatility.common.client.particle;

import net.hollowed.volatility.Volatility;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Volatility.MOD_ID);
    public static final RegistryObject<SimpleParticleType> ELECTRIC_PULSE = REGISTRY.register("electric_pulse",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> ELECTRICAL_CRACKLE = REGISTRY.register("electrical_crackle",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FRICTION_SPARKS = REGISTRY.register("friction_sparks",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> DEATH_SWEEP = REGISTRY.register("death_sweep",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> ICE_PORTAL = REGISTRY.register("ice_portal",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LEAVES = REGISTRY.register("leaves",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SLASH = REGISTRY.register("slash",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FOG = REGISTRY.register("fog",
            () -> new SimpleParticleType(false));
}

