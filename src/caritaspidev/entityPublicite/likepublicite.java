/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityPublicite;

import caritaspidev.entityUser.user;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author asus
 */
public class likepublicite {
    private int id ;
    private int idpublicite ;
    private Date datelike ;
    private user user; 
    private int idUser ;
    private String username;
    private String nom;

    public likepublicite(int id, int idpublicite, int idUser) {
        this.id = id;
        this.idpublicite = idpublicite;
        this.idUser = idUser;
    }

    public likepublicite(int id, String nom,int idUser ) {
        this.id = id;
        this.idUser = idUser;
        this.nom = nom;
    }

    public user getUser() {
        return user;
    }

    public likepublicite(int idpublicite, String username) {
        this.idpublicite = idpublicite;
        this.username = username;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public likepublicite(int idpublicite, int idUser) {
        this.idpublicite = idpublicite;
        this.idUser = idUser;
    }
    
    
    

    public likepublicite(int idpublicite, user user, int idUser) {
        this.idpublicite = idpublicite;
        this.user = user;
        this.idUser = idUser;
    }

    public likepublicite(int idpublicite, user user) {
        this.idpublicite = idpublicite;
        this.user = user;
    }
  
   

    public likepublicite(int id, int idpublicite, Date datelike,  int idUser) {
        this.id = id;
        this.idpublicite = idpublicite;
        this.datelike = datelike;
      
        this.idUser = idUser;
    }

    public likepublicite(int idpublicite, Date datelike, int idUser) {
        this.idpublicite = idpublicite;
        this.datelike = datelike;
      
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public likepublicite(int idpublicite) {
        this.idpublicite = idpublicite;
    }

    public int getIdpublicite() {
        return idpublicite;
    }

    public void setIdpublicite(int idpublicite) {
        this.idpublicite = idpublicite;
    }

    public Date getDatelike() {
        return datelike;
    }

    public void setDatelike(Date datelike) {
        this.datelike = datelike;
    }

   

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + this.idpublicite;
        hash = 23 * hash + Objects.hashCode(this.datelike);
       
        hash = 23 * hash + this.idUser;
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
        final likepublicite other = (likepublicite) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idpublicite != other.idpublicite) {
            return false;
        }
        if (!Objects.equals(this.datelike, other.datelike)) {
            return false;
        }
        
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "likepublicite{" + "id=" + id + ", idpublicite=" + idpublicite + ", datelike=" + datelike +  ", idUser=" + idUser + '}';
    }

  
    
}
