package com.aduffy12.alphamod.world;

import com.aduffy12.alphamod.init.AlphamodBiomes;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class AlphamodWorldType extends WorldType{

	public AlphamodWorldType() {
		super("alphamod_type");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) {

		OverworldGenSettings settings = new OverworldGenSettings();	
		SingleBiomeProviderSettings single = new SingleBiomeProviderSettings();
		single.setBiome(AlphamodBiomes.volcano_biome); //change this to alter which biome should the world consist of
		return new OverworldChunkGenerator(world, new SingleBiomeProvider(single), settings);
		
	}

}
