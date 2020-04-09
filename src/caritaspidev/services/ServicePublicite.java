/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityPublicite.publicite;
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
public class ServicePublicite implements Iservice<publicite>{
    private Connection con;
    private Statement ste;
    private PreparedStatement pre;
   
    
    public ServicePublicite(){
    con = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(publicite t) throws SQLException {
      
        pre=con.prepareStatement("INSERT INTO `caritass`.`publicite` ( `image`, `description`, `etat`, `like`) VALUES ( ?, ?, ?, ?);");
    pre.setString(1, t.getImage());
    pre.setString(2, t.getDescription());
    
    pre.setInt(4, t.getLike());
    pre.setBoolean(3, t.isEtat());
    pre.executeUpdate();
   
    }

    @Override
    public boolean delete(int id) throws SQLException {
   if(chercher(id)){
            System.out.println("exist");
        pre=con.prepareStatement("delete from `caritass`.`publicite` where id  = (?);");
        pre.setInt(1,id);
            System.out.println(pre.execute());
       return true;}
        else 
        {System.out.println("nexiste pas");
            return false;}
    }

    @Override
    public boolean chercher(int id) throws SQLException {
        String req="select * from publicite";
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
    public boolean chercher_ajout(publicite t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(publicite t, int id) throws SQLException {
         if(chercher(id)){
        
        pre=con.prepareStatement("UPDATE publicite SET  image = ? , description = ?  , etat =? , like =? WHERE id = ?");
         
    pre.setString(1, t.getImage());
    
    
    pre.setString(2,t.getDescription());
  
    pre.setInt(4, t.getLike());
    pre.setBoolean(3, t.isEtat());
    pre.setInt(7,id);
    pre.executeUpdate();
    return true;}
        return false;
    }

    @Override
    public List<publicite> readAll() throws SQLException {
       
     String req="select * from publicite  ";
        List<publicite> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
               
               
                ImageView v = new ImageView();
                
                v.setImage(new Image(rs.getString(3)));
                v.setFitWidth(100);
                v.setFitHeight(100);
               
                //ystem.out.println(v.getImage().toString());
                publicite p2=new publicite(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getBoolean(4),rs.getInt(5));
                
                p2.setPhoto(v);
                list.add(p2);
              // list.add(new Publicite(rs.getInt(1),rs.getString(2),rs.getString(3),d1, rs.getString(6), d2,rs.getDouble(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    }}
