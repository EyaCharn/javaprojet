/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityHebergement;

import caritaspidev.entityServicesante.servicesante;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Maissa
 */
public class hebergement {
    private Long id;
    private String duree_max;
    private String nbplaces ;
    private String adresse ;
    private String description_logement ;
    private String image_logement;
    private Date date ;
    private String reglement_interieur;
    
    public hebergement (Long id , String duree_max ,String nbplaces , String adresse , String description_logement , String image_logement ,Date date, String reglement_interieur){
    this.id=id; 
    this.duree_max=duree_max;
    this.nbplaces=nbplaces ;
    this.adresse=adresse;
    this.description_logement=description_logement;
    this.image_logement=image_logement;
    this.date=date;
    this.reglement_interieur=reglement_interieur;
    
}
     public hebergement ( String duree_max ,String nbplaces , String adresse , String description_logement , String image_logement ,Date date, String reglement_interieur){
  
    this.duree_max=duree_max;
    this.nbplaces=nbplaces ;
    this.adresse=adresse;
    this.description_logement=description_logement;
    this.image_logement=image_logement;
    this.date=date;
    this.reglement_interieur=reglement_interieur;
    
}
     public hebergement(){}
     
     public hebergement ( String duree_max ,String nbplaces , String adresse , String description_logement , String image_logement , String reglement_interieur){
  
    this.duree_max=duree_max;
    this.nbplaces=nbplaces ;
    this.adresse=adresse;
    this.description_logement=description_logement;
    this.image_logement=image_logement;
   
    this.reglement_interieur=reglement_interieur;
    
}
        public hebergement ( Long id,String duree_max , String adresse ,String nbplaces, String description_logement , String image_logement , Date date){
    this.id=id;
    this.duree_max=duree_max;
    this.nbplaces=nbplaces ;
    this.adresse=adresse;
    this.description_logement=description_logement;
    this.image_logement=image_logement;
    this.date=date;
   
    
}
        
        public hebergement ( Long id,String duree_max , String adresse ,String nbplaces, String description_logement , String image_logement,String reglement_interieur){
    this.id=id;
    this.duree_max=duree_max;
    this.nbplaces=nbplaces ;
    this.adresse=adresse;
    this.description_logement=description_logement;
    this.image_logement=image_logement;
    this.reglement_interieur=reglement_interieur;
    
  
   
    
}
        
        public hebergement ( String duree_max , String adresse ,String nbplaces, String description_logement , String reglement_interieur){
    
    this.duree_max=duree_max;
    this.nbplaces=nbplaces ;
    this.adresse=adresse;
    this.description_logement=description_logement;
    this.reglement_interieur=reglement_interieur;
 
   
    
}
     
      @Override
    public String toString() {
        return "hebergement{" + "id=" + id + ", duree_max=" + duree_max + ", nb places=" + nbplaces + ", adresse=" + adresse + ", description_logement=" + description_logement+ ", image_logement=" + image_logement+ ",date=" + date +", reglement_interieur=" + reglement_interieur +'}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final hebergement other = (hebergement) obj;
        if (this.id != other.id) {
            return false;
        }
       if (!Objects.equals(this.duree_max, other.adresse)) {
            return false;
        }
         if (!Objects.equals(this.nbplaces, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.description_logement,other.description_logement )) {
            return false;
        }
         if (!Objects.equals(this.image_logement, other.image_logement)) {
            return false;
        }
        if (!Objects.equals(this.reglement_interieur, other.reglement_interieur)) {
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
     public String getDureemax() {
        return duree_max;
    }

    public void setDureemax(String duree_max) {
        this.duree_max = duree_max;
    }
     public String getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(String nbplaces) {
        this.nbplaces= nbplaces;
    }
     public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
     public String getDescription() {
        return description_logement;
    }

    public void setDescription(String description_logement) {
        this.description_logement= description_logement;
    }
     public String getImage() {
        return image_logement;
    }

    public void setImage(String image_logement) {
        this.image_logement = image_logement;
    }
     public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     public String getReglement() {
        return reglement_interieur;
    }

    public void setReglement(String reglement_interieur) {
        this.reglement_interieur = reglement_interieur;
    }
    
    
}
