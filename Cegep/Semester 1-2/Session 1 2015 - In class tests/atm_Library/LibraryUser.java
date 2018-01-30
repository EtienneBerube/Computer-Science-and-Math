package atm_Library;

public class LibraryUser {
	private String name = "";
	private long id= 0;
	private String address = "";
	private int age = 0;
	private String gender = "";
	private int bookCount = 0;
	private int reservedBookCount = 0;
	private double feesToPay = 0;
	
	public LibraryUser(String name, String address, long id, int age, String gender) {
		this.name = name;
		this.id = id;
		this.address= address;
		this.age = age;
		this.gender = gender;
	}
	
	void printInfo(){
		System.out.printf("%-10s%-1s\n%-10s%-1d\n%-10s%-1s\n%-10s%-1d\n%-10s%-1s\n%-10s%-1d\n%-10s%-1d\n","Name:",name,"User ID:",id, "Address:", address,"Age",age,"Gender:",gender,"Books:",bookCount, "Late fees: ",(int)getFeesToPay());
	}
	
	void rentBook(LibraryEbook book){
			if (book.getAvailability() == "Available"){
				if (bookCount <= 3){
				bookCount++;
				book.rentBook();
				
			}else{
				System.out.println("You already have the maximum quatity of books");
			}
			
		}else{
			System.out.println("The book is currently not available, you can still reserve it");
		}
		
	}
	void returnBook(LibraryEbook book){
		bookCount--;
		book.returnBook();
		book.calculateFees();
		if (book.calculateFees() !=0){
			System.out.println("You have "+book.calculateFees()+"$ to pay for this book, you can pay the fees in the menu");
		}
		
	}
	
	void reserveBook(LibraryEbook book){
		if (book.getAvailability()!= "Reserved"){
			if (reservedBookCount <= 2){
				book.reserveBook();
				reservedBookCount++;
			}
			else{
			System.out.println("You have already the maximum quatity of reserved book");
			}
		}else{
			System.out.println("This book is already reserved by another user");
		}
	}
	
	int getBookCount(){
		return bookCount;
	}
	String getUserName(){
		return name;
	}
	

	double getFeesToPay(){
		return feesToPay;
	}
	void setFeesToPay(double x){
		feesToPay = x;
	}
}
