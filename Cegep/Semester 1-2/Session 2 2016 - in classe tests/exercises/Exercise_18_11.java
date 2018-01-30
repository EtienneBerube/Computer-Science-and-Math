package exercises;
import java.util.*;
public class Exercise_18_11 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a digit: ");
		long n = input.nextLong();
		System.out.println(sumDigits(n));

	}
	
	public static int sumDigits(long n){
		int total;
		if((double)(n/10) < 1){
			return (int)n;
	
		}else{
			return (int)(n%10 + sumDigits(n/10));
		}
	}

}
