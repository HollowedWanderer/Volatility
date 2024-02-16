package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.event.LightningMarkerEvent;
import net.hollowed.volatility.common.item.ModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class StaffOfThunderingFail {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        {
            if (entity instanceof Player _player) {
                if (!_player.isCreative()) {
                    ItemStack _ist = itemstack;
                    if (_ist.hurt(1, RandomSource.create(), null)) {
                        _ist.shrink(1);
                        _ist.setDamageValue(0);
                    }
                }

            }
        }

        if (entity == null)
            return;
/**        if (entity instanceof Player _player)
            _player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                mana.subMana(10);
                _player.sendSystemMessage(Component.literal("Current Thirst " + mana.getMana())
                        .withStyle(ChatFormatting.AQUA));
            }); **/
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.STAFF_OF_THUNDERING.get()) {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.MAIN_HAND, true);
        } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.STAFF_OF_THUNDERING.get()) {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.OFF_HAND, true);
        }

        if (entity instanceof Player _player)
            _player.getCooldowns().addCooldown(itemstack.getItem(), 80);
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
                    "playsound minecraft:block.amethyst_cluster.break master @p ~ ~1 ~ 1 0.8");
        LightningMarkerEvent.execute(world, entity);
    }
}









