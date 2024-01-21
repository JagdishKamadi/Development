package com.gift.children;

public class DairyMilk extends Chocolates{
	
	private String itemName = "Dairy Milk";
	private int itemPrice = 80;   
	private float itemWeightInGrams = 145.45f;
	private int itemCount;
	
	DairyMilk(int count){
		this.itemCount = count;
	}
	
	public int getItemsPrice() {
		return itemCount * itemPrice;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	public float getItemsWeight() {
		return itemCount * itemWeightInGrams;
	}
	@Override
	public int getSingleItemPrice() {
		return itemCount;
	}
}
