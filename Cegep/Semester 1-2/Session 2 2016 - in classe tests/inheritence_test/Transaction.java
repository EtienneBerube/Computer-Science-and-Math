package inheritence_test;

import java.util.Date;

public class Transaction {
	
	Date date = new Date();
	char type;
	double amount;
	double balance;
	String description;
	
	public Transaction(char type, double amount, double balance, String description){
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;	
	}
	
	@Override
	public String toString(){
		return "Date: "+ date.toString() +"\nType: " + type +"\nAmount: "+ amount +"\nBalance: " + balance + "\nDescription: "+ description;
	}

}
