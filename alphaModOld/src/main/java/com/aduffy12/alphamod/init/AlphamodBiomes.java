package com.aduffy12.alphamod.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class AlphamodBiomes {

	//list of all added biomes
	public static Biome volcanic_beach_biome;
	public static Biome volcano_biome;
	
	//final method to register, use this one
	public static void registerBiomes() {
		
		registerBiome(volcano_biome, Type.MOUNTAIN);
		registerBiome(volcanic_beach_biome, Type.BEACH);
	}
	
	//longer method to register biome in the world generation
	public static void registerBiome(Biome biome, Type... types) {
		
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
	
}
