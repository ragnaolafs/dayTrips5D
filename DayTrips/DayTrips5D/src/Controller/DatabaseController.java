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
    
    private static ArrayList<String> stringToArrayList(String s) {
        String[] split = s.split(", ");
        ArrayList<String> splitList = new ArrayList<String>();
        for (int i = 0; i < split.length; i++) {
            splitList.add(split[i]);
        }
        return splitList;
    }
    
    
    private static ArrayList<Trip> helperSearch(String q) {
        ArrayList<Trip> tripList = new ArrayList<Trip>();
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        try {
            ResultSet rs = dbConn.select(q);
            Trip trip;

            while (rs.next()) {
                String dates = rs.getString("dates");
                String types = rs.getString("types");
                ArrayList<String> datesList = stringToArrayList(dates);
                ArrayList<String> typesList = stringToArrayList(dates);
                
                trip = new Trip(rs.getInt("tripID"), datesList, 
                        rs.getString("time"), rs.getString("nameOfTrip"), 
                        rs.getString("description"), rs.getInt("price"), 
                        typesList, rs.getString("duration"), 
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
    
    
    public static ArrayList<Trip> search(String q) {
        
        String searchQuery = "SELECT * FROM Trips WHERE nameOfTrip LIKE '%" + q + 
                "%' COLLATE NOCASE OR description LIKE '%" + q + "%' COLLATE NOCASE"; // '%q%'
        
        ArrayList<Trip> tripList = helperSearch(searchQuery);
        
        return tripList;
    }
    
    
    public static ArrayList<Trip> searchLocation(String location) {
        
        String q = "SELECT * FROM Trips WHERE location = '" + location + "'";
        
        ArrayList<Trip> tripList = helperSearch(q);
        
        return tripList;
    }
    
    
    public static ArrayList<Trip> searchPrice(int lower, int higher) {
        
        String q = "SELECT * FROM Trips WHERE price > " + lower + 
                " AND price < " + higher;
        
        ArrayList<Trip> tripList = helperSearch(q);
        
        return tripList;
    }
    
    
    public static ArrayList<Trip> searchDate(String date) {
        
        String q = "SELECT * FROM Trips WHERE location = '" + date + "'";
        
        ArrayList<Trip> tripList = helperSearch(q);
        
        return tripList;
    }
            
            
    public static ArrayList<Trip> getTripList() {       

        String q = "SELECT * FROM Trips";
        
        ArrayList<Trip> tripList = helperSearch(q);

        return tripList;
    }
    
    public static void main(String args[]) {
        
    }
}
