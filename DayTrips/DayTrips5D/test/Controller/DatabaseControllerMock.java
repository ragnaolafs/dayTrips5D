/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Trip;
import java.util.ArrayList;

/**
 *
 * @author ragna
 */
public class DatabaseControllerMock extends DatabaseController {
    
    public static ArrayList<Trip> search(String q) {
        
        ArrayList<Trip> tripList = new ArrayList<Trip>();
        
        return tripList;
    }
}
