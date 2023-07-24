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
        return null;
    }

    // Define class methods
    void addFlight(Flight flight){

    }

    long getTotalLayover(){
        return 0;
    }
}
