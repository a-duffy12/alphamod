package com.aidz.alphamod.world.biome;

import com.aidz.alphamod.lists.BlockList;
import com.google.common.collect.Lists;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Fluids;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.LakesConfig;
import net.minecraft.world.gen.feature.LiquidsConfig;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.RandomDefaultFeatureListConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.TallGrassConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.StrongholdConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.DungeonRoomConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.LakeChanceConfig;
import net.minecraft.world.gen.surfacebuilders.CompositeSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class VolcanoBiome extends Biome {
	
	//surface object
	public static SurfaceBuilderConfig volcanic_surface = new SurfaceBuilderConfig(BlockList.black_sand.getDefaultState(), BlockList.black_sandstone.getDefaultState(), BlockList.black_sand.getDefaultState());

	public VolcanoBiome() {
		super((new Biome.BiomeBuilder()).surfaceBuilder(new CompositeSurfaceBuilder<>(DEFAULT_SURFACE_BUILDER, volcanic_surface)).precipitation(Biome.RainType.RAIN).category(Biome.Category.EXTREME_HILLS).depth(1.4F).scale(0.7F).temperature(1.8F).downfall(0.1F).waterColor(3093137).waterFogColor(3093137).parent((String)null));
	      this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
	      this.addStructure(Feature.STRONGHOLD, new StrongholdConfig());
	      this.addCarver(GenerationStage.Carving.AIR, createWorldCarverWrapper(CAVE_WORLD_CARVER, new ProbabilityConfig(0.14285715F)));
	      this.addCarver(GenerationStage.Carving.AIR, createWorldCarverWrapper(CANYON_WORLD_CARVER, new ProbabilityConfig(0.02F)));
	      this.addStructureFeatures();
	      this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, createCompositeFeature(Feature.LAKES, new LakesConfig(Blocks.WATER), LAKE_WATER, new LakeChanceConfig(10)));
	      this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, createCompositeFeature(Feature.LAKES, new LakesConfig(Blocks.LAVA), LAVA_LAKE, new LakeChanceConfig(10)));
	      this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, createCompositeFeature(Feature.DUNGEONS, IFeatureConfig.NO_FEATURE_CONFIG, DUNGEON_ROOM, new DungeonRoomConfig(8)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.GRANITE.getDefaultState(), 17), COUNT_RANGE, new CountRangeConfig(5, 0, 0, 80)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.DIORITE.getDefaultState(), 17), COUNT_RANGE, new CountRangeConfig(5, 0, 0, 80)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.ANDESITE.getDefaultState(), 17), COUNT_RANGE, new CountRangeConfig(5, 0, 0, 80)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.COAL_ORE.getDefaultState(), 9), COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.IRON_ORE.getDefaultState(), 9), COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.GOLD_ORE.getDefaultState(), 9), COUNT_RANGE, new CountRangeConfig(2, 0, 0, 32)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.REDSTONE_ORE.getDefaultState(), 17), COUNT_RANGE, new CountRangeConfig(8, 0, 0, 16)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.DIAMOND_ORE.getDefaultState(), 17), COUNT_RANGE, new CountRangeConfig(1, 0, 0, 16)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.LAPIS_ORE.getDefaultState(), 17), DEPTH_AVERAGE, new DepthAverageConfig(1, 16, 16)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.amber_ore.getDefaultState(), 6), COUNT_RANGE, new CountRangeConfig(5, 16, 0, 48)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.basalt.getDefaultState(), 65), COUNT_RANGE, new CountRangeConfig(10, 0, 0, 128)));
		  this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, createCompositeFeature(Feature.SPHERE_REPLACE, new SphereReplaceConfig(BlockList.black_sand, 7, 2, Lists.newArrayList(Blocks.DIRT, Blocks.GRASS_BLOCK)), TOP_SOLID, new FrequencyConfig(3)));
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createCompositeFeature(Feature.RANDOM_FEATURE_LIST, new RandomDefaultFeatureListConfig(new Feature[]{Feature.TALL_TAIGA_TREE, Feature.BIG_TREE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.666F, 0.1F}, Feature.TREE, IFeatureConfig.NO_FEATURE_CONFIG), AT_SURFACE_WITH_EXTRA, new AtSurfaceWithExtraConfig(0, 0.1F, 1)));
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createCompositeFeature(Feature.TALL_GRASS, new TallGrassConfig(Blocks.GRASS.getDefaultState()), TWICE_SURFACE, new FrequencyConfig(1)));
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createCompositeFeature(Feature.DEAD_BUSH, IFeatureConfig.NO_FEATURE_CONFIG, TWICE_SURFACE, new FrequencyConfig(2)));
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createCompositeFeature(Feature.LIQUIDS, new LiquidsConfig(Fluids.WATER), HEIGHT_BIASED_RANGE, new CountRangeConfig(50, 8, 8, 256)));
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createCompositeFeature(Feature.LIQUIDS, new LiquidsConfig(Fluids.LAVA), HEIGHT_VERY_BIASED_RANGE, new CountRangeConfig(20, 8, 0, 256)));
	      this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, Blocks.INFESTED_STONE.getDefaultState(), 9), COUNT_RANGE, new CountRangeConfig(7, 0, 0, 64)));
	      this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, createCompositeFeature(Feature.ICE_AND_SNOW, IFeatureConfig.NO_FEATURE_CONFIG, PASSTHROUGH, IPlacementConfig.NO_PLACEMENT_CONFIG));
	      this.addSpawn(EnumCreatureType.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 10, 4, 4));
	      this.addSpawn(EnumCreatureType.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 15, 4, 4));
	      this.addSpawn(EnumCreatureType.CREATURE, new Biome.SpawnListEntry(EntityType.LLAMA, 5, 4, 6));
	      this.addSpawn(EnumCreatureType.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 5, 8, 8));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EnumCreatureType.MONSTER, new Biome.SpawnListEntry(EntityType.MAGMA_CUBE, 1, 1, 1));
	}

}
