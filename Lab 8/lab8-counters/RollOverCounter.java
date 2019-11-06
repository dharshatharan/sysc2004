public class RollOverCounter extends Counter
{
    public RollOverCounter()
    {
        super();
    }

    /**
     * Constructs a new RollOverCounter whose current count is
     * initialized to minCount, and which counts between
     * minCount and maxCount, inclusive.
     */
    public RollOverCounter(int minCount, int maxCount)
    {
        super(minCount, maxCount);
    }
    /**
     * Increment this counter by 1.
     */
    public void countUp()
    {
        // If we've reached the maximum count, invoking this
        // method rolls the counter over to its minimum value.
        if (super.isAtMaximum()) {
            super.reset();
        } else {
            super.incrementCount();
        }
    }
}
