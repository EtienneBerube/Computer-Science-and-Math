/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;


import gui.Game;
import gui.Menu;
import java.io.File;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import objects.Board;
import objects.Cell;
import objects.Computer;
import objects.Easy;
import objects.Hard;
import objects.Human;
import objects.Medium;

/**
 *
 * @author steven
 */
public class GameEngine {
    private Settings settings;
    private Computer com;
    private Human human;
    private Board board ;
    private int turnNumber = 1;
    private boolean endGame = false;
    private MediaPlayer menu;
    private MediaPlayer turnSound;
    private Stage primaryStage;
   
    public GameEngine(Settings settings, Stage stage){
        primaryStage = stage;
        board = new Board();
        File fileMenu = new File("src/media/mainMenu.mp3");
         Media soundMenu = new Media(fileMenu.toURI().toString());
         menu  = new MediaPlayer(soundMenu);
         menu.stop();
         menu.seek(Duration.ZERO);
         menu.setVolume(0.2);
         menu.setCycleCount(INDEFINITE);
         menu.play();
       
        this.settings = settings;
        if(settings.getDifficulty().toLowerCase().compareTo("hard") == 0)
        com = new Hard(board);
       else if(settings.getDifficulty().toLowerCase().compareTo("easy") == 0)
       com = new Easy(board);
        else
           com = new Medium(board);
        
      
        
        human = settings.getHuman();
        human.setBoard(board);
        setAction();
    }
    // return the setting object
    public Settings getSettings(){
        return settings;
    }
      // set EndGame
    public synchronized void endGame(){
        endGame = true;
    }
    
    public void startMusic(){
        menu.play();
        
    }
    // get endGame
    
    public synchronized boolean isEndGame(){
        return endGame;
    }
    
  
    //return com object
    public synchronized Computer getCom(){
        return com;
    }
    //return human
    public synchronized Human getHuman(){
        return human;
    }
    
    public synchronized Board getBoard(){
        return board;
    }
    //play turn
    public synchronized void playTurn(){
        if(turnNumber % 2 == 0){
            com.turn();
  
      turnNumber++;
        }
               
    }
    public void updateHumanTurnCount(Text a, Text b){
        a.setText("Turn: " +( com.getTurnsPlayed()));
        b.setText(" Wins: " + this.human.getWin());
       }
     public void updateComTurnCount(Text a, Text b){
        a.setText("Turn: " +( com.getTurnsPlayed()));  
          b.setText(" Wins: " + settings.getSecondPlayerWins());
        }
     
     public void setEndGame(boolean status){
         endGame= status;
     }
     
     public boolean getEndGame(){
         return endGame;
     }
     
     public void checkForWin(Color color){
         for(int i = 0; i < 7; i++){
             for(int j = 0; j < 6; j++){
                 if(rowCheck(j,i,color)){
                     setEndGame(true);
                     return;
                 }     
             }
         }
         
         for(int i = 0; i < 7; i++){
             if(columnCheck(i, color)){
                 setEndGame(true);
                 return;
             }
         }
         
          for(int i = 0; i < 7; i++){
             for(int j = 0; j < 6; j++){
                 if(parallelCheck(i,j,color)){
                     setEndGame(true);
                     return;
                 }     
             }
         }
     }
     
     public void win(boolean human, boolean tie){
        GridPane pane = new GridPane();
         HBox menu = new HBox();
         Text winner = new Text();
         HBox txt = new HBox();
         txt.setPadding(new Insets(10,10,10,10));
         txt.setAlignment(Pos.CENTER);
         
         menu.setSpacing(25);
         menu.setPadding(new Insets(5,5,5,5));
         
         txt.getChildren().add(winner);
         pane.addRow(0, txt);
         
         Button restart = new Button("Restart");
         Button quit = new Button("Exit");
         
         menu.getChildren().addAll(restart, quit);
         menu.setAlignment(Pos.CENTER);
         
         pane.addRow(1, menu);
         
         if(human){
            File tokenaa = new File("src/media/Winning-sound-effect.mp3");
            Media soundTurnaa = new Media(tokenaa.toURI().toString());
           MediaPlayer aa = new MediaPlayer(soundTurnaa);
               aa = new MediaPlayer(soundTurnaa);
                aa.stop();
                aa.seek(Duration.ZERO);
                aa.setVolume(1);
                aa.play();
             winner.setText(settings.getPlayerName() + " has won");
             this.human.setWin();
         }
         else if(human == false && tie == false){
             File tokena = new File("src/media/groans.wav");
            Media soundTurna = new Media(tokena.toURI().toString());
           MediaPlayer a = new MediaPlayer(soundTurna);
               a = new MediaPlayer(soundTurna);
                a.stop();
                a.seek(Duration.ZERO);
                a.setVolume(1);
                a.play();
                
             winner.setText("CPU has won!");
          settings.addWin();
         }
             else
             winner.setText("TIE GAME");
     
         
         Scene scene = new Scene(pane, 100, 100);
         Stage winStage = new Stage();
         winStage.initModality(Modality.APPLICATION_MODAL);
         winStage.setScene(scene);
         winStage.setResizable(false);
         winStage.show(); 
         
         restart.setOnAction(e->{
           GameEngine engine = new GameEngine(settings, primaryStage);
           Game game = new Game(engine);
           game.start(primaryStage);
           winStage.close();
           
       });
         
         quit.setOnAction(e->{
             Menu newMenu = new Menu(settings);
             newMenu.start(primaryStage);
             winStage.close();
         });
         
     }
     
