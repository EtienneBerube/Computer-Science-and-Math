/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author Étienne Bérubé
 */
public class testGeometricObject {
   
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
   
    System.out.print("Enter three sides: ");
    
    double s1 = input.nextDouble();
    double s2 = input.nextDouble();
    double s3 = input.nextDouble();
   
    Triangle tri = new Triangle(s1,s2,s3,"Black",true);
        System.out.println("Area: " + tri.getArea() + "\nPerimeter: " + tri.getPerimeter() + "\n" + tri.toString());
    }
}
