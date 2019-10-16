import java.util.ArrayList;
import java.util.Random;

/**
 * Deck models a deck of 52 Anglo-American playing cards.
 * 
 * @author Lynn Marshall 
 * @author Dharshatharan J. A.
 * @version 1.2 October 16, 2019
 *
 */
public class Deck
{
    /** 
     * The cards are stored in a linked-list implementation of the
     * List collection.
     */
    private ArrayList<Card> cards;
    
    /** Lowest ranking card (the ace). */
    private static final int ACE = 1;
    
    /** Highest ranking card (the king). */
    private static final int KING = 13;
    
    /** 
     * Total number cards in the deck (4 suits, each with 13 cards of 
     * different ranks).
     */ 
    private static final int TOTAL_CARDS = 52;
    
    /** 
     * Some constants that define the Strings for the various suits.
     */ 
    private static final String HEARTS = "hearts";
    private static final String DIAMONDS = "diamonds";
    private static final String CLUBS = "clubs";
    private static final String SPADES = "spades";

    /**
     * Constructs a new, unshuffled deck containing 52 playing cards.
     */
    public Deck()
    {
        cards = new ArrayList<Card>();
        buildSuit(HEARTS);
        buildSuit(DIAMONDS);
        buildSuit(CLUBS);
        buildSuit(SPADES);
    }
    
    /**
     * Creates the 13 cards for the specified suit, and adds them
     * to this deck.
     */
    private void buildSuit(String suit)
    {
        for(int i=1; i<= 13; i++){
            cards.add(new Card(suit, i));
        }
    }
 
    /**
     * Shuffles this deck of cards.
     */
    public void shuffle()
    {   
        int a, b;
        Card temp;
        Random rand = new Random();
        for(int i=0; i <= 10000; i++){
            a = rand.nextInt(cards.size());
            b = rand.nextInt(cards.size());
            temp = cards.get(a);
            cards.set(a, cards.get(b));
            cards.set(b, temp);
        }
    }
 
    /**
     * Removes a card from this deck.
     * 
     * @param dealCard Card that has been dealed
     */
    public Card dealCard()
    {
        Card dealCard = cards.get(0);
        cards.remove(0);
        return dealCard;
    }
 
    /**
     * Determines if this deck is empty.
     * 
     * @return true if the deck is empty
     */
    public boolean isEmpty()
    {
        if(cards.size() == 0){
            return true;
        }
        return false;
    }
  
    /**
     * Returns the number of cards that are currently in the deck.
     */
    public int size()
    {
        return cards.size();
    }
}
