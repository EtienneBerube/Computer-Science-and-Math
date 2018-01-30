/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.paint.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Étienne Bérubé
 */
public class GraphicCalendar extends Application {
    GregorianCalendar cal = new GregorianCalendar();    
    GregorianCalendar prevCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)-1, 1);
    GregorianCalendar nextCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, 1);
    GridPane grid = new GridPane();
    Text txt1 = null;
    
    @Override
    public void start(Stage primaryStage) {
        
        cal.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.DAY_OF_WEEK));
        
        VBox root = new VBox();
        HBox lbl = new HBox();
        //*****************************************Top**************************************************
        txt1 = new Text("" + getMonthName(cal.get(Calendar.MONTH))+ ", " + cal.get(Calendar.YEAR));
        
        lbl.getChildren().add(txt1);
        lbl.setAlignment(Pos.CENTER);
        
        root.getChildren().add(lbl);
        //****************************************GridPane**********************************************
        
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));
        
        
        printCal();
       
        
        HBox but = new HBox();
        
        Button prev = new Button("Prior");
        
        prev.setOnAction(e->{
            
            nextCal = cal;
            cal = prevCal;
            prevCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)-1, 1);
            
            txt1.setText("" + getMonthName(cal.get(Calendar.MONTH))+ ", " + cal.get(Calendar.YEAR));
            
            grid.getChildren().clear();
            printCal();
        
        });
        
        
        Button next = new Button("Next");
        
        next.setOnAction(e->{
        
            prevCal = cal;
            cal = nextCal;
            nextCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, 1);
            
            txt1.setText("" + getMonthName(cal.get(Calendar.MONTH))+ ", " + cal.get(Calendar.YEAR));
            
            grid.getChildren().clear();
            printCal();
        
        
        });
        
        
        but.setAlignment(Pos.CENTER);
        but.setSpacing(5);
        
        but.getChildren().addAll(prev, next);
        
        root.getChildren().add(grid);
        
        root.getChildren().add(but);
        
        Scene scene = new Scene(root, 450, 250);
        
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
    
    public String getMonthName(int month){
        switch(month){
            case 0: return "January";
            case 1: return "febuary";
            case 2: return "March";
            case 3: return "April";
            case 4: return "May";
            case 5: return "June";
            case 6: return "July";
            case 7: return "August";
            case 8: return "September";
            case 9: return "October";
            case 10: return "November";
            case 11: return "December";
        }
        return "";
    }
    public String getDayName(int i){
        switch(i){
            case 0: return "Sunday";
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
        }
        return "";
    }
    
    public void printCal(){
         int firstDayInWeek = cal.get(Calendar.DAY_OF_WEEK);
        int dayInPreviousMonth = prevCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = dayInPreviousMonth - firstDayInWeek +2 ;
        
        for(int i = 0; i< 7; i++){
            grid.add(new Label(getDayName(i)), i, 0);
        }
        
        
        Text[][] backCal= new Text[6][7];
        
        for(int i = 0; i < backCal.length; i++){
            for(int j = 0; j < backCal[i].length; j++){
                backCal[i][j] = new Text("");
            }
        }
        
        
        for(int i = 0; i < firstDayInWeek -1; i++) { // First Days in gray
            backCal[0][i] = new Text(""+day);
            backCal[0][i].setStroke(Color.GRAY);
            day++;
        }
        
        day = 1;
        
        for(int i= firstDayInWeek-1; i<7; i++){//Finish first week
            backCal[0][i] = new Text(""+day);
            day++;
        }
        int lastI = 0;
        int lastJ = 0;
        
        for(int i = 1; i < 6; i++){
            for(int j = 0; j< 7 && day <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); j++){// Rest of Month
                backCal[i][j] = new Text(""+day);
                day++;
                lastI = i;
                lastJ = j;
            }
        }
        
        day = 1;
        for(int j = lastJ+1; j < 7; j++){ // finish partial month
            backCal[lastI][j] = new Text(""+day);
            backCal[lastI][j].setStroke(Color.GRAY);
            day++;
        }
        
        for(int i = 0; i < 6; i++){ 
            for(int j = 0; j < 7; j++){
                grid.add(backCal[i][j], j, i+1);
            }
        }
    }
    
}
