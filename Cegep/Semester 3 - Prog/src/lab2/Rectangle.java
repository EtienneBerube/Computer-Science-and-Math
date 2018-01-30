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
public class Rectangle extends GeometricObject{
    private double width;
    private double height;
    
    public Rectangle(){
     this.width = 1.0;
     this.height = 1.0;
    }
    
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(double width, double height, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
       return 2 * width + 2 * height;
    }
    
     @Override
    public String toString(){
        return "Rectangle \nWidth: " + width + "\nHeight: " +height + super.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Rectangle){
            
            if(equals(o) && width == ((Rectangle) o).getWidth() && height == ((Rectangle) o).getHeight()){
                return true;
            }
            
        
        }
        return false;
    }
    
}
