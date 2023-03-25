/**
 *Flight class uses Time1
 * Represents a flight.
 * A Flight object is represented by the flight's origin,
 * destination,departure time, flight duration, no of passengers,
 * if it is full and the price.
 *
 * @author (eden cohen)
 * @version (V 1.0)
 */
public class Flight
{
    // instance variables 
    private String _origin; 
    private String _destination; 
    private Time1 _departure; 
    private int _flightDuration; 
    private int _noOfPassengers;
    private boolean _isFull; // true if its full
    private int _price; 

    private final int MAX_CAPACITY = 250;
    private final int MIN_CAPACITY = 0;

    /**
     * Constructor for a Flight object.
     * If the number of passengers exceeds the maximum capacity 
     * the number of passengers will be set to the maxmum capacity.
     * If the number of passengers is negative the number of passengers will be set to zero. 
     * If the flight duration is negative the flight duration will be set to zero. 
     * If the price is negative the price will be set to zero.
     * 
     * @param dest The city the flight lands at.
     * @param origin The city the flight leaves from.
     * @param depHour the departure hour (should be between 0-23).
     * @param depMinute The departure minute (should be between 0-59).
     * @param durTimeMinutes The duration time in minutes(should not be negative).
     * @param noOfPass The number of passengers (should be between 0-maximum capacity).
     * @param price The price (should not be negative).
     */
    public Flight(String origin, String dest, int depHour,
    int depMinute,int durTimeMinutes, int noOfPass,
    int price)
    {
        // instance variables
        _origin = origin;
        _destination = dest;
        _departure = new Time1(depHour, depMinute); 
        _flightDuration = flightDurationValidator(durTimeMinutes); //flightDurationValidator return 0 if durTimeMinutes is negative
        _noOfPassengers = noOfPassengersValidator(noOfPass); //noOfPassengersValidator return default values if noOfPass is not between 0-250
        _isFull = isFull(); //true if _noOfPassengers is at MAX_CAPACITY
        _price = priceValidator(price); //priceValidator return 0 if price is negative
    }

    /**
     * Copy constructor for a Flight object. 
     * Construct a Flight object with the same attributes 
     * as another Flight object.
     * 
     * @param other The Flight object from which to construct the new Flight.
     * 
     */
    public Flight(Flight other){
        _origin = new String(other._origin);
        _destination = new String(other._destination);
        _departure = new Time1(other._departure); 
        _flightDuration = other._flightDuration;
        _noOfPassengers = other._noOfPassengers;
        _isFull = other._isFull;
        _price = other._price;
    }

    //getters
    /**
     * Returns the flight origin.
     * @return The flight origin.
     */
    public String getOrigin(){
        return new String (_origin);
    }

    /**
     * Returns the flight destination.
     * @return The flight destination.
     */
    public String getDestination(){
        return new String (_destination);
    }

    /**
     * Returns the flight departure time.
     * @return A copy of the flight departure time.
     */
    public Time1 getDeparture(){
        return new Time1(_departure);        
    }

    /**
     * Returns the flight duration time in minutes.
     * @return The flight duration.
     */ 
    public int getFlightDuration(){
        return _flightDuration;
    }

    /**
     * Returns the number of passengers on the flight.
     * @return The number of passengers.
     */
    public int getNoOfPassengers(){
        return _noOfPassengers;
    }

    /**
     * Returns whether the flight is full or not.
     * @return True if the flight is full.
     */
    public boolean getIsFull(){
        return _isFull;
    }

    /**
     * Returns the price of the flight .
     * @return The price.
     */
    public int getPrice(){
        return _price;
    }

    //setters
    /**
     * Changes the flight's destination.
     * @param dest The flight's new destination.
     */
    public void setDestination(String dest){
        _destination = dest;
    }

    /**
     * Changes the flight's origin.
     * @param origin The flight's new origin.
     */
    public void setOrigin(String origin){
        _origin = origin;
    }

    /**
     * Changes the flight's departure time.
     * @param departureTime The flight's new departure time.
     */
    public void setDeparture(Time1 departureTime){
        _departure.setHour(departureTime.getHour());
        _departure.setMinute(departureTime.getMinute());
    }

