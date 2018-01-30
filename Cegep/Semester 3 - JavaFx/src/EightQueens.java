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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class EightQueens extends Application {
     public static final int SIZE = 8; 
     Pane root;
     Timeline anim;
     Image queen = new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/queen.png");
     ImageView[] viewer = new ImageView[8];
     Circle[] graph = new Circle[8];
     Rectangle[] rec = new Rectangle[8];
     
     int numberQueen=0;
     int k = 0;
     
     private int[] queens = {-1, -1, -1, -1, -1, -1, -1, -1}; 

    @Override
    public void start(Stage primaryStage){
        initialize();
        
        if (search()) // Search for a solution 
            System.out.println("yep");
        else
          System.out.println("nope");
        
        
        
        
        Scene scene = new Scene(root, 601, 601);
        
        primaryStage.setTitle("8 girls in a party!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
     private boolean search() {
    // k - 1 indicates the number of queens placed so far
    // We are looking for a position in the kth row to place a queen
    anim = new Timeline(new KeyFrame(Duration.millis(100), e->{
        if(k >= 0 && k < SIZE) {
          // Find a position to place a queen in the kth row
          int j = findPosition(k);
          if (j < 0) {
            //root.getChildren().remove(graph[numberQueen-1]);
            root.getChildren().remove(viewer[numberQueen-1]);
            numberQueen--;
            queens[k] = -1;
            k--; // back track to the previous row
          } else {
            //graph[numberQueen] = new Circle(k*75 + 37.5, j*75 + 37.5, 25);
            viewer[numberQueen] = new ImageView(queen);
             viewer[numberQueen].setX(k*75+15);
             viewer[numberQueen].setY(j*75+15);
             viewer[numberQueen].setFitHeight(50);
             viewer[numberQueen].setFitWidth(50);
            //root.getChildren().add(graph[numberQueen]);
            root.getChildren().add(viewer[numberQueen]);
                    
            numberQueen++; 
            queens[k] = j;
            k++;
          }
    }
    }));
    
    anim.setCycleCount(Timeline.INDEFINITE);
    anim.play();
    

    
    if (k == -1)
      return false; // No solution
    else
      return true; // A solution is found
  }
     
     public int findPosition(int k) {
    int start = queens[k] + 1; // Search for a new placement

    for (int j = start; j < SIZE; j++) {
        
        rec[j].setFill(Color.BROWN);
        rec[j].setOpacity(0.5);
        
      if (isValid(k, j)){
          if(j> 0){
         rec[j-1].setFill(Color.TRANSPARENT);
         rec[j-1].setOpacity(0.5);
          }
        return j; // (k, j) is the place to put the queen now
      }
      
      rec[j].setFill(Color.TRANSPARENT);
        rec[j].setOpacity(0.5);
    }
    
    return -1;
  }
    
    public boolean isValid(int row, int column) {
    for (int i = 1; i <= row; i++)
      if (queens[row - i] == column // Check column
        || queens[row - i] == column - i // Check upleft diagonal
        || queens[row - i] == column + i) // Check upright diagonal
        return false; // There is a conflict
    return true; // No conflict
  }
    
    
    
    public void initialize(){
        root = new Pane();
        
        for(int i =0; i< 9; i++){
            Line ln = new Line(i*75, 0, i*75, 601);
            root.getChildren().add(ln);
        }
        
        for(int i =0; i< 9; i++){
            Line ln = new Line(0, i*75, 601, i*75);
            root.getChildren().add(ln);
        }
        
        for(int i = 0; i < rec.length; i++){
            rec[i] = new Rectangle(0, i*75, 601, 75);
            rec[i].setStroke(Color.TRANSPARENT);
            rec[i].setFill(Color.TRANSPARENT);
        }
        
        for(Rectangle r: rec){
            root.getChildren().add(r);
        }
        
    }
    
}
