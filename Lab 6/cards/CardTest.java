/**
 * The test class CardTest.
 *
 * @author  Lynn Marshall
 * @version 1.1 October 11, 2012
 */
public class CardTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CardTest
     */
    public CardTest()
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
  
    private static final int ACE = 1;
    private static final int KING = 13;
    
    /* Verifies that we can create 52 different cards (13 in each suit). */
    public void testCreateAllCards()
    {
        String suit;
        suit = "hearts";
        for (int i = ACE; i <= KING; i++) {
            Card card = new Card(suit, i);
            assertEquals(suit, card.suit());
            assertEquals(i, card.rank());
        }
        
        suit = "diamonds";
        for (int i = ACE; i <= KING; i++) {
            Card card = new Card(suit, i);
            assertEquals(suit, card.suit());
            assertEquals(i, card.rank());
        }
        
        suit = "clubs";
        for (int i = ACE; i <= KING; i++) {
            Card card = new Card(suit, i);
            assertEquals(suit, card.suit());
            assertEquals(i, card.rank());
        }
        
        suit = "spades";
        for (int i = ACE; i <= KING; i++) {
            Card card = new Card(suit, i);
            assertEquals(suit, card.suit());
            assertEquals(i, card.rank());
        }        
    }
    
    public void testSameRank()
    {
        Card c1 = new Card("hearts", 3);
        Card c2 = new Card("clubs", 3);
        assertTrue(c1.hasSameRank(c2));
    }
    
    public void testIsEqualTo()
    {
        Card c1 = new Card("hearts", 3);
        Card c2 = new Card("clubs", 3);
        Card c3 = new Card("hearts", 3);
        assertTrue(c1.isEqualTo(c3));
        assertFalse(c1.isEqualTo(c2));
    }
}
