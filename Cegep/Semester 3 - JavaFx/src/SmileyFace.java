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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class SmileyFace extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        Circle circle = new Circle(250,250, 200);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        Ellipse rightEye = new Ellipse(350, 175 ,50, 40);
        rightEye.setFill(Color.WHITE);
        rightEye.setStroke(Color.BLACK);
       
        Ellipse leftEye = new Ellipse(150, 175 ,50, 40);
        leftEye.setFill(Color.WHITE);
        leftEye.setStroke(Color.BLACK);
        
        Circle rightPupil = new Circle(350, 175, 20);
        rightPupil.setFill(Color.BLACK);
       
        Circle leftPupil = new Circle(150, 175, 20);
        leftPupil.setFill(Color.BLACK);
        
        Polygon nose = new Polygon();
        
        Arc mouth = new Arc(250, 350, 100, 50, 180, 180);
        mouth.setFill(Color.WHITE);
        mouth.setStroke(Color.BLACK);
        
        
        
        nose.getPoints().addAll(250.0, 200.0, 300.0, 300.0, 200.0, 300.0);
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);
        
        pane.getChildren().addAll(circle,rightEye, leftEye, rightPupil, leftPupil, nose, mouth);
        Scene scene = new Scene(pane, 500, 500);
        
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
