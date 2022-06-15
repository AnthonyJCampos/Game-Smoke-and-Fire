/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cardgame.smokeorfire;

import javax.swing.ImageIcon;
/**
 *
 * @author Antho
 */
public class Card {
   // Suits and Ranks of  Deck (Cannot be changed)
   // The zeroth element should never be used, 
   // because the only valid ranks are 1–13. We set it to null to indicate an unused element.
   private final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
   private final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6","7", "8", "9", "10", "Jack", "Queen", "King"};

   
   private int rank;
   private int suit;
   private ImageIcon cardImage;
   private int color;
   
   
   // constructor 
   public Card(int rank, int suit, ImageIcon cardImage){
      this.rank = rank;
      this.suit = suit;
      this.cardImage = cardImage;
      if(this.suit == 1 || this.suit == 2){
         this.color = 0;
      } else {
         this.color = 1;
      }
      
   }
   
   public int getRank(){
      return this.rank;
   }
   
   public int getSuit(){
      return this.suit;
   }
   
   public int getColor(){
      return this.color;
   }
   
   public ImageIcon getCardImage(){
       return this.cardImage;
   }
   
   public boolean equals(Card other){
      
      return this.rank == other.rank && this.suit == other.suit;
      
   }
   public int compareTo(Card other){
      
      if (this.rank == other.rank) {
         if (this.suit < other.suit){
            return -1;
         } else {
            return 1;
         }      
      } else if (this.rank < other.rank){
         return -1;
         
      } else if( this.rank > other.rank) {
         return 1;       
      } else { // 0 if they are equivalent
      
      return 0;   
      }
   }
   
   // toString Method
   public String toString(){   
      String s = RANKS[this.rank] + " of " + SUITS[this.suit];      
      return s;
   }    
}
