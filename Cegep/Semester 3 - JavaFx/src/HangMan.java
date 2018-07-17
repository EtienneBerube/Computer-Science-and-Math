/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Étienne Bérubé
 */
public class HangMan extends Application {
     Pane man = new Pane();
     ArrayList<Character> used = new ArrayList<>();
     ArrayList<String> wordList = new ArrayList<>();
     PathTransition anim;
     
     
     Circle head;
     Line body;
     Line leftHand;
     Line rightHand;
     Line leftLeg;
     Line rightLeg;
     Arc base;
     Polyline hang;
     TextField guess;
     Text compMess;
     Text graphicWord;
     
     String word;
     String tempWord = "";
     String path = "C:/Users/Etienne/Documents/1.Ecole/Cégep/Session 3/Programming/Text Bank/hangman.txt";
     int missed;
     
     
     
    @Override
    public void start(Stage primaryStage) {
        initializeShapes();
        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15, 15, 25, 15));
        
        
        
        
        //*************************************************************
        VBox game = new VBox();
        game.setSpacing(20);
        HBox lbl = new HBox();
        
        HBox mess = new HBox();
        mess.setAlignment(Pos.CENTER);
        
        compMess = new Text();
        
        mess.getChildren().add(compMess);
        
        lbl.setAlignment(Pos.CENTER);
        
        
        graphicWord = new Text("");
        graphicWord.setFont(Font.font(25));
      
        lbl.getChildren().add(graphicWord);
        
        Pane graph = new Pane();
        graph.getChildren().addAll(base, hang, man);
       
        game.getChildren().addAll(graph, mess ,lbl);
        
        //************************************************************
        HBox control = new HBox();
        control.setAlignment(Pos.TOP_CENTER);
        
        guess = new TextField("");
        guess.setPrefColumnCount(1);
       
        guess.textProperty().addListener(e->{
         
            if(guess.getText().length()>1){
                compMess.setText("");//<------------------------- changed label
                guess.setText("" + guess.getText().charAt(0));
            }
        });
        
        Button go = new Button("Go!");
        
        control.getChildren().addAll(guess, go);
        
        //***********************************************************
        
        root.setBottom(control);
        root.setCenter(game);
        //***********************************************************Game************************************************
        //TODO
        showPop(primaryStage);
        
        
        graphicWord.setText(tempWord);
        EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    
        if(guess.getText().length() < 1){   
                compMess.setText("Invalid Word");
            
        }else if(used.contains(guess.getText().charAt(0))){
            compMess.setText("The Character: " + guess.getText() + " have already been used");
        
        }else if(characterCheck(guess.getText().charAt(0))){
            String temp ="";

            for(int i = 0; i < word.length(); i++){
                if(tempWord.charAt(i)!= '*'){
                    temp+= word.charAt(i);
                }else if(word.charAt(i) == guess.getText().charAt(0)){
                    temp+=word.charAt(i);
                    compMess.setText("Congrats!");
                }else
                    temp+="*";
            }
            
            tempWord = temp;
            graphicWord.setText(tempWord);
        }else{
            compMess.setText("The character: " + guess.getText().charAt(0) + " is not in the word");
            missed++;
            used.add(guess.getText().charAt(0));
            guess.setText("");
        }
        
        if(tempWord.equals(word)){
            guess.setEditable(false);
            go.setDisable(true);
            compMess.setText("You won, the word is: ");
        }
        
            drawBody(missed);
            guess.setText("");
        
        };
            
        };
        
        go.setOnAction(e);
        guess.setOnAction(e);
        
        
        
        
        //****************************************************************************************************************
        Scene scene = new Scene(root, 500, 650);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        
        
    }
    
    public void drawBody(int error){
        man.getChildren().clear();
        
        switch(error){
            case 6: man.getChildren().add(leftLeg);
                    guess.setEditable(false);
                    graphicWord.setText(word);
                    compMess.setText("Too bad, the word was: ");
                    anim = new PathTransition(Duration.millis(1000), new Arc(180, 200, 20, 40, 180, 180), man);
                    anim.setCycleCount(Timeline.INDEFINITE);
                    anim.setAutoReverse(true);
                    
                    anim.play();
            case 5: man.getChildren().add(rightLeg);
            case 4: man.getChildren().add(leftHand);
            case 3: man.getChildren().add(rightHand);
            case 2: man.getChildren().add(body);
            case 1: man.getChildren().add(head);
        }
    }
    
    private void initializeWordBank(String path){
        path = path.replace('\\', '/');
        
        File file = new File(path);
        //System.out.println("debug: " + file.exists());
        
        try{
            Scanner input = new Scanner(file);
            
            while(input.hasNext()){
                wordList.add(input.next());
            }
            
            
        }catch(Exception x){
            System.out.println("file doesnt exist m8");
        }
    }
    
    private void initializeShapes(){
        base = new Arc(100, 480, 75, 20, 0, 180);
        base.setFill(Color.TRANSPARENT);
        base.setStroke(Color.BLACK);
        
        hang = new Polyline();
        hang.getPoints().addAll(100.0, 460.0, 100.0,80.0, 300.0, 80.0, 300.0, 125.0 );
        
        head = new Circle(300.0, 165.0 , 40.0);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        
        rightHand = new Line(300.0, 185.0, 250.0, 300.0);
        leftHand = new Line(300.0, 185.0, 350.0, 300.0);
        body = new Line(300.0 , 205.0, 300.0, 355.0);
        rightLeg = new Line(300.0, 355.0, 250.0, 455.0);
        leftLeg = new Line(300.0, 355.0, 350.0, 455.0);
    }
    
     
    
    public void getWord(){
        word = wordList.get((int)(Math.random()*wordList.size()));
    }
    
    public boolean characterCheck(char c){
        boolean result = false;
        
        for(int i = 0; i< word.length(); i++){
            if(word.charAt(i) == c)
               result = true;     
        }
        
        return result;
    }
    
    
    public void showPop(Stage x){
        Stage pop = new Stage();
        
        VBox v = new VBox();
        v.setAlignment(Pos.TOP_CENTER);
        v.setPadding(new Insets(25));
        
        GridPane grd = new GridPane();
        RadioButton preLoaded = new RadioButton("Default Library");
        RadioButton custom = new RadioButton("Custom Library");
        
        ToggleGroup tg = new ToggleGroup();
        
        preLoaded.setSelected(true);
        preLoaded.setToggleGroup(tg);
        custom.setToggleGroup(tg);
        
        TextField customPath= new TextField();
        customPath.setDisable(true);
        
        Button ok = new Button("Ok");
        grd.add(preLoaded, 0, 0);
        grd.add(custom, 0, 1);
        grd.add(customPath, 0, 2);
        grd.add(ok, 2, 4);
        v.getChildren().addAll(new Text("Which library to use?"), grd);
        
        EventHandler<ActionEvent> dis = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(preLoaded.isSelected()){
                    customPath.setDisable(true);
                }else
                    customPath.setDisable(false);
            }
        };
        
        ok.setOnAction(e->{
            if(!customPath.isDisable())
                path = customPath.getText();
            
            initializeWordBank(path);
            getWord();
        
        
            System.out.println(word);
            
            tempWord="";
            
            for(int i = 0; i < word.length(); i++){
            tempWord+="*";
            }
            
            graphicWord.setText(tempWord);
            
            pop.close();
            x.show();
            
        });
        
        preLoaded.setOnAction(dis);
        custom.setOnAction(dis);
        
        Scene s = new Scene(v, 300, 200);
        pop.setScene(s);
        pop.setTitle("Options");
        pop.show();
    }
    
    
   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
