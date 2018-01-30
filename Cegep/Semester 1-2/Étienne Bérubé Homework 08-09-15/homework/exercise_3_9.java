package homework;

import java.util.*; //doesn't work

public class exercise_3_9 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int d1;
		int d2;
		int d3;
		int d4;
		int d5;
		int d6;
		int d7;
		int d8;
		int d9;
		int d10;
		int isbn;
		String isbnString;
		
		System.out.print("Enter the first nine digits of the ISBN-10: ");
		isbnString = input.nextLine();
	
		isbn = Integer.parseInt(isbnString);
		
		d9 = (isbn / 100000000) % 10;
		d8 = (isbn / 10000000) % 10;
		d7 = (isbn / 1000000) % 10;
		d6 = (isbn / 100000) % 10;
		d5 = (isbn / 10000) % 10;
		d4 = (isbn / 1000) % 10;
		d3 = (isbn / 100) % 10;
		d2 = (isbn / 10) % 10;
		d1 = (isbn / 1) % 10;
		System.out.println(d9);
		d10 = (d9*1 + d8*2 + d7*3 + d6*4 + d5*5 + d4*6 + d3*7 + d2*8 + d1*9) % 11;
		
		if (d10 == 10)
			System.out.print(isbnString+"X");
		
		else 
			System.out.print(isbnString+""+d10);
	}		

}
