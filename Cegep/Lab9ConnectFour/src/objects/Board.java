/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author steven
 */
public class Board extends GridPane{
    private ArrayList<VBox> cells = new ArrayList<>();
     private int lastPlayed = 0;
    private int lastPlayedCell = 0;
    
    public Board(){
        // fill up the board with 42 cells
        // 6 rows of 7
        this.setAlignment(Pos.CENTER);
        for(int i = 1; i <= 7; i++){
            VBox circle = new VBox();
            circle.setSpacing(15);
            circle.setPadding(new Insets(10,10,10,10));
            for(int j = 0; j < 6; j++){
                Cell cell = new Cell();
                cell.setFill(Color.WHITE);
                cell.setRadius(25);
                cell.setStroke(Color.BLACK);
                circle.getChildren().add(cell);
               
                
            }
            this.addColumn(i, circle); 
            cells.add(circle);
        }
    }
    //get the cells
    public ArrayList<VBox> getCells(){
        return cells;
    }
    // set the backGroundColor
    public void setBackGroundColor(Color color){
        if(color == Color.WHITE)
      this.setStyle("-fx-background-color: white");
        else  if(color == Color.BLACK)
      this.setStyle("-fx-background-color: black");
        else
      this.setStyle("-fx-background-color: blue");
    }
    
    // return VBox number
    public int getIndex(VBox vbox){
        int index= 0;
        for(int i = 0; i < this.getChildren().size();i++){
            if(((VBox)this.getChildren().get(i)).equals(vbox) ){
                index=i;
            break;
            }
        }
        return index;
    }
      // return lastPlayedColumn
    public int getLastPlayedColumn(){
        return lastPlayed;
    }
    
    // return last playedRow
    
    public int getLastPlayedRow(){
        return lastPlayedCell;
    }
    
     public void setLastPlayedColumn(int i){
       lastPlayed = i;
    }
    
    // return last playedRow
    
    public void setLastPlayedRow(int i){
        lastPlayedCell = i;
    }
}
