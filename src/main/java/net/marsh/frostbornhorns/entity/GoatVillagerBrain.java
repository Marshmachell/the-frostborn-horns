package net.marsh.frostbornhorns.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.*;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class GoatVillagerBrain {
    public GoatVillagerBrain() {}

    /*
    protected static Brain<?> create(Brain<GoatVillagerEntity> brain) {
        addIdleActivities(brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.resetPossibleActivities();
        return brain;
    }
    private static void addIdleActivities(Brain<GoatEntity> brain) {
        brain.setTaskList(Activity.IDLE, ImmutableList.of(Pair.of(0, LookAtMobWithIntervalTask.follow(EntityType.PLAYER, 6.0F, UniformIntProvider.create(30, 60))), Pair.of(0, new BreedTask(EntityType.GOAT)), Pair.of(1, new TemptTask((goat) -> {
            return 1.25F;
        })), Pair.of(2, WalkTowardsClosestAdultTask.create(WALKING_SPEED, 1.25F)), Pair.of(3, new RandomTask(ImmutableList.of(Pair.of(StrollTask.create(1.0F), 2), Pair.of(GoToLookTargetTask.create(1.0F, 3), 2), Pair.of(new WaitTask(30, 60), 1))))), ImmutableSet.of(Pair.of(MemoryModuleType.RAM_TARGET, MemoryModuleState.VALUE_ABSENT), Pair.of(MemoryModuleType.LONG_JUMP_MID_JUMP, MemoryModuleState.VALUE_ABSENT)));
    }
    */
}
