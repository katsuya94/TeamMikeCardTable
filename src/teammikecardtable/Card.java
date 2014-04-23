package teammikecardtable;

/**
 * Represents a playing card with rank and suit
 * @author Luke Olney
 */
public class Card {
    private final int rank;
    private final int suit;
    
    /**
    * Object constructor
    * @param r Rank
    * @param s Suit
    */
    public Card(int r, int s){
        rank = r;
        suit = s;
    }
    
    /**
    * 
    * @return Rank of the card
    */
    public int getRank(){
        return rank;
    }
    
    /**
    * 
    * @return Suite of the card
    */
    public int getSuit(){
        return suit;
    }
    
    /**
    * @param in Card to which to be compared
    * @return True if cards have the same rank and suit
    */
    public boolean compare(Card in){
        if((in.getSuit() == suit) && (in.getRank() == rank)) return true;
        return false;
    }
    
    /**
    * 
    * @return A string of the format "Suit: s Rank: r", where s and r represent rank and suite, respectively, of the card
    */
    @Override
    public String toString(){
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
