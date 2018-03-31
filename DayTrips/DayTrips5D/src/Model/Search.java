/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * This class searches the database for trips whose location, time/date, 
 * name, description, price, type and duration fall within the conditions
 * selected/specified by the user through the GUI. 
 * Search first searches the database for trips having the desired locations 
 * and gives an ArrayList<Trip> with the results. The following search methods 
 * then each search the results of their forerunning ArrayList<Trip> objects in 
 * a cascading manner until the last method delivers the final result of the 
 * search.
 * @author karen
 */
public class Search {
    
    private ArrayList<String> type;
    private int priceRange;
    private int priceHigher;
    private String location;
    private String keyword;
    private String duration;
    private String[] dates;
    
    // Order: Location, price, string(if empty then return input),
    // date, time, type, duration
   
    /**
    * Looks for trips placed in locations selected by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    public ArrayList<Trip> searchLocations(String checkboxes){ // breyta inntaki eitthað asdf
        ArrayList<Trip> result = new ArrayList();
        // iterate through checkboxes and push their true (checked)
        // values into an ArrayList, which is then returned.
        return result;
    }
    
    /**
    * Looks for trips within the timeframe specified by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    public ArrayList<Trip> searchPrices(int lower, int higher){
        ArrayList<Trip> result = searchLocations();
        return result;
    }
    
    /**
    * Looks for trips within the timeframe specified by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    public ArrayList<Trip> searchDates(){
        ArrayList<Trip> result = new ArrayList();
           
        return result;
    }
    
    /**
    * Looks for the given string in title and description of all trips
    * and returns ArrayList<Trip> with the results.
    **/
    public ArrayList<Trip> searchStrings(String string) {
       ArrayList<Trip> searchResult = new ArrayList();
       searchResult = DatabaseController.search(string); 
       // return DatabaseController.search(string); 
       // Maybe the first two lines are more descriptive?
       return searchResult;
    }
}
