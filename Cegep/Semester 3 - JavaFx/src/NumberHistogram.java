
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Étienne Bérubé
 */
public class NumberHistogram extends Pane{
    //ArrayList<Integer> list = new ArrayList<>();
    int[] list = new int[50];
    Line base = new Line(20, 250, 370, 250);
    Rectangle[] rec = new Rectangle[50];
    public static final int SELECTION = 1;
    public static final int INSERTION = 2;
    public static final int BUBBLE = 3;
    Thread sleeper = new Thread();
    
    public NumberHistogram(){
        
        for(int i = 0 ; i< 50; i++){
            list[i] = i+1;
        }
        
        
        for(int i = 0; i < list.length; i++){
            int index = (int)(Math.random()*50);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }
        
        
        for(int i = 0; i < list.length; i ++){
            rec[i] = new Rectangle((20 + i*7), 250, 5, list[i] * 3);
            rec[i].setTranslateY(-1 * rec[i].getHeight());
            rec[i].setStroke(Color.BLACK);
            rec[i].setFill(Color.WHITE);
            getChildren().add(rec[i]);
        }
        
        getChildren().add(base);
        
    }
    
    public synchronized void sort(int n, int index){
        if(n == 1){
                //rec[index].setFill(Color.BLACK);
                int minIndex = index;
                for(int j = index + 1; j < list.length; j++){
                    if(list[j] < list[minIndex])
                        minIndex = j;
                }
                int temp = list[index];
                list[index] = list[minIndex];
                list[minIndex] = temp;
                
                draw(index);
                
        }else if(n == 2){
            int temp;
                
                //rec[index].setFill(Color.BLACK);
                for(int j = index ; j > 0 ; j--){
                    if(list[j] < list[j-1]){
                        temp = list[j];
                        list[j] = list[j-1];
                        list[j-1] = temp;
                        
                        draw(index);
                    }
                }
        

            
        }else if(n == 3){
            
            int temp;
               
                //rec[index].setFill(Color.BLACK);
                for(int j=1; j < (list.length-index); j++){ //changed from list.length- index to list.length
                  
                    if(list[j-1] > list[j]){
                        temp = list[j-1];
                        list[j-1] = list[j];
                        list[j] = temp;
                        
                       
                    }
                    draw(j); 
                }
        }
    }

    public void draw(int index){
        this.getChildren().clear();
        
        for(Rectangle r : rec)
            r = null;
        
        for(int i = 0; i < list.length; i ++){
            rec[i] = new Rectangle((20 + i*7), 250, 5, list[i] * 3);
            rec[i].setTranslateY(-1 * rec[i].getHeight());
            rec[i].setStroke(Color.BLACK);
            
            if(i == index)
                rec[index].setFill(Color.color((Math.random()),(Math.random()),(Math.random())));
            else
                rec[i].setFill(Color.color((Math.random()),(Math.random()),(Math.random())));
                //rec[i].setFill(Color.WHITE);
            
            getChildren().add(rec[i]);
        }
        
        getChildren().add(base);
    }
    
    public int getListLength(){
        return list.length;
    }
}
