/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Date;

/**
 *
 * @author Étienne Bérubé
 */
public abstract class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;
    
    protected GeometricObject(){
        color = "Default";
        filled = false;
        dateCreated = new Date();
    }
    
    protected GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    
    @Override
    public  String toString(){
        return "Color: " + color + "\nFilled: " + filled;
    }
    
    @Override
    public boolean equals(Object o){
     if(o instanceof GeometricObject){
         if(color == ((GeometricObject) o).getColor() && filled == ((GeometricObject) o).isFilled() && dateCreated.equals(((GeometricObject) o).getDateCreated()));
         return true;
     } 
     return false;
    }
        
    public abstract double getArea();
    
    public  abstract double getPerimeter();
}
