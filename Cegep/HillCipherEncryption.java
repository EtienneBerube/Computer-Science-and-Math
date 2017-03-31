
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
public class HillCipherEncryption {
     public static void main(String[] args){
        final String REF = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        System.out.print("Enter Text");
        
        Scanner input = new Scanner(System.in);
        
        String txt = input.nextLine();
        txt = txt.toUpperCase();
        System.out.println(txt);
        
        
        while(txt.length()%3!=0){
            txt+=" ";
        }
        
        char[] charArray = txt.toCharArray();
        
        for(char c: charArray){
            System.out.print(c + ",");
        }
        System.out.println("");
        String cipherTxt = "";
        
        System.out.print("Enter numebr of key");
        int[][] key = new int[3][3];
        for(int i = 0; i< key.length; i++){
            for(int j =0; j < key[i].length; j++){
                key[i][j]=input.nextInt();
            }
        }
        
        
        
        for(int i = 0; i < charArray.length; i++){
            int num1 = REF.indexOf(charArray[i]);
            
            int num2 = REF.indexOf(charArray[++i]);
            
            int num3 = REF.indexOf(charArray[++i]);
             
            System.out.println("num1 " + num1 + " num 2 " + num2);
            
            int cipherNum1 = (key[0][0]*num1 +key[0][1]*num2+key[0][2]*num3)%27;
            int cipherNum2 = (key[1][0]*num1 +key[1][1]*num2+key[1][2]*num3)%27;
            int cipherNum3 = (key[2][0]*num1 +key[2][1]*num2+key[2][2]*num3)%27;
            
            cipherTxt+= REF.charAt(cipherNum1)+""+REF.charAt(cipherNum2)+""+REF.charAt(cipherNum3);
            
        }
        
        System.out.println("New text is: "+ cipherTxt);
        
    }
}
