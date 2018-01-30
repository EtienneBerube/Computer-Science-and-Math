/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.logging.Logger;
import lab3.Course;

/**
 *
 * @author Étienne Bérubé
 */
public class TestCourse {

    public static void main(String[] args){
        Course c1 = new Course("Intro to radical islam");
        Course c2 = new Course("Being a winner for losers");
        Course c3 = null;
        
        c1.addStudent("Jeremy");
        c1.addStudent("William");
        c1.addStudent("Etienne");
        c1.addStudent("Aya");
        c1.addStudent("Naya");
        
        
        c2.addStudent("Samsung");
        c2.addStudent("Jean-Pistache");
        c2.addStudent("Hugh Mongus");
        
        c3 = c1.clone();
        
        System.out.println(c1.toString());
        System.out.println("");
        System.out.println(c3.toString());
        
        
        
        
    }
}
