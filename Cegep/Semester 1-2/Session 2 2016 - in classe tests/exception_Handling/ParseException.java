package exception_Handling;

import java.util.Scanner;

public class ParseException {
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		String str = "1234";
		int number = 0;
		
		try{
		number = Integer.parseInt(str);
		System.out.println(number);
		}
		
		catch (NumberFormatException x){
		System.out.println("Bad person");
		}

	}

}
