package com.gift.children;

public class KitKat extends Chocolates{
	private String itemName = "KitKat";
	private int itemPrice = 25;  
	private float itemWeightInGrams = 38.5f;
	private int itemCount;
	KitKat(int count){
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