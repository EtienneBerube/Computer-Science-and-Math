package In_Class;

import java.util.Scanner;

import In_Class.BankAccount;

public class TestBankAccount {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		double startBalance = 0;
		double startInterestRate = 0;
		int exitChoice;
		
		System.out.print("Please enter the initial amount: ");
		startBalance = input.nextDouble();
		
		System.out.print("Please enter the interest rate in %: ");
		startInterestRate = input.nextDouble();
		
		BankAccount myBankAccount = new BankAccount(startBalance, startInterestRate); 
		
		System.out.println("\nWith the creation of your account with us, we created a saving account linked with your main account\n");
		
		BankAccount myBankAccount2 = new BankAccount(0,startInterestRate);
		
		
		do {	
		System.out.print("What do you want to do? \n 1) Get the balance \n 2) Deposit money \n 3) Withdraw money \n"
		 + " 4) See the balance after a certain time \n 5) Get the interest rate \n 6) See how much Bank accounts are active \n 7) Transfer money to your saving account" );
		
		int choice = input.nextInt();
		
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7){
			System.out.print("Invalid input, try again");
			choice = input.nextInt();
			
		}
		switch (choice){
		
		case 1: System.out.println(myBankAccount.getBalance() + "$");
			break;
		
		case 2: System.out.print("how much do you want to deposit? ");
			myBankAccount.deposit(input.nextDouble());
			System.out.println("the new balance is: " + myBankAccount.getBalance() + "$");
			break;
		
		case 3: System.out.print("how much do you want to Withdraw? ");
			myBankAccount.withdraw(input.nextDouble());
			System.out.println("the new balance is: " + myBankAccount.getBalance() + "$");
			break;
		
		case 4:	System.out.println("After one month, you would make " + myBankAccount.getInterest() + "of interest");
				System.out.print("Do you want to add this to your balance?\n 0) yes \n 1) no");
				int addChoice = input.nextInt();
				
				while (addChoice != 0 && addChoice != 1){
					System.out.print("Invalid input, try again");
					addChoice = input.nextInt();		
				}
				if (addChoice == 0){
					myBankAccount.addInterest();
					System.out.println("Your new balance is " + myBankAccount.getBalance() + "$");
				}
			
				break;	
		
		case 5:System.out.println(myBankAccount.getInterestRate());
			break;
		
		case 6: System.out.println(BankAccount.getNumOfAccounts() + " accounts are active right now");	
			break;
			
		case 7: System.out.print("How much do you want transfer? ");
			double transfer = input.nextDouble();
		
			while (transfer > myBankAccount.getBalance()){
				System.out.println("Insufficient fonds, try again: ");
				transfer = input.nextDouble();
			}
		
			myBankAccount.withdraw(transfer);
			myBankAccount2.deposit(transfer);
			System.out.println("Your new balance is " + myBankAccount.getBalance() + "$ for your first account and " + myBankAccount2.getBalance() + "$ in your saving account");
			break;
		
		}
		
		System.out.print("\nEnter 0 to continu and 1 to exit: ");
		exitChoice = input.nextInt();
		
		while (exitChoice != 0 && exitChoice !=1){
			System.out.print("Invalid input, try again: ");
			exitChoice = input.nextInt();
		}
		System.out.println("");
		
		}while (exitChoice !=1);
		
		input.close();
	}
	
}
