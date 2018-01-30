/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author steven
 */
public abstract class Computer implements Player{
     private int winCount = 0;
     private Board board;
   
     protected int turnsPlayed = 0;
     
     public Computer(Board cells){
         board = cells;
     }
     public int getWin(){
         return winCount;
     }
     
     public Board getBoard(){
         return board;
     }
     
     public int getTurnsPlayed(){
         return turnsPlayed;
     }
     
     public void setComWin(){
         winCount++;
     }
     
     public void setWinStart(int win){
         winCount = win;
     }
     
     public abstract void placeToken(int i);
}

