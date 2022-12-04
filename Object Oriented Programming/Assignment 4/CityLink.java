import java.util.ArrayList;

public class CityLink implements Vendor {

    Trip trip1 = new Trip();
    Trip trip2 = new Trip();
    private ArrayList<Trip> availableTrips = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    // initialise hardcoded trips
    public void initTrips() {
        trip1.setTrip("Dublin", "Wexford", "20/11/2022", "15:00",
                "20/11/2022", "18:00", 4002, 7.50F);


        trip2.setTrip("Dundalk", "Dublin", "22/11/2022", "10:00",
                "22/11/2022", "13:00", 4004, 6.50F);

        addTrip(trip1);
        addTrip(trip2);
    }

    public void addTrip(Trip t) {
        availableTrips.add(t);
    }

    public Trip getTrip(int index) {
        return (availableTrips.get(index));
    }

    public void getAllAvailableTrips() {
        for (Trip i : availableTrips) {
            System.out.printf(i.toString());
        }
    }

    public int sumPassengers(int id) {
        int numPassengers = 0;

        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                numPassengers += booking.getNoOfPassengers();
            }
        }
        return numPassengers;
    }


    public Boolean makeBooking(Booking b) {
        // sum up total booked passengers for trip, if less than capacity then return false

        // get trip that corresponds to booking

        Trip trip;
        int passengerSum = sumPassengers(b.getId());

        for (int i = 0; i < availableTrips.size(); i++) {
            if (availableTrips.get(i).getId() == b.getId()) {
                trip = availableTrips.get(i);

                if (passengerSum + b.getNoOfPassengers() <= trip.getAvailableSeats()) {
                    // add booking
                    bookings.add(b);

                    // update amount of seats
                    trip.setAvailableSeats(56 - passengerSum);
                    return true;
                }
            }
        }
        return false;
    }
}
