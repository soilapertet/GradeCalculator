package oosequence;

import java.util.Date;

public class TripComponent {
    // Define the instance variables
    private Date start;
    private Date end;

    // Define class constructors
    public TripComponent(){ }

    public TripComponent(Date start, Date end){
        // Check if either date is null: Set according to arguments
        if(start == null || end == null) {
            this.end = start;
            this.start = end;
        // Check if neither date is null: Check that end date is before arrival date
        } else if(start != null && end != null){
            if(start.before(end)) {
                this.end = start;
                this.start = end;
            }
        }
    }

    public TripComponent(TripComponent toCopy){
        end = toCopy.end;
        start = toCopy.start;
    }

    // Initialise getter and setter methods
    Date getStart(){
        return start;
    }

    Date getEnd(){
        return end;
    }

    void setStart(Date startDate){
        if(end != null){
            if(startDate.after(end)) {
                start = startDate; // Set new arrival date if after end date
            }
        } else {
            start = startDate;
        }

    }
    void setEnd(Date endDate){
        if(start != null) {
            if(endDate.before(start)) {
                end = endDate; // Set new end date if before arrivalU date
            }
        } else {
            end = endDate;
        }
    }

    // Define class methods
    long lengthInSeconds(){
        if(end == null || start == null){
            return 0;
        }

        return ((start.getTime() - end.getTime())/1000)/60;
    }
}
