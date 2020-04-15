/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

 
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceuser;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Maissa
 */
public class UserinterfaceController implements Initializable {
    @FXML
    private AnchorPane parent;

    @FXML
    private VBox vbox;

    @FXML
    private Label categorie;

    @FXML
    private Label partenaire;

    @FXML
    private JFXButton btnclose;

    @FXML
    private Label loggeduser;

    @FXML
    private AnchorPane AnchorPane;
    private static Serviceuser myServices = new Serviceuser();
      public static String username;
        public static Integer userid;

    @FXML
    void hebergement(MouseEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/caritaspidev/GUI/Listehebergement.fxml"));
        Parent root = loader.load();
        categorie.getScene().setRoot(root);
    }
      @FXML
    void formation(MouseEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/caritaspidev/GUI/AfficherFormation.fxml"));
        Parent root = loader.load();
        categorie.getScene().setRoot(root);
    }
     private void setNode(Node node) {
        AnchorPane.getChildren().clear();
        AnchorPane.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.seconds(1));//durre de la translation
        ft.setNode(node);
        ft.setFromValue(0.10);//dispartion 
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
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
    void profil(MouseEvent event) throws IOException {
              setNode(FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/ProfileMembre.fxml")));

    }

    @FXML
    void quitter(ActionEvent event) {

        Stage stage = (Stage) btnclose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void servicesante(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/caritaspidev/GUI/servicesante.fxml"));
        Parent root = loader.load();
        categorie.getScene().setRoot(root);

    }
     @FXML
    void accueil(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/caritaspidev/GUI/Front.fxml"));
        Parent root = loader.load();
        categorie.getScene().setRoot(root);

    }
     @FXML
    void doctorrequest(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/caritaspidev/GUI/ListeDoctorrequests.fxml"));
        Parent root = loader.load();
        categorie.getScene().setRoot(root);

    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
    }

}
