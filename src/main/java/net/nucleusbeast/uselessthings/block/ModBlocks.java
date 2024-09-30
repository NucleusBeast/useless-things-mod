package net.nucleusbeast.uselessthings.block;

import com.mojang.serialization.Decoder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nucleusbeast.uselessthings.UselessThings;
import net.nucleusbeast.uselessthings.block.simplegenerator.SimpleGenerator;

public class ModBlocks {

    //Adding glocks:
    public static final Block SIMPLE_GENERATOR = registerBlock("simple_generator",
            new SimpleGenerator(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool().luminance((state) -> state.get(SimpleGenerator.ACTIVE) ? 8 : 0)), ItemGroup.REDSTONE);


    //Methods:
    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(UselessThings.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(UselessThings.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        UselessThings.LOGGER.info("Registering ModBlocks for" + UselessThings.MOD_ID + " mod!");
    }
}
