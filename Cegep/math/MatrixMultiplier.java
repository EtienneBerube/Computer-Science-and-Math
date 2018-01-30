
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Étienne Bérubé
 */
public class MatrixMultiplier {
    static private int ax;
    static private int ay;
    static private String a;
    static private int bx;
    static private int by;
    static private String b;
    static private int cx;
    static private int cy;
    static private double[][] matrixC;
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the first matrix as mXn [no spaces]");
        a = input.next().toLowerCase();
        String[] matrix1 = a.split("x");
        
        
        System.out.println("Enter the size of the second matrix as mXn [no spaces]");
        b = input.next().toLowerCase();
        String[] matrix2 = b.split("x");
        
        try{
            ax = Integer.parseInt(matrix1[0]);
            ay = Integer.parseInt(matrix1[1]);
            bx = Integer.parseInt(matrix2[0]);
            by = Integer.parseInt(matrix2[1]);
            
        }catch(Exception ex){
            System.out.println("Something went wrong");
            System.exit(0);
        }
        
        if(ay != bx){
            System.out.println("Incompatible Matrices");
            System.exit(0);
        }else{
            //create Matrix C
            matrixC = new double[ax][by];
            //Fill Matrix A
            double[][] matrixA = new double[ax][ay];
            System.out.println("Matrix A");
                    
            for(int i = 0; i < ax; i++){
                for(int j = 0 ; j < ay; j++){
                    System.out.print("Enter position " + (i+1) +","+ (j+1)+":");
                    matrixA[i][j] = input.nextDouble();
                }
            }
            //Fill matrix B
            double[][] matrixB = new double[bx][by];
            System.out.println("Matrix B");
                    
            for(int i = 0; i < bx; i++){
                for(int j = 0 ; j < by; j++){
                    System.out.print("Enter position " + (i+1) +","+ (j+1)+":");
                    matrixB[i][j] = input.nextDouble();
                }
            }
            
            for(int i = 0; i < matrixC.length; i++){
                for(int j = 0; j < matrixC[i].length; j++){
                    matrixC[i][j] = calculator(matrixA, matrixB, i, j);
                }
            }
            
            printResult(matrixC);
            
        }
        
    }
    
    public static double calculator(double[][] a, double[][] b, int x, int y){
        double sum = 0;
        
        for(int i = 0; i < a[x].length; i++){
            sum += a[x][i] * b[i][y];
        }
        
        return sum;
    }
    
    public static void printResult(double[][] c){
        for(int i = 0 ; i < c.length; i++){
            for(int j = 0; j < c[i].length; j++){
                if(c[i][j] < 0){
                    System.out.print("" + c[i][j]+ " ");
                }else {
                     System.out.print(" " + c[i][j]+ " ");
                }
            }
            System.out.println("");
        }
    }
    
    
    
}
