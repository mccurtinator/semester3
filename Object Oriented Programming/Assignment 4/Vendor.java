import java.util.ArrayList;

public interface Vendor {
    public void addTrip(Trip t);

    public void getAllAvailableTrips();

    public Boolean makeBooking(Booking b);
}
