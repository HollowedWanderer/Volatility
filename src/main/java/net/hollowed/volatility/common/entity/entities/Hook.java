package net.hollowed.volatility.common.entity.entities;

import dev.kosmx.playerAnim.core.util.Vec3d;
import net.hollowed.volatility.common.effect.ModEffects;
import net.hollowed.volatility.common.entity.ModEntityTypes;
import net.hollowed.volatility.common.event.*;
import net.hollowed.volatility.common.network.ModVariables;
import net.hollowed.volatility.common.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import org.jetbrains.annotations.NotNull;
import software.bernie.example.entity.BatEntity;

import java.util.Objects;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class Hook extends AbstractArrow implements ItemSupplier {
    public static final ItemStack PROJECTILE_ITEM = new ItemStack(Items.IRON_PICKAXE);

    public Hook(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntityTypes.GRAPPLING_HOOK.get(), world);
    }

    public Hook(EntityType<? extends Hook> type, Level world) {
        super(type, world);
    }

    public Hook(EntityType<? extends Hook> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    protected float getWaterInertia() {
        return 0.85F;
    }

    public Hook(EntityType<? extends Hook> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return PROJECTILE_ITEM;
    }

    @Override
    protected ItemStack getPickupItem() {
        return PROJECTILE_ITEM;
    }

    @Override
    protected void doPostHurtEffects(@NotNull LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.setArrowCount(entity.getArrowCount() - 1);
    }

    @Override
    public void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        HookHitEntity.execute(this, this.getOwner());
    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        HookHitBlock.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
    }


    //@Override
    //protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
    //    return SoundEvents.TRIDENT_HIT_GROUND;
    //}

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return ModSounds.HOOK_LAND.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) { // Check if it's not the client side
            HookFlyingTick.execute(this.getOwner(), this);
            if (this.inGround && this.getOwner() != null) {
                double maxSpeed = 0.4; // Adjust the maximum speed as needed
                Vec3 direction = new Vec3(this.getX() - this.getOwner().getX(), this.getY() - this.getOwner().getY(), this.getZ() - this.getOwner().getZ());
                double distance = direction.length();

                // Calculate the scaling factor based on distance
                double scale = Math.max(0, (1 - (distance / 46))); // Adjust maxDistance as needed

                // Apply scaling to the speed
                double speed = maxSpeed * scale;

                // Normalize the direction vector
                direction = direction.normalize();

                // Calculate the motion components
                double motionX = direction.x * speed;
                double motionY = direction.y * speed;
                double motionZ = direction.z * speed;

                // Update the player's position directly
                this.getOwner().getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    if (distance <= 0.6) {
                        capability.hookX = motionX * 0.05;
                        capability.hookY = motionY * 0.05;
                        capability.hookZ = motionZ * 0.05;
                    } else {
                        capability.hookX = motionX;
                        capability.hookY = motionY;
                        capability.hookZ = motionZ;
                    }
                    capability.syncPlayerVariables(this.getOwner());
                });

                if (this.getOwner() instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(ModEffects.HOOKED.get(), 2, 0, false, false));
            }
        }
    }

    public static Hook shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 0.4f, 0, 0);
    }

    public static Hook shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
        Hook entityarrow = new Hook(ModEntityTypes.GRAPPLING_HOOK.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot"))), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
        return entityarrow;
    }

    public static Hook shoot(LivingEntity entity, LivingEntity target) {
        Hook entityarrow = new Hook(ModEntityTypes.GRAPPLING_HOOK.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.4f * 2, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(0);
        entityarrow.setKnockback(0);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
        entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot"))), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
        return entityarrow;
    }
}

