package atm_Library;
import atm_Library.*;

import java.util.Scanner;


public class Atm_Library_Test {

	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		//books and user section
		LibraryEbook book1 = new LibraryEbook("Bible", "God", "Spiritual", 2088, "978-2-608-12511-8");
		LibraryEbook book2 = new LibraryEbook("The legend of the secret Babybel", "Drake", "Thriller", 35,"978-2-608-12511-9" );
		LibraryEbook book3 = new LibraryEbook("The lost cow", "Michael Phelps", "Kids", 1032, "978-2-608-12511-7");
		LibraryEbook book4 = new LibraryEbook("Do Unicorns exist?", "Luis Vergerado", "Scientific", 3834, "978-2-608-12511-6");
		LibraryEbook book5 = new LibraryEbook("Hitler, a hidden lover", "Pritt Glue", "Kids", 344, "978-2-608-12511-0");
		LibraryEbook book6 = new LibraryEbook("Enium paper", "Jay-Z", "Scientific", 37, "978-2-608-12511-3");
		LibraryEbook book7 = new LibraryEbook("How to pick up women", "Myriem Elmahboubi", "Scientific", 57, "978-2-608-12511-2");
		LibraryEbook book8 = new LibraryEbook("The island of unknown sounds", "Merry Sunner", "Thriller", 756, "978-2-608-12511-1");
		LibraryEbook book9 = new LibraryEbook("The lost truth", "Daniel Johnson", "Spiritual", 328, "978-2-608-12511-5");
		LibraryEbook book10 = new LibraryEbook("Everyone poops", "Brandy Swingly", "Kids", 24, "978-2-608-12511-4");
	
		LibraryEbook[] bookList = new LibraryEbook[10];
		bookList[0] = book1;
		bookList[1] = book2;
		bookList[2] = book3;
		bookList[3] = book4;
		bookList[4] = book5;
		bookList[5] = book6;
		bookList[6] = book7;
		bookList[7] = book8;
		bookList[8] = book9;
		bookList[9] = book10;
		
		LibraryUser user1 = new LibraryUser("John Molson", "17 rue des Connifères", 166791 , 57, "M");
		LibraryUser user2 = new LibraryUser("Sylvie Barbant", " 32 blv des Mouchons", 194382 , 76, "F");
		LibraryUser user3 = new LibraryUser("Little Johnny", "1998 chemin des poules", 2141268, 6, "M");
		LibraryUser user4 = new LibraryUser("Samantha Belly", "164 rue des colles", 201591 , 32, "F");
		LibraryUser user5 = new LibraryUser("Etienne Berube", "1947 rue de Paris", 123456, 18, "M");
		
		LibraryUser[] currentUsers = new LibraryUser[5];
		currentUsers[0] = user1;
		currentUsers[1] = user2;
		currentUsers[2] = user3;
		currentUsers[3] = user4;
		currentUsers[4] = user5;
		
		//presets
		user1.rentBook(book9);
		book5.setRentedOwner(user1);
		book5.setRentTime(System.currentTimeMillis() - 14688000);
		
		user1.rentBook(book7);
		book7.setRentedOwner(user1);
		book7.setRentTime(System.currentTimeMillis() - 1987200000);
		
		user2.rentBook(book1);
		book1.setRentedOwner(user2);
		book1.setRentTime(System.currentTimeMillis() - 267200000);
		
		user3.rentBook(book3);
		book3.setRentedOwner(user3);
		book3.setRentTime(System.currentTimeMillis() - 202020000);
		
		user3.rentBook(book10);
		book10.setRentedOwner(user3);
		book10.setRentTime(System.currentTimeMillis() - 12960000);
		
		user3.rentBook(book5);
		book5.setRentedOwner(user3);
		book5.setRentTime(System.currentTimeMillis() - 29872000);
		
		user4.reserveBook(book6);
		book6.setRentedOwner(user4);
		
		
		
		
		
		//Variables
		int switchChoice = 0;
		String nullChoice;
		char choice;
		String name;
		int id;
		
		System.out.println("***************************************************************************");
		System.out.println("*                                                                         *");
		System.out.println("*                                                                         *");
		System.out.println("*                        Online Library Project                           *");
		System.out.println("*                                                                         *");
		System.out.println("*                        Press Enter to continue                          *");
		System.out.println("*                                                                         *");
		System.out.println("*                                                                         *");
		System.out.println("*                                                                         *");
		System.out.println("***************************************************************************");
		nullChoice = input.nextLine();
		
		System.out.println("Please enter your name");
		name = input.nextLine();
		
		
		System.out.println("Please enter your id");
		id = input.nextInt();
		
