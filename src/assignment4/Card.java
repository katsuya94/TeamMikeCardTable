/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4;

import java.util.Scanner;

/**
 *
 * @author henrysmith
 * 
 */
public class Card {
    private int suit;
    private int rank;
    Scanner in = new Scanner(System.in);

    /**
     * @param int Suit, the suit of the card
     * @param int Rank, the rank of the card
     */
    
    Card(int S, int R)
    {
        if(S<=0 || S>4 ||R<=0 || R>13)
        {
            System.out.println("Invalid Rank is not 1,13 or inbetween, Or Suit is not 1,4 or inbetween.");
            System.out.print(" Please enter valid suit, 1 for Hearts, 2 for Clubs, 3 for Diamonds, 4 for Spades: ");
           suit = in.nextInt();
           System.out.print("Please enter valid rank, 1 for Ace, 2 - 10, 11 for Jack, 12 for Queen, 13 for King: ");
           rank = in.nextInt();
           
            
        }
        else
        {   
            suit=S;
            rank=R;
        }
    }
    
    
    // returns suit of card
    public int getSuit()
    {
        return suit;
    }
    /**
     * @return returns rank of card
     */
    public int getRank()
    {
        return rank;
    }
    
    @Override public String toString()
    {
        
        String RANK = null;
        String SUIT = null;
        
        switch(suit)
        {
            case 1: SUIT= "Hearts";
                break;
            
            case 2: SUIT = "Clubs";
                break;
                
            case 3: SUIT= "Diamonds";
                break;
            
            case 4: SUIT = "Spades";
                break;
        }
        
        switch(rank) 
        {
            case 1: RANK = "Ace";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                RANK=Integer.toString(rank); 
                break;
            case 11: RANK = "Jack";
                break;
            case 12: RANK = "Queen";
                break;
            case 13: RANK = "King";
                break;        
        }
         
        return (RANK + " of " + SUIT);
    }
}
