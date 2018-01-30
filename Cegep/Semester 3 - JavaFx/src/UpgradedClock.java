/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.Clock;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class UpgradedClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      ClockPane ck = new ClockPane();
      Label lblCurrentTime = new Label("" + ck.getHour() + ":" + ck.getMinute()+":"+ck.getSecond());  
     
              
      BorderPane pane = new BorderPane();
      pane.setCenter(ck);
      BorderPane.setAlignment(ck, Pos.CENTER_RIGHT);
      pane.setBottom(lblCurrentTime);
      BorderPane.setAlignment(lblCurrentTime,Pos.TOP_CENTER);
              
        Scene scene = new Scene(pane, 250, 275);
        
        primaryStage.setTitle("Upgraded Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
