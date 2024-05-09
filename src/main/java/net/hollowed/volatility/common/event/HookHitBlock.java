package net.hollowed.volatility.common.event;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Objects;

public class HookHitBlock {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (world instanceof Level _level) {
            {
                if (!entity.level().isClientSide() && entity.getServer() != null) {
                    entity.getServer().getCommands().performPrefixedCommand(
                            new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level()
                                    instanceof ServerLevel ? (ServerLevel) entity.level() : null,
                                    4, entity.getName().getString(), entity.getDisplayName(),
                                    Objects.requireNonNull(entity.level().getServer()), entity),
                            "/playsound minecraft:item.trident.hit_ground player @a ~ ~ ~ 0.8 0.9");
                }
            }
        }
    }
}




