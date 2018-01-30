package inheritence_test;

public class AccountTest {

	public static void main(String[] args) {
		Account x = new Account("Georges", 1122, 1000);
		x.deposit(30);
		x.deposit(40);
		x.deposit(50);
		x.withdraw(5);
		x.withdraw(4);
		x.withdraw(2);
		
		System.out.println(x.getBalance());
		
		for(int i =0; i < x.transactions.size(); i ++){
			System.out.println(x.transactions.get(i).toString());
		}
		
	}

}
