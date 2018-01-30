/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class MovingBall extends Application {
    static double x = 27.0;
    static double y = 27.0;        
   
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        
        Pane cpane = new Pane();
        
        
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
        pane.setBottom(hbox);
        pane.setCenter(cpane);
      
        BorderPane.setAlignment(hbox, Pos.BOTTOM_CENTER);
        
        Circle ball = new Circle(x, y, 25.0);
        ball.setStroke(Color.BLACK);
        ball.setFill(Color.BLUE);
        
        cpane.getChildren().add(ball);
       
        Button up = new Button("up");
        up.setOnAction(e -> {
        if(ball.getCenterY() > ball.getRadius() )
          ball.setCenterY(ball.getCenterY()-5);
        });
        
        Button down = new Button("Down");
        down.setOnAction(e -> {
        if(ball.getCenterY() < pane.getHeight()-ball.getRadius()-down.getHeight()-20 )
          ball.setCenterY(ball.getCenterY()+5);
        });
        
        Button left = new Button("Left");
        left.setOnAction(e -> {
        if(ball.getCenterX() > ball.getRadius())
          ball.setCenterX(ball.getCenterX()-5);
        });
        
        Button right = new Button("Right");
        right.setOnAction(e -> {
        if(ball.getCenterX() < pane.getWidth()- ball.getRadius() )
          ball.setCenterX(ball.getCenterX()+5);
        });
        
        hbox.getChildren().addAll(up, down, left, right);
        
        
        
        
        
        
        Scene scene = new Scene(pane, 300, 300);
        
        primaryStage.setTitle("My moving balls");
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
