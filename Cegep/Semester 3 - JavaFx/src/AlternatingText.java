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
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class AlternatingText extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        StackPane root = new StackPane();
        
        
        Label lbl = new Label("Java is fun");
        lbl.setTextFill(Color.RED);
        
        root.getChildren().add(lbl);
     
        /* 
        x.translateYProperty().bind(root.heightProperty().divide(3));
        x.translateXProperty().bind(root.widthProperty().divide(2));
        */
        
        lbl.setOnMouseClicked(e -> {
            if(lbl.getText().equals("Java is fun")){
                lbl.setText("Programming is powerful");
               
            }else{
                lbl.setText("Java is fun");
               
            }
        });
       
        Scene scene = new Scene(root, 300, 250);
        
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
