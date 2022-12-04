public class Travel_Ireland {

    public static void main(String[] args) {
        scenario1();
    }


    public static void scenario1() {

        // Scenario 1: Booking trips from all 3 vendors (2 valid and 1 invalid)

        BusEireann be = new BusEireann();
        CityLink cl = new CityLink();
        GoBus gb = new GoBus();

        be.initTrips();
        cl.initTrips();
        gb.initTrips();

        System.out.println("List of available trips:");
        be.getAllAvailableTrips();
        cl.getAllAvailableTrips();
        gb.getAllAvailableTrips();


        Trip selectedTrip = be.getTrip(1);

        Booking booking = new Booking(selectedTrip, 10);
        System.out.printf("\nAttempting to book trip %d with %d passengers.\n", booking.getId(), booking.getNoOfPassengers());

        if (be.makeBooking(booking)) {
            System.out.println("Booking successful.");
            System.out.println("------------");
            System.out.printf("\nNumber of passengers: %d", booking.getNoOfPassengers());
            System.out.printf("\nTraveling from %s to %s", booking.getStartingLocation(), booking.getDestination());
            System.out.printf("\nTrip ID: %d", booking.getId());
            System.out.printf("\nTotal cost: €%.2f", booking.getFare());
            System.out.println("\n----------");

        } else {
            System.out.println("Too many passengers. Booking failed.");
            System.out.println("------------");
        }

        System.out.println("List of available trips:");
        be.getAllAvailableTrips();
        cl.getAllAvailableTrips();
        gb.getAllAvailableTrips();

        Trip selectedTrip2 = cl.getTrip(1);

        Booking booking2 = new Booking(selectedTrip2, 10);
        System.out.printf("\nAttempting to book trip %d with %d passengers.\n", booking2.getId(), booking2.getNoOfPassengers());

        if (cl.makeBooking(booking2)) {
            System.out.println("Booking successful.");
            System.out.println("------------");
            System.out.printf("\nNumber of passengers: %d", booking2.getNoOfPassengers());
            System.out.printf("\nTraveling from %s to %s", booking.getStartingLocation(), booking2.getDestination());
            System.out.printf("\nTrip ID: %d", booking2.getId());
            System.out.printf("\nTotal cost: €%.2f", booking2.getFare());
            System.out.println("\n----------");

        } else {
            System.out.println("Too many passengers. Booking failed.");
            System.out.println("------------");
        }

        System.out.println("List of available trips:");
        be.getAllAvailableTrips();
        cl.getAllAvailableTrips();
        gb.getAllAvailableTrips();

        Trip selectedTrip3 = gb.getTrip(1);

        Booking booking3 = new Booking(selectedTrip2, 58);
        System.out.printf("\nAttempting to book trip %d with %d passengers.\n", booking3.getId(), booking3.getNoOfPassengers());

        if (cl.makeBooking(booking3)) {
            System.out.println("Booking successful.");
            System.out.println("------------");
            System.out.printf("\nNumber of passengers: %d", booking3.getNoOfPassengers());
            System.out.printf("\nTraveling from %s to %s", booking.getStartingLocation(), booking3.getDestination());
            System.out.printf("\nTrip ID: %d", booking3.getId());
            System.out.printf("\nTotal cost: €%.2f", booking3.getFare());
            System.out.println("\n----------");

        } else {
            System.out.println("Too many passengers. Booking failed.");
            System.out.println("------------");
        }

    }
}
