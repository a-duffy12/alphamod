package com.aduffy12.alphamod.config;

import java.io.File;

import com.aduffy12.alphamod.Main;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {

	//config builder for the server
	private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec server_config;
	
	//config builder for the client
	private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec client_config;
	
	static {
		
		//build the two configs
		server_config = server_builder.build();
		client_config = client_builder.build();
	}
	
	//method to load the config from its location, including any changes made to it
	public static void LoadConfig(ForgeConfigSpec config, String path) {
		
		Main.LOGGER.info("Loading config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		Main.LOGGER.info("Built config: " + path);
		file.load();
		Main.LOGGER.info("Loaded config: " + path);
		config.setConfig(file);
	}
	
}
