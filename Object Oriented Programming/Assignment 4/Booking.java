import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Booking {

    String date = "MM/dd/yyyy";
    String time = "HH:mm";
    DateFormat df = new SimpleDateFormat(date);
    DateFormat tf = new SimpleDateFormat(time);
    private int id;
    private int noOfPassengers;
    private String startingLocation;
    private String destination;
    private Date DateOfDeparture;
    private Date TimeOfDeparture;
    private Date DateOfArrival;
    private Date TimeOfArrival;
    private float fare;
    public Booking(Trip trip, int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
        this.startingLocation = trip.getStartingLocation();
        this.destination = trip.getDestination();
        this.DateOfDeparture = trip.getDateOfDeparture();
        this.TimeOfDeparture = trip.getTimeOfDeparture();
        this.DateOfArrival = trip.getDateOfArrival();
        this.TimeOfArrival = trip.getTimeOfArrival();
        this.fare = trip.getFare();
        this.id = trip.getId();


    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public int getId() {
        return id;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDateOfDeparture() {
        return DateOfDeparture;
    }

    public Date getTimeOfDeparture() {
        return TimeOfDeparture;
    }

    public Date getDateOfArrival() {
        return DateOfArrival;
    }

    public Date getTimeOfArrival() {
        return TimeOfArrival;
    }

    public float getFare() {
        return fare;
    }

    public String ToString() {
        return (String.format("%d %s %s %s %s %s %s %d %.2f\n", noOfPassengers, destination, df.format(DateOfDeparture),
                tf.format(TimeOfDeparture), df.format(DateOfArrival), tf.format(TimeOfArrival), id, fare));
    }

}
