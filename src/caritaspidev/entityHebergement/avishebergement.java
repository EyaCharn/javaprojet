/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityHebergement;

import caritaspidev.entityUser.user;

/**
 *
 * @author Maissa
 */
public class avishebergement {
   int id; 
   Double stars;
   user user_id;
   String title, description ;
   hebergement heb;

    public avishebergement() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double rating) {
        this.stars = rating;
    }

    public user getRefavis() {
        return user_id;
    }

    public void setRefavis(user user_id) {
        this.user_id = user_id;
    }

    public String getTitre() {
        return title;
    }

    public void setTitre(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public hebergement getheb() {
        return heb;
    }

    public void setBn(hebergement heb) {
        this.heb = heb;
    }

    public avishebergement(int id, Double stars, user user_id, String title, String description, hebergement heb) {
        this.id = id;
        this.stars = stars;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.heb = heb;
    }
    
   

    @Override
    public String toString() {
        return "avishebergement{" + "refavis=" + user_id + '}';
    }

   
    
}
