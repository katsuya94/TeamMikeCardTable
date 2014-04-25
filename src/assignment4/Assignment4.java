/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment4;

import assignment4.Table;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 *
 * @author henrysmith
 */
public class Assignment4 {
   
    
    //@return returns an integer
     

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Table table = new Table();
        
        JFrame myFrame = new JFrame("Cards");
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     myFrame.setContentPane(table);
    myFrame.setPreferredSize(new Dimension(1400,1100));

    //Display the window.
    myFrame.pack();
    myFrame.setVisible(true);
                
        Scanner input = new Scanner(System.in);
        int i = 0;
       
        
        System.out.println("Enter 1 for CardTestDriver");
        System.out.println("Enter 2 for DeckTestDriver");
        System.out.println("Enter 3 for a round of Irish Poker");
        System.out.println("Enter 4 to quit ");
        
 
  
      i = enterNumber();
  
  
    
      while (i<4)
      {
        switch(i) {
          case 1:
              System.out.println("Card testdriver\n");
              Card c = new Card(0,8);
       
              System.out.println(c);
            
              System.out.println("Enter 1 for CardTestDriver");
              System.out.println("Enter 2 for DeckTestDriver");
              System.out.println("Enter 3 for a round of Irish Poker");
              System.out.println("Enter 4 or more to quit ");
              i = enterNumber();
              break;
        
          case 2:
            System.out.println("Deck Testdriver\n");
            DeckOfCards d =new DeckOfCards();
        
            d.PrintDeck();
        
            System.out.println("\nShuffling Deck\n");
        
            d.shuffle();
        
            d.PrintDeck();
        
            System.out.println("\n Dealing random\n");
            System.out.println(d.dealCard());
            
            System.out.println("Enter 1 for CardTestDriver");
            System.out.println("Enter 2 for DeckTestDriver");
            System.out.println("Enter 3 for a round of Irish Poker");
            System.out.println("Enter 4 or more to quit ");
            i = enterNumber();
              break;
          case 3:
            int points = 0;
            DeckOfCards deck = new DeckOfCards();
            deck.shuffle();
            Card[] hand= new Card[4];  
            System.out.print("Dealing Hand of 4 cards\n");
            System.out.println("Card 1");
            System.out.println("Card 2");
            System.out.println("Card 3");
            System.out.println("Card 4");
            
            for(int j = 0; j<4; ++j)//dealing hand
            {
                hand[j]=deck.dealCard();
            }
            
            
            
            System.out.print("Guess Card color, RED or BLACK: ");
            String colorGuess = input.next();
            
            if ((hand[0].getSuit()==1 ||hand[0].getSuit()==3)&& (colorGuess.equals("RED") || colorGuess.equals("red")))//check to see if guess is correct
            {
                ++points;
            }
            if ((hand[0].getSuit()==2 ||hand[0].getSuit()==4)&& (colorGuess.equals("BLACK") || colorGuess.equals("black")))//Same as above
            {
                ++points;
            }
            
            System.out.println(hand[0]);
            System.out.println("Card 2");
            System.out.println("Card 3");
            System.out.println("Card 4");
          
            System.out.println("\nYour Score: "+ points);
            
            System.out.print("Guess whether card 2 is HIGHER or LOWER than card 1: ");
            String highOrLowerGuess = input.next();
            
            if(highOrLowerGuess.equals("HIGHER")&& hand[0].getRank() < hand[1].getRank())//check to see if guess is correct
            {
                ++points;
            }
             if(highOrLowerGuess.equals("LOWER")&& hand[0].getRank() > hand[1].getRank())//check to see if guess is correct
            {
                ++points;
            }
            
            System.out.println(hand[0]);
            System.out.println(hand[1]);
            System.out.println("Card 3");
            System.out.println("Card 4");
            
            System.out.println("\nYou Score: " +points);
            
            System.out.print("Guess whether card 3 is BETWEEN or OUTSIDE of cards 1 and 2: ");
            String betweenOrOutSide = input.next();
            
            if(hand[0].getRank()<hand[1].getRank())//check to see if guess is correct
            {
                if (betweenOrOutSide.equals("OUTSIDE") && (hand[2].getRank()<hand[0].getRank() || hand[2].getRank()>hand[1].getRank()))
                {
                    ++points;
                }
        
            }
              
            if(hand[0].getRank()>hand[1].getRank())//check to see if guess is correct
            {
                if (betweenOrOutSide.equals("OUTSIDE") && (hand[2].getRank()>hand[0].getRank() || hand[2].getRank()<hand[1].getRank()))
                {
                    ++points;
                }
        
            }
            
            if(hand[0].getRank()<hand[1].getRank())//check to see if guess is correct
            {
                if (betweenOrOutSide.equals("BETWEEN") && (hand[2].getRank()>hand[0].getRank() && hand[2].getRank()<hand[1].getRank()))
                {
                    ++points;
                }
        
            }
              
            if(hand[0].getRank()>hand[1].getRank())//check to see if guess is correct
            {
                if (betweenOrOutSide.equals("OUTSIDE") && (hand[2].getRank()<hand[0].getRank() && hand[2].getRank()>hand[1].getRank()))
                {
                    ++points;
                }
        
            }
            
            System.out.println(hand[0]);
            System.out.println(hand[1]);
            System.out.println(hand[2]);
            System.out.println("Card 4");
            
            System.out.println("\nYou Score: " +points);
            
            System.out.print("Guess Card 4 suit, DIAMONDS, HEARTS, SPADES, CLUBS: ");
            
            String SUIT = input.next();
            
            if (SUIT.equals("DIAMONDS") && hand[3].getSuit()==3)
                ++points;
            else if (SUIT.equals("HEARTS") && hand[3].getSuit()==1)
                ++points;
            else if (SUIT.equals("SPADES") && hand[3].getSuit()==4)
                ++points;
            else if (SUIT.equals("CLUBS") && hand[3].getSuit()==2)
                ++points;

             System.out.println(hand[0]);
            System.out.println(hand[1]);
            System.out.println(hand[2]);
            System.out.println(hand[3]);
            
            System.out.println("\nYou Final Score is: " +points +"\n\n");
            
            
            System.out.println("Enter 1 for CardTestDriver");
            System.out.println("Enter 2 for DeckTestDriver");
            System.out.println("Enter 3 for a round of Irish Poker");
            System.out.println("Enter 4 or more to quit ");
            i = enterNumber();
              break;
          
          case 4: 
              break;
          
        }
      }
        
   
    }
    /**
     * @return returns an integer to be used by main
    */
    static public int enterNumber() // gets input from keyboard and verifies that it is an integer before returning it
    {
        Scanner into = new Scanner(System.in);
        int j = 0;
        boolean correctinput = false;
        
        do 
        {
            try 
            {
                correctinput = true;
                System.out.print("Enter Number: ");
                j = into.nextInt();
            }
            catch (Exception e)
            {
                correctinput = false;
                System.out.print("That isn't an Integer, please try again\n");
                String clear = into.nextLine();
            } 
        } while(!correctinput);
        
        return j;
    }
    
}
