
/**
 * The timer engine for a lap timer application. This engine can keep
 * track of a 'run'. A run is a sequence of one or more consecutive laps.
 * The timer records single lap times and the time for the total run, 
 * and it calculate averages and speed. 
 * 
 * @author Michael Kolling?
 * @version 20 September 2004?
 * 
 * @author Lynn Marshall
 * @version Bugs added September 18, 2012
 */
public class TimingEngine
{
    private boolean running;
    
    /* The number of laps that the runner has completed. */
    private int lapCount;
    
    /* The time of the lap just completed, in milliseconds. */
    private long lapTime;
    
    /* The total time the runner has run so far, in milliseconds. */
    private long totalTime;  
    
    /* The current time of the system clock when the runner
     * started the current lap, in milliseconds.
     * See getSystemTime(), at the end of this class.
     */
    private long lapStartTime;
    
    /* The lap length, in metres. */
    private int lapLength;

    /* The average speed, in m/s. */
    private int avgSpeed;    
   
    /**
     * Create a TimingEngine object. The object will be initialised at 0,
     * status is "Stopped", ready to start timing. The default lap length
     * is 400 m.
     */
    public TimingEngine()
    {
        running = false;
        lapCount = 0;
        totalTime = 0;
        lapTime = 0;
        avgSpeed = 0;
        lapLength = 400;
    }

    
    /**
     * Instruct the timer to start timing a lap.
     * If we were not timing before, this starts the timer for a new 
     * run. If we were already timing, this starts a new lap, adding the
     * current lap time to the total.
     */
    public void startLap()
    {
        if (running) {
            finishLap();
        }
        else {
            lapCount = 0;
            totalTime = 0;
            lapTime = 0;
            lapStartTime = getSystemTime();
            running = true;
        }
    }
    
    
    /**
     * Stop timing. Add the current lap time to the total, and set
     * the timer into idle mode (waiting for a new run).
     */
    public void stop()
    {
        if(running == true){
            finishLap();
            running = false;
        }
    }
    
    
    /**
     * Return the current status of the timer. The status is one of the
     * two Strings "Timing..." or "Stopped", indicating whether this 
     * timer is currently running or stopped.
     */
    public String getStatus()
    {
        if (running) {
            return "Timing...";
        }
        else {
            return "Stopped";
        }
    }
    
    
    /**
     * Return the number of laps completed in this run.
     */
    public int getLapCount()
    {
        return lapCount;
    }
    
    
    /**
     * Return the time of the last lap completed.
     * The result is a string in the format "m:ss:hh", where m is
     * the number of minutes, ss the number of seconds, and hh the number
     * of hundredths of a second. For example "7:02:43".
     */
    public String getLastTime()
    {
        return timeToString(lapTime);
    }
    
    
    /**
     * Return the average time for a lap in this run.
     * The result is a string in the format "m:ss:hh".
     */
    public String getAverageTime()
    {
        if (lapCount == 0) {
            return timeToString(0);
        }
        else {
            long avgTime = totalTime / lapCount;
            return timeToString(avgTime);
        }
    }
    
    
    /**
     * Return the total time of the last or current run.
     * The result is a string in the format "m:ss:hh".
     */
    public String getTotalTime()
    {
        return timeToString(totalTime);
    }
    
    
    /**
     * Return the average speed in this run in meters per second.
     * The result is a string such as "73 m/s".
     */
    public String getAverageSpeed()
    {
        long totalSeconds = totalTime / 1000;
        if (totalSeconds == 0) {
            return "0 m/s";
        }
        else {
            long avgSpeed = (lapCount * lapLength) / totalSeconds;
            return avgSpeed + " m/s";
        }
    }
    
    
    /**
     * Return the length of a lap.
     */
    public int getLapLength()
    {
        return lapLength;
    }
    
    
    /**
     * Set the length of a lap.
     */
    public void setLapLength(int length)
    {
        if(length > 0){
            lapLength = length;
        }
    }
    

    /**
     * Private method called whenever a lap is finished. This method
     * updates the statistics.
     */
    private void finishLap()
    {
        lapCount++;
        long lapEndTime = getSystemTime();
        lapTime = lapEndTime - lapStartTime;
        totalTime = totalTime + lapTime;
        lapStartTime = lapEndTime;
    }
    

    /**
     * Convert a time interval in milli-seconds into a String in the
     * format "m:ss:hh".
     */
    private String timeToString(long time)
    {
        long hundredths = (time / 10) % 100;
        long seconds = (time / 1000) % 60;
        long minutes = time / 60000;
        
        return minutes + ":" + twoDigit(seconds) + ":" + twoDigit(hundredths);
    }
    
    
    /**
     * Convert a number into a two-digit String representation.
     */
    private String twoDigit(long number)
    {
        if(number < 10) {
            return "0" + number;
        }
        else {
            return "" + number;
        }
    }
    
    
    /**
     * Return the current time of the system clock (in milli-seconds).
     */
    private long getSystemTime()
    {
        return System.currentTimeMillis();
    }
}
