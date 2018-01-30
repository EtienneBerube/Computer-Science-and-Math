/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author steven
 */
public class Hard extends Computer {
    private final int TREAT_LEVEL_REACT = 2;
    private int lastColumn = 0;
    private int lastRow = 5;
     
    private ArrayList<Integer> columnCounterD;
     private ArrayList<Integer> highestRowTreat;
     private ArrayList<Integer> listOfDiagonal;
     private int treatLevel1 = 0;
     private int treatLevel2 = 0;
     private int treatLevel3 = 0;
     
    public Hard(Board board){
        super(board);
    }
  
    
    @Override
    public void turn() {
  
        /*
        To determine how we will play we will determine the highest risk at 
        every point in time based on the players last played position.
 
        */
     int rowNumber = getBoard().getLastPlayedRow();
     
     // because it is possible that the last play positions causes a possible winning row on-top it most be taking into consideration

    
   
      treatLevel1 = 0;
     treatLevel2 = 0;
     treatLevel3 = 0;
    int attackLevel1 = 0;
    int attackLevel2 = 0;
    int attackLevel3 = 0;
     
     ArrayList<ArrayList<Integer>> list = new ArrayList<>();
     ArrayList<ArrayList<Integer>> diagonal = new ArrayList<>();
         ArrayList<ArrayList<Integer>> listAttack = new ArrayList<>();
     ArrayList<ArrayList<Integer>> diagonalAttack = new ArrayList<>();

     // diagonals upper

     for(int i = 0; i < 7;i++){
         for(int k = 0; k < 6; k++){
             ArrayList<Integer> array = this.getDiagonalTreat(k, i, Color.YELLOW);
             diagonal.add(array);
         }
     }
      ArrayList<Integer> listOfDiagonal =this.findHighestRowTreat(diagonal);
      if(listOfDiagonal.size() == 1)
          treatLevel3 = 2;
        
      /*
      Attack Diagonals
      
      
      */
           for(int i = 0; i < 7;i++){
         for(int k = 0; k < 3; k++){
             ArrayList<Integer> array = this.getDiagonalTreat(k, i, Color.RED);
             diagonalAttack.add(array);
         }
     }
     
     //diagonalLower
      for(int i = 0; i < 7;i++){
         for(int k = 5; k > 3; k--){
             ArrayList<Integer> array = this.getDiagonalTreat(k, i, Color.RED);
              diagonalAttack.add(array);
         }
     }
      
      ArrayList<Integer> listOfDiagonalAttack =this.findHighestRowTreat(diagonalAttack);
      if(listOfDiagonalAttack.size() == 1)
          attackLevel3 = 2;
      
   
     /*
     FOR EVERY COLUMN
     */
        
     // fill up the list with all the rows of highest treat (size)
     for(int i = 0; i < 6; i++){
         for(int j = 0; j < 7; j++){
         ArrayList<Integer> toAdd = this.getRiskRateRow(i, j,Color.YELLOW);
         list.add(toAdd);
         }
     }
     
     ArrayList<Integer> highestRowTreat = findHighestRowTreat(list);
     if(highestRowTreat.size() == 1){
         treatLevel1 = 2;
     }
   
     // row attack
       // fill up the list with all the rows of highest treat (size)
     for(int i = 0; i < 6; i++){
         for(int j = 0; j < 7; j++){
         ArrayList<Integer> toAdd = this.getRiskRateRow(i, j,Color.RED);
         listAttack.add(toAdd);
         }
     }
     
     ArrayList<Integer> highestRowTreatAttack = findHighestRowTreat(listAttack);
     
     if(highestRowTreatAttack.size() == 1){
         attackLevel1 = 2;
     }
  
     /*
     We will begin by determing the amount of yellow in a row
     */
     // then we will analyse the risk in that line
    
     
     /*
     determine the amount of consecutive yellow cell above the played row
     */
    
     // determine columns
       ArrayList<ArrayList<Integer>> listColumnD = new ArrayList<>();
       for(int i = 0; i < 7;i++){
           listColumnD.add(this.getRiskRateColumn(i, Color.YELLOW));
       }
       ArrayList<Integer> columnCounterD = this.findHighestRowTreat(listColumnD);
       
       if(columnCounterD.size() == 1)
       treatLevel2 = 2; 
       
       /*
       RED attack counter column
       */
       
       // determine columns
       ArrayList<ArrayList<Integer>> listColumn = new ArrayList<>();
       for(int i = 0; i < 7;i++){
           listColumn.add(this.getRiskRateColumn(i, Color.RED));
       }
       ArrayList<Integer> columnCounter = this.findHighestRowTreat(listColumn);
      
    if(columnCounter.size() == 1)
       attackLevel2 = 2;  
       // compare which treatLevel is highest
 
   
    if(attackLevel3 >= TREAT_LEVEL_REACT){
        place(listOfDiagonalAttack);
    }
   else if(attackLevel2 >= attackLevel1 && attackLevel2 >= attackLevel3 && attackLevel2 >= this.TREAT_LEVEL_REACT){
       place(columnCounter);
   }
      else if(attackLevel1 >= attackLevel3 && attackLevel1 >= TREAT_LEVEL_REACT){
         place(highestRowTreatAttack);
      }
   
      else{
         playAttack(getBoard().getLastPlayedColumn(), getBoard().getLastPlayedRow());
      }
      turnsPlayed++;
   }

