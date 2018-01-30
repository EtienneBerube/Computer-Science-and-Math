
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
public class TestByteDecryption {
     
    public static void main(String[] args){
        File file = new File("C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/crypted.txt");
        try{
            FileInputStream in = new FileInputStream(file);
            //System.out.println(""+ file.exists());
            DataInputStream input = new DataInputStream(in);
           
           // PrintWriter out = new PrintWriter("C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/decrypted.txt");
            
            while(input.available() != 0){
                System.out.println(input.readInt()-4);
                
            }
            
            //out.close();
        
        } catch (FileNotFoundException ex) {
            System.out.println("Input file does not exist");
        } catch(IOException x){
            System.out.println("Something went wrong bruh");
        };
        
       
        
    }
}
