package net.nucleusbeast.uselessthings.blockentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.nucleusbeast.uselessthings.block.simplegenerator.SimpleGenerator;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class SimpleGeneratorEntity extends BlockEntity{

    private static final int capacity = 10000;
    private static final int maxExtract = 100;
    private static final int generating = 10;

    SimpleEnergyStorage energy = new SimpleEnergyStorage(capacity, maxExtract, generating);

    public SimpleGeneratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.SIMPLE_GENERATOR_ENTITY, pos, state);
    }

    static int tickable = 0;

    public static void tick(World world, BlockPos pos, BlockState state, SimpleGeneratorEntity be) {
        if (!world.isReceivingRedstonePower(pos)){
            if (state.get(SimpleGenerator.ACTIVE)){
                world.setBlockState(pos, state.with(SimpleGenerator.ACTIVE, false), Block.NOTIFY_ALL);
            }
        }
        else {
            if (!state.get(SimpleGenerator.ACTIVE)){
                world.setBlockState(pos, state.with(SimpleGenerator.ACTIVE, true), Block.NOTIFY_ALL);
            }
            if (!world.isClient && (be.energy.amount < 10000)) {
                if (tickable != 20) {
                    tickable += 1;
                } else {
                    be.energy.amount += generating;
                    if (be.energy.amount > be.energy.capacity) {
                        be.energy.amount = be.energy.capacity;
                    }
                    tickable = 0;

                    for (Direction side : Direction.values()) {
                        if (EnergyStorage.SIDED.find(world, pos.offset(side), side.getOpposite()) != null) {
                            if (EnergyStorage.SIDED.find(world, pos.offset(side), side.getOpposite()).getAmount()
                                    < EnergyStorage.SIDED.find(world, pos.offset(side), side.getOpposite()).getCapacity()) {
                                EnergyStorageUtil.move(
                                        EnergyStorage.SIDED.find(world, pos, side),
                                        EnergyStorage.SIDED.find(world, pos.offset(side), side.getOpposite()),
                                        maxExtract * 10,
                                        null
                                );
                            }
                        }
                    }
                }
            }
        }
    }

//    public void printEnergy(PlayerEntity player, long amount){
//        player.sendMessage(new LiteralText("energy: " + amount), false);
//    }

    public SimpleEnergyStorage getEnergy(){
        return energy;
    }
}
