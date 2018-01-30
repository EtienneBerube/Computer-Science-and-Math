/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
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
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class BeamShell extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        int[] arr = {0,0,0,0,0,0,0};

//******************************************Shell**************************************************
        Polyline shell = new Polyline();
        shell.getPoints().addAll(220.0, 50.0, 220.0, 85.0, 100.0, 400.0, 100.0, 450.0, 400.0, 450.0, 400.0, 400.0, 280.0, 85.0, 280.0, 50.0);
        
        double xStartPos = 250.0;
        double yStartPos = 80.0;
        double xCurrentPos;
        
        for(int i = 0; i < 7; i++){
            xCurrentPos = xStartPos;            
            
            for(int j = 0; j < i; j++){
                root.getChildren().add(new Circle(xCurrentPos+20, yStartPos, 5.0, Color.BLACK));
                xCurrentPos += 30+10;
                
            }
            xStartPos -= 15+5;
            yStartPos += 32+15;
        }
        
        root.getChildren().add(shell);
        
        Line line1 = new Line(150, 365, 150, 450);
        Line line2 = new Line(190, 365, 190, 450);
        Line line3 = new Line(230, 365, 230, 450);
        Line line4 = new Line(270, 365, 270, 450);
        Line line5 = new Line(310, 365, 310, 450);
        Line line6 = new Line(350, 365, 350, 450);
        root.getChildren().addAll(line1, line2, line3, line4, line5, line6);
       
        //**************************************BALL****************************************************
        
        for(int i = 0; i < 10; i++){
            Circle ball = new Circle(250.0, 100.0 , 5.0, Color.RED);
            root.getChildren().add(ball);
            Polyline line = new Polyline();
            line.getPoints().addAll( ball.getCenterX() , ball.getCenterY(), ball.getCenterX(), ball.getCenterY()+15 );
            double currentX = ball.getCenterX();
            double currentY = ball.getCenterY();
            
            
            for(int j = 0; j < 6; j++){
                currentY += 50;
                currentX = ((Math.random() > 0.5)? (currentX - 21 ): (currentX + 21) );
                line.getPoints().addAll( currentX, currentY );
                
                
            }
            int pos = 0;
            
            if(currentX < 150){
                arr[0]++;
                pos = 0;
            }else if(currentX > 150 && currentX < 190){
                arr[1]++;
                pos = 1;
            }else if(currentX > 190 && currentX < 230){
                arr[2]++;
                pos = 2;
            }else if(currentX > 230 && currentX < 270){
                arr[3]++;
                pos = 3;
            }else if(currentX > 270 && currentX < 310){
                arr[4]++;
                pos = 4;
            }else if(currentX > 310 && currentX < 350){
                arr[5]++;
                pos = 5;
            }else if(currentX > 350){
                arr[6]++;
                pos = 6;
            }
            
            currentY = 453 - (arr[pos]*10);
            
            line.getPoints().addAll(currentX,currentY);
            
            line.setStroke(Color.TRANSPARENT);
            root.getChildren().add(line);
            PathTransition path = new PathTransition(Duration.millis(2000), line, ball);
            path.setDelay(Duration.millis(2000*i));
            path.play();
           
        }
        
        
        
        
        
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hope that it works!");
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
