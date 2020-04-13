/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

 import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityServicesante.doctorRequest;
 
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
public class ServiceDoctorrequest implements Dservice<doctorRequest>{
        Connection cnx = DataSource.getInstance().getConnection(); 
      @Override
    public void  delete(doctorRequest d) {
   try{
            
        String requete=("delete from `caritass`.`doctorrequest where id  = (?);");
        PreparedStatement pre = cnx.prepareStatement(requete);
        pre.setLong(1, d.getId());
        pre.executeUpdate();
        System.out.println("request supprimée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    }
    }
     public List<doctorRequest> afficher() {
        List<doctorRequest> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM doctorrequest";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new doctorRequest(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(7)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
     public void accepterrequest(doctorRequest d) {
        try { // 

            String requete = "UPDATE doctorrequest set validation =? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1,"acceptée");
            pst.setInt(2,d.getId());
          
            pst.executeUpdate();

            System.out.println(" modification effectuée avec succés ");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
      public void refuserrequest(doctorRequest d) {
        try { // 

            String requete =  ("delete from `caritass`.`doctorrequest` where id  = (?) ;");
//  
            PreparedStatement pst = cnx.prepareStatement(requete);       
            pst.setInt(1, d.getId());
            pst.executeUpdate();

            System.out.println(" modification effectuée avec succés ");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
     

}
