/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Étienne Bérubé
 * 
 */
public class Test {
    
    
    public static void main(String[] args){
         Student student = new Student("John k", "111 rue Rue, k-Ville",450986456 ,"yourMom@kkk.ca",Student.SENIOR );
         Faculty faculty = new Faculty("Smithy-joe", "112 rue rue, k-ville", 450986101,"inYaFace@trump.org", "GreatLeader", "6-12pm", 12000, "F208");
         Staff staff = new Staff("Toe Pimoe", "112 rue rue, k-ville", 450986101, "imyours@hilary.org", "GarbageLeader", 24000, "A210");
         Person person = new Person("Bruh j", "345 rue boulvard", 540216563, "imSomeone@youpi.gouv.qc.kkk");
         Employee employee = new Employee("NGouyi", "134 rue Nigeria", 450216356, "imANigerianPrince@google.com", 20, "G201");
        
        System.out.println(student.toString());
        System.out.println();
        System.out.println(staff.toString()); 
        System.out.println();
        System.out.println(faculty.toString());
        System.out.println();
        System.out.println(person.toString());
        System.out.println();
        System.out.println(employee.toString());
        System.out.println();
    }
}
