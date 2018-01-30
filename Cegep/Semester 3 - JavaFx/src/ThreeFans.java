/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class ThreeFans extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox();
        HBox hbox = new HBox();
        
        SpinningFan f1 = new SpinningFan();
        SpinningFan f2 = new SpinningFan();
        SpinningFan f3 = new SpinningFan();
        hbox.getChildren().addAll(f1, f2, f3);
        
        HBox control = new HBox();
        
        Button start = new Button("Start All");
        Button pause = new Button("Pause All");
       
        control.getChildren().addAll(start, pause);
        control.setAlignment(Pos.CENTER);
        control.setSpacing(10);
        
        root.getChildren().addAll(hbox, control);
        
        start.setOnAction(e->{
            f1.startAnime();
            f2.startAnime();
            f3.startAnime();
        });
        
        pause.setOnAction(e->{
            f1.pauseAnim();
            f2.pauseAnim();
            f3.pauseAnim();
        });
        
        
        Scene scene = new Scene(root, 850, 450);
        
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
