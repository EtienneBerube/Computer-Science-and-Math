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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class imageInGridPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      GridPane grdpane = new GridPane();
        
        Image im1 = new Image("file:C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Image bank/waddup.jpg");
        Image im2 = new Image("file:C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Image bank/pepe.jpg");
        Image im3 = new Image("file:C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Image bank/Doge.jpg");
        Image im4 = new Image("file:C:/Users/Étienne Bérubé/Documents/1. École/Cégep/Session 3/Programming/Image bank/serious.png");
        
        ImageView im1view = new ImageView(im1);
        im1view.setFitHeight(400);
        im1view.setFitWidth(400);
       
        ImageView im2view = new ImageView(im2);
        im2view.setFitHeight(400);
        im2view.setFitWidth(400);
        
        ImageView im3view = new ImageView(im3);
        im3view.setFitHeight(400);
        im3view.setFitWidth(400);
        
        ImageView im4view = new ImageView(im4);
        im4view.setFitHeight(400);
        im4view.setFitWidth(400);
        
        grdpane.add(im1view, 0, 0);
        grdpane.add(im2view, 1, 0);
        grdpane.add(im3view, 0, 1);
        grdpane.add(im4view, 1, 1);
       
        
        Scene scene = new Scene(grdpane,(im1view.getFitWidth()+im2view.getFitWidth()),800 );
        
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
