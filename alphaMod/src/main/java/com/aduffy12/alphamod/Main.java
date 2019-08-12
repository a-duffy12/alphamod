package com.aduffy12.alphamod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aduffy12.alphamod.blocks.CustomStairsBlock;
import com.aduffy12.alphamod.blocks.CustomOreBlock;
import com.aduffy12.alphamod.items.CustomAxeItem;
import com.aduffy12.alphamod.items.CustomPickaxeItem;
import com.aduffy12.alphamod.items.ItemKnife;
import com.aduffy12.alphamod.world.OreGeneration;
import com.aduffy12.alphamod.world.biomes.VolcanicBeachBiome;
import com.aduffy12.alphamod.world.biomes.VolcanoBiome;
import com.aduffy12.alphamod.config.Config;
import com.aduffy12.alphamod.config.KnifeConfig;
import com.aduffy12.alphamod.init.AlphamodArmorMaterials;
import com.aduffy12.alphamod.init.AlphamodBiomes;
import com.aduffy12.alphamod.init.AlphamodBlocks;
import com.aduffy12.alphamod.init.AlphamodItems;
import com.aduffy12.alphamod.init.AlphamodToolMaterials;

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
		
		//collecting the config files from the users
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
	
}
