
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
public class FileCombiner {
    public static void main(String[] args){
        /*
        args = new String[4];
        
        args[0] = "C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/x1.txt";
        args[1] = "C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/x2.txt";
        args[2] = "C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/x3.txt";
        args[3] = "C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/comb.txt";
        */
        try{
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
            System.out.println(args[3]);
            FileOutputStream out = new FileOutputStream(new File(args[args.length-1]), true);
            DataOutputStream output = new DataOutputStream(out);
            
            for(int i = 0 ; i < args.length-1;i++){
                File file = new File(args[i]);
                
                Scanner in = new Scanner(file);
                
                while(in.hasNext()){
                    output.writeUTF(in.next());
                }
                
            }
            
            output.close();
            out.close();
            
            DataInputStream byteIn = new DataInputStream(new FileInputStream(args[3]));
            
            while(byteIn.available() != 0){
                System.out.print(" " + byteIn.readUTF());
            }
            
        }catch(FileNotFoundException x){
            System.out.println("File does not exist bruh");
        } catch (IOException ex) {
            System.out.println("nope (io Ex)");;
        }
    }
}
