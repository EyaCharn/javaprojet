/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityPublicite;


import java.sql.Date;
import java.util.Objects;
import javafx.scene.image.ImageView;




/**
 *
 * @author asus
 */
public class actualite {
    public int id ;
   public String titre ;
    public String contenu ;
 public String image ;
 public Date dateajout ; 
 public Date datemodif ; 
 private ImageView photo;
 
 
    public actualite(int id, String titre, String contenu, String image, Date dateajout, Date datemodif) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.image = image;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
        
    }

    public actualite(String titre, String contenu, String image, Date dateajout, Date datemodif) {
        this.titre = titre;
        this.contenu = contenu;
        this.image = image;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
    }

    public actualite(int id, String titre, String contenu, String image, Date dateajout, Date datemodif, ImageView photo) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.image = image;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
        this.photo = photo;
    }

    public actualite(String titre, String contenu, String image, Date dateajout, Date datemodif, ImageView photo) {
        this.titre = titre;
        this.contenu = contenu;
        this.image = image;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public Date getDatemodif() {
        return datemodif;
    }

    public void setDatemodif(Date datemodif) {
        this.datemodif = datemodif;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.titre);
        hash = 67 * hash + Objects.hashCode(this.contenu);
        hash = 67 * hash + Objects.hashCode(this.image);
        hash = 67 * hash + Objects.hashCode(this.dateajout);
        hash = 67 * hash + Objects.hashCode(this.datemodif);
        hash = 67 * hash + Objects.hashCode(this.photo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final actualite other = (actualite) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.dateajout, other.dateajout)) {
            return false;
        }
        if (!Objects.equals(this.datemodif, other.datemodif)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "actualite{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", image=" + image + ", dateajout=" + dateajout + ", datemodif=" + datemodif + ", photo=" + photo + '}';
    }
    
    
    
    

  
 
 
 
    
}
