package com.aduffy12.alphamod.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;

@net.minecraftforge.registries.ObjectHolder("minecraft")
public class AlphamodSoundEvents {

	private static SoundEvent register(String key) {
	      return Registry.register(Registry.SOUND_EVENT, key, new SoundEvent(new ResourceLocation(key)));
	}
	
	public static final SoundEvent ITEM_ARMOR_EQUIP_BONE = register("item.armor.equip_bone");
}
