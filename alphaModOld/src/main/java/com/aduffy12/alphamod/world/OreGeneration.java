package com.aduffy12.alphamod.world;

import com.aduffy12.alphamod.config.OreGenConfig;
import com.aduffy12.alphamod.init.AlphamodBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {

	public static void setupOreGeneration() {
		
		if(OreGenConfig.generate_overworld.get()) { //must be true
			
			//all biomes
			for(Biome biome : ForgeRegistries.BIOMES) {
				
				//amber ore
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, AlphamodBlocks.amber_ore.getDefaultState(), OreGenConfig.amber_regular_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(OreGenConfig.amber_regular_chance.get(), OreGenConfig.amber_min_height.get(), 0, OreGenConfig.amber_max_height.get())));
				
				//basalt
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, AlphamodBlocks.basalt.getDefaultState(), OreGenConfig.basalt_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(OreGenConfig.basalt_chance.get(), OreGenConfig.basalt_min_height.get(), 0, OreGenConfig.basalt_max_height.get())));
				
			}
		}
	}
}
