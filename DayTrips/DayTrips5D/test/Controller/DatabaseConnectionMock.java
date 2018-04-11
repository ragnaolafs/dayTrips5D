
package Controller;

import Model.Trip;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ragna
 */
public class DatabaseConnectionMock {
    
    private ArrayList<Trip> trips;
    
    public DatabaseConnectionMock(){
        ArrayList<String> dates1 = new ArrayList();
        dates1.add("2018-05-05");
        dates1.add("2018-05-04");
        dates1.add("2018-05-03");
        
        ArrayList<String> dates2 = new ArrayList();
        dates2.add("2018-05-02");
        dates2.add("2018-05-01");
        
        ArrayList<String> dates3 = new ArrayList();
        dates2.add("2018-05-06");
        
        ArrayList<String> types1 = new ArrayList();
        dates1.add("Horseback");
        dates1.add("Sightseeing");
        
        ArrayList<String> types2 = new ArrayList();
        dates1.add("Hiking/Yoga");
        dates1.add("Northern Lights");
        
        trips.add(new Trip(1, dates1, "1200", "walk on the lava", 
                "this is a trip where we go and walk on the lava with horses",
                2000, types1, "4", 30, false, "South"));
        
        trips.add(new Trip(2, dates2, "1300", "walk on the ice", 
                "let's see some sights on the ice!",
                2000, types1, "4", 10, false, "North"));
        
        trips.add(new Trip(1, dates1, "0800", "yoga on the moss", 
                "let's do some yoga in untouched nature",
                2000, types2, "4", 25, false, "West"));
        
        trips.add(new Trip(1, dates1, "2300", "northern lights adventure", 
                "if you want to see northern lights, this is the trip for you",
                2000, types2, "4", 50, false, "East"));
        
        trips.add(new Trip(1, dates3, "1200", "hiking with vikings", 
                "learn how to hike like a true viking barbarian",
                2000, types2, "5", 15, false, "East"));
    }
    
    public ArrayList<Trip> selectLocation(String s) {
        
        ArrayList<Trip> tripMatches = new ArrayList<Trip>();
        
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getLocation() == s) {
                tripMatches.add(trips.get(i));
            }
        }
        
        return tripMatches;
    }
    
    public ArrayList<Trip> selectDates(String dateFrom, String dateTo) throws ParseException {
        SimpleDateFormat from = new SimpleDateFormat(dateFrom);
        SimpleDateFormat to = new SimpleDateFormat(dateTo);
        
        Date fromD = from.parse(dateFrom);
        Date toD = from.parse(dateTo);
        
        ArrayList<Trip> tripMatches = new ArrayList<Trip>();
        
        for (int i = 0; i < trips.size(); i++) {
            ArrayList<String> dates = trips.get(i).getDates();
            
            for (int j = 0; j < dates.size(); j++) {
                SimpleDateFormat tripDate = new SimpleDateFormat(dates.get(j));
                Date tripD = tripDate.parse(dates.get(j));
                
                if ((tripD.after(fromD) || tripD.equals(fromD)) && 
                        (tripD.before(toD) || tripD.equals(toD))) {
                    tripMatches.add(trips.get(i));
                    break;
                }
            }
        }
        
        return tripMatches;
    }
    
    public ArrayList<Trip> select(String s) {
        
        ArrayList<Trip> tripMatches = new ArrayList<Trip>();
        
        for (int i = 0; i < trips.size(); i++) {
            String name = trips.get(i).getName();
            String description = trips.get(i).getDescription();
            if (name.toLowerCase().contains(s.toLowerCase()) 
                    || description.toLowerCase().contains(s.toLowerCase())) {
                tripMatches.add(trips.get(i));
            }
        }
        
        return tripMatches;
    }

}

