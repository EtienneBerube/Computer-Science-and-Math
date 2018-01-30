package exercises;

import java.util.Scanner;

public class Exercise_12_3 {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean x = true;
		int[] a = new int[100];
		
		for(int i=0; i < a.length; i++){
			a[i]=(int)Math.ceil(Math.random()*100);
		}
		
		do try{
			x = true;
			System.out.print("Enter an index:");
			System.out.println(a[input.nextInt()]);
		}
		catch(ArrayIndexOutOfBoundsException y){
			x = false;
			System.out.print("Bad index! \n");
			input.nextLine();
		}while(!x);

	}

}