		if (name.equals("Etienne") && id == 123456){//******************************************************************************************************************************************
		do{
		System.out.println("\nWhat do you want to do? \n 1) See the Ebook library \n 2) Rent/Return/Reserve a Book \n 3) Pay the fees \n 4) See Your profil \n 5) Exit");
		System.out.print("Enter the respective number of the action: ");
		switchChoice = input.nextInt();
		
		while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3 && switchChoice != 4){
			System.out.println("Invalid input, try again");
			switchChoice = input.nextInt();
		}
		
		switch (switchChoice){
		case 1: System.out.println("\nwhat do you want to do? \n 1) See all the Ebooks \n 2) See the available Ebooks \n 3) Search for a book by genre"); 
				System.out.print("Enter the respective number of the action: ");
				switchChoice = input.nextInt();
				
				while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3){
					System.out.println("Invalid input, try again");
					switchChoice = input.nextInt();
				}
		
				switch (switchChoice){
					case 1: printEbookList(bookList);
							break;
					case 2: printAvailabilityList(bookList);
							break;
					case 3: System.out.println("\nEnter the respective number of the genre: \n 1) Spiritual \n 2) Thriller \n 3) Scientific \n 4) Kids");
							System.out.print("Enter the respective number of the action: ");		
							switchChoice = input.nextInt();
							
							while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3 && switchChoice != 4){
								System.out.println("Invalid input, try again");
								switchChoice = input.nextInt();
							}
								switch (switchChoice){
									case 1: printInfoByGenre(bookList, "Spiritual");
											break;
									case 2: printInfoByGenre(bookList, "Thriller");
											break;
									case 3: printInfoByGenre(bookList, "Scientific");
											break;
									case 4: printInfoByGenre(bookList, "Kids");
											break;
								}
							break;
				}
						break;
		case 2: System.out.println("\nWhat do you want to do? \n 1) Rent an Ebook \n 2) Return an Ebook \n 3) Reserve an Ebook"); 
				System.out.print("Enter the respective number of the action: ");
				switchChoice = input.nextInt();
				
