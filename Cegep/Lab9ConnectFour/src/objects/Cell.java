/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author steven
 */
public class Cell extends Circle{
    private boolean selected = false;
    
    public Cell(){
        selected = false;
    }
    
    //return to selected
    public synchronized boolean isSelected(){
        return selected;
    }
    //set is selected
   public void setSelected(boolean human){
     
        if(human)
        this.setFill(Color.YELLOW);
        else 
            this.setFill(Color.RED);
        selected = true;
    }
   
   public void reset(){
       setFill(Color.WHITE);
       selected = false;
   }

}
