package inheritence_test;

import java.util.ArrayList;

public class Course {
	
	private ArrayList<Teacher> teachers = new ArrayList<>();
	private ArrayList<Student> students = new ArrayList<>();
	private final int NUMBEROFSTUDENTS = 30;
	private final int NUMBEROFTEACHERS = 2;
	//private Teacher[] teachers= new Teacher[2];
	//private Student[] students = new Student[NUMBEROFSTUDENTS];
	private Name name;
	
	public Course(String name) {
		
		this.name = new Name(name);
		/*for (int i = 0; i < teachers.length;i++){
			teachers[i] = null;
		}
		for (int i = 0; i < students.length;i++){
			students[i] = null;
		}*/
		
	}
	
	String getName(){
		return name.getName();
	}
	
	void setDropped(Student x){
		students.remove(x);
	}
	
	void addStudent(Student x){ //DO NOT USE
		
		if (students.size() <= NUMBEROFSTUDENTS){		
			students.add(x);
		}else{
			System.out.println("The maximum number of students is reached");
		}
	}
	
	void addTeacher(Teacher x){
		
		if (teachers.size() <= NUMBEROFTEACHERS){		
			teachers.add(x);
		}else{
			System.out.println("The maximum number of teachers is reached");
		}
	}
	
	
	
	void printStudentList(){
		for (int i = 0 ; i < students.size(); i++){
			if(students.get(i)==null){
				System.out.println((i+1) + ") free ");
			}else{
			System.out.println((i+1) + ") " + students.get(i).getStudentName());
			}
		}
	}
	
	int getMaxNumOfStudents(){
		return NUMBEROFSTUDENTS;
	}
	
}
