/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 * @Icons: Icon made by Madebyoliver from www.flaticon.com 
 */
public class ConnectFour extends Application {
    Circle[][] playGround = new Circle[6][7];
    Point[][] pointArray = new Point[6][7];
    int[] circleInColumn = new int[7];
    int currentX;
    int currentY;
    
    int lastCheckedX;
    int lastCheckedY;
    
    Circle possiblePlay1 = null;
    Circle possiblePlay2 = null;
    
    Color turn = Color.RED;
    Pane root = new Pane();
    Thread dummy = new Thread();
    boolean isVolumeOn = true;
    boolean isAI = false;
    boolean isFinished = false;
    
    Image volumeON = new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/my-icons-collection/png/speaker.png");
    Image volumeOFF = new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/my-icons-collection/png/speaker-1.png");
    Image refresh = new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/my-icons-collection/png/reload.png");
    Image computer = new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/my-icons-collection/png/computer.png");
    Image user = new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/my-icons-collection/png/users.png");
    
    ImageView viewer;
    ImageView refreshView;
    ImageView opponent;
    
    ArrayList<Circle> winningSeq = new ArrayList<>();
    ArrayList<Circle> redList = new ArrayList<>();
    ArrayList<Circle> yellowList = new ArrayList<>();
    
    
    Media clack = new Media( new File("C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Sound Bank/button.mp3").toURI().toString());
    MediaPlayer player = new MediaPlayer(clack);
    
    Media music = new Media(new File("C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Sound Bank/back.mp3").toURI().toString());
    MediaPlayer musicPlayer = new MediaPlayer(music);
    
    Media clap = new Media(new File("C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Sound Bank/clap.mp3").toURI().toString());
    MediaPlayer clapPlayer = new MediaPlayer(clap);
    

