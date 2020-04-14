/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityPublicite.actualite;
import caritaspidev.services.ServiceActualite;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
 * @author asus
 */
public class AfficherActualiteController implements Initializable {

    @FXML
    private VBox actualitecontainer;

    private Connection con;
    @FXML
    private TextField search;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Button bt1;
    int n=1;

    public AfficherActualiteController() {
        con = DataSource.getInstance().getConnection();
    }
    private Statement ste;
    private PreparedStatement pre;
    String s1 = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       
            actualitecontainer.setSpacing(5);
            try {
                displayActualite();
            } catch (SQLException ex) {
                Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
             
            
        
    }

    private void displayActualite() throws SQLException {
        ServiceActualite pa = new ServiceActualite();
        String req = "select * from actualite  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            java.sql.Date d1 = new java.sql.Date(rs.getDate(5).getTime());
            java.sql.Date d2 = new java.sql.Date(rs.getDate(6).getTime());

            actualite a1 = new actualite(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), d1, d2);
            ImageView va = new ImageView(new Image(rs.getString(4)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre : " + a1.getTitre());
            Label contenu = new Label("Le contenu : " + a1.getContenu());
            Label dateajout = new Label("Cette publication est ajouté le : " + a1.getDateajout());
            Label datemodif = new Label("Cette publication est modifé le : " + a1.getDatemodif());

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
            h3.getChildren().addAll(dateajout);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(datemodif);
            Button bt2=new Button("imprimer" ) ;
             bt2.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) { //bitha heki chas
                     
                         PDF pdf = new PDF();
                     System.out.println("c button mouhage tsir creation houniiii  ");
                     try {
                         pdf.pdf(a1);
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (DocumentException ex) {
                         Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                               bt2.setDisable(true); 
                      
              


                      
                 }
             });

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,bt2);

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
        actualitecontainer.getChildren().addAll(list);
    }
    
       private void displayActualiteAvancee(String req) throws SQLException {
        ServiceActualite pa = new ServiceActualite();
       
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            java.sql.Date d1 = new java.sql.Date(rs.getDate(5).getTime());
            java.sql.Date d2 = new java.sql.Date(rs.getDate(6).getTime());

            actualite a1 = new actualite(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), d1, d2);
            ImageView va = new ImageView(new Image(rs.getString(4)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre : " + a1.getTitre());
            Label contenu = new Label("Le contenu : " + a1.getContenu());
            Label dateajout = new Label("Cette publication est ajouté le : " + a1.getDateajout());
            Label datemodif = new Label("Cette publication est modifé le : " + a1.getDatemodif());

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
            h3.getChildren().addAll(dateajout);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(datemodif);
            Button bt2=new Button("imprimer" ) ;
           bt2.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) { //bitha heki chas
                     
                         PDF pdf = new PDF();
                     System.out.println("c button mouhage tsir creation houniiii  ");
                     try {
                         pdf.pdf(a1);
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (DocumentException ex) {
                         Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                               bt2.setDisable(true); 
                      
              


                      
                 }
             });
            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,bt2);

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
        actualitecontainer.getChildren().addAll(list);
    }


    @FXML
    private void recherche(ActionEvent event) throws SQLException {
      actualitecontainer.getChildren().removeAll(actualitecontainer.getChildren());
      String search11 = search.getText();
      String req ="select * from actualite where titre = '"+search11+"'";
        displayActualiteAvancee(req);
        if(search11.equals("")){
             req ="select * from actualite";
        displayActualiteAvancee(req);
            
        }
      
        
       
        
    }

    @FXML
    private void triedate(ActionEvent event) throws SQLException {
        actualitecontainer.getChildren().removeAll(actualitecontainer.getChildren());
        String req = "select * from actualite ORDER BY titre  ";
        displayActualiteAvancee(req);
    }
        
       

}
