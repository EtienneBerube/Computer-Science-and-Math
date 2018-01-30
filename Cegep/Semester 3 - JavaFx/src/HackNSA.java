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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class HackNSA extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setFont(Font.font(STYLESHEET_CASPIAN));
        btn.setText("Hack NSA");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                MediaPlayer sound = new MediaPlayer(new Media("http://soundboard.panictank.net/OOOOOOOOHMYGOOOOD.mp3"));
                MediaView view = new MediaView(sound);
                sound.setVolume(0.1);
                sound.play();
                Text txt = new Text("Bush did 9/11");
                txt.setFont(Font.font(30));
                txt.setTextAlignment(TextAlignment.CENTER);
                txt.setFill(Color.WHITE);
                StackPane pane = new StackPane();
                ImageView img = new ImageView(new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/fire2.jpg",true));
                img.setFitHeight(250);
                img.setFitWidth(250);
                pane.getChildren().addAll(img,txt);
                Stage x = new Stage();
                
                Scene y = new Scene(pane,250,250);
                x.setScene(y);
                
                x.show();
                
            }
        });
        
        ImageView x = new ImageView(new Image("file:C:/Users/Etienne/Documents/1. École/Cégep/Session 3/Programming/Image bank/fire.jpg",true));
        
        StackPane root = new StackPane();
        
        root.getChildren().addAll(x, btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        
        primaryStage.setTitle("NSA Hacker");
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
