package net.nucleusbeast.uselessthings.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.nucleusbeast.uselessthings.UselessThings;
import net.nucleusbeast.uselessthings.item.ModItems;

public class ModLootTableModifiers {

    private static final Identifier ACACIA_LEAVES = new Identifier("minecraft", "blocks/acacia_leaves");
    private static final Identifier AZALEA_LEAVES = new Identifier("minecraft", "blocks/azalea_leaves");
    private static final Identifier BIRCH_LEAVES = new Identifier("minecraft", "blocks/birch_leaves");
    private static final Identifier DARK_OAK_LEAVES = new Identifier("minecraft", "blocks/dark_oak_leaves");
    private static final Identifier FLOWERTING_AZALEA_LEAVES = new Identifier("minecraft", "blocks/flowering_azalea_leaves");
    private static final Identifier JUNGLE_LEAVES = new Identifier("minecraft", "blocks/jungle_leaves");
    private static final Identifier OAK_LEAVES = new Identifier("minecraft", "blocks/oak_leaves");
    private static final Identifier SPRUCE_LEAVES = new Identifier("minecraft", "blocks/spruce_leaves");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((((resourceManager, manager, id, supplier, setter) -> {
            if (ACACIA_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (AZALEA_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (BIRCH_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (DARK_OAK_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (JUNGLE_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (FLOWERTING_AZALEA_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (OAK_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (SPRUCE_LEAVES.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) //drops 1% of the time
                        .with(ItemEntry.builder(ModItems.MAJESTIC_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }
        } )));
    }
}
