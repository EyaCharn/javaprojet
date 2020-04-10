/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event)  throws IOException {
        System.out.println("You clicked me!");
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/login.fxml"));
        //Parent home_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/Registration.fxml"));
        //Parent home_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/Listehebergement.fxml"));
        //Parent home_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/FXMLListedoctorrequest.fxml"));
         //Parent home_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/FXMLNewhebergement.fxml"));
         // Parent home_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/servicesante.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
