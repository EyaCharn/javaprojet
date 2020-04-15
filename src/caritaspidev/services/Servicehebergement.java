/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;
import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityHebergement.avishebergement;
import caritaspidev.entityHebergement.hebergement;
import caritaspidev.entityServicesante.servicesante;
import caritaspidev.entityUser.user;
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
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 *
 * @author Maissa
 */
public class Servicehebergement implements Hservice<hebergement> {
    

   Connection cnx = DataSource.getInstance().getConnection();
   private PreparedStatement ps;
    
   
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
                list.add(new hebergement(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(8)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public void rating(int rat, int hebergement) {

        try { // 
            String requete = "INSERT INTO reviews(stars) VALUES(?) where hebergement=" + hebergement;
//            String requete = "INSERT INTO bon_plan(longitude,latitude,refcategorie,num_tel_local,libelle ,desciption,image,couverture,addresse,email,overture,fermeture)(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, rat);

            pst.executeUpdate();

            System.out.println("rating ajouté");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajoutreview(avishebergement a) {

        try { // 
            String requete = "INSERT INTO reviews(user_id,hebergement,stars,title,description) VALUES(?,?,?,?,?) ";
//            String requete = "INSERT INTO bon_plan(longitude,latitude,refcategorie,num_tel_local,libelle ,desciption,image,couverture,addresse,email,overture,fermeture)(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, a.getRefavis().getId());
            pst.setLong(2, a.getheb());
            pst.setDouble(3, a.getRating());
            pst.setString(4, a.getTitre());
            pst.setString(5, a.getDescription());

            pst.executeUpdate();

            System.out.println("Review ajouté");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

     public List<avishebergement> ListeAvis(Long id) {
        List<avishebergement> myList = new ArrayList<avishebergement>();

        try { // LES var declaré dans le try ne sont vue que dans le try, et inversement pour en dhors du try
            String requete = "SELECT * from reviews where hebergement=" + id; //MAJUSCULE NON OBLIGATOIRE 
            Statement pst = cnx.prepareStatement(requete); // import java.sql.Statement
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                avishebergement p2 = new avishebergement();
                p2.setId(rs.getInt(1));
                user u = new user(rs.getInt(2));
                p2.setRefavis(u);

                p2.setRating(rs.getDouble(3));
                p2.setTitre(rs.getString(4));
                p2.setDescription(rs.getString(5));
                

                myList.add(p2);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;

    }
      public void supprimeravis(Integer r) {
        user loggedUser = caritaspidev.controller.LoginController.getInstance().getLoggedUser();
        if (loggedUser.getId() == r) {
            try {

                String requete = "delete from `reviews` where id=?";
                PreparedStatement ps;
                ps = cnx.prepareStatement(requete);
                ps.setInt(1, r);
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Ce n'est pas votre commentaire")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning();
        }

    }
      
      public int GEtMoyRating(int id) {

        int i = 0;
        try {
            String sqlStationName = " select AVG(stars) as moyenne from reviews where hebergement="+id;
            Statement st3 = cnx.createStatement();
            ResultSet rs = st3.executeQuery(sqlStationName);
            while (rs.next()) {

                i = (int)rs.getDouble("moyenne");
              //  System.out.println("i= "+i);

            }

            rs.close();
            st3.close();

        } catch (SQLException ex) {
            System.err.println("ERR" + ex);
        }
        return i;
    }
      
      public ResultSet statistic() throws SQLException  {
   
    String rec="SELECT count(*),adresse FROM `hebergement` group by adresse";
    ps= cnx.prepareStatement(rec);
    ResultSet result = ps.executeQuery();
    return result;
    } 

    
}
