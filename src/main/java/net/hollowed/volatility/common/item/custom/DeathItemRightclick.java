package net.hollowed.volatility.common.item.custom;

import net.hollowed.volatility.common.client.shader.GlowPostProcessor;
import net.hollowed.volatility.common.client.shader.LightingFx;
import net.hollowed.volatility.common.event.DeathEvent;
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
import org.joml.Vector3f;
import team.lodestar.lodestone.handlers.ScreenshakeHandler;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.screenshake.PositionedScreenshakeInstance;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

public class DeathItemRightclick {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        {
            if (entity instanceof Player _player) {
                _player.getCooldowns().addCooldown(itemstack.getItem(), 5);
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
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.DEATHS_SCYTHE.get()) {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.MAIN_HAND, true);
        } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ModItems.DEATHS_SCYTHE.get()) {
            if (entity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.OFF_HAND, true);
        }
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(
                            (entity.level().clip(new ClipContext(
                                    entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)),
                                    ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                            (entity.level().clip(
                                            new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)),
                                                    ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                    .getBlockPos().getY()),
                            (entity.level().clip(
                                            new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)),
                                                    ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                    .getBlockPos().getZ())),
                            Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                    "summon minecraft:marker ~ ~ ~ {Tags:[\"death\"]}");
        DeathEvent.execute(world, entity);
        //ScreenshakeInstance instance = new ScreenshakeInstance(5);
        //instance.setIntensity(0.25F);
        //instance.setEasing(Easing.LINEAR);
        //ScreenshakeHandler.addScreenshake(instance);

        PositionedScreenshakeInstance instance1 = new PositionedScreenshakeInstance(5, entity.getEyePosition(), 2, 4);
        instance1.setIntensity(0.35F);
        for (int i = 0; i < 2; i++) {
            ScreenshakeHandler.addScreenshake(instance1);
        }
        GlowPostProcessor.INSTANCE.addFxInstance(new LightingFx(new Vector3f(0, 0, 0), new Vector3f(1, 0, 1)));
    }
}









