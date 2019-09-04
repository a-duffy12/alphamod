package com.aduffy12.alphamod.blocks;

import java.util.Random;

import com.aduffy12.alphamod.init.AlphamodBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class CustomOreBlock extends OreBlock{

	public CustomOreBlock(Block.Properties properties) {
		super(properties);
		
	}	
		
	/*//leftover code from 1.13, do not want to delete yet
	@Override //drop function
	public Item getItemDropped(BlockState state, World worldIn, BlockPos pos, int fortune) {
		if (this == AlphamodBlocks.amber_ore) {
			return ItemList.amber;
	    } else {
	    	return this.asItem();
	    }
	}
	
	@Override //xp return function
	   public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune) {
	      World world = reader instanceof World ? (World)reader : null;
	      if (world == null || this.getItemDropped(state, world, pos, fortune) != this.asItem()) {
	         int i = 0;
	         if (this == AlphamodBlocks.amber_ore) {
	            i = MathHelper.nextInt(RANDOM, 3, 7);
	         }
	         return i;
	      }
	      return 0;
	   }
	   */
	
	//1.14 version of xp drop function
	public int getExpDrop(Random num) {
		 if (this == AlphamodBlocks.amber_ore) {
	         return MathHelper.nextInt(num, 3, 7);
		 } else {
			 return 0;
		 }
	}
	
}


