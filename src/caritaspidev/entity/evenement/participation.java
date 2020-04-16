/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.evenement ;

import caritaspidev.entityUser.user;

/**
 *
 * @author asus
 */
public class participation {
    
      private int id;
    private int idEvent;
    private int idUtilisateur ; 
    
    
    public participation(){}

   
    public participation(evenement id_evenement , user id_user) {
        this.idEvent =idEvent;
        this.idUtilisateur=idUtilisateur;
        
    }
   

   

    public participation( int id, int idEvent, int idUtilisateur) {
       
        this.id = id;
        this.idEvent = idEvent;
        this.idUtilisateur = idUtilisateur;
    }

    public participation( int idUtilisateur) {
        
        this.idUtilisateur = idUtilisateur;
    }
    
    
    


    public participation(int idEvent,int idUtilisateur) {
        this.idEvent = idEvent;
        this.idUtilisateur = idUtilisateur;
    }


  

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
  
    
    

   


    @Override
    public String toString() {
        return "participation{" + "id=" + id + ", idEvent=" + idEvent + ", idUtilisateur=" + idUtilisateur + '}';
    }

    
      
    
  
   
    
}
