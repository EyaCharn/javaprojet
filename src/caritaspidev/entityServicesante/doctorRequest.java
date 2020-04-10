/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entityServicesante;

import java.util.Objects;

/**
 *
 * @author Maissa
 */
public class doctorRequest {
    private int id;
    private String description ;
    private String adresse ;
    private String id_cart ;
    private String document ;
    private String validation ;
public doctorRequest(Integer id, String description , String adresse, String id_cart, String document ,  String validation)
{   this.id=id;
    this.description=description ;
    this.adresse=adresse;
    this.id_cart=id_cart;
    this.document=document;
    this.validation=validation;
    
}
public doctorRequest( String description , String adresse, String id_cart, String document , String validation)
{ 
    this.description=description ;
    this.adresse=adresse;
    this.id_cart=id_cart;
    this.document=document;
    this.validation=validation;
    
}
public doctorRequest( String description , String adresse, String id_cart, String document )
{ 
    this.description=description ;
    this.adresse=adresse;
    this.id_cart=id_cart;
    this.document=document;
 
    
}
 @Override
    public String toString() {
        return "doctorRaquest{" + "id=" + id + ", description=" + description + ", adresse=" + adresse + ", id_cart=" + id_cart + ", document=" + document + ", validation=" + validation + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final doctorRequest other = (doctorRequest) obj;
        if (this.id != other.id) {
            return false;
        }
        
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
         if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
          if (!Objects.equals(this.id_cart, other.id_cart)) {
            return false;
        }
           if (!Objects.equals(this.document, other.document)) {
            return false;
        }
        if (!Objects.equals(this.validation, other.validation)) {
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String decription) {
        this.description = description;
    }
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
      public String getIdcart() {
        return id_cart;
    }

    public void setIdcart(String id_cart) {
        this.id_cart =id_cart;
    }
     public String getDocument() {
        return document;
    }

    public void setDocument(String decription) {
        this.description = description;
    }
     public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }
    
    
}
