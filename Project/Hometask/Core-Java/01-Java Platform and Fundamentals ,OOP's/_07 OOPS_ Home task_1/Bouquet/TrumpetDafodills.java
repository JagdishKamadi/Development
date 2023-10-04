package com.bouquet.flowers;

public class TrumpetDafodills extends Dafodills{
	
	private String flowerColor = "yellow";
	private int flowerPrice = 25;
	private int noOfFlowers;
	
	TrumpetDafodills(int noOfFlowers){
		this.noOfFlowers= noOfFlowers;
	}
	
	@Override
	public int getPrice() {
		return noOfFlowers * flowerPrice;
	}
}