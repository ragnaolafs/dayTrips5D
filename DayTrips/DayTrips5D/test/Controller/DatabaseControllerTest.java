/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Trip;
import java.text.ParseException;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ragna
 */
public class DatabaseControllerTest {

    private DatabaseConnectionMock dbConnMock;
    
    @Before
    public void setUp() {
        dbConnMock = new DatabaseConnectionMock();
    }
    
    @After
    public void tearDown() {
        dbConnMock = null;
    }
    
    @Test
    public void testSearch() {
        ArrayList<Trip> tripList = dbConnMock.select("walk");
        assertEquals(2, tripList.size());
    }
    
    @Test
    public void testSearchFail() {
        ArrayList<Trip> tripList = dbConnMock.select("dustbunnies");
        assertEquals(0, tripList.size());
    }
    
    @Test
    public void testSearchLocation() {
        ArrayList<Trip> tripList = dbConnMock.selectLocation("North");
        assertEquals(1, tripList.size());
    }
    
    @Test
    public void testSearchDates() throws ParseException {
        ArrayList<Trip> tripList = dbConnMock.selectDates("2018-05-03", "2018-05-05");
        assertEquals(3, tripList.size());
    }
}
