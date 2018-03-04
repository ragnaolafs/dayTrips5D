import java.sql.*;

public class DatabaseConnection {
	
	
	Connection connection = null;
	Statement stmt = null;
	ResultSet r = null;
	
	public DatabaseConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:dayTripsDB.db");
			stmt = connection.createStatement();
		}
		catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		
	}
}
