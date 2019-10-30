/**
 * The test class CarTest.
 *
 * @author  Lynn Marshall, SCE
 * @version 1.2 May 1st, 2015
 */
public class CarTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CarTest
     */
    public CarTest()
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
    
    public void testCreateBusinessCar()
    {
        Car aCar = new Car(1385, true);
        Seat[] seats = aCar.seats();
        
        /* Verify that the car has the right number of seats. */
        assertEquals(Car.BUSINESS_SEATS, seats.length);
        
        /* Verify that each seat has the correct number and price. */
        for (int i = 0; i < seats.length; i++) {
            assertEquals(i+1, seats[i].number());
            assertEquals(Car.BUSINESS_SEAT_COST, seats[i].price());
        }
    }
    
    public void testCreateEconomyCar()
    {
        Car aCar = new Car(1400, false);
        Seat[] seats = aCar.seats();
        
        /* Verify that the car has the right number of seats. */        
        assertEquals(Car.ECONOMY_SEATS, seats.length);
        
        /* Verify that each seat has the correct number and price. */       
        for (int i = 0; i < seats.length; i++) {
            assertEquals(i+1, seats[i].number());
            assertEquals(Car.ECONOMY_SEAT_COST, seats[i].price());
        }
    }    
    
    public void testID()
    {
         Car aCar;
         aCar= new Car(1385, true);
         assertEquals(1385, aCar.id());
         aCar = new Car(1400, false);
         assertEquals(1400, aCar.id());
    }
    
    public void testIsBusinessClass()
    {
         Car aCar;
         aCar = new Car(1385, true);
         assertTrue(aCar.isBusinessClass());
         aCar = new Car(1400, false);
         assertFalse(aCar.isBusinessClass()); 
    }
    
    public void testBookNextSeat()
    {
        Car businessCar, economicCar;
        businessCar = new Car(1234, true);
        economicCar = new Car(43210, false);
        
        Seat[] businessSeats = businessCar.seats();
        Seat[] economicSeats = economicCar.seats();
        
        /* Verify that no seats are booked. */
        for (int i = 0; i < businessSeats.length; i++) {
            assertFalse(businessSeats[i].isBooked());
        }     
        
        for (int i = 0; i < economicSeats.length; i++) {
            assertFalse(economicSeats[i].isBooked());
        }      
        
        /* Verify that the seats are booked consecutively,
         * starting with Seat #1.
         */
        for (int i = 0; i < businessSeats.length; i++) {
            businessSeats = businessCar.seats();
            assertFalse(businessSeats[i].isBooked()); // not booked
            assertTrue(businessCar.bookNextSeat()); // book it
            assertTrue(businessSeats[i].isBooked()); // now booked
            if (i!=businessSeats.length-1) {
                assertFalse(businessSeats[i+1].isBooked()); // but next isn't
            }
        }
        
        for (int i = 0; i < economicSeats.length; i++) {
            economicSeats = economicCar.seats();
            assertFalse(economicSeats[i].isBooked()); // not booked
            assertTrue(economicCar.bookNextSeat()); // book it
            assertTrue(economicSeats[i].isBooked()); // now booked
            if (i!=economicSeats.length-1) {
                assertFalse(economicSeats[i+1].isBooked()); // but next isn't
            }
        }
        
        /* Try to book a seat now that all the seats have been booked. */
        assertFalse(businessCar.bookNextSeat());
        assertFalse(economicCar.bookNextSeat());
    }
    
    public void testCancelSeat()
    {
        Car businessCar, economicCar;
        businessCar = new Car(1234, true);
        economicCar = new Car(4321, false);
        
        Seat[] businessSeats = businessCar.seats();
        Seat[] economicSeats = economicCar.seats();
        
        /* Cancel seat 0. cancelSeat() should return false, as there
         * is no seat 0.
         */
        assertFalse(businessCar.cancelSeat(0));
        assertFalse(economicCar.cancelSeat(0));
        
        /* Try cancelling a seat whose number is one higher than 
         * the highest valid seat number (seats.length - 1). 
         * cancelSeat() should return false.
         */
        assertFalse(businessCar.cancelSeat(businessSeats.length));
        assertFalse(economicCar.cancelSeat(economicSeats.length));
        
        /* Try cancelling all the seats in the car, even though 
         * they haven't been booked. cancelSeat() should 
         * return false.
         */
        for (int i = 0; i < businessSeats.length; i++) {
            assertFalse(businessCar.cancelSeat(i+1));
        }
        
        for (int i = 0; i < economicSeats.length; i++) {
            assertFalse(economicCar.cancelSeat(i+1));
        }        
        
        /* Book all the seats */
        for (int i = 0; i < businessSeats.length; i++) {
            businessCar.bookNextSeat();
        }  
        
        for (int i = 0; i < economicSeats.length; i++) {
            economicCar.bookNextSeat();
        }  
        
        /* Try cancelling all the seats in the car.
         */
        for (int i = 0; i < businessSeats.length; i++) {
            assertTrue(businessCar.cancelSeat(i+1));
        } 
        
        for (int i = 0; i < economicSeats.length; i++) {
            assertTrue(economicCar.cancelSeat(i+1));
        }
        
        
        assertFalse(businessCar.cancelSeat(50));
        assertFalse(economicCar.cancelSeat(50));
        
        /* In case seat numbers are off, try some more tests.
         */
        Car bCar;
        bCar = new Car (4321,false);
        // book 2 seats
        assertTrue(bCar.bookNextSeat());
        assertTrue(bCar.bookNextSeat());
        // try to cancel the 3rd (not booked)
        assertFalse(bCar.cancelSeat(3));
        // cancel the 1st and 2nd (were both booked)
        assertTrue(bCar.cancelSeat(1));
        assertTrue(bCar.cancelSeat(2));
       
    }      
}
