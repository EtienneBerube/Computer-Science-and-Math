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
public class LengthCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        double x1 = 15+ Math.random()*(485-15);
        double y1 = 15+ Math.random()*(485-15);
        double x2 = 15+ Math.random()*(485-15);
        double y2 = 15+ Math.random()*(485-15);
        
        Circle c1 = new Circle(x1, y1, 15);
        Circle c2 = new Circle(x2, y2, 15);
        
        Line bob = new Line(x1, y1, x2, y2);
        
        
        double length = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1), 2));
        
        Text text = new Text("" + length);
        text.setX((Math.max(x1, x2)- Math.min(x1,x2))/2+ Math.min(x1, x2));
        text.setY((Math.max(y1, y2)- Math.min(y1,y2))/2+ Math.min(y1, y2));
        text.setFill(Color.BLACK);
        
        
        pane.getChildren().addAll(bob, c1, c2, text);      
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
