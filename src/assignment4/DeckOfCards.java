/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author henrysmith
 */
public class DeckOfCards {
    
    Scanner input = new Scanner(System.in);

    public Card[] c= new Card[52];
    
    protected int CardsRemaining= 52;
   
    protected int CardsDealt= 0;
    
 
   
    int b = 0;
    
    //Creates a deck of 52 playing cards
    DeckOfCards()
    {
        while (b<CardsRemaining) //while we still havent gone through the deck
        {
            for (int i = 1; i<= 4; i++)//cover all suits
            {
                for (int j = 1; j<= 13;j++)//cover all ranks
                {
                    c[b]= new Card(i,j);
                    b++;
                    
              
                }
            }
        }
    }
    
    //puts cards in random order
    public void shuffle()
    {//puts cards in random order
        Random rand = new Random();
        int newLocation;
        Card temporary;
        
        for(int i = CardsDealt; i<52;++i)
        {
            newLocation = rand.nextInt(CardsRemaining)+CardsDealt; //get new int between Cards Dealt and 51
            temporary = c[i];
            c[i]=c[newLocation];
            c[newLocation]=temporary;
        }
        
       
    }
    
    /**
     * @return returns the number of cards in deck
     */
    public int cardsLeft()//returns number of undelt cards
    {
           return CardsRemaining;     
    }
    
    //returns a card from the deck 
    public Card dealCard() 
    {
       if(CardsRemaining==0)
       {
           shuffle();
           CardsRemaining=52;
           System.out.println("Creating new Deck");
       }
      CardsRemaining--;
       Card d =c[CardsDealt++];
       
       return d;
    
    }
    
    
    
    
//Prints deck to command window
    public void PrintDeck()
    {
        for(int i = 0;i<CardsRemaining;++i)
        {
            System.out.println(c[i]);
            //System.out.println(i+1 +". " + c[i]);
        }
    }

    
    
    
   
    
    
}
