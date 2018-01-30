/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Étienne Bérubé
 */
public class Point {
    private double x;
    private double y;
    
    public Point(){
        x = 0;
        y = 0;
    }
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
    @Override 
    public boolean equals(Object o){
        if(o instanceof Point){
            Point x = (Point)o;
            if(this.x == x.getX() && this.y == x.getY()){
                return true;
            }
        }
        return false;
    }
}
