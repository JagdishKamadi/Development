package com.gift.children;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Chocolates implements GiftItem{
	protected String itemType = "Chocolates";
	public String getItemType() {
		return itemType;
	}
}

abstract class Sweets implements GiftItem{
	protected String itemType = "Sweets";
	public String getItemType() {
		return itemType;
	}
	
}

class CustomCom implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		return ((GiftItem) o1).getItemName().compareTo(((GiftItem) o2).getItemName());
	}
}


public class Gift {
	static Scanner sc = new Scanner(System.in);
	
	
	public static String childName() {
		
		System.out.println("Enter child Name: ");
		String name = sc.next();
		return name;
	}
	
	public static int numberOfChildren() {
		
		System.out.println("Enter number of Children: ");
		int noOfChildren = sc.nextInt();
		return noOfChildren;
	}

	public static void main(String[] args) {
		int noOfChildren;
		noOfChildren = numberOfChildren();
		
		ArrayList<GiftItem> childrenGifts = new ArrayList<>();
		
		for(int i = 0; i < noOfChildren; i++ ) {
			childrenGifts.addAll(UserInput.chooseItems());
		}
		Collections.sort(childrenGifts, new CustomCom());
		giftOperations.findCandiesInGift(childrenGifts);
		
		sc.close();	

	}

}


