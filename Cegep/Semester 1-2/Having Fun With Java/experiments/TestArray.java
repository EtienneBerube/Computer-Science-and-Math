package experiments;

import java.util.Scanner;

public class TestArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] in = new int[5];
		
		for(int i =0; i < in.length; i++){
			in[i] = input.nextInt();
		}
		for(int i =0; i < in.length; i++){
			System.out.println(in[i]);
		}
		
	}

}
