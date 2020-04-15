/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.evenement;

/**
 *
 * @author asus
 */
public class theme {
    
      public int id ;
      public String nom;
   public String description ;

    public theme(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public theme(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public theme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "theme{" + "id=" + id + ", nom=" + nom + ", description=" + description + '}';
    }
    
   
}
