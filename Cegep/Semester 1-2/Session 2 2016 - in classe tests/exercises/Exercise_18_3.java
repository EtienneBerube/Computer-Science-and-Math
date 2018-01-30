package exercises;
import java.util.Scanner;

public class Exercise_18_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two digits: ");
		int m = input.nextInt();
		int n = input.nextInt();
		System.out.println(GCD(m,n));

	}
	
	static int GCD(int m, int n){
		if(m % n == 0)
			return n;
		else
			return GCD(n,(m % n));
	}

}
