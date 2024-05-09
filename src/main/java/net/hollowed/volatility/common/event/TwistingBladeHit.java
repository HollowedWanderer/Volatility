package net.hollowed.volatility.common.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TwistingBladeHit {
    public static void execute(Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (Mth.nextInt(RandomSource.create(), 1, 5) == 3) {
            if (sourceentity instanceof LivingEntity _entity)
                _entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
                    @Override
                    public @NotNull Component getLocalizedDeathMessage(@NotNull LivingEntity _msgEntity) {
                        String _translatekey = "death.attack." + "curse";
                        if (this.getEntity() == null && this.getDirectEntity() == null) {
                            return _msgEntity.getKillCredit() != null
                                    ? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
                                    : Component.translatable(_translatekey, _msgEntity.getDisplayName());
                        } else {
                            Component _component = this.getEntity() == null ? Objects.requireNonNull(this.getDirectEntity()).getDisplayName() : this.getEntity().getDisplayName();
                            ItemStack _itemstack = ItemStack.EMPTY;
                            if (this.getEntity() instanceof LivingEntity _livingentity)
                                _itemstack = _livingentity.getMainHandItem();
                            return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
                                    ? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
                                    : Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
                        }
                    }
                }, 2);
        }
    }
}

