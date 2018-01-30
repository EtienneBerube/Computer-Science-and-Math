/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class WalkingManAnimation extends Application {
    Timeline anim = null;
    
    private int currentX = 8;
    private int currentY = 8;
    
    private ArrayList<Point> used = new ArrayList<>();
    
    private boolean isStuck = false;
    
    private int numberOfLine = 0;
    
    Point[][] matrix = new Point[17][17];
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        Pane pane = new Pane();
        for(int i = 0; i <= 320; i+=20){ // horizontale line
            Line line = new Line(i, 0, i, 320);
            line.setStroke(Color.GREY);
            line.setOpacity(0.7);
            pane.getChildren().add(line);
        }
        
        for(int j = 0; j <= 320; j+= 20){
            Line line = new Line(0, j, 320, j);
            line.setStroke(Color.GREY);
            line.setOpacity(0.7);
            pane.getChildren().add(line);
        }
        
        root.setCenter(pane);
        
        
        
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 17; j++){
                matrix[i][j] = new Point(i*20, j*20);
            }
        }
        
        Circle circ = new Circle(matrix[8][8].getX(), matrix[8][8].getY(), 4);
        pane.getChildren().add(circ);
        
        used.add(matrix[8][8]);
        
        
        
        anim = new Timeline(new KeyFrame(Duration.millis(200), e-> {
     try{
            if(currentX == 1 || currentX == 16 || currentY == 0 || currentY == 16){
            
                stopAnim();
            }

        if(check(matrix[currentX+1][currentY]) && check(matrix[currentX-1][currentY]) && check(matrix[currentX][currentY+1]) && check(matrix[currentX][currentY-1])){ // is it stuck
                
            stopAnim();
        }
            
            int move = (int)(Math.abs(Math.random()*4+1));
            
            switch(move){
                case 1://up
                    if( !check( matrix[currentX][currentY -1] ) ){
                        pane.getChildren().add( new Line(matrix[currentX][currentY].getX(), matrix[currentX][currentY].getY(), 
                                matrix[currentX][currentY-1].getX(), matrix[currentX][currentY-1].getY()));
                        currentY--;
                        used.add(matrix[currentX][currentY]); 
                        numberOfLine++;
                    }
                    break;
                
                case 2://right
                    if( !check( matrix[currentX + 1][currentY] ) ){
                        pane.getChildren().add( new Line(matrix[currentX][currentY].getX(), matrix[currentX][currentY].getY(), 
                                matrix[currentX+1][currentY].getX(), matrix[currentX+1][currentY].getY()));
                        currentX++;
                        used.add(matrix[currentX][currentY]);
                        numberOfLine++;
                    }
                    break;
                    
                case 3://down
                    if( !check( matrix[currentX][currentY +1] ) ){
                        pane.getChildren().add( new Line(matrix[currentX][currentY].getX(), matrix[currentX][currentY].getY(), 
                                matrix[currentX][currentY+1].getX(), matrix[currentX][currentY+1].getY()));
                        currentY++;
                        used.add(matrix[currentX][currentY]);
                        numberOfLine++;
                    }
                    break;
                    
                case 4://left
                    if( !check( matrix[currentX - 1][currentY] ) ){
                        pane.getChildren().add( new Line(matrix[currentX][currentY].getX(), matrix[currentX][currentY].getY(),
                                matrix[currentX - 1][currentY].getX(), matrix[currentX-1][currentY].getY()));
                        currentX--;
                        used.add(matrix[currentX][currentY]);
                        numberOfLine++;
                    }
                    break;
                    
                default:
                    break;
            }
     }
     catch(Exception ex){
         stopAnim();
     }
            
        }));
        
        
            
        anim.setCycleCount(Timeline.INDEFINITE);
        
        anim.play();
        
        
        Scene scene = new Scene(root, 309, 309);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean check(Point p){
        boolean x = false;
        
        for(Point point : used){
            if(point.equals(p))
                x=true;
        }
        
        return x;
    }
    
    public void stopAnim(){
    anim.stop();
    }
}
