package net.hollowed.volatility.common.entity;

import net.hollowed.volatility.Volatility;
//import net.hollowed.volatility.common.entity.custom.IceChunkEntity;
//import net.hollowed.volatility.common.entity.custom.IceSpikesEntity;
//import net.hollowed.volatility.common.entity.custom.IceologerEntity;
import net.hollowed.volatility.common.entity.entities.*;
import net.minecraft.world.entity.animal.Pig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Volatility.MOD_ID);

    public static final RegistryObject<EntityType<CursedRemainsEntity>> CURSED_REMAINS = register("cursed_remains", EntityType.Builder.<CursedRemainsEntity>of(CursedRemainsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CursedRemainsEntity::new).fireImmune().sized(0.8f, 2.8f));

    public static final RegistryObject<EntityType<SkeletonNecromancerEntity>> SKELETON_NECROMANCER = register("skeleton_necromancer", EntityType.Builder.<SkeletonNecromancerEntity>of(SkeletonNecromancerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(24).setUpdateInterval(3).setCustomClientFactory(SkeletonNecromancerEntity::new).sized(0.8f, 2.8f));

    public static final RegistryObject<EntityType<ScratcherEntity>> SCRATCHER = register("scratcher",
            EntityType.Builder.<ScratcherEntity>of(ScratcherEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).setCustomClientFactory(ScratcherEntity::new)
                    .sized(1.2f, 0.6f));

    public static final RegistryObject<EntityType<HookHitboxEntity>> HOOK_HITBOX = register("hook_hitbox",
            EntityType.Builder.<HookHitboxEntity>of(HookHitboxEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).setCustomClientFactory(HookHitboxEntity::new)
                    .sized(1.2f, 2.3f));

    public static final RegistryObject<EntityType<Hook>> GRAPPLING_HOOK = register("hook_projectile",
            EntityType.Builder.<Hook>of(Hook::new, MobCategory.MISC).setCustomClientFactory(Hook::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.7f, 0.7f));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }


    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(CursedRemainsEntity::init);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CURSED_REMAINS.get(), CursedRemainsEntity.createAttributes().build());
        event.put(SKELETON_NECROMANCER.get(), SkeletonNecromancerEntity.createAttributes().build());
        event.put(SCRATCHER.get(), ScratcherEntity.createAttributes().build());
        event.put(HOOK_HITBOX.get(), HookHitboxEntity.createAttributes().build());
    }

}

