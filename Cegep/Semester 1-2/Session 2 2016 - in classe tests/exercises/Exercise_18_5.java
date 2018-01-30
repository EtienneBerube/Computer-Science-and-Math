package exercises;

import java.util.Scanner;

public class Exercise_18_5 {

	public static void main(String[] args) {
		for(int i = 1; i < 10; i++){
			System.out.println(sum(i));
		}
	}
	
	static double sum(int i){

		if (i == 1)
			return (1.0/3);
		
		else 
			return (((double)i/(double)(2*i+1)) + sum(i-1));
	}

}
