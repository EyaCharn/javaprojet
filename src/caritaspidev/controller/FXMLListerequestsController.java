/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import caritaspidev.entityServicesante.doctorRequest;
import caritaspidev.services.ServiceDoctorrequest ;
 
import com.jfoenix.controls.JFXButton;
import java.io.File;
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
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
    }
             }
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
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }
}
