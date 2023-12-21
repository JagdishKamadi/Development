package com.gift.children;

public class Rasgulla extends Sweets{
	
	private String itemName = "Rasgulla";
	private int itemPrice = 20;  //weight = 14g;
	private float itemWeightInGrams = 14f;
	private int itemCount;
	
	Rasgulla(int count){
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
