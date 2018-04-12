/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.TripsView;
import Controller.DatabaseController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JCheckBox;

/**
 * This class can search the database for trips whose location, date, 
 * price, name and description fall within the conditions selected/specified by
 * the user through the GUI. 
 * Each search method returns a container with some properties that 
 * DatabaseController then uses to search for the desired trips.
 * (Search first searches the database for trips having the desired locations 
 * and gives an ArrayList<Trip> with the results. The following search methods 
 * then each search the results of their forerunning ArrayList<Trip> objects in 
 * a cascading manner until the last method delivers the final result of the 
 * search.)
 * @author karen
 */
public class Search {
    
    private String query;
    private String location;
    private int priceHigher;
    private int priceLower;
    private String[] dates; // hmm
    private String keyword;
    private TripsView tripsView = new TripsView();
    private final ArrayList<JCheckBox> checkboxes = tripsView.getCheckboxes();
    private ArrayList<Trip> resultSet;
    private DatabaseController dbController;
    
    
    public Search() {
        dbController = new DatabaseController();
    }
    
    /**
    * Looks for trips placed in locations selected by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchLocations(ArrayList<String> locations, ArrayList<Trip> tripList){

        for (int i = 0; i < tripList.size(); i++) {
            boolean locationMatch = false;
            for (int j = 0; j < locations.size(); j++) {
                if (tripList.get(i).getLocation().equals(locations.get(j))) {
                    locationMatch = true;
                    break;
                }
            }
            // if no selected locations matches trip location then remove it
            if (!locationMatch) {
                tripList.remove(i);
            }
        }
        return tripList;
    }
    
    /**
    * Looks through the list of trips in the desired locations for trips within the price range specified by the user through the
    * GUI, then . and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchPrices(int lower, int higher, ArrayList<Trip> tripList){

        for(int i = 0; i < tripList.size(); i++){
            if(tripList.get(i).getPrice()<lower || tripList.get(i).getPrice()>higher){
                tripList.remove(i);
            }
        }
        return tripList;
    }
    
    /**
    * Looks for trips within the timeframe specified by the user through the
    * GUI and returns 3ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchDates(String dateFrom, String dateTo, ArrayList<Trip> tripList) throws ParseException{
        SimpleDateFormat from = new SimpleDateFormat(dateFrom);
        SimpleDateFormat to = new SimpleDateFormat(dateTo);
        
        Date fromD = from.parse(dateFrom);
        Date toD = from.parse(dateTo);
        
        
        for (int i = 0; i < tripList.size(); i++) {
            ArrayList<String> dates = tripList.get(i).getDates();
            
            boolean dateMatch = false;
            
            for (int j = 0; j < dates.size(); j++) {
                SimpleDateFormat tripDate = new SimpleDateFormat(dates.get(j));
                Date tripD = tripDate.parse(dates.get(j));
                
                if ((tripD.after(fromD) || tripD.equals(fromD)) && 
                        (tripD.before(toD) || tripD.equals(toD))) {
                    dateMatch = true;
                    break;
                }
                if(!dateMatch) {
                    tripList.remove(i);
                }
            }
        }
        return tripList;
    }
    
    
    /**
    * Looks for the given string in title and description of all trips
    * and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchStrings(String string) {
       ArrayList<Trip> searchResult = dbController.search(string); 
       return searchResult;
    }

    
    
    public ArrayList<Trip> search(ArrayList<String> locations, int priceLower,
            int priceHigher, String dateFrom, String dateTo, String searchQuery) throws ParseException {
        // ASDF bæta við type of trip líka!
        ArrayList<Trip> tripList;
        
        if (searchQuery != "") {
            tripList = searchStrings(searchQuery); 
        }
        else {
            tripList = dbController.getTripList();
        }
        
        tripList = searchLocations(locations, tripList); //breytum triplist í þessa niðurst
        tripList = searchPrices(priceLower, priceHigher, tripList);
        tripList = searchDates(dateFrom, dateTo, tripList);
        
        return tripList;
    }

}
