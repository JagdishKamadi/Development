package com.bouquet.flowers;

public class RedRose extends Rose {
	
	private String flowerColor = "red";
	private int flowerPrice = 15;
	private int noOfFlowers;
	
	RedRose(int noOfFlowers){
		this. noOfFlowers = noOfFlowers;
	}

	@Override
	public int getPrice() {
		return noOfFlowers * flowerPrice;
	}
	
}
