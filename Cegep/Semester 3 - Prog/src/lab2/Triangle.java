/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Étienne Bérubé
 */
public class Triangle extends GeometricObject{
    private double s1;
    private double s2;
    private double s3;
    
    public Triangle(){
        s1 = 1.0;
        s2 = 1.0;
        s3 = 1.0;
    } 
    public Triangle(double s1, double s2, double s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    public Triangle(double s1, double s2, double s3, String color, boolean filled){
        super(color, filled);
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public double getS1() {
        return s1;
    }

    public void setS1(double s1) {
        this.s1 = s1;
    }

    public double getS2() {
        return s2;
    }

    public void setS2(double s2) {
        this.s2 = s2;
    }

    public double getS3() {
        return s3;
    }

    public void setS3(double s3) {
        this.s3 = s3;
    }

    @Override
    public double getArea() {
        double p = (s1 + s2 + s3)/2;
        return Math.sqrt(p* (p - s1) * (p - s2) * (p - s3));
    }

    @Override
    public double getPerimeter() {
        return s1 + s2 + s3;
    }
    
    @Override
    public String toString(){
        return "Triangle \nSide 1: "+s1+"\nSide 2: " + s2 + "\nSide 3: " + s3 + "\n" +super.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Triangle){
            
            if(equals(o) && s1 == ((Triangle) o).getS1() && s2 == ((Triangle) o).getS2() && s3 == ((Triangle) o).getS3()){
                return true;
            }
            
        
        }
        return false;
    }
    
   
}
