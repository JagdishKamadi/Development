package com.gift.children;

public class FerroroRocher extends Chocolates {
	private String itemName = "FerroRocher";
	private int itemPrice = 20;
	private float itemWeightInGrams = 10f;
	private int itemCount;
	
	FerroroRocher(int count){
		this.itemCount = count;
	}
	
	public int getItemsPrice() {
		return itemCount * itemPrice;
	}
	
	public float getItemsWeight() {
		return  itemCount * itemWeightInGrams;
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