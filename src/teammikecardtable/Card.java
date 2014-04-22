package teammikecardtable;

/**
 * Represents a playing card with rank and suite
 * @author Luke Olney
 */
public class Card {
    private final int rank;
    private final int suit;
    
    /**
    * Object constructor
    * @param r Rank
    * @param s Suite
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
        return "Suit: " + suit + " Rank: " + rank;
    }
}
