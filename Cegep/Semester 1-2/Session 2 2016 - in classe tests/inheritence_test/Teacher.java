package inheritence_test;

import java.util.ArrayList;

public class Teacher extends Employee{
	
	private ArrayList<Course> courses = new ArrayList<>();
	private String name;
	//private Course[] coursesArray;
	private String officeHours;
	private String rank;
	
	public Teacher(){
		this("Default");
	}
	
	public Teacher(String name) {
		
		super.setName(name);
		/*courses= new Course[3];
		for (int i = 0; i < courses.length;i++){
			courses[i] = null;
		}
		*/
	}
	
	@Override
	void setName(String name){
		super.setName(name);
	}
	
	@Override
	String getName(){
		return name;
	}
	
	void addCourse(Course x){
		/*boolean aSpotLeft = false;
		for (int i = 0; i < courses.length && aSpotLeft == false; i++){
			if (courses[i] == null){
				aSpotLeft = true;
			}
		}
		*/
		if (courses.size() <=  3){		
			/*for (int i = 0; i < courses.length; i++){
				if (courses[i]==null){
					courses[i] = x;
			*/
				courses.add(x);	
					x.addTeacher(this);
					//break;
				
			
		}else{
			System.out.println("The maximum number of class is reached");
		}
	}
	
	void printList(){
		for (int i =0; i < courses.size(); i++){
			if(courses.get(i) == null){
				System.out.println((i+1) + ") ");
			}else{
				System.out.println((i+1) + ") " + courses.get(i).getName());
			}
		}
		System.out.println();
	}

}
