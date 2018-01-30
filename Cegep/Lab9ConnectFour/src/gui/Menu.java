/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import engine.GameEngine;
import engine.Settings;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author steven
 */
public class Menu extends Application {
    private Settings settings = new Settings();
    
    public Menu(Settings settings){
        this.settings = settings;
    }
    
    public Menu(){
        
    }
    @Override
    public void start(Stage primaryStage) {            
    File fileBackground = new File("src/media/background.jpg");
       
        BackgroundImage myBI= new BackgroundImage(new Image(fileBackground.toURI().toString(),310,315,false,true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);

        BorderPane pane = new BorderPane();
        HBox root = new HBox();
        pane.setBottom(root);
  
        Button play = new Button("Play");
        Button options = new Button("Options");
        Button exit = new Button("Exit");

        root.getChildren().addAll(play,options,exit);
        root.setSpacing(25);
        root.setPadding(new Insets(10,10,10,10));
        root.setAlignment(Pos.CENTER);
        //pane.setStyle("-fx-background-color: blue");
        
        exit.setOnAction(e->{           
            System.exit(0);
        });
       // NEW OPTION STAGE
        options.setOnAction((ActionEvent e) ->{
          File file = new File("src/media/button1.wav");
            Media sound = new Media(file.toURI().toString());
            MediaPlayer player = new MediaPlayer(sound);
           player.stop();
            player.seek(Duration.ZERO);
            player.play();
            player.setVolume(1);
           
            
        GridPane optionPane = new GridPane();   
        // Add a title to the stage pane
        HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.setPadding(new Insets(10,10,10,50));
        Label titleOption = new Label("Options");
    
        title.getChildren().add(new Label("Options"));
          optionPane.addRow(0, title);
        // allow the user to change his/her name
        HBox userNameInput = new HBox();
        Label userName = new Label("Player Name: ");
        TextField userNameInputField = new TextField();
        userNameInputField.setPrefColumnCount(10);
        userNameInputField.setText(settings.getPlayerName());
        userNameInput.getChildren().addAll(userName, userNameInputField);
        userNameInput.setPadding(new Insets(10,10,10,10));
        userNameInput.setSpacing(10);
        optionPane.addRow(1, userNameInput);
               
        // Create Radio Buttons for Difficulty
        HBox difficulty = new HBox();
        Label diff = new Label("Difficulty: ");
        RadioButton easy = new RadioButton("Easy");
        RadioButton normal = new RadioButton("Normal");    
        RadioButton hard = new RadioButton("Hard");
        // create toggle group
        ToggleGroup dif = new ToggleGroup();
        easy.setToggleGroup(dif);
        normal.setToggleGroup(dif);
        hard.setToggleGroup(dif);
        // modify HBox
        difficulty.setSpacing(10);
        difficulty.setPadding(new Insets(10,10,10,10));
        difficulty.getChildren().addAll(diff, easy, normal, hard);
         optionPane.addRow(2, difficulty);
        // set default toggle
        if(settings.getDifficulty().toLowerCase().compareTo("easy") == 0){
            dif.selectToggle(easy);
        }
        else if(settings.getDifficulty().toLowerCase().compareTo("normal") == 0){
            dif.selectToggle(normal);
        }
        
        else
            dif.selectToggle(hard);
        // Change In-Game Color based on 3 options White, Black and Blue
         HBox colorPane = new HBox();
        Label background = new Label("Background: ");
        RadioButton white = new RadioButton("White");
        RadioButton black = new RadioButton("Black");    
        RadioButton blue = new RadioButton("Blue");
        // create toggle group
        ToggleGroup colors = new ToggleGroup();
        white.setToggleGroup(colors);
        black.setToggleGroup(colors);
        blue.setToggleGroup(colors);
        // modify HBox
       colorPane.setSpacing(10);
        colorPane.setPadding(new Insets(10,10,10,10));
        colorPane.getChildren().addAll(background, white, black, blue);
         optionPane.addRow(3, colorPane);
        // set default toggle
        if(settings.getBackgroundColor() == Color.WHITE){
           colors.selectToggle(white);
        }
        else if(settings.getBackgroundColor() == Color.BLACK){
            colors.selectToggle(black);
        }
        
        else
            colors.selectToggle(blue);
        
        // save buttons 
        HBox ui = new HBox();
        Button save = new Button("Save Changes");
        Button cancel = new Button("Cancel and Exit");
        ui.getChildren().addAll(save, cancel);
        ui.setSpacing(100);
        ui.setPadding(new Insets(10,10,10,10));
        optionPane.addRow(4, ui);
        
      
        
        Scene optionScene = new Scene(optionPane, 350, 300);
        Stage stage = new Stage();
        stage.setTitle("Options");
        stage.setScene(optionScene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.setResizable(false);
        cancel.setOnAction(c->{
           player.stop();
            player.seek(Duration.ZERO);
            player.play();
            player.setVolume(1);
          stage.close();
      });
        save.setOnAction(s->{
         
           player.stop();
            player.seek(Duration.ZERO);
            player.play();
            player.setVolume(1);
           settings.setPlayerName(userNameInputField.getText());
        
        if(dif.getSelectedToggle() == easy){
            settings.setDifficulty("easy");
        }
        else if(dif.getSelectedToggle() == normal){
            settings.setDifficulty("normal");
        }
        else
            settings.setDifficulty("hard");
        
        // save color options
        
        if(colors.getSelectedToggle() == white){
            settings.setBackgroundColor(Color.WHITE);
        }
        else if(colors.getSelectedToggle() == black){
            settings.setBackgroundColor(Color.BLACK);
        }
        else
            settings.setBackgroundColor(Color.BLUE);
        // close the stage
        stage.close();
        });
        });
      
        // set action on play
        
        play.setOnAction(e->{
          File file = new File("src/media/button1.wav");
          Media sound = new Media(file.toURI().toString());
           
            MediaPlayer player = new MediaPlayer(sound);
           player.stop();
            player.seek(Duration.ZERO);
            player.play();
            player.setVolume(1);
            
            GameEngine engine = new GameEngine(settings, primaryStage);
            Game game = new Game(engine);
            game.start(primaryStage);
           
        });
      pane.setBackground(new Background(myBI));
       Scene scene = new Scene(pane, 300, 300);
      
     
       primaryStage.setTitle("Connect Four");
       primaryStage.setScene(scene);
       primaryStage.show();
       primaryStage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
