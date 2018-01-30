
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Étienne Bérubé
 */
public class ThreadSum {
    
    static Integer sum = 0;
    
    public static void main(String[] args){
    
        ExecutorService x = Executors.newFixedThreadPool(1000);
        
        for(int i = 0; i < 1000 ; i++){
            x.execute(new Runnable() {
                @Override
                public void run() {
                    addONENS();
                }
            });
        }
        
        x.shutdown();
        
        System.out.println("Non Synchronised: " + sum);
        
        sum = 0;
        
        ExecutorService y = Executors.newFixedThreadPool(1000);
        
        for(int i = 0; i < 1000 ; i++){
            y.execute(new Runnable() {
                @Override
                public void run() {
                   addONES();
                }
            });
        }
        y.shutdown();
        
        System.out.println("Synchronised: " + sum);
        
        
        
    }
    
    public static synchronized void addONES(){
        sum += 1;
    }
    
    public static void addONENS(){
        sum += 1;
    }
   
  
    
}