    ArrayList<FadeTransition> animList = new ArrayList<>();
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        initialize();
        
        
        Scene scene = new Scene(root, 750, 500);
        
        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void initialize(){
        isAI = false;
        player.setVolume(1.0);
        musicPlayer.stop();
        musicPlayer.setVolume(0.2);
        musicPlayer.setCycleCount(Timeline.INDEFINITE);
        musicPlayer.seek(Duration.ZERO);
        musicPlayer.play();
       
        isFinished = false;
        
        turn = Color.RED;
        currentY = 80;
        currentX = 120;
        isVolumeOn = true;
        root.setStyle("-fx-background-color: white");
        root.getChildren().clear();
        
        animList.clear();
        winningSeq.clear();
        
        viewer = new ImageView(volumeON);
        viewer.setX(40);
        viewer.setY(25);
        
        refreshView = new ImageView(refresh);
        refreshView.setX(40);
        refreshView.setY(75);
        
        viewer.setOnMouseClicked(e->{
        
            if(isVolumeOn){
                isVolumeOn = false;
                viewer.setImage(volumeOFF);
                musicPlayer.pause();
            }else{
                isVolumeOn = true;
                viewer.setImage(volumeON);
                musicPlayer.play();
            }
        
        });
        
        refreshView.setOnMouseClicked(e->{
            initialize();
        });
        
        
        
        opponent = new ImageView(user);
        opponent.setX(40);
        opponent.setY(125);
        
        opponent.setOnMouseClicked(e->{
            
            if(!isAI){
                isAI = true;
                opponent.setImage(computer);
            }else{
                isAI = false;
                opponent.setImage(user);
            }
            
        });
        
        root.getChildren().addAll(viewer, refreshView, opponent);
        
        for(int i = 0; i< circleInColumn.length; i++){
            circleInColumn[i]=0;
        }
        
        for(int i = 0; i < 6; i ++){
            
            for(int j = 0; j < 7; j++){
                pointArray[i][j] = new Point(currentX, currentY);
                playGround[i][j] = new Circle(pointArray[i][j].getX(), pointArray[i][j].getY(), 30);
                root.getChildren().add(playGround[i][j]);
                currentX += 85;
            }
            
            currentX = 120;
            currentY += 68;
        }
     
        
        for(int i =0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                playGround[i][j].setFill(Color.WHITE);
                playGround[i][j].setStroke(Color.BLACK);
                Circle c = playGround[i][j];
                c.setOnMouseClicked(e->{
                    
                    putToken(c);

                });
            }
        }
        
    }
    
    public void switchColor(){
        if(turn.equals(Color.RED))
            turn = Color.YELLOW;
        else
            turn = Color.RED;
    }
    
    public void putToken(Circle c){
        player.setVolume(1.0);
        int column = 0;
        int row = 0;
        //Color currentColor = turn;
        
        switch((int)c.getCenterX()){
            case 120: column = 0; break;
            case 205: column = 1; break;
            case 290: column = 2; break;
            case 375: column = 3; break;
            case 460: column = 4; break;
            case 545: column = 5; break;
            case 630: column = 6; break;     
            default: column = 0; break;
        }
        currentX = column;
        row = 5-circleInColumn[column];
        currentY = 5-circleInColumn[column];
        
        if (turn.equals(Color.RED) && circleInColumn[column]!= 6) {
            
            playGround[row][column].setFill(Color.RED); 
            redList.add(playGround[row][column]);
            
            if (isVolumeOn) {
                player.seek(Duration.ZERO);
                player.play();
                //player.stop();
                
            }
            check(turn, 4); // <---- modification from currentColor to turn
            switchColor();
            circleInColumn[column]++;
            
        }else if(turn.equals(Color.YELLOW) && circleInColumn[column]!= 6){
            
            playGround[row][column].setFill(Color.YELLOW);
            yellowList.add(playGround[row][column]);
            
            if (isVolumeOn) {
                player.seek(Duration.ZERO);
                player.play();
                //player.stop();
                
            }
            check(turn, 4); // <------ modification from currentColor to turn
            switchColor();
            circleInColumn[column]++;
        }
        
       
       
       if(isAI && turn.equals(Color.YELLOW) && !isFinished){
           winningSeq.clear();
            AIPlay(); //TODO
       }
        
    }
   
    public void AIPlay(){
        //CHECK to win
        
        blockCheck(Color.RED, 3);
        
        if(turn.equals(Color.YELLOW)){
            int column;
            
            do{
            
                column = (int)(Math.random()*7);
            
            }while(circleInColumn[column] == 6);
        
            putToken(playGround[(int)(Math.random()*6)][(int)(Math.random()*7)]);
        }
    }
    
    //***********************************************************************CHECK METHOD******************************************************************
    public void check(Color color, int n){
        winningSeq.clear();
        
        if( checkHorizontal(color, n)){
          startAnim();
          winningSequence();
          
        }else if(checkVertical(color, n)){
            startAnim();
          winningSequence();
          
        }else if(checkDiag1(color, n)){
            startAnim();
          winningSequence();
          
        }else if(checkDiag2(color, n)){
            startAnim();
          winningSequence();
        }

    }
    
    public void blockCheck(Color color, int n){
        possiblePlay1 = null;
        possiblePlay2 = null;
        
        if(checkHorizontal(color, n)){
          if(possiblePlay1 != null){
              putToken(possiblePlay1);
              possiblePlay1 = null;
              possiblePlay2 = null;
          }else if(possiblePlay2 != null){
              putToken(possiblePlay2);
              possiblePlay1 = null;
              possiblePlay2 = null;
          }
          
        }else if(checkVertical(color, n)){
           if(possiblePlay1 != null){
              putToken(possiblePlay1);
              possiblePlay1 = null;
              possiblePlay2 = null;
          }else if(possiblePlay2 != null){
              putToken(possiblePlay2);
              possiblePlay1 = null;
              possiblePlay2 = null;
          }
          
        }else if(checkDiag1(color, n)){
           if(possiblePlay1 != null){
              putToken(possiblePlay1);
          }else if(possiblePlay2 != null){
              putToken(possiblePlay2);
          }
          
          
        }else if(checkDiag2(color, n)){
          if(possiblePlay1 != null){
              putToken(possiblePlay1);
          }else if(possiblePlay2 != null){
              putToken(possiblePlay2);
          }
            
        }
    }
    
    public void winningSequence(){
            isFinished = true;
            musicPlayer.stop();
            if(isVolumeOn){
            clapPlayer.seek(Duration.ZERO);
            
            clapPlayer.play();
            }
            
            Stage win = new Stage();
            Text txt = new Text("Congrats");
            txt.setFont( new Font(25));
            
            HBox hbox = new HBox();
            hbox.setSpacing(30);
            Button restart = new Button("Restart");
            Button exit = new Button("  Exit  ");
            hbox.getChildren().addAll(exit, restart);
            hbox.setAlignment(Pos.CENTER);
            
            VBox vbox = new VBox();
            vbox.setSpacing(20);
            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(txt, hbox);
            
            exit.setOnAction(e->{
            
                System.exit(0);
            
            });
            
            restart.setOnAction(e->{
                animStop();
                winningSeq.clear();
                initialize();
                win.close();
                clapPlayer.stop();
            
            });
            
            win.setOnCloseRequest(e->{
                animStop();
                winningSeq.clear();
                initialize();
                win.close();
            
            });
            
            
            
            Scene scene = new Scene(vbox, 230, 150);
            win.setScene(scene);
            win.initModality(Modality.APPLICATION_MODAL);
            win.setResizable(false);
            win.setTitle("Winner!");
            win.show();
            
    }
    
    //******************************************************************Wrappers****************************************************************
    public boolean checkHorizontal(Color color, int n){
        possiblePlay1 = null;
        possiblePlay2 = null;
        if((checkRight(currentX+1, currentY, color) + checkLeft(currentX, currentY, color)) >= n){
            return true;
            
        }else
            winningSeq.clear();
            return false;
        
    }
    
    public boolean checkDiag1(Color color, int n){
        possiblePlay1 = null;
        possiblePlay2 = null;
        if((checkDiagDownLeft(currentX, currentY, color) + checkDiagUpRight(currentX+1, currentY-1, color))>= n){
            return true;
        }else
            winningSeq.clear();
            return false;
    }
    
    public boolean checkDiag2(Color color, int n){
        possiblePlay1 = null;
        possiblePlay2 = null;
        if((checkDiagDownRight(currentX, currentY, color)+checkDiagUpLeft(currentX-1, currentY-1, color)) >= n){
            return true;
        }else
            winningSeq.clear();
            return false;
    }
    
    public boolean checkVertical(Color color, int n){
        possiblePlay1 = null;
        possiblePlay2 = null;
        if((checkDown(currentX, currentY, color) + checkUp(currentX, currentY-1, color)) >= n){
            return true;
        }else
            winningSeq.clear();
            return false;
    }
    //******************************************************************Wrappers****************************************************************
    public int checkRight(int x, int y, Color color){
       if(x < 7 && playGround[y][x].getFill().equals(color)){
           winningSeq.add(playGround[y][x]);
           return 1 + checkRight(x+1, y, color);
       }else{
           if(x < 7 && playGround[y][x].getFill().equals(Color.WHITE)){
               possiblePlay1 = playGround[y][x];
           }
           lastCheckedX = x-1;
           lastCheckedY = y;
           return 0;
       }
    }
    
    public int checkLeft(int x, int y, Color color){
        if(x >= 0 && playGround[y][x].getFill().equals(color)){
            winningSeq.add(playGround[y][x]);
            return 1 + checkLeft(x-1, y, color);
       }else{
            if(x>=0 && playGround[y][x].getFill().equals(Color.WHITE)){
               possiblePlay2 = playGround[y][x];
           }
           lastCheckedX = x+1;
           lastCheckedY = y;
           return 0;
        }
    }
    
    public int checkDown(int x, int y, Color color){
        if(y < 6 && playGround[y][x].getFill().equals(color)){
            winningSeq.add(playGround[y][x]);
            return 1+ checkDown(x, y+1, color);
       }else{
            if(( y < 6)  && playGround[y][x].getFill().equals(Color.WHITE)){
                possiblePlay1 = playGround[y][x];
            }
           lastCheckedX = x;
           lastCheckedY = y-1;
           return 0;
        }
    }
    
    public int checkUp(int x, int y, Color color){
        if(y >= 0 && playGround[y][x].getFill().equals(color)){
            winningSeq.add(playGround[y][x]);
            return 1+ checkDown(x, y-1, color);
       }else{
            if((y >=0)  && playGround[y][x].getFill().equals(Color.WHITE)){
                possiblePlay2 = playGround[y][x];
            }
           lastCheckedX = x;
           lastCheckedY = y-1;
           return 0;
        }
    }
    
    public int checkDiagDownRight(int x, int y, Color color){
        if((y < 6 && x < 7) && playGround[y][x].getFill().equals(color)){
            winningSeq.add(playGround[y][x]);
            return 1+ checkDiagDownRight(x+1, y+1, color);
       }else{
            if((y < 6 && x < 7) && playGround[y][x].getFill().equals(Color.WHITE)){
                possiblePlay1 = playGround[y][x];
            }
            lastCheckedX = x-1;
           lastCheckedY = y-1;
           return 0;
        }
    }
    
    public int checkDiagDownLeft(int x, int y, Color color){
        if((y < 6 && x >= 0) && playGround[y][x].getFill().equals(color)){
            winningSeq.add(playGround[y][x]);
            return 1 + checkDiagDownLeft(x-1, y+1, color);
       }else{
            if((y < 6 && x >= 0) && playGround[y][x].getFill().equals(Color.WHITE)){
                possiblePlay1 = playGround[y][x];
            }
            lastCheckedX = x+1;
           lastCheckedY = y-1;
           return 0;
        }
    }
    
    public int checkDiagUpRight(int x, int y, Color color){
        if((y >= 0 && x < 7) && playGround[y][x].getFill().equals(color)){
            winningSeq.add(playGround[y][x]);
            return 1+ checkDiagUpRight(x+1, y-1, color);
       }else{
            if((y >= 0 && x < 7) && playGround[y][x].getFill().equals(Color.WHITE)){
                possiblePlay2 = playGround[y][x];
            }
           lastCheckedX = x-1;
           lastCheckedY = y+1;
           return 0;
        }
    }
    
    public int checkDiagUpLeft(int x, int y, Color color){
        if((y >= 0 && x >= 0) && playGround[y][x].getFill().equals(color)){
            winningSeq.add(playGround[y][x]);
            return 1 + checkDiagUpLeft(x-1, y-1, color);
       }else{
            if((y >= 0 && x >= 0) && playGround[y][x].getFill().equals(Color.WHITE)){
                possiblePlay2 = playGround[y][x];
            }
           lastCheckedX = x+1;
           lastCheckedY = y+1;
           return 0;
        }
    }
    //******************************************************************Checkers******************************************************************
    public void startAnim(){
        for(Circle c : winningSeq){
            animList.add(new FadeTransition(Duration.millis(500), c));
        }
        
        for(FadeTransition anim : animList){
            anim.setCycleCount(Timeline.INDEFINITE);
            anim.setFromValue(1.0);
            anim.setToValue(0.1);
            anim.setAutoReverse(true);
            anim.play();
        }
    }
    
    public void animStop(){
        for(FadeTransition anim : animList){
            anim.stop();
        }
        
        animList.clear();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
