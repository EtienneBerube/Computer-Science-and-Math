/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.util.Scanner;

/**
 *
 * @author Étienne Bérubé
 */
public class PerfectSquare {
   
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int m = input.nextInt();
       
        boolean isSquare = false;
        int n = 1;
        double ans = 0;
       
        while(!isSquare){
             ans = (Math.sqrt(m*n)%1);
            if(ans == 0){
                isSquare = true;
                break;
            }
            n++;
        }
        System.out.println("The smallest number n for m * n to be a perfect square is " + n + " m*n is " + (m*n));
        
    }
}
