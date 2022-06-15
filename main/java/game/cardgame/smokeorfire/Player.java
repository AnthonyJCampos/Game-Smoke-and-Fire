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
import java.util.ArrayList;
public class Player {
   private boolean drinkOrNot;
   private ArrayList<Card> hand;
   private String name;
   private int handCount;
   private int drinkCount;
   
   public Player(String name){
      
      this.drinkOrNot = false;
      this.name = name;
      this.handCount = 0;
      this.drinkCount = 0;
      this.hand = new ArrayList<Card>();
     }
   
    public void showPlayerCards(){
        System.out.println("---------------------------------------------");
        for (Card card : hand){
            System.out.println(card.toString());
        }
        System.out.println("---------------------------------------------");      
   }
   
   public void showCertainCard(){
      System.out.println();
      
   }
   
   public void drawCard(Card card){
      hand.add(card);
      handCount++;
 
   }
   
   public Card getCard(int index){
   
      return (Card)hand.get(index);    
   }
   
   public int getDrinkCount(){
       return drinkCount;
   }
   
   public void takesADrink(boolean drinkOrNot){
      this.drinkOrNot = drinkOrNot; 
   }
   
   public int getHandCount(){
      return handCount;      
   }
   
   public ArrayList<Card> getHand(){
      return this.hand;
   }
   
   public String getName(){
      return this.name;
   }
   
   public boolean getDrinkStatus(){
      return this.drinkOrNot;
   }
   
   public String toString(){
      String s = this.name; 
      return s;
   }
   
   public void setDrinkCount(int num){
       this.drinkCount = num;       
   }
   
   public void clearPlayerHand(){
        for(int i = hand.size() - 1; i >= 0; i--){
            hand.remove(i);
        }     
   }
   
   public boolean setDrinkStatus(boolean check){
      if(check = true){
         return this.drinkOrNot = true;
           
      } else {
         return this.drinkOrNot = false;
      }  
   }     
}
