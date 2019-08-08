package com.aduffy12.alphamod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aduffy12.alphamod.blocks.CustomStairsBlock;
import com.aduffy12.alphamod.blocks.CustomOreBlock;
import com.aduffy12.alphamod.items.CustomAxeItem;
import com.aduffy12.alphamod.items.CustomPickaxeItem;
import com.aduffy12.alphamod.items.ItemKnife;
import com.aduffy12.alphamod.lists.AlphamodArmorMaterials;
import com.aduffy12.alphamod.lists.AlphamodBiomes;
import com.aduffy12.alphamod.lists.AlphamodBlocks;
import com.aduffy12.alphamod.lists.AlphamodItems;
import com.aduffy12.alphamod.lists.AlphamodToolMaterials;
import com.aduffy12.alphamod.world.OreGeneration;
import com.aduffy12.alphamod.world.biome.VolcanicBeachBiome;
import com.aduffy12.alphamod.world.biome.VolcanoBiome;
import com.aduffy12.alphamod.config.Config;
import com.aduffy12.alphamod.config.KnifeConfig;

import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("alphamod")
public class Main {

	//mod instance
	public static Main instance;
	
	//reference variables for mod information
	public static final String MOD_ID = "alphamod";
	public static final String NAME = "More Lore";
	public static final String VERSION = "0.9.5 beta";
	public static final String ACCEPTED_VERSIONS = "(1.14.4)";
	
	//item group for creative mod
	public static final ItemGroup ALPHAMOD = new AlphaModItemGroup(12, "alphamod");
	
