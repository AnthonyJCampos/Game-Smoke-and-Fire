
package game.cardgame.smokeorfire;

/**
 *
 * @author Anthony Campos
 */

import javax.swing.ImageIcon;
public class SmokeOrFire {

   private final int PILE_SIZE = 3;
   private final static String newline = "\n";
   private Player[] players;
   private int playerCount; 
   private int currentPlayer = 0;
   private int pileRound;
   private int gameRound;
   private boolean emptyDeck;
   private int choice;
   private String suitChoice;
   private String message;
   private ImageIcon cardDrawn= new ImageIcon();
   private Deck deck;
   private Card[] give = new Card[PILE_SIZE];
   private Card[] take = new Card[PILE_SIZE];
   private Card[] share = new Card[PILE_SIZE];
   private Card[] fuckYou = new Card[1]; 
      
   
   public SmokeOrFire(){
      this.players = new Player[0];
      this.deck = new Deck();
      this.message = "";
      this.choice = 0;
      this.suitChoice = "";
      this.gameRound = 1;
      this.emptyDeck = false;
   }
   
    //shuffles the games deck.
   public void startGame(){ 
       deck.shuffle();
       listPlayerNames();
       pileMaker(this.give, PILE_SIZE); // index 0
       pileMaker(this.take, PILE_SIZE); // index 1
       pileMaker(this.share, PILE_SIZE); // index 2
       pileMaker(this.fuckYou, 1); // index 4
      
      
   }
   
   public void resetGame(){
      for(Player player : players){
          player.clearPlayerHand();
      }       
      this.deck = new Deck();
      this.message = "";
      this.choice = 0;
      this.suitChoice = "";
      this.gameRound = 1;
      this.emptyDeck = false;
      this.players = new Player[0];
   }
   
   public void returnGame(){
      this.players = new Player[0];       
      this.deck = new Deck();
      this.message = "";
      this.choice = 0;
      this.suitChoice = "";
      this.gameRound = 1;
      this.emptyDeck = false;
            
   }

   public void replayGame(){
      this.deck = new Deck();
      this.message = "";
      this.choice = 0;
      this.suitChoice = "";
      this.gameRound = 1;
      this.emptyDeck = false;
      for(Player player : players){
          player.clearPlayerHand();
      }
   }
   
   
   // creates player object
   public void createPlayer(int playerNum, String playerName){
       players[playerNum] = new Player(playerName);  
   }
   // returns player count
   public int getPlayerCount(){
       return playerCount;
   }
   
   public boolean getEmptyDeck(){
       return emptyDeck;
   }
   // returns a specific player
   public Player getPlayer(int num){
       return players[num];
   }
   
   public String getMessage(){
        return message;
   }
   
   public int getCurrentPlayer(){
      return currentPlayer; 
   } 
   
   public int getGameRound(){
       return gameRound;
   }
   
   public ImageIcon getCardDrawn(){
       return this.cardDrawn;
   }
     
   
   // sets the player count for the game
   public void setPlayerCount(int playerCount){ 
       this.players = new Player[playerCount];
       this.playerCount = playerCount;   
   }
   
   public void setChoice(int choice){
        this.choice = choice;
   }
   
   public void setSuitChoice(String suitChoice){
       this.suitChoice = suitChoice;
   }
   
   private void setMessage(String s){
       this.message = s;
   }
   
   public void setCurrentPlayer(int c){
       this.currentPlayer = c;
   }
   
   public void setGameRound(int r){
       this.gameRound = r;
   }
   
   public void SetPileRound(int inRowPosition){
       this.pileRound = inRowPosition;
   }
     
   public void listPlayerNames(){
        int count = 1;
        String s = "";
        
        s += "Welcome to Smoke Or Fire" + newline  + "The Players Are:";
        for (Player player : players){
            
            s += newline + "Player " + count + ": " + player.toString();
            count++;
        }
        setMessage(s);
   }   
       
   public String askQuestion1(int current){
        String s = "";
        if(gameRound == 1){
            s += players[currentPlayer].toString() + " Smoke or Fire?" + newline;              
        } else if(gameRound == 2){
            s += players[currentPlayer].toString() + " Higher or Lower?" + newline;
        } else if (gameRound == 3){
            s += players[currentPlayer].toString() + " In or Out" + newline;
        } else { // round == 4)
            s += players[currentPlayer].toString() + " Guess the Suit " + newline;
        }
        return s;
   }
   
   public String finalString(){
       String s = "";
       
       s += "Welcome to the Final Round of Smoke or Fire."+ newline;
       s += "We will flip a card from the Give, Take, and Share piles." + newline;
       s += "If a Card in your hand matches the Rank of one of these Cards you will have to Give, Take, or Share a Drink." + newline;
       s += "Let's begin";       
       
       return s;
   }
   
