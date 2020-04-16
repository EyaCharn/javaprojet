/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityHebergement.avishebergement;
import caritaspidev.entityHebergement.hebergement;
import caritaspidev.entityUser.UserSession;
import caritaspidev.entityUser.user;
import caritaspidev.services.Servicehebergement;
import caritaspidev.services.Serviceuser;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
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
    private TableView<avishebergement> table;

    @FXML
    private TableColumn<avishebergement, String> membre;

    @FXML
    private TableColumn<avishebergement, String> titret;

    @FXML
    private TableColumn<avishebergement, String> commentairet;

    @FXML
    private JFXTextField titre;

    @FXML
    private JFXTextField commentaire;

    @FXML
    private Rating rating;
    hebergement h= ListehebergementController.heb;
     private  static Serviceuser Services=new Serviceuser();
   String  s1;
     private Connection con;
   public RatingController() {
          con = DataSource.getInstance().getConnection();
    }
    @FXML
    void ajouter(ActionEvent event) throws SQLException {
         System.out.println("Hebergement");
      
        user connecte=getUserConnecte();  

        avishebergement a=new avishebergement(connecte,h.getId(),rating.getRating(), titre.getText(),commentaire.getText());
//        avisbonplan a=new avisbonplan(5.0,new User(1), titre.getText(),commentaire.getText(), b);
         
        Servicehebergement sh =new Servicehebergement();
           
         if (!titre.getText().equals("")&& !commentaire.getText().equals("") )
         {
                   sh.ajoutreview(a);
                     new Alert(Alert.AlertType.INFORMATION, "Merci pour votre commentaire").show();
     
         }
         else
         {
                  new Alert(Alert.AlertType.ERROR, "Ecrivez votre commentaire s'il vous plait avant de valider").show();
         }

    }

    @FXML
    void supprimer(ActionEvent event) {
        if (table.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
                     n.showWarning();
        } else {
            ObservableList<avishebergement> heb = table.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment supprimer ce commentaire");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                new Servicehebergement().supprimeravis(heb.get(0).getId());
                System.out.println(heb.get(0).getId());
            }
        }
        list();
    }
     public void list(){
        Servicehebergement bon = new Servicehebergement();
        ArrayList arrayList = (ArrayList) bon.ListeAvis(h.getId());
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table.setItems(observableList);
        

}
    
     
 public user getUserConnecte() throws SQLException
{

                             UserSession n = UserSession.getInstance();
                               user cc=new user();
                               String s1 = n.getUsername();
                               Statement stmt1 = con.createStatement();
                              String SQL1 = "SELECT * FROM user  WHERE username ='" +s1+"'";
                               ResultSet rs1 = stmt1.executeQuery(SQL1);
                               while(rs1.next())
                                {
                                    cc.setId(rs1.getInt(1));
                                    cc.setUsername(rs1.getString(3));
                                   
                                           
                                }
        return cc;
                              
    
}
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       
           
    
            
         
      Servicehebergement sh = new Servicehebergement();
        ArrayList arrayList = (ArrayList) sh.ListeAvis(h.getId());
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table.setItems(observableList);
        membre.setCellValueFactory(new PropertyValueFactory<>("user_id"));
       titret.setCellValueFactory(new PropertyValueFactory<>("title"));
      commentairet.setCellValueFactory(new PropertyValueFactory<>("description"));
        // TODO
     
}
}
