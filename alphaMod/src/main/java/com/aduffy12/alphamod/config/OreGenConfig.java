package com.aduffy12.alphamod.config;

import net.minecraftforge.common.ForgeConfigSpec;;

public class OreGenConfig {

	public static ForgeConfigSpec.IntValue amber_regular_chance;
	public static ForgeConfigSpec.IntValue amber_jungle_hills_chance;
	public static ForgeConfigSpec.IntValue amber_jungle_chance;
	public static ForgeConfigSpec.IntValue basalt_chance;
	
	public static ForgeConfigSpec.IntValue amber_min_height;
	public static ForgeConfigSpec.IntValue amber_max_height;
	public static ForgeConfigSpec.IntValue basalt_min_height;
	public static ForgeConfigSpec.IntValue basalt_max_height;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		
		server.comment("OreGen Config");
		
		amber_regular_chance = server
				.comment("Maximum number of Amber Ore veins that spawn in one chunk of regular biomes")
				.defineInRange("oregen.amber_regular", 5, 0, 1000);
		
		amber_jungle_hills_chance = server
				.comment("Maximum number of Amber Ore vens that spawn in one chunk of Jungle Hills biomes")
				.defineInRange("oregen.amber_jungle_hills", 10, 0, 1500);
		
		amber_jungle_chance = server
				.comment("Maximum number of Amber Ore vens that spawn in one chunk of Jungle Hills biomes")
				.defineInRange("oregen.amber_jungle", 15, 0, 2000);
		
		basalt_chance = server
				.comment("Maximum number of Basalt veins that spawn in one chunk")
				.defineInRange("oregen.basalt", 20, 0, 4000);
		
		amber_min_height = server
				.comment("Minimum height that Amber Ore will spawn")
				.defineInRange("oregen.amber_min", 16, 0, 64);
		
		amber_max_height = server
				.comment("Maximum height that Amber Ore will spawn")
				.defineInRange("oregen.amber_max", 48, 0, 128);
		
		basalt_min_height = server
				.comment("Minimum height that Basalt will spawn")
				.defineInRange("oregen.basalt_min", 0, 0, 64);
		
		basalt_min_height = server
				.comment("Minimum height that Basalt will spawn")
				.defineInRange("oregen.basalt_min",16, 0, 128);
		
	}
	
}
