package com.gift.children;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class UserInput {
	
	
	public static boolean itemNotNull(GiftItem item) {
		return item != null;
	}
	
	public static boolean addMore() {
		System.out.println("Add more: (yes/ no)");
		if(Gift.sc.next().equals("yes")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int itemNumber() {
		System.out.println("Enter Item Number");
		int itemNo = Gift.sc.nextInt();
		 return  itemNo; 
	}
	
	public static int numberOfPieces() {
		System.out.println("Enter number of pieces");
		int noOfPieces = Gift.sc.nextInt();
		return noOfPieces;
	}
	
	public static ArrayList<GiftItem> chooseItems(){
		ArrayList<GiftItem> items = new ArrayList<>();
		boolean haveMore = true;
		System.out.println("1.Ferroro Rocher\n 2. DairyMilk\n 3.Snickers \n 4.KitKat\n "
				
				+ "5. MysorePak\n 6. Rasgulla\n 7.Palkova");
		while(haveMore) {
			int itemNumber = itemNumber();
			int noOfPieces = numberOfPieces();
			GiftItem item = addingSelectedItem(itemNumber, noOfPieces);
			if(itemNotNull(item))
				items.add(item);
			haveMore = addMore();
		}
		
		return items;
	}
	
	public static GiftItem addingSelectedItem(int itemNumber, int noOfPieces) {
		switch(itemNumber) {
		case 1:
			return new FerroroRocher(noOfPieces);
		case 2:
			return new DairyMilk(noOfPieces);
		case 3:
			return new Snickers(noOfPieces);
		case 4:
			return new KitKat(noOfPieces);
		case 5:
			return new MysorePak(noOfPieces);
		case 6:
			return new Rasgulla(noOfPieces);
		case 7:
			return new Palkova(noOfPieces);
		default:
			return null;
		}
	}

}