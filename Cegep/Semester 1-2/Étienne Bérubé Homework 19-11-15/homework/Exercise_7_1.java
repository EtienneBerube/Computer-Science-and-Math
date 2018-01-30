package homework;
import java.util.Scanner;
public class Exercise_7_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		
		System.out.print("Please enter the number of students:");
		n = input.nextInt();
		
		int[] studentList = new int[n];
		
		for (int i=0; i < n; i++){
			System.out.println("Enter the grade for the student number" + (i+1));
			studentList[i] = input.nextInt();
			
		}
		
		for (int i=0; i < n; i++){
			System.out.print("The student "+(i+1)+" got a grade of " + studentList[i] +" and his mark is ");
			
			if( studentList[i]<= 60){
				System.out.println("F");
			}else if (studentList[i]<= 70){
				System.out.println("D");
			}else if (studentList[i]<= 80){
				System.out.println("C");
			}else if (studentList[i]<= 90){
				System.out.println("B");
			}else{
				System.out.println("A");
			}
				
			
		}
		

	}

}
