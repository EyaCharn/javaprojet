/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.emploi;

import java.util.Objects;
import javafx.scene.image.ImageView;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EYA
 */
public class emploi {

   

    private int id ;
     private String titre;
     private String exeperiance;
     private String image ;
     private String description ;
     private String email;
     private String lieu ;
     private Date dateDebut;
     private Date dateFin;
     private ImageView photo;

    public emploi(int id, String titre, String exeperiance, String image, String description, String email, String lieu, Date dateDebut, Date dateFin, ImageView photo) {
        this.id = id;
        this.titre = titre;
        this.exeperiance = exeperiance;
        this.image = image;
        this.description = description;
        this.email = email;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.photo = photo;
    }

    public emploi(String titre, String exeperiance, String image, String description, String email, String lieu, Date dateDebut, Date dateFin, ImageView photo) {
        this.titre = titre;
        this.exeperiance = exeperiance;
        this.image = image;
        this.description = description;
        this.email = email;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.photo = photo;
    }

    public emploi(int id, String titre, String exeperiance, String image, String description, String email, String lieu, Date dateDebut, Date dateFin) {
        this.id = id;
        this.titre = titre;
        this.exeperiance = exeperiance;
        this.image = image;
        this.description = description;
        this.email = email;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public emploi(String titre, String exeperiance, String image, String description, String email, String lieu, Date dateDebut, Date dateFin) {
        this.titre = titre;
        this.exeperiance = exeperiance;
        this.image = image;
        this.description = description;
        this.email = email;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public String getExeperiance() {
        return exeperiance;
    }

    public void setExeperiance(String exeperiance) {
        this.exeperiance = exeperiance;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.titre);
        hash = 67 * hash + Objects.hashCode(this.exeperiance);
        hash = 67 * hash + Objects.hashCode(this.image);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.lieu);
        hash = 67 * hash + Objects.hashCode(this.dateDebut);
        hash = 67 * hash + Objects.hashCode(this.dateFin);
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
        final emploi other = (emploi) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.exeperiance, other.exeperiance)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emploi{" + "id=" + id + ", titre=" + titre + ", exeperiance=" + exeperiance + ", image=" + image + ", description=" + description + ", email=" + email + ", lieu=" + lieu + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", photo=" + photo + '}';
    }
     
     
}
