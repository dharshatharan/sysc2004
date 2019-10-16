/**
 * The test class DeckTest.
 *
 * @author  Lynn Marshall
 * @version 1.1 October 11, 2012
 */
public class DeckTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class DeckTest
     */
    public DeckTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    /** Lowest ranking card (the ace). */
    private static final int ACE = 1;
    
    /** Highest ranking card (the king). */
    private static final int KING = 13;  

    /** 
     * Total number cards in the deck (4 suits, each with 13 cards of 
     * different ranks).
     */ 
    private static final int TOTAL_CARDS = 52;
    
    /* Verifies that a new deck has 52 cards. */
    public void testCreateDeck()
    {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty());
        assertEquals(deck.size(), TOTAL_CARDS);
    }
  
    /* Verfies that each time a card is dealt, the size of the deck
     * decreases by 1.
     */
    public void testDeal()
    {
        Deck deck = new Deck();
        Card c1;
        for (int i = 0; i < TOTAL_CARDS; i++) {
            c1 = deck.dealCard();
        }
        assertTrue(deck.isEmpty());
        assertEquals(deck.size(), 0);
    }
    
    /* Verifies that a new deck has 13 DIFFERENT cards for each of
     * the four suits.
     */
    public void testHas52cards()
    {
        Deck deck = new Deck();

        int[] cards = new int[TOTAL_CARDS];
        for (int i = 0; i < TOTAL_CARDS; i++) {
            cards[i] = 0;
        }
        
        while (!deck.isEmpty()) {
            Card c = deck.dealCard();
            String suit = c.suit();
            if (c.suit().equals("hearts"))
                cards[c.rank() - 1]++;
            else if (c.suit().equals("diamonds"))
                cards[13 + c.rank() - 1]++;
           else if (c.suit().equals("clubs"))
                cards[26 + c.rank() - 1]++; 
           else if (c.suit().equals("spades"))
                cards[39 + c.rank() - 1]++; 
        }
        
        for (int i = 0; i < TOTAL_CARDS; i++) {
            assertEquals(cards[i], 1);
        }
    }
    
    /* Verifies the shuffle operation.
     * This would be a much more rigorous test if Deck provided a way for 
     * us to look at the i'th card in a deck, without removing it.
     * We could then verify that shuffling rearranges the order of the cards.
     * As it is, we can only check that a shuffled deck has 52 different cards.
     */
    public void testShuffle()
    {
        Deck deck = new Deck();
        deck.shuffle();
        assertEquals(deck.size(), TOTAL_CARDS);
        
        int[] cards = new int[TOTAL_CARDS];
        for (int i = 0; i < TOTAL_CARDS; i++) {
            cards[i] = 0;
        }       
        
        while (!deck.isEmpty()) {
            Card c = deck.dealCard();
            String suit = c.suit();
            if (c.suit().equals("hearts"))
                cards[c.rank() - 1]++;
            else if (c.suit().equals("diamonds"))
                cards[13 + c.rank() - 1]++;
           else if (c.suit().equals("clubs"))
                cards[26 + c.rank() - 1]++; 
           else if (c.suit().equals("spades"))
                cards[39 + c.rank() - 1]++; 
        }
        
        for (int i = 0; i < TOTAL_CARDS; i++) {
            assertEquals(cards[i], 1);
        }
        
        int matches = 0;
        Deck original = new Deck();
        Deck shuffled = new Deck();
        shuffled.shuffle();   
        while (!original.isEmpty()) {
            Card c1 = original.dealCard();
            Card c2 = shuffled.dealCard();
            if (c1.isEqualTo(c2)) {
                matches++;
            }
        }
        /* matches will contain 52 is the cards in the shuffled deck
         & were in exactly the same order as the cards in the unshuffled
         * deck. This likely means that shuffled doesn't shuffle the 
         * deck!
         */
         assertTrue(matches != TOTAL_CARDS);
    } 
}
