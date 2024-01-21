package com.bouquet.flowers;

public class PinkJasmine extends Jasmine{
	
	private String flowerColor = "pink";
	private int flowerPrice = 21;
	private int noOfFlowers;
	
	PinkJasmine(int noOfFlowers){
		this.noOfFlowers= noOfFlowers;
	}
	
	@Override
	public int getPrice() {
		return noOfFlowers * flowerPrice;
	}
}
