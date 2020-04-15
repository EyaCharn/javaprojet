/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
 
/**
 *
 * @author Maissa
 */
public class FXMLHomePageController implements Initializable {
      @FXML
    private AnchorPane holderPane;

    @FXML
    private Pane pane;

    @FXML
    private ImageView imglogo;

    @FXML
    private Line line1;

    @FXML
    private JFXButton btnHeberg;

    @FXML
    private JFXButton btnSrv;

    @FXML
    private Line line2;

    @FXML
    private JFXButton BtnCnt;

    @FXML
    private JFXToolbar toolbar;

    @FXML
    void servClick(ActionEvent event) throws IOException {
          Parent service_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/servicesante.fxml"));
        Scene service_page_scene = new Scene(service_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(service_page_scene);
        app_stage.show();
       
      }
       @FXML
    void hebergClick(ActionEvent event)throws IOException {
      Parent hebergement_page_parent = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/FXMLNewhebergement.fxml"));
        Scene hebergement_page_scene = new Scene(hebergement_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(hebergement_page_scene);
        app_stage.show();  

    }
             
           
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    } 

    
     
    
    
    }

