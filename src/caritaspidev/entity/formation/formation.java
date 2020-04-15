/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.formation;

import java.util.Objects;
import java.util.Date;
import javafx.scene.image.ImageView;

/**
 *
 * @author EYA
 */
public class formation {

    
     
   
    private int id;
    private String titre;
    private String image;
    private Date datedebut;
    private int nbplaces;
    private String lieu;
    private String description;
    private int repliesnumber;
    private int likesnumber;
    private int idUser;
   
    private ImageView photo;

    public formation() {
    }
    
    

    public formation(int id, String titre, String image, Date datedebut, int nbplaces, String lieu, String description, int repliesnumber, int likesnumber, int idUser, ImageView photo) {
    public formation() {
    }

    public formation(int id, String titre, String image, Date datedebut, int nbplaces, String lieu, String description, int repliesnumber, int likesnumber, int idUser) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
        this.repliesnumber = repliesnumber;
        this.likesnumber = likesnumber;
        this.idUser = idUser;
        this.repliesnumber = repliesnumber;
        this.likesnumber = likesnumber;
        this.idUser = idUser;
    }

    public formation(int id, String titre, String image, Date datedebut, int nbplaces, String lieu, String description, int likesnumber, int idUser) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
        this.likesnumber = likesnumber;
        this.idUser = idUser;
    }
    
    

    public formation(int id, String titre, String image, Date datedebut, int nbplaces, String lieu, String description, int repliesnumber, int likesnumber, int idUser, ImageView photo) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
        this.repliesnumber = repliesnumber;
        this.likesnumber = likesnumber;
        this.idUser = idUser;
        this.photo = photo;
    }

     public formation(int id, String titre, String image, Date datedebut, int nbplaces, String lieu, String description,ImageView photo) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
       
        this.photo = photo;
    }

    public formation(String titre, String image, Date datedebut, int nbplaces, String lieu, String description, ImageView photo) {
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
        
        this.photo = photo;
    }

    public formation(int id, String titre, String image, Date datedebut, int nbplaces, String lieu, String description) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
      
    }

    public formation(String titre, String image, Date datedebut, int nbplaces, String lieu, String description) {
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
       
    }

    

   

    public formation(int id, String titre, String image, Date datedebut, int nbplaces, String description) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.description = description;
       
    }

    public formation(int id, String image, Date datedebut, int nbplaces, String lieu, String description, ImageView photo) {
        this.id = id;
        this.image = image;
        this.datedebut = datedebut;
        this.nbplaces = nbplaces;
        this.lieu = lieu;
        this.description = description;
       
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRepliesnumber() {
        return repliesnumber;
    }

    public void setRepliesnumber(int repliesnumber) {
        this.repliesnumber = repliesnumber;
    }

    public int getLikesnumber() {
        return likesnumber;
    }

    public void setLikesnumber(int likesnumber) {
        this.likesnumber = likesnumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.titre);
        hash = 83 * hash + Objects.hashCode(this.image);
        hash = 83 * hash + Objects.hashCode(this.datedebut);
        hash = 83 * hash + this.nbplaces;
        hash = 83 * hash + Objects.hashCode(this.lieu);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + this.repliesnumber;
        hash = 83 * hash + this.likesnumber;
        hash = 83 * hash + this.idUser;
        hash = 83 * hash + Objects.hashCode(this.photo);
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
        final formation other = (formation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.datedebut, other.datedebut)) {
            return false;
        }
        if (this.nbplaces != other.nbplaces) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.repliesnumber != other.repliesnumber) {
            return false;
        }
        if (this.likesnumber != other.likesnumber) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "formation{" + "id=" + id + ", titre=" + titre + ", image=" + image + ", datedebut=" + datedebut + ", nbplaces=" + nbplaces + ", lieu=" + lieu + ", description=" + description + ", repliesnumber=" + repliesnumber + ", likesnumber=" + likesnumber + ", idUser=" + idUser + ", photo=" + photo + '}';
    }
    
    

   
    
    
    
     

   
}
