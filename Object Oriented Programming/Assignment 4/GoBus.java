import java.util.ArrayList;

public class GoBus implements Vendor {

    Trip trip1 = new Trip();
    Trip trip2 = new Trip();
    private ArrayList<Trip> availableTrips = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    // initialise hardcoded trips
    public void initTrips() {
        trip1.setTrip("Donegal", "Sligo", "20/11/2022", "11:00",
                "20/11/2022", "13:00", 2004, 7.50F);


        trip2.setTrip("Cork", "Limerick", "22/11/2022", "12:00",
                "22/11/2022", "15:00", 2006, 6.50F);

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
