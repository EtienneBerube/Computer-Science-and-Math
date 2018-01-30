package homework;
import java.util.Scanner;
public class Exercise_7_31 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the lenght of the first list: ");
		int n = input.nextInt();
		int[] listA = new int[n];
		
		for (int i = 0; i<n; i++){
			System.out.print("Enter a number to fit in the list: ");
			listA[i] = input.nextInt();
		}
		
		System.out.print("Please enter the lenght of the second list: ");
		int m = input.nextInt();
		int[] listB = new int[m];
		
		for (int i = 0; i<m; i++){
			System.out.print("Enter a number to fit in the list: ");
			listB[i] = input.nextInt();
		}
		
		
		int[] merge = merge(listA, listB);
		
		for (int i = 0; i<(listA.length + listB.length);i++){
			System.out.println(merge[i]);
		}
		
	

	}
	public static int[] merge(int [] list1, int[] list2){
		int n = list1.length + list2.length;
		int[] merged = new int[n];
		
		for (int i = 0; i < list1.length; i++){
			merged[i]=list1[i];
			System.out.println("Merged cell:" + i + " is :" + merged[i]); // for debugging 
		}
		
		int z=0;
		for (int i = list1.length; i< n ;i++){
			merged[i]=list2[z];
			System.out.println("Merged cell:" + i + " is :" + merged[i]); // for debugging 
			z++;
		}
		
		for (int i = 0; i<((list1.length + list2.length)-1); i++){
			int currentMin = merged[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j<((list1.length + list2.length)-1); j++){
				if(merged[j] < currentMin){
					currentMin = merged[j];
					currentMinIndex = j;
				}
			}
			
			if (currentMinIndex != i){
				merged[currentMinIndex] = merged[i];
				merged[i]=currentMin;
				
			}
		}
		
		return merged;
		
	}
}
