package Model;

import Controller.DatabaseController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class can search the database for trips whose location, date, 
 * price, name and description fall within the conditions selected/specified by
 * the user through the GUI. 
 * Each search method returns a container with some properties that 
 * DatabaseController then uses to search for the desired trips.
 * (Search first searches the database for trips having a name or
 * description matching a search query and gives an ArrayList<Trip> with the 
 * results. The following search methods then each search the results of their 
 * forerunning ArrayList<Trip> objects in a cascading manner until the last 
 * method delivers the final result of the search.)
 * @author Ragna Ólafsdóttir, rao9@hi.is
 * @author Hugrún Guðmundsdóttir, hug17@hi.is
 * @author Karen Ósk Pétursdóttir, kop1@hi.is
 */
public class Search {
    
    private String query;
    private String location;
    private int priceHigher;
    private int priceLower;
    private String[] dates;
    private String keyword;
    private ArrayList<Trip> resultSet;
    private DatabaseController dbController;
    
    /**
     * Constructor creates an object of DatabaseController class.
     */
    public Search() {
        dbController = new DatabaseController();
    }
    
    /**
     * Returns all trip objects. To be used for resetting (canceling) search.
     * @return ArrayList of all Trip objects in Trips relation in database.
     */
    public ArrayList<Trip> resetSearch(){
        resultSet = dbController.getTripList();
        return resultSet;
    }
    
    /**
     * Returns trips matching desired locations by removing all trips in tripList
     * not matching any desired location.
     * @param locations ArrayList of strings of desired locations
     * @param tripList ArrayList of Trip objects to check for matching locations
     * @return ArrayList of Trip objects matching desired locations
     */
    private ArrayList<Trip> searchLocations(ArrayList<String> locations, 
            ArrayList<Trip> tripList){

        for (int i = 0; i < tripList.size(); i++) {
            boolean locationMatch = false;
            for (int j = 0; j < locations.size(); j++) {
                if (tripList.get(i).getLocation().equals(locations.get(j))) {
                    locationMatch = true;
                    break;
                }
            }
            // If no selected locations match trip location then remove it
            if (!locationMatch) {
                tripList.remove(i);
            }
        }
        return tripList;
    }
    
    /**
     * Removes Trip objects not matching desired price range from tripList.
     * @param lower int - lower bound of price range
     * @param higher int - upper bound of price range
     * @param tripList ArrayList of Trip objects to look for desired price range
     * @return ArrayList of Trip objects with prices within a desired price range
     */
    private ArrayList<Trip> searchPrices(int lower, int higher, ArrayList<Trip> tripList){

        for(int i = 0; i < tripList.size(); i++){
            if(tripList.get(i).getPrice()<lower || tripList.get(i).getPrice()>higher){
                tripList.remove(i);
            }
        }
        return tripList;
    }
    
    /**
     * Removes trips not within a given timeframe from tripList.
     * @param dateFrom String - lower bound of timeframe
     * @param dateTo String - upper bound of timeframe
     * @param tripList ArrayList of Trip objects to check on dates within the
     * desired timeframe
     * @return ArrayList of Trip objects matching the desired timeframe
     * @throws ParseException 
     */
    private ArrayList<Trip> searchDates(String dateFrom, String dateTo, ArrayList<Trip> tripList) throws ParseException{
        SimpleDateFormat from = new SimpleDateFormat(dateFrom);
        SimpleDateFormat to = new SimpleDateFormat(dateTo);
        
        Date fromD = from.parse(dateFrom);
        Date toD = to.parse(dateTo);
        
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
     * Searches for a given string in names and description of trips.
     * @param string
     * @return ArrayList of Trip objects where string was found in name or
     * description of trip
     */
    private ArrayList<Trip> searchStrings(String string) {
       ArrayList<Trip> searchResult = dbController.search(string); 
       return searchResult;
    }
    
    /**
     * Calls private methods to search for trips in desired locations, within
     * a given price range and timeframe, with some string matching part
     * of name or description.
     * @param locations
     * @param priceLower
     * @param priceHigher
     * @param dateFrom
     * @param dateTo
     * @param searchQuery
     * @return ArrayList of Trip objects matching given search parameters
     * @throws ParseException 
     */
    public ArrayList<Trip> search(ArrayList<String> locations, int priceLower,
            int priceHigher, String dateFrom, String dateTo, String searchQuery) throws ParseException {

        ArrayList<Trip> tripList;
        
        if (!"".equals(searchQuery)) {
            tripList = searchStrings(searchQuery); 
        }
        else {
            tripList = dbController.getTripList();
        }

        // Update the triplist with the search results:
        tripList = searchLocations(locations, tripList); 
        tripList = searchPrices(priceLower, priceHigher, tripList);
        tripList = searchDates(dateFrom, dateTo, tripList);
        
        return tripList;
    }
}
