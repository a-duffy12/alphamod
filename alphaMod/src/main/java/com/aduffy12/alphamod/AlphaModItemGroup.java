package com.aduffy12.alphamod;

import com.aidz.alphamod.lists.ItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AlphaModItemGroup extends ItemGroup {

	public AlphaModItemGroup(int index, String label) {
		super(index, "alphamod");	
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(ItemList.amber);
	}

}
