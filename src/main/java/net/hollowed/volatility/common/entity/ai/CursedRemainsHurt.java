package net.hollowed.volatility.common.entity.ai;

import net.hollowed.volatility.Volatility;
import net.hollowed.volatility.common.entity.entities.CursedRemainsEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
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
        if (Mth.nextInt(RandomSource.create(), 1, 5) == 1 &&
                entity instanceof CursedRemainsEntity) {
            if (event != null && event.isCancelable()) {
                event.setCanceled(true);
            }
            //((CursedRemainsEntity) entity).setAnimation("block");
            if (!entity.level().isClientSide() && entity.getServer() != null) {
                entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
                        entity.getName().getString(), entity.getDisplayName(), Objects.requireNonNull(entity.level().getServer()), entity), "/particle volatility:friction_sparks ~ ~1 ~ 0 0 0 0.2 15");
            }
            entity.getPersistentData().putDouble("blocking", 1);
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


