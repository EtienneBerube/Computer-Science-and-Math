package exercises;

import java.util.Scanner;

import tests.BinaryFormatException;

public class Exercise_12_9 {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter some binary stuff: ");
		String x = input.next();
		try{
			System.out.println(bin2Dec(x));	
		}catch (BinaryFormatException ex){
			System.out.println("not binary stuff");
		}
		

	}
	
	public static int bin2Dec(String x) throws BinaryFormatException {
		
		try{
			return Integer.parseInt(x, 2);
		}catch (NumberFormatException ex){
			throw new BinaryFormatException(x);
		}
		
	}


}
