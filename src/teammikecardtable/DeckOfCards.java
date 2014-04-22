package teammikecardtable;
import java.util.*;

/**
 * Contains methods for shuffling and dealing a deck of cards
 * @author Luke Olney
 */
public class DeckOfCards implements DeckOfCardsInterface { 
    
    private static final int numcards = 52;
    private Card[] cards;
    private int index;
    
    /**
    * Creates a standard deck of cards (contains 52 cards)
    * 
    */
    public DeckOfCards(){
        cards = new Card[numcards];
        index = 0;
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<13; j++)
            {
                cards[i*13 + j] = new Card(i, j);
            }
        }
    }
    
    /**
    * Copy constructor
    * 
    */
    public DeckOfCards(DeckOfCards d){
        cards = d.getCards().clone();
        index = d.getIndex();
    }
    
    /**
    * Shuffles the card deck, returning the index of the deck to the first card
    * 
    */
    @Override
    public void shuffle(){
        index = 0;
        ArrayList<Card> temp = new ArrayList<>();
        Random rand = new Random();
        
        temp.addAll(Arrays.asList(cards));
        
        // For each index i of cards, selects a random index from the remaining
        // cards to be shuffled and assigns it to index i in cards
        int j, uBound;
        for(int i=0; i<cards.length; i++){
            uBound = temp.size() - 1;
            if(uBound != 0)
                j = rand.nextInt(uBound);
            else j = 0;
            cards[i] = temp.remove(j);
        }
   
    }
    
    /**
    * 
    * @return The number of cards left in the deck
    */
    @Override
    public int cardsLeft(){
        return numcards - index;
    }
    
    /**
    * 
    * @return The next card in the deck
    */
    @Override
    public Card dealCard(){
        if(index == numcards) shuffle();
        Card myCard = cards[index];
        index++;
        return myCard;
    }
    
    /**
    * 
    * @return A reference to the deck's array of cards
    */
    public Card[] getCards()
    {
        return cards;
    }
    
    /**
    * 
    * @return The deck's index (position in array of cards)
    */
    public int getIndex()
    {
        return index;
    }
    
    /**
    * 
    * @return A string containing the toString representation of all cards in the deck,
    * separated by the newline character
    */
    @Override
    public String toString(){
        String output = "";
        for(int i=0; i<cards.length; i++){
            output += cards[i].toString() + "\n";
        }
        return output;
    }
}