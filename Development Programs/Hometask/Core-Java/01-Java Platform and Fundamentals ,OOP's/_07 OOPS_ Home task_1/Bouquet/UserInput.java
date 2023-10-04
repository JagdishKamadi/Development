package com.bouquet.flowers;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
	static Scanner sc = new Scanner(System.in);
	
	public static int getFlowerType() {
		System.out.println("Enter Flower Number: ");
		int flowerType = sc.nextInt();
		return flowerType;
		
	}
	
	public static int getNoOfFlowers() {
		System.out.println("Enter Number of Flowers: ");
		int flowerType = sc.nextInt();
		return flowerType;
	}
	
	public static Flower addingFlower(int flowerType, int noOfFlowers) {
		switch(flowerType){
		case 1:
			return new RedRose(noOfFlowers);
		case 2:
			return new WhiteRose(noOfFlowers);
		case 3:
			return new PinkRose(noOfFlowers);
		case 4:
			return new LargeCupDafodills(noOfFlowers);
		case 5:
			return new TrumpetDafodills(noOfFlowers);
		case 6:
			return new PurpleJasmine(noOfFlowers);
		case 7:
			return new PinkJasmine(noOfFlowers);
		default:
			return null;
		}
	}
	
	public static boolean flowerNotNull(Flower flower) {
		return flower != null;
	}
	
	public static boolean addMoreFlowers() {
		System.out.println("Want to add More flowers yes/no");
		String addMoreStatus = sc.next();
		if(addMoreStatus.equals("yes")) {
			return true;
		}
		return false;
	}
	
	public static ArrayList<Flower> addFlowers() {
		ArrayList<Flower> flowers = new ArrayList<>();
		boolean addMoreStatus = true;
		System.out.println(" 1.RedRose\n 2.WhiteRose\n 3.PinkRose\n 4.LargeCupDafodills\n 5.TrumpetDafodills\n"
				+ " 6.PurpleJasmine\n 7.PinkJasmine");
		
		while(addMoreStatus) {
			Flower flower = addingFlower(getFlowerType(), getNoOfFlowers());
			if(flowerNotNull(flower))
				flowers.add(flower);
			addMoreStatus = addMoreFlowers();
		}
		return flowers;
	}
}
