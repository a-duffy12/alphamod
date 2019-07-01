package com.aidz.alphamod.blocks;

import com.aidz.alphamod.lists.BlockList;
import com.aidz.alphamod.lists.ItemList;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockCustomOre extends BlockOre{

	public BlockCustomOre(Properties builder) {
		super(builder);
		
	}	
		
	@Override //drop function
	public Item getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		if (this == BlockList.amber_ore) {
			return ItemList.amber;
	    } else {
	    	return this.asItem();
	    }
	}
	
	@Override //xp return function
	   public int getExpDrop(IBlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune) {
	      World world = reader instanceof World ? (World)reader : null;
	      if (world == null || this.getItemDropped(state, world, pos, fortune) != this.asItem()) {
	         int i = 0;
	         if (this == BlockList.amber_ore) {
	            i = MathHelper.nextInt(RANDOM, 3, 7);
	         }
	         return i;
	      }
	      return 0;
	   }
	
}


