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
	//public String hostEmail = "";
	//public String hostPhone = "";
        //ASDF beil á þessu tvennu ?
	
	
	public static void login(String username, char[] pw) {
        
            for(int i = 0; i < pw.length;i++){
                password = password + i;
            }
            //DatabaseController.login(username,password);
		
	}
        public static void createNewUser(String fullname, String username, char[] pw){
             
            for(int i = 0; i < pw.length;i++){
                password = password + i;
            }
            //DatabaseController.createNewUser(fullname,username,password);
            
        }
}
