package com.aduffy12.alphamod.world;

import com.aduffy12.alphamod.config.OreGenConfig;
import com.aduffy12.alphamod.init.AlphamodBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {

	public static void setupOreGeneration() {
		
		/*//will spawn in all biomes (amber ore)
		for(Biome biome : ForgeRegistries.BIOMES) {
				
			//amber_ore
			CountRangeConfig amber_ore_placement_regular = new CountRangeConfig(OreGenConfig.amber_regular_chance.get(), OreGenConfig.amber_max_height.get(), 0, OreGenConfig.amber_max_height.get()); // parameters are chance, min_height, max_height_base, max height
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, AlphamodBlocks.amber_ore.getDefaultState(), 6), new CountRange(), amber_ore_placement_regular));
			
			//basalt
			CountRangeConfig basalt_placement = new CountRangeConfig(OreGenConfig.basalt_chance.get(), OreGenConfig.basalt_min_height.get(), 0, OreGenConfig.basalt_max_height.get());
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, AlphamodBlocks.basalt.getDefaultState(), 4), new CountRange(), obsidian_ore_placement));
		
		}
		
		//jungle edge has increased spawn rate of amber ore 2x
		Biome biome_0 = Biomes.JUNGLE_EDGE;
		CountRangeConfig amber_ore_placement_jungle_edge = new CountRangeConfig(OreGenConfig.amber_jungle_hills_chance.get(), OreGenConfig.amber_min_height.get(), 0, OreGenConfig.amber_max_height.get());
		biome_0.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, AlphamodBlocks.amber_ore.getDefaultState(), 8), new CountRange(), amber_ore_placement_jungle_edge));
		
		// Jungle and jungle hills max spawn rate 3x
		Biome biome_1 = Biomes.JUNGLE_HILLS;
		Biome biome_2 = Biomes.JUNGLE;
		CountRangeConfig amber_ore_placement_jungle = new CountRangeConfig(OreGenConfig.amber_jungle_chance.get(), OreGenConfig.amber_min_height.get(), 0, OreGenConfig.amber_max_height.get());
		biome_1.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, AlphamodBlocks.amber_ore.getDefaultState(), 10), new CountRange(), amber_ore_placement_jungle));
		biome_2.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, AlphamodBlocks.amber_ore.getDefaultState(), 10), new CountRange(), amber_ore_placement_jungle));
		*/
		if(OreGenConfig.generate_overworld.get()) {
			
			//all biomes
			for(Biome biome : ForgeRegistries.BIOMES) {
				
				biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, AlphamodBlocks.amber_ore.getDefaultState(), OreGenConfig.amber_regular_chance.get())));
				biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, AlphamodBlocks.basalt.getDefaultState(), OreGenConfig.basalt_chance.get())));
				
			}
		}
	}
}
