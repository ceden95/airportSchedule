
/**
 * Represents a flight schedule at the airport in a day.
 * 
 * the flight schedule represented as a Flight object
 * classed in an arrey.
 *
 * @author (Eden Cohen)
 * @version (V 1.0)
 */
public class Airport
{
    // instance variables 
    private Flight [] _flightsSchedule; 
    private int _noOfFlight; //number of flights available in that day.
    private String _city; //the city where the airport is.

    private final int MAX_FLIGHTS = 200; //number of max flights a day
    /**
     * Constructor for an Airport object.
     * construct an arrey of permanent space- MAX_FLIGHTS.
     * the number of flights for a new object initialized to 0.
     * 
     * @param city represent the city where the airport is.
     */
    public Airport(String city){
        _city = city;
        _flightsSchedule = new Flight[MAX_FLIGHTS];// arrey initialized to MAX FLIGHTS 
        _noOfFlight  = 0; //number of flights new object has.
    }

    /**
     * add flights to the airport schedule.
     * if the flight's origin or destination equals to
     * the city of the object, the flight is added to the 
     * object and return true.
     * if the flight's origin or destination is not equal to the 
     * object's city- flight is not added and return false.
     * 
     * Assumption: the flight that needs to be added is not in the airport schedule.
     * 
     * @param f the flight to add
     * @return true if the flight has added to the airport schedule.
     */
    public boolean addFlight(Flight f) {
        if (_city.equals(f.getDestination()) || _city.equals(f.getOrigin())) {
            _flightsSchedule[_noOfFlight] = new Flight(f); //adding f to the arrey _flightsSchedule
            _noOfFlight++; //adds 1 flight to today's flights schedule
            return true;
        }
        return false;
    }

    /**
     * remove flight from airport schedule.
     * return true if flight removed successfully,
     * if not-return false.
     * 
     * @param f the flight needed to be removed from airport schedule.
     * @return true if the flight removed successfully
     */
    public boolean removeFlight(Flight f){
        for (int i=0; i<_noOfFlight; i++) {
            if (_flightsSchedule[i].equals(f)) { //if f equals to a flight in airport schedule.
                for (int j=i+1; j<_noOfFlight; j++) {
                    _flightsSchedule[j-1] = _flightsSchedule[j]; //switch f with the next flight in the arrey 
                }//for every flight until _noOfFlight
                _noOfFlight--; 
                return true;
            }
        }
        return false;
    }

    /**
     * return the time of the earliest flight from the place.
     * if place is'nt an origin place in the flight schedule - method return null.
     * 
     * @param place the origin of flight.
     * @return the earliest Time1 of the flights from place
     */
    public Time1 firstFlightFromOrigin(String place){
        if (_noOfFlight == 0) {
            return null;
        }

        Flight first = null;
        for (int i=0; i<_noOfFlight; i++) {
            if (_flightsSchedule[i].getOrigin().equals(place)){
                if (first == null){
                    first = _flightsSchedule[i];
                }
                else if (_flightsSchedule[i].getDeparture().before(first.getDeparture())){
                    first = _flightsSchedule[i];
                }
            }
        }

        if (first == null){
            return null;
        }

        return first.getDeparture();
    }

    /**
     * return the number of full flights in a flight schedule.
     * @return the numer of full flghts
     */
    public int howManyFullFlights(){
        int temp = 0;
        for (int i=0; i<_noOfFlight; i++) {
            if (_flightsSchedule[i].getIsFull()){ //if a flight in airport schedule is full
                temp++; // add flight to number of full flights
            }
        }
        return temp;
    }

    /**
     * calculate the number of flights departs\lands from the param city
     * 
     *@param city the place the flight departs\lands from
     *@return the number of flights departs\lands from the param city
     */
    public int howManyFlightsBetween(String city){
        int temp = 0;
        for (int i=0; i<_noOfFlight; i++) {
            if (_flightsSchedule[i].getOrigin().equals(city) || _flightsSchedule[i].getDestination().equals(city)){
                temp++;
            }
        }
        return temp;
    }

    /**
     * return the most popular destination city in the airport schedule
     * if airport schedule is empty- return null
     * if there is more then 1 popular destination- 
     * the first destination in the airport schedule returns.
     * 
     * @return the most popular destination city in the airport schedule
     */
    public String mostPopularDestination(){  
        if (_noOfFlight==0){
            return null;
        }

        int popularCount = -1;
        String popularDestination = null;
        for(int i = 0; i<_noOfFlight; i++){
            int specificFlightCount = 0;
            String specificFlight = _flightsSchedule[i].getDestination();
            for(int j = 0; j<_noOfFlight; j++){
                if(_flightsSchedule[j].getDestination().equals(specificFlight)){
                    specificFlightCount++;
                }
            }
        
            if(popularCount == -1) //for the first flight in the loop
            {
                popularCount = specificFlightCount;
                popularDestination = specificFlight;                
            }
            else if(specificFlightCount > popularCount){ //if the current flight is most popular
                popularCount = specificFlightCount;
                popularDestination = specificFlight;
            }
        }
        return popularDestination;
    }

    /**
     * return a flight with the most expansive ticket in the airport schedule.
     * if airport schedule is empty- return null.
     * if there are  several flights with the same most expensive price- 
     * the most exapnsive is the first flight in the airport schedule. 
     * 
     * @return the most expensive flight.
     */
    public Flight mostExpensiveTicket(){
        if (_noOfFlight == 0) {
            return null;
        }

        Flight mostExpansive = _flightsSchedule[0];
        for (int i=1; i<_noOfFlight; i++) {
            if (mostExpansive.isCheaper(_flightsSchedule[i])){
                mostExpansive = _flightsSchedule[i];
            }
        }
        for (int i=0; i<_noOfFlight; i++) {
            if (mostExpansive.getPrice() == _flightsSchedule[i].getPrice()){
                mostExpansive = _flightsSchedule[i];
                break;
            }
        }
        return mostExpansive;
    }

    /**
     * return the longest flight in the airport schedule.
     * if airport schedule is empty- return null. 
     * if there are several flights with the same longest duration- 
     * the longest flight is the first flight in the airport schedule. 
     * 
     * @return the longest flight in the airport schedule.
     */
    public Flight longestFlight(){
        if (_noOfFlight == 0) {
            return null;
        }
        int maxDuration = 0;
        for (int i=0; i<_noOfFlight; i++) {
            if (maxDuration < _flightsSchedule[i].getFlightDuration()){
                maxDuration = _flightsSchedule[i].getFlightDuration();
            }
        }
        Flight longestFlight = _flightsSchedule[0];
        for (int i=0; i<_noOfFlight; i++) {
            if (maxDuration == _flightsSchedule[i].getFlightDuration()){
                longestFlight = _flightsSchedule[i];
                break;
            }
        }
        return longestFlight;
    }

    /**
     * Return a string of a list of all flights-
     * every flight in a new line. list comes with a headline.
     * 
     * @Overrides
     * @return string of the airport schedule with a headline. 
     * (for example:  headline, "Flight from London to Paris departs at 09:24. Flight is full.").
     */
    public String toString(){
        if (_noOfFlight == 0) {
            return null;
        }
        String str = "The flights for airport " + _city + " today are:\n";
        for (int i=0; i<_noOfFlight; i++) {
            str += _flightsSchedule[i] + "\n";
        }
        return str;
    }
}
