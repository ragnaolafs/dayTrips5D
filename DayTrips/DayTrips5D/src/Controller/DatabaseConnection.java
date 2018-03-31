/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Trip;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ragna
 */
public class DatabaseConnection {
	

	Connection connection = null;
	Statement stmt = null;
	ResultSet r = null;
	
	public DatabaseConnection() {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:dayTripsDB.db");
                stmt = connection.createStatement();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
	}
        
        
        public void insert(String insertValues) {
            try {
                stmt.executeUpdate(insertValues);
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        
        public void delete(String deleteValues) {
            try {
                stmt.executeUpdate(deleteValues);
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        
        public ResultSet select(String selectQuery) {
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery(selectQuery);
                
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            return rs;
        }
        
        
        
        public ArrayList<Trip> getTripList() {
            ArrayList<Trip> tripList = new ArrayList<Trip>();
            
            String q = "SELECT * FROM Trips";
            
            ResultSet rs = null;
            
            Trip trip;
            
            return tripList;
        }
	
	public static void main(String[] args) {
		
	}

}
