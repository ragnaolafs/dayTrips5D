package Model;

import Controller.DatabaseController;

/**
 * This class handles the logic of booking a trip. It handles the booking of 
 * trips and it updates the capacity of trips when bookings are made.
 * @author Ragna Ólafsdóttir, rao9@hi.is
 * @author Hugrún Guðmundsdóttir, hug17@hi.is
 * @author Karen Ósk Pétursdóttir, kop1@hi.is
 */

public class Booking {

    /**
     * This method calls the DatabaseController class and makes it add the
     * trip that is to be booked into the database.
     * @param name
     * @param date
     * @param email
     * @param pax
     * @param tripID
     * @param phoneNo 
     */
    public static void bookTrip(String name, String date, String email, int pax, int tripID, String phoneNo) {
        DatabaseController dbctr = new DatabaseController();
        dbctr.insertBooking(name, date, email, pax, tripID, phoneNo);
    }
    
    /**
     * This method calls the DatabaseController class and makes it update 
     * existing information about the remaining capacity of a newly booked trip.
     * @param pax
     * @param tripID 
     */
    public static void updateTripCapacity(int pax, int tripID) {
        DatabaseController dbctr = new DatabaseController();
        dbctr.updateTripCapacity(tripID, pax);
    }
}
