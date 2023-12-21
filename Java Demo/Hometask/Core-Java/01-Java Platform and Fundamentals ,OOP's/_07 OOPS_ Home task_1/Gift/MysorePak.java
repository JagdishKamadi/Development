package com.gift.children;

public class MysorePak extends Sweets{
	
	private String itemName = "Mysore Pak";
	private int itemPrice = 15;  
	private float itemWeightInGrams = 20f;
	private int itemCount;
	
	MysorePak(int count){
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