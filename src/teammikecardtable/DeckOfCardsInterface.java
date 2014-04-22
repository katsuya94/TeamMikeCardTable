package teammikecardtable;

/**
 *
 * @author Luke Olney
 */
public interface DeckOfCardsInterface {
    public void shuffle();
    public int cardsLeft();
    public Card dealCard();
    public String toString();
}


