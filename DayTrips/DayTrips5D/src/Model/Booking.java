/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ragna
 */

public class Booking {
	private String name = "";
	private String date ="";
	private String ssn ="";
	private String email ="";
	private int pax = 0;
	// tripID =""; setja sem hlut af klasa - gagnagrunnur sér um þetta
	private String phoneNo ="";
	
	public static void insertIntoDB(String name, String date,String ssn,String email, 
									int pax, String tripID, String phoneNo) {
		
	}
	public static void updateTripCapacity(String tripID, int pax, String date) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

