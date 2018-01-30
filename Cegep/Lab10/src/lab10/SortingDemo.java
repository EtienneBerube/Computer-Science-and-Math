/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author steven
 */
public class SortingDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      int[] array1 = new int[50]; 
      
      
      for (int i = 1; i <= 50; i++){
      array1[i - 1] = i;
    }
      shuffleArray(array1); 
      
       int[] array2 = new int[50]; 
      
      
      for (int i = 1; i <= 50; i++){
      array2[i - 1] = i;
    }
      shuffleArray(array2);
      
       int[] array3 = new int[50]; 
      
      
      for (int i = 1; i <= 50; i++){
      array3[i - 1] = i;
    }
      shuffleArray(array3); 
      
      Thread insertion = new Thread(new InsertionSortThread(array1));
      insertion.start();

      
     Histogram pane = new Histogram(array1,array2,array3);
      Scene scene = new Scene(pane, 1300,200);
        primaryStage.setTitle("Array Historgram Shuffle");
          primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
     static void shuffleArray(int[] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
    
}
class Histogram extends HBox{
    private int[] insertion;
    private int[] bubble;
    private int[] selection;
    
public Histogram(int[] list1, int[] list2, int[] list3){
    insertion = list1;
    bubble = list2;
    selection = list3;
    
 update();
  Timeline animation = new Timeline( new KeyFrame( Duration.millis( 500 ), e ->{
          update();
        }));
        animation.setCycleCount(INDEFINITE);
        animation.play();
}

public synchronized void update(){
    this.getChildren().clear();
    BorderPane pane = new BorderPane();
    Text text = new Text("Insertion");
    text.setX(100);
    text.setY(30);
    pane.setTop(text);
    text.setTranslateX(150);
    
    HBox insertionPane = new HBox();
    pane.setCenter(insertionPane);
    
    insertionPane.setSpacing(2);
    insertionPane.setAlignment(Pos.BOTTOM_RIGHT);
    insertionPane.setTranslateY(-80);
    boolean setLast = false;
for(int i = 0; i < 49; i++){
   
    Rectangle rectangle = new Rectangle();
rectangle.setHeight(insertion[i]);
rectangle.setX(100);
rectangle.setWidth(3);
rectangle.setStroke(Color.BLACK);
rectangle.setY(200);
 if(insertion[i] < insertion[i + 1] || setLast == true)
rectangle.setFill(Color.GRAY);
 else{
     rectangle.setFill(Color.BLUE);
     setLast = true;
 }
rectangle.setRotate(360);
insertionPane.getChildren().add(rectangle);
    }
    

this.getChildren().add(pane);

}
}