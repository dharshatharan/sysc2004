public abstract class Counter
{
    /** The current value of this counter. */
    private int count;

    /** The minimum value of this counter. */
    private int minimumCount;

    /** The maximum value of this counter. */
    private int maximumCount;

    /** The default minimum value of this counter. */
    private static final int DEFAULT_MINIMUM = 0;

    /** The default maximum value of this counter. */
    private static final int DEFAULT_MAXIMUM = 999;

    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to DEFAULT_MINIMUM, and which counts between
     * DEFAULT_MINIMUM and DEFAULT_MAXIMUM, inclusive.
     */
    public Counter()
    {
        minimumCount = DEFAULT_MINIMUM;
        maximumCount = DEFAULT_MAXIMUM;
        count = minimumCount;
    }

    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to minCount, and which counts between
     * minCount and maxCount, inclusive.
     */
    public Counter(int minCount, int maxCount)
    {
        minimumCount = minCount;
        maximumCount = maxCount;
        count = minimumCount;
    }

    /**
     * Returns the maximum value of this counter.
     */
    public int maximumCount()
    {
        return maximumCount;
    }

    /**
     * Returns the minimum value of this counter.
     */
    public int minimumCount()
    {
        return minimumCount;
    }

    /**
     * Returns this counter's current count.
     */
    public int count()
    {
        return count;
    }

    /**
     * Returns true if this counter is at its minimum value.
     */
    public boolean isAtMinimum()
    {
         return (count == minimumCount);
    }

    /**
     * Returns true if this counter is at its maximum value.
     */
    public boolean isAtMaximum()
    {
        return (count == maximumCount);
    }

    /**
     * Resets this counter to its minimum value.
     */
    public void reset()
    {
        count = minimumCount;
    }
    /**
     * Increment this counter by 1
     */
    public void countUp(){
        count++;
    }
    
    public void decrementCount(){
        count--;
    }
    
    public abstract void countDown();
    
    public void setToMaximum(){
        count = maximumCount;
    }
}
