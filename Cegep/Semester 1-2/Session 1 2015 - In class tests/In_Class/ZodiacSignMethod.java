package In_Class;

import java.util.*;

public class ZodiacSignMethod {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		byte choice;
		int currentYear;
		String returnZodiacSign;
		do{
		System.out.print("Please enter the year you want to check: ");
		currentYear = input.nextInt();
		
		returnZodiacSign = zodiacSign(currentYear);
		
		System.out.println("The year sign is: " + returnZodiacSign);
		
		System.out.print("Enter 1 to continu and 0 to exit:  ");
		choice = input.nextByte();
		
		
		while ((choice != 0 && choice != 1)){ //invalid choice
		
			System.out.print("This input is invalid, start again: ");
			choice = input.nextByte();
		}
		
		
		}while(choice != 0);
		
		System.out.println("You exited the code");
		System.exit(1);
		input.close();
		
	}
	public static String zodiacSign( int year ){
			String value = "error";
		
			switch (year % 12){
		case 0:value = "monkey"; break;
		case 1:value = "rooster"; break;
		case 2:value = "dog"; break;
		case 3:value = "pig"; break;
		case 4:value = "rat"; break;
		case 5:value = "ox"; break;
		case 6:value = "tiger"; break;
		case 7:value = "rabbit"; break;
		case 8:value = "dragon"; break;
		case 9:value = "snake"; break;
		case 10:value = "horse"; break;
		case 11:value = "sheep"; break;
			}	
		return value;
			
			
		}
}
