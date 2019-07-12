package com.aduffy12.alphamod.lists;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import com.aduffy12.alphamod.Main;

import net.minecraft.init.Items;

public enum AlphamodArmorMaterials implements IArmorMaterial{
	
	bone("bone", 22, new int[] {1, 4, 5, 2}, 5, Items.BONE, "entity.skeleton.ambient", 0.0f) //TODO custom equip sound
	;
	
	private String name, equipSound;
	private int durability, enchantability;
	private float toughness;
	private Item repairItem;
	private int[] damageReductionAmount;
	public static final int[] max_damage_array = new int[] {13, 15, 16, 11};
	
	private AlphamodArmorMaterials(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem, String equipSound, float toughness) {
		
		//setting all the parameters
		this.name = name;
		this.durability = durability;
		this.damageReductionAmount = damageReductionAmount;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.equipSound = equipSound;
		this.toughness = toughness;
	}

	@Override //GETTER
	public int getDurability(EntityEquipmentSlot slotIn) {
		
		return max_damage_array[slotIn.getIndex()]*this.durability;
	}

	@Override //GETTER
	public int getDamageReductionAmount(EntityEquipmentSlot slotIn) {
		
		return this.damageReductionAmount[slotIn.getIndex()];
	}

	@Override //GETTER
	public int getEnchantability() {
		
		return this.enchantability;
	}

	@Override //GETTER
	public SoundEvent getSoundEvent() {
		
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override //GETTER
	public Ingredient getRepairMaterial() {
		
		return Ingredient.fromItems(this.repairItem);
	}

	@Override //GETTER
	public String getName() {
		
		return Main.MOD_ID+":"+this.name;
	}

	@Override //GETTER
	public float getToughness() {
		
		return this.toughness;
	}

}
