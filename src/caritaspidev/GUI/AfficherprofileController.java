/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceuser;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author asus
 */

public class AfficherprofileController implements Initializable {
    
    
     private Connection con;
    @FXML
    private VBox profilcontainer;
    
     public AfficherprofileController() {
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
        
        
          profilcontainer.setSpacing(5);
            try {
                displayActualite();
            } catch (SQLException ex) {
                Logger.getLogger(AfficherprofileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        // TODO
    }  
    
    
    
  private void displayActualite() throws SQLException {
        
        String req = "select * from user  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
           

            user a1 = new user( rs.getString(3), rs.getString(5),rs.getString(9), rs.getString(14), rs.getString(15), rs.getString(16));
//            ImageView va = new ImageView(new Image(rs.getString(16)));
          //  va.setFitHeight(170);
          //  va.setFitWidth(200);
            Label username = new Label("username : " + a1.getUsername());
            Label email = new Label("email : " + a1.getEmail());
            Label firstname = new Label("nom : " + a1.getFirstname());
            Label lastname = new Label("prenom : " + a1.getLastname());

            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(username);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(email);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(firstname);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(lastname);
           

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4);

            VBox vv = new VBox();
            vv.setAlignment(Pos.CENTER);
            vv.setSpacing(10);
            vv.getChildren().addAll();
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
        profilcontainer.getChildren().addAll(list);
    }
    
}
