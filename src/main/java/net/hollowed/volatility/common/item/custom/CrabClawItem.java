package net.hollowed.volatility.common.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;

public class CrabClawItem extends Item {
    private final ImmutableMultimap<Attribute, AttributeModifier> defaultModifiers;

    public CrabClawItem(int p_43270_, Item.Properties p_43272_) {
        super(p_43272_);
        float reach = (float) p_43270_;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Claw reach", (double) reach, AttributeModifier.Operation.ADDITION));
        defaultModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot == EquipmentSlot.OFFHAND) {
            return defaultModifiers;
        }
        return super.getAttributeModifiers(slot, stack);
    }
}