package com.aduffy12.alphamod.world.biomes;

import com.aduffy12.alphamod.AlphamodRegisteries;
import com.aduffy12.alphamod.init.AlphamodBlocks;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class VolcanoBiome extends Biome{

	public VolcanoBiome() {
		
		super((new Biome.Builder())
				.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.MOUNTAIN, new SurfaceBuilderConfig(AlphamodBlocks.black_sand.getDefaultState(), AlphamodBlocks.black_sandstone.getDefaultState(), AlphamodBlocks.black_sand.getDefaultState())))
				.precipitation(RainType.RAIN)
				.category(Category.MESA)
				.downfall(0.2F)
				.depth(0.8F)
				.scale(0.5F)
				.temperature(0.8F)
				.waterColor(0x6534ad)
				.waterFogColor(0x6534ad)
				.parent("mountains"));
		
		DefaultBiomeFeatures.addCarvers(this);
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE,  new ProbabilityConfig(0.428571F))); //3x chance of caves spawning
		DefaultBiomeFeatures.addDeadBushes(this);
		DefaultBiomeFeatures.addDesertLakes(this);
		DefaultBiomeFeatures.addFossils(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addStructures(this);
		
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 25, 10, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DONKEY, 5, 2, 2));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 20, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		
		this.setRegistryName(AlphamodRegisteries.location("volcano_biome"));
		
	}
}
