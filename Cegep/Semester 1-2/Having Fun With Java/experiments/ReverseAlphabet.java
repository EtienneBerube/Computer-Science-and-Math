package experiments;
import java.util.Scanner;

public class ReverseAlphabet {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		String base;
		
		System.out.println("What do you want to do?\n 1)Crypt \n 2)Decrypt");
		int choice = input.nextInt();
		
		while (choice != 1 && choice != 2){
			System.out.println("Invalid input, try again: ");
			choice = input.nextInt();
		}
		
		switch(choice){
		
		case 1: System.out.print("Pleas enter the String you want to crypt: ");
		 base = input.nextLine();
		 base = input.nextLine();
		
		System.out.println("The crypted String is: " + cryptingDecrypting(base));
		break;
		
		case 2: System.out.print("Pleas enter the String you want to decrypt: ");
		 base = input.nextLine();
		 base = input.nextLine();
		
		System.out.println("The decrypted String is: " + cryptingDecrypting(base));
		break;
			
			
		}
	}
	
	static String cryptingDecrypting(String base){
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String crypted = "";
		
		for (int i = 0; i < base.length(); i++){
			for (int j = 0; j < alphabet.length(); j++){
				if (base.charAt(i) == ' '){
					crypted += " ";
					break;
				}
				
				else if (base.charAt(i) == alphabet.charAt(j)){
					int pos = alphabet.lastIndexOf(alphabet.charAt(j));
					crypted += alphabet.charAt((int)(25 - pos ));
					break;
				}
			}
		}
	return crypted;
	}

}
