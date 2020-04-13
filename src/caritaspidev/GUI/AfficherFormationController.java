/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.formation.formation;
import caritaspidev.services.formationService;
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

   
 public AfficherFormationController() {
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
        String req = "select * from formation  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            java.sql.Date dd=new java.sql.Date(rs.getDate(4).getTime());
            

            formation a1 = new formation(rs.getInt(1),rs.getString(2),rs.getString(3),dd,rs.getString(5),rs.getString(6),rs.getString(7));
            ImageView va = new ImageView(new Image(rs.getString(3)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre : " + a1.getTitre());
            Label date = new Label("La date : " + a1.getDatedebut());
            Label nbplaces = new Label("le nombre de places disponibles : " + a1.getNbplaces());
            Label lieu = new Label("le lieu : " + a1.getLieu());
            Label description = new Label("une petite description : " + a1.getDescription());


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

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4);

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
    
}
