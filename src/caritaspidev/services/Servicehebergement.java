/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;
import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityHebergement.hebergement;
import caritaspidev.entityServicesante.servicesante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;


/**
 *
 * @author Maissa
 */
public class Servicehebergement implements Hservice<hebergement> {
    

   Connection cnx = DataSource.getInstance().getConnection();
    
   
     @Override
    public void ajouter(hebergement h)throws SQLException {
       try {  
    String requete=("INSERT INTO `caritass`.`hebergement` (`dureemax`, `adresse`, `nbplaces`, `description_logement`, `image_logement`,`date`, `reglement_interieur`) VALUES ( ?, ?, ?, ?,?, ?, ?);");
    PreparedStatement pre = cnx.prepareStatement(requete);
    pre.setString(1, h.getDureemax());
    pre.setString(2, h.getAdresse());
    pre.setString(3, h.getNbplaces());
    pre.setString(4, h.getDescription());
    pre.setString(5, h.getImage());
    pre.setDate(6, h.getDate());
    pre.setString(7,h.getReglement());
    pre.executeUpdate();
     System.out.println("hebergement ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
   
    }
    @Override
    public void  delete(hebergement h) {
   try{
            
        String requete=("delete from `caritass`.`hebergement` where id  = (?);");
        PreparedStatement pre = cnx.prepareStatement(requete);
        pre.setLong(1, h.getId());
        pre.executeUpdate();
        System.out.println("hebergment supprimée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    }
    }
      
       @Override
     
    
    public void update(hebergement h)  {
        try {
            System.out.println(h.toString());
            String requete = "UPDATE `hebergement` SET `dureemax`=?,`adresse`=?,`nbplaces`=?,`description_logement`=?,`image_logement`=?,`date`=?,`reglement_interieur`=?  WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, h.getDureemax());
            pst.setString(2, h.getAdresse());
            pst.setString(3, h.getNbplaces());
            pst.setString(4, h.getDescription());
            pst.setString(5, h.getImage());
            pst.setDate(6, h.getDate());
            pst.setString(7,h.getReglement());
            pst.setLong(8, h.getId());
            pst.executeUpdate();
            System.out.println("Modification effectué avec succés"+h.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    @Override
    public List<hebergement> afficher() {
        List<hebergement> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM hebergement";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new hebergement(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getDate(7)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
