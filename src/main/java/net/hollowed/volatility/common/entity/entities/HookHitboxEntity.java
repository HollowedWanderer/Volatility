package net.hollowed.volatility.common.entity.entities;

import net.hollowed.volatility.common.entity.ModEntityTypes;
import net.hollowed.volatility.common.entity.ai.ScratcherHurt;
import net.hollowed.volatility.common.entity.ai.ScratcherTick;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import software.bernie.example.entity.BatEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Objects;

public class HookHitboxEntity extends Animal implements GeoEntity {

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(HookHitboxEntity.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(HookHitboxEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(HookHitboxEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(HookHitboxEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public String animationprocedure = "empty";

    public HookHitboxEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(ModEntityTypes.HOOK_HITBOX.get(), world);
    }

    public HookHitboxEntity(EntityType<HookHitboxEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(true);
        setNoGravity(true);
        setPersistenceRequired();
        //this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
    }

    @Override
    protected void dropCustomDeathLoot(@NotNull DamageSource source, int lootingMultiplier, boolean allowDrops) {
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "blank");
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }

    //public boolean onClimbable() {
        //return this.isClimbing();
    //}



    @Override
    protected float getStandingEyeHeight(@NotNull Pose poseIn, @NotNull EntityDimensions sizeIn) {
        return 1.0F;
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        //CursedRemainsSpawn.execute(this);
        return retval;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(2, new PanicGoal(this, 1.5));
        //this.goalSelector.addGoal(1, new FloatGoal(this));
        //this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        //this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    @Override
    public @NotNull MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    //@Override
    //public SoundEvent getAmbientSound() {
        //return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.axolotl.idle_air"));
    //}


    //@Override
    //public void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
    //    this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step"))), 0.15f, 1);
    //}

    //@Override
    //public SoundEvent getHurtSound(@NotNull DamageSource ds) {
    //    return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.axolotl.hurt"));
    //}

    //@Override
    //public SoundEvent getDeathSound() {
    //    return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.axolotl.death"));
    //}

    @Override
    public void die(@NotNull DamageSource source) {
        super.die(source);
        //CursedRemainsDies.execute(this.level(), this.getX(), this.getY(), this.getZ());
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        //ScratcherHurt.execute(this.level(), this);
        return super.hurt(source, amount);
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture"))
            this.setTexture(compound.getString("Texture"));
    }

    @Override
    public void baseTick() {
        super.baseTick();
        //ScratcherTick.execute(this);
        this.refreshDimensions();
    }

    //@Override
    //public void tick() {
    //    super.tick();
    //    if (!this.level().isClientSide) {
    //        this.setClimbing(this.horizontalCollision);
    //    }
    //}

    //public boolean isClimbing() {
    //    return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    //}

    //public void setClimbing(boolean p_33820_) {
    //    byte b0 = this.entityData.get(DATA_FLAGS_ID);
    //    if (p_33820_) {
    //        b0 = (byte)(b0 | 1);
    //    } else {
    //        b0 = (byte)(b0 & -2);
    //    }

    //    this.entityData.set(DATA_FLAGS_ID, b0);
    //}

    //protected PathNavigation createNavigation(Level p_33802_) {
    //    return new WallClimberNavigation(this, p_33802_);
    //}

    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        return super.getDimensions(p_33597_).scale((float) 1);
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
        builder = builder.add(Attributes.MAX_HEALTH, 20);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0);
        return builder;
    }

    private PlayState movementPredicate(AnimationState event) {
        return PlayState.STOP;
    }


    private PlayState procedurePredicate(AnimationState event) {
        if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else if (animationprocedure.equals("empty")) {
            return PlayState.STOP;
        }
        return PlayState.CONTINUE;
    }

    @Override
    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime == 1) {
            this.remove(RemovalReason.KILLED);
            this.dropExperience();
        }
    }

    public String getSyncedAnimation() {
        return this.entityData.get(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.entityData.set(ANIMATION, animation);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 6, this::movementPredicate));
        data.add(new AnimationController<>(this, "procedure", 6, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