   public String roundOne(int currentPlayer){         
        String s = "";                
        players[currentPlayer].drawCard(deck.dealACard());
         
        s += "You drew a: " +  players[currentPlayer].getCard(0) + newline;                       
         
        if(players[currentPlayer].getCard(0).getColor() != choice){
            s += players[currentPlayer].toString() + " Has to Drink!";            
        } else {
            s += players[currentPlayer].toString() + " Give out one Drink!";         
        }
        return s;
   }
   

   
   public String roundTwo(int currentPlayer){
       String s = "";
       players[currentPlayer].drawCard(deck.dealACard());
       
       s += "You drew a: " + players[currentPlayer].getCard(1) + newline;
       
       int cardOne = players[currentPlayer].getCard(0).getRank();
       int cardTwo = players[currentPlayer].getCard(1).getRank();      
       
       if(choice == 1){ // Higher
          if(cardOne >= cardTwo){ // Card1 = 6 and Card2 = 4
               s += "Sorry the " + players[currentPlayer].getCard(1) + " is Lower than " + players[currentPlayer].getCard(0) + newline;
               s +=  players[currentPlayer].toString() + " Has to take two Drinks!";   
          }else {
               s +=  "Congratz the " + players[currentPlayer].getCard(1) + " is Higher than " + players[currentPlayer].getCard(0)+ newline;
               s +=  players[currentPlayer].toString() + " Give out two Drinks!";  
          }
        } else { // choice = 0 Lower
           if(cardOne <= cardTwo){ // Card1 = 6 and Card2 = 7
               s +=  "Sorry the " + players[currentPlayer].getCard(1) + " is Higher than " + players[currentPlayer].getCard(0)+ newline;
               s +=  players[currentPlayer].toString() + " Has to take two Drinks!";
            } else {
               s +=  "Congratz the " + players[currentPlayer].getCard(1) + " is Lower than " + players[currentPlayer].getCard(0)+ newline;
               s +=  players[currentPlayer].toString() + " Give out two Drinks!"; 
            }  
         }      
         return s;
   }
   
   public String roundThree(int currentPlayer){
        String s = "";
        players[currentPlayer].drawCard(deck.dealACard());
         
        s += "You drew a: " + players[currentPlayer].getCard(2) + newline;
        int cardOne = players[currentPlayer].getCard(0).getRank();
        int cardTwo = players[currentPlayer].getCard(1).getRank();
        int cardThree = players[currentPlayer].getCard(2).getRank();
        
        if(cardOne == cardThree || cardTwo == cardThree){
            s += "That sucks, you drew a Card that has the same rank as one in your Hand " + newline;
            s += "That means you have to take three Drinks!";
         
        } else if(choice == 1){ // response In
            
            if((cardThree > cardOne && cardThree < cardTwo) || (cardThree < cardOne && cardThree > cardTwo)){
               s += "That is Inside: " + players[currentPlayer].getCard(0) + " and " + players[currentPlayer].getCard(1) + newline;
               s += players[currentPlayer].toString() + " Give out Three Drinks!";
            } else {
               s += "That is Outside: " + players[currentPlayer].getCard(0) + " and " + players[currentPlayer].getCard(1);
               s += players[currentPlayer].toString() + " Has to take three Drinks!";
            }  
            
        } else { //response Out
            
            if((cardThree > cardOne && cardThree < cardTwo) || (cardThree < cardOne && cardThree > cardTwo)){
               s += "That is Inside: " + players[currentPlayer].getCard(0) + " and " + players[currentPlayer].getCard(1) + newline;
               s += players[currentPlayer].toString() + " Has to take three Drinks!";
            } else {
               s += "That is Outside: " + players[currentPlayer].getCard(0) + " and " + players[currentPlayer].getCard(1) + newline;
               s += players[currentPlayer].toString() + " Give out Three Drinks!";
            }
        }
        return s;           
   }
      
   public String roundFour(int currentPlayer){
       String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"}; 
       String s = "";
       
       players[currentPlayer].drawCard(deck.dealACard());
       s += "You drew a: " + players[currentPlayer].getCard(3) + newline; 
       int cardDrawn = players[currentPlayer].getCard(3).getSuit();
       String suitDrawn = suits[cardDrawn];
       
       if(suitChoice.equalsIgnoreCase(suitDrawn)){
           s += "You Guessed " + suitChoice +" and you were correct. Give out four Drinks!"; 
       } else {
           s += "You Guessed " + suitChoice + " but drew a " + suitDrawn + ". Take four Drinks!"; 
       }
       return s;
   }
   
   
   
