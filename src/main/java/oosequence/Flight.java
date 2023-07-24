package oosequence;

import java.util.Date;

public class Flight {
    // Define the instance variables
    Date arrival;
    Date departure;

    // Define class constructors
    public Flight(Date departureDate, Date arrivalDate){
        // Check if either date is null: Set according to arguments
        if(departureDate == null || arrivalDate == null) {
            departure = departureDate;
            arrival = arrivalDate;
        // Check if neither date is null: Check that departure date is before arrival date
        } else if(departureDate != null && arrivalDate != null){
            if(departureDate.before(arrivalDate)) {
                departure = departureDate;
                arrival = arrivalDate;
            }
        }
    }

    public Flight(Flight flight){
        departure = flight.departure;
        arrival = flight.arrival;
    }

    // Define class methods
    long length(){
        if(departure == null || arrival == null){
            return 0;
        }

        return ((arrival.getTime() - departure.getTime())/1000)/60;
    }
}
