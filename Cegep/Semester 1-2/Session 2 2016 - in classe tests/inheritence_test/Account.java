package inheritence_test;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	String name = "";
	int id;
	double balance = 0;
	public ArrayList<Transaction> transactions = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public Account() {
		
	}
	
	public Account(String name, int id, double balance){
		this.name = name;
		this.id = id;
		this.balance = balance;
	}
	void withdraw(double amount){
		
		if(amount > balance)
			System.out.println("Insufficient amount");
		else{
			System.out.println("Add a description: ");
			String description = input.nextLine();
			transactions.add(new Transaction('W', amount, (balance - amount), description));
			balance -= amount;
		}
			
	}
	
	void deposit(double amount){

			System.out.println("Add a description: ");
			String description = input.nextLine();
			transactions.add(new Transaction('D', amount, (balance + amount), description));
			balance += amount;
		
			
	}
	double getBalance(){
		return balance;
	}

}
