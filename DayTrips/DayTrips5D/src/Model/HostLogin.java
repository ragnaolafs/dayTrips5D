package Model;

import Controller.DatabaseController;

/**
 * 
 * @author Ragna Ólafsdóttir, rao9@hi.is
 * @author Hugrún Guðmundsdóttir, hug17@hi.is
 * @author Karen Ósk Pétursdóttir, kop1@hi.is
 */
public class HostLogin {
    private String username = "";
    private static String password = "";	
    private String hostName = "";
    private static String loggedInUser ="";
    
    public HostLogin(String fullname, String username, String password){
        this.hostName=fullname;
        this.username=username;
        this.password=password;
    }

    public HostLogin(String username, String password) {
        this.username=username;
        this.password=password;
    }
    
    public HostLogin() {
      this.username = username;
    }
    
     /**
     * Getters
     * @return 
     */
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getLoggedIn(){
        return loggedInUser;
    }
    /**
     * Calls the databaseController with the username and password
     * and returns true if the database found a match, false otherwise.
     * @param username
     * @param password 
     */
    public boolean login(String username, String password) {
        loggedInUser = username;
        DatabaseController logincontrol = new DatabaseController();
        boolean loggedIn = logincontrol.login(username,password);
        return loggedIn;

    }

    /**
     * Calls the database with full name, username and password.
     * @param fullname
     * @param username
     * @param password 
     */
    public void createNewUser(String fullname, String username, String password){
        DatabaseController newuser = new DatabaseController();
        newuser.createNewUser(fullname,username,password);
    }
    

}
