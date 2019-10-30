/**
 * The test class SeatTest.
 *
 * @author  Lynn Marshall
 * @version October 21, 2012
 */
public class SeatTest extends junit.framework.TestCase
{
	private Seat seat1;
	private Seat seat2;

    /**
     * Default constructor for test class SeatTest
     */
    public SeatTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
		seat1 = new Seat(1, 125.0);
		seat2 = new Seat(2, 50.0);
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    /**
     * Test creating a seat.
     * 
     * Check that seat 1 has the correct price (within 0.50)
     * and isn't booked.
     * 
     * Check that seat 2 has the correct price (within 0.50)
     * and isn't booked.
     */
	public void testCreateSeat()
	{
		assertEquals(1, seat1.number());
		assertEquals(125.0, seat1.price(), 0.50);		
		assertEquals(false, seat1.isBooked());
		assertEquals(2, seat2.number());
		assertEquals(50.0, seat2.price(), 0.50);
		assertEquals(false, seat2.isBooked());
	}

	/**
	 * Test booking a seat.
	 * 
	 * Book a seat and check that it is indeed booked.  Try to book it
	 * again and check that book() returns false, and that the seat
	 * is still booked.
	 */
	public void testBooking()
	{
		assertEquals(true, seat1.book());
		assertEquals(true, seat1.isBooked());
		assertEquals(false, seat1.book());
		assertEquals(true, seat1.isBooked());
		assertNotSame(seat1, seat2);
		assertEquals(true, seat2.book());
		assertEquals(true, seat2.isBooked());
		assertEquals(false, seat2.book());
		assertEquals(true, seat2.isBooked());
	}
	
	/**
	 * Test cancelling a seat booking.
	 * 
	 * Try to cancel a booking that hasn't been made.  Book a set
	 * and cancel the booking, and check that it isn't booked.  Try
	 * cancelling the booking again and check that cancelBooking()
	 * returns false and that the seat is still not booked.
	 */
	public void testCancelBooking()
	{
		assertEquals(false, seat1.cancelBooking());
		assertEquals(true, seat1.book());
		assertEquals(true, seat1.cancelBooking());
		assertEquals(false, seat1.isBooked());
		assertEquals(false, seat1.cancelBooking());
		assertEquals(false, seat1.isBooked());
	}
}
