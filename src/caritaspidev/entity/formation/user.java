/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.formation;

import java.sql.Date;

/**
 *
 * @author EYA
 */
public class user {
    
    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private String password;
     
    private int enabled;
    //salt
    private Date last_login;
    private String roles;

    private String firstname;
    private String lastname;
    private String profile_picture;
  
    
 public user() {
    }

    public user(int id) {
        this.id = id;
    }
    
    
     

    public user(int id, String username, String username_canonical, String email, String email_canonical, String password, int enabled, Date last_login, String roles, String firstname, String lastname, String profile_picture) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.password = password;
        this.enabled = enabled;
         
        this.roles = roles;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile_picture = profile_picture;
       
    }
    
    

    public user(int id, String username, String username_canonical, String email, String email_canonical, String password, String roles, String firstname, String lastname, String profile_picture) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.password = password;
        this.roles = roles;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile_picture = profile_picture;
 
    }

    public user(String username, String username_canonical,String firstname, String lastname, String roles) {
         
        this.username = username;
        this.username_canonical = username_canonical;
    
        this.roles = roles;
        this.firstname = firstname;
        this.lastname = lastname;
        
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname =lastname;
    }

     
    public String getImage() {
        return profile_picture;
    }

    public void setImage(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    

     

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", password=" + password + ", enabled=" + enabled + ", last_login=" + last_login + ", roles=" + roles + ", Firstname=" +firstname + ", Last_name=" + lastname +  ", profile_picture=" + profile_picture + '}'+'\n';
    }
     

    
   
  

}

