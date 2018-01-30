/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class BallAndVertice extends Application {
    
    Point[] point = null;
    Text[] texts= null;
    ArrayList<Vertice> vertices = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        
        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: rgb(49, 89, 23);\n" +
                      "-fx-border-radius: 15;");
        
        HBox h = new HBox();
        h.setAlignment(Pos.CENTER);
        h.setSpacing(10);
        h.setPadding(new Insets(10));
        
        
        TextField path = new TextField();
        path.setPrefColumnCount(20);
        path.setText("C:\\Users\\Étienne Bérubé\\Documents\\1. École\\Cégep\\Session 3\\Programming\\Text Bank\\Display_graph_test_cases\\test4.txt");
        path.setText(path.getText().replace('\\', '/'));
        
        Button view = new Button("View");
        
        h.getChildren().addAll(path, view);
        
        root.setBottom(h);
        root.setCenter(pane);
        
        view.setOnAction(e->{
            String refPath = path.getText().replace('\\', '/');
            File file = new File(refPath);
            
            if(!file.exists())
                path.setText("Invalid path, try again");
            else{
                try{
                    Scanner input = new Scanner(file);
                    System.out.println(file.exists());
                    //path.setText("good"); <---- DEBUGGING
                    
                    point = new Point[input.nextInt()];
                    input.nextLine();
                    texts = new Text[point.length];
                    
                    
                    
                    for(int i = 0; i < point.length; i++){
                        
                        
                        String temp = input.nextLine();
                        String[] code = temp.split(" ");
                        
                        int index = Integer.parseInt(code[0]);
                        int x = Integer.parseInt(code[1]);
                        int y = Integer.parseInt(code[2]);
                        
                        point[index] = new Point( (double)x, (double)y);
                        texts[index] = new Text(x-15, y-10, ("" + index));
                        
                        for(int j = 3; j < code.length ; j++){
                            vertices.add(new Vertice(index, Integer.parseInt(code[j])));
                        }
                        
                        
                        
                       pane.getChildren().addAll(texts[i], new Circle(point[i].getX() , point[i].getY() , 5) );
                        
                    }
                    
                    for(Vertice v : vertices){
                        pane.getChildren().add( new Line(point[v.getStart()].getX(), point[v.getStart()].getY(), point[v.getEnd()].getX(), point[v.getEnd()].getY()));
                    }
                    
                    
                    
                } catch (FileNotFoundException ex) {
                    path.setText("Internal error");
                }
            }
        
        
        
        });
        
        
        
        
        Scene scene = new Scene(root, 500, 500);
        
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
