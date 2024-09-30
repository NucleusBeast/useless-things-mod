package net.nucleusbeast.uselessthings.block.simplegenerator;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nucleusbeast.uselessthings.blockentity.ModBlockEntity;
import net.nucleusbeast.uselessthings.blockentity.SimpleGeneratorEntity;
import org.jetbrains.annotations.Nullable;

public class SimpleGenerator extends BlockWithEntity implements BlockEntityProvider {

    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");

    public SimpleGenerator(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SimpleGeneratorEntity(pos, state);
    }

    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntity.SIMPLE_GENERATOR_ENTITY, SimpleGeneratorEntity::tick);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    //@SuppressWarnings("deprecation")
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (world.isClient){
//            if (hand == Hand.MAIN_HAND){
//                if (world.getBlockEntity(pos) instanceof SimpleGeneratorEntity){
//                    ((SimpleGeneratorEntity) world.getBlockEntity(pos)).printEnergy(player, ((SimpleGeneratorEntity) world.getBlockEntity(pos)).getEnergy().amount);
//                }
//            }
//        }
//        return ActionResult.SUCCESS;
//    }

}
