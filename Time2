
/**
 *same class as Time1 with the same methods- different instance variables
 * Represents time - hours:minutes. 
 * Values must represent a proper time
 *
 * @author (eden cohen)
 * @version (V 1.0)
 */
public class Time2
{
    // instance variables 
    private int _minFromMid;

    private final int DEFAULT_VAL = 0;

    //constructors
    /**
     * Constructs a Time2 object.
     * Construct a new time instance with the specified hour and minute.
     * hour should be between 0-23, otherwise it should be set to 0. 
     * minute should be between 0-59, otherwise they should be set to 0.
     * 
     * @param h hour
     * @param m minute
     */

    public Time2(int h, int m){
        if (!(isHourValid(h))) { //validate the int h is between 0-23, else- h=default value- 0
            h = DEFAULT_VAL;
        }
        if (!(isMinuteValid(m))) { //validate the int m is between 0-59, else- m=default value- 0
            m = DEFAULT_VAL;
        }
        _minFromMid = (h * 60) + m;
    }

    /**
     *Copy constructor for Time2.
     *Constructs a time with the same variables as another time.
     *
     *@param other The time object from which to construct the new time
     */

    public Time2(Time2 other){
        _minFromMid = other._minFromMid;
    }

    //getters
    /**
     * Returns the hour of the time.
     * @return The hour of the time
     */
    public int getHour(){
        return (_minFromMid/60);
    }

    /**
     * Returns the minute of the time.
     * @return The minute of the time
     */
    public int getMinute(){
        return (_minFromMid%60);
    }

    //setters
    /**
     * Changes the hour of the time. 
     * If an illegal number is received hour will remain unchanged.
     * 
     * @param num The new hour
     */
    public void setHour(int num) {
        if (isHourValid(num)){
            _minFromMid = num * 60 + getMinute();
        }
    }

    /**
     * Changes the minute of the time. 
     * If an illegal number is received minute will remain unchanged.
     * 
     * @param num The new minute
     */
    public void setMinute(int num) {
        if (isMinuteValid(num)){
            _minFromMid = (getHour() * 60) + num;
        }
    }

    //methods

    /**
     * Return the amount of minutes since midnight
     * 
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight (){
        return _minFromMid;
    }

    /**
     * Checks if the received time is equal to this time.
     * 
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    public boolean equals (Time2 other){
        return(this._minFromMid == other._minFromMid);
    }

    /**
     * Checks if this time is before a received time.
     * 
     * @param other The time to check if this time is before
     * @return True if this time is before other time
     */
    public boolean before(Time2 other){
        return(this._minFromMid < other._minFromMid);
    }

    /**
     * Checks if this time is after a received time.
     * 
     * @param other The time to check if this time is after
     * @return True if this time is after other time
     */
    public boolean after(Time2 other){
        return other.before(this);
    }

    /**
     * Calculates the difference (in minutes) between two times.
     * 
     * @param other The time to check the difference with. 
     * Assumption: this time is after other time
     * 
     *@return int difference in minutes
     */
    public int difference(Time2 other){
        return (_minFromMid - other._minFromMid);
    }

    /**
     * Returns a string representation of this time(hh:mm).
     * @override
     * @return String representation of this time(hh:mm).
     */
    public String toString(){
        String hour = (getHour()<10 ? "0" : "") + getHour();
        String minute = (getMinute()<10 ? "0" : "") + getMinute(); 
        String time = hour + ":" + minute;
        return (time);
    }

    //return new added time
    /**
     * Copy current object and add requested minutes to new object.
     * 
     * @param num The minutes need to add.
     * @return new update Time2 object.
     */
    public Time2 addMinutes(int num){
        int minutesADay = _minFromMid + num;
        minutesADay = ((minutesADay% 1440)+ 1440) % 1440;
        int hour = minutesADay / 60;
        int minute = minutesADay % 60;

        return new Time2(hour, minute);
    }

    //private method
    //return true if hour and minute are valid
    private boolean isValid(int h, int m) {
        return((0 <= m && m <=59) && (0 <= h && h <= 23));
    }

    //return true if hour is valid (0-23)
    private boolean isHourValid(int h){
        return (0 <= h && h <= 23);
    }

    //return true if minute is valid(0-59)
    private boolean isMinuteValid(int m){
        return (0 <= m && m <=59);
    }

}
