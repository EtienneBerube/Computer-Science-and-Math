/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author Étienne Bérubé
 */
public class Course implements Cloneable{
private String courseName;
private String[] students = new String[100];
private int numberOfStudents;

public Course(String courseName) {
this.courseName = courseName;
}

public void addStudent(String student) {
students[numberOfStudents] = student;
numberOfStudents++;
}

public String[] getStudents() {
return students;
}

public int getNumberOfStudents() {
return numberOfStudents;
}

public String getCourseName() {
return courseName;
}

public void dropStudent(String student) {
// Left as an exercise in Programming Exercise 10.9
}

@Override
public String toString(){
    String names = "";
    
    for(int i = 0; i < students.length; i++){
       if(students[i]!=null)
            names += (students[i]+"\n");
    }
    
    return courseName+"\n"+ names +"\nNumber of students: " + numberOfStudents;
}

@Override
public boolean equals(Object o){
    if(o instanceof Course){
        if(courseName.equals( ((Course)o).getCourseName()) && numberOfStudents==((Course)o).getNumberOfStudents())
           return true; 
        else
            return false;
        }
       return false;
}

public Course clone(){
    Course crs = new Course(this.courseName);
    
    for(String student: this.getStudents()){
        if(student != null)
            crs.addStudent(student);
    }
    
    return  crs;        
}

 
}

