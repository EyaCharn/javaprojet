/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import static caritaspidev.controller.FXMLhebergementController.isInteger;
import static caritaspidev.controller.RegistrationController.loadWindow;
import caritaspidev.entityServicesante.servicesante;
import caritaspidev.services.Serviceservicesante;
import com.jfoenix.controls.JFXTabPane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeJava.type;
import org.controlsfx.control.Notifications;
 

/**
 *
 * @author Maissa
 */
public class FXMLServicesanteController implements Initializable {
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
    private ImageView importemotiv;
    @FXML
    private ImageView importecv;
      

    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    private TextArea textarea;

    @FXML
    private HBox hbox4;

    @FXML
    private Button Btnmotivation;

    @FXML
    private Button Btncv;

    @FXML
    private HBox hbox5;

    @FXML
    private VBox vbox;

    @FXML
    private Button Btnajouter;

    @FXML
    private Tab Tabstat;
        List<String> type;
      String motiv="";
      String cv="";
      
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
 
     @FXML
    void OnClicknew(ActionEvent event) {
        
           Alert alert = new Alert(Alert.AlertType.ERROR);
        
         if (textfield1.getText().equals(""))
         {                
                Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
                .text("  Veillez enter votre spécialité");
                n.showError();
        }
          else  if (textfield2.getText().equals(""))
         {                
                Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
                .text("  Merci d'entrer la durée maximale de disponibilité");
                n.showError();
        }
          else if (!isInteger(textfield2.getText()))
           {     
                Notifications n = Notifications.create().title("erreur").graphic(null).position(Pos.TOP_CENTER)
               .text("  La durée doit être un entier ");
                n.showError();          
   
          }
        
        
        else {
          try {
            String specialite = textfield1.getText();
            String periode_dispo= textfield2.getText() ;
            
            String commentaire = textarea.getText();
            
          
           
            
            Serviceservicesante se = new Serviceservicesante();
            servicesante s = new servicesante(specialite,periode_dispo,path,path2,commentaire);
            
            se.ajouter(s);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            textfield1.clear();
             textfield1.clear();
            textarea.clear();
        
            //afficher();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLServicesanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
         
    }
      private boolean verificationImage;
  String path;
    File selectedFile;
     private boolean verificationImage2;
  String path2;
    File selectedFile2;
     @FXML
    private void importer_motiv(ActionEvent event) {
          FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png","*.pdf"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            path = selectedFile.getName();
          Image image = new Image(selectedFile.toURI().toString());
           importemotiv.setImage(image) ;
            Btnmotivation.setText(path);
            if(path.equals(""))
            {
            verificationImage=false;
            }
            else 
                  
              { verificationImage=true;}  
              

        }

    }
        @FXML
    private void importer_cv(ActionEvent event) {
             FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image"); 
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png","*.pdf"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf")
        );
        selectedFile2 = fc.showOpenDialog(null);

        if (selectedFile2 != null) {

            path2 = selectedFile2.getName();
//            
          Image image = new Image(selectedFile2.toURI().toString());
           importecv.setImage(image) ;
            Btncv.setText(path2);
            if(path2.equals(""))
            {
            verificationImage2=false;
            }
            else 
                  
              { verificationImage2=true;}  
               


        }  
    }
       public static void loadWindow(URL loc, String title, Stage parentStage) {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            Scene scene = new Scene(parent);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
       @FXML
    void annuler(ActionEvent event) throws IOException{
              loadWindow(getClass().getResource("/caritaspidev/GUI/UserInterface.fxml"), "User interface", null);
    }
      @FXML
    void stat(ActionEvent event) throws IOException{
              loadWindow(getClass().getResource("/caritaspidev/GUI/Statsante.fxml"), "Statistique", null);
    }
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
      
         
    
     
    
    
    
}
