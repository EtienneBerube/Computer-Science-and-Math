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
public class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;
    
    public Circle(){
        radius = 1.0;
    }
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return Math.PI*2*radius;
    }

    @Override
    public int compareTo(Circle o) {
        if(radius > o.getRadius()){
            return 1;
        }else if(radius < o.getRadius()){
            return -1;
        }else
            return 0;
    }
    
    @Override
    public String toString(){
        return "Cricle \nRadius: "+ radius+ "\n" +super.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Circle){
            
            if(equals(o) && radius ==((Circle) o).getRadius()){
                return true;
            }
            
        
        }
        return false;
    }
    
    
        
}
