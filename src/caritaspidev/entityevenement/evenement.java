/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityevenement ;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author asus
 */
public class evenement {
     private int id;
    private String NomEvenement;
    private String image;
    private String description;
       private int NbDeParticipants ;
    private String dateEvenement ;
     private ImageView photo; 

    public evenement(int id, String NomEvenement, String description, int NbDeParticipants, String dateEvenement, ImageView photo) {
        this.id = id;
        this.NomEvenement = NomEvenement;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
        this.photo = photo;
    }

    public evenement(int id, String NomEvenement, String image, String description, int NbDeParticipants, String dateEvenement) {
        this.id = id;
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
    }
    

    public evenement(String NomEvenement, String image, String description, int NbDeParticipants, String dateEvenement) {
        this.NomEvenement = NomEvenement;
        this.image = image;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
    }

    public evenement(String NomEvenement, String description, int NbDeParticipants, String dateEvenement, ImageView photo) {
        this.NomEvenement = NomEvenement;
        this.description = description;
        this.NbDeParticipants = NbDeParticipants;
        this.dateEvenement = dateEvenement;
        this.photo = photo;
    }
    

    public evenement() {
    }

    public evenement(int aInt, String string, String string0, int aInt0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(String dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final evenement other = (evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", NomEvenement=" + NomEvenement + ", image=" + image + ", description=" + description + ", NbDeParticipants=" + NbDeParticipants + ", dateEvenement=" + dateEvenement + ", photo=" + photo + '}';
    }
     
     
 
  
    
     
    
}
