package com.aduffy12.alphamod.init;

import com.mojang.datafixers.types.Type;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class AlphamodBiomes {

	//list of all added biomes
	public static Biome volcanic_beach_biome;
	public static Biome volcano_biome;
	
	
	public static void registerBiomes() {
		
		registerBiome(volcano_biome, Type.MESA);
	}
	
	//method to register biome in the world generation
	public static void registerBiome(Biome biome, net.minecraftforge.common.BiomeDictionary.Type... types) {
		
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
	
}
