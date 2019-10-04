
/**
 * This class implements an alarm system in an alarm clock. The time for the
 * alarm can be set. It can also be turned on or off. 
 *
 * @author Dharshatharan J.A.
 * @version September 18th, 2019
 */
public class Alarm
{
    private boolean alarmStatus;
    private ClockDisplay12 alarm;

    /**
     * Constructor without parameters for objects of class Alarm
     */
    public Alarm(){
        alarm = new ClockDisplay12();
        alarmStatus = false;
    }
      
    /**
     * Constructor with parameters for objects of class Alarm
     */
    public Alarm(int hours, int minutes, String amPm, boolean newAlarmStatus){
        alarm = new ClockDisplay12(hours, minutes, amPm);
        alarmStatus = newAlarmStatus;
    }
    
    /**
     * Sets the time of the alarm
     */
    public void setTime(int hours, int minutes, String amPm){
        alarm.setTime(hours, minutes, amPm);
    }
    
    /**
     * Turns on the alarm
     */
    public void turnOn(){
        alarmStatus = true;
    }
    
    /**
     * Turns off the alarm
     */
    public void turnOff(){
        alarmStatus = false;
    }
    
    /**
     * Returns the time the alarm is set to
     */
    public String getTime(){
        return alarm.getTime();
    }
    
    /**
     * returns true if the alarm is set and false if not
     */
    public boolean isSet(){
        return alarmStatus;
    }

}
