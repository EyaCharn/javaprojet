/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

/**
 *
 * @author EYA
 */
public class UserSession {
     private static UserSession instance;
 
    private String username; 
    private String profile_picture;

     public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

   

   
    public UserSession(String username) {
        this.username = username;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance; 
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserSession(String username, String profile_picture) {
        this.username = username;
        this.profile_picture = profile_picture;
        
    }

    @Override
    public String toString() {
        return "UserSession{" + "username=" + username + ", profile_picture=" + profile_picture + '}';
    }

    
    
    public static UserSession getInstace(String username, String profile_picture) {
        if(instance == null) {
         instance = new UserSession(username,profile_picture);
        }
        return instance;
    }   
    
     public void cleanUserSession() {
        username = "";
        profile_picture = null;//7 or null
      instance = null;
        
       // or null
    }  
     
     
     
     
    
      
      

   

   
   

  
}
