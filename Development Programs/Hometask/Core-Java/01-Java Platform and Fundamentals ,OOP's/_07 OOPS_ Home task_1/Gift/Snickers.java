package com.gift.children;

public class Snickers extends Chocolates{
	private String itemName = "Snickers";
	private int itemPrice = 30; 
	private float itemWeightInGrams = 45f;
	private int itemCount;
	
	Snickers(int count){
		this.itemCount = count;
	}
	
	public int getItemsPrice() {
		return itemCount * itemPrice;
	}
	
	public float getItemsWeight() {
		return itemCount * itemWeightInGrams;
	}
	
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
