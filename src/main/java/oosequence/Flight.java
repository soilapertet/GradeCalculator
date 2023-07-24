package oosequence;

import java.util.Date;

public class Flight {
    // Define the instance variables
    private Date arrival;
    private Date departure;

    // Define class constructors
    public Flight(Date departure, Date arrival){
        // Check if either date is null: Set according to arguments
        if(departure == null || arrival == null) {
            this.departure = departure;
            this.arrival = arrival;
        // Check if neither date is null: Check that departure date is before arrival date
        } else if(departure != null && arrival != null){
            if(departure.before(arrival)) {
                this.departure = departure;
                this.arrival = arrival;
            }
        }
    }

    public Flight(Flight flight){
        departure = flight.departure;
        arrival = flight.arrival;
    }

    // Initialise getter and setter methods
    Date getArrival(){
        return arrival;
    }

    Date getDeparture(){
        return departure;
    }

    void setArrival(Date arrivalDate){
        if(departure != null){
            if(arrivalDate.after(departure)) {
                arrival = arrivalDate; // Set new arrival date if after departure date
            }
        } else {
            arrival = arrivalDate;
        }

    }
    void setDeparture(Date departureDate){
        if(arrival != null) {
            if(departureDate.before(arrival)) {
                departure = departureDate; // Set new departure date if before arrivalU date
            }
        } else {
            departure = departureDate;
        }
    }

    // Define class methods
    long length(){
        if(departure == null || arrival == null){
            return 0;
        }

        return ((arrival.getTime() - departure.getTime())/1000)/60;
    }
}
