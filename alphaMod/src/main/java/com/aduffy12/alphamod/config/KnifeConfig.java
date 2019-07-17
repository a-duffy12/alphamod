package com.aduffy12.alphamod.config;

import net.minecraftforge.common.ForgeConfigSpec;;

public class KnifeConfig {
	
	public static ForgeConfigSpec.IntValue knife_attack_damage;
	public static ForgeConfigSpec.IntValue knife_attack_speed;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		
		server.comment("Knife Config");
		
		knife_attack_damage = server
				.comment("Base damage of a knife, will adjust all types of knives equally. Default is 0")
				.defineInRange("knife.knife_damage", 0, -2, 10);
		
		knife_attack_speed = server
				.comment("Base attack speed of a knife, in hits per second. Default is 4")
				.defineInRange("knife.knife_speed", 4, -4, 16);
		
	}

}
