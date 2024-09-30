package net.nucleusbeast.uselessthings.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nucleusbeast.uselessthings.UselessThings;
import net.nucleusbeast.uselessthings.item.advanced.MajesticStick;
import net.nucleusbeast.uselessthings.item.tools.ModAxeItem;
import net.nucleusbeast.uselessthings.item.tools.ModPickaxeItem;
import net.nucleusbeast.uselessthings.item.tools.ModShovelItem;

public class ModItems {

    //Adding items:
    public static final Item NUCLEUS_CORE = registerItem("useless_core", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item PEARL_SHARD = registerItem("pearl_shard", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item MAJESTIC_STICK = registerItem("majestic_stick", new MajesticStick(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));
    public static final Item USELESS_INGOT = registerItem("useless_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    //Adding tools:
    public static final Item DUSTY_PICKAXE = registerItem("dusty_pickaxe", new ModPickaxeItem
            (ModToolMaterial.MATERIAL, 1, 1f, new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item RUSTY_SHOWEL = registerItem("rusty_showel", new ModShovelItem
            (ModToolMaterial.MATERIAL, 1, 1f,new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item DULL_AXE = registerItem("dull_axe", new ModAxeItem
            (ModToolMaterial.MATERIAL, 5, 3f, new FabricItemSettings().group(ItemGroup.TOOLS)));

    //Functions:
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(UselessThings.MOD_ID, name), item);
    }
    public static void registerModItems(){
        UselessThings.LOGGER.info("Registering ModItems for "+ UselessThings.MOD_ID +" mod!");
    }
}
