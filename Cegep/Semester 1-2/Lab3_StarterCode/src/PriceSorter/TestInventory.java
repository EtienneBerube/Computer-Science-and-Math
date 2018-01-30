package PriceSorter;

import java.util.Scanner;

import PriceSorter.Item.ItemType;

public class TestInventory {
	
	static final int MAX_ITEMS = 10;

	public static void main(String[] args) {
		
		Item[] myInventory = new Item[MAX_ITEMS];
		Item[] sortedInventory = new Item[MAX_ITEMS];
		
		Scanner input = new Scanner(System.in);
				
		//populate myInventory
		myInventory = populateInventory(myInventory, 10);
				
		//Query how user wants to sort the Inventory
		System.out.println("How would you like to view the inventory?");
		System.out.println("Enter 1 to sort from lowest price to highest price.");
		System.out.println("Enter 2 to sort from highest price to lowest price.");
		System.out.println("Enter 3 to sort in the brand's alphabetic order. (Low to High)");
		System.out.println("Enter 4 to sort in the brand's alphabetic order. (High to Low)");
		
		int choice = input.nextInt();
		
		switch (choice) {
		
			case 1: printInventory(sortInventory(SortHow.LH, myInventory)); break; //case 1 is low to high
			case 2: printInventory(sortInventory(SortHow.HL, myInventory)); break; //case 2 is high to low
			case 3:printInventory(sortInventory(SortHow.BLH, myInventory)); break; //case 2 is Brand (Low to high)
			case 4:printInventory(sortInventory(SortHow.BHL, myInventory)); break; //case 2 is Brand (High to Low)
			default: System.out.println("Your entry is invalid.");
		}
		
	

	}

	
	public static Item[] populateInventory(Item[] itemArray, int numItems) { //Done
	    //numItems is not used at this time
	    
		itemArray[0] = new Item(ItemType.BREAD, 3.99, "POM");
		itemArray[1] = new Item(ItemType.COOKIES, 5.99, "Keebler");
		itemArray[2] = new Item(ItemType.BREAD, 7.99, "Dave's Killer Bread");
		itemArray[3] = new Item(ItemType.COOKIES, 2.99, "Mrs. Field's");
		itemArray[4] = new Item(ItemType.FRUIT, 1.99, "Apple");
		itemArray[5] = new Item(ItemType.FRUIT, 3.99, "Mango");
		itemArray[6] = new Item(ItemType.MEAT, 10.99, "Filet Mignon");
		itemArray[7] = new Item(ItemType.JUICE, 4.99, "DelMonte");
		itemArray[8] = new Item(ItemType.SOUP, 0.99, "Campbell's");
		itemArray[9] = new Item(ItemType.VEGETABLES, 2.99, "Carrots");
		
		return itemArray;
	}
	
	
	public static void printInventory(Item[] itemArray) {
		System.out.printf("%-10s%-15s%-5s\n","Price","Type","Brand");
		for (int i = 0; i < itemArray.length; i++){
			System.out.printf("%1s%-9s%-15s%-4s\n","$",itemArray[i].getPrice(),itemArray[i].getType(),itemArray[i].getBrand());
		}
	}
	
	
	public static Item[] sortInventory(SortHow how, Item[] inputArray){
		switch (how){
		case LH:
			for (int i =0; i<inputArray.length; i++){
				double currentMin = inputArray[i].getPrice();
				int currentMinIndex = i;
				double currentMinObjectPrice = inputArray[i].getPrice();
				ItemType currentMinObjectType = inputArray[i].getType();
				String currentMinObjectBrand = inputArray[i].getBrand();
				Item temp;
				
				for (int j = (i +1); j<inputArray.length; j++  ){
					if (inputArray[j].getPrice() < currentMin){
						/*currentMinObjectPrice = inputArray[j].getPrice();
						currentMinObjectType = inputArray[j].getType();
						currentMinObjectBrand = inputArray[j].getBrand();*/
						currentMin=inputArray[j].getPrice();
						currentMinIndex=j;
						
					}
				}
					
					if (currentMinIndex != i){ // swap
						/*inputArray[currentMinIndex].setBrand(inputArray[i].getBrand());
						inputArray[currentMinIndex].setType(inputArray[i].getType());
						inputArray[currentMinIndex].setPrice(inputArray[i].getPrice());
						inputArray[i].setBrand(currentMinObjectBrand);
						inputArray[i].setPrice(currentMinObjectPrice);
						inputArray[i].setType(currentMinObjectType);*/
						temp = inputArray[i];
						inputArray[i] = inputArray[currentMinIndex];
						inputArray[currentMinIndex] = temp;
						
						
						
					}
				}
			
			break;
			
		
		case HL:
			
				for (int i =0; i<inputArray.length; i++){
					double currentMax = inputArray[i].getPrice();
					int currentMaxIndex = i;
					double currentMaxObjectPrice = inputArray[i].getPrice();
					ItemType currentMaxObjectType = inputArray[i].getType();
					String currentMaxObjectBrand = inputArray[i].getBrand();
					
					for (int j = (i +1); j<inputArray.length; j++  ){
						if (inputArray[j].getPrice() > currentMax){
							currentMaxObjectPrice = inputArray[j].getPrice();
							currentMaxObjectType = inputArray[j].getType();
							currentMaxObjectBrand = inputArray[j].getBrand();
							currentMax=inputArray[j].getPrice();
							currentMaxIndex=j;
						}
					}
						
						if (currentMaxIndex != i){ // swap
							inputArray[currentMaxIndex].setBrand(inputArray[i].getBrand());
							inputArray[currentMaxIndex].setType(inputArray[i].getType());
							inputArray[currentMaxIndex].setPrice(inputArray[i].getPrice());
							inputArray[i].setBrand(currentMaxObjectBrand);
							inputArray[i].setPrice(currentMaxObjectPrice);
							inputArray[i].setType(currentMaxObjectType);
							
							
						}
					}
				
			break;
				
				
		case BLH:
			for (int i =0; i<inputArray.length; i++){
				String currentMin = inputArray[i].getBrand();
				int currentMinIndex = i;
				double currentMinObjectPrice = inputArray[i].getPrice();
				ItemType currentMinObjectType = inputArray[i].getType();
				String currentMinObjectBrand = inputArray[i].getBrand();
				
				for (int j = (i +1); j<inputArray.length; j++  ){
					if (inputArray[j].getBrand().compareTo(currentMin) < 0 ){
						currentMinObjectPrice = inputArray[j].getPrice();
						currentMinObjectType = inputArray[j].getType();
						currentMinObjectBrand = inputArray[j].getBrand();
						currentMin=inputArray[j].getBrand();
						currentMinIndex=j;
					}
				}
					
					if (currentMinIndex != i){ // swap
						inputArray[currentMinIndex].setBrand(inputArray[i].getBrand());
						inputArray[currentMinIndex].setType(inputArray[i].getType());
						inputArray[currentMinIndex].setPrice(inputArray[i].getPrice());
						inputArray[i].setBrand(currentMinObjectBrand);
						inputArray[i].setPrice(currentMinObjectPrice);
						inputArray[i].setType(currentMinObjectType);
						
						
					}
				}
			
				
			
			break;
		case BHL:
			
			for (int i =0; i<inputArray.length; i++){
				String currentMin = inputArray[i].getBrand();
				int currentMinIndex = i;
				double currentMinObjectPrice = inputArray[i].getPrice();
				ItemType currentMinObjectType = inputArray[i].getType();
				String currentMinObjectBrand = inputArray[i].getBrand();
				
				for (int j = (i +1); j<inputArray.length; j++  ){
					if (inputArray[j].getBrand().compareTo(currentMin) > 0 ){
						currentMinObjectPrice = inputArray[j].getPrice();
						currentMinObjectType = inputArray[j].getType();
						currentMinObjectBrand = inputArray[j].getBrand();
						currentMin=inputArray[j].getBrand();
						currentMinIndex=j;
					}
				}
					
					if (currentMinIndex != i){ // swap
						inputArray[currentMinIndex].setBrand(inputArray[i].getBrand());
						inputArray[currentMinIndex].setType(inputArray[i].getType());
						inputArray[currentMinIndex].setPrice(inputArray[i].getPrice());
						inputArray[i].setBrand(currentMinObjectBrand);
						inputArray[i].setPrice(currentMinObjectPrice);
						inputArray[i].setType(currentMinObjectType);
						
						
					}
				}
			
				
			
			break;
			
		default: 
			break;
			
		}
		return inputArray;
	}


		
	public enum SortHow {
	    LH, HL , BLH, BHL
	    //LH means lowest to highest price
	    //HL means highest to lowest price
	}
	
}