    public boolean checkConsequences(int column, int row){
         int rowNumber = getBoard().getLastPlayedRow();
        ((Cell)getBoard().getCells().get(column).getChildren().get(row)).setSelected(false);
     // because it is possible that the last play positions causes a possible winning row on-top it most be taking into consideration

    
   
     int treatLevel1 = 0;
     int treatLevel2 = 0;
     int treatLevel3 = 0;

     
     ArrayList<ArrayList<Integer>> list = new ArrayList<>();
     ArrayList<ArrayList<Integer>> diagonal = new ArrayList<>();
    ArrayList<ArrayList<Integer>> listAttack = new ArrayList<>();
 

     // diagonals upper

     for(int i = 0; i < 7;i++){
         for(int k = 0; k < 6; k++){
             ArrayList<Integer> array = this.getDiagonalTreat(k, i, Color.YELLOW);
             diagonal.add(array);
         }
     }
      
      ArrayList<Integer> listOfDiagonal =this.findHighestRowTreat(diagonal);
      if(listOfDiagonal.size() == 1)
          treatLevel3 = 2;

     // fill up the list with all the rows of highest treat (size)
     for(int i = 0; i < 6; i++){
         for(int j = 0; j < 7; j++){
         ArrayList<Integer> toAdd = this.getRiskRateRow(i, j,Color.YELLOW);
         list.add(toAdd);
         }
     }

     ArrayList<Integer> highestRowTreat = findHighestRowTreat(list);
     if(highestRowTreat.size() == 1){
         treatLevel1 = 2;
     }

     // determine columns
       ArrayList<ArrayList<Integer>> listColumnD = new ArrayList<>();
       for(int i = 0; i < 7;i++){
           listColumnD.add(this.getRiskRateColumn(i, Color.YELLOW));
       }
       ArrayList<Integer> columnCounterD = this.findHighestRowTreat(listColumnD);
       
       if(columnCounterD.size() == 1){
       treatLevel2 = 2; 
       }
       if(treatLevel2 >= 2){
           ((Cell)getBoard().getCells().get(column).getChildren().get(row)).reset();
           return true;
       }
       else if(treatLevel3 >= 2){
              ((Cell)getBoard().getCells().get(column).getChildren().get(row)).reset();
           return true;
       }
       else if(treatLevel1 >= 2){
              ((Cell)getBoard().getCells().get(column).getChildren().get(row)).reset();
           return true;
       }
       ((Cell)getBoard().getCells().get(column).getChildren().get(row)).reset();
        return false;
    }
    
