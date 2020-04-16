/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

/**
 *
 * @author Maissa
 */
 

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityHebergement.hebergement;
import caritaspidev.entityUser.UserSession;
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceuser;
import caritaspidev.services.formationService;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author EYA
 */
public class AfficherHebController implements Initializable {
    
     @FXML
    private TextField search;
     
      private Connection con;

    @FXML
    private VBox formationcontainer;

    @FXML
    private ScrollPane scroll;
        private static Serviceuser myServices = new Serviceuser();


   
 public AfficherHebController() {
     con = DataSource.getInstance().getConnection();
    }
    private Statement ste;
    private PreparedStatement pre;
   Integer s1=0 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         // user n = user.getInstance();
        // s1 = n.getId();
        
         try {
            // TODO
            formationcontainer.setSpacing(5);
            
            
            displayFormation();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherHebController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

    private void displayFormation() throws SQLException {
       formationService pa = new formationService();
   
        String req = "select * from hebergement  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
    while (rs.next()) {
             
            
            hebergement a1 = new hebergement(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
           //formation a2=new formation(rs.getInt(1),rs.getString(2),rs.getString(3),dd,rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
            //ImageView va = new ImageView(new Image(rs.getString(6)));
            //va.setFitHeight(170);
           //va.setFitWidth(200);
            Label duree = new Label("Duree max : " + a1.getDureemax());
            Label adresse = new Label("l'adresse est : " + a1.getAdresse());
            Label nbplaces = new Label("le nombre de places disponibles : " + a1.getNbplaces());
            Label description = new Label("une petite description : " + a1.getDescription());
            Label reglement = new Label("Réglement intérieur : " + a1.getReglement());
            Button demander=new Button("Demander");
             HBox h1 = new HBox();
            h1.setSpacing(10);
           h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(duree);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(adresse);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(nbplaces);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(description);
             HBox h5 = new HBox();
            h5.setSpacing(10);
            h5.setAlignment(Pos.CENTER);
            h5.getChildren().addAll(reglement);
              HBox h6= new HBox();
            h6.setSpacing(10);
            h6.setAlignment(Pos.CENTER);
            h6.getChildren().addAll(demander);
            VBox v2=new VBox();
               v2.setAlignment(Pos.CENTER);
               v2.setSpacing(10);
               v2.getChildren().addAll(h6);
               
               demander.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event) {
                       int i = Integer.parseInt(a1.getNbplaces());
                       int nb=i-1;
                       String nbp=Integer.toString(nb);
                          a1.setNbplaces(nbp);
                        System.out.println("le nombre des places  ====>"+a1.getNbplaces());
                         Notifications n = Notifications.create()
                        .title("Merci")
                        .text("Votre demande est enregistrée avec succés!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5));
                         n.showInformation();}
                           });
            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,h6);

            VBox vv = new VBox();
            vv.setAlignment(Pos.CENTER);
            vv.setSpacing(10);
          //  vv.getChildren().addAll(va);
            HBox No = new HBox();
            No.setSpacing(10);
            No.setAlignment(Pos.CENTER);
            No.getChildren().addAll(vv, v);

           VBox v1 = new VBox();
            v1.setAlignment(Pos.CENTER);
           v1.setSpacing(10);
            v1.getChildren().addAll(No);
            list.add(v1);

        }
        formationcontainer.getChildren().addAll(list);    }
    
                         public user getUserConnecte() throws SQLException
{

      UserSession n = UserSession.getInstance();
      user cc=new user();
                               String s1 = n.getUsername();
                               Statement stmt1 = con.createStatement();
                              String SQL1 = "SELECT * FROM user  WHERE username ='" +s1+"'";
                               ResultSet rs1 = stmt1.executeQuery(SQL1);
                               while(rs1.next())
                                {
                                    cc.setId(rs1.getInt(1));
                                    cc.setUsername(rs1.getString(3));
                                   
                                           
                                }
        return cc;
                              
    
}
}


