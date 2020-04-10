/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.control.Rating;

/**
 *
 * @author Maissa
 */
public class RatingController implements Initializable {
     @FXML
    private Button supprimer;

    @FXML
    private Button ajouterButton;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> membre;

    @FXML
    private TableColumn<?, ?> titret;

    @FXML
    private TableColumn<?, ?> commentairet;

    @FXML
    private JFXTextField titre;

    @FXML
    private JFXTextField commentaire;

    @FXML
    private Rating rating;

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
}
