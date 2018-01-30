/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import engine.GameEngine;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author steven
 */
public class Game extends Application {
    private GameEngine gameEngine;
   
    public Game(GameEngine engine){
        gameEngine = engine;
    }
    @Override
    public void start(Stage primaryStage) {
      
        BorderPane pane = new BorderPane();
        pane.setCenter(gameEngine.getBoard());
       
        gameEngine.getBoard().setBackGroundColor(gameEngine.getSettings().getBackgroundColor());

        HBox info = new HBox();
      
        info.setAlignment(Pos.CENTER);
        BorderPane playerOne = new BorderPane();
        BorderPane playerTwo = new BorderPane();
        
        Text name = new Text("Player One: " + gameEngine.getSettings().getPlayerName()); 
        Text turnsPlayed = new Text("Turn: " + gameEngine.getCom().getTurnsPlayed());
       
   
        Text playerWin = new Text("Wins: " + gameEngine.getHuman().getWin());
        
        playerOne.setTop(name);
        playerOne.setLeft(turnsPlayed);
        playerOne.setBottom(playerWin);
        playerOne.setPadding(new Insets(10,10,10,10));
        info.getChildren().add(playerOne);
        pane.setTop(info); 
        
        Timeline animation = new Timeline( new KeyFrame( Duration.millis( 100 ), e ->{
         gameEngine.updateHumanTurnCount(turnsPlayed, playerWin); 
      }));
        animation.setCycleCount(INDEFINITE);
        animation.play();
        
        
          Text name2 = new Text("Player Two: " + gameEngine.getSettings().getDifficulty()); 
        Text turnsPlayed2 = new Text("Turn: " + gameEngine.getCom().getTurnsPlayed());
       
    
        
        Text comWin = new Text("Wins: " + gameEngine.getCom().getWin());
        
        playerTwo.setTop(name2);
        playerTwo.setLeft(turnsPlayed2);
        
        playerTwo.setBottom(comWin);
        playerTwo.setPadding(new Insets(10,10,10,10));
        info.getChildren().add(playerTwo);
        info.setSpacing(80);
        
          Timeline animation2 = new Timeline( new KeyFrame( Duration.millis( 100 ), e ->{
         gameEngine.updateComTurnCount(turnsPlayed2,comWin); 
      }));
        animation2.setCycleCount(INDEFINITE);
        animation2.play();
        // loop
       
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
       
        // set the cell placing
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
