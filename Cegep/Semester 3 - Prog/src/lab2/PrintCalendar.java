/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Étienne Bérubé
 */
public class PrintCalendar {

     private static GregorianCalendar cal = null;
    
    
    public static void main(String[] args){
      
        //Integer month = new Integer(Integer.parseInt(args[0])) - 1;
       // Integer year = new Integer(Integer.parseInt(args[1]));
        
        //**************for debug only**************
        
       int month = 7;
        int year = 2015;
                
        //*****************************************
       
        cal = new GregorianCalendar(year, month, 1);
        
        print(cal);
        
        
    }

    
    public static void print(GregorianCalendar cal){
        System.out.println(cal.get(Calendar.MONTH) + ", " + cal.get(Calendar.YEAR));
        System.out.println("----------------------------------------");
        System.out.println(" Sun   Mon   Tue   Wed   Thu   Fri   Sat");
        
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        int day = 1;
        int temp = 0;
     //   
       // System.out.println(firstDay);
        
//puts empty spaces before first day e.g if the 1st is on wednesday
         for(int i = 1; i < firstDay; i++){
             if(i != 1){
                 System.out.print("  ");
             }
             System.out.print("    ");
             temp++;
         }
         // System.out.println(temp);
         //finishes the week;
         for(int i=temp; i <7; i++,day++){
             if(i != 0){
                 System.out.print("  ");
             }
             System.out.print("   " + day);
         }
         System.out.println();
         
        //goes for month
        for(int i =1; i<=cal.getActualMaximum(Calendar.WEEK_OF_MONTH)-1; i++){
            for(int j = 0; j < 7 && day <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); j++){
               if(j != 0){
                   System.out.print("  ");
               }
                if(day<10){
                    System.out.print("   " + day);
                }else{
                    System.out.print("  " + day);
                }
                day++;
            }
            System.out.println();
        }
        
    }
    
}
