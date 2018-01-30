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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class StickMan extends Pane {
    
    
    public StickMan(){
        
        Pane man = new Pane();
        
        
        Arc base = new Arc(100, 480, 75, 20, 0, 180);
        base.setFill(Color.WHITE);
        base.setStroke(Color.BLACK);
        
        Polyline hang = new Polyline();
        hang.getPoints().addAll(100.0, 460.0, 100.0,80.0, 300.0, 80.0, 300.0, 125.0 );
        
        Circle head = new Circle(300.0, 165.0 , 40.0);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        
        Line rightHand = new Line(300.0, 185.0, 250.0, 300.0);
        Line leftHand = new Line(300.0, 185.0, 350.0, 300.0);
        Line body = new Line(300.0 , 205.0, 300.0, 355.0);
        Line rightLeg = new Line(300.0, 355.0, 250.0, 455.0);
        Line leftLeg = new Line(300.0, 355.0, 350.0, 455.0);
        
        
        //man.getChildren().addAll(head, body, leftHand, rightHand, leftLeg, rightLeg);
       // this.getChildren().addAll(base, hang, man);
        
        
        
        
    }
    
    

    
    
}
