/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class ButtonCalculator extends Application {
    TextField text3 = new TextField();
    double num1 = 0.0;
    double num2 = 0.0;

    @Override
    public void start(Stage primaryStage) {
       BorderPane pane = new BorderPane();
        
       Text number1 = new Text("Number 1: ");
       Text number2 = new Text("Number 2: ");
       TextField txt1 = new TextField();
       TextField txt2 = new TextField();
       Text result = new Text("Result: ");
       text3.setEditable(false);
       //******************************CENTER***********************************
       HBox hbox1 = new HBox();
       hbox1.setAlignment(Pos.CENTER);
       hbox1.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
       hbox1.getChildren().addAll(number1, txt1, number2, txt2, result, text3);
       pane.setCenter(hbox1);
       //********************************TOP************************************
       HBox error = new HBox();
      
       Text errorMessage = new Text("");
       errorMessage.setFill(Color.RED);
       
       error.getChildren().add(errorMessage);
       
       pane.setTop(error);
      
       
       
       
       //********************************BUTTONS********************************
       Button add = new Button("Add");
       Button substract = new Button("Substract");
       Button multiply = new Button("Multiply");
       Button divide = new Button("Divide");
       
       
       
       
       
       add.setOnAction(e ->{
           
           try{
           num1 = Double.parseDouble(txt1.getText());
           num2 = Double.parseDouble(txt2.getText());
           errorMessage.setText("");
              
           double answer = num1 + num2;     
           text3.setText("" + answer);
           
       }catch(Exception x){
               System.out.println("----");
           errorMessage.setText("*no!!!");
           txt1.setText("");
           txt2.setText("");
           text3.setText("");
       }
           
       });
       
     
       
       substract.setOnAction(e -> {
           try{
           num1 = Double.parseDouble(txt1.getText());
           num2 = Double.parseDouble(txt2.getText());
           errorMessage.setText("");
           System.out.println(num1);
           System.out.println(num2);
           
              text3.setText("" + (num1 - num2));
           
       }catch(Exception x){
           errorMessage.setText("no!!!");
           txt1.setText("");
           txt2.setText("");
           text3.setText("");
       }
       });
       
      
       
       multiply.setOnAction(e -> {
           try{
           num1 = Double.parseDouble(txt1.getText());
           num2 = Double.parseDouble(txt2.getText());
           errorMessage.setText("");
           System.out.println(num1);
           System.out.println(num2);
           
            text3.setText(""+(num2 * num1));
            
       }catch(Exception x){
           errorMessage.setText("no!!!");
           txt1.setText("");
           txt2.setText("");
           text3.setText("");
       }
          
       });
       
     
       
       divide.setOnAction(e -> {
           try{
           num1 = Double.parseDouble(txt1.getText());
           num2 = Double.parseDouble(txt2.getText());
           errorMessage.setText("");
           System.out.println(num1);
           System.out.println(num2);
           
            text3.setText(""+(num1 / num2));
            
           }catch(Exception x){
           errorMessage.setText("no!!!");
           txt1.setText("");
           txt2.setText("");
           text3.setText("");
       }
          
       });
       
       HBox hbox2 = new HBox();
       hbox2.setAlignment(Pos.CENTER);
       hbox2.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
       hbox2.getChildren().addAll(add, substract, multiply, divide);
       pane.setBottom(hbox2);
       
       
       Scene scene = new Scene(pane,  400 , 250);
        
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
