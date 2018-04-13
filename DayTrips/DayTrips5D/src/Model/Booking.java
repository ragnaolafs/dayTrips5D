/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseController;
import View.BookingView;
/**
 *
 * @author ragna
 */

public class Booking {
    private BookingView bView = new BookingView();
    private String name = bView.getName();
    private String date = bView.getDate();
    private String email = bView.getEmail();
    private int pax = bView.getPax();
    private Trip trip = bView.getTrip();
    private String phoneNo = bView.getPhoneNo();
    private DatabaseController databaseController = new DatabaseController();

    public void bookTrip() {
        databaseController.insertBooking(name, date, email, pax, trip, phoneNo);
    }
    public void updateTripCapacity() {
        trip.setCapacity(trip.getCapacity()-pax);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}

