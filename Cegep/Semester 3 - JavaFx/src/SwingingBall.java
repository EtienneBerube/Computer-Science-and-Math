/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
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
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class SwingingBall extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Arc arc = new Arc(150, 125, 100, 50, 180, 180);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        
        Circle circ = new Circle(10);
        
        
        root.getChildren().addAll(arc, circ);
        
        
        PathTransition path = new PathTransition(Duration.millis(1000), arc, circ);
        path.setAutoReverse(true);
        path.setCycleCount(Timeline.INDEFINITE);
        path.play();
        

        Scene scene = new Scene(root, 300, 250);
        
        scene.setOnMousePressed(e -> path.pause());
        scene.setOnMouseReleased(e -> path.play());
        
        
        
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
