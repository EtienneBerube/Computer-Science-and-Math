package exercises;

import java.util.Scanner;

/*
 *  O(n)
 */

public class Exercise_22_1 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter: ");
		String popo= input.next();
		
		String reconstructedString = "";
		String finalReconstructedString = "";
		
		for(int i = 0; i < popo.length(); i++){
			
			if(i<popo.length()-1){
				
				if(popo.charAt(i)<=popo.charAt(i+1)){
					reconstructedString+=popo.charAt(i);
					
					
				}else{
					reconstructedString+=popo.charAt(i);
				
					if(finalReconstructedString.length() < reconstructedString.length())
						finalReconstructedString = reconstructedString;
						
					reconstructedString="";
				}
			}else if(i == popo.length()-1){
				if(popo.charAt(i)>=popo.charAt(i-1))
					reconstructedString+=popo.charAt(i);
				
				if(finalReconstructedString.length() < reconstructedString.length())
					finalReconstructedString = reconstructedString;
					
				reconstructedString="";
				
			}
		}
		
		System.out.println(finalReconstructedString);
		
	}

}
