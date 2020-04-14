/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author EYA
 */
 package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.controller.UserSession;
 
import caritaspidev.entity.formation.formation;
import caritaspidev.entity.formation.participation;
import caritaspidev.entity.formationlike.formationlike;
import caritaspidev.entity.trainingparticipation.traningparticipation;
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceuser;
import caritaspidev.services.formationService;
import formation.Service.formationlikeService;
import formation.Service.participationService;
 
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

/**
 * FXML Controller class
 *
 * @author EYA
 */
public class AfficherFormationController implements Initializable {
    
     @FXML
    private TextField search;
     
      private Connection con;

    @FXML
    private VBox formationcontainer;

    @FXML
    private ScrollPane scroll;
        private static Serviceuser myServices = new Serviceuser();


   
 public AfficherFormationController() {
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
            Logger.getLogger(AfficherFormationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

    private void displayFormation() throws SQLException {
       formationService pa = new formationService();
       formationlikeService pf=new formationlikeService();
        participationService pe =new participationService();
        String req = "select * from formation  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
    while (rs.next()) {
            java.sql.Date dd=new java.sql.Date(rs.getDate(4).getTime());
            
            formation a1 = new formation(rs.getInt(1),rs.getString(2),rs.getString(3),dd,rs.getInt(5),rs.getString(6),rs.getString(7));
            formation a2=new formation(rs.getInt(1),rs.getString(2),rs.getString(3),dd,rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
            ImageView va = new ImageView(new Image(rs.getString(3)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre : " + a1.getTitre());
            Label date = new Label("La date : " + a1.getDatedebut());
            Label nbplaces = new Label("le nombre de places disponibles : " + a1.getNbplaces());
            Label lieu = new Label("le lieu : " + a1.getLieu());
            Label description = new Label("une petite description : " + a1.getDescription());
            Button participer=new Button("participer");
            
            
             Button aimer=new Button("aimer("+a2.getLikesnumber()+")");
             
           
           
            
              
            

            HBox h1 = new HBox();
            h1.setSpacing(10);
           h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(date);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(nbplaces);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(lieu);
             HBox h5 = new HBox();
            h5.setSpacing(10);
            h5.setAlignment(Pos.CENTER);
            h5.getChildren().addAll(description);
              HBox h6= new HBox();
            h6.setSpacing(10);
            h6.setAlignment(Pos.CENTER);
            h6.getChildren().addAll(participer);
            
            
            
             HBox h7= new HBox();
            h7.setSpacing(10);
            h7.setAlignment(Pos.CENTER);
            h7.getChildren().addAll(aimer);
            
            
            
            
            
            
            
            
            
            
             VBox v2=new VBox();
               v2.setAlignment(Pos.CENTER);
               v2.setSpacing(10);
               v2.getChildren().addAll(h6);
               
               
               
               VBox v3=new VBox();
               v3.setAlignment(Pos.CENTER);
               v3.setSpacing(10);
               v3.getChildren().addAll(h7);
               user connecte=getUserConnecte();
                 if (pe.chercher_participation(new participation(a1.getId(),connecte)))
                         {
                   participer.setDisable(true);
              }
                 if (pf.chercher_formationLike(new formationlike(connecte.getId(),a2.getId()))) {
                     aimer.setDisable(true);
            
        }
               
               
                 participer.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event) {
                         
                         a1.setNbplaces(a1.getNbplaces() - 1);
                        System.out.println("le nombre des places  ====>"+a1.getNbplaces());
                    
                       try {
                           user connecte=getUserConnecte();
                              if (!pe.chercher_participation(new participation(a1.getId(),new user(85))))
                         {
                             pe.ajouter(new participation(a1.getId(),connecte));
                             pa.update2(a1);
                             nbplaces.setText("le nombre de places disponibles : "+ a1.getNbplaces());
                   participer.setDisable(true);
              }
                          
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherFormationController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                          
                          
                   
                        
                   }
                                    
                   
                     });
                         
                         aimer.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event) {
                         
                         a2.setLikesnumber(a2.getLikesnumber() + 1);
                        System.out.println("le nombre de like  ====>"+a2.getLikesnumber());
                         
                       try {
                           user connecte=getUserConnecte();
                            if (!pf.chercher_formationLike(new formationlike(connecte.getId(),a2.getId()))) {
                     aimer.setDisable(true);
                     pf.ajouter(new formationlike(connecte.getId(),a2.getId()));
                      pa.updateLike(a2);
                      aimer.setText("aimer("+a2.getLikesnumber()+")");
                     
            
        }
                           
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherFormationController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                          
                     
                        
                   }
                                    
                   
                     })
                      
                         
                         
                         ;
                 
                 
                 
                 
                 
          

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,h6,h7);

            VBox vv = new VBox();
            vv.setAlignment(Pos.CENTER);
            vv.setSpacing(10);
            vv.getChildren().addAll(va);
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

