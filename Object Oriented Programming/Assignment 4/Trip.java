import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Trip {


    String date = "dd/MM/yyyy";
    String time = "HH:mm";
    SimpleDateFormat df = new SimpleDateFormat(date);
    SimpleDateFormat tf = new SimpleDateFormat(time);
    private int id;
    private String startingLocation;
    private String destination;
    private Date DateOfDeparture;
    private Date TimeOfDeparture;
    private Date DateOfArrival;
    private Date TimeOfArrival;
    private float fare;
    private int availableSeats = 56; // arbitrary available seat number (assumes standardised buses across vendors)

    public void setTrip(String startingLocation, String destination, String DoD, String ToD,
                        String DoA, String ToA, int id, float fare) {

        this.startingLocation = startingLocation;
        this.destination = destination;
        this.id = id;
        this.fare = fare;

        try {
            this.DateOfDeparture = df.parse(DoD);
            this.TimeOfDeparture = tf.parse(ToD);
            this.DateOfArrival = df.parse(DoA);
            this.TimeOfArrival = tf.parse(ToA);
        } catch (java.text.ParseException e) {
            System.out.println("Parsing error");
            e.printStackTrace();
        }

    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
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

    public int getId() {
        return id;
    }

    public String toString() {
        return (String.format("[%s-%s] %s %s %s %s [%d] €%.2f\n", startingLocation, destination, df.format(DateOfDeparture),
                tf.format(TimeOfDeparture), df.format(DateOfArrival), tf.format(TimeOfArrival), id, fare));
    }

}
