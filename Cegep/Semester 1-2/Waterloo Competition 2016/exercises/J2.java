package exercises;
import java.util.Scanner;
public class J2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a line of characters from 1 to 255");
		String line = input.nextLine();
		int countHappy=0;
		int countSad=0;
		
		while(line.length()<1 && line.length()>255){
			System.out.println("Your line is either too long or too short, try again: ");
			line = input.nextLine();
		}
		
		for(int i = 0; i < line.length()-3;i++){
			if(line.charAt(i)==':'){
				if(line.substring(i,(i+3)).equals(":-("))
					countSad++;
				else if(line.substring(i,(i+3)).equals(":-)"))
					countHappy++;
				
			}
		}
		System.out.println("happy :" + countHappy);
		System.out.println("sad :" + countSad);
		if(countHappy > countSad)
			System.out.println("happy");
		else if (countSad> countHappy)
			System.out.println("sad");
		else
			System.out.println("none");
	}
}
