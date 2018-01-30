package machine;
import java.util.Scanner;
public class VendingMachine { // This program is a simulation of a typical vending machine, so the user will have to choose which item he wants and pay the correct amount for the item
							  // The user will choose the item and needs to enter the correct amount or more than the price of the object
							  // if the user enter # when the system asks him to press Enter, he will enter the Admin mode
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Items[] itemList = new Items[9]; // Array initializing
		populate(itemList);
		
		int systemLoop = 1;
		int end;
		
		//Template
		massBuy(itemList[0], 15); 
		massBuy(itemList[1], 12);
		massBuy(itemList[2], 18);
		massBuy(itemList[3], 2);
		massBuy(itemList[4], 11);
		massBuy(itemList[5], 13);
		massBuy(itemList[6], 8);
		massBuy(itemList[7], 9);
		massBuy(itemList[8], 20);
		
		
	do{ // system loop, we can never exit this loop
		do{ // user loop the admin can exit this loop
		
			printList(itemList); // the list is printed
		
		System.out.print("Please enter the Code for the item that would satisfy your desire: ");
		String switchChoice = input.next();
		switchChoice = switchChoice.toUpperCase();
		
		switch(switchChoice){
		
		case "A1": buy(itemList[0]);
			break;
		
		case "A2":buy(itemList[1]);
			break;
		
		case "A3":buy(itemList[2]);
			break;
		
		case "B1":buy(itemList[3]);
			break;
		
		case "B2":buy(itemList[4]);
			break;
		
		case "B3":buy(itemList[5]);
			break;
		
		case "C1":buy(itemList[6]);
			break;
		
		case "C2":buy(itemList[7]);
			break;
		
		case "C3":buy(itemList[8]);
			break;
			
		default: System.out.println("Invalid Input");
			break;
		
		}
		end = 0; // end of user loop
		
		System.out.print("Press any Enter to continue: ");
		String admin = input.nextLine();
		admin = input.nextLine(); //To stop it from eating anything else
		
		System.out.println("");
		
		if(admin.isEmpty() == false){
		char temp = admin.charAt(0);
	
			if (temp == '#'){
				end = 1;
			}
		}
		
	
	}while(end == 0); // start of admin section
		System.out.println("[Admin Mode]");
		printQuantity(itemList);
		System.out.println("Do you want to refill? (Y/N): ");
		String choice = input.next();
		
		choice = choice.toUpperCase();
		char yn = choice.charAt(0);
		
		while (yn != 'Y'&& yn != 'N'){
			System.out.println("Invalid input, try again: ");
			choice = input.next();
			choice = choice.toUpperCase();
			yn = choice.charAt(0);
		}
		
		if (yn =='Y'){
			 for (int i = 0; i < itemList.length; i++){ 
				itemList[i].refill(); // sets every item quantity to 20
			 }
			 System.out.println("The System have been refilled to initial stock (20 per item)");
		 }
		
	}while(systemLoop ==1);
	
}
	
	static void populate(Items[] x){ // this method populates the array, this makes the program cleaner in the main method
		x[0] = new Items("Kit-Kat",1.50);
		x[1] = new Items("Hershey's",1.00);
		x[2] = new Items("Skittle",2.00);
		x[3] = new Items("Fuzzy Peach",1.50);
		x[4]  = new Items("Oh Henry",1.50);
		x[5] = new Items("M&M",1.00);
		x[6] = new Items("Reese",2.50);
		x[7]  = new Items("Gatorade",3.00);
		x[8]  = new Items("Cherry Blossom",0.50);
	}
	
	static void buy(Items x){ // this method is a crucial point in the program, this method contains every action that makes the user buy the item
		Scanner input = new Scanner(System.in);
		if(x.getQuantity() > 0) {
		System.out.printf("\nThe price is: %1.2f$\nPayment methods:", x.getPrice() );
	
		
		double amount = x.getPrice();
		while (amount > 0){
			
			double[] payment = {0.05, 0.10, 0.25, 1.00, 2.00, 5.00, 10.00, 20.00}; // the user can only choose between real payment option in a vending machine
			for (int i = 0; i < payment.length; i++){
				System.out.printf("\n%1d) %1.2f$",(i+1),payment[i]);
			}
			System.out.print("\nEnter the respective number for the payment you want: ");
			String s = input.next();
		
			while (s.equals("1") == false && s.equals("2") == false  && s.equals("3") == false && s.equals("4") == false  && s.equals("5") == false  && s.equals("6") == false  && s.equals("7") == false  && s.equals("8") == false ){
				System.out.print("Wrong input, try again: ");
				s = input.next();
			}
			
			int switchChoice = Integer.parseInt(s);
			--switchChoice;
			amount -= payment[switchChoice];
			
			if (amount > 0 ){
			System.out.printf("\n%1.2f$ missing\n",amount);
			}
		}
		
		x.buy(); // Actually buying the item
		amount = Math.abs(amount);
		amount = amount *100;
		int remainingAmmount = (int)(amount);
		if (amount != 0){
			
			int loony = remainingAmmount/100;
			remainingAmmount = remainingAmmount%100;
			
			int quarter = remainingAmmount/25;
			remainingAmmount = remainingAmmount%25;
			
			int dime = remainingAmmount/10;
			remainingAmmount = remainingAmmount%10;
			
			int nickel = remainingAmmount/5;
			
			System.out.println("\nHere is your change:\n 1$: " + loony + "\n 25¢: " + quarter + "\n 10¢: " + dime + "\n 5¢: " + nickel); // like a real vending machine, if the user enters more than what he is supposed, 
																																	   //the machine will give him back the change
		
		}
			System.out.println("Here is your item: " + x.getName());
		}else{
		System.out.println("There's no more of this item");	
		}
	
	}
	
	static void printList(Items[] x){ //This method prints the entire list of items in the machine
		String[] slots = {"A1","A2","A3","B1","B2","B3","C1","C2","C3"};
		System.out.printf("%-6s%-18s%-1s\n","Code", "Name","Price");
		System.out.println("-----------------------------");
		for (int i = 0; i < x.length; i++){
			System.out.printf(" %-5s%-18s%-1.2f$\n",slots[i], x[i].getName(),x[i].getPrice());
			System.out.println("-----------------------------");
		}
		System.out.println("");
	}
	
	static void printQuantity(Items[] x){ // This method prints the list of objects, but only with the name and the quantity of items
		System.out.printf("%-18s%-1s\n", "Name","Quantity");
		System.out.println("--------------------------");
		for (int i = 0; i < x.length; i++){
			System.out.printf("%-18s%6d\n", x[i].getName(),(int)(x[i].getQuantity()));
			System.out.println("--------------------------");
		}
		System.out.println("");
	}
	
	static void massBuy(Items x, int y){ // this method is like a preset, since we want a realistic simulation, this item pre-buys some items so that the machine isn't full
		for (int i = 0; i<y;i++){
			x.buy();
			}
	}
	
	
}
