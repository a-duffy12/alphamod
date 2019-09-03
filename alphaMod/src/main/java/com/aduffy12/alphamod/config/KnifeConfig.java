package com.aduffy12.alphamod.config;

import net.minecraftforge.common.ForgeConfigSpec;;

public class KnifeConfig {
	
	public static ForgeConfigSpec.IntValue knife_attack_damage;
	public static ForgeConfigSpec.IntValue knife_attack_speed;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		
		server.comment("Knife Config");
		
		//change knife damage
		knife_attack_damage = server
				.comment("Base damage of a knife, will adjust all types of knives equally. Default is 0, which corresponds to 2 damage above the material's base")
				.defineInRange("knife.knife_damage", 0, -2, 10);
		
		//change knife speed
		knife_attack_speed = server
				.comment("Base attack speed of a knife, in hits per second. Default is 4, which corresponds to 8h/s")
				.defineInRange("knife.knife_speed", 4, -4, 16);
		
	}

}
