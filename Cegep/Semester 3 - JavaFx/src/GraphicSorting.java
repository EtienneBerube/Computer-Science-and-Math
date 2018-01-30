/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class GraphicSorting extends Application {
    NumberHistogram h1;
    NumberHistogram h2;
    NumberHistogram h3;
    
    Thread h1Sorter;
    Thread h2Sorter;
    Thread h3Sorter;
    
    
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        root.setSpacing(10);
        
        h1 = new NumberHistogram();
        h2 = new NumberHistogram();
        h3 = new NumberHistogram();
        
        root.getChildren().addAll(h1, h2, h3);
        
        h1Sorter = new Thread(new SelectionSort());
        h1Sorter.start();
        
        h2Sorter = new Thread(new InsertionSort());
        h2Sorter.start();
        
        h3Sorter = new Thread(new BubbleSort());
        h3Sorter.start();
        
        /*
        Platform.runLater(new SelectionSort());
        Platform.runLater(new InsertionSort());
        Platform.runLater(new BubbleSort());
        */
        
        
        Scene scene = new Scene(root, 1150, 350);
        
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
    
    class  SelectionSort implements Runnable{
        int i = 0;
        @Override
        public void run() {
            try{
            for(i = 0; i < 50; i++){
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        h1.sort(NumberHistogram.SELECTION, i);
                    }
                
                });
                
                Thread.sleep(200);
            }
            }catch(Exception ex){
                
            }
        }
    }
    
    
    class  InsertionSort implements Runnable{
        
       int i = 0;
        @Override
        public void run() {
            try{
            for(i = 0; i < 50; i++){
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        h2.sort(NumberHistogram.INSERTION, i);
                    }
                
                });
                
                Thread.sleep(200);
            }
            }catch(Exception ex){
                
            }
        }
    }
    
    
    class  BubbleSort implements Runnable{
        int i = 0;
        @Override
        public void run() {
            try{
            for(i = 0; i < 50; i++){
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        h3.sort(NumberHistogram.BUBBLE, i);
                    }
                
                });
                
                Thread.sleep(200);
            }
            }catch(Exception ex){
                
            }
        }
    }
}
