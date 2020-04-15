/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.entityHebergement.hebergement;
import caritaspidev.services.ServiceDoctorrequest;
 
import caritaspidev.services.Servicehebergement;
import caritaspidev.services.Serviceuser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Maissa
 */
public class ListehebergementController implements Initializable {
     @FXML
    private BorderPane ListeCadeauxBorderPane;

    @FXML
    private ImageView imgpro;

    @FXML
    private JFXButton buttonSupprimerhebergement;

    @FXML
    private JFXButton buttonModifierhebergement;

    @FXML
    private JFXButton buttonAjouterhebergement;

    @FXML
    private JFXCheckBox adresse;

    @FXML
    private JFXCheckBox nbplaces;

    @FXML
    private JFXCheckBox dureemax;

    @FXML
    private TextField Chercherheb;

    @FXML
    private TableView<hebergement> tableviewhebergements;

    @FXML
    private TableColumn<hebergement,String> tablecolonnehebId;

    @FXML
    private TableColumn<hebergement,String> tablecolonnehebduree;

    @FXML
    private TableColumn<hebergement,String> tablecolonnehebAdresse;

    @FXML
    private TableColumn<hebergement,String> tablecolonnehebnbplaces;

    @FXML
    private TableColumn<hebergement,String> tablecolonnehebDescription;

    @FXML
    private TableColumn<hebergement,String> tablecolonnehebImage;

    @FXML
    private TableColumn<hebergement,String> tablecolonnehebDate;
      @FXML
    private TableColumn<hebergement,String> tablecolonnehebReg;
    public static hebergement heb;
     Servicehebergement services = new Servicehebergement();
      private List<hebergement> listhebergements;//retourner liste de la select
    private ObservableList<hebergement> Observablelistehebergements;//pour la table view

    @FXML
    void ChercherHebFonction(KeyEvent event) {
         Serviceuser Service = new Serviceuser();
        List<hebergement> hebergements = new ArrayList<>();

     

                if (adresse.isSelected()) {
       
                    listhebergements = Service.rechercheAvanceeHeb(adresse.getText(), Chercherheb.getText());

                } else if (nbplaces.isSelected()) {
                    
                    
                    listhebergements = Service.rechercheAvanceeHeb(nbplaces.getText(), Chercherheb.getText());

                } else if (dureemax.isSelected()) {
                    listhebergements = Service.rechercheAvanceeHeb(dureemax.getText(), Chercherheb.getText());

                }   
             else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error valeur");
                alert.setHeaderText("???");
                alert.setContentText("Il Faut cocher une valeur");
                alert.show();
                //createtableviewhebergements();
                listhebergements = Service.afficherlisteHeb();

            }
        

        Observablelistehebergements = FXCollections.observableArrayList(listhebergements);//convertir la liste en observable liste
        tableviewhebergements.setItems(Observablelistehebergements);
        //System.out.println(hebergements.toString() + "V" + Valeur.getText());

    }


    @FXML
    void SelectedValue(ActionEvent event) {
        if (adresse.isSelected()) {

            nbplaces.setSelected(false);
            dureemax.setSelected(false);
        

        } else if (nbplaces.isSelected()) {

            adresse.setSelected(false);
            dureemax.setSelected(false);
        
        } else if (dureemax.isSelected()) {

            adresse.setSelected(false);
            nbplaces.setSelected(false);
          
        }   
        

    }
      @FXML
    void back(ActionEvent event)throws IOException {
           setNode(FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/UserInterface.fxml")));

    }
     private void setNode(Node node) {
        ListeCadeauxBorderPane.getChildren().clear();
        ListeCadeauxBorderPane.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.seconds(1));//dure de la translation
        ft.setNode(node);
        ft.setFromValue(0.10);//dispartion 
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }

    @FXML
    void ajouterhebergement(ActionEvent event) throws IOException, SQLException  {
        setNode(FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/FXMLNewhebergement.fxml")));


    }
      @FXML
    void avis(ActionEvent event) throws IOException, SQLException  {
           heb = tableviewhebergements.getSelectionModel().getSelectedItem();

        if (heb != null) {
                 setNode(FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/rating.fxml")));
           
           

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner une proposition");
            alert.show();
        }
     


    }

    @FXML
    void modifierhebergement(ActionEvent event)throws IOException {
           heb = tableviewhebergements.getSelectionModel().getSelectedItem();

        if (heb != null) {

            boolean buttonConfimClicked =   showModifierhebergementsFXML(heb);// ouvrir la page 
            if (buttonConfimClicked) {

                services.update(heb);
                
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner une proposition");
            alert.show();
        }

    }

    @FXML
    void supprimerhebergement(ActionEvent event) {
          heb = tableviewhebergements.getSelectionModel().getSelectedItem();

        if (heb != null) {

            services.delete(heb);
           

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner une proposition");
            alert.show();
        }

    }
      @FXML
  private  void createtableviewhebergements(ActionEvent event) {
       
        
       
        tablecolonnehebId.setCellValueFactory(new PropertyValueFactory<>("id")); 
       tablecolonnehebduree.setCellValueFactory(new PropertyValueFactory<>("dureemax"));
        tablecolonnehebAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
       tablecolonnehebnbplaces.setCellValueFactory(new PropertyValueFactory<>("nbplaces"));
       tablecolonnehebDescription.setCellValueFactory(new PropertyValueFactory<>("description_logement"));
        tablecolonnehebImage.setCellValueFactory(new PropertyValueFactory<>("image_logement"));
        //tablecolonnehebDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tablecolonnehebReg.setCellValueFactory(new PropertyValueFactory<>("reglement_interieur"));
          listhebergements = services.afficher();
         Observablelistehebergements= FXCollections.observableArrayList(listhebergements);//convertir la liste des client en observable liste
        tableviewhebergements.setItems(Observablelistehebergements);


    }
      
  private boolean showModifierhebergementsFXML(hebergement heb) throws IOException {
        

        FXMLLoader loader = new FXMLLoader();//qui va charger la fichier de type fxml
        loader.setLocation(ModifierhebergemntController.class.getResource("/caritaspidev/GUI/FXMLModifierhebergement.fxml"));//ouvrire ce fenetre
        AnchorPane page = (AnchorPane) loader.load(); 
         
        Stage dialogeStage = new Stage();
        //titre
        dialogeStage.setTitle("Modifer hebergement");
         Scene scene = new Scene(page);
        dialogeStage.setScene(scene);
        ModifierhebergemntController controller = loader.getController();
        controller.setStage(dialogeStage);
        controller.sethebergement(heb); 
        dialogeStage.showAndWait(); 
        return controller.isButtonConfimClicked();
    }
         @Override
    public void initialize(URL url, ResourceBundle rb) {}

}
