package In_Class;

public class BankAccount {
	private double balance =0;
	private double interestRate =0;
	private double interest = 0;
	private static int numberOfAccounts = 0;
	
	BankAccount(double newBalance, double newInterestRate){ // constructor
		balance = newBalance;
		interestRate = newInterestRate;
		numberOfAccounts++;
	}
	void deposit(double amount){
		balance += amount;
	}
	
	void withdraw(double amount){
		balance -= amount;
	}
	
	double getBalance(){
		return balance;
	}
	
	double getInterestRate(){
		return interestRate;
	}
	
	double getInterest(){
		double z = 0;
		
		z = balance *(interestRate/100); 
		
		return z;
	}
	void addInterest(){
		interest = balance *(interestRate/100); 
		
		balance += interest;
			
	}
	static int getNumOfAccounts(){
		return numberOfAccounts;
	}
}
