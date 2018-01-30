/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Line;

/**
 *
 * @author Étienne Bérubé
 */
public class RacingCarAnimation extends Pane {
     PathTransition epicRace1 = null;
     PathTransition epicRace2 = null;
     PathTransition epicRace3 = null;
     PathTransition epicRace4 = null;
    
    
    public RacingCarAnimation() {
       
        Rectangle bottom = new Rectangle(0, 25, 50, 10);
        
        Circle wheel1 = new Circle(15, 40, 5);
       
        
        Circle wheel2 = new Circle(35, 40,5);
        
        
        Polygon top = new Polygon();
        
        top.getPoints().addAll(10.0, 25.0, 20.0, 15.0, 30.0, 15.0, 40.0, 25.0);
        
       
        
        this.getChildren().addAll(bottom, wheel1, wheel2, top);
       
        
        
        epicRace1 = new PathTransition(Duration.millis(1000), new Line(20, 25, 500+20, 25),bottom);
        epicRace1.setCycleCount(PathTransition.INDEFINITE);
        epicRace1.play();
        
        epicRace2 = new PathTransition(Duration.millis(1000), new Line(20, 15, 500+20, 15),top);
        epicRace2.setCycleCount(PathTransition.INDEFINITE);
        epicRace2.play();
        
        epicRace3 = new PathTransition(Duration.millis(1000), new Line(10, 35, 500+10, 35),wheel1);
        epicRace3.setCycleCount(PathTransition.INDEFINITE);
        epicRace3.play();
        
        epicRace4 = new PathTransition(Duration.millis(1000), new Line(30, 35, 500+30, 35),wheel2);
        epicRace4.setCycleCount(PathTransition.INDEFINITE);
        epicRace4.play();
        
       /* root.setOnKeyPressed(e-> {
        
            if(e.getCode() == KeyCode.UP){
                
                epicRace1.setRate(epicRace1.getRate()*1.1);
                epicRace2.setRate(epicRace2.getRate()*1.1);
                epicRace3.setRate(epicRace3.getRate()*1.1);
                epicRace4.setRate(epicRace4.getRate()*1.1);
            }else if(e.getCode() == KeyCode.DOWN){
                
                epicRace1.setRate(epicRace1.getRate()*0.9);
                epicRace2.setRate(epicRace2.getRate()*0.9);
                epicRace3.setRate(epicRace3.getRate()*0.9);
                epicRace4.setRate(epicRace4.getRate()*0.9);
            }
        
        });*/
        
    }

    public void setSpeed(int speed){
        epicRace1.setRate(speed);
        epicRace2.setRate(speed);
        epicRace3.setRate(speed);
        epicRace4.setRate(speed);
    }
    
    
    
}
