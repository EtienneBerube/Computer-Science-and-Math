package homework;
import java.util.Scanner;
public class Exercise_7_17 {

	public static void main(String[] args) { // doesn't work...
		Scanner input = new Scanner(System.in);
		System.out.print("Pleas enter the number of students you want to grade: ");
		int n = input.nextInt();
		
		String[] studentList = new String[n];
		byte[] studentGrade = new byte[n];
		
		for (int i = 0; i< n; i++){
			System.out.print("Please enter the student's name: ");
			studentList[i] = input.next();
			System.out.println("");
			System.out.print("Please enter his grade: ");
			studentGrade[i] = input.nextByte();
		}
		for (int i = 0; i< n; i++){
			byte currentMax = studentGrade[i];
			int currentMaxIndex = i;
			
			for (int j = i+1; j<n; j++){
				if(studentGrade[j] > currentMax){
					currentMax = studentGrade[j];
					currentMaxIndex = j;
				}
			}
			
			if (currentMaxIndex != i){
				studentGrade[currentMaxIndex] = studentGrade[i];
				studentGrade[i]=currentMax;
				
				studentList[currentMaxIndex] = studentList[i];
				studentList[i]= studentList[currentMaxIndex];
			}
		}
		
		for (int i = 0; i<n; i++){
			System.out.println(studentList[i] + " " + studentGrade[i] + "%");
		}
		
	}
	


}
