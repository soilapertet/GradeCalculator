package oosequence;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Itinerary {
    // Define instance variables
    private ArrayList<TripComponent> flights;
    private String name;

    // Define constructor
    public Itinerary(String name){
        flights = new ArrayList<>();
        this.name = name;
    }

    // Define getter and setter methods
    String getName(){ return name;}
    ArrayList<TripComponent> getFlights(){
        return flights;
    }

    // Define class methods
    void addFlight(TripComponent flight){
        if(flights.isEmpty()) {
            flights.add(flight);
        } else {
            boolean overlap = false;
            int n = flights.size();
            int i = n - 1;

            while(i >= 0 && !overlap) {
                TripComponent prevFlight = flights.get(i);

                if(flight.getEnd().after(prevFlight.getStart())) {
                    if(!flights.contains(flight)) {
                        flights.add(flight);
                    }
                } else if(flight.getEnd().before(prevFlight.getEnd()) && flight.getStart().before(prevFlight.getEnd())) {
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
        if(flights.size() == 1 || flights.size() == 0){
            return 0;
        }

        long totalLayover = 0;

        for(int i = 0; i < flights.size(); i++) {

            if(i == flights.size() - 1){
                return totalLayover;
            }

            Date arrivalTime = flights.get(i).getStart();
            Date departureTime = flights.get(i + 1).getEnd();

            totalLayover += TimeUnit.MILLISECONDS.toMinutes(departureTime.getTime() - arrivalTime.getTime());
        }

        return totalLayover;
    }
}
