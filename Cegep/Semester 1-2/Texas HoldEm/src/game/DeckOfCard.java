package game;

import java.util.Collections;

public class DeckOfCard {
	private Card[] deck = new Card[52];
	private int numOfCards = 0;
	
	public DeckOfCard(){
		initialize();
	}
	
	public void initialize(){
		for(int i=0, value = 1; i< 13;i++, value++){
			deck[i] = new Card(value,"Black","Clubs");
			numOfCards++;
		}
		for(int i=13, value = 1; i< 26;i++, value++){
			deck[i] = new Card(value,"Black","Spades");
			numOfCards++;
		}
		for(int i=26, value = 1; i< 39;i++, value++){
			deck[i] = new Card(value,"Rouge","Diamonds");
			numOfCards++;
		}
		for(int i=39, value = 1; i< 52;i++, value++){
			deck[i] = new Card(value,"Rouge","Hearts");
			numOfCards++;
		}
	}
	
	public int getNumOfCards(){
		return numOfCards;
	}
	
	public void printCompleteDeck(){
		for(Card card: deck){
			System.out.println(card.toString());
		}
	}
	
	public void shuffleDeck(){
		int rndIndex=1;
		Card temp;
		
		for(int i =0; i < deck.length; i ++){
			
			do{ // protection to not swap with itself
				rndIndex = (int)(Math.random()*52);
			}while(i==rndIndex);
			
			temp = deck[i];
			deck[i] = deck[rndIndex];
			deck[rndIndex] = temp;
		}
	}
}

