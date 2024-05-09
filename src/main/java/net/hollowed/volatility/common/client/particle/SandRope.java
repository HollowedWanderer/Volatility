package net.hollowed.volatility.common.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SandRope extends TextureSheetParticle {
    public static SandRopeParticleProvider provider(SpriteSet spriteSet) {
        return new SandRopeParticleProvider(spriteSet);
    }

    public static class SandRopeParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public SandRopeParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
                                       double zSpeed) {
            return new SandRope(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }

    private final SpriteSet spriteSet;

    private float angularVelocity;
    private float angularAcceleration;

    protected SandRope(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.spriteSet = spriteSet;
        this.setSize(0.1f, 0.1f);
        this.quadSize *= 4f;
        this.lifetime = 1;
        this.gravity = 0f;
        this.hasPhysics = false;
        this.xd = vx * 1;
        this.yd = vy * 1;
        this.zd = vz * 1;
        this.angularVelocity = 0f;
        this.angularAcceleration = 0.01f;
        this.pickSprite(spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.oRoll = this.roll;
        this.roll += this.angularVelocity;
        this.angularVelocity += this.angularAcceleration;

        // Shrink the particle rapidly
        this.quadSize -= 0.15f; // Adjust the rate of shrinking as needed
    }
}

