/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseController;

/**
 *
 * @author karen
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

	
	public void login(String username, String password) {
            loggedInUser = username;
            System.out.println(username);
            DatabaseController logincontrol = new DatabaseController();
            logincontrol.login(username,password);
            
            
		
	}
        public void createNewUser(String fullname, String username, String password){
             
            DatabaseController newuser = new DatabaseController();
            newuser.createNewUser(fullname,username,password);
            
        }
        public String getUsername(){
            return this.username;
        }
        public String getPassword(){
            return this.password;
        }
        public String getLoggedIn(){
            return loggedInUser;
        }
}