	//logger instance
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	//main method, starts mod
	public Main() {
		
		//collecting the congif files from the users
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG, "alphamod-server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG, "alphamod-client.toml");
		
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		// Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the clientSetup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        
        //loading the custom config files into the game
        Config.LoadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("alphamod-server.toml").toString());
        Config.LoadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("alphamod-client.toml").toString());
        

        //creating an instance of the mod, useful for encapsulation
        instance = this;
        
	}
	
	//sets up common event
	private void setup(final FMLCommonSetupEvent event) {
		
		//logger message
		LOGGER.info("Setup method registered");
		
		//ore generation
		OreGeneration.setupOreGeneration();
	}
	
	//sets up client event
	private void clientSetup(final FMLClientSetupEvent event) {
		
		//logger message
		LOGGER.info("Client setup method registered");
		
	}
	
	//class that acts as a directory of all the items and blocks added in the mod
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		
		//location method, enables easier creation of locations
		private static ResourceLocation location(String name) {
			
			return new ResourceLocation(MOD_ID, name);
		}
		
		//method to register the item in the directory
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			
			//logger message
			LOGGER.info("Items registered");
			
			
			//registering everything, use commas
			event.getRegistry().registerAll(
					
					//AMBER
					AlphamodItems.amber = new Item(new Item.Properties().group(ALPHAMOD)).setRegistryName(location("amber")),
					
					//AMBER_ORE
					AlphamodItems.amber_ore = new BlockItem(AlphamodBlocks.amber_ore, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.amber_ore.getRegistryName()),
					
					//AMBER BLOCK
					AlphamodItems.amber_block = new BlockItem(AlphamodBlocks.amber_block, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.amber_block.getRegistryName()),
					
					//AMBER_AXE
					AlphamodItems.amber_axe = new CustomAxeItem(AlphamodToolMaterials.amber, 2.0f, -3.0f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("amber_axe")),
					
					//AMBER_HOE
					AlphamodItems.amber_hoe = new HoeItem(AlphamodToolMaterials.amber, 0.0f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("amber_hoe")),
					
					//AMBER_PICKAXE
					AlphamodItems.amber_pickaxe = new CustomPickaxeItem(AlphamodToolMaterials.amber, -2, -2.8f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("amber_pickaxe")),
					
					//AMBER_SHOVEL
					AlphamodItems.amber_shovel = new ShovelItem(AlphamodToolMaterials.amber, -1.5f, -3.0f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("amber_shovel")),
					
					//AMBER_SWORD
					AlphamodItems.amber_sword = new SwordItem(AlphamodToolMaterials.amber, 0, -2.4f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("amber_sword")),
					
					//AMBER_KNIFE
					AlphamodItems.amber_knife = new ItemKnife(AlphamodToolMaterials.amber, -2.5f, (float)KnifeConfig.knife_attack_speed.get(), new Item.Properties().group(ALPHAMOD)).setRegistryName(location("amber_knife")),
					
					//OBSIDIAN_SHARD
					AlphamodItems.obsidian_shard = new Item(new Item.Properties().group(ALPHAMOD)).setRegistryName(location("obsidian_shard")),
					
					//BASALT 
					AlphamodItems.basalt = new BlockItem(AlphamodBlocks.basalt, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.basalt.getRegistryName()),
					
					//POLISHED_BASALT
					AlphamodItems.polished_basalt = new BlockItem(AlphamodBlocks.polished_basalt, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.polished_basalt.getRegistryName()),
					
					//OBSIDIAN_AXE
					AlphamodItems.obsidian_axe = new CustomAxeItem(AlphamodToolMaterials.obsidian, 4.0f, -3.2f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("obsidian_axe")),
					
					//OBSIDIAN HOE
					AlphamodItems.obsidian_hoe = new HoeItem(AlphamodToolMaterials.obsidian, -2.0f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("obsidian_hoe")),
					
					//OBSIDIAN_PICKAXE
					AlphamodItems.obsidian_pickaxe = new CustomPickaxeItem(AlphamodToolMaterials.obsidian, -2, -2.8f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("obsidian_pickaxe")),
					
					//OBSIDIAN_SHOVEL
					AlphamodItems.obsidian_shovel = new ShovelItem(AlphamodToolMaterials.obsidian, -1.5f, -3.0f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("obsidian_shovel")),
					
					//OBSIDIAN_SWORD
					AlphamodItems.obsidian_sword = new SwordItem(AlphamodToolMaterials.obsidian, 0, -2.4f, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("obsidian_sword")),
					
					//OBSIDIAN_KNIFE
					AlphamodItems.obsidian_knife = new ItemKnife(AlphamodToolMaterials.obsidian, -2.5f, (float)KnifeConfig.knife_attack_speed.get(), new Item.Properties().group(ALPHAMOD)).setRegistryName(location("obsidian_knife")),
					
					//BONE_HELMET
					AlphamodItems.bone_helmet = new ArmorItem(AlphamodArmorMaterials.bone, EquipmentSlotType.HEAD, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("bone_helmet")),
					
					//BONE_HELMET
					AlphamodItems.bone_chestplate = new ArmorItem(AlphamodArmorMaterials.bone, EquipmentSlotType.CHEST, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("bone_chestplate")),
					
					//BONE_HELMET
					AlphamodItems.bone_leggings = new ArmorItem(AlphamodArmorMaterials.bone, EquipmentSlotType.LEGS, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("bone_leggings")),
					
					//BONE_HELMET
					AlphamodItems.bone_boots = new ArmorItem(AlphamodArmorMaterials.bone, EquipmentSlotType.FEET, new Item.Properties().group(ALPHAMOD)).setRegistryName(location("bone_boots")),
					
					//WOOD_KNIFE
					AlphamodItems.wooden_knife = new ItemKnife(ItemTier.WOOD, 0.5f, (float)KnifeConfig.knife_attack_speed.get(), new Item.Properties().group(ALPHAMOD)).setRegistryName(location("wooden_knife")),
					
					//STONE_KNIFE
					AlphamodItems.stone_knife = new ItemKnife(ItemTier.STONE, 0.5f, (float)KnifeConfig.knife_attack_speed.get(), new Item.Properties().group(ALPHAMOD)).setRegistryName(location("stone_knife")),
					
					//IRON_KNIFE
					AlphamodItems.iron_knife = new ItemKnife(ItemTier.IRON, 0.5f, (float)KnifeConfig.knife_attack_speed.get(), new Item.Properties().group(ALPHAMOD)).setRegistryName(location("iron_knife")),
					
					//GOLDEN_KNIFE
					AlphamodItems.golden_knife = new ItemKnife(ItemTier.GOLD, 0.5f, (float)KnifeConfig.knife_attack_speed.get(), new Item.Properties().group(ALPHAMOD)).setRegistryName(location("golden_knife")),
					
					//DIAMOND_KNIFE
					AlphamodItems.diamond_knife = new ItemKnife(ItemTier.WOOD, 3.5f, (float)KnifeConfig.knife_attack_speed.get(), new Item.Properties().group(ALPHAMOD)).setRegistryName(location("diamond_knife")),
					
					//BLACK_SAND
					AlphamodItems.black_sand = new BlockItem(AlphamodBlocks.black_sand, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.black_sand.getRegistryName()),
					
					//BLACK_SANDSTONE
					AlphamodItems.black_sandstone = new BlockItem(AlphamodBlocks.black_sandstone, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.black_sandstone.getRegistryName()),
					
					//BLACK_SANDSTONE_SLAB
					AlphamodItems.black_sandstone_slab = new BlockItem(AlphamodBlocks.black_sandstone_slab, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.black_sandstone_slab.getRegistryName()),
					
					//BLACK_SANDSTONE_STAIRS
					AlphamodItems.black_sandstone_stairs = new BlockItem(AlphamodBlocks.black_sandstone_stairs, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.black_sandstone_stairs.getRegistryName()),
					
					//CHISELED_BLACK_SANDSTONE
					AlphamodItems.chiseled_black_sandstone = new BlockItem(AlphamodBlocks.chiseled_black_sandstone, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.chiseled_black_sandstone.getRegistryName()),
					
					//CUT_BLACK_SANDSTONE
					AlphamodItems.cut_black_sandstone = new BlockItem(AlphamodBlocks.cut_black_sandstone, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.cut_black_sandstone.getRegistryName()),
					
					//SMOOTH_BLACK_SANDSTONE
					AlphamodItems.smooth_black_sandstone = new BlockItem(AlphamodBlocks.smooth_black_sandstone, new Item.Properties().group(ALPHAMOD)).setRegistryName(AlphamodBlocks.smooth_black_sandstone.getRegistryName())
					
					);
		}
		
		//method to register the block in the directory
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			
			//logger message
			LOGGER.info("Blocks registered");
			
			//registering everything, use commas
			event.getRegistry().registerAll(
					
				//AMBER_BLOCK
				AlphamodBlocks.amber_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 30.0f).lightValue(4).sound(SoundType.STONE)).setRegistryName(location("amber_block")),
				
				//AMBER_ORE
				AlphamodBlocks.amber_ore = new CustomOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE)).setRegistryName(location("amber_ore")),
			
				//BASALT
				AlphamodBlocks.basalt = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)).setRegistryName(location("basalt")),
				
				//POLISHED_BASALT
				AlphamodBlocks.polished_basalt = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 30.0f).sound(SoundType.STONE)).setRegistryName(location("polished_basalt")),
				
				//BLACK_SAND
				AlphamodBlocks.black_sand = new SandBlock(0, Block.Properties.create(Material.SAND).hardnessAndResistance(0.5f, 2.5f).sound(SoundType.SAND)).setRegistryName(location("black_sand")),
				
				//BLACK_SANDSTONE
				AlphamodBlocks.black_sandstone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 4.0f).sound(SoundType.STONE)).setRegistryName(location("black_sandstone")),
				
				//BLACK_SANDSTONE_SLAB
				AlphamodBlocks.black_sandstone_slab = new SlabBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 4.0f).sound(SoundType.STONE)).setRegistryName(location("black_sandstone_slab")),
				
				//BLACK_SANDSTONE_STAIRS
				AlphamodBlocks.black_sandstone_stairs = new CustomStairsBlock(AlphamodBlocks.black_sandstone.getDefaultState(), Block.Properties.from(AlphamodBlocks.black_sandstone)).setRegistryName(location("black_sandstone_stairs")),
				
				//CHISELED_BLACK_SANDSTONE
				AlphamodBlocks.chiseled_black_sandstone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 4.0f).sound(SoundType.STONE)).setRegistryName(location("chiseled_black_sandstone")),
				
				//CUT_BLACK_SANDSTONE
				AlphamodBlocks.cut_black_sandstone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 4.0f).sound(SoundType.STONE)).setRegistryName(location("cut_black_sandstone")),
				
				//SMOOTH_BLACK_SANDSTONE
				AlphamodBlocks.smooth_black_sandstone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 4.0f).sound(SoundType.STONE)).setRegistryName(location("smooth_black_sandstone"))
			
			);
		}

		//method to register biomes in the directory
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
			
			//logger message
			LOGGER.info("Biomes registered");
			
			//registering everything, use commas
			event.getRegistry().registerAll(
					
				//VOLCANIC_BEACH
				AlphamodBiomes.volcanic_beach = new VolcanicBeachBiome().setRegistryName("volcanic_beach"),
				
				//VOLCANO
				AlphamodBiomes.volcano = new VolcanoBiome().setRegistryName("volcano")
			
			);
			
		}
		
	}
	
}
