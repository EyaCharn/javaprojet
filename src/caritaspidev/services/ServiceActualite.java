/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityPublicite.actualite;

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
public class ServiceActualite implements Iservice<actualite> {
    private  Connection con;
     private Statement ste;
    private PreparedStatement pre;
    
     public ServiceActualite(){
    con = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(actualite t) throws SQLException {
    pre=con.prepareStatement("INSERT INTO `caritass`.`actualite` ( `titre`, `contenu`, `image`, `dateajout`,`datemodif`) VALUES ( ?, ?, ?, ?,?);");
    pre.setString(1, t.getTitre());
    pre.setString(2, t.getContenu());
    Date sDate = new java.sql.Date(t.getDateajout().getTime());
    Date sDate1 = new java.sql.Date(t.getDatemodif().getTime());
    pre.setString(3, t.getImage());
    pre.setDate(4,sDate);
     pre.setDate(5,sDate1);
   
    pre.executeUpdate();
   
    }

    @Override
    public boolean delete(int id) throws SQLException {
       if(chercher(id)){
            System.out.println("exist");
        pre=con.prepareStatement("delete from `caritass`.`actualite` where id  = (?);");
        pre.setInt(1,id);
            System.out.println(pre.execute());
       return true;}
        else 
        {System.out.println("nexiste pas");
            return false;}
    }

    @Override
    public boolean chercher(int id) throws SQLException {
        String req="select * from actualite";
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
    public boolean chercher_ajout(actualite t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(actualite t, int id) throws SQLException {
           if(chercher(id)){
       
        pre=con.prepareStatement("UPDATE actualite SET   titre =?,contenu =?,image =?,dateajout =?,datemodif =? WHERE id = ?");
         
    pre.setString(1, t.getTitre());
    
    
    pre.setString(2, t.getContenu());
  
    Date sDate = new java.sql.Date(t.getDateajout().getTime());
    Date sDate1 = new java.sql.Date(t.getDatemodif().getTime());
    pre.setString(3, t.getImage());
    pre.setDate(4, sDate);
     pre.setDate(5, sDate1);
    pre.setInt(6, id);
    pre.executeUpdate();
    return 1;}
        return 0;
    }
    
 public List<actualite>trieParDate_D() throws SQLException{
            String req="select * from actualite  ORDER BY titre ";
        List<actualite> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                 ImageView v = new ImageView();
                
                v.setImage(new Image(rs.getString(4)));
                v.setFitWidth(100);
                v.setFitHeight(100);
                 java.sql.Date d1 = new java.sql.Date(rs.getDate(5).getTime());
               java.sql.Date d2 = new java.sql.Date(rs.getDate(6).getTime());
                
              
               actualite a1 = new actualite (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), d1,d2);
                 a1.setPhoto(v);
                list.add(a1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    
    }
    @Override
    public List<actualite> readAll() throws SQLException {
            
     String req="select * from actualite  ";
        List<actualite> list = new ArrayList<>();
         ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
               
               
                ImageView v = new ImageView();
                
                v.setImage(new Image(rs.getString(4)));
                v.setFitWidth(100);
                v.setFitHeight(100);
               
                //ystem.out.println(v.getImage().toString());
                actualite p2=new actualite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5),rs.getDate(6));
                
                p2.setPhoto(v);
                list.add(p2);
            
    
}
        return list; }}
