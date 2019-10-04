

/**
 * The test class HeaterTest.
 *
 * @author  L.S. Marshall
 * @version 1.01 September 9th, 2012
 */
public class HeaterTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class HeaterTest
     */
    public HeaterTest()
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
    
	public void testConstructor()
	{
	    Heater heater1 = new Heater();
	    assertEquals(15, heater1.temperature());
	}
	
	public void testWarmer()
	{
	    Heater heater1 = new Heater();
	    heater1.warmer();
	    assertEquals(20, heater1.temperature());
	}
	
	public void testCooler()
	{
	    Heater heater1 = new Heater();
	    heater1.cooler();
	    assertEquals(10, heater1.temperature());
	}
	
	public void testTwoParameterConstructor()
	{
	    Heater heater1 = new Heater(0, 30);
	    assertEquals(15, heater1.temperature());
	    heater1.warmer();
	    assertEquals(20, heater1.temperature());
	    heater1.cooler();
	    heater1.cooler();
	    assertEquals(10, heater1.temperature());	 	    
	}
	
	public void testMax()
	{
	    Heater heater1 = new Heater(0, 30);
	    heater1.warmer();
	    assertEquals(20, heater1.temperature());
	    heater1.warmer();
	    assertEquals(25, heater1.temperature());
	    heater1.warmer();
	    assertEquals(30, heater1.temperature());
	    
	    /* The heater is now set to its maximum temperature.
	     * Additional calls to warmer() should not change the temperature.
	     */
	    heater1.warmer();
	    assertEquals(30, heater1.temperature());
	    
	    Heater heater2 = new Heater(0, 27);
	    heater2.warmer();
	    assertEquals(20, heater2.temperature());
	    heater2.warmer();
	    assertEquals(25, heater2.temperature());
	    
	    /* The heaster is now 2 degrees below its maximum temperature.
	     * Additional calls to warmer() should not change the temperature.
	     */
	    heater2.warmer();
	    assertEquals(25, heater2.temperature());   	    
	}
	
    public void testMin()
	{
	    Heater heater1 = new Heater(0, 30);
	    heater1.cooler();
	    assertEquals(10, heater1.temperature());
	    heater1.cooler();
	    assertEquals(5, heater1.temperature());
	    heater1.cooler();
	    assertEquals(0, heater1.temperature());
	    
	    /* The heater is now set to its minimum temperature.
	     * Additional calls to cooler() should not change the temperature.
	     */
	    heater1.cooler();
	    assertEquals(0, heater1.temperature());	 
	    
	    Heater heater2 = new Heater(3, 30);
	    heater2.cooler();
	    assertEquals(10, heater2.temperature());
	    heater2.cooler();
	    assertEquals(5, heater2.temperature());
	    
	    /* The heater is now 3 degrees above its minimum temperature.
	     * Additional calls to cooler() should not change the temperature.
	     */	    
	    heater2.cooler();
	    assertEquals(5, heater2.temperature());    	    
	}		
	
	public void testSetIncrement()
	{
	    Heater heater1 = new Heater(0, 30);
	    
	    heater1.setIncrement(3);
	    heater1.warmer();
	    assertEquals(18, heater1.temperature());
	    heater1.cooler();
	    assertEquals(15, heater1.temperature());
	}
	
	public void testZeroAndNegativeIncrement()
	{
	    Heater heater1 = new Heater(0, 30);
	    heater1.setIncrement(0);
	    /* Increment should remain at 5. */
	    heater1.warmer();
	    assertEquals(20, heater1.temperature());	    
	    heater1.setIncrement(-4);
	    /* Increment should remain at 5. */
	    heater1.warmer();
	    assertEquals(25, heater1.temperature());
	}		
}
