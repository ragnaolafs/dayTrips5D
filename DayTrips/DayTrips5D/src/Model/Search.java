/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.TripsView;
import Controller.DatabaseController;
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
    private ArrayList<Trip> searchLocations(ArrayList<String> locations){
        // ef leitarstrengurinn er tómur, gera þetta eins og venjulega
        // ef ekki, þá leita þar og svo gera rest
        
        // look through all trips in database and find those in desired
        // locations.
        ArrayList<Trip> trips = dbController.searchLocation(locations);
        
        return trips;
    }
    
    /**
    * Looks for trips within the timeframe specified by the user through the
    * GUI and returns ArrayList<Trip> with the results.
    **/
    private ArrayList<Trip> searchPrices(){
        //sql taka inn result?
        ArrayList<Trip> locations = searchLocations(checkboxes);
        ArrayList<Trip> priceTrips = new ArrayList();
        
        int lower = tripsView.jPriceFrom.getValue();
        int higher = tripsView.jPriceTo.getValue();
        
        // Leita að öllum trips within price range
        // Fyrir öll stök í price range: Ef location.contains þær ferðir
        //  þá priceTrips.add(i)
        
        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).getPrice()<lower || locations.get(i).getPrice()>higher){
                locations.remove(i);
            }
        }
        return priceTrips;
    }
    
    /**
    * Looks for trips within the timeframe specified by the user through the
    * GUI and returns 3ArrayList<Trip> with the results.
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
       searchResult = dbController.search(string); 
       // return DatabaseController.search(string); 
       // Maybe the first two lines are more descriptive?
       return searchResult;
    }
    
    
    
    public ArrayList<Trip> search(ArrayList<String> locations, int priceLower,
            int priceHigher, String dateFrom, String dateTo, String searchQuery) {
        
        ArrayList<Trip> tripList;
        
        if (searchQuery != "") {
            tripList = searchStrings(searchQuery);
            // bæta við searchlocation og eyða ef trip í triplist er ekki með location sem passar
        }
        
        else {
            tripList = searchLocations(locations);
        }
        
        
    }
}
