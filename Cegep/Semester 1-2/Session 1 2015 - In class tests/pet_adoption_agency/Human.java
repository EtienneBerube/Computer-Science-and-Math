package pet_adoption_agency;

public class Human {
private String newOwner= "";
private String adress = "";
	public Human(String x, String y) {
		newOwner = x;
		adress = y;
	}
	
	String getInfo(String nameOfPet){
		return (newOwner +", " + adress);
	}
	
	String getName(){
		return newOwner;
	}

}
