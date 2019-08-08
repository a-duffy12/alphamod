package com.aduffy12.alphamod;

import com.aduffy12.alphamod.lists.AlphamodItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AlphaModItemGroup extends ItemGroup {

	public AlphaModItemGroup(int index, String label) {
		super(index, "alphamod");	
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(AlphamodItems.amber);
	}

}
