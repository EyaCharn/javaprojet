/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import static caritaspidev.controller.FXMLhebergementController.isInteger;
import caritaspidev.entityHebergement.hebergement;
import caritaspidev.services.Servicehebergement;
import com.jfoenix.controls.JFXTabPane;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Maissa
 */
public class ModifierhebergemntController {
    @FXML
    private JFXTabPane Tabpane;

    @FXML
    private Tab Tabsrv;

    @FXML
    private HBox hbox;

    @FXML
    private Label Lblsrv;

    @FXML
    private HBox hbox2;

    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    private TextField textfield3;

    @FXML
    private DatePicker textfield4;

    @FXML
    private TextArea textarea;

    @FXML
    private TextArea textarea2;

    @FXML
    private HBox hbox4;

    @FXML
    private Button Btnimage;

    @FXML
    private ImageView importeimage;

    @FXML
    private HBox hbox5;

    @FXML
    private Button Btnajouter;

    @FXML
    private VBox vbox;

    @FXML
    private Button Btnannuler;

    @FXML
    private Tab Tabstat;

    @FXML
    void New(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
        
         if (textfield1.getText().equals(""))
         {                
                Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
                 .text("  Veillez enter la duree maximale d'accueil");
                n.showError();
        }
         else if (!isInteger(textfield1.getText()))
           {     
                Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
               .text("  Le Valeur du ce champ doit être un entier ");
                n.showError();          
   
          }
         else if (textfield2.getText().equals(""))
         {                
                      Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
                      .text("  Veillez enter le nombre des places disponibles ");
                      n.showError();
        }
           else if (!isInteger(textfield2.getText()))
           {     
               Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
               .text("  Le nombre des places doit etre un entier  ");
                n.showError();          
   
          }
           
              
        
            else  {
            
            
                this.hebergement=hebergement;
                hebergement.setDureemax(textfield1.getText());
                hebergement.setNbplaces(textfield2.getText());
                hebergement.setAdresse(textfield3.getText());
                hebergement.setDescription(textarea.getText());
                hebergement.setImage(path);
               hebergement.setReglement(textarea2.getText());
               //hebergement.setImage(importeimage.getText());
               
         
                buttonConfimClicked = true;
 
            stage.close();
                
          
           
            
             
          
        
           
         }
        

    }

    @FXML
    void annuler(ActionEvent event) {
           stage.close();

    }
         private boolean verificationImage;
  String path;
    File selectedFile;
    @FXML
    void importimg(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
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
          
          
          importeimage.setVisible(true);
          
           importeimage.setImage(image) ;
         
            Btnimage.setText(path);
           
              if(path.equals(""))
            {
            verificationImage=false;
            }
            else 
                  
              { verificationImage=true;}  
               

        }
        

    }
     Servicehebergement services = new Servicehebergement();
    private hebergement hebergement;
        
    private Stage stage;
    private boolean buttonConfimClicked = false;//nous informer est ce que on clicker sur confimer ou annuler
    
     public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isButtonConfimClicked() {
        return buttonConfimClicked;
    }

    public void setButtonConfimClicked(boolean buttonConfimClicked) {
        this.buttonConfimClicked = buttonConfimClicked;
    }

    public hebergement gethebergement() {
        return hebergement;
    }

    public void sethebergement(hebergement hebergement) {
        this.hebergement = hebergement;
        this.textfield1.setText(hebergement. getDureemax());
        this.textfield2.setText(hebergement.getNbplaces());
        this.textfield3.setText(hebergement.getAdresse());
       // this.textfield4.set(String.valueOf(hebergement.getDate()));
        this.textarea.setText(hebergement.getDescription());
         File file = new File("C:\\wamp64\\www\\javaprojet\\web\\uploads\\images\\" + hebergement.getImage());
        javafx.scene.image.Image img;
        try {
            img = new javafx.scene.image.Image(file.toURI().toURL().toString());
             importeimage.setImage(img);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ModifierhebergemntController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.textarea2.setText(hebergement.getReglement());
        
   }
     public static boolean isInteger(String s) {
    try { 
        Double.parseDouble(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    return true;
}
    
    
}
