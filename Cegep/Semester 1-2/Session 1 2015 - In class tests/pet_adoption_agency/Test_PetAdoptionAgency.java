package pet_adoption_agency;

import pet_adoption_agency.*;
import java.util.Scanner;

public class Test_PetAdoptionAgency {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long x = 0;
		Pet fido = new Pet("fido", 12, "Dog", 22, "M", true);
		Pet fluffy = new Pet("Fluffy", 26, "Unicorn", 157, "F", false);
		Pet monsterTruck = new Pet("Monster Truck", 8, "Gold Fish", 127, "M", true);
		Pet mrBlue = new Pet("Mr. Blue", 2, "Goat", 16, "M", true);
		
		Pet[] ourPets = new Pet[4];
		ourPets[0] = fido;
		ourPets[1] = fluffy;
		ourPets[2] = monsterTruck;	
		ourPets[3] = mrBlue;
		
		do{
		do{
		System.out.println("Welcome the the pet adoption center, here is our pets");

		for (int i = 0; i < 4; i++){
			ourPets[i].printInfo();
		}
		
		
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		System.out.println("");
		
		System.out.println("Enter your adress: ");
		String adress = input.nextLine();
		System.out.println("");
		
		
		Human h1 = new Human(name, adress);
		
		System.out.println("Do you want to adopt pet? (Y/N)");
		String yn = input.next();
		yn.toLowerCase();
		char choice1 = yn.charAt(0);
		
		while(choice1 != 'n' && choice1 !='y'){
			System.out.println("Invalid input, try again: (Y/N)");
			yn = input.next();
			yn.toLowerCase();
			choice1 = yn.charAt(0);
		}
		
		if (choice1 == 'n'){
			System.exit(0);	
		}else if(choice1 == 'y'){
			System.out.println("Here is our animals, wich one do you want to adopt?");
			
			do{
				for (int i = 0; i < 4; i++){
					System.out.println((i+1) + ") " + ourPets[i].getName());
				}
			
			System.out.print("Enter the respective number of the animal you want to adopt:");
			int choice2 = input.nextInt();
			
			switch (choice2){
			case 1: System.out.println("Fido is now yours!");
					fido.adoptPet(h1.getName());
				break;
			case 2: System.out.println("Fluffy is now yours!");
					fluffy.adoptPet(h1.getName());
				break;
			case 3: System.out.println("Monster Truck is now yours!");
					monsterTruck.adoptPet(h1.getName());
				break;
			case 4:  System.out.println("Mr. Blue is now yours!");
				mrBlue.adoptPet(h1.getName());
				break;
			}
			System.out.println("Do you want to adopt another animal? (Y/N)");
			yn = input.next();
			yn.toLowerCase();
			choice1 = yn.charAt(0);
			
			}while(choice1 == 'y');
			
			System.out.println("Thanks for using our Pet Adoption ATM machine! ");
			x = 1;
		}
		System.out.println("Press enter to continu:");
		String cheat = input.next();
		cheat.toLowerCase();
		char easterEgg = cheat.charAt(0);
		if (easterEgg == '.'){
			x = 0;
		}
		}while(x ==1);
		
		Pet.getAdopterList();
		x = 1;
		}while( x == 1);
	}

}
