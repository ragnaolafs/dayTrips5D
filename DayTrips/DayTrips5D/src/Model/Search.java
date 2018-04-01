/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.TripsView;
import java.util.ArrayList;
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
    private JCheckBox[] checkboxes = [TripsView.jCheckReykjavik];
    // ^til að þetta virki, pulla - hugrún gerði public
    private ArrayList<Trip> resultSet;

    /**
    * Looks for trips placed in locations selected by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchLocations(JCheckBox[] checkboxes){
        ArrayList<JCheckBox> selectedBoxes = new ArrayList();
        ArrayList<Trip> trips = new ArrayList();
        
        for(int i = 0; i < checkboxes.length; i++){
            if(checkboxes[i].isSelected()){
                selectedBoxes.add(checkboxes[i]);
            }
        }
        
        // If no locations are selected, search in all locations.
        if(selectedBoxes.isEmpty()){
            for(int i = 0; i < checkboxes.length; i++){
                selectedBoxes.add(checkboxes[i]);
            }
        }
        
        // Now look through all trips in database and find those in desired
        // locations.
        for(int i = 0; i < selectedBoxes.size(); i++){// fyrir öll völdu boxin asdf
            // locationTrips includes all trips for a location in selectedBoxes
            ArrayList<Trip> locationTrips = new ArrayList();
            locationTrips = DatabaseController.searchLocation(
                    TripsView.selectedBoxes[i].getText());
            
            for(int j = 0; j < locationTrips.size(); j++){
                trips.push(locationTrips[j]);
            }
        }
        return trips;
    }
    
    /**
    * Looks for trips within the timeframe specified by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchPrices(){
        ArrayList<Trip> locations = searchLocations(checkboxes);
        ArrayList<Trip> priceTrips = new ArrayList();
        
        int lower = TripsView.jPriceFrom.getValue();
        int higher = TripsView.jPriceTo.getValue();
        
        for(int i = 0; i < locations.size(); i++){
            
            priceRange.push(DatabaseController.searchPrice(lower, higher))
        }
        
        // leitar í áður fengnum niðurstöðum:
        if(locations.contains(priceRange[i])) {
        return priceRange;
    }
    
    /**
    * Looks for trips within the timeframe specified by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchDates(){
        ArrayList<Trip> dates = new ArrayList();
        TripsView.jDateChooseFrom
        return dates;
    }
    
    // Ef síðasta result skilar null, grípa það og skila e-u
    
    /**
    * Looks for the given string in title and description of all trips
    * and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchStrings(String string) {
       ArrayList<Trip> searchResult = new ArrayList();
       searchResult = DatabaseController.search(string); 
       // return DatabaseController.search(string); 
       // Maybe the first two lines are more descriptive?
       return searchResult;
    }
    
    public ArrayList<Trip> search() {
        
    }
}
