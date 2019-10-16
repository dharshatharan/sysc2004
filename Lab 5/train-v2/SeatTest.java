/**
 * The test class SeatTest.
 *
 * @author  D.L. Bailey, SCE, Carleton University
 * @version 1.00 January 28, 2007
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

	public void testCreateSeat()
	{
		assertEquals(1, seat1.number());
		assertEquals(125.0, seat1.price(), 1.25);		
		assertEquals(false, seat1.isBooked());
		assertEquals(2, seat2.number());
		assertEquals(50.0, seat2.price(), 0.5);
		assertEquals(false, seat2.isBooked());
	}

	public void testBooking()
	{
		assertEquals(true, seat1.book());
		assertEquals(true, seat1.isBooked());
		assertEquals(false, seat1.book());
		assertEquals(true, seat1.isBooked());
	}

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
