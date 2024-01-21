package com.bouquet.flowers;

public class PurpleJasmine extends Jasmine{
	
	String flowerColor = "purple";
	private int flowerPrice = 17;
	private int noOfFlowers;
	
	PurpleJasmine(int noOfFlowers){
		this.noOfFlowers= noOfFlowers;
	}
	
	@Override
	public int getPrice() {
		return noOfFlowers * flowerPrice;
	}
}
