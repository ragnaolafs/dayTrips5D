/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;

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
			
		}
	}
	
	public static void main(String[] args) {
		
	}
}
