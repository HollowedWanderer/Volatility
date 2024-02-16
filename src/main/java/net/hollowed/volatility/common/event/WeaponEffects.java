package net.hollowed.volatility.common.event;

import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber
public class WeaponEffects {
    @SubscribeEvent
    public static void onEntityAttacked(CriticalHitEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity());
        }
    }

    public static void execute(Entity sourceentity) {
        execute(null, sourceentity);
    }



    private static void execute(@Nullable Event event, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:metal_swords")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((0.6 + random.nextDouble() * 0.4) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:sword_hit player @a ~ ~ ~ 0.7 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
            }
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:ice_weapons")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((0.6 + random.nextDouble() * 0.4) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:sword_hit player @a ~ ~ ~ 0.5 " + randomMultiplier;
            String playsoundCommand2 = "playsound minecraft:entity.player.hurt_freeze player @a ~ ~ ~ 1 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand2);
            }
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:great_hammer")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((0.8 + random.nextDouble() * 0.5) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:hammer_hit player @a ~ ~ ~ 0.7 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
            }
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:metal_greatswords")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((0.8 + random.nextDouble() * 0.5) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:greatsword_crit player @a ~ ~ ~ 0.7 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
            }
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:nonmetal_swords")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((0.8 + random.nextDouble() * 0.5) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:sword_bonk player @a ~ ~ ~ 0.7 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
            }
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:metal_axes")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((0.8 + random.nextDouble() * 0.5) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:axe_hit player @a ~ ~ ~ 0.7 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
            }
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:trident")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((0.5 + random.nextDouble() * 0.4) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:sword_hit player @a ~ ~ ~ 0.7 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
            }
        }
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("volatility:glaives")))) {
            Random random = new Random();
            double randomMultiplier = Math.round((1.1 + random.nextDouble() * 0.5) * 10.0) / 10.0;  // Round to the nearest tenth
            String playsoundCommand = "playsound volatility:sword_hit player @a ~ ~ ~ 0.7 " + randomMultiplier;

            if (!sourceentity.level().isClientSide() && sourceentity.getServer() != null) {
                sourceentity.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, sourceentity.position(), sourceentity.getRotationVector(),
                                sourceentity.level() instanceof ServerLevel ? (ServerLevel) sourceentity.level() : null, 4,
                                sourceentity.getName().getString(), sourceentity.getDisplayName(),
                                Objects.requireNonNull(sourceentity.level().getServer()), sourceentity), playsoundCommand);
            }
        }
    }
}