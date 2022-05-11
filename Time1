
/**
 * Represents time - hours:minutes. Coordinates cannot be negative.
 *
 * @author (eden cohen)
 * @version (V 1.0)
 */
public class Time1
{
    // instance variables
    private int _hour;
    private int _minute;

    private final int DEFAULT_VAL = 0;
    
    //Constructors
    /**
     * Constructs a Time1 object.
     * Construct a new time instance with the specified hour and minute.
     * hour should be between 0-23, otherwise it should be set to 0.
     * minute should be between 0-59, otherwise it should be set to 0.
     * 
     * @param h the hour of the time
     * @param m the minute of the time  
     * 
     */
    public Time1(int h,int m)
    {
        hourValidate(h); // check for an error and default an error to DEFAULT_VAL
        minuteValidate(m); // check for an error and default an error to DEFAULT_VAL
    }

    /**
     *     Copy constructor for Time1.
     *     Construct a time with the same instance variables 
     *     as another time.
     *     
     *     @param other The time object from which to construct the new time
     */
    public Time1 (Time1 other){
        this._hour = other._hour;
        this._minute = other._minute;
    }

    //getters
    /**
     * Returns the hour of the time.
     * @return The hour of the time.
     */
    public int getHour(){
        return _hour;
    }

    /**
     * Returns the minute of the time.
     *@return The minute of the time
     */
    public int getMinute(){
        return _minute;
    }

    //setters
    /**
     * Changes the hour of the time.
     * If an illegal number is received hour will be unchanged.
     * 
     * @param num The new hour
     */
    public void setHour(int num) {
        if (0 <= num && num<= 23){
            _hour = num; 
        }
    }

    /**
     * Changes the minute of the time.
     * If an illegal number is received minute will be unchanged.
     * 
     * @param num The new minute.
     */
    public void setMinute(int num) {
        if (0 <= num && num <=59) {
            _minute = num;
        }
    }

    //mothods

    /**
     * Return a string representation of this time (hh:mm).
     * 
     * @overrides 
     * @return String representation of this time (hh:mm).
     */
    public String toString() {
        String hour = (_hour<10 ? "0" : "") + _hour;
        String minute = (_minute<10 ? "0" : "") + _minute; 
        String time = hour + ":" + minute;

        return (time);
    }

    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight (){
        return((_hour * 60) + _minute);
    }

    //return true if Time1 other equals to this Time1
    /**
     * Check if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    public boolean equals(Time1 other) {
        return (_hour == other._hour && _minute == other._minute);
    }

    //returns true if this object before other.
    /**
     * Check if this time is before a received time.
     * @param other The time to check if this point is before
     * @return True if this time is before other time
     */
    public boolean before (Time1 other){
        return (_hour < other._hour || (_hour == other._hour && _minute < other._minute));
    }

    //returns true if other is after this object by using method before()
    /**
     * Check if this time is after a received time.
     * @param other The time to check if this point is after 
     * @return True if this time is after other time
     */
    public boolean after(Time1 other) {
        return other.before(this);
    }
    
    /**
     * Calculates the difference (in minutes) between two times.
     * Assumption: this time is after other time.
     * 
     *@param other The time to check the difference to
     *@return int difference in minutes
     */
    public int difference(Time1 other){
        return (((_hour - other._hour)*60) + (_minute - other._minute));
    }

    //return Time1 with the added time from num
    /**
     * Copy current object and add requested minutes to new object.
     * @param num The minutes need to add.
     * @return new update Time1 object.
     */
    public Time1 addMinutes(int num){
        int minutesADay = (_hour * 60) + _minute + num;
        minutesADay = ((minutesADay%1440) + 1440) % 1440;
        int hour = minutesADay / 60;
        int minute = minutesADay % 60;
        return new Time1(hour, minute);
    } 

    //private methods

    // returns h=0 if not 0<=hour<=23 as default 
    private void hourValidate(int h) {
        _hour = DEFAULT_VAL; 
        if (0 <= h && h <= 23){
            _hour = h; 
        }
    }

    // returns m=0 if not 0<= miunte<=59 as default 
    private void minuteValidate(int m) {
        _minute = DEFAULT_VAL;
        if (0 <= m && m <=59) {
            _minute = m;
        }
    }
}
