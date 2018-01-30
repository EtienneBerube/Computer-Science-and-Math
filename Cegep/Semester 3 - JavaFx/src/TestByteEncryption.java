
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Étienne Bérubé
 */
public class TestByteEncryption {
    
    public static void main(String[] args){
        File in = new File("C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/file.txt");
        try {
            Scanner input = new Scanner(in);
            
            FileOutputStream out = new FileOutputStream("C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/crypted.txt");
            DataOutputStream output = new DataOutputStream(out);
            while(input.hasNext()){
                
                output.writeInt(input.nextInt()+4);
            }
            
            output.close();
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Input file does not exist");
        } catch(IOException x){
            System.out.println("Something went wrong bruh");
        };
        
       
        
    }
}
