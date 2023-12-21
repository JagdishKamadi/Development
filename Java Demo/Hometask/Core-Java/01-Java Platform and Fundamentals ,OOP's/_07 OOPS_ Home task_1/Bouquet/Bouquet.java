package com.bouquet.flowers;

import java.util.ArrayList;
import java.util.List;

abstract class Rose implements Flower{
	protected String flowerName = "Rose";
}

abstract class Dafodills implements Flower{
	protected String flowerName = "Dafodills";
}

abstract class Jasmine implements Flower{
	protected String flowerName = "Jasmine";
}

public class Bouquet {
	
	public static void totalCost(List<Flower> bouquet) {
		int totalCostOfBouquet = 0;
		for(Flower flower : bouquet) {
			totalCostOfBouquet += flower.getPrice();
		}
		System.out.println("Total cost of Bouquet (Rupees): "+ totalCostOfBouquet);
	}
	
	public static void main(String[] args) {
		List<Flower> bouquet = new ArrayList<>();
		bouquet = UserInput.addFlowers();
		totalCost(bouquet);
		UserInput.sc.close();
	}
}