     public boolean parallelCheck(int startingColumn,int startingRow, Color color){
           FadeTransition flash1 = new FadeTransition();
        flash1.setDuration(Duration.millis(1000));
        flash1.setCycleCount(INDEFINITE);
        flash1.setToValue(0);
        
        FadeTransition flash2 = new FadeTransition();
        
        flash2.setDuration(Duration.millis(1000));
        flash2.setCycleCount(INDEFINITE);
        flash2.setToValue(0);
        
        FadeTransition flash3 = new FadeTransition();
        flash3.setDuration(Duration.millis(1000));
        flash3.setCycleCount(INDEFINITE);
        flash3.setToValue(0);
        
        FadeTransition flash4 = new FadeTransition();
        flash4.setDuration(Duration.millis(1000));
        flash4.setCycleCount(INDEFINITE);
        flash4.setToValue(0);
        
        if((startingColumn == 0 && startingRow < 3)
                ||(startingColumn <= 3 && startingRow == 0)){
            if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow + 3)).getFill() == color
                
                    ){
                       flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow + 3)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
            }

        }
        // remainder of left to right if the row is more than zero
        // also check the previos point and the next two
        else if(startingColumn > 1 && startingColumn <= 3 && startingRow > 0 && startingRow < 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)).getFill() == color
                 
                    ){
                flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow + 2)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
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
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow + 3)).getFill() == color
                
                    ){
              flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow + 3)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
            }
        }
         // check left from row
          if(startingColumn >= 3 && startingColumn < 6 && startingRow > 0 && startingRow < 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)).getFill() == color
             
                    ){
             flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow + 2)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
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
                    && ((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow - 3)).getFill() == color
                    ){
               flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn + 3).getChildren().get(startingRow - 3)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
            }
        }
        // remainder of left to right if the row is more than zero
        // also check the previos point and the next two
        else if(startingColumn > 1 && startingColumn <= 3 && startingRow < 5 && startingRow >= 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)).getFill() == color
                   
                    ){
                flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow + 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow - 1)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn + 2).getChildren().get(startingRow - 2)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
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
                    && ((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow - 3)).getFill() == color
                 
                    ){
                   flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn - 3).getChildren().get(startingRow - 3)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
            }
        }
         // check left from row
          if(startingColumn >= 3 && startingColumn < 6 && startingRow < 5 && startingRow >= 3){
              if(
            ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)).getFill() == color
               
                    ){
                  flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(startingRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn + 1).getChildren().get(startingRow + 1)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn - 1).getChildren().get(startingRow - 1)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn - 2).getChildren().get(startingRow - 2)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
            }
          }
         return false;
     }
     public boolean columnCheck(int startingColumn, Color color){
         
     FadeTransition flash1 = new FadeTransition();
        flash1.setDuration(Duration.millis(1000));
        flash1.setCycleCount(INDEFINITE);
        flash1.setToValue(0);
        
        FadeTransition flash2 = new FadeTransition();
        
        flash2.setDuration(Duration.millis(1000));
        flash2.setCycleCount(INDEFINITE);
        flash2.setToValue(0);
        
        FadeTransition flash3 = new FadeTransition();
        flash3.setDuration(Duration.millis(1000));
        flash3.setCycleCount(INDEFINITE);
        flash3.setToValue(0);
        
        FadeTransition flash4 = new FadeTransition();
        flash4.setDuration(Duration.millis(1000));
        flash4.setCycleCount(INDEFINITE);
        flash4.setToValue(0);
        
             if( ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(5)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(4)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(3)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(2)).getFill() == color
                    ){
                //add the consecutive Yellos
                   flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(5)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(4)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(3)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(2)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
                // end the if
            }
     else  if( ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(4)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(3)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(1)).getFill() == color
                    ){
                //add the consecutive Yellos
                        flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(4)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(3)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(2)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(1)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
                // end the if
            }
     
        else  if( ((Cell)getBoard().getCells().get(startingColumn).getChildren().get(3)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(2)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(1)).getFill() == color
                    && ((Cell)getBoard().getCells().get(startingColumn ).getChildren().get(0)).getFill() == color
                    ){
                //add the consecutive Yellos
                       flash1.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(3)));
              flash2.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(2)));
              flash3.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(1)));
              flash4.setNode(((Cell)getBoard().getCells().get(startingColumn).getChildren().get(0)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
                // end the if
            }
             return false;
     }
 
     
     public boolean rowCheck(int row, int column, Color color){
        FadeTransition flash1 = new FadeTransition();
        flash1.setDuration(Duration.millis(1000));
        flash1.setCycleCount(INDEFINITE);
        flash1.setToValue(0);
        
        FadeTransition flash2 = new FadeTransition();
        
        flash2.setDuration(Duration.millis(1000));
        flash2.setCycleCount(INDEFINITE);
        flash2.setToValue(0);
        
        FadeTransition flash3 = new FadeTransition();
        flash3.setDuration(Duration.millis(1000));
        flash3.setCycleCount(INDEFINITE);
        flash3.setToValue(0);
        
        FadeTransition flash4 = new FadeTransition();
        flash4.setDuration(Duration.millis(1000));
        flash4.setCycleCount(INDEFINITE);
        flash4.setToValue(0);
        
        int lastPlayedColumn = column;
        int lastPlayedRow = row;
        
        
        if(lastPlayedColumn == 0){
        if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 3).getChildren().get(lastPlayedRow)).getFill() == color){
              flash1.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)));
              flash3.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)));
              flash4.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 3).getChildren().get(lastPlayedRow)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
        }
        }
        // check the three other columns to the left
        else if(lastPlayedColumn == 6){
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 3).getChildren().get(lastPlayedRow)).getFill() == color
                      
                ){
               flash1.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)));
              flash3.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)));
              flash4.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 3).getChildren().get(lastPlayedRow)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
        }
        }
        // check if the last playedColumn is at 1
         else if(lastPlayedColumn == 1){
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
                      
                ){
               flash1.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)));
              flash3.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)));
              flash4.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
        }
        }
        
          // check if the last playedColumn is at 5
         else if(lastPlayedColumn == 5){
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                ){
               flash1.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)));
              flash3.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)));
              flash4.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
        }
        }
         /*
         
         */
         // anything else comesback to the same procedure
         else if(lastPlayedColumn >= 2 && lastPlayedColumn <= 4){            
              if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color 
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                      ){
            //set animation
               flash1.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)));
              flash3.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 2).getChildren().get(lastPlayedRow)));
              flash4.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
        }
               // check for the right possibilities
              else if(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)).getFill() == color
                && ((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)).getFill() == color
              
                      ){
            flash1.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn).getChildren().get(lastPlayedRow)));
              flash2.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 1).getChildren().get(lastPlayedRow)));
              flash3.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn + 2).getChildren().get(lastPlayedRow)));
              flash4.setNode(((Cell)getBoard().getCells().get(lastPlayedColumn - 1).getChildren().get(lastPlayedRow)));
              
              flash1.play();
              flash2.play();
              flash3.play();
              flash4.play();
              return true;
        }
         }
        
        return false;
     }
    private synchronized void setAction(){
      
        
        if(!endGame){
        for (Node children : board.getChildren()) {
            
            children.setOnMouseClicked(e->{
                VBox node = (VBox)children;
                for(int c= node.getChildren().size() - 1;c >= 0;c--){
                    if(this.com.getTurnsPlayed() == 21 && endGame == false){
                        win(false, true);
                    }
                    // check if red wins
                    
                    if(endGame){
                        win(false,false);
                        break;
                    }
                    Cell cell = (Cell) node.getChildren().get(c);
                    if(!cell.isSelected()){
                         if(turnNumber % 2 != 0){
                             File token = new File("src/media/button4.wav");
            Media soundTurn = new Media(token.toURI().toString());
           
                turnSound = new MediaPlayer(soundTurn);
                turnSound.stop();
                turnSound.seek(Duration.ZERO);
                turnSound.setVolume(1);
                turnSound.play();
                menu.play();
           
                             board.setLastPlayedColumn(board.getIndex(node));
                             board.setLastPlayedRow(c);
                             cell.setSelected(true);
                             turnNumber++;
                             this.checkForWin(Color.YELLOW);
                             if(getEndGame()){
                                 win(true,false);
                                 break;
                             }
                             playTurn();  
                    }
                             this.checkForWin(Color.RED);
                             if(endGame){
                        win(false,false);
                      
                        break;
                    }
                             if(this.com.getTurnsPlayed() == 21 && endGame == false){
                        win(false, true);
                           break;  
                         }                        
                         break;
                    }  
                }
            });    
        }    
    }
          if(getEndGame()){
                                 return;
                             }
    }
}
