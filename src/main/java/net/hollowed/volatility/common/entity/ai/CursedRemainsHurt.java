package net.hollowed.volatility.common.entity.ai;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class CursedRemainsHurt {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (Mth.nextInt(RandomSource.create(), 1, 3) == 1 &&
                entity instanceof CursedRemainsEntity &&
                entity.getPersistentData().getDouble("attacking") == 0 &&
                entity.getPersistentData().getDouble("blocking") == 0) {
            if (event != null && event.isCancelable()) {
                event.setCanceled(true);
            }
            ((CursedRemainsEntity) entity).setAnimation("block");
            entity.getPersistentData().putDouble("blocking", 1);
            Volatility.queueServerWork(25, ()-> {
                entity.getPersistentData().putDouble("blocking", 0);
            });
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land"))), SoundSource.HOSTILE, 1, (float) 1.8);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land"))), SoundSource.HOSTILE, 1, (float) 1.8, false);
                }
            }
        }
    }
}


