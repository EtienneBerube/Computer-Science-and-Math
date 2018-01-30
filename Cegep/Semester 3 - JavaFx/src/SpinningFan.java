/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class SpinningFan extends BorderPane {
    Boolean reverse = false;
    Timeline anim = null;
    int increment = 2;
    
    
    public SpinningFan() {
       
        Pane pane = new Pane();
        
        Circle circ = new Circle(150, 150, 125, Color.TRANSPARENT);
        circ.setStroke(Color.BLACK);
        
        Arc a1 = new Arc(150, 150, 120, 120, 0, 45);
        a1.setType(ArcType.ROUND);
        Arc a2 = new Arc(150, 150, 120, 120, 90, 45);
        a2.setType(ArcType.ROUND);
        Arc a3 = new Arc(150, 150, 120, 120, 180, 45);
        a3.setType(ArcType.ROUND);
        Arc a4 = new Arc(150, 150, 120, 120, 270, 45);
        a4.setType(ArcType.ROUND);
        
        pane.getChildren().addAll(circ, a1, a2, a3, a4);
        
        EventHandler<ActionEvent> eventHandlerLeft = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a1.setStartAngle(a1.getStartAngle() + increment);
                a2.setStartAngle(a2.getStartAngle()+increment);
                a3.setStartAngle(a3.getStartAngle()+increment);
                a4.setStartAngle(a4.getStartAngle()+increment);
            }
        };
        
        
        anim = new Timeline(new KeyFrame(Duration.millis(10), eventHandlerLeft));
        
        anim.setCycleCount(Timeline.INDEFINITE);
        anim.play();
        
        this.setCenter(pane);
        
        HBox control = new HBox();
        control.setPadding(new Insets(10, 5, 10, 5));
        
        Button bt1 = new Button("Pause");
        bt1.setOnAction(e-> anim.pause());
        
        Button bt2 = new Button("Resume");
        bt2.setOnAction(e-> anim.play());
        
        Button bt3 = new Button("Reverse");
        bt3.setOnAction(e-> increment = (increment < 0)? increment: (-1) * increment);
        
       control.getChildren().addAll(bt1, bt2, bt3);
       
       this.setTop(control);
       
       Slider sl = new Slider(2, 20, 2);
       
       this.setBottom(sl);
       
       
       sl.valueProperty().addListener(ov -> {
           if(increment < 0)
           increment = -1 * (int) sl.getValue();
           else
               increment = (int)sl.getValue();
       
       });
       
       control.setAlignment(Pos.CENTER);
       control.setSpacing(10);
        
       
    }
    
    public void pauseAnim(){
        anim.pause();
    }
    
    public void startAnime(){
        anim.play();
    }

}
