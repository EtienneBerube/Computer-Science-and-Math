/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class TextWithEnter extends Application {
    static String msg = "";
    
    @Override
    public void start(Stage primaryStage) {
        Scanner input = new Scanner(System.in);
        
        Pane root = new Pane();
        
        Text lbl = new Text(150, 125, "Enter: ");
        
         
        root.getChildren().add(lbl);
        
        lbl.setOnKeyPressed(e->{
            System.out.println("in");
           
            if(e.getCode() != KeyCode.ENTER)
                msg += e.getText();
            else{
                 lbl.setText("Enter: " + msg);
                 lbl.setTextAlignment(TextAlignment.CENTER);
                 msg= "";
            }
        });
       
        
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        lbl.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
