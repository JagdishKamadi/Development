package com.gift.children;

public class Palkova extends Sweets{
	
	private String itemName = "Palkova";
	private int itemPrice = 12;  
	private float itemWeightInGrams = 12f;
	private int itemCount;
	
	Palkova(int count){
		this.itemCount = count;
	}
	
	public int getItemsPrice() {
		return itemCount * itemPrice;
	}
	
	public float getItemsWeight() {
		return itemCount * itemWeightInGrams;
	}
	
	@Override
	public String getItemName() {
		return itemName;
	}
	@Override
	public int getSingleItemPrice() {
		return itemPrice;
	}

	@Override
	public int getItemCount() {
		return itemCount;
	}
}