/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.prism.paint.Color;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class Histogram extends BorderPane {
    int[] count = new int[26];
    Rectangle[] rec;
    Text[] lbl = new Text[26];
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String pathRefined ="";
   
    public Histogram() {
        //*******************************************Controls**********************************
        HBox hbox = new HBox();
        Button view = new Button("View");
        TextField path = new TextField("Enter Path");
        path.setPrefColumnCount(22);
        path.setText("C:\\Users\\Étienne Bérubé\\Documents\\1. École\\Cégep\\Session 3\\Programming\\Text Bank\\sample.txt");
        
        System.out.println("SUPRISE");
        
        hbox.getChildren().addAll(path, view);
       
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        
        hbox.setPadding(new Insets(75, 50, 50, 50));
        
        this.setBottom(hbox);
       
        
        //********************************************Graph*************************************
       
        Pane pane = new Pane();
        Line base = new Line(50, 250, 450, 250);
        pane.getChildren().add(base);
        rec = new Rectangle[26];
        int letter = 'A';
        
        for(int i =0; i < 26; i++){
            rec[i] = new Rectangle((50 + i*14), 250, 12, i * 5);
            lbl[i] = new Text((51 + i*14), 265, ""+(char)letter + " ");
            letter++;
        }
        
       for(Rectangle r : rec){ // Add bars to pane
           r.setTranslateY(-1 * r.getHeight());
           pane.getChildren().addAll(r);
       }
       
       for(Text txt: lbl){
           pane.getChildren().add(txt);
       }
       
       
       view.setOnAction((ActionEvent e)->{
           
           pathRefined = path.getText().replace('\\', '/');
           System.out.println(pathRefined);
           File file = new File(pathRefined);
           System.out.println(file.exists());
           
           
           
            try {
                
                Scanner input = new Scanner(file);
                while(input.hasNext()){
                    
                    String temp = input.next().toLowerCase();
                    
                    for(int i = 0; i < temp.length(); i++){
                        if(temp.charAt(i) - 97 >= 0 && temp.charAt(i)-97 <26)
                            count[temp.charAt(i) - 97]++;
                    }
                }
                
              
                
                for(int i = 0; i < 26; i++){
                    rec[i].setHeight(count[i]*2);
                    rec[i].setTranslateY(-1 * rec[i].getHeight());
                }
                
                
            } catch (Exception ex) {
                System.exit(0);
            }
            
            
           
       });
       
       
       this.setCenter(pane);
        
        
    }
    
}
