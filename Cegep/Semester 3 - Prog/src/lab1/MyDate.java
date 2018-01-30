/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.util.*;

/**
 *
 * @author Étienne Bérubé
 */


public class MyDate {
    private GregorianCalendar c;
    private int month;
    private int day;
    private int year;
    
    public MyDate(){
        c = new GregorianCalendar();
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.month = c.get(Calendar.MONTH);
        this.year = c.get(Calendar.YEAR);
    }
    
    public MyDate(int year, int month, int day){
        c = new GregorianCalendar(year, month, day);
        
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.month = c.get(Calendar.MONTH);
        this.year = c.get(Calendar.YEAR);
    }
    
    public String getDate(){
        return ""+day+"/"+month+"/"+year;
    }

    public GregorianCalendar getC() {
        return c;
    }

    public void setC(GregorianCalendar c) {
        this.c = c;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
}
