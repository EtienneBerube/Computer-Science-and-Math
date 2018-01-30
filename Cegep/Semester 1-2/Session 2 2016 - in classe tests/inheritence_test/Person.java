package inheritence_test;

public class Person {
	private Name name;
	private Address address;
	private String email;
	
	public Person() {
		
	}
	
	void setName(String name){
		this.name = new Name(name);
	}
	void setAddress(String address){
		this.address = new Address(address);
	}
	String getName(){
		return name.getName();
	}
	String getAddress(){
		return address.getAddress();
	}
	void setEmailAddress(String email){
		this.email = email;
	}
	String getEmailAddress(){
		return email;
	}

}
