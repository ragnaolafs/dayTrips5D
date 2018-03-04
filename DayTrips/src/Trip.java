import java.util.*;

public class Trip {
	private String tripID = "";
	private ArrayList<String> dates = new ArrayList<String>();
	private String time ="";
	private String nameOfTrip ="";
	private String description ="";
	private int price = 0;
	private ArrayList<String> types = new ArrayList<String>();
	private String duration ="";
	private int capacity = 0;
	private String location = "";
	private boolean soldOut = false;	
	private int value = 0;
	
	
	public int getCapacity() {
		return this.capacity;
		
	}
	
	public void setCapacity(int value) {
		this.capacity = value;
		
	}
	
	
	

}