   public void playAttack(int column, int row){     
        boolean status = false;
        int random = (int) (1 + Math.random() * 1);
       
           if(columnCounterD != null && treatLevel2 >= treatLevel1 && treatLevel2 > treatLevel3 && treatLevel2 >= this.TREAT_LEVEL_REACT){
       place(columnCounterD);
       status = true;
     }
      else if(highestRowTreat != null && treatLevel1 >= treatLevel3 && treatLevel1 >= TREAT_LEVEL_REACT){
        place(highestRowTreat);
        status = true;
      }
      else if(listOfDiagonal != null  && treatLevel3 >= TREAT_LEVEL_REACT){
        place(listOfDiagonal);
        status = true;
      }
        
       else if(random == 1){
           if(status == false && column > 0 && isRowDrop(column - 1, row )
               && ! this.checkConsequences(column - 1, row)
               ){
           placeToken(column - 1);
            status = true;
           
       }
     else if(status == false&& column < 6 && isRowDrop(column + 1, row )
               && ! this.checkConsequences(column + 1, row)){
               placeToken(column + 1);
                status = true;
       }
     else if(status == false && row > 0 && isRowDrop(column, row - 1) 
              && ! this.checkConsequences(column, row -1 )){
          placeToken(column);
          status = true;
               }
       
     else if(status == false&& column > 0 && row > 0 && isRowDrop(column - 1, row - 1 )
               && ! this.checkConsequences(column - 1, row - 1)){
               placeToken(column - 1);
                status = true;
       }
    
     else if(status == false&& column < 6 && row > 0 && isRowDrop(column + 1, row - 1 )
               && ! this.checkConsequences(column + 1, row - 1)){
               placeToken(column + 1);
                status = true;
       }
         
          else if(status == false&& column > 0 && row < 5 && isRowDrop(column - 1, row + 1 )
               && ! this.checkConsequences(column - 1, row + 1)){
               placeToken(column - 1);
                status = true;
       }
           
           else  if(status == false&& column < 6 && row < 5 && isRowDrop(column + 1, row + 1 )
               && ! this.checkConsequences(column + 1, row + 1)){
               placeToken(column + 1);
                status = true;
       }
        }
        // random == 2 change combinations
        else if(random == 2){   
               
               if(status == false&& column < 6 && row < 5 && isRowDrop(column + 1, row + 1 )
               && ! this.checkConsequences(column + 1, row + 1)){
               placeToken(column + 1);
                status = true;
       }
          else if(status == false && column > 0 && isRowDrop(column - 1, row )
               && ! this.checkConsequences(column - 1, row)
               ){
           placeToken(column - 1);
            status = true;
           
       }
     else if(status == false&& column < 6 && isRowDrop(column + 1, row )
               && ! this.checkConsequences(column + 1, row)){
               placeToken(column + 1);
                status = true;
       }
     else if(status == false && row > 0 && isRowDrop(column, row - 1) 
              && ! this.checkConsequences(column, row -1 )){
          placeToken(column);
          status = true;
               }
       
        else if(status == false&& column > 0 && row > 0 && isRowDrop(column - 1, row - 1 )
               && ! this.checkConsequences(column - 1, row - 1)){
               placeToken(column - 1);
                status = true;
       }
    
        else if(status == false&& column < 6 && row > 0 && isRowDrop(column + 1, row - 1 )
               && ! this.checkConsequences(column + 1, row - 1)){
               placeToken(column + 1);
                status = true;
       }
         
         else if(status == false&& column > 0 && row < 5 && isRowDrop(column - 1, row + 1 )
               && ! this.checkConsequences(column - 1, row + 1)){
               placeToken(column - 1);
                status = true;
       }
        }
           
           // random -> 3
           else if(random == 3){   
                 if(status == false&& column > 0 && row < 5 && isRowDrop(column - 1, row + 1 )
               && ! this.checkConsequences(column - 1, row + 1)){
               placeToken(column - 1);
                status = true;
       }
               else if(status == false&& column < 6 && row < 5 && isRowDrop(column + 1, row + 1 )
               && ! this.checkConsequences(column + 1, row + 1)){
               placeToken(column + 1);
                status = true;
       }
               else if(status == false && column > 0 && isRowDrop(column - 1, row )
               && ! this.checkConsequences(column - 1, row)
               ){
           placeToken(column - 1);
            status = true;
           
       }
               else if(status == false&& column < 6 && isRowDrop(column + 1, row )
               && ! this.checkConsequences(column + 1, row)){
               placeToken(column + 1);
                status = true;
       }
               else if(status == false && row > 0 && isRowDrop(column, row - 1) 
              && ! this.checkConsequences(column, row -1 )){
          placeToken(column);
          status = true;
               }
       
               else if(status == false&& column > 0 && row > 0 && isRowDrop(column - 1, row - 1 )
               && ! this.checkConsequences(column - 1, row - 1)){
               placeToken(column - 1);
                status = true;
       }
    
               else if(status == false&& column < 6 && row > 0 && isRowDrop(column + 1, row - 1 )
               && ! this.checkConsequences(column + 1, row - 1)){
               placeToken(column + 1);
                status = true;
       } 
        }
            
            //random -> 4
            // 
           else if(random == 4){   
                
                if(status == false&& column < 6 && row > 0 && isRowDrop(column + 1, row - 1 )
               && ! this.checkConsequences(column + 1, row - 1)){
               placeToken(column + 1);
                status = true;
       } 
               else if(status == false&& column > 0 && row < 5 && isRowDrop(column - 1, row + 1 )
               && ! this.checkConsequences(column - 1, row + 1)){
               placeToken(column - 1);
                status = true;
       }
               else if(status == false&& column < 6 && row < 5 && isRowDrop(column + 1, row + 1 )
               && ! this.checkConsequences(column + 1, row + 1)){
               placeToken(column + 1);
                status = true;
       }
               else if(status == false && column > 0 && isRowDrop(column - 1, row )
               && ! this.checkConsequences(column - 1, row)
               ){
           placeToken(column - 1);
            status = true;
           
       }
               else if(status == false&& column < 6 && isRowDrop(column + 1, row )
               && ! this.checkConsequences(column + 1, row)){
               placeToken(column + 1);
                status = true;
       }
               else if(status == false && row > 0 && isRowDrop(column, row - 1) 
              && ! this.checkConsequences(column, row -1 )){
          placeToken(column);
          status = true;
               }
       
               else if(status == false&& column > 0 && row > 0 && isRowDrop(column - 1, row - 1 )
               && ! this.checkConsequences(column - 1, row - 1)){
               placeToken(column - 1);
                status = true;
       } 
        }
            // random -> 5
            else if(random == 5){   
                 if(status == false&& column > 0 && row > 0 && isRowDrop(column - 1, row - 1 )
               && ! this.checkConsequences(column - 1, row - 1)){
               placeToken(column - 1);
                status = true;
       }
              else if(status == false&& column < 6 && row > 0 && isRowDrop(column + 1, row - 1 )
               && ! this.checkConsequences(column + 1, row - 1)){
               placeToken(column + 1);
                status = true;
       } 
                else if(status == false&& column > 0 && row < 5 && isRowDrop(column - 1, row + 1 )
               && ! this.checkConsequences(column - 1, row + 1)){
               placeToken(column - 1);
                status = true;
       }
                else if(status == false&& column < 6 && row < 5 && isRowDrop(column + 1, row + 1 )
               && ! this.checkConsequences(column + 1, row + 1)){
               placeToken(column + 1);
                status = true;
       }
            else if(status == false && column > 0 && isRowDrop(column - 1, row )
               && ! this.checkConsequences(column - 1, row)
               ){
           placeToken(column - 1);
            status = true;
           
       }
            else if(status == false&& column < 6 && isRowDrop(column + 1, row )
               && ! this.checkConsequences(column + 1, row)){
               placeToken(column + 1);
                status = true;
       }
       else if(status == false && row > 0 && isRowDrop(column, row - 1) 
              && ! this.checkConsequences(column, row -1 )){
          placeToken(column);
          status = true;
               }
        }
             // random -> 6
            else  if(random == 6){  
                  
                  if(status == false && row > 0 && isRowDrop(column, row - 1) 
              && ! this.checkConsequences(column, row -1 )){
          placeToken(column);
          status = true;
               } 
              else   if(status == false&& column > 0 && row > 0 && isRowDrop(column - 1, row - 1 )
               && ! this.checkConsequences(column - 1, row - 1)){
               placeToken(column - 1);
                status = true;
       }
              else if(status == false&& column < 6 && row > 0 && isRowDrop(column + 1, row - 1 )
               && ! this.checkConsequences(column + 1, row - 1)){
               placeToken(column + 1);
                status = true;
       } 
               else if(status == false&& column > 0 && row < 5 && isRowDrop(column - 1, row + 1 )
               && ! this.checkConsequences(column - 1, row + 1)){
               placeToken(column - 1);
                status = true;
       }
               else if(status == false&& column < 6 && row < 5 && isRowDrop(column + 1, row + 1 )
               && ! this.checkConsequences(column + 1, row + 1)){
               placeToken(column + 1);
                status = true;
       }
               else if(status == false && column > 0 && isRowDrop(column - 1, row )
               && ! this.checkConsequences(column - 1, row)
               ){
           placeToken(column - 1);
            status = true; 
       }
               else if(status == false&& column < 6 && isRowDrop(column + 1, row )
               && ! this.checkConsequences(column + 1, row)){
               placeToken(column + 1);
                status = true;
       }
        }
     
              // last random 
                   else if(random == 7){  
                        
                  if(status == false&& column < 6 && isRowDrop(column + 1, row )
               && ! this.checkConsequences(column + 1, row)){
               placeToken(column + 1);
                status = true;
       }
                else if(status == false && row > 0 && isRowDrop(column, row - 1) 
              && ! this.checkConsequences(column, row -1 )){
          placeToken(column);
          status = true;
               } 
                else if(status == false&& column > 0 && row > 0 && isRowDrop(column - 1, row - 1 )
               && ! this.checkConsequences(column - 1, row - 1)){
               placeToken(column - 1);
                status = true;
       }
                else if(status == false&& column < 6 && row > 0 && isRowDrop(column + 1, row - 1 )
               && ! this.checkConsequences(column + 1, row - 1)){
               placeToken(column + 1);
                status = true;
       } 
               else if(status == false&& column > 0 && row < 5 && isRowDrop(column - 1, row + 1 )
               && ! this.checkConsequences(column - 1, row + 1)){
               placeToken(column - 1);
                status = true;
       }
               else if(status == false&& column < 6 && row < 5 && isRowDrop(column + 1, row + 1 )
               && ! this.checkConsequences(column + 1, row + 1)){
               placeToken(column + 1);
                status = true;
       }
               else if(status == false && column > 0 && isRowDrop(column - 1, row )
               && ! this.checkConsequences(column - 1, row)
               ){
           placeToken(column - 1);
            status = true; 
       }
        
        }
         if (status == false){
           for(int i = 0; i < 7; i++){
               for(int j = 0; j < 6; j++){
                   if(isRowDrop(i,j) && ! this.checkConsequences(i, j)){
                       placeToken(i);
                       column = i;
                       row = j;
                       status = true;
                   return;
                   }
               }
           }
       }     
           if (status == false){
           for(int i = 0; i < 7; i++){
               for(int j = 0; j < 6; j++){
                   if(isRowDrop(i,j)){
                       placeToken(i);
                       column = i;
                       row = j;
                       status = true;
                   return;
                   }
               }
           }
       } 
       
   }
   
