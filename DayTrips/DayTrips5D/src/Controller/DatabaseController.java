/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Trip;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ragna
 */
public class DatabaseController {
    
    public static ArrayList<Trip> search(String q) {
        ArrayList<Trip> tripList = new ArrayList<Trip>();
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        String searchQuery = "SELECT * FROM Trips WHERE nameOfTrip LIKE '%" + q + "%'"; // '%q%'
        
        try {
            // asdf útfæra streng betur!!!
            ResultSet rs = dbConn.select(searchQuery);
            Trip trip;

            while (rs.next()) {
                trip = new Trip(rs.getInt("tripID"), rs.getString("dates"), 
                        rs.getString("time"), rs.getString("nameOfTrip"), 
                        rs.getString("description"), rs.getString("price"), 
                        rs.getString("types"), rs.getString("duration"), 
                        rs.getInt("capacity"), rs.getBoolean("soldOut"), 
                        rs.getString("location"));
                
                tripList.add(trip);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            dbConn.closeConnection();
        }
        
        return tripList;
    }
            
            
    public static ArrayList<Trip> getTripList() {
        ArrayList<Trip> tripList = new ArrayList<Trip>();
        
        DatabaseConnection dbConn = new DatabaseConnection();

        String q = "SELECT * FROM Trips";
        
        try {
            ResultSet rs = dbConn.select(q);
            Trip trip;

            while (rs.next()) {
                trip = new Trip(rs.getInt("tripID"), rs.getString("dates"), 
                        rs.getString("time"), rs.getString("nameOfTrip"), 
                        rs.getString("description"), rs.getString("price"), 
                        rs.getString("types"), rs.getString("duration"), 
                        rs.getInt("capacity"), rs.getBoolean("soldOut"), 
                        rs.getString("location"));
                
                tripList.add(trip);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            dbConn.closeConnection();
        }

        return tripList;
    }
    
    public static void main(String args[]) {
        
    }
}
