import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		char[] ch = new char[6];
		
		int winCount = 0;
		
		for(int i = 0; i < ch.length;i++){
			ch[i] = input.next().charAt(0);
		}
		
		for(int i = 0; i < ch.length; i++){
			if(ch[i]=='W')
				winCount++;
				
		}
		
		if(winCount >= 5)
			System.out.print("1");
		else if (winCount >= 3)
			System.out.print("2");
		else if (winCount >= 1)
			System.out.print("3");
		else 
			System.out.print("-1");

	}

}
