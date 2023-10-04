package com.bouquet.flowers;

public class PinkRose extends Rose {
	
	private String flowerColor = "pink";
	private int flowerPrice = 16;
	private int noOfFlowers;
	
	PinkRose(int noOfFlowers){
		this.noOfFlowers= noOfFlowers;
	}
	
	@Override
	public int getPrice() {
		return noOfFlowers * flowerPrice ;
	}
}
