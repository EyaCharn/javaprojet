/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.evenement.evenement;
import caritaspidev.entity.evenement.theme;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author asus
 */
public class Serviceevenement  implements Iservice<evenement>{
      private Connection con;
    private Statement ste;
    private PreparedStatement pre;
   
    
    public Serviceevenement(){
    con = DataSource.getInstance().getConnection();
    }


    @Override
    public void ajouter(evenement t) throws SQLException {
          try {  
    String requete=("INSERT INTO `caritass`.`evenement` (`id_theme`, `NomEvenement`, `image`, `description`, `NbDeParticipants`,`Date`) VALUES ( ?, ?, ?, ?,?, ?);");
    PreparedStatement pre = con.prepareStatement(requete);
    pre.setInt(1, t.getId_theme());
    pre.setString(2, t.getNomEvenement());
    pre.setString(3, t.getImage());
    pre.setString(4, t.getDescription());
    pre.setInt(5, t.getNbDeParticipants());
    pre.setDate(6, t.getDateEvenement());
    
    pre.executeUpdate();
     System.out.println("evenement ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         
    }
   
   
 
    

    @Override
    public boolean delete(int id) throws SQLException {
         if(chercher(id)){
            System.out.println("exist");
        pre=con.prepareStatement("delete from `caritass`.`evenement` where id  = (?);");
        pre.setInt(1,id);
            System.out.println(pre.execute());
       return true;}
        else 
        {System.out.println("nexiste pas");
            return false;}
    }

    @Override
    public boolean chercher(int id) throws SQLException {
       String req="select * from evenement";
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return list.contains(id);    
     
    }

    @Override
    public boolean chercher_ajout(evenement t) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

      
    }

    @Override
    public boolean update(evenement t, int id) throws SQLException {
      if(chercher(id)){
       
        pre=con.prepareStatement("UPDATE `evenement` SET `id_theme`=?,`NomEvenement`=?,`image`=?,`description`=?,`NbDeParticipants`=?,`Date`=? WHERE id = ? ");
     pre.setInt(1,t.getId_theme());    
    pre.setString(2, t.getNomEvenement());
    
    
    pre.setString(3, t.getImage());
      pre.setString(4, t.getDescription());
      pre.setInt(5,t.getNbDeParticipants());
  Date sDate = new java.sql.Date(t.getDateEvenement().getTime());
    
 
  pre.setDate(6, sDate);
  
    pre.setInt(7, id);
     
        pre.executeUpdate();
      System.out.println("update valide");
         return true;}
        System.out.println("update invalid: emploi nexiste pas");
        return false;  
    }
    

     public List<evenement> trieParnb() {
        String req ="select * from evenement ORDER BY NbDeParticipants DESC ";
        List<evenement> list =new ArrayList<>();
         try {
                ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
               while(rs.next())
               {         java.sql.Date d1 = new java.sql.Date(rs.getDate(7).getTime());
        list.add(new evenement(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),d1));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(Serviceevenement.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
    }
     public List<evenement> recherche_event(int id) {
            List<evenement> arr=new ArrayList<>();
            PreparedStatement pre;
         try {
             pre =con.prepareStatement("SELECT * FROM evenement WHERE  id LIKE ? ;");
              pre.setInt(1,id);
        ResultSet rs=pre.executeQuery();
        while (rs.next()) {                
                 java.util.Date dd=new java.util.Date(rs.getDate(4).getTime());
      
        arr.add(new evenement(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getNString(5), rs.getInt(6) , (Date) dd));
    
     }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return arr;
        
        
     
 
    
   
}

    @Override
    public List<evenement> readAll() throws SQLException {
          String req ="select * from evenement ";
          
        List<evenement> list =new ArrayList<>();
         try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
               while(rs.next())
               {       
              ImageView v=new ImageView();
            v.setImage(new Image(rs.getString(4)));
                  v.setFitHeight(100);
                 v.setFitWidth(100);
                  evenement pp=new evenement(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7),null);
           pp.setPhoto(v);
        list.add(pp);
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(Serviceevenement.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
        
    }
}
