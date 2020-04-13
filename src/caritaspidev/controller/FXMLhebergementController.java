/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.entityHebergement.hebergement;
 
import caritaspidev.services.Servicehebergement;
 
import com.jfoenix.controls.JFXTabPane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javax.swing.JOptionPane;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Maissa
 */
public class FXMLhebergementController implements Initializable  {
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
    private AnchorPane anchorpaneajouterheb;


    @FXML
    private Button Btnimage;

    @FXML
    private ImageView importeimage;
    private boolean verificationImage;
      String path;
    File selectedFile;


    @FXML
    private HBox hbox5;
    

    @FXML
    private VBox vbox;

    @FXML
    private Button Btnajouter;

    @FXML
    private Tab Tabstat;
     String img="";
     List<String> type;
     private Stage stage;
     
       public Stage getStage() {
             return stage;
                }

        public void setStage(Stage stage) {
            this.stage = stage;
          }

        @Override
    public void initialize(URL url, ResourceBundle rb) {}
     public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    return true;
}
      private void setNode(Node node) {
        anchorpaneajouterheb.getChildren().clear();
        anchorpaneajouterheb.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.seconds(1));//durree de la translation
        ft.setNode(node);
        ft.setFromValue(0.10);//dispartion 
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
      
       

   @FXML
    private void annuler(ActionEvent event) throws IOException {
                 stage.close();

    }

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
           else if (textfield4.getEditor().getText().equals(""))
            { 

                     
                 Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
                 .text("  Veillez enter la date de votre proposition d'hébergement");
                n.showError();
            }
              
        
            else  {    
            try{String duree_max = textfield1.getText();
            String nbplaces = textfield2.getText() ;
            String adresse= textfield3.getText() ;
            LocalDate date= textfield4.getValue() ;
            String description = textarea.getText();
            
            String reglement = textarea2.getText();
            
          
           
            
            Servicehebergement sh = new Servicehebergement();
            hebergement h = new hebergement(duree_max, nbplaces,adresse,description,path,reglement);
            
            sh.ajouter(h);
            JOptionPane.showMessageDialog(null, "Hebergement ajouté  avec succes");
            textfield1.clear();
             textfield2.clear();
             textfield3.clear();
             textarea.clear();
             textarea2.clear();
            importeimage.setImage(null);
        
            //afficher();
            } catch (SQLException ex) {
            Logger.getLogger(FXMLServicesanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
        

    }

    @FXML
    void importimg(ActionEvent event) {
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

    }
    

