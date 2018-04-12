/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ragna
 */

public class Booking {
    private String name = "";
    private Date date;
    private String ssn ="";
    private String email ="";
    private int pax = 0;
    // tripID =""; setja sem hlut af klasa - gagnagrunnur sér um þetta
    private Trip trip;
    private String phoneNo ="";

    public static void insertIntoDB(String name, Date date,String email, 
                                                                    int pax, Trip trip, String phoneNo) {

    }
    public static void updateTripCapacity(String tripID, int pax, Date date) {

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}

