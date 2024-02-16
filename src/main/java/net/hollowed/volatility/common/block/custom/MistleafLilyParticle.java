package net.hollowed.volatility.common.block.custom;

//import net.hollowed.volatility.common.client.particle.ModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class MistleafLilyParticle {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            //_level.sendParticles(ModParticleTypes.FOG.get(), x, y, z, 5, 15, 5, 15, 0.04);
        }
    }
}

