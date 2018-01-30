package exercises;
import java.util.Scanner;
public class Exercise_18_17 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] ch = new char[10];
		for (int i = 0; i < ch.length; i++ ){
			System.out.print("Enter a character: ");
			ch[i] = (input.next()).charAt(0);
		}
		
		System.out.println("Enter the key character: ");
		char key = (input.next()).charAt(0);
		
		System.out.println(count(ch, key));
	}
	public static int count(char[] chars, char key){
		return count(chars, key, chars.length-1);
	}
	
	public static int count(char[] chars, char ch, int high){
		if(high < 0)
			return 0;
		else if(chars[high] == ch)
			return count(chars, ch, high-1) + 1;
		else
			return count(chars, ch, high-1) + 0;
	}

}
