/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.cardgame.smokeorfire;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Anthony Campos
 */
public class CardImage {
    final int SIZE = 52;
    private final String[] SUITS = {"C", "D", "H", "S"};
    private final String[] RANKS = {null, "A", "2", "3", "4", "5", "6","7", "8", "9", "10", "J", "Q", "K"};
    private ImageIcon[] images;
 
    public CardImage(){
        this.images = new ImageIcon[SIZE];
        int index = 0;
        for(int suit = 0; suit <= 3; suit++){
            for(int rank = 1; rank <= 13; rank++){
            String mySuit = SUITS[suit];
            String myRank = RANKS[rank];
            String imagePath = "/" + myRank + mySuit + ".png";
            URL imageURL = getClass().getResource(imagePath);
            ImageIcon img = new ImageIcon(imageURL);
            images[index] = img;
            index++;        
            }
        }
    }
	

    public ImageIcon getCardImage(int num){
      return images[num];
    }    
}
