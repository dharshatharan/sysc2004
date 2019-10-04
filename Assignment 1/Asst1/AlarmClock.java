
/**
* This class implements an alarm clock which has a current time and and alarm.
* Both the times can be set and the alarm can be turned on or off. If the
* current time reaches the time that the alarm is set and the alarm is turned
* on, the class will print RING RING RING in the terminal.
*
* @author Dharshatharan J.A.
* @version September 18th, 2019
*/
public class AlarmClock
{
    private ClockDisplay12 currentTime;
    private Alarm alarm;

    /**
    * Constructor without parameters for objects of class AlarmClock
    */
    public AlarmClock()
    {
        currentTime = new ClockDisplay12();
        alarm = new Alarm();
    }

    /**
     * Constructor with parameters for objects of class AlarmClock
     */
    public AlarmClock(int clockHours, int clockMinutes, String clockAmPm,
    int alarmHours, int alarmMinutes, String alarmAmPm, boolean alarmStatus){
        currentTime = new ClockDisplay12(clockHours, clockMinutes, clockAmPm);
        alarm = new Alarm(alarmHours, alarmMinutes, alarmAmPm, alarmStatus);
    }
    
    /**
     * Sets the current time of the alarm clock
     */
    public void setTime(int hours, int minutes, String amPm){
        currentTime.setTime(hours, minutes, amPm);
    }
    
    /**
     * Sets the time for the alarm on the alarm clock
     */
    public void setAlarmTime(int hours, int minutes, String amPm){
        alarm.setTime(hours, minutes, amPm);
    }
    
    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void clockTick(){
        currentTime.timeTick();
        if((currentTime.getTime().equals(alarm.getTime()))&&(alarm.isSet() == true)){
            System.out.println("RING RING RING");
        }
    }
    
    /**
     * Turns on the alarm
     */
    public void setAlarm(){
        alarm.turnOn();
    }
    
    /**
     * Turns off the alarm
     */
    public void unsetAlarm(){
        alarm.turnOff();
    }
    
    /**
     * Returns the current time on the alarm clock
     */
    public String getTime(){
        return currentTime.getTime();
    }
    
    /**
     * Returns the set alarm time on the alarm clock
     */
    public String getAlarmTime(){
        return alarm.getTime();
    }
    
    /**
     * Returns true of the alarm is on and false if the alarm is off
     */
    public boolean isAlarmSet(){
        return alarm.isSet();
    }
}
