package net.hollowed.volatility.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public enum ModRarity implements net.minecraftforge.common.IExtensibleEnum {
    LEGENDARY(ChatFormatting.GOLD);

    /** @deprecated Forge: Use {@link #getStyleModifier()} */
    @Deprecated
    public final ChatFormatting color;
    private final java.util.function.UnaryOperator<net.minecraft.network.chat.Style> styleModifier;

    private ModRarity(ChatFormatting p_43028_) {
        this.color = p_43028_;
        this.styleModifier = style -> style.withColor(p_43028_);
    }

    ModRarity(java.util.function.UnaryOperator<net.minecraft.network.chat.Style> styleModifier) {
        this.color = ChatFormatting.BLACK;
        this.styleModifier = styleModifier;
    }

    public java.util.function.UnaryOperator<net.minecraft.network.chat.Style> getStyleModifier() {
        return this.styleModifier;
    }

    public static Rarity create(String name, ChatFormatting p_43028_) {
        throw new IllegalStateException("Enum not extended");
    }

    public static Rarity create(String name, java.util.function.UnaryOperator<net.minecraft.network.chat.Style> styleModifier) {
        throw new IllegalStateException("Enum not extended");
    }

    public Rarity get() {
        return null;
    }
}
