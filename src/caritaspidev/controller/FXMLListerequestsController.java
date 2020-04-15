/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.entity.mailing.Mailing;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import caritaspidev.entityServicesante.doctorRequest;
import caritaspidev.entityUser.user;
import caritaspidev.services.ServiceDoctorrequest ;
import caritaspidev.services.Serviceuser;
 
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class FXMLListerequestsController implements Initializable {

 
     @FXML
    private TableView<doctorRequest> table;

    @FXML
    private TableColumn<doctorRequest,String> description;

    @FXML
    private TableColumn<doctorRequest,String> adresse;

    @FXML
    private TableColumn<doctorRequest,String> idcart;

    @FXML
    private TableColumn<doctorRequest,String> document;
    
    @FXML
    private TableColumn<doctorRequest,String> status;
    @FXML
    private TableColumn<doctorRequest,String> idrequest;
    
    @FXML
    private JFXButton doctorequest;
      @FXML
    private JFXButton acceptbutton;

    @FXML
    private JFXButton refusebutton;
    static doctorRequest dr ;

 

     

    @FXML
    void afficher(ActionEvent event) {
        
       ServiceDoctorrequest dr = new ServiceDoctorrequest();
       List events=dr.afficher();
       ObservableList et=FXCollections.observableArrayList(events);
       table.setItems(et);
       
       idrequest.setCellValueFactory(new PropertyValueFactory<>("id")); 
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
       idcart.setCellValueFactory(new PropertyValueFactory<>("id_cart"));
       document.setCellValueFactory(new PropertyValueFactory<>("document"));
        status.setCellValueFactory(new PropertyValueFactory<>("validation"));
        
    
}
    @FXML
    void accepter(ActionEvent event) {
        
        
             if (table.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning();
             }
             else { List<doctorRequest> d = table.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment accepter cette demande");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
               dr = table. getSelectionModel().getSelectedItem();
                new ServiceDoctorrequest().accepterrequest(dr);
               // System.out.println(bon.get(0).getId());
            }}
             
             Serviceuser services=new Serviceuser();
            user user=services.chercherUtilisateurByid(dr.getIduser());
            String to = user.getEmail();
            String subject = "Confirmation Demande";
            String message = "Bienvenue " + user.getFirstname()+ " " + user.getLastname()+ " Votre demande service santé a été  acceptée ,vous pouvez confirmer votre proposition  et  imprimer la demande en papier";
            String usermail = "maissa.benhajsalah@esprit.tn";
            String passmail = "193JFT1798";
             Mailing.send(to, subject, message, usermail, passmail);
                         Notifications n = Notifications.create()
                        .title("Bienvenue")
                        .text("Vous avez accepter la demande et vous avez envoyer une email de confirmation a!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5)); 
    }
     @FXML
    void refuser(ActionEvent event) {
          List<doctorRequest> bon = table.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment refuser cette demande ");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
               dr = table. getSelectionModel().getSelectedItem();
                new ServiceDoctorrequest().refuserrequest(dr);

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
    void back(ActionEvent event) throws IOException{
              loadWindow(getClass().getResource("/caritaspidev/GUI/UserInterface.fxml"), "User interface", null);
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }
}
