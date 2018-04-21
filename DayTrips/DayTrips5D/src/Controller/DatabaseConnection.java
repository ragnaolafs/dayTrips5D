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
 * Class connecting to database. Calls and updates database with commands
 * as parameters to functions.
 * @author Ragna Ólafsdóttir, rao9@hi.is
 * @author Hugrún Guðmundsdóttir, hug17@hi.is
 * @author Karen Ósk Pétursdóttir, kop1@hi.is
 */
public class DatabaseConnection {
	

	Connection connection = null;
	Statement stmt = null;
	ResultSet r = null;
	
        /**
         * Constructor creates a connection to the database with SQLite JDBC.
         */
	public DatabaseConnection() {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:dayTripsDB.db");
                stmt = connection.createStatement();
            }
            catch (Exception e) {
                System.out.println(e);
            }
	}
        
        /**
         * Updates database with insert command. Throws SQLException.
         * @param insertValues - String with full SQLite command
         */
        public void insert(String insertValues) {
            try {
                System.out.println(insertValues);
                stmt.executeUpdate(insertValues);
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        /**
         * Updates database with delete command. Throws SQLException.
         * @param deleteValues - String with full SQLite command
         */
        public void delete(String deleteValues) {
            try {
                stmt.executeUpdate(deleteValues);
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        /**
         * Updates database with update command. Throws SQLException.
         * @param updateValues - String with full SQLite command
         */
        public void update(String updateValues) {
            try {
                System.out.println(updateValues);
                stmt.executeUpdate(updateValues);
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        
        /**
         * Calls database with select query. Throws SQLException.
         * @param selectQuery - String with full SQLite command
         * @return - ResulSet with result from select command
         */
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
        
        
        /**
         * Closes database connection. Throws SQLException.
         */
        public void closeConnection() {
            try {
                if(connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
	
	public static void main(String[] args) {

	}

}
