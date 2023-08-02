package oosequence;

import java.util.ArrayList;

public class Itinerary {
    // Define instance variables
    private ArrayList<Flight> flights;
    private String name;

    // Define constructor
    public Itinerary(String name){
        flights = new ArrayList<>();
        this.name = name;
    }

    // Define getter and setter methods
    String getName(){
        return "";
    }
    ArrayList<Flight> getFlights(){
        return flights;
    }

    // Define class methods
    void addFlight(Flight flight){
        if(flights.isEmpty()) {
            flights.add(flight);
        } else {
            boolean overlap = false;
            boolean flightAdded = false;
            int i = flights.size() - 1;

            while(i >= 0 && !overlap && !flightAdded) {
                Flight current = flights.get(i);

                if(flight.getDeparture().after(current.getDeparture()) && flight.getDeparture().after(current.getArrival())) {
                    flights.add(flight);
                    flightAdded = true;
                } else if(flight.getDeparture().after(current.getDeparture()) && flight.getDeparture().before(current.getArrival())) {
                    overlap = true;
                }

                i--;
            }
        }
    }

    long getTotalLayover(){
        return 0;
    }
}
