/**
 * An amount of money in Canadian currency; i.e., dollars and cents.
 *
 * @author D.L. Bailey, Department of Systems and Computer Engineering,
 * Carleton University
 * @version 1.11, March 11, 2007
 * 
 * @author Lynn Marshall
 * @version November 24, 2012
 */
public class Money implements Comparable
{
    /** The total amount of money, in cents */
    private int totalCents;

    /**
     * Constructs a Money object whose value is equal to the specified
     * quantity of cents, which can be positive or negative, and < -99 or > 99.
     * 
     * @param cents A quantity of cents.
     * @see Money#Money(int, int)
     */   
    public Money(int cents)
    {
        totalCents = cents;
    }

    /**
     * Constructs a Money object whose value is equal to the specified
     * quantity of dollars and cents, both of which can be positive or
     * negative. Cents must be between -99 and 99.
     *
     * @param dollars A quantity of dollars.
     * @param cents A quantity of cents.
     * @see Money(int)
     * @throws IllegalArgumentException if cents outside valid range
     */
    public Money(int dollars, int cents)
    {
        if (cents<-99 || cents>99) {
            throw new IllegalArgumentException("cents must be between -99 and 99");
        }
        totalCents = dollars * 100 + cents;
    }

    /**
     * Returns the dollars part of this Money object. For example, if this
     * object represents $9.37, 9 is returned; and if this object represents
     * -$7.14, -7 is returned.
     *
     * @return the dollars part of this Money object.
     */
    private int dollars()
    {
        return totalCents / 100;
    }

    /**
     * Returns the cents part of this Money object. For example, if this
     * object represents $9.37, 37 is returned; and if this object represents
     * -$7.14, -14 is returned.
     *
     * @return the cents part of this Money object, between -99 and 99, inclusive.
     */
    private int cents() 
    {
        return totalCents % 100;
    }

    /**
     * Returns the sum of this Money object and the specified amount of money.
     *
     * @param anAmount the Money object that is to be added to this object.
     * @return a Money object equal to the sum of this Money object and anAmount.
     */
    public Money plus(Money anAmount)
    {
        if (anAmount==null) {
            throw new NullPointerException("anAmount may not be null");
        }
        return new Money(totalCents + anAmount.totalCents);
    }
   
    /**
     * Returns the difference of this Money object and the specified amount of money.
     *
     * @param anAmount the Money object that is to be subtracted from this object.
     * @return a Money object equal to the result of subtracting anAmount from this
     *         Money object.
     */
    public Money minus(Money anAmount) 
    {
        return new Money(totalCents - anAmount.totalCents);
    }

    /**
     * Returns the result of multiplying this Money object an integer amount.
     *
     * @param anAmount the integer that is to be multiplied by this object.
     * @return a Money object equal to the product of this Money object
     *         and anAmount.
     */   
    public Money multipliedBy(int anAmount)
    {
         return new Money(totalCents * anAmount);
    }
    
    /**
     * Returns the result of dividing this Money object an integer amount.
     *
     * @param anAmount the integer that is to be divided into this object.
     * @return a Money object equal to the quotient of this Money object
     *         and anAmount.
     */   
    public Money dividedBy(int anAmount)
    {
        /* We could check to see if anAmount is 0, but what should we do
         * if we determine that we are attempting to divide by 0?
         */
         return new Money(totalCents / anAmount);
    }  
    
    /**
     * Compares this Money object against the specified Money object. The result 
     * is true if and only if the two objects are equal.
     *
     * @param anAmount the Money object that is to be compared to this object.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean isEqualTo(Money anAmount)
    {
        return (totalCents == anAmount.totalCents);
    }

    /**
     * Compares this Money object with the specified Money object for order. 
     * Returns a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * 
     * @return a negative integer, zero, or a positive integer as this object 
     *         is less than, equal to, or greater than the specified object.  
     */
    public int compareTo(Object obj)
    {
        if (!(obj instanceof Money)) {
            throw new ClassCastException("Object is not a Money");
        }
        Money m = (Money) obj;
        return (totalCents - m.totalCents);
    }
    
    /**
     * Returns a String representation of this Money object in the form:
     * "$ddd.cc" or "-$ddd.cc", where ddd is the dollars part and cc is the
     * cents part.
     *
     * @return a String representation of this Money object.
     */
    public String toString() {
        String s;
 
        int dollars = dollars();
        int cents = cents();
      
        /* The String for a negative amount has a leading "-" */
        if (totalCents < 0) {
            dollars = -dollars;
            cents = -cents;
            s = "-$";
        } else {
            s = "$";
        }
        
        s = s + dollars + ".";
        
        /* Ensure that quantities of cents between 0 and 9, inclusive,
         * are rendered with a leading 0.
         */
        if (cents <= 9)
            s = s + "0";
        s = s + cents;
        
        return s;
    }
    
    /**
     * Compares this object against the specified object.
     * The result is true if and only if the argument is
     * not null and is a Money object that represents the
     * same amount of money as this object.
     *
     * @param obj the object that is compared to this object.
     *
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object obj)
    {
        /*
         * Are we checking for equality with ourself?
         * If so, return true.
         */
        if (this == obj)
            return true;

        /*
         * Check if obj is null (no point in continuing
         * if it is).
         * Check if obj refers to an instance of class
         * Money (no point in continuing if it does not).
         */
        if ((obj == null) || !(obj instanceof Money))
            return false;

        /* Cast argument back to the correct type. */
        Money m = (Money)obj;

        /*
         * Now compare the instance variables of this object
         * and the argument.
         */
        return (totalCents == m.totalCents);
    }
    
    /** 
     * A method to use for learning about exceptions. 
     * 
     * This method returns the sum of "this", the object and 
     * number*cents. 
     * 
     * @param number A number between 1 and 10
     * @param cents The number of cents (between 0 and 99)
     * @param obj An object
     * 
     * @returns The sum of "this", obj, and number*cents
     */
    public Money addMonies (int number, int cents, Object obj) throws Exception
    {
        // adds together "this", number*cents, and obj (cast as a Money object)
        // once part 1 is completed, this line will never throw an exception
        // as they will be taken care of earlier in the method
        if((number < 1) || (number > 10)){
            throw new IllegalArgumentException ("Number not betweem 1 and 10");
        }
        if((cents < 0) || (cents > 99)){
            throw new IllegalArgumentException ("Cents not betweem 0 and 99");
        }
        if(obj == null){
            throw new NullPointerException ("obj is null");
        }
        if(obj instanceof Money == false) {
            throw new ClassCastException ("obj is not an object of Money");
        }
        return this.plus(new Money(number*cents)).plus((Money) obj);
    }
}
 