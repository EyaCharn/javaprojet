/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;
import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityServicesante.servicesante;
import caritaspidev.entityServicesante.doctorRequest;
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
 * @author Maissa
 */
public class Serviceservicesante implements Sservice<servicesante>{
    private Connection con;
    private Statement ste;
    private PreparedStatement pre;
    
    public Serviceservicesante(){
    con = DataSource.getInstance().getConnection();
    }
     @Override
    public void ajouter(servicesante s) throws SQLException {
      
    pre=con.prepareStatement("INSERT INTO `caritass`.`servicesante` ( `specialite`, `periode_dispo`, `motivation`, `cv`, `commentaire`) VALUES ( ?, ?, ?, ?, ?);");
    pre.setString(1, s.getSpecialite());
    pre.setString(2, s.getPeriodedispo());
    pre.setString(3, s.getMotivation());
    
    pre.setString(4, s.getCv());
    pre.setString(5, s.getCommentaire());
    pre.executeUpdate();
   
    }
    
    public void DoctorRequest(doctorRequest d) throws SQLException {
      
    pre=con.prepareStatement("INSERT INTO `caritass`.`doctorrequest` ( `description`, `adresse`, `id_cart`, `document`, `validation`) VALUES ( ?, ?, ?, ?, ?);");
    pre.setString(1, d.getDescription());
    pre.setString(2, d.getAdresse());
    pre.setString(3, d.getIdcart());
    
    pre.setString(4, d.getDocument());
    pre.setString(5, d.getValidation());
    pre.executeUpdate();
   
    }
    
     public ResultSet statistic() throws SQLException  {
   
    String rec="SELECT count(*),specialite FROM `servicesante` group by specialite";
    pre= con.prepareStatement(rec);
    ResultSet result = pre.executeQuery();
    return result;
    } 
    
    
    
}