   // Round 5 Flip a Card Action
   public void roundFive(int pileType, int positionInRow){ 
      
       Card[][] piles = {this.give, this.take, this.share, this.fuckYou};
       
       roundFiveAction(piles[pileType], positionInRow, pileType);
   }
   
   //method plays a card from a given pile   
   public void roundFiveAction(Card[] pile, int positionInRow, int pileType){
      int flippedCard;
      flipCard(pile, positionInRow, pileType);
      flippedCard = pile[positionInRow].getRank();
      handCheck(flippedCard);   
      playPile(pileType);         
   }   
   
   //method that prints the card drawn from the given pile
   public void flipCard(Card[] pile, int positionInRow, int pileType){
      String s = "";
      String[] flipNum = {"first", "second", "third", "Fuck You", "Test"};
      String[] pileName = {"Give", "Take", "Share", "Fuck You", "Test"};
      s += "The " + flipNum[positionInRow] + " card from the " + pileName[pileType] + " pile is: " + pile[positionInRow] + newline;
      this.cardDrawn = pile[positionInRow].getCardImage();
      setMessage(s);
   }      
   
   //method the reports if a player has to do a certain action.
   public void playPile(int pileType){
      String s = "";
      boolean check = false;      
      for(Player player : players){
         if(player.getDrinkStatus() == true){ 
            playerAction(pileType, player);
            check = true;
         }
         //player.takesADrink(false); // resets drink status of  player
      }
          
     if(emptyDeck != true && check == false){
        s = newline + "No one had that Card, Draw Another Card." + newline;      
        
     } else if(emptyDeck == true && check != true){
         
         if(pileType == 3){
            s = newline + "No one had that Card and there are no Cards left in the Deck. That's Game." + newline;
         } else {
            s = newline + "No one had that Card; however, there are no Cards left in the Deck." + newline + "We will move onto the next Card to Flip." + newline;              
         }
        
     }
      s = getMessage() + s;
      setMessage(s);
   

   }
   
   //method the prints the action the player has to take
   public void playerAction(int pileType, Player player){
      String s = "";
  
      int[] drinkAmount = {1, 2, 3};
      if(pileType == 3){
         s += player.getName() + " Looks like you got the the Big Fuck You! Take a Shot Or Chug a Beer!";   
      } else if(pileType == 2){
         s += player.getName() + " has to share " + drinkAmount[pileRound] * player.getDrinkCount() + ".";   
      } else if(pileType == 1){
         s += player.getName() + " has to take "  + drinkAmount[pileRound] * player.getDrinkCount() + ".";
      } else {
         s += player.getName() + " has to give "  + drinkAmount[pileRound] * player.getDrinkCount() + ".";
      }
      
      s = getMessage() + newline + s;
      setMessage(s);
   }
   //method that draws a new card if know players have the flipped card. 
   public void reDraw(int pileType){
      String s; 
      if(deck.dealACard() != null){
        Card drawnCard = deck.dealACard();
        int flippedCard = drawnCard.getRank();
        //s = getMessage() + newline + "The drawn Card is: " + newCard[0] + newline;
        s = "The drawn Card is: " + drawnCard.toString() + newline;
        setMessage(s);
        this.cardDrawn = drawnCard.getCardImage();
        handCheck(flippedCard); // checks the players hands to see if they have the card. 
        playPile(pileType); // checks to see if a player has to do an action.
        this.emptyDeck = false;
      } else{
          s = "The are no more cards left in the deck!" + newline;
          setMessage(s);
          this.emptyDeck = true;

      }
      
   }
   
   
   //method checks to see if the player's hand as the drawn card
   public void handCheck(int flippedCard){        

       for(Player player : players){
        int count = 1;   
         for(int i = 0; i < 4; i++){            
            //if player has the card set players drink status to true
            if(flippedCard == player.getCard(i).getRank()){
               player.takesADrink(true);
               player.setDrinkCount(count);
               count++;
            }
         }
        count = 1;
      }
   }
   //check if any player as to drink
   public boolean playerDrinkCheck(){
      for(Player player : players){
         if(player.getDrinkStatus() == true){ 
            return true;
         }
      }       
       return false;
   }
   //reset all player drink status
   public void resetPlayersDrinkStatus(){
      for(Player player : players){
         if(player.getDrinkStatus() == true){ 
         }
         player.takesADrink(false); // resets drink status of  player
      }       
   }

   //method creates each pile
   public Card[] pileMaker(Card[] a, int size){
      
      for(int i = 0; i < size; i++){
         a[i] = deck.dealACard();
      }   
      return a;
   }   
   
    
}
