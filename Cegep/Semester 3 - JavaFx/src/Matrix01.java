/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class Matrix01 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grd = new GridPane();
        for(int i = 0; i< 10; i++){
            for(int j = 0; j < 10; j++){
                grd.add(new TextField("" + ((int)(Math.random()*2))), j, i);
            }
        }
        
        Scene scene = new Scene(grd,500,312);
        
        primaryStage.setTitle("Hello World!");
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
