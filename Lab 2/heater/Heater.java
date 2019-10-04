/**
 * A Heater models a simple space-heater. The operations provided by a Heater
 * object are:
 * 1. Increase and decrease the temperature setting by a set amount.
 * 2. Return the current temperature setting.
 * 3. Change the set amount by which the temperature is increased and lowered.
 * 
 * @author L.S. Marshall, SCE, Carleton University
 * (incomplete implementation for SYSC 2004 Lab 2)
 * @author Dharshatharan J. A.
 * @version 1.03 September 18th, 2019
 */
public class Heater
{
    /** The temperature setting that the heater should maintain. */
    private int temperature;
    
    /** The temperature setting for a newly created heater. */
    private static final int INITIAL_TEMPERATURE = 15;
    
    /** 
     * The amount by which the temperature setting is raised/lowered when
     * warmer() and cooler() are invoked.
     */
     private int increment;
     
    /**
     * The minimum and maximum temperature settings of the heater.
     */
    private int max, min;
    
    /**
     * The default values for the minimum and maximum temperatures.
     */
    private static final int DEFAULT_MINIMUM_TEMPERATURE = 0;
    private static final int DEFAULT_MAXIMUM_TEMPERATURE = 100;
    
    /** 
     * The default amount by which the temperature setting is 
     * increased when warmer() is invoked and decreased when cooler()
     * is invoked.
     */
    private static final int DEFAULT_INCREMENT = 5;
    
    /**
     * Constructs a new Heater with an initial temperature setting of 15
     * degrees, and which increments and decrements the temperature
     * setting in increments of 5 degrees.
     */
    public Heater()
    {
        temperature = INITIAL_TEMPERATURE;
        increment = DEFAULT_INCREMENT;
        min = DEFAULT_MINIMUM_TEMPERATURE;
        max = DEFAULT_MAXIMUM_TEMPERATURE;
    }
 
    /**
     * Write an appropriate comment here.
     */    
    public Heater(int minTemp, int maxTemp)
    {
        temperature = INITIAL_TEMPERATURE;
        increment = DEFAULT_INCREMENT;
        min = minTemp;
        max = maxTemp;
    }

    /**
     * Returns the temperature of the heater.
     */    
    public int temperature()
    {
        return temperature;
    }
    
    /**
     * Increases the temperature by the increment value.
     */
    public void warmer()
    {
        if ((temperature + increment) <= max){
            temperature += increment;
        }
    }

    /**
     * Decreases the temperature by the increment value.
     */    
    public void cooler()
    { 
        if ((temperature - increment) >= min){
            temperature -= increment;
        }
    }
    
    
    /**
     * Write an appropriate comment here.
     */    
    public void setIncrement(int newIncrement)
    { 
        if (newIncrement > 0){
            increment = newIncrement;
        }
    }
}
