package net.nucleusbeast.uselessthings.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nucleusbeast.uselessthings.UselessThings;
import net.nucleusbeast.uselessthings.block.ModBlocks;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntity {

    //Adding block entities:
    public static BlockEntityType<SimpleGeneratorEntity> SIMPLE_GENERATOR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
            new Identifier(UselessThings.MOD_ID, "simple_generator_entity"),
            FabricBlockEntityTypeBuilder.create(SimpleGeneratorEntity::new, ModBlocks.SIMPLE_GENERATOR).build(null));





//
//    public static BlockEntityType<SimpleGeneratorEntity> SIMPLE_GENERATOR_ENTITYa =
//            registerBlockEntities("simple_generator_entity", SimpleGeneratorEntity, ModBlocks.SIMPLE_GENERATOR);
//
//
//    //Method:
//    public static BlockEntityType<?> registerBlockEntities(String name, BlockEntity type, Block block){
//        return Registry.register(Registry.BLOCK_ENTITY_TYPE,
//                new Identifier(UselessThings.MOD_ID, name), FabricBlockEntityTypeBuilder.create(type::new, ModBlocks.SIMPLE_GENERATOR).build(null));
//    }
    public static void registerModBlockEntities() {
        UselessThings.LOGGER.info("Registering ModBlockEntities for" + UselessThings.MOD_ID + " mod!");
    }
}
