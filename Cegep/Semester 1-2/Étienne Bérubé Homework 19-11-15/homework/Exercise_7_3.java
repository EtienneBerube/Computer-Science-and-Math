package homework;

import java.util.Scanner;

public class Exercise_7_3 {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int data;
	int count = 0;
	int[] num = new int[10];
	boolean[] state = new boolean[10];
	int j;
	int y = 1;
	
	
	for (int i = 0;i<10; i++){
		System.out.print("Enter an integer or less form 1 to 100 : ");
		y = input.nextInt();
		num[i] = y;
		
	}
	
	for (int i = 0; i < 10; i++){
		if (state[i]==false ){
		count = 0;	
		for (j = 0; j<10; j++){
				if (num[i] == num[j]){
					count++;
					state[j]=true; 
				}
			}
		if (count ==1)
			System.out.println(num[i]+" happens " + count + " time");
		else
			System.out.println(num[i]+" happens " + count + " times");
		}	
		
	}
	
	}

}
