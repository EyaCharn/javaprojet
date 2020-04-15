/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.controller.LoginController;
import caritaspidev.entity.evenement.evenement;
import caritaspidev.entity.evenement.participation;
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceevenement;
import caritaspidev.services.Servicesparticipation;
import caritaspidev.services.Serviceuser;
import caritaspidev.controller.UserSession;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EventsController implements Initializable {

    @FXML
    private VBox eventcontainer;
     private Connection con;
     
        private Statement ste;
    private PreparedStatement pre;
      Integer s1=0 ;
   
    @FXML
    private TextField search;
    @FXML
    private CheckBox recherche;
    @FXML
    private CheckBox recherchee;
    @FXML
    private AnchorPane page;
    @FXML
    private JFXButton myevent;
     public EventsController() {
        con = DataSource.getInstance().getConnection();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          UserSession n = UserSession.getInstance();
  //s1 =n.getId_user();
         try {
            // TODO
            eventcontainer.setSpacing(5);
            display_events();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
        // TODO
    }    
     private void display_events() throws SQLException{
         
 Serviceevenement pa = new Serviceevenement();
  Servicesparticipation pp = new Servicesparticipation();
  Serviceuser uu= new Serviceuser();
    user u=new user(LoginController.getIdCnx());
        String req = "select * from evenement  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
           
               java.sql.Date d1 = new java.sql.Date(rs.getDate(7).getTime());
            evenement a1 = new evenement(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6) ,d1);
            ImageView va = new ImageView(new Image(rs.getString(4)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre : " + a1.getNomEvenement());
            Label contenu = new Label("Le contenu : " + a1.getDescription());
         
            Label datemodif = new Label("Cette publication est modifé le : " + a1.getDateEvenement());
 
            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(contenu);
            
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(datemodif);
            
           
             Button bt1=new Button("participer");
             
            
             
                   if(pp.checkIfParticipated(a1,new user())){
                       
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                     alert.setTitle("Done");
                    alert.setHeaderText("Tu as deja participé");
                    alert.setContentText("merci n'oubliez pas de venir");
                    alert.showAndWait();
                       
            
                 
                   
                  bt1.setDisable(true);
                  
              }
            
            
             VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,bt1);

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
            
              bt1.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event) {
                       try {
                           if(!pp.checkIfParticipated(a1,new user()))
                           { 
             evenement e1 =new evenement();
                           
        
              pp.insert(a1.getId(),LoginController.getIdCnx());
                      participation ue=new participation(a1,new user() );

        
                               bt1.setDisable(true);
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Done");
                    alert.setHeaderText(" Bravo Bienvenueeee  ");
                    alert.setContentText("merci pour l'utilisation de Caritass ");
                    alert.showAndWait();
                            
                           }          
                           
                       } catch (SQLException ex) {
                           Logger.getLogger(EventsController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   
               });
          

        }
        eventcontainer.getChildren().addAll(list);
    }
       private void display_eventavancee(String req) throws SQLException {
        Serviceevenement pa = new Serviceevenement();
       
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            java.sql.Date d1 = new java.sql.Date(rs.getDate(7).getTime());
      
            evenement a1 = new evenement(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6) ,d1);
            ImageView va = new ImageView(new Image(rs.getString(4)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre : " + a1.getNomEvenement());
            Label contenu = new Label("Le contenu : " + a1.getDescription());
         
            Label datemodif = new Label("Cette publication est modifé le : " + a1.getDateEvenement());
 
            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(contenu);
            
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(datemodif);
            

           
            Button bt2=new Button("details" ) ;
         


                      
         
            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,bt2);

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
        eventcontainer.getChildren().addAll(list);
    }



    @FXML
    private void recherche(ActionEvent event) throws SQLException {
         eventcontainer.getChildren().removeAll(eventcontainer.getChildren());
      String search11 = search.getText();
      String req ="select * from evenement where NomEvenement = '"+search11+"'";
        display_eventavancee(req);
        if(search11.equals("")){
             req ="select * from evenement";
        display_eventavancee(req);
    }
    
   
         
         
     }

    private void triedate(ActionEvent event) throws SQLException {
         eventcontainer.getChildren().removeAll(eventcontainer.getChildren());
        String req = "select * from evenement ORDER BY Date  ";
        display_eventavancee(req);
    }

    @FXML
    private void recherchee(ActionEvent event) throws SQLException {
         eventcontainer.getChildren().removeAll(eventcontainer.getChildren());
        String req = "select * from evenement ORDER BY Date  ";
        display_eventavancee(req);
    }

    @FXML
    private void rechercheee(ActionEvent event) throws SQLException {
         eventcontainer.getChildren().removeAll(eventcontainer.getChildren());
        String req = "select * from evenement ORDER BY NomEvenement DESC ";
        display_eventavancee(req);
    }

    @FXML
    private void myevent(ActionEvent event) throws IOException {
          AnchorPane pane=FXMLLoader.load(getClass().getResource("myevents.fxml"));
        page.getChildren().setAll(pane);
    }

  
        
    }
        
    




