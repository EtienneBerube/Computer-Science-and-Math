/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Étienne Bérubé
 * O(N) -> removing doubles
 */

public class RemovingDoubles {
    
    public static Scanner input = new Scanner(System.in);
   
    public static void main(String[] args){
        ArrayList<Integer> x = new ArrayList<>();
        System.out.println("Enter ten integers: ");
        
        for(int i =0; i < 10; i++){
            x.add(input.nextInt());
        }
        //sorting
        Collections.sort(x);
        
        /*print confirmation
        *for(int i = 0; i<x.size(); i++){
        *    System.out.println(x.get(i));
        *} 
        */

        removeDuplicate(x);
    }
      public static void removeDuplicate(ArrayList<Integer> list){
        //removing doubles
        ArrayList<Integer> y = new ArrayList<>();
        int ref = list.get(0);
        y.add(list.get(0));
        
        for(int i =1 ; i < list.size(); i++ ){
            if(list.get(i)!=ref){
                y.add(list.get(i));
                ref =list.get(i);
            }
        }
         System.out.println("*******************************NEW*********************************");
        for(Integer i: y){
            System.out.print(i+ " ");
        }
    }  
        
 }
    
    

