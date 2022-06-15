/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cardgame.smokeorfire;

/**
 *
 * @author Antho
 */


public class Deck {
   final int SIZE = 52;
   private Card[] deck;
   private int topCard;
      
   public Deck(){    
      this.deck = new Card[SIZE];
      int index = 0;
      CardImage imageDeck = new CardImage();
      topCard = 0;     
      for(int suit = 0; suit <= 3; suit++){
         for(int rank = 1; rank <= 13; rank++){;        
            deck[index] = new Card(rank, suit, imageDeck.getCardImage(index));
            index++;
         }
      }     
   }
   /*public Deck(){    
      this.deck = new Card[SIZE];
      int index = 0; 
      topCard = 0;     
      for(int suit = 0; suit <= 3; suit++){
         for(int rank = 1; rank <= 13; rank++){;        
            deck[index] = new Card(rank, suit);
            index++;
         }
      }     
   }*/   

   //shuffles the deck of deck
   public void shuffle(){
      topCard = 0;      
      for(int i = 0; i < this.deck.length; i++){
         int rCard = randInt (i, deck.length-1);
         swapCards(i, rCard);       
      }      
   }
   //swapCards 
   public void swapCards(int i, int rCard){
      Card temp = deck[i];
      deck[i] = deck[rCard];
      deck[rCard] = temp;
   }
   
   //find a card in the deck
   public int findCard (Card card) {
     for (int i=0; i<deck.length; i++) {
		
       // two deck are considered to be the same if they have the same rank
       // and suit (even if they are not the same object)
       if (deck[i].getRank() == card.getRank() && deck[i].getSuit() == card.getSuit()) 
         return i;
     }
     return -1;
   }   
   
   public Card dealACard()
   {
      // determine whether Cards remain to be dealt
      if (topCard < deck.length ){
         return deck[ topCard++ ]; // return current Card in array
      }else {        
         return null; // return null to indicate that all Cards were dealt 
      }   
   }
   
   public boolean isEmpty(){
      // determine whether Cards remain to be dealt
      if (topCard < deck.length ){
         return false;
      }else {        
         return true; // return null to indicate that all Cards were dealt 
      }             
   }
   
   //randInt: returns a random integer [low, high]  (including low and  high)
   public static int randInt (int low, int high) {
      double x = Math.random() * (high - low + 1);
      return (int) x + low;
   }   
   
   public void printDeck() {     
       for (int i = 0; i < this.deck.length; i++) {
           System.out.println(this.deck[i]);
       }
   }    
}