				while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3){
					System.out.println("Invalid input, try again");
					switchChoice = input.nextInt();
				}
				
				switch (switchChoice){
				case 1: System.out.print("\nEnter the respective Ebook number:\n");
						printNameAvailabilityList(bookList);
						switchChoice = input.nextInt();
						
						--switchChoice;
						while (bookList[switchChoice].getAvailability() != "Available" ){
								System.out.println("Book not available, try again");
								switchChoice = input.nextInt();
								--switchChoice;
						}
								
							user5.rentBook(bookList[(switchChoice)]);
							bookList[(switchChoice)].setRentedOwner(user5);
							System.out.println("\nYou have rented the Ebook: " + bookList[(switchChoice)].getName());
							System.out.println("\n You have two weeks to return this EBook, the fees are of 2$/day if it is late");
							break;
				
				case 2: printEbookOwnedByUser(bookList, user5); //******************************************************DOESNT WORK, NO ARRAY FOR RENTED BOOK
						System.out.print("\nEnter the respective Ebook number:");
						switchChoice = input.nextInt();
						switchChoice--;
						user5.returnBook(bookList[(switchChoice)]);
						break;
				case 3:	printEbookReservableList(bookList);
						System.out.print("\nEnter the respective Ebook number:");
						switchChoice = input.nextInt();
						user5.reserveBook(bookList[(switchChoice-1)]);
				}
				
				break;
		case 3: calculateTotalFees(bookList, user5);
			System.out.println("You have:" + user5.getFeesToPay() +"$ to pay, do you want to pay? (Y/N)");
			System.out.print("Enter Y or N: ");
			String yn = input.next();
			yn = yn.toLowerCase();
			choice = yn.charAt(0);
			
			while(choice != 'y' && choice != 'n'){
				System.out.println("Invalid input, try again");
				yn = input.next();
				yn = yn.toLowerCase();
				choice = yn.charAt(0);
			}
			if (choice == 'Y' ){
				System.out.println("We are currently paying your fees from the credit card 4540-XXXX-XXXX-XXXX");
				user5.setFeesToPay(0);
			}else{
				System.out.println("Hope you will pay the next time");
			}
				
			break;
		case 4:user5.printInfo();
			break;
		
		case 5: System.exit(0);
				break;
		
		}
		System.out.println("Do you want to do another action? (Y/N)");
		System.out.print("Enter Y or N: ");
		String yn = input.next();
		yn = yn.toLowerCase();
		choice = yn.charAt(0);
		}while(choice == 'y');
		
		}else if (name.equals("Admin") && id == 314159){//************************************************************************************************************************************
			
			do{
			
			System.out.println("\nWhat do you want to do? \n 1) See the Ebook library \n 2) See fees to pay by user \n 3) Exit");
			System.out.print("Enter the respective number of the action: ");
			switchChoice = input.nextInt();
			
			while (switchChoice != 1 && switchChoice != 2){
				System.out.println("Invalid input, try again");
				switchChoice = input.nextInt();
			}
			
			switch (switchChoice){
			case 1: System.out.println("\nwhat do you want to do? \n 1) See all the Ebooks \n 2) See the available Ebooks \n 3) Search for a book by genre"); 
					System.out.print("Enter the respective number of the action: ");
					switchChoice = input.nextInt();
					
					while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3){
						System.out.println("Invalid input, try again");
						switchChoice = input.nextInt();
					}
			
					switch (switchChoice){
						case 1: printEbookList(bookList);
								break;
						case 2: printAvailabilityList(bookList);
								break;
						case 3: System.out.println("\nEnter the respective number of the genre: \n 1) Spiritual \n 2) Thriller \n 3) Scientific \n 4) Kids");
								switchChoice = input.nextInt();
								
								while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3 && switchChoice != 4){
									System.out.println("Invalid input, try again");
									switchChoice = input.nextInt();
								}
									switch (switchChoice){
										case 1: printInfoByGenre(bookList, "Spiritual");
												break;
										case 2: printInfoByGenre(bookList, "Thriller");
												break;
										case 3: printInfoByGenre(bookList, "Scientific");
												break;
										case 4: printInfoByGenre(bookList, "Kids");
												break;
									}
								break;
					}
							break;
			case 2:
				System.out.println("\n 1) Look at the books owned and fees for one user \n 2) Look at the fees to pay for each user");
				System.out.print("\nEnter the respective number of the action: ");
				switchChoice = input.nextInt();
				
				while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3){
					System.out.println("Invalid input, try again");
					switchChoice = input.nextInt();
				}
					
					switch(switchChoice){
					case 1: System.out.println("Users");
							for (int i = 0; i<5; i++){
								System.out.println((i+1) + ") " + currentUsers[i].getUserName());
							}
							System.out.print("Enter the respective number of the action: ");
							switchChoice = input.nextInt();
					
							while (switchChoice != 1 && switchChoice != 2 && switchChoice != 3){
								System.out.println("Invalid input, try again");
								switchChoice = input.nextInt();
							}
							switchChoice--;
							
							LibraryUser y = currentUsers[switchChoice];
							printEbookOwnedByUser(bookList, y);
							
							System.out.println("\nThe user needs to pay: " + y.getFeesToPay() + "$");
							break;
					
					case 2: for (int i = 0; i<5; i++){
								System.out.println("\n" + currentUsers[i].getUserName());
								printEbookOwnedByUser(bookList, currentUsers[i]);
								calculateTotalFees(bookList, currentUsers[i]);
								System.out.printf("\nThe user needs to pay: %-1.2f $ \n",(float) currentUsers[i].getFeesToPay());
							}
							break;
					}
					
			
				break;
			
			case 3: System.exit(0);
				break;
			}
			System.out.println("\nDo you want to do another action? (Y/N)");
			System.out.print("Enter Y or N: ");
			String yn = input.next();
			yn = yn.toLowerCase();
			choice = yn.charAt(0);
			}while(choice == 'y');
		}
		System.out.println("Wrong Name or ID, since this is a college student project, please reboot the program to start over");
		input.close();
	}
		static void printAvailabilityList(LibraryEbook[] x){
			for (int i = 0; i < 10; i++){
				if (x[i].getAvailability() == "Available"){
					x[i].printInfo();
				}
			}
		}
		
		static void printEbookList(LibraryEbook[] x){

			for (int i = 0; i < 10; i++){
				x[i].printInfo();
			}
		}
		
		static void printInfoByGenre(LibraryEbook[] x, String genre){

			for (int i = 0; i < 10; i++){
				if (x[i].getGenre() == genre){
					x[i].printInfo();
				}
			}
		}
		
		static void printEbookNameList(LibraryEbook[] x){
			for (int i = 0; i<10; i++){
				System.out.println((i+1) + ")" + x[i].getName());
			}
		}
		
		static void printNameAvailabilityList(LibraryEbook[] x){
			for (int i = 0; i < 10; i++){
				if (x[i].getAvailability() == "Available"){
					System.out.println( (i+1) + ") " + x[i].getName());
				}
			}
		}
		
		static void printEbookOwnedByUser(LibraryEbook[] x, LibraryUser y){
			for (int i = 0; i < 10; i++){
				if (x[i].getRentedOwner() == y){
					System.out.println((i+1) + ") " +x[i].getName());
				}
			}
		}
		
		static void printEbookReservableList(LibraryEbook[] x){
			for (int i = 0; i < 10; i++){
				if (x[i].getAvailability() != "Reserved"){
					System.out.println( (i+1) + ") " + x[i].getName());
				}
			}
		}
		
		static void calculateTotalFees(LibraryEbook[] x, LibraryUser y){
			for (int i = 0; i < 10; i++){
				if (x[i].getRentedOwner() == y){
					y.setFeesToPay(y.getFeesToPay()+x[i].calculateFees());
				}
			}
		}
}
