package com.aidz.alphamod.world;

import com.aidz.alphamod.lists.BlockList;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {

	public static void setupOreGeneration() {
		
		//will spawn in all biomes (amber ore)
		for(Biome biome : ForgeRegistries.BIOMES) {
				
			//amber_ore
			CountRangeConfig amber_ore_placement_regular = new CountRangeConfig(5, 16, 0, 48); // parameters are chance, min_height, max_height_base, max height
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.amber_ore.getDefaultState(), 6), new CountRange(), amber_ore_placement_regular));
			
			//obsidian_ore
			CountRangeConfig obsidian_ore_placement = new CountRangeConfig(20, 0, 0, 16);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.basalt.getDefaultState(), 4), new CountRange(), obsidian_ore_placement));
		
		}
		
		//jungle edge has increased spawn rate of amber ore 2x
		Biome biome_0 = Biomes.JUNGLE_EDGE;
		CountRangeConfig amber_ore_placement_jungle_edge = new CountRangeConfig(10, 16, 0, 64);
		biome_0.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.amber_ore.getDefaultState(), 8), new CountRange(), amber_ore_placement_jungle_edge));
		
		// Jungle and jungle hills max spawn rate 3x
		Biome biome_1 = Biomes.JUNGLE_HILLS;
		Biome biome_2 = Biomes.JUNGLE;
		CountRangeConfig amber_ore_placement_jungle = new CountRangeConfig(15, 16, 0, 80);
		biome_1.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.amber_ore.getDefaultState(), 10), new CountRange(), amber_ore_placement_jungle));
		biome_2.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.amber_ore.getDefaultState(), 10), new CountRange(), amber_ore_placement_jungle));
		
	}
}
