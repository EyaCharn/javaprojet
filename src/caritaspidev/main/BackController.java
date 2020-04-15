/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.main;

import com.jfoenix.controls.JFXToolbar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class BackController implements Initializable {
    @FXML
    private JFXToolbar toolbar;
    @FXML
    private ImageView imglogo;
    @FXML
    private Button singout;
    @FXML
    private Button ab512;
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void gererpublicites(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/publicite.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void gereractualités(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/actualite.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void gererevenements(ActionEvent event) {
    }

    @FXML
    private void gereroffreemploi(ActionEvent event) throws IOException {
          AnchorPane page=FXMLLoader.load(getClass().getResource("/emploiGUI/Emploi.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void gererreclamation(ActionEvent event) {
    }

    @FXML
    private void gererformations(ActionEvent event) throws IOException {
          AnchorPane page=FXMLLoader.load(getClass().getResource("/formationGUI/formation.fxml"));
        pane.getChildren().setAll(page);
    }

    @FXML
    private void gererutilisateur(ActionEvent event) {
    }

    @FXML
    private void gererdemandeservice(ActionEvent event) {
    }

    @FXML
    private void gererparticipation(ActionEvent event) {
    }
    
}
