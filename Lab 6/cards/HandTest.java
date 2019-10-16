/**
 * The test class HandTest.
 *
 * @author  Lynn Marshall
 * @version 1.1 October 11, 2012
 */
public class HandTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class HandTest
     */
    public HandTest()
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
  
    /* Verifies that a new hand is empty (has size 0). */
    public void testCreateHand()
    {
        Hand hand = new Hand();
        assertTrue(hand.isEmpty());
    }
        
    /* Verifies that each time we add a card to the hand, its
     * size increases by 1.
     */
    public void testAddCardsToHand()
    {
        Hand hand = new Hand();
        assertEquals(hand.size(), 0);
        hand.addCard(new Card("hearts", 3));
        assertEquals(hand.size(), 1);
        assertFalse(hand.isEmpty());
        hand.addCard(new Card("spaces", 10));
        assertEquals(hand.size(), 2);       
    }
 
    /* Verifies that each time we remove a card from the hand, its
     * size decreases by 1.
     */
    public void testAddAndRemoveCards()
    {
        Hand hand = new Hand();
        hand.addCard(new Card("hearts", 3));
        hand.addCard(new Card("clubs", 3));
        hand.addCard(new Card("diamonds", 8));
        
        Card c;
        c = hand.playCard();
        assertEquals(hand.size(), 2);
        c = hand.playCard();
        assertEquals(hand.size(), 1);
        c = hand.playCard();
        assertEquals(hand.size(), 0);
        assertTrue(hand.isEmpty());
    }
    
    /* Verifies that cards are removed from the hand in the same order that
     * they were added.
     */
    public void testOrder()
    {
        Hand hand = new Hand();
        Card c1 = new Card("hearts", 3);
        Card c2 = new Card("clubs", 3);
        Card c3 = new Card("diamonds", 8);
        Card c4 = new Card("spades", 1);
        hand.addCard(c1);
        hand.addCard(c2);
        hand.addCard(c3);
        hand.addCard(c4);
        
        Card c;
        c = hand.playCard();
        assertTrue(c.isEqualTo(c1));
         c = hand.playCard();
        assertTrue(c.isEqualTo(c2));
        c = hand.playCard();
        assertTrue(c.isEqualTo(c3));
        c = hand.playCard();
        assertTrue(c.isEqualTo(c4));
    }
   
    /* Verifies that toString() returns a String containing the ranks
     * of the cards in the hand, starting with the first card that was 
     * added to the hand.
     */
    public void testToString()
    {
        Hand hand = new Hand();
        String s;
        
        // Case 1: hand with no cards.
        s = hand.toString();
        assertEquals(s, "");   
        
        //Case 2: hand with 1 card.
        Card c1 = new Card("hearts", 3);
        hand.addCard(c1);
        s = hand.toString();
        assertEquals(s, "3");
        
        // Case 3: hand with multiple cards.        
        Card c2 = new Card("hearts", 4);
        Card c3 = new Card("spades", 4);    
        Card c4 = new Card("hearts", 5);
        Card c5 = new Card("clubs", 3);
        Card c6 = new Card("diamonds", 8);
        Card c7 = new Card("spades", 1);
        hand.addCard(c2);
        hand.addCard(c3);
        hand.addCard(c4);
        hand.addCard(c5);
        hand.addCard(c6);
        hand.addCard(c7);
        
        s = hand.toString();
        assertEquals(s, "3 4 4 5 3 8 1");
    }
}
