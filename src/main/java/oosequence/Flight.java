package oosequence;

public class Flight extends TripComponent{
    private String departureAirport;
    private String arrivalAirport;

    public String getDepartureAirport(){
        return departureAirport;
    }

    public String getArrivalAirport(){
        return arrivalAirport;
    }

    public void setDepartureAirport(String airport){
        departureAirport = airport;
    }

    public void setArrivalAirport(String airport){
        arrivalAirport = airport;
    }

    public String getDuration(){
        return "";
    }
}
