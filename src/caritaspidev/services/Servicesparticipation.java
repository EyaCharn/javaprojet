/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.evenement.participation;
import caritaspidev.entityUser.user;
import caritaspidev.entity.evenement.evenement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Servicesparticipation 
{
      private Connection con;
    private Statement ste;
    private PreparedStatement pre;
      private ResultSet rs;
   
    
    public Servicesparticipation(){
    con = DataSource.getInstance().getConnection();
    }
    
   public void insert(int ide,int idu) throws SQLException
   {
            String req="insert into participation (idEvent,idUtilisateur) values (?,?)";
        
        try {
            pre=con.prepareStatement(req);
            pre.setInt(1,ide);
            pre.setInt(2,idu);
             
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Servicesparticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Boolean checkIfParticipated(evenement e, user u) {
        String req="SELECT * FROM participation WHERE idEvent="+e.getId()+ " AND idUtilisateur="+u.getId()+"";
        System.out.println(req);
        try {
            ste=con.createStatement();
            rs=ste.executeQuery(req);
        } catch (SQLException ex) {
            Logger.getLogger(Servicesparticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            List<participation> list = new ArrayList<>();
            Serviceuser us = new Serviceuser();
            Serviceevenement es = new Serviceevenement();
        try {
           
            while(rs.next()){
               list.add(new participation(e,u)) ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Servicesparticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(list.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
    
    public List<evenement> readMyEvents(int u) {
         String req="SELECT * FROM evenement e join participation es on e.id=es.idEvent where es.idUtilisateur="+u+"";
         System.out.println(req);
    evenement event=new evenement();
    try {
        ste=con.createStatement();
        rs=ste.executeQuery(req);
        if(rs.next())
        {
             java.sql.Date d1 = new java.sql.Date(rs.getDate(7).getTime());
        
         event= new evenement(rs.getInt("id"), rs.getString("NomEvenement") , rs.getString("image"), rs.getString("description") ,d1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Servicesparticipation.class.getName()).log(Level.SEVERE, null, ex);
    }
    List<evenement> list=new ArrayList<>();
        try {
            while(rs.next()){
                  java.sql.Date d1 = new java.sql.Date(rs.getDate(7).getTime());
            list.add(new evenement(rs.getInt("id")
                     ,rs.getInt("id_theme")
                    
                , rs.getString("NomEvenement")
                     , rs.getString("image")
                 , rs.getString("description")
                      , rs.getInt("NbDeParticipants")
                ,d1));
               
               
              
            }
            } catch (SQLException ex) {
            Logger.getLogger(Servicesparticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
    
    public void delete(int e,int id) {
         try {
            String req = "DELETE FROM participation WHERE idEvent=? AND idUtilisateur=?";
            pre = con.prepareStatement(req);
            pre.setInt(1, e);
            pre.setInt(2, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Servicesparticipation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public List<participation> displayAll() {
       String req ="select * from participation";
        List<participation> list =new ArrayList<>();
         try {
             ste=con.createStatement();
             ResultSet rs =ste.executeQuery(req);
               while(rs.next())
               {      
      
        
         
               
              
               participation a= new participation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
               
               list.add(a);
               }
         } catch (SQLException ex) {
             Logger.getLogger(Servicesparticipation.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
    }
         public boolean deletee(int id) {
        if(chercher(id)){
        try {
             
             pre=con.prepareStatement("delete from participation where id= ?;");
             pre.setInt(1, id);
             pre.execute();
         } catch (SQLException ex) {
             Logger.getLogger(Serviceevenement.class.getName()).log(Level.SEVERE, null, ex);
         }
             System.out.println("delete valide");
         return true;
         }
         System.out.println("event nexiste pas");
         return false;
    } 

    private boolean chercher(int id) {
          String req ="select * from participation";
        List<Integer> list =new ArrayList<>();
         try {
             ste=con.createStatement();
             ResultSet rs =ste.executeQuery(req);
               while(rs.next())
               {       
       
        list.add(rs.getInt(1));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(Serviceevenement.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list.contains(id);
    }
      
}
