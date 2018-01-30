package exercises;

import java.util.Scanner;

public class Exercise_12_7 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter some binary stuff: ");
		String x = input.next();
		try{
			System.out.println(bin2Dec(x));	
		}catch (NumberFormatException ex){
			System.out.println("not binary stuff");
		}
		

	}
	
	public static int bin2Dec(String x) {
		int y = Integer.parseInt(x, 2);
		return y;
	}

}
