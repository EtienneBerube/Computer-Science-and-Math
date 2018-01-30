package exercises;
import java.util.Scanner;

import tests.StackOfIntegers;

public class Exercise_10_5 {

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		StackOfIntegers stack = new StackOfIntegers();
		System.out.print("Enter an integer: ");
		int num = input.nextInt();
		
		
		while (num != 1){
			for (int i = 2; i <= num; i++){
				if (num % i == 0){
					num = num / i;
					stack.push(i);
					break;
				}
					
			}
		}
		
		while (!stack.empty()){
			System.out.print(stack.pop() + " ");
		}
		
	}

}
