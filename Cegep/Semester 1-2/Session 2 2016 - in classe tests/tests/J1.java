package tests;
import java.util.Scanner;
public class J1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the month and the date(in the same order): ");
		int month = input.nextInt();
		int day = input.nextInt();
		if (month > 2)
			System.out.println("After");
		else if(month < 2){
			System.out.println("Before");
		}else{
			if(day > 18){
				System.out.println("after");
			}else if (day<18){
				System.out.println("Before");
			}else{
				System.out.println("Special");
			}
		}
	}
}
