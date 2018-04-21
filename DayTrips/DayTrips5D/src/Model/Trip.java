/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 * The primary purpose of this class is to construct, set and get the values of 
 * a Trip object.
 * @author Ragna Ólafsdóttir, rao9@hi.is
 * @author Hugrún Guðmundsdóttir, hug17@hi.is
 * @author Karen Ósk Pétursdóttir, kop1@hi.is
 */
public class Trip {
    private int tripID;
    private ArrayList<String> dates;
    private String time;
    public String nameOfTrip;
    private String description;
    private int price;
    private ArrayList<String> types;
    private String duration;
    private int capacity;
    private boolean soldOut;
    private String location;
    
    /**
     * This constructor instatiates a Trip object with several properties.
     * @param ID
     * @param DATES
     * @param TIME
     * @param NAMEOFTRIP
     * @param DESCR
     * @param PRICE
     * @param TYPES
     * @param DURATION
     * @param CAPACITY
     * @param SOLDOUT
     * @param LOCATION 
     */
    public Trip(int ID, ArrayList<String> DATES, String TIME, String NAMEOFTRIP,
            String DESCR, int PRICE, ArrayList<String> TYPES, String DURATION,
            int CAPACITY, boolean SOLDOUT, String LOCATION){

        this.tripID=ID;
        this.dates=DATES;
        this.time=TIME;
        this.nameOfTrip=NAMEOFTRIP;
        this.description=DESCR;
        this.price=PRICE;
        this.types=TYPES;
        this.duration=DURATION;
        this.capacity=CAPACITY;
        this.soldOut=SOLDOUT;
        this.location=LOCATION;
    }
    
    /**
     * Getters
     * @return 
     */
    public int getTripID(){
        return tripID;    
    }
    public ArrayList<String> getDates(){
        return dates;
    }
    public String getTime(){
        return time;
    }
    public String getName(){
        return nameOfTrip;
    }
    public String getDescription(){
        return description;
    }  
    public int getPrice(){
        return price;
    }
    public ArrayList<String> getTypes(){
        return types;
    }
    public String getDuration(){
        return duration;
    }
    public int getCapacity(){
        return capacity;
    }
    public boolean getSoldOut(){
        return soldOut;
    }
    public String getLocation(){
        return location;
    }
}
