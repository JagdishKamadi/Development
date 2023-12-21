package com.bouquet.flowers;

public class WhiteRose extends Rose {
	
	private String flowerColor = "white";
	private int flowerPrice = 14;
	private int noOfFlowers;
	
	WhiteRose(int noOfFlowers){
		this. noOfFlowers = noOfFlowers;
	}
	
	@Override
	public int getPrice() {
		return noOfFlowers * flowerPrice;
	}
	
}
