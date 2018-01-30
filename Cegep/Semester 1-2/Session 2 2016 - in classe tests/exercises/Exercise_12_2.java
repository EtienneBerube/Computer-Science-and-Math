package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_12_2 {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n1=0;
		int n2=0;
		boolean x = true;
		
				do try{
					System.out.println("Enter something");
					x=true;
					n1 = input.nextInt();
				}catch(InputMismatchException y){
					x = false;
					input.nextLine();
					System.out.print("nope");
				}while(!x);
				
				System.out.println();
			
				do try{
					n2 = input.nextInt();
				}catch(InputMismatchException y){
					x = false;
					input.nextLine();
					System.out.println("nope");
				}while(!x);
				
				System.out.println(n1+n2);
	}			

}
