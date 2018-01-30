package exercises;
import java.util.Scanner;
public class Exercise_18_9 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter String: ");
		String s = input.nextLine();
		reverseDisplay(s);
	}
	
	public static void reverseDisplay(String value){
		if(value.length() == 1){
			System.out.println(value);
		}else{
			System.out.print(value.charAt(value.length()-1));
			reverseDisplay(value.substring(0,value.length()-1));
		}
		
	}

}
