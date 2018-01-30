package tests;
import java.util.Scanner;

public class Grader {

	private double[] testScores;
		
	Grader(double[] scoreArray){
		
	}
	
	double getLowsetScore(double[] scoreArray){
		
		double min = scoreArray[0];
		for (int i = 0; i<scoreArray.length; i++){
			if (scoreArray[i] < min){
				min = scoreArray[i]; 
			}
			
		}
		
		return min;
	}
	
	double getAverage(double[] scoreArray){
		double z=0;
		
		double min = scoreArray[0];
		for (int i = 0; i<scoreArray.length; i++){
			if (scoreArray[i] < min){
				min = scoreArray[i]; 
			}	
		}
		double total = 0;
		for (int i = 0; i<scoreArray.length; i++){
			total += scoreArray[i]; 
		}
		double blue = total - min; // YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAY
		return z;
	}
	

}
