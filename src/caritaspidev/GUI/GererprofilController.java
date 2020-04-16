/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.controller.UserSession;
import caritaspidev.entityUser.user;
import caritaspidev.services.Password;
import caritaspidev.services.Serviceuser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class GererprofilController implements Initializable {
    @FXML
    private JFXTextField prenom;
    @FXML
    private Label labelPhone;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXButton addBtn;
    @FXML
    private Label inscrirLabel;
    private ImageView ImporterImage;
    @FXML
    private Label labelconfEmail;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelusername;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField username;
    String img="";
      List<String>type;
      UserSession n = UserSession.getInstance();
    @FXML
    private AnchorPane parent;
    @FXML
    private Label labeldate_naissance;
    @FXML
    private Label labeldate_inscrit;
    @FXML
    private Label labelprenom;
    @FXML
    private Label labelnom;
    @FXML
    private ImageView ImporterImageCheck;
    @FXML
    private ImageView date_inscritCheck;
    @FXML
    private ImageView date_naissanceCheck;
    @FXML
    private ImageView Confirmation_passwordCheck;
    @FXML
    private ImageView rolesCheck;
    @FXML
    private ImageView prenomCheck;
    @FXML
    private ImageView phoneCheck;
    @FXML
    private ImageView passwordCheck;
    @FXML
    private ImageView genreCheck;
    @FXML
    private ImageView nomCheck;
    @FXML
    private ImageView ccnfirmation_emailCheck;
    @FXML
    private ImageView emailCheck;
    @FXML
    private ImageView usernameCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            // TODO
            type=new ArrayList<>();
            type.add("*.jpg");
            type.add("*.png");  
            
            Serviceuser user_ser= new Serviceuser();
            user uu = new user(); 
            uu.setUsername(n.getUsername());
            user u =user_ser.getuser(uu);
            
            nom.setText(u.getFirstname());
            prenom.setText(u.getLastname()); 
            email.setText(u.getEmail());
            password.setText(u.getPassword());
          
        
            username.setText(u.getUsername());
        
        } catch (SQLException ex) {
            Logger.getLogger(GererprofilController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
       
    }    

    private void image(ActionEvent event) {
          FileChooser f=new FileChooser();
        
            f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png files", type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            ImporterImage.setImage(i);
        }
    }

    @FXML
    private void verifPrenom(KeyEvent event) {
    }


    @FXML
    private void verifNom(KeyEvent event) {
    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) throws SQLException, IOException {
        
          Serviceuser cs = new Serviceuser();
        user uu = new user(); 
            uu.setUsername(n.getUsername());
            user u =cs.getuser(uu);
            
       
         String nnom = nom.getText();
       String pprenom = prenom.getText(); 
        String mmot_de_passe = password.getText(); 
       
        String uusername = username.getText();
                  
                    String eemail = email.getText();
        cs.update(new user(uusername,eemail,mmot_de_passe,nnom,pprenom),u.getId()); 
     JOptionPane.showMessageDialog(null, "parametre modifié");
    AnchorPane pane = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/Gererprofil.fxml"));
         parent.getChildren().setAll(pane);  
        
        
    }

    @FXML
    private void controlMdp(KeyEvent event) {
    }

    @FXML
    private void verifEmail(KeyEvent event) {
        
    }

    @FXML
    private void verifusername(KeyEvent event) {
    }
    
}
