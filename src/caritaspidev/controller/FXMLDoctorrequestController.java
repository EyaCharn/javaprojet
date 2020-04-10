/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.entityServicesante.doctorRequest;
import caritaspidev.services.Serviceservicesante;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Maissa
 */
public class FXMLDoctorrequestController implements Initializable {
    @FXML
    private Label Lbldoctor;

    @FXML
    private HBox hbox1;

    @FXML
    private TextField adresse;

    @FXML
    private HBox hbox2;

    @FXML
    private TextArea description;

    @FXML
    private HBox hbox3;

    @FXML
    private Button import_id;

    @FXML
    private Button import_doc;
        @FXML
    private ImageView importeid;
            @FXML
    private ImageView importedoc;

    @FXML
    private Button button1;
     List<String> type;
      String cart="";
      String doc="";
          private boolean verificationImage;
  String path;
    File selectedFile;
     private boolean verificationImage2;
  String path2;
    File selectedFile2;

    @FXML
    //void Onclickvalider(ActionEvent event) {
         //try {
            //String descriptionD= description.getText();
            //String adresseD= adresse.getText() ;
            
            
            
          // Serviceservicesante se = new Serviceservicesante();
          //  doctorRequest d= new doctorRequest(descriptionD,adresseD,cart,doc,0);
            
           // se.doctorRequest(d);
           // JOptionPane.showMessageDialog(null, "ajout avec succes");
            //description.clear();
             //adresse.clear();
            
        
            //afficher();
        //} catch (SQLException ex) {
            //Logger.getLogger(FXMLDoctorrequestController.class.getName()).log(Level.SEVERE, null, ex);
       // }

    //}
    
     private void importer_cart(ActionEvent event) {
         FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image"); 
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            path = selectedFile.getName();
          Image image = new Image(selectedFile.toURI().toString());
           importeid.setImage(image) ;
            import_id.setText(path);
            if(path.equals(""))
            {
            verificationImage=false;
            }
            else 
                  
              { verificationImage=true;}  
               

        }

        
    }
     @FXML
     private void importer_doc(ActionEvent event) {
          FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image"); 
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile2 = fc.showOpenDialog(null);

        if (selectedFile2 != null) {

            path2 = selectedFile2.getName();
          Image image = new Image(selectedFile2.toURI().toString());
           importedoc.setImage(image) ;
            import_doc.setText(path2);
            if(path2.equals(""))
            {
            verificationImage2=false;
            }
            else 
                  
              { verificationImage2=true;}  

        }
 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
      
    
}