    public ArrayList<Integer> findHighestRowTreat(ArrayList<ArrayList<Integer>> list){
        
     
        int indexMax = 0;
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(indexMax).size() < list.get(i).size())
                indexMax = i;
        }
        
        return list.get(indexMax);   
    }
    @Override
      public void placeToken(int i) {
      
       
        // place the token in the first available slot in the selected column
        for(int b = 5; b >= 0;b-- ){
            if(!((Cell)getBoard().getCells().get(i).getChildren().get(b)).isSelected()){
                System.out.println("----------------------" + this.checkConsequences(i, b) + "\nColumn" + i + "\nRow " + b);
                ((Cell)getBoard().getCells().get(i).getChildren().get(b)).setSelected(false);
              
                break;
            }
                
        }
       
    }
      
      public void place(ArrayList<Integer> list){
          if(list.size() == 1)
              placeToken(list.get(0));
      }
    // check if the column is Full
    public boolean isColumnFull(int i){
       boolean status = false;
        for(int b = 5; b >= 0;b-- ) {
            if(!((Cell)getBoard().getCells().get(i).getChildren().get(b)).isSelected()){
               status = true;
               break;
            }             
                        }
        return status;
    }
    
    public int lowestRow(int i){
       int lowest = 0;
        for(int b = 5; b >= 0;b-- ) {
            if(!((Cell)getBoard().getCells().get(i).getChildren().get(b)).isSelected()){
               lowest = b;
               break;
            }             
                        }
        return lowest;
    }
    
    public boolean isRowDrop(int column, int row){
        boolean status = false;
        
        if( row < 5 && ((Cell)getBoard().getCells().get(column).getChildren().get(row)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(column).getChildren().get(row + 1)).getFill() != Color.WHITE){
            status = true;
        }
        else if( row == 5 && ((Cell)getBoard().getCells().get(column).getChildren().get(row)).getFill() == Color.WHITE ){
           status = true;
        }
        return status;
    }
    
    public ArrayList<Integer> getRiskRateRow(int i, int j, Color color){
        int lastPlayedColumn = j;
        int lastPlayedRow = i;
        ArrayList<Integer> consecutiveYellows = new ArrayList<>();
        
        if(lastPlayedColumn == 0){
        if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 3).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
                && this.isRowDrop(lastPlayedColumn + 3,lastPlayedRow)
                ){
            consecutiveYellows.add(lastPlayedColumn + 3);
        }
        else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 3).getChildren().get(lastPlayedRow)).getFill() == color
                 && this.isRowDrop(lastPlayedColumn + 1,lastPlayedRow)
                ){
                consecutiveYellows.add(lastPlayedColumn + 1);
        }
         else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 3).getChildren().get(lastPlayedRow)).getFill() == color
                  && this.isRowDrop(lastPlayedColumn + 2,lastPlayedRow)
                 ){
                 consecutiveYellows.add(lastPlayedColumn + 2);
        }
        
            }
        // check the three other columns to the left
        else if(lastPlayedColumn == 6){
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 3).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
                       && this.isRowDrop(lastPlayedColumn - 3,lastPlayedRow)
                ){
            consecutiveYellows.add(lastPlayedColumn - 3);
        }
        else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 3).getChildren().get(lastPlayedRow)).getFill() == color
                 && this.isRowDrop(lastPlayedColumn - 1,lastPlayedRow)
                ){
             consecutiveYellows.add(lastPlayedColumn - 1);
            
        }
         else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 3).getChildren().get(lastPlayedRow)).getFill() == color
                && this.isRowDrop(lastPlayedColumn - 2,lastPlayedRow)
                 ){
             consecutiveYellows.add(lastPlayedColumn - 2);
               
        }
        }
        // check if the last playedColumn is at 1
         else if(lastPlayedColumn == 1){
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
                       && this.isRowDrop(lastPlayedColumn + 2,lastPlayedRow)
                ){
            consecutiveYellows.add(lastPlayedColumn + 2);
        }
        else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1 ).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
               && this.isRowDrop(lastPlayedColumn - 1,lastPlayedRow)
                ){
             consecutiveYellows.add(lastPlayedColumn -1);
        }
         else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
                && this.isRowDrop(lastPlayedColumn + 1,lastPlayedRow)
                 ){
             consecutiveYellows.add(lastPlayedColumn + 1);
             
        }
        }
          // check if the last playedColumn is at 5
         else if(lastPlayedColumn == 5){
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
                       && this.isRowDrop(lastPlayedColumn - 2,lastPlayedRow)
                ){
            consecutiveYellows.add(lastPlayedColumn - 2);
        }
        else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1 ).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                 && this.isRowDrop(lastPlayedColumn + 1,lastPlayedRow)
                ){
             consecutiveYellows.add(lastPlayedColumn +1);
        }
         else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                && this.isRowDrop(lastPlayedColumn - 1,lastPlayedRow)
                 ){
             consecutiveYellows.add(lastPlayedColumn - 1);
        }
        }
         /*
         
         */
         // anything else comesback to the same procedure
         else if(lastPlayedColumn >= 2 && lastPlayedColumn <= 4){            
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
                && this.isRowDrop(lastPlayedColumn +1,lastPlayedRow)
                      ){
            consecutiveYellows.add(lastPlayedColumn +1);
        }
                  else if(color == Color.YELLOW && ((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1 ).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1 ).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
                && this.isRowDrop(lastPlayedColumn - 1,lastPlayedRow)
                ){
             consecutiveYellows.add(lastPlayedColumn - 1);   
        }
        else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2 ).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && this.isRowDrop(lastPlayedColumn - 1,lastPlayedRow)
                ){
             consecutiveYellows.add(lastPlayedColumn - 1);
               
        }
         else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                  && this.isRowDrop(lastPlayedColumn - 2,lastPlayedRow)
                 ){
             consecutiveYellows.add(lastPlayedColumn - 2);
        }
               // check for the right possibilities
              else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE
               && this.isRowDrop(lastPlayedColumn - 1,lastPlayedRow)
                      ){
            consecutiveYellows.add(lastPlayedColumn - 1);
        }
        else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2 ).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
               && this.isRowDrop(lastPlayedColumn + 1,lastPlayedRow)
                ){
             consecutiveYellows.add(lastPlayedColumn + 1);
        }
         else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == Color.WHITE 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                 && this.isRowDrop(lastPlayedColumn + 2,lastPlayedRow)
                 ){
             consecutiveYellows.add(lastPlayedColumn + 2);
               
        }
         }
         else{
             consecutiveYellows.add(lastPlayedColumn);
         }
        return consecutiveYellows;
    }
    
    public ArrayList<Integer> getRiskRateColumn(int i, Color color){
           ArrayList<Integer> consecutiveYellows = new ArrayList<>();
          int startingColumn = i;
     if( ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(5)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(4)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(3)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(2)).getFill() == Color.WHITE
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn);
                // end the if
            }
     else  if( ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(4)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(3)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(1)).getFill() == Color.WHITE
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn);
                // end the if
            }
     
        else  if( ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(3)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(0)).getFill() == Color.WHITE
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn);
                // end the if
            }
     
     return consecutiveYellows;
    }
    
    public ArrayList<Integer> getDiagonalTreat(int row, int column, Color color){
        int startingColumn = column;
        int startingRow = row;
        ArrayList<Integer> consecutiveYellows = new ArrayList<>();
    
        // two exceptions when column == 0 and 6
        /*
        
        when the row changes, check the previous points, and check the next two points
        */
        
        //what to do if column == 0(do the same thing for everything including rows)
        
        if((startingColumn == 0 && startingRow < 3)
                ||(startingColumn <= 3 && startingRow == 0)){
            if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow + 3)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn + 3, startingRow + 3)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 3);
                // end the if
            }
            
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow + 3)).getFill() == color
                    && this.isRowDrop(startingColumn + 2, startingRow + 2)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 2);
                // end the if
            }
            else 
                 if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow + 3)).getFill() == color
                    && this.isRowDrop(startingColumn + 1, startingRow + 1)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 1);
                // end the if
            }
        }
        // remainder of left to right if the row is more than zero
        // also check the previos point and the next two
        else if(startingColumn > 1 && startingColumn <= 3 && startingRow > 0 && startingRow < 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn + 2, startingRow + 2)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 2);
                // end the if
            }
            // another possibility
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == color
                    && this.isRowDrop(startingColumn + 1, startingRow + 1)
                    ){
                //add the consecutive Yellos
                consecutiveYellows.add(startingColumn + 1);
                // end the if
            }
            else 
                 if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow -1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == color
                    && this.isRowDrop(startingColumn - 1, startingRow - 1)
                    ){
                //add the consecutive Yellos

                   consecutiveYellows.add(startingColumn - 1);
                // end the if
            }
        }
        /*
        Reverse the direction of the search from right to left
        Keep the addition as the components from the right to the left
        */
        
         if((startingColumn >= 3 && startingRow < 3)
                ||(startingColumn >= 3 && startingRow == 0)){
            if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow + 3)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn - 3, startingRow + 3)
                    ){
                //add the consecutive Yellos

                consecutiveYellows.add(startingColumn - 3);
                // end the if
            }
            
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow + 3)).getFill() == color
                    && this.isRowDrop(startingColumn - 2, startingRow + 2)
                    ){
                //add the consecutive Yellos
                consecutiveYellows.add(startingColumn - 2);
                // end the if
            }
            else 
                 if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow + 3)).getFill() == color
                    && this.isRowDrop(startingColumn - 1, startingRow + 1)
                    ){
                //add the consecutive Yellos
              
                   consecutiveYellows.add(startingColumn - 1);
                // end the if
            }
        }
         // check left from row
          if(startingColumn >= 3 && startingColumn < 6 && startingRow > 0 && startingRow < 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn - 2, startingRow + 2)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn - 2);
                // end the if
            }
            // another possibility
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)).getFill() == color
                    && this.isRowDrop(startingColumn - 1, startingRow + 1)
                    ){
                //add the consecutive Yellos
                consecutiveYellows.add(startingColumn - 1);
                // end the if
            }
            else 
                 if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow -1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)).getFill() == color
                    && this.isRowDrop(startingColumn + 1, startingRow - 1)
                    ){
                //add the consecutive Yellos

                   consecutiveYellows.add(startingColumn + 1);
                // end the if
            }
        }
          
          /*
          Wash and repeat the same process, but from the bottoms up
          Check the bottom half of the board for any potential winning situations and return the missing column
          */
          
          if((startingColumn == 0 && startingRow >= 3)
                ||(startingColumn <= 3 && startingRow == 5)){
            if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow - 3)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn + 3, startingRow - 3)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 3);
                // end the if
            }
            
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow - 3)).getFill() == color
                    && this.isRowDrop(startingColumn + 2, startingRow - 2)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 2);
                // end the if
            }
            else 
                 if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow - 3)).getFill() == color
                    && this.isRowDrop(startingColumn + 1, startingRow - 1)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 1);
                // end the if
            }
        }
        // remainder of left to right if the row is more than zero
        // also check the previos point and the next two
        else if(startingColumn > 1 && startingColumn <= 3 && startingRow < 5 && startingRow >= 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn + 2, startingRow - 2)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn + 2);
                // end the if
            }
            // another possibility
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)).getFill() == color
                    && this.isRowDrop(startingColumn + 1, startingRow - 1)
                    ){
                //add the consecutive Yellos
                consecutiveYellows.add(startingColumn + 1);
                // end the if
            }
            else 
                 if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow +1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)).getFill() == color
                    && this.isRowDrop(startingColumn - 1, startingRow + 1)
                    ){
                //add the consecutive Yellos

                   consecutiveYellows.add(startingColumn - 1);
                // end the if
            }
        }
          
          // reverse the order 
          // for the 2nd half
          if((startingColumn >= 3 && startingRow > 3)
                ||(startingColumn >= 3 && startingRow == 5)){
            if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow - 3)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn - 3, startingRow - 3)
                    ){
                //add the consecutive Yellos

                consecutiveYellows.add(startingColumn - 3);
                // end the if
            }
            
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow - 3)).getFill() == color
                    && this.isRowDrop(startingColumn - 2, startingRow - 2)
                    ){
                //add the consecutive Yellos
                consecutiveYellows.add(startingColumn - 2);
                // end the if
            }
            else 
                 if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow - 3)).getFill() == color
                    && this.isRowDrop(startingColumn - 1, startingRow - 1)
                    ){
                //add the consecutive Yellos
              
                   consecutiveYellows.add(startingColumn - 1);
                // end the if
            }
        }
         // check left from row
          if(startingColumn >= 3 && startingColumn < 6 && startingRow < 5 && startingRow >= 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)).getFill() == Color.WHITE
                    && this.isRowDrop(startingColumn - 2, startingRow - 2)
                    ){
                //add the consecutive Yellos
                   consecutiveYellows.add(startingColumn - 2);
                // end the if
            }
            // another possibility
            else  if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)).getFill() == color
                    && this.isRowDrop(startingColumn - 1, startingRow - 1)
                    ){
                //add the consecutive Yellos
                consecutiveYellows.add(startingColumn - 1);
                // end the if
            }
            else if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow +1)).getFill() == Color.WHITE
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)).getFill() == color
                    && this.isRowDrop(startingColumn + 1, startingRow +1)
                    ){
                //add the consecutive Yellos
                
                   consecutiveYellows.add(startingColumn + 1);
                // end the if
            }
        }
        return consecutiveYellows;    
     }
 
}
