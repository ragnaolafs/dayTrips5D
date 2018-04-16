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
    private String name;
    private String date;
    private String email;
    public int pax;
    private int tripID;
    private String phoneNo;
    
    public Booking(String name, String date, String email, int pax, int tripID, String phoneNo){
        this.name=name;
        this.date=date;
        this.email=email;
        this.pax=pax;
        this.tripID=tripID;
        this.phoneNo=phoneNo;
        
    }


    public void bookTrip(String name, String date, String email, int pax, int tripID, String phoneNo) {
        DatabaseController dbctr = new DatabaseController();
        dbctr.insertBooking(name, date, email, pax, tripID, phoneNo);
    }
    public void updateTripCapacity(int pax, int tripID) {
        DatabaseController dbctr = new DatabaseController();
        dbctr.updateTripCapacity(tripID, pax);


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }



}

