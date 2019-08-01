package com.aduffy12.alphamod.blocks;

import com.aduffy12.alphamod.lists.AlphamodBlocks;
import com.aduffy12.alphamod.lists.ItemList;

import net.minecraft.block.OreBlock;
import net.minecraft.block.state.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockCustomOre extends OreBlock{

	public BlockCustomOre(Properties builder) {
		super(builder);
		
	}	
		
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
	
}


