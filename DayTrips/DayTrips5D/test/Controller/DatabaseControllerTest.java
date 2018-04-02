/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.junit.*;

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
        
    }
}
