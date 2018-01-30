package exercises;

import java.util.Scanner;
/*
 * O(n)
 */

public class Exercise_22_3 {
	
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter 1: ");
		String bigString = input.nextLine();
		System.out.println("Enter 2: ");
		String smallString = input.nextLine();
		
		int n = smallString.length();
		String index = "";
		String subBigString="";
		
		for(int i = 0; i< bigString.length(); i++){
			
			if(( i + n )> bigString.length())
				subBigString = bigString.substring(i, (bigString.length()));
			else
				subBigString = bigString.substring(i, (i+n));
			
			
			if(smallString.equals(subBigString)){
				System.out.println("Match!");
				index += i + " ";
			}
		}
	
		System.out.println("Match at : " + index);

	}

}
