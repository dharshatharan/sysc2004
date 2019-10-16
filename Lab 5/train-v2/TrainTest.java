import java.util.ArrayList;

/**
 * The test class TrainTest.
 *
 * @author  Lynn Marshall
 * @version May 2015
 */
public class TrainTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TrainTest
     */
    public TrainTest()
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
 
    public void testCreateEmptyTrain()
    {
        Train aTrain = new Train();
        
        /* Verify that a new train has no cars. */
        assertEquals(0, aTrain.cars().size());
    }
    
    public void testAddCar()
    {
        Train aTrain = new Train();
        
        Car car1 = new Car(1250, true);
        aTrain.addCar(car1);
        
        Car car2 = new Car(1300, false);
        aTrain.addCar(car2);
        
        Car car3 = new Car(1740, false);
        aTrain.addCar(car3);
        
        ArrayList<Car> cars = aTrain.cars();
        assertEquals(3, cars.size());
        
        
        /* Verify that each car added to the train was placed at
         * the end of the list.
         */
        Car aCar;
        aCar = cars.get(0);
        
        /* Important - assertSame() does not compare the Car objects 
         * referred to by car1 and aCar to detemine if they are equal
         * (have the same state). It verifies that car1 an aCar refer to
         * the same object; i.e., that the Car (reference) retrieved by get(0)
         * is the first first that was added to the ArrayList.
         */
        assertSame(car1, aCar);
        
        aCar = cars.get(1);
        assertSame(car2, aCar);
        
        aCar = cars.get(2);
        assertSame(car3, aCar);      
    }
        
    public void testIssueTicket()
    {
        Train aTrain = new Train();
        
        Car car1 = new Car(1250, true);
        aTrain.addCar(car1);
        
        Car car2 = new Car(1300, false);
        aTrain.addCar(car2);
        
        Car car3 = new Car(1740, false);
        aTrain.addCar(car3);
        
        boolean result;
        /* Book all the seats in the business-class car. */
        for (int i = 0; i <Car.BUSINESS_SEATS; i++) {
            result = aTrain.issueTicket(true);
            assertTrue(result);
        }
        
        /* Attempt to book one more business-class seat, even
         * though they are all booked.
         */
        result = aTrain.issueTicket(true);
        assertFalse(result);        
 
        ArrayList<Car> cars = aTrain.cars();
        
        for (int i = 0; i < Car.BUSINESS_SEATS; i++) {
            assertTrue(cars.get(0).seats()[i].isBooked());
        }
        
        for (int i = 0; i < Car.ECONOMY_SEATS; i++) {
            assertFalse(cars.get(1).seats()[i].isBooked());
        }
        
        for (int i = 0; i < Car.ECONOMY_SEATS; i++) {
            assertFalse(cars.get(2).seats()[i].isBooked());
        }
        
        /* Book all the seats in the first economy-class car. */
        for (int i = 0; i <Car.ECONOMY_SEATS; i++) {
            result = aTrain.issueTicket(false);
            assertTrue(result);
        }
        
        cars = aTrain.cars();
        
        for (int i = 0; i < Car.BUSINESS_SEATS; i++) {
            assertTrue(cars.get(0).seats()[i].isBooked());
        }
        
        for (int i = 0; i < Car.ECONOMY_SEATS; i++) {
            assertTrue(cars.get(1).seats()[i].isBooked());
        }
        
        for (int i = 0; i < Car.ECONOMY_SEATS; i++) {
            assertFalse(cars.get(2).seats()[i].isBooked());
        }  
        
        /* Book all the seats in the second economy-class car. */
        for (int i = 0; i <Car.ECONOMY_SEATS; i++) {
            result = aTrain.issueTicket(false);
            assertTrue(result);
        }
        
        /* check that all seats are now booked */
        for (int i = 0; i < Car.BUSINESS_SEATS; i++) {
            assertTrue(cars.get(0).seats()[i].isBooked());
        }
        
        for (int i = 0; i < Car.ECONOMY_SEATS; i++) {
            assertTrue(cars.get(1).seats()[i].isBooked());
        }
        
        for (int i = 0; i < Car.ECONOMY_SEATS; i++) {
            assertTrue(cars.get(2).seats()[i].isBooked());
        }  
        
        /* Try to book another business class seat (fails)*/
        result = aTrain.issueTicket(true);
        assertFalse(result);
        /* Try to book another economy class seat (fails)*/
        result = aTrain.issueTicket(false);
        assertFalse(result);
    }
    
    public void testCancelTicket()
    {
        Train aTrain = new Train();
        
        Car car1 = new Car(1250, true);
        aTrain.addCar(car1);
        
        Car car2 = new Car(1300, false);
        aTrain.addCar(car2);
        
        Car car3 = new Car(1740, false);
        aTrain.addCar(car3);
        
        boolean result;
        /* Book all the seats in the business-class car. */
        for (int i = 0; i <Car.BUSINESS_SEATS; i++) {
            result = aTrain.issueTicket(true);
            assertTrue(result);
        }
        
        /* Book all the seats in the first economy-class car. */
        for (int i = 0; i <Car.ECONOMY_SEATS; i++) {
            result = aTrain.issueTicket(false);
            assertTrue(result);
        }
        
        ArrayList<Car> cars = aTrain.cars();
        
        result = aTrain.cancelTicket(1300, 4);
        assertTrue(result);
        assertFalse(cars.get(1).seats()[3].isBooked());        
        
        /* Cancel ticket in a non-existent car. */
        result = aTrain.cancelTicket(1500, 7);
        assertFalse(result);
        
        /* Cancel ticket in a non-existent seat. */
        result = aTrain.cancelTicket(1300, 54);
        assertFalse(result);
        
        /* Cancel ticket for a seat that hasn't been booked. */
        result = aTrain.cancelTicket(1740, 21);
        assertFalse(result);
        assertFalse(cars.get(2).seats()[20].isBooked());        
        
        /* Attempt to cancel the same ticket twice. */
        result = aTrain.cancelTicket(1250, 11);
        assertTrue(result);
        assertFalse(cars.get(0).seats()[10].isBooked());
        
        result = aTrain.cancelTicket(1250, 11);
        assertFalse(result);   
        assertFalse(cars.get(0).seats()[10].isBooked());         
    }
}
