package com.bouquet.flowers;

public class LargeCupDafodills extends Dafodills{
	
	private String flowerColor = "yellow";
	private int flowerPrice = 20;
	private int noOfFlowers;
	
	LargeCupDafodills(int noOfFlowers){
		this.noOfFlowers= noOfFlowers;
	}
	
	@Override
	public int getPrice() {
		return noOfFlowers * flowerPrice;
	}
}