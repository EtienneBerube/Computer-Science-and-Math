/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author steven
 */
public class Human implements Player{
    private String userName;
    private int winCount = 0;
    private Board board;
    
    public Human(Board cells){
        userName = "Human";
        board = cells;
    }
    
    public Human(String setName, Board cells){
        userName = setName;
         board = cells;
    }
     public Human(String setName){
        userName = setName;
    }
    
     public void setBoard(Board board){
         this.board = board;
     }
    public String getName(){
        return userName;
    }
    
    public void setName(String newName){
        userName = newName;
    }
    
    public int getWin(){
        return winCount;
    }
    
    public void setWin(){
        winCount++;
    }
    
    @Override
    public void turn() {
        // just do it
    }
    
    public Board getBoard(){
        return board;
    }
    
}
