package com.gift.children;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class giftOperations {
	
	public static void CalculateTotalWeight(ArrayList<GiftItem> childrenGifts) {
		float totalWeight = 0.0f;
		for(GiftItem item : childrenGifts) {
			totalWeight += item.getItemsWeight();
		}
		System.out.println("Total Weight of Gifts: " + totalWeight);
	}
	
	
		public static void performAction( ArrayList<GiftItem> childrenGifts, int choose) {
			switch(choose) {
			case 1:
				getPriceLesserThan(childrenGifts);
				break;
			case 2:
				getPriceGreaterThan(childrenGifts);
				break;
			case 3:
				getTotalNumberOfChocolates(childrenGifts);
				break;
			case 4:
				getTotalNumberOfSweets(childrenGifts);
				break;
			case 5:
				getTotalCandies(childrenGifts);
				break;
			default:
				System.out.println(" No given operation");
			}
		}
		
		public static void displayResultItems(HashSet<String> resultedItemNames) {
			for( String resultedItemName : resultedItemNames) {
				System.out.print(resultedItemName + " ");
			}
			System.out.println();
			
		}
	
		public static void getPriceLesserThan( ArrayList<GiftItem> childrenGifts) {
			
			System.out.println("Enter price :");
			int givenPrice = Gift.sc.nextInt();
			
			HashSet<String> resultedItemNames = new HashSet<>();
			for(GiftItem item : childrenGifts) {
				if(item.getSingleItemPrice() <= givenPrice) {
					resultedItemNames.add(item.getItemName());
				}
			}
			displayResultItems(resultedItemNames);
		}
		
		public static void getPriceGreaterThan( ArrayList<GiftItem> childrenGifts) {
			HashSet<String> resultedItemNames = new HashSet<>();
			System.out.println("Enter price :");
			int givenPrice = Gift.sc.nextInt();
			for(GiftItem item : childrenGifts) {
				if(item.getSingleItemPrice() >= givenPrice) {
					resultedItemNames.add(item.getItemName());
				}
			}
			displayResultItems(resultedItemNames);
		}

		
		public static int getTotalNumberOfSpecificItem(ArrayList<GiftItem> childrenGifts, String itemType) {
			int specificItemCount = 0;
			
			for(GiftItem item : childrenGifts) {
				if(item.getItemType().equals(itemType)) {
					specificItemCount += item.getItemCount();
				}
			}
			
			return specificItemCount;
		}
		
		public static void getTotalNumberOfChocolates( ArrayList<GiftItem> childrenGifts) {
			
			System.out.println("Total number of Chocolates: " + getTotalNumberOfSpecificItem(childrenGifts, "Chocolates"));
			
		}

		public static void getTotalNumberOfSweets( ArrayList<GiftItem> childrenGifts) {
		
			
			System.out.println("Total number of Sweets: " + getTotalNumberOfSpecificItem(childrenGifts, "Sweets"));
			
		}


		public static void getTotalCandies( ArrayList<GiftItem> childrenGifts) {
			
			int totalCandies = 0;
			for(GiftItem item : childrenGifts) {

				totalCandies += item.getItemCount();
			}
			System.out.println("Total Candies: " + totalCandies);
			
		}
	
	public static void findCandiesInGift(ArrayList<GiftItem> childrenGifts) {
		CalculateTotalWeight(childrenGifts);
		System.out.println(" Choose below\n  1. price lesser than given\n 2. price higher than given\n 3.Total chocolates\n 4.Total Sweets\n"
				+ " 5.Toatal candies");
		int choose = Gift.sc.nextInt();
		performAction( childrenGifts, choose);
		
	}
}
