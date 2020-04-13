package caritaspidev.services;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.formation.formation;
import caritaspidev.services.Iservice;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class formationService implements Iservice<formation>{
    private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    
     public formationService(){
         cnx = DataSource.getInstance().getConnection();
     }

    @Override
    public void ajouter(formation t) throws SQLException {
        Date dd=new java.sql.Date(t.getDatedebut().getTime());
       
        String req="INSERT INTO `caritass`.`formation` (`titre`, `image`, `datedebut`, `nbplaces`, `lieu`, `description`) VALUES ('"+t.getTitre()+"','"+t.getImage()+"','"+t.getDatedebut()+"','"+t.getNbplaces()+"','"+t.getLieu()+"','"+t.getDescription()+"');";
        try {
            
            st=cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(formationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
      if(chercher(id)){
        try {
             
             pre=cnx.prepareStatement("delete from formation where id= ?");
             pre.setInt(1,id);
             pre.execute();
         } catch (SQLException ex) {
             Logger.getLogger(formationService.class.getName()).log(Level.SEVERE, null, ex);
         }
             System.out.println("delete valide");
         return true;
         }
         System.out.println("emploi nexiste pas");
         return false;
    }

    @Override
    public boolean chercher(int id) throws SQLException {
        String req ="select * from formation";
        List<Integer> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {       java.util.Date dd=new java.util.Date(rs.getDate(4).getTime());
       
        list.add(rs.getInt(1));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(formationService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list.contains(id);
    }

    @Override
    public boolean chercher_ajout(formation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(formation t, int id) throws SQLException {
         if(chercher(id)){
               Date dd=new java.sql.Date(t.getDatedebut().getTime());
         
             pre=cnx.prepareStatement("UPDATE formation SET titre =?,image =?,datedebut =?,nbplaces =?,lieu =?,description=? WHERE id=?");
             pre.setString(1,t.getTitre());
             pre.setString(2,t.getImage());
             pre.setDate(3,dd);
             pre.setString(4,t.getNbplaces());
             pre.setString(5,t.getLieu());
             pre.setString(6,t.getDescription());
            
             pre.executeUpdate();
         
            System.out.println("update valide");
         return true;}
        System.out.println("update invalid: formation nexiste pas");
        return false;
    }

    @Override
    public List<formation> readAll() throws SQLException {
          String req ="select * from formation";
        List<formation> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {       java.util.Date dd=new java.util.Date(rs.getDate(4).getTime());
                   ImageView v=new ImageView();
                   v.setImage(new Image(rs.getString(3)));
                   v.setFitHeight(100);
                   v.setFitWidth(100);
                   formation pp=new formation(rs.getInt(1),rs.getString(2),rs.getString(3),dd,rs.getString(5),rs.getString(6),rs.getString(7));
                   pp.setPhoto(v);
        list.add(pp);
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(formationService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
    }
    }
    
    
    
