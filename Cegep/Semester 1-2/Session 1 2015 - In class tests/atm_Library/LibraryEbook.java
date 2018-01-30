package atm_Library;
public class LibraryEbook {
	private String name = "";
	private String author="";
	private String genre = "";
	private int numberOfPages = 0;
	private String isbn = "";
	private String availability = "";
	private LibraryUser rentedOwner; 
	private long startRentTime = 0;
	private long diffEndTime = 0;
	
	public LibraryEbook(String name, String author, String genre, int numberOfPages, String isbn) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.numberOfPages = numberOfPages;
		this.isbn = isbn;
		this.availability = "Available";
		
	}
	
	void printInfo(){
		System.out.printf("********************************************\n%-10s%-1s\n%-10s%-1s\n%-10s%-1s\n%-10s%-1d\n%-10s%-1s\n\n%-1s\n\n","Name:",name,"Author:",author,"Genre:",genre,"Pages:",numberOfPages,"ISBN:",isbn,availability);
	}
	
	void rentBook(){
		availability = "Not available";
		startRentTime = System.currentTimeMillis();
	}
	
	void returnBook(){
		availability = "Available";
		rentedOwner = null;
	}
	
	void reserveBook(){
		availability = "Reserved";	
	}
	
	String getAvailability(){
		return availability;
	}
	String getGenre(){
		return genre;
	}
	String getName(){
		return name;
	}
	void setRentedOwner(LibraryUser x){
		rentedOwner = x;
	}
	LibraryUser getRentedOwner(){
		return rentedOwner;
	}
	
	double calculateFees(){
		diffEndTime = System.currentTimeMillis() - startRentTime;
		if ((diffEndTime)/1000/60/60/24/7 > 2){
			double lateFees = (((int)(((double)(double)(diffEndTime)/1000/60/60/24/7) - 2) * 7 ) * 2);
			return lateFees;
		}else{
				return 0;
			}
			
		}
	void setRentTime(long x){
		startRentTime = x;
	}	
	
}
