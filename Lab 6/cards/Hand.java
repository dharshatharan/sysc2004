import java.util.ArrayList;

/**
 * Hand models a hand of cards held by a player.
 * 
 * @author Lynn Marshall 
 * @version 1.2 Feb 19, 2019
 *
 */
public class Hand
{
    /** 
     * The cards are stored in an array-list implementation of the
     * List collection.
     */
    private ArrayList<Card> cards;

    /**
     * Constructs a new, empty hand.
     */
    public Hand()
    {   
        cards = new ArrayList<Card>();
    }
    
    /**
     * Adds the specified card to this hand.
     */
    public void addCard(Card aCard)
    {
        cards.add(aCard);
    }
     
   /**
     * Removes a card from this hand. Cards are removed in the order in
     * which they were added to the hand.
     */
    public Card playCard()
    {
        return cards.remove(0);
    }

    /**
     * Returns the number of cards that are currently in this hand.
     */    
    public int size()
    {
        return cards.size();
    }

    /**
     * Determines if this hand is empty.
     */    
    public boolean isEmpty()
    {
        if(cards.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns a String that lists the ranks (but not the suits) of all the 
     * cards in this hand, starting with the first card and finishing with
     * the last card. For example, if the first card is the two of hearts, 
     * the second card is the five of diamonds, and the last card is the
     * queen of clubs, the String returned by this method will be: "2 5 12".
     */
    public String toString()
    {
        if(cards.size() == 0){
            return "";
        }
        String ranks = String.valueOf(cards.get(0).rank());
        for(int i=1; i<cards.size(); i++){
            ranks += " " + String.valueOf(cards.get(i).rank());
        }
        return ranks;
    }
}
