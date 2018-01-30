package inheritence_test;

import java.util.ArrayList;

public class Student extends Person{
	
	private ArrayList<Course> courses = new ArrayList<>();
	//private Course[] courses;
	//private Name name;  <------------------ to check
	//private Address address;
	private final int MAXNUMOFCLASS = 9;
	private String status;
	
	public Student(String name, String address, String emailAddress, String status) {
		this.status = status;
		super.setName(name);;
		super.setAddress(address);
		//courses = new Course[MAXNUMOFCLASS];
		//for (int i = 0; i < courses.length;i++){
		//	courses[i] = null;
		//}
		
	}
	
	String getStudentName(){
		return super.getName();
	}
	
	String getStudentAddress(){
		return super.getAddress();
	}
	
	void addClass(Course x){
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
					x.addStudent(this);
					//break;
				
			
		}else{
			System.out.println("The maximum number of class is reached");
		}
	}

	void printClassList(){
		for(int i = 0; i < courses.size(); i++){
			if(courses.get(i)==null){
				System.out.println((i+1)+") ");
			}else{
				System.out.println((i+1)+") "+courses.get(i).getName());
			}
		}System.out.println();
	}
	
	int getNumClasses(){
		return courses.size();
	}
	
	void dropClass(Course x){
		courses.remove(x);	
	}
	
	void printStudentInfo(){
		System.out.printf("Name: %-10s\n Address: %-10s\n",super.getName() , super.getAddress());
		printClassList();
	}
		
}
