/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author steven
 */
public class InsertionSortThread implements Runnable {
    private int[] list;
    
    public InsertionSortThread(int[] array){
       list = array;
    }

    @Override
    public void run() {
       for(int i = 1; i < list.length; i++){
           int currentElement = list[i];
           int k;
           for(k = i - 1; k >= 0 && list[k] > currentElement; k--){
               list[k + 1] = list[k];
           }
           
           list[k + 1] = currentElement;
           try {
               Thread.sleep(500);
           } catch (InterruptedException ex) {
               Logger.getLogger(InsertionSortThread.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
      
    };
    
    
    
}
