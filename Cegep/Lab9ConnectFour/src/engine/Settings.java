/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.awt.Toolkit;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import objects.Computer;
import objects.Human;


/**
 *
 * @author steven
 */
public class Settings {
    private String difficulty = "hard";
    private String playerName = "Human";
    private Color inGameBackgroundColor = Color.BLACK;
    private Media winningMedia= null;
    private Media losingMedia= null;
    private Human human = new Human(playerName);
    private int secondPlayerWins;
    
    public Settings(){
        
    }
    
    public Human getHuman(){
        return human;
    }
    
    public int getSecondPlayerWins(){
        return secondPlayerWins;
    }
    
    public void addWin(){
        secondPlayerWins++;
    }
    public void setDifficulty(String dif){
        difficulty = dif;
    }
    
    public String getDifficulty(){
        return difficulty;
    }
    
    public void setPlayerName(String nm){
        playerName = nm;
    }
    
    public String getPlayerName(){
        return playerName;
    }
    
    public void setBackgroundColor(Color color){
        inGameBackgroundColor = color;
    }
    
    public Color getBackgroundColor(){
        return inGameBackgroundColor;
    }
    
    
}
