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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class StopLights extends Application {
    Timeline anim = null;
    
    @Override
    public void start(Stage primaryStage) {
       
        BorderPane root = new BorderPane();
        
        Pane pane = new Pane();
       
       Rectangle rec = new Rectangle(125,25, 50, 152);
       rec.setStroke(Color.BLACK);
       rec.setFill(Color.WHITE);
       
       Circle gn = new Circle(150, 50 , 22.5);
       gn.setFill(Color.WHITE);
       gn.setStroke(Color.BLACK);
       
       Circle yl = new Circle(150, 100.5 , 22.5);
       yl.setStroke(Color.BLACK);
       yl.setFill(Color.WHITE);
       
       Circle rd = new Circle(150, 150.5, 22.5);
       rd.setStroke(Color.BLACK);
       rd.setFill(Color.WHITE);
       
       
       root.getChildren().addAll(rec, gn, yl, rd);
       
       root.setCenter(pane);
        
       HBox hbox = new HBox();
       
       ToggleGroup tg = new ToggleGroup();
       
       RadioButton green = new RadioButton("Green");
       RadioButton yellow = new RadioButton("Yellow");
       RadioButton red = new RadioButton("Red");
       
       green.setToggleGroup(tg);
       yellow.setToggleGroup(tg);
       red.setToggleGroup(tg);
       hbox.getChildren().addAll(green, yellow, red);
       hbox.setPadding(new Insets(10, 50, 10, 50));
       hbox.setSpacing(5);
       
       root.setBottom(hbox);
       
       
        anim = new Timeline(new KeyFrame(Duration.millis(500), e->{
        
        if(green.isSelected()){
            yellow.setSelected(true);
            rd.setFill(Color.WHITE);
            gn.setFill(Color.WHITE);
            yl.setFill(Color.YELLOW);
            
        }else if(yellow.isSelected()){
           
            red.setSelected(true);
            gn.setFill(Color.WHITE);
            yl.setFill(Color.WHITE);
            rd.setFill(Color.RED);
       
        }else{
            green.setSelected(true);
            yl.setFill(Color.WHITE);
            rd.setFill(Color.WHITE);
            gn.setFill(Color.GREEN);
        }
        
        }));
        
        anim.setCycleCount(Timeline.INDEFINITE);
       
       
       
       green.setOnAction(e -> {
           gn.setFill(Color.GREEN);
           anim.play();
       
       });
       
       yellow.setOnAction(e -> {
           yl.setFill(Color.YELLOW);
           anim.play();
       
       });
       
       red.setOnAction(e -> {
           rd.setFill(Color.RED);
           anim.play();
       
       });
       
       Scene scene = new Scene(root, 300, 300);
        
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
