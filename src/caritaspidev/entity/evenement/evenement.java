/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.evenement;

import java.sql.Date;
import javafx.scene.image.ImageView;

/**
 *
 * @author asus
 */
public class evenement {
      public int id ;
      public int id_theme;
      
   public String NomEvenement ;
    public String image ;
 public String description ;
 public int NbDeParticipants ; 
 public Date dateEvenement ; 
 private ImageView photo;

    public evenement(int id, int id_theme, String NomEvenement, String image, String description, int NbDeParticipants, Date dateEvenement, ImageView photo) {
        this.id = id;
        this.id_theme = id_theme;
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
        this.photo = photo;
      
    }

    public evenement(int id, String NomEvenement, String image, String description, Date dateEvenement) {
        this.id = id;
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.dateEvenement = dateEvenement;
    }

  

    public evenement(String NomEvenement, String image, String description, Date dateEvenement) {
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.dateEvenement = dateEvenement;
    }
    

    public evenement(int id, int id_theme, String NomEvenement, String image, String description, int NbDeParticipants, Date dateEvenement) {
        this.id = id;
        this.id_theme = id_theme;
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
    }

    public evenement(int id_theme, String NomEvenement, String image, String description, int NbDeParticipants, Date dateEvenement, ImageView photo) {
        this.id_theme = id_theme;
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
        this.photo = photo;
    }

    public evenement(int id_theme, String NomEvenement, String image, String description, int NbDeParticipants, Date dateEvenement) {
        this.id_theme = id_theme;
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
    }

   

    public evenement() {
        
    }

    public evenement(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_theme() {
        return id_theme;
    }

    public void setId_theme(int id_theme) {
        this.id_theme = id_theme;
    }

    public String getNomEvenement() {
        return NomEvenement;
    }

    public void setNomEvenement(String NomEvenement) {
        this.NomEvenement = NomEvenement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbDeParticipants() {
        return NbDeParticipants;
    }

    public void setNbDeParticipants(int NbDeParticipants) {
        this.NbDeParticipants = NbDeParticipants;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", id_theme=" + id_theme + ", NomEvenement=" + NomEvenement + ", image=" + image + ", description=" + description + ", NbDeParticipants=" + NbDeParticipants + ", dateEvenement=" + dateEvenement + ", photo=" + photo + '}';
    }

    
    

    
}
