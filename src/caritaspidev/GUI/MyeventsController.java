/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.controller.LoginController;
import caritaspidev.entity.evenement.evenement;
import caritaspidev.entity.evenement.participation;
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceevenement;
import caritaspidev.services.Servicesparticipation;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class MyeventsController implements Initializable {

    @FXML
    private TableView<evenement> table;
    @FXML
    private TableColumn<evenement, Integer> id;
    @FXML
    private TableColumn<evenement, String> nom;
    @FXML
    private TableColumn<evenement, String> description;
    @FXML
    private TableColumn<evenement, String> date;
    @FXML
    private TableColumn<evenement, String> image;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try{
              
        Servicesparticipation es = new Servicesparticipation();
        int x=LoginController.getIdCnx();
        ArrayList<evenement> even = (ArrayList<evenement>) es.readMyEvents(x);
        ObservableList<evenement> obs = FXCollections.observableArrayList(even);
         table.setItems(obs);
       id.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<evenement,String>("NomEvenement"));
          image.setCellValueFactory(new PropertyValueFactory<evenement,String>("photo"));
        description.setCellValueFactory(new PropertyValueFactory<evenement,String>("description"));
         date.setCellValueFactory(new PropertyValueFactory<>("dateEvenement"));
        
    }    
    
   catch(Exception ex){
              Logger.getLogger(MyeventsController.class.getName()).log(Level.SEVERE, null, ex);
         }
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event) {
           try{
       Serviceevenement us=new Serviceevenement();
        Servicesparticipation es = new Servicesparticipation();
         Integer x=LoginController.getIdCnx();
        user user1 =new user(x);
          evenement e= table.getSelectionModel().getSelectedItem();
       evenement e1 =new evenement();
      us.update(e1,e.getId());
        participation ue=new participation(e,user1);
        es.delete(e.getId(), x);
        ArrayList<evenement> even = (ArrayList<evenement>) es.readMyEvents(x);
        ObservableList<evenement> obs = FXCollections.observableArrayList(even);
         table.setItems(obs);
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("NomEvenement"));
        image.setCellValueFactory(new PropertyValueFactory<>("photo"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
         date.setCellValueFactory(new PropertyValueFactory<>("dateEvenement"));
          
        }
         catch(Exception ex){
              Logger.getLogger(MyeventsController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    }
    

