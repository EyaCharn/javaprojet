/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.emploi.emploi;
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceuser;
import caritaspidev.services.emploiService;
import emploiGUI.EmploiController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author EYA
 */
public class AfficheUserController implements Initializable {
    @FXML
    private AnchorPane usercontainer;
    
     private Connection con;
     
         private ObservableList<user> data;

    @FXML
    private TableColumn<user, String> id;
    @FXML
    private TableColumn<user, String> username;
    @FXML
    private TableColumn<user, String> email;
    @FXML
    private TableColumn<user, String> roles;
    @FXML
    private Button btn2;
     //private user cc=null;
    String img="";
    List<String> type;
    
      int n=1;
    @FXML
    private TableView<user> id_tableUser;

    public AfficheUserController() {
        con = DataSource.getInstance().getConnection();
    }
    private Statement ste;
    private PreparedStatement pre;
    String s1 = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
              data = FXCollections.observableArrayList();

       Serviceuser myListe = new Serviceuser();

        myListe.afficherlisteUtilisateurs().forEach((u) -> {

            data.add(u);

        });

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        roles.setCellValueFactory(new PropertyValueFactory<>("roles"));

          id_tableUser.setItems(null);
           id_tableUser.setItems(data);
           
        // TODO
      //  FilteredList<user> filteredData = new FilteredList<>(data, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
       // id_recherche.textProperty().addListener((observable, oldValue, newValue) -> {
         //   filteredData.setPredicate(alo -> {
                // If filter text is empty, display all persons.

           //     if (newValue == null || newValue.isEmpty()) {
             //       return true;
               // }

                // Compare first name and last name of every person with filter text.
                //String lowerCaseFilter = newValue.toLowerCase();

                //if (alo.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                  //  return true; // Filter matches first name.
                //} else if (alo.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                 //   return true; // Filter matches first name.
                //} else if (alo.getRoles().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                  //  return true; // Filter matches first name.
                //} else {
                  //  return false; // Does not match.
                //}
            //});
        //});

        // 3. Wrap the FilteredList in a SortedList. 
       // SortedList<User> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
     //   sortedData.comparatorProperty().bind(id_tableUser.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
       // id_tableUser.setItems(sortedData);
    }

   // @FXML
    //public void navigation_ajout() throws java.io.IOException {
      //  User u = new User();

        //récupération fichier fxml
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutUser.fxml"));
        //récupération du root  à partir du fichier fxml
        //Parent root;
        //try {
          //  root = loader.load();
            //récupération du controller lier au fichier fxml 
            //AjoutUserController dpc = loader.getController();

            //btn1.getScene().setRoot(root);

        //} catch (IOException ex) {
           // Logger.getLogger(AjoutUserController.class.getName()).log(Level.SEVERE, null, ex);
        //}

    //}

    @FXML
    private void SupprimerUser(ActionEvent event) {

        user usertab = (user) id_tableUser.getSelectionModel().getSelectedItem();
//        Action ad = Dialogs.create()
//                .title("TESt")
//                .actions(Dialog.ACTION_OK , Dialog.ACTION_NO)
//                .message("test")
//                .styleClass(Dialog.STYLE_CLASS_NATIVE)
//                .showConfirm();
        if (usertab != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Voulez vous vraiment supprimer cet utilisateur  ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                Serviceuser crud = new Serviceuser();
                //ParentCrud parents = new ParentCrud();
                user u = new user();
                u.setId(usertab.getId());
               // if (parents.verifParent(u.getId())) {
                 //   Parents p = new Parents();
                   // p.setId(u.getId());
                   // parents.deleteParent(p);

                //}
                crud.deleteUser(u);

                //récupération fichier fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheUser.fxml"));
                //récupération du root  à partir du fichier fxml
                Parent root;
                try {
                    root = loader.load();
                    //récupération du controller lier au fichier fxml 
                    AfficheUserController dpc = loader.getController();
                    //             dpc.setLbMessage(id_act.getText());

                    btn2.getScene().setRoot(root);

                } catch (IOException ex) {
                    Logger.getLogger(AfficheUserController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("ooops ! vous devez selectionner un utilisateur ");

                alert.showAndWait();
            }

        }

    }

   // public void envoiModif() throws IOException {
        //récupération fichier fxml
     //   FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierUser.fxml"));
        //récupération du root  à partir du fichier fxml
       // Parent root = loader.load();
        //récupération du controller lier au fichier fxml 
        //ModifierUserController dpc = loader.getController();
        //dpc.setUsername(username.getText());
        //dpc.setEmail(email.getText());
        //dpc.setLbMessage(id_tableUser.getSelectionModel().getSelectedItem().getId() + "");
        //dpc.setUsername(id_tableUser.getSelectionModel().getSelectedItem().getUsername());
        //dpc.setEmail(id_tableUser.getSelectionModel().getSelectedItem().getEmail());

        //btn3.getScene().setRoot(root);

    //}

    //public void GenerateUserPdf() throws SQLException, IOException {
      //  PDFutil pdf = new PDFutil();
        //try {
         //   pdf.listUser();
        //} catch (FileNotFoundException ex) {
          //  Logger.getLogger(AfficheUserController.class.getName()).log(Level.SEVERE, null, ex);
       // } catch (DocumentException ex) {
         //   Logger.getLogger(AfficheUserController.class.getName()).log(Level.SEVERE, null, ex);
        //}
    //}

  //  private void imprimer(ActionEvent event) {
   //     System.out.println(" can I print?");
     //   PrinterJob printerJob = PrinterJob.createPrinterJob();
       // if (printerJob.printPage(id_tableUser)) {
         //   printerJob.endJob();
           // System.out.println("printed");
        //}
    //}

}

    
   
    