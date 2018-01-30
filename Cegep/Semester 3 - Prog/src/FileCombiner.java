
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/x1.txt C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/x2.txt C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/x3.txt C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Text Bank/comb.txt


/**
 *
 * @author Étienne Bérubé
 */
public class FileCombiner {
    public static void main(String[] args){
        if(args.length == 0){
            System.exit(0);
        }
        
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        System.out.println(args[3]);
        
        try{
            FileOutputStream out = new FileOutputStream(new File(args[args.length-1]), true);
            FileOutputStream del = new FileOutputStream(new File(args[args.length-1]), false);
            DataOutputStream output = new DataOutputStream(out);
            
            del.close();
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
