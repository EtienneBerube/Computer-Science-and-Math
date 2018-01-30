package exercises;
import java.util.Scanner;

import java.math.BigInteger;

public class Exercise_10_19 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i = 2; i < 101; i++){
			
			if(isPrime(i))
				System.out.println(i+ " " + mersenePrime(i));
		}

	}
	
	static BigInteger mersenePrime(int n){
		final BigInteger TWO = new BigInteger("2");
		BigInteger x = new BigInteger("1");
		
		
		for(int i = 0; i < n; i++){
			x = x.multiply(TWO);
		}
		
		
		return x.subtract(BigInteger.ONE);
	}
	
	static boolean isPrime(int n){
		boolean isPrime = true;
		for (int i =2; i<n && isPrime == true;i++){
			if(n%i==0){
				isPrime = false;
			}
		}
		return isPrime;
	}

}
