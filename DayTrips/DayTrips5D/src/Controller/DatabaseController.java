/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HostLogin;
import Model.Trip;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Calls database connection with right SQLite commands according to  
 * parameter values in functions.
 * @author Ragna Ólafsdóttir, rao9@hi.is
 * @author Hugrún Guðmundsdóttir, hug17@hi.is
 * @author Karen Ósk Pétursdóttir, kop1@hi.is
 */
public class DatabaseController {

    /**
     * Creates an insert command to create a new user in Hosts relation in 
     * database.
     * @param fullname String - full name of new user
     * @param username String - username for new user
     * @param password String - password for new user
     */
    public void createNewUser(String fullname, String username, String password) {
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        String q = "INSERT INTO Hosts (fullname, username, password) VALUES ('" 
                + fullname + "', '" + username + "', '" + password + "')";
        
        try {
            dbConn.insert(q);
        }
        catch (Exception e) {
            
            System.err.println(e.getMessage());
        }
        finally {
            dbConn.closeConnection();
        }
    }

    /**
     * Selects all values from relation Hosts in database and checks if
     * username and password parameters match some user in database.
     * @param username String - username to check
     * @param password String - password to check
     * @return boolean value - true if username and password match a user in
     * the database, false otherwise.
     */
    public boolean login(String username, String password) {
        ArrayList<HostLogin> hostsList = new ArrayList<HostLogin>();
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        String q = "SELECT * FROM Hosts";
        try {
            ResultSet rs = dbConn.select(q);
            HostLogin host;
            
            while (rs.next()) {
                String fullnameHost = rs.getString("fullname");
                String usernameHost = rs.getString("username");
                String passwordHost = rs.getString("password");
                
                host = new HostLogin(fullnameHost, usernameHost, passwordHost);
                
                hostsList.add(host);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            dbConn.closeConnection();
        }
        
        for (int i = 0; i < hostsList.size(); i++) {
            HostLogin host = hostsList.get(i);
            if (host.getUsername().equals(username) && host.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Splits values, seperated by ",", in String to ArrayList.
     * @param s String to split into array list
     * @return Arraylist of split string
     */
    private ArrayList<String> stringToArrayList(String s) {
        String[] split = s.split(", ");
        ArrayList<String> splitList = new ArrayList<String>();
        for (int i = 0; i < split.length; i++) {
            splitList.add(split[i]);
        }
        return splitList;
    }
    
    /**
     * Calls database with select query according to search string.
     * Makes Trip objects from result and puts them in ArrayList.
     * @param q String - SQLite search query
     * @return ArrayList of Trip objects matching search query
     */
    private ArrayList<Trip> helperSearch(String q) {
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
    
    /**
     * Creates a select query to search for trips with the parameter String
     * matching part of name or description of trip.
     * @param q String value to search for in names and descriptions of trips
     * @return ArrayList of Trip objects matching search query
     */
    public ArrayList<Trip> search(String q) {
        
        String searchQuery = "SELECT * FROM Trips WHERE nameOfTrip LIKE '%" + q + 
                "%' COLLATE NOCASE OR description LIKE '%" + q + "%' COLLATE NOCASE"; // '%q%'
        
        ArrayList<Trip> tripList = helperSearch(searchQuery);
        
        return tripList;
    }
    
    /**
     * Creates a select query to search for trips according to location.
     * @param locations ArrayList of String of locations to search for
     * @return ArrayList of Trip objects matching search query
     */
    public ArrayList<Trip> searchLocation(ArrayList<String> locations) {
        
        String q = "SELECT * FROM Trips WHERE location = '" + locations.get(0) + "'";
        
        for (int i = 1; i < locations.size(); i++) {
            q += "AND location = '" + locations.get(i) + "'";
        }
        
        ArrayList<Trip> tripList = helperSearch(q);
        
        return tripList;
    }
    
    /**
     * Creates a select query to search for trips in a given price range.
     * @param lower int - lower bound of price range
     * @param higher int - upper bound of price range
     * @return ArrayList of Trip objects matching search query
     */
    public ArrayList<Trip> searchPrice(int lower, int higher) {
        
        String q = "SELECT * FROM Trips WHERE price > " + lower + 
                " AND price < " + higher;
        
        ArrayList<Trip> tripList = helperSearch(q);
        
        return tripList;
    }
    
    /**
     * Searches for trips between to dates.
     * @param dateFrom 
     * @param dateTo
     * @return ArrayList of Trip objects with a date between dateFrom and dateTo
     * @throws ParseException 
     */
    public ArrayList<Trip> searchDate(String dateFrom, String dateTo) throws ParseException {
        
        SimpleDateFormat from = new SimpleDateFormat(dateFrom);
        SimpleDateFormat to = new SimpleDateFormat(dateTo);
        
        Date fromD = from.parse(dateFrom);
        Date toD = from.parse(dateTo);
        
        ArrayList<Trip> allTrips = getTripList();
        ArrayList<Trip> tripMatches = new ArrayList<Trip>();
        
        for (int i = 0; i < allTrips.size(); i++) {
            ArrayList<String> dates = allTrips.get(i).getDates();
            
            for (int j = 0; j < dates.size(); j++) {
                SimpleDateFormat tripDate = new SimpleDateFormat(dates.get(j));
                Date tripD = tripDate.parse(dates.get(j));
                
                if ((tripD.after(fromD) || tripD.equals(fromD)) && 
                        (tripD.before(toD) || tripD.equals(toD))) {
                    tripMatches.add(allTrips.get(i));
                    break;
                }
            }
        }
        return tripMatches;
    }
            
    
    /**
     * Creates a select query to get all trips form Trips relation in database.
     * @return ArrayList of Trip objectes - all trips in Trips relation
     */
    public ArrayList<Trip> getTripList() {       

        String q = "SELECT * FROM Trips";
        
        ArrayList<Trip> tripList = helperSearch(q);

        return tripList;
    }
    
    /**
     * Updates capacity value in Trips relation for the trip matching tripID.
     * @param tripID int - ID of trip to update capacity for
     * @param newCapacity int - new value of capacity for trip
     */
    public void updateTripCapacity(int tripID, int newCapacity) {
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        String q = "UPDATE Trips SET capacity = " + newCapacity + " WHERE tripID = " + tripID;
        
        try {
            dbConn.update(q);
        }
        catch (Exception e) {
            
            System.err.println(e.getMessage());
        }
        finally {
            dbConn.closeConnection();
        }
    }
    
    /**
     * Creates a command to insert a new trip to the Trips relation in database.
     * @param dates 
     * @param time 
     * @param nameOfTrip
     * @param description
     * @param price
     * @param types
     * @param duration
     * @param capacity
     * @param soldOut
     * @param location
     * @param host 
     */
    public void insertTrip(ArrayList<String> dates, String time, String nameOfTrip, 
            String description, int price, ArrayList<String> types, String duration,
            int capacity, boolean soldOut, String location, String host) {
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        String datesString = "";
        for (int i = 0; i < dates.size()-1; i++) {
            datesString += dates.get(i) + ", ";
        }
        // Add last date without comma afterwards
        datesString += dates.get(dates.size()-1); 
        
        String typesString = "";
        for (int i = 0; i < types.size()-1; i++) {
            typesString += types.get(i) + ", ";
        }
        // Add last type without comma afterwards
        typesString += types.get(types.size()-1);
        
        int soldOutInt = 0;
        if (soldOut) {
            soldOutInt = 1;
        }
        System.out.println("insert");
        String q = "INSERT INTO Trips (dates, time, nameOfTrip, description, " +
                "price, types, duration, capacity, soldOut, location, host) VALUES ('" 
                + datesString + "', '" 
                + time + "', '" 
                + nameOfTrip + "', '" 
                + description + "', " 
                + price + ", '" 
                + typesString + "', '" 
                + duration + "', " 
                + capacity + ", " 
                + soldOutInt + ", '" 
                + location + "', '" 
                + host + "')";
        System.out.println(q);
        try {
            dbConn.insert(q);
        }
        catch (Exception e) {
            
            System.err.println(e.getMessage());
        }
        finally {
            dbConn.closeConnection();
        }
    }
    
    /**
     * Creates a command to insert new booking in Bookings relation in database.
     * @param contactName String - name of contact booking the trip
     * @param date String - date of trip to book
     * @param contactEmail String - e-mail for contact booking the trip
     * @param pax int - number of passengers for this booking
     * @param tripID int - ID of trip to book
     * @param contactPhoneNo String - phonenumber for contact booking the trip
     */
    public void insertBooking(String contactName, String date, String contactEmail, 
                    int pax, int tripID, String contactPhoneNo){
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        System.out.println("insert into Booking");
        String q = "INSERT INTO Bookings (contactName, date, contactEmail, " +
                "pax, tripID, contactPhoneNo) VALUES ('" 
                + contactName + "', '" 
                + date + "', '" 
                + contactEmail + "', '" 
                + pax + "', " 
                + tripID + ", '" 
                + contactPhoneNo + "')";
        System.out.println(q);
        try {
            dbConn.insert(q);
        }
        catch (Exception e) {
            
            System.err.println(e.getMessage());
        }
        finally {
            dbConn.closeConnection();
        }
    }
}
