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
    String getName(){ return "";}
    ArrayList<Flight> getFlights(){
        return flights;
    }

    // Define class methods
    void addFlight(Flight flight){
        if(flights.isEmpty()) {
            flights.add(flight);
        } else {
            boolean overlap = false;
            int n = flights.size();
            int i = n - 1;

            while(i >= 0 && !overlap) {
                Flight prevFlight = flights.get(i);

                if(flight.getDeparture().after(prevFlight.getArrival())) {
                    if(!flights.contains(flight)) {
                        flights.add(flight);
                    }
                } else if(flight.getDeparture().before(prevFlight.getDeparture()) && flight.getArrival().before(prevFlight.getDeparture())) {
                    if(flights.contains(flight)){
                        flights.remove(flight);
                    }

                    flights.add(i, flight);
                } else {
                    overlap = true;
                    flights.remove(flight);
                }

                i--;
            }
        }
    }

    long getTotalLayover(){
        return 0;
    }
}
