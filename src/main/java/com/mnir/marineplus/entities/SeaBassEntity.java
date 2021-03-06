package com.mnir.marineplus.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.FindWaterGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;

@SuppressWarnings("EntityConstructor")
public class SeaBassEntity extends AbstractFishEntity
{
    public SeaBassEntity(EntityType<? extends AbstractFishEntity> type, World world) { super(type, world); }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {
        return MobEntity.func_233666_p_().
                createMutableAttribute(Attributes.MAX_HEALTH, 3.0D).
                createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.65);
    }

    @Override
    protected void registerGoals()
    {
        GoalSelector selector = this.goalSelector;
        super.registerGoals();
        selector.addGoal(0, new FindWaterGoal(this));
        selector.addGoal(1, new PanicGoal(this, 1.0D));
        selector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class,
                12.0F, 1.6D, 1.4D, EntityPredicates.NOT_SPECTATING::test));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) { return 1 + this.world.rand.nextInt(24); }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_COD_AMBIENT; }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_COD_DEATH; }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_COD_HURT; }

    @Override
    protected SoundEvent getFlopSound() { return SoundEvents.ENTITY_COD_FLOP; }

    @Override
    protected void playSwimSound(float volume) { this.playSound(SoundEvents.ENTITY_FISH_SWIM, 0.15F, 1.0F); }

    @Override
    protected ItemStack getFishBucket() { return null; }
}
