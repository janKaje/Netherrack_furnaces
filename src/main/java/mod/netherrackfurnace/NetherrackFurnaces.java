package mod.netherrackfurnace;

import mod.netherrackfurnace.block.NetherrackFurnaceBlock;
import mod.netherrackfurnace.entity.NetherrackFurnaceBlockEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherrackFurnaces implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("netherrack-furnaces");

	// Add netherrack furnace block
	public static final NetherrackFurnaceBlock NETHERRACK_FURNACE_BLOCK = Registry.register(
			Registries.BLOCK,
			new Identifier("netherrack-furnaces", "netherrack_furnace"),
			new NetherrackFurnaceBlock(FabricBlockSettings.create())
	);

	public static final BlockEntityType<NetherrackFurnaceBlockEntity> NETHERRACK_FURNACE_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier("netherrack-furnaces", "netherrack_furnace_block_entity"),
			FabricBlockEntityTypeBuilder.create(NetherrackFurnaceBlockEntity::new, NETHERRACK_FURNACE_BLOCK).build()
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
			content.addAfter(Items.FURNACE ,NETHERRACK_FURNACE_BLOCK);
		});

		Registry.register(Registries.ITEM, new Identifier("netherrack-furnaces", "netherrack_furnace"), new BlockItem(NETHERRACK_FURNACE_BLOCK, new FabricItemSettings()));

		LOGGER.info("Hello Fabric world!");
	}
}