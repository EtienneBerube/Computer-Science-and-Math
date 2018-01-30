package pet_adoption_agency;

import java.util.Date;

public class Pet {
	Date time = new Date();
	private String nameOfPet = ""; 
	private int possibleAgeWhenFound = 0;
	private String dateFound ="";
	private String specie = "";
	private double weight = 0;
	private String gender = "";
	private boolean isAdopted = false;
	private String nameNewOwner = "";
	private String dateAdopted = "";
	private static int numberOfPets = 0;
	private static String adopterList = "";

	public Pet(String name, int age, String specieType, double w, String g, boolean owner) {
		dateFound = time.toString();
		nameOfPet = name;
		possibleAgeWhenFound = age;
		weight = w;
		gender = g;
		isAdopted = false;
		specie = specieType;
		numberOfPets++;
		
	}
	
	void adoptPet(String x){
		isAdopted = true;
		nameNewOwner = x;
		adopterList += ("\n" + nameNewOwner);
		dateAdopted = time.toString();
	}
	
	 String getName(){
		return nameOfPet;
	}
	
	int getNumberOfPet(){
		return numberOfPets;
	}
	
	String getAdoptionDate(){
		return dateAdopted;
	}
	
	void printInfo(){
		System.out.printf("\n \n Name:%15s \n Age: %15d \n Specie: %12s \n Gender: %12s \n Weight: %12.0f \n Date Found: %25s"
							+ "\n Adopted: %b \n \n ",nameOfPet, possibleAgeWhenFound, specie, gender,(float) weight, dateFound, isAdopted);
	}
	
	static String getAdopterList(){
		return adopterList;
		
	}
}
