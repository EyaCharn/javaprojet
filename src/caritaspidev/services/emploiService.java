/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.emploi.emploi;
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
import static jdk.nashorn.internal.objects.Global.setDate;



/**
 *
 * @author EYA
 */
public class emploiService implements Iservice<emploi>{
    private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
   
    public emploiService(){
    cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(emploi t) throws SQLException {
        Date dd=new java.sql.Date(t.getDateDebut().getTime());
        Date df=new java.sql.Date(t.getDateFin().getTime());
        String req="INSERT INTO `caritass`.`offre_emplois` (`titre`, `exeperiance`, `image`, `description`, `email`, `lieu`, `dateDebut`, `dateFin`) VALUES ('"+t.getTitre()+"','"+t.getExeperiance()+"','"+t.getImage()+"','"+t.getDescription()+"','"+t.getEmail()+"','"+t.getLieu()+"','"+t.getDateDebut()+"','"+t.getDateFin()+"');";
        try {
            
            st=cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(emploiService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if(chercher(id)){
        try {
             
             pre=cnx.prepareStatement("delete from offre_emplois where id= ?");
             pre.setInt(1,id);
             pre.execute();
         } catch (SQLException ex) {
             Logger.getLogger(emploiService.class.getName()).log(Level.SEVERE, null, ex);
         }
             System.out.println("delete valide");
         return true;
         }
         System.out.println("emploi nexiste pas");
         return false;
    }

    @Override
    public boolean chercher(int id) throws SQLException {
         String req ="select * from offre_emplois";
        List<Integer> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {       java.util.Date dd=new java.util.Date(rs.getDate(8).getTime());
        java.util.Date  df=new java.util.Date(rs.getDate(9).getTime()); 
        list.add(rs.getInt(1));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(emploiService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list.contains(id);
    }

    @Override
    public boolean chercher_ajout(emploi t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(emploi t, int id) throws SQLException {
        if(chercher(id)){
               Date dd=new java.sql.Date(t.getDateDebut().getTime());
        Date df=new java.sql.Date(t.getDateFin().getTime()); 
         
             pre=cnx.prepareStatement("UPDATE offre_emplois SET titre =?,exeperiance =?,image =?,description =?,email =?,lieu=?,dateDebut =?,dateFin =? WHERE id=?");
             pre.setString(1,t.getTitre());
             pre.setString(2,t.getExeperiance());
             pre.setString(3,t.getImage());
             pre.setString(4,t.getDescription());
             pre.setString(5,t.getEmail());
             pre.setString(6,t.getLieu());
             pre.setDate(7,dd);
             pre.setDate(8,df);
             pre.setInt(9,t.getId());
             pre.executeUpdate();
         
            System.out.println("update valide");
         return true;}
        System.out.println("update invalid: emploi nexiste pas");
        return false;
    }

    @Override
    public List<emploi> readAll() throws SQLException {
         String req ="select * from offre_emplois";
        List<emploi> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {       java.util.Date dd=new java.util.Date(rs.getDate(8).getTime());
        java.util.Date  df=new java.util.Date(rs.getDate(9).getTime()); 
                   ImageView v=new ImageView();
                   v.setImage(new Image(rs.getString(4)));
                   v.setFitHeight(100);
                   v.setFitWidth(100);
                   emploi pp=new emploi(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), dd, df);
                   pp.setPhoto(v);
        list.add(pp);
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(emploiService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
    }
    
        }
    

