package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.event.LightningMarkerEvent;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class StaffOfThunderingCharging {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
/**        if (entity instanceof Player _player)
            _player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                mana.subMana(10);
                _player.sendSystemMessage(Component.literal("Current Thirst " + mana.getMana())
                        .withStyle(ChatFormatting.AQUA));
            }); **/



        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(
                            (entity.level().clip(new ClipContext(
                                    entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)),
                                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                            (entity.level().clip(
                                            new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)),
                                                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
                                    .getBlockPos().getY()),
                            (entity.level().clip(
                                            new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0)),
                                                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
                                    .getBlockPos().getZ())),
                            Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "playsound minecraft:entity.illusioner.prepare_blindness player @a ~ ~1 ~ 2 1");
        LightningMarkerEvent.execute(world, entity);
    }
}









