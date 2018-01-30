package In_Class;

import java.util.Scanner;

public class TopDownApproach {

	public static void main(String[] args) {
		
		printOutput(readInput());
		 System.exit(0);

	}
public static String readInput(){
	Scanner input = new Scanner(System.in);
	int choice;
	String print = "";
		
	System.out.println("Enter 1 if the input is a character");
	System.out.println("Enter 2 if the input is a double");
	System.out.println("Enter 3 if the input is a String");
	System.out.print("Choice: ");
	choice = input.nextInt();	
	
	while(choice != 1 && choice != 2 && choice != 3){
		System.out.println("invalid input, try again: ");
		
		System.out.print("Choice: ");
		choice = input.nextInt();
		}
		
	
	switch (choice){
	case 1: 
		System.out.print("Please enter the characters you want to compare separated by a [enter]: ");
		
		String charValue1 = input.next();
		char charAtValue1 = charValue1.charAt(0);
		
		String charValue2 = input.next();
		char charAtValue2 = charValue2.charAt(0);
		
		print = less(charAtValue1, charAtValue2);
		break;
	
	case 2:	
		System.out.print("Please enter the numbers you want to compare separated by [enter]: ");
		
		double doubleValue1 = input.nextDouble();
		double doubleValue2 = input.nextDouble();
		
		print = less(doubleValue1, doubleValue2 );
		break;
	
	case 3:	
		System.out.println("Please enter the strings you want to compare separated by [enter]: ");
		String stringValue1 = input.next();
		
		System.out.println("and ");
		String stringvalue2 = input.next();
		
		print = less(stringValue1, stringvalue2);
		break;
	
	default: System.out.println("The input is invalid");
			
		break;
	}
	input.close();
	return print;
}
public static String less(char x, char y){
	System.out.println("character");
	String z = "";
	if (x < y)
		z = x+"";
	else 
		z = y+"";
	return z;
}
public static String less(double x, double y ){
	System.out.println("double");
	String z = "";
	if (x < y)
		z = x+"";
	else 
		z = y+"";
	
	return z;
}
public static String less(String x, String y){
	System.out.println("String");
	String z = "";
	int v = x.compareTo(y);
	
	if (v < 0)
		z = x;
	else if (v > 0)
		z = y;
	else 
		z = "The two inputs are equal";
	return z;
}
public static void printOutput(String x){
	System.out.println("The lesser value is: " + x);
}
}