    /**
     * Changes the flight's duration time. 
     * If the parameter is negative the duration 
     * time will remain unchanged.
     * @param durTimeMinutes The flight's new duration time.
     */
    public void setFlightDuration​(int durTimeMinutes){
        if (0 <= durTimeMinutes){
            _flightDuration = durTimeMinutes;
        }
    }

    /**
     * Changes the number of passengers. 
     * If the parameter is negative or larger than the maximum capacity 
     * the number of passengers will remain unchanged.
     * @param noOfPass The new number of passengers.
     */
    public void setNoOfPassengers​(int noOfPass){
        if (MIN_CAPACITY <= noOfPass && noOfPass <= MAX_CAPACITY){
            _noOfPassengers = noOfPass;
            _isFull = isFull();
        }
    }

    /**
     * Changes the flight price. 
     * If the parameter is negative the price will remain unchanged.
     * @param price The new price.
     */
    public void setPrice​(int price){
        if (0 <= price){
            _price = price;
        }
    }

    //mothods
    /**
     * Check if the received flight is equal to this flight. 
     * Flights are considered equal if 
     * the origin, destination and departure times are the same.
     * @param other The flight to be compared with this flight.
     * @return True if the received flight is equal to this flight.
     */
    public boolean equals(Flight other){
        return (_origin.equals(other._origin) &&
            _destination.equals(other._destination) &&
            _departure.equals(other._departure));
    }

    /**
     * Returns the arrival time of the flight .
     * @return The arrival time of this flight.
     */
    public Time1 getArrivalTime(){
        return _departure.addMinutes(_flightDuration);
    }

    /**
     * Add passengers to this flight. 
     * If the number of passengers exceeds the maximum capacity, 
     * no passengers are added and alse is returned. 
     * If the flight becomes full, the boolean attribute describing 
     * whether the flight if full becomes true.
     * 
     * @param num The number of passengers to be added to this flight.
     * @return True if the passengers were added to the flight.
     */
    public boolean addPassengers(int num){
        num = _noOfPassengers + num;
        if (num <= MAX_CAPACITY){
            _noOfPassengers = num;
            _isFull = isFull();
        }
        return (num <= MAX_CAPACITY);
    }

    /**
     * Check if this flight is cheaper than another flight.
     * @param other The flight whose price is 
     * to be compared with this flight's price.
     * @return True if this flight is cheaper than the received flight .
     */
    public boolean isCheaper​(Flight other){
        return (_price < other._price);
    }

    /**
     * Calculate the total price of the flight.
     * @return The total price of the flight.
     */
    public int totalPrice(){
        return (_price * _noOfPassengers);
    }

    /**
     * Check if this flight lands before another flight. 
     * Note - the flights may land on different days, 
     * the method checks which flight lands first.
     * 
     * @param other The flight whose arrival time to be compared with this flight's arrival time.
     * @return True if this flight arrives before the received flight.
     */
    public boolean landsEarlier(Flight other){
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    /**
     * Return a string representation of this flight 
     * (for example: "Flight from London to Paris departs at 09:24.
     * Flight is full.").
     * @Overrides
     * @return String representation of this flight 
     * (for example: "Flight from London to Paris departs at 09:24. Flight is full.").
     * 
     */
    public String toString(){
        String isFull; //value determined by boolean _isfull
        if (_isFull){
            isFull = "full.";
        }else{
            isFull = "not full.";
        }
        String rep = "Flight from " + _origin + " to " + _destination +
            " departs at " + _departure + ". Flight is " + isFull;
        return rep;
    }

    //private methods.
    private int flightDurationValidator(int durTimeMinutes) { //return durTimeMinutes=0 if it is negative
        if (durTimeMinutes < 0){
            durTimeMinutes = 0;
        }
        return durTimeMinutes;
    }

    private int noOfPassengersValidator(int noOfPass){ //return noOfPass=0 if it is negative, and noOfPass=250 if its over 250
        if (MAX_CAPACITY < noOfPass){
            noOfPass = MAX_CAPACITY;
        }
        if (noOfPass < MIN_CAPACITY){
            noOfPass = MIN_CAPACITY;
        }
        return noOfPass;
    }

    private int priceValidator(int price){ //return price=0 if price is negative
        if (price < 0) {
            price = 0;
        }
        return price;
    }

    private boolean isFull(){ //return true if flight is full
        return (MAX_CAPACITY <= _noOfPassengers);
    }

}
