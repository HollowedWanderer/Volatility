package net.hollowed.volatility.common.sound;

import net.hollowed.volatility.Volatility;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Volatility.MOD_ID);

    public static final RegistryObject<SoundEvent> ICEOLOGER_AMBIENT = registerSoundEvent("iceologer_ambient");
    public static final RegistryObject<SoundEvent> ICEOLOGER_HURT = registerSoundEvent("iceologer_hurt");
    public static final RegistryObject<SoundEvent> ICEOLOGER_DEATH = registerSoundEvent("iceologer_death");
    public static final RegistryObject<SoundEvent> ICEOLOGER_ATTACK = registerSoundEvent("iceologer_attack");
    public static final RegistryObject<SoundEvent> ICE_CHUNK_SMASH = registerSoundEvent("ice_chunk_smash");
    public static final RegistryObject<SoundEvent> SWORD_HIT = registerSoundEvent("sword_hit");
    public static final RegistryObject<SoundEvent> GREATSWORD_CRIT = registerSoundEvent("greatsword_crit");
    public static final RegistryObject<SoundEvent> HAMMER_HIT = registerSoundEvent("hammer_hit");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(Volatility.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
