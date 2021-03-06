package com.aduffy12.alphamod.items;

import com.aduffy12.alphamod.config.KnifeConfig;
import com.google.common.collect.Multimap;

import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

   public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      return !player.isCreative();
   }

   //knives are good for cutting vegetation super fast
   public float getDestroySpeed(ItemStack stack, BlockState state) {
      Material material = state.getMaterial();
      return material != Material.PLANTS && material != Material.BAMBOO && material != Material.BAMBOO_SAPLING && material != Material.TALL_PLANTS && material != Material.CACTUS && material != Material.OCEAN_PLANT && material != Material.SEA_GRASS && material != Material.CORAL && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 10.0F : 15.0F;
      
   }

   //TODO
   /*
   
   //does 2 durability when hitting entities, drawback of hitting so fast
   public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      stack.damageItem(2, attacker);
      return true;
   }

   //what happens when you destroy a block, costs more durability, at 3 each
   public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
      if (state.getBlockHardness(worldIn, pos) != 0.0F) {
         stack.damageItem(3, entityLiving);
      }

      return true;
   }

   // can harvest vines, grass and (TEST) glass
   public boolean canHarvestBlock(BlockState blockIn) {
      return blockIn.getBlock() == Blocks.VINE && blockIn.getBlock() == Blocks.GRASS;
   }
   
   //some shit that seems integral to making them work correctly, idk why
   public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
      @SuppressWarnings("deprecation")
	Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
      if (equipmentSlot == EquipmentSlotType.MAINHAND) {
         multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
         multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, 0));
      }

      return multimap;
   } */

}