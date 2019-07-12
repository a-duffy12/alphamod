package com.aduffy12.alphamod.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;


public enum AlphamodToolMaterials implements IItemTier {

	amber(7.0f, 7.0f, 97, 1, 18, ItemList.amber),
	obsidian(4.0f, 5.0f, 8193, 3, 12, ItemList.obsidian_shard)
	;
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchanability;
	private Item repairMaterial;
	
	private AlphamodToolMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		
		//setting all the parameters
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchanability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override //GETTER
	public float getAttackDamage() {
		
		return this.attackDamage;
	}

	@Override //GETTER
	public float getEfficiency() {
		
		return this.efficiency;
	}

	@Override //GETTER
	public int getEnchantability() {
		
		return this.enchanability;
	}

	@Override //GETTER
	public int getHarvestLevel() {
		
		return this.harvestLevel;
	}

	@Override //GETTER
	public int getMaxUses() {
		
		return this.durability;
	}

	@Override //GETTER
	public Ingredient getRepairMaterial() {
		
		return Ingredient.fromItems(this.repairMaterial);
	}
	
	public void setMaxUses(int a) {
		this.durability = a;
	}
	
}
