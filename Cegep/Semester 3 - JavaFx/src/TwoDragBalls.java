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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class TwoDragBalls extends Application {
        double x1 = Math.random()*290 + 10;
        double y1 = Math.random()*290 + 10;
        double x2 = Math.random()*290 + 10;
        double y2 = Math.random()*290 + 10;
        
        Circle c1 = new Circle(x1, y1, 10.0);
        Circle c2 = new Circle(x2, y2, 10.0);
    
        @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        
        Line line = new Line(x1, y1, x2, y2);
        Text text = new Text("");
       
        text.setX((Math.max(x1, x2)- Math.min(x1,x2))/2+ Math.min(x1, x2));
        text.setY((Math.max(y1, y2)- Math.min(y1,y2))/2+ Math.min(y1, y2));
        text.setText("" + String.format("%2.0f", getDistance() ));
        text.setFill(Color.BLACK);
        
        c1.setOnMouseDragged(e -> {
        
            c1.setCenterX(e.getX());
            c1.setCenterY(e.getY());
            text.setText("" + String.format("%2.0f", getDistance() ));
            line.setStartX(c1.getCenterX());
            line.setStartY(c1.getCenterY());
            line.setEndX(c2.getCenterX());
            line.setEndY(c2.getCenterY());
            
            text.setX((Math.max(c1.getCenterX(), c2.getCenterX())- Math.min(c1.getCenterX(), c2.getCenterX()))/2+ Math.min(c1.getCenterX(), c2.getCenterX()));
            text.setY((Math.max(c1.getCenterY(), c2.getCenterY())- Math.min(c1.getCenterY(), c2.getCenterY()))/2+ Math.min(c1.getCenterY(), c2.getCenterY()));
        
        });
        
        c2.setOnMouseDragged(e -> {
        
            c2.setCenterX(e.getX());
            c2.setCenterY(e.getY());
            text.setText("" + String.format("%2.0f", getDistance() ));
            line.setStartX(c2.getCenterX());
            line.setStartY(c2.getCenterY());
            line.setEndX(c1.getCenterX());
            line.setEndY(c1.getCenterY());
            
            text.setX((Math.max(c1.getCenterX(), c2.getCenterX())- Math.min(c1.getCenterX(), c2.getCenterX()))/2+ Math.min(c1.getCenterX(), c2.getCenterX()));
            text.setY((Math.max(c1.getCenterY(), c2.getCenterY())- Math.min(c1.getCenterY(), c2.getCenterY()))/2+ Math.min(c1.getCenterY(), c2.getCenterY()));
        
        
        });
        
        root.getChildren().addAll(line, c1, c2, text);
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("k");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public double getDistance(){
        return Math.sqrt(Math.pow((c2.getCenterX() - c1.getCenterX()),2) + Math.pow((c2.getCenterY() - c1.getCenterY()), 2));
    }
    
}
