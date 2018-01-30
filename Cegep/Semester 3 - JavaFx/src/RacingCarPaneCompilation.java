/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class RacingCarPaneCompilation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox v = new VBox();
        HBox h = new HBox();
        h.setSpacing(5);
        h.setPadding(new Insets(5));
        
        TextField c1 = new TextField("1");
        c1.setPrefColumnCount(3);
        Label l1 = new Label("Car 1:", c1);
        l1.setContentDisplay(ContentDisplay.RIGHT);
        
        TextField c2 = new TextField("1");
        c2.setPrefColumnCount(3);
        Label l2 = new Label("Car 2:", c2);
        l2.setContentDisplay(ContentDisplay.RIGHT);
        
        TextField c3 = new TextField("1");
        c3.setPrefColumnCount(3);
        Label l3 = new Label("Car 3:", c3);
        l3.setContentDisplay(ContentDisplay.RIGHT);
        
        TextField c4 = new TextField("1");
        c4.setPrefColumnCount(3);
        Label l4 = new Label("Car 4:", c4);
        l4.setContentDisplay(ContentDisplay.RIGHT);
        
        h.getChildren().addAll(l1, c1, l2, c2, l3, c3, l4, c4);
        
        v.getChildren().add(h);
        
        v.setSpacing(5);
        
        RacingCarAnimation car1 = new RacingCarAnimation();
        RacingCarAnimation car2 = new RacingCarAnimation();
        RacingCarAnimation car3 = new RacingCarAnimation();
        RacingCarAnimation car4 = new RacingCarAnimation();
        
        v.getChildren().addAll(car1, car2, car3, car4);
        
        c1.setOnAction(e->{
            try{
                int speed = Integer.parseInt(c1.getText());
                if(speed <= 100){
                   car1.setSpeed(speed); 
                }else{
                    c1.setText("100");
                    car1.setSpeed(100);
                }
            }catch(Exception ex){
                c1.setText("1");
                car1.setSpeed(1);
            }
        });
        
        c2.setOnAction(e->{
            try{
                int speed = Integer.parseInt(c2.getText());
                if(speed <= 100){
                   car2.setSpeed(speed); 
                }else{
                    c2.setText("100");
                    car2.setSpeed(100);
                }
            }catch(Exception ex){
                c2.setText("1");
                car2.setSpeed(1);
            }
        });
        
        c3.setOnAction(e->{
            try{
                int speed = Integer.parseInt(c3.getText());
                if(speed <= 100){
                   car3.setSpeed(speed); 
                }else{
                    c3.setText("100");
                    car3.setSpeed(100);
                }
            }catch(Exception ex){
                c3.setText("1");
                car3.setSpeed(1);
            }
        });
        
        c4.setOnAction(e->{
            try{
                int speed = Integer.parseInt(c4.getText());
                if(speed <= 100){
                   car4.setSpeed(speed); 
                }else{
                    c4.setText("100");
                    car4.setSpeed(100);
                }
                
            }catch(Exception ex){
                c4.setText("1");
                car4.setSpeed(1);
            }
        });
        
        
        
        
        
        Scene scene = new Scene(v, 446, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
