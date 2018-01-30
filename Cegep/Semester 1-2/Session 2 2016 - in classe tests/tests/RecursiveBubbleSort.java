package tests;
import java.util.Scanner;
public class RecursiveBubbleSort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] x = new int[10];
		for(int i =0; i<x.length;i++){
			x[i] = 2*(i+1);
		}
		System.out.println("Enter a key: ");
		int n = input.nextInt();
		System.out.println(bubbleSort(x, n, 0, x.length));
		
		
		
	}
	
	static int bubbleSort(int[] x, int key, int low, int high){
		int middle = (high+low)/2;
		
		if(high < low)
			return -low-1;
		
		else if(x[middle] == key)
			return middle;
		
		else if (key < x[middle])
			return bubbleSort(x, key, low, middle-1);
		
		else
			return bubbleSort(x, key, high+1, high);
		
		
	}

}
