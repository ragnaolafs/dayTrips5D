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
 *
 * @author ragna
 */
public class DatabaseController {

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
    
    
    
    private ArrayList<String> stringToArrayList(String s) {
        String[] split = s.split(", ");
        ArrayList<String> splitList = new ArrayList<String>();
        for (int i = 0; i < split.length; i++) {
            splitList.add(split[i]);
        }
        return splitList;
    }
    
    
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
    
    
    public ArrayList<Trip> search(String q) {
        
        String searchQuery = "SELECT * FROM Trips WHERE nameOfTrip LIKE '%" + q + 
                "%' COLLATE NOCASE OR description LIKE '%" + q + "%' COLLATE NOCASE"; // '%q%'
        
        ArrayList<Trip> tripList = helperSearch(searchQuery);
        
        return tripList;
    }
    
    
    public ArrayList<Trip> searchLocation(ArrayList<String> locations) {
        
        String q = "SELECT * FROM Trips WHERE location = '" + locations.get(0) + "'";
        
        for (int i = 1; i < locations.size(); i++) {
            q += "AND location = '" + locations.get(i) + "'";
        }
        
        ArrayList<Trip> tripList = helperSearch(q);
        
        return tripList;
    }
    
    
    public ArrayList<Trip> searchPrice(int lower, int higher) {
        
        String q = "SELECT * FROM Trips WHERE price > " + lower + 
                " AND price < " + higher;
        
        ArrayList<Trip> tripList = helperSearch(q);
        
        return tripList;
    }
    
    
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
        
        //String q = "SELECT * FROM Trips WHERE dates = '" + dateTo + "'":
        
        //ArrayList<Trip> tripList = helperSearch(q);
        
        return tripMatches;
    }
            
            
    public ArrayList<Trip> getTripList() {       

        String q = "SELECT * FROM Trips";
        
        ArrayList<Trip> tripList = helperSearch(q);

        return tripList;
    }
    
    // asdf útfæra föll sem ráða við ef einhvern dálk vantar löglega í töfluna
    public void insertTrip(ArrayList<String> dates, String time, String nameOfTrip, 
            String description, int price, ArrayList<String> types, String duration,
            int capacity, boolean soldOut, String location, String host) {
        
   // asdf breyta host í hostlogin!!!
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        String datesString = "";
        for (int i = 0; i < dates.size()-1; i++) {
            datesString += dates.get(i) + ", ";
        }
        // add last date without comma afterwards
        datesString += dates.get(dates.size()-1); 
        
        String typesString = "";
        for (int i = 0; i < types.size()-1; i++) {
            typesString += types.get(i) + ", ";
        }
        // add last date without comma afterwards
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
     * This method updates the Bookings table.
     * If 
     * @param contactName
     * @param date
     * @param contactEmail
     * @param pax
     * @param trip
     * @param contactPhoneNo 
     */
    public void insertBooking(String contactName, String date, String contactEmail, 
                    int pax, Trip trip, String contactPhoneNo){
        
        DatabaseConnection dbConn = new DatabaseConnection();
        
        System.out.println("insert into Booking");
        String q = "INSERT INTO Bookings (contactName, date, contactEmail, " +
                "pax, trip, contactPhoneNo) VALUES ('" 
                + contactName + "', '" 
                + date + "', '" 
                + contactEmail + "', '" 
                + pax + "', " 
                + trip + ", '" 
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
    
    public static void main(String args[]) {
        ArrayList<String> dates = new ArrayList<String>();
        dates.add("2.2.19");
        ArrayList<String> types = new ArrayList<String>();
        types.add("skemmtileg");
        
        //insertTrip(dates, "12:00", "Ferd", "skemmtileg", 2000, types, "6 timar",
        //        30, false, "Akureyri", "Hugrún");
        
        DatabaseController dbController = new DatabaseController();
        
        /*ArrayList<Trip> location = dbController.searchDate("2.2.19");
        for (int i = 0; i < location.size(); i++) {
            System.out.println(location.get(i).getTripID());
        }*/
    }
}
