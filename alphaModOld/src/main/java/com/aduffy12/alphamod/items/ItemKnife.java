package com.aduffy12.alphamod.items;

import com.aduffy12.alphamod.config.KnifeConfig;
import com.google.common.collect.Multimap;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTiered;
import net.minecraft.item.TieredItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemKnife extends TieredItem {
   private final float attackDamage;
   private final float attackSpeed;

   public ItemKnife(IItemTier tier, float attackDamage, float attackSpeedIn, Item.Properties builder) {
      super(tier, builder);
      this.attackSpeed = (float)KnifeConfig.knife_attack_speed.get();
      this.attackDamage = (float)KnifeConfig.knife_attack_damage.get() + tier.getAttackDamage();
   }

   public float getAttackDamage() {
      return this.attackDamage;
   }

   public boolean canPlayerBreakBlockWhileHolding(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player) {
      return !player.isCreative();
   }

   //knives are good for cutting vegetation super fast
   public float getDestroySpeed(ItemStack stack, IBlockState state) {
      Material material = state.getMaterial();
      return material != Material.PLANTS && material != Material.VINE && material != Material.CACTUS && material != Material.OCEAN_PLANT && material != Material.SEA_GRASS && material != Material.CORAL && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 10.0F : 15.0F;
      
   }

   //does 2 durability when hitting entities, drawback of hitting so fast
   public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
      stack.damageItem(2, attacker);
      return true;
   }

   //what happens when you destroy a block, costs more durability, at 3 each
   public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
      if (state.getBlockHardness(worldIn, pos) != 0.0F) {
         stack.damageItem(3, entityLiving);
      }

      return true;
   }

   // can harvest vines, grass and (TEST) glass
   public boolean canHarvestBlock(IBlockState blockIn) {
      return blockIn.getBlock() == Blocks.VINE && blockIn.getBlock() == Blocks.GRASS;
   }
   
   //some shit that seems integral to making them work correctly, idk why
   public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
      @SuppressWarnings("deprecation")
	Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
      if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
         multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
         multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, 0));
      }

      return multimap;
   }

}