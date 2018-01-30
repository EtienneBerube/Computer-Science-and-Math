/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class MovingClockPane extends Application {
    Timeline anim = null;
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        
        ClockPane clock = new ClockPane();
       
        EventHandler<ActionEvent> refresh = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clock.setCurrentTime();
            }
        };
        
        pane.setCenter(clock);
        
        HBox x = new HBox();
        
        Button start = new Button("Start");
        Button pause = new Button("Pause");
        
        
        x.getChildren().addAll(start, pause);
        x.setSpacing(10);
        x.setAlignment(Pos.CENTER);
        
        pane.setBottom(x);
        
        start.setOnAction(e->{
        
            if(anim.getStatus() == Animation.Status.PAUSED){
                anim.play();
            }
            
        });
        
        pause.setOnAction(e->{
        
            if(anim.getStatus() == Animation.Status.RUNNING){
                anim.pause();
            }
            
        });
        
        anim = new Timeline(new KeyFrame(Duration.millis(1000), refresh));
        anim.setCycleCount(Timeline.INDEFINITE);
        anim.play();
        
        Scene scene = new Scene(pane, 250, 300);
        
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
