/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseController;
import java.util.ArrayList;
/**
 *
 * @author ragna
 */

public class Booking {



    public static void bookTrip(String name, String date, String email, int pax, int tripID, String phoneNo) {
        DatabaseController dbctr = new DatabaseController();
        dbctr.insertBooking(name, date, email, pax, tripID, phoneNo);
    }
    public static void updateTripCapacity(int pax, int tripID) {
        DatabaseController dbctr = new DatabaseController();
        dbctr.updateTripCapacity(tripID, pax);


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }



}

