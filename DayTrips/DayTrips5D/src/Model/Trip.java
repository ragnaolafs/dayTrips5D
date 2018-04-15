/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author ragna
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
	
        
        public Trip(int ID, ArrayList<String> DATES,String TIME,String NAMEOFTRIP,String DESCR,
                int PRICE,ArrayList<String> TYPES,String DURATION,int CAPACITY,boolean SOLDOUT,String LOCATION){
            
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
         * GETTERS
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
        
        /**
         * SETTERS
         */
        
        public void setDates(ArrayList<String> dates){
            this.dates = dates;
        }
        public void setTime(String time){
            this.time = time;
        }
        public void setName(String name){
            this.nameOfTrip = name;
        }
        public void setDescription(String descr){
            this.description = descr;
        }  
        public void setPrice(int price){
            this.price = price;
        }
	public void setTypes(ArrayList<String> types){
            this.types = types;
        }
        public void setDuration(String duration){
            this.duration = duration;
        }
        public void setCapacity(int capacity){
            this.capacity = capacity;
        }
        public void setSoldOut(boolean soldout){
            this.soldOut = soldout;
        }
        public void setLocation(String location){
            this.location = location;
        }
        
        
        public static void main(String[] args) {
            
        }
	
	
	

}
