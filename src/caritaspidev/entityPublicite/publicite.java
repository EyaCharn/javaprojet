/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityPublicite;

import java.util.Objects;
import javafx.scene.image.ImageView;

/**
 *
 * @author asus
 */
public class publicite {
    
    private int id;
    private String image ;
    private String description ;
    private boolean etat;
   
    private ImageView photo;

    public publicite(int id, String image, String description, boolean etat, ImageView photo) {
        this.id = id;
        this.image = image;
        this.description = description;
        this.etat = etat;
        
        this.photo = photo;
    }

    public publicite(int id, String image, String description, boolean etat) {
        this.id = id;
        this.image = image;
        this.description = description;
        this.etat = etat;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.image);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + (this.etat ? 1 : 0);
      
        hash = 29 * hash + Objects.hashCode(this.photo);
        return hash;
    }

    @Override
    public String toString() {
        return "publicite{" + "id=" + id + ", image=" + image + ", description=" + description + ", etat=" + etat +  ", photo=" + photo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final publicite other = (publicite) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.etat != other.etat) {
            return false;
        }
       
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

 
    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public publicite(String image, String description, boolean etat, ImageView photo) {
        this.image = image;
        this.description = description;
        this.etat = etat;
     
        this.photo = photo;
    }

    public publicite(String image, String description, boolean etat) {
        this.image = image;
        this.description = description;
        this.etat = etat;
        
    }

   

}  
  