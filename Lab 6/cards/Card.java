 /**
 * A Card is a playing card from an Anglo-American deck of cards.
 * 
 * @author Lynn Marshall
 * @author Dharshatharan J. A.
 * @version 1.2 October 16, 2019
 */
public class Card
{
    /** The card's suit: "hearts", "diamonds", "clubs", "spades". */
    private String suit;
    
    /** 
     * The card's rank, between 1 and 13 (1 represents the ace, 11 represents
     * the jack, 12 represents the queen, and 13 represents the king.)
     */
    private int rank;

    /**
     * Constructs a new card with the specified suit and rank.
     */
    public Card(String suit, int rank)
    {
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * Returns this card's suit.
     * 
     * @return suit the suit of the card
     */
    public String suit()
    {
        return this.suit;
    }
    
    /**
     * Returns this card's rank.
     * 
     * @return rank the rank of the card
     */
    public int rank()
    {
        return this.rank;
    }
    
    /**
     * Determines if this card has the same rank as the specified card.
     * 
     * @param aCard Card to check same rank
     * @return true if rank is same
     */
    public boolean hasSameRank(Card aCard)
    {
        if(this.rank == aCard.rank){
            return true;
        }
        return false;
    }
    
    /**
     * Determines if this card is equal to the specified card.
     * 
     * @param aCard Card to check same rank
     * @return true is card it the same
     */
    public boolean isEqualTo(Card aCard)
    {
        if(this.suit == aCard.suit){
            if(hasSameRank(aCard)){
                return true;
            }
        }
        return false;
    }
}
