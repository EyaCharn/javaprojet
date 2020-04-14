/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityServicesante;

import caritaspidev.entityPublicite.publicite;
import java.util.Objects;

/**
 *
 * @author Maissa
 */
public class servicesante {
    private Long id;
    private String specialite ;
    private String periode_dispo;
    private String motivation;
    private String cv ;
    private String commentaire;
    

public servicesante(Long id , String specialite , String periodedispo , String motivation , String cv , String commentaire ){
    this.id=id; 
    this.specialite=specialite;
    this.periode_dispo=periode_dispo ;
    this.motivation=motivation;
    this.cv=cv;
    this.commentaire=commentaire;
}
public servicesante( String specialite , String periodedispo , String motivation , String cv , String commentaire ){ 
    this.specialite=specialite;
    this.periode_dispo=periode_dispo ;
    this.motivation=motivation;
    this.cv=cv;
    this.commentaire=commentaire;
}
public servicesante( String specialite ,String periodedispo,  String commentaire ){ 
    this.specialite=specialite;
      this.periode_dispo=periode_dispo ;
    this.commentaire=commentaire;
}  
 @Override
    public String toString() {
        return "servicesante{" + "id=" + id + ", specialite=" + specialite + ", periode_dispo=" + periode_dispo + ", motivation=" + motivation + ", CV=" + cv + ", commentaire=" + commentaire + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final servicesante other = (servicesante) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.specialite, other.specialite)) {
            return false;
        }
       
        if (!Objects.equals(this.periode_dispo,other.periode_dispo )) {
            return false;
        }
         if (!Objects.equals(this.motivation, other.motivation)) {
            return false;
        }
        if (!Objects.equals(this.cv, other.cv)) {
            return false;
        } 
        if (!Objects.equals(this.commentaire, other.commentaire)) {
            return false;
        }
        return true;
    }
 public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
     public String getPeriodedispo() {
        return periode_dispo;
    }

    public void setPeriodedispo(String periode_dispo) {
        this.periode_dispo = periode_dispo;
    }
    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation =motivation;
    }
    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
}
