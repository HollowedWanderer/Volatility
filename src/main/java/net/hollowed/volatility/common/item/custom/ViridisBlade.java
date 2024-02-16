package net.hollowed.volatility.common.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.hollowed.volatility.common.event.SweepSound;
import net.hollowed.volatility.common.event.ViridisBladeAttack;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;


public class ViridisBlade extends SwordItem  {

    public static final int EFFECTIVE_BLOCK_DELAY = 10;
    public static final float MINIMUM_DURABILITY_DAMAGE = 3.0F;
    public static final String TAG_BASE_COLOR = "Base";
    public ViridisBlade(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43089_) {
        super(p_43269_, p_43270_, p_43271_, p_43089_);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        float attackDamage = (float) p_43270_ + p_43269_.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double) attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)p_43271_, AttributeModifier.Operation.ADDITION));
        Multimap<Attribute, AttributeModifier> defaultModifiers = builder.build();
    }

    public @NotNull String getDescriptionId(@NotNull ItemStack p_43109_) {
        return BlockItem.getBlockEntityData(p_43109_) != null ? this.getDescriptionId() + "." + getColor(p_43109_).getName() : super.getDescriptionId(p_43109_);
    }

    public void appendHoverText(@NotNull ItemStack p_43094_, @Nullable Level p_43095_, List<Component> p_43096_, @NotNull TooltipFlag p_43097_) {
        p_43096_.add(Component.literal("Unique Item").withStyle(ChatFormatting.GOLD));
        p_43096_.add(Component.literal("Two Handed").withStyle(ChatFormatting.GOLD));
        BannerItem.appendHoverTextFromBannerBlockEntityTag(p_43094_, p_43096_);
    }

    public int getUseDuration(@NotNull ItemStack p_43107_) {
        return 72000;
    }

    public UseAnim getUseAnimation(ItemStack p_43105_) {
        return UseAnim.BLOCK;
    }

    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level p_43099_, Player p_43100_, @NotNull InteractionHand p_43101_) {
        ItemStack itemstack = p_43100_.getItemInHand(p_43101_);
        p_43100_.startUsingItem(p_43101_);
        return InteractionResultHolder.consume(itemstack);
    }

    public boolean isValidRepairItem(@NotNull ItemStack p_43091_, ItemStack p_43092_) {
        return p_43092_.is(ItemTags.PLANKS) || super.isValidRepairItem(p_43091_, p_43092_);
    }

    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
        if (entity instanceof Player player) {
            player.getCooldowns().addCooldown(itemstack.getItem(), 200);
        }
        SweepSound.execute(world, entity.getX(), entity.getY(), entity.getZ());
    }


    public static DyeColor getColor(ItemStack p_43103_) {
        CompoundTag compoundtag = BlockItem.getBlockEntityData(p_43103_);
        return compoundtag != null ? DyeColor.byId(compoundtag.getInt("Base")) : DyeColor.WHITE;
    }

    /* ******************** FORGE START ******************** */

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, net.minecraftforge.common.@NotNull ToolAction toolAction) {
        return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
    }

 //   public EquipmentSlot getEquipmentSlot() {
   //     return EquipmentSlot.MAINHAND;
  //  }


    @Override
    public void inventoryTick(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected)
            TwoHandWeaponHand.execute(entity);
        ViridisBladeAttack.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
    }
}
