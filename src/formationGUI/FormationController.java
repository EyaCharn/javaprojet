/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formationGUI;

import caritaspidev.entity.formation.formation;
import caritaspidev.services.formationService;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author EYA
 */
public class FormationController implements Initializable {
    @FXML
    private TextField Ftitre;
    @FXML
    private ImageView imgview;
    @FXML
    private DatePicker Fdate;
    @FXML
    private TextField Placeformation;
    @FXML
    private TextField Flieu;
    @FXML
    private TextField Desformation;
    @FXML
    private TableView<formation> tableview999;
  
 @FXML
    private Label caption;

    @FXML
    private Tab formation;
      @FXML
    private PieChart piechart;

    @FXML
    private TableColumn<formation, String> titre;
    @FXML
    private TableColumn<formation, String> image;
    @FXML
    private TableColumn<formation, String> date;
    @FXML
    private TableColumn<formation, String> nbplaces;
    @FXML
    private TableColumn<formation, String> lieu;
    @FXML
    private TableColumn<formation, String> description;

    
    
     private  formation cc=null;
    String img="";
    List<String> type;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
         afficher();
         tableview999.setOnMouseClicked(new EventHandler<MouseEvent>() {
             
             @Override
            public void handle(MouseEvent event) {
               cc = (formation)tableview999.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                Ftitre.setText(cc.getTitre());
                imgview.setImage(new Image(cc.getImage()));
                LocalDate d1=cc.getDatedebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Fdate.setValue(d1);
                Placeformation.setText(cc.getNbplaces());
                Flieu.setText(cc.getLieu());   
                Desformation.setText(cc.getDescription());
                
    
                
                
                
               
             
                
            }            }
         );
         }

       

    @FXML
    private void importerformation(ActionEvent event) {
     FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg,png",type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imgview.setImage(i);
        }
    }

    @FXML
    private void ajouter(ActionEvent event) {
         try {
            String titre = Ftitre.getText();
             LocalDate dd =Fdate.getValue();
             Date date_Fdate = java.sql.Date.valueOf(dd);
            String nbplaces = Placeformation.getText();
            String lieu = Flieu.getText();
            String description = Desformation.getText();
            formationService sp = new formationService();
            formation e = new formation(titre,img,date_Fdate,nbplaces,lieu,description);
            sp.ajouter(e);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            Ftitre.clear();
            Fdate.setValue(null);
            Placeformation.clear();
            Flieu.clear();
            Desformation.clear();
            imgview.setImage(null);
            
          
            
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }

    @FXML
    private void modifier(ActionEvent event) {
         formationService cs = new formationService();
        
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir une formation");
                   
        }else{
            try {
                LocalDate dd=Fdate.getValue();
                java.util.Date d1=java.sql.Date.valueOf(dd);
                
                if(img.length()==0)
                    cs.update(new formation(Ftitre.getText(),cc.getImage(),d1,Placeformation.getText(),Flieu.getText(),Desformation.getText()),cc.getId());
                else
                    cs.update(new formation(Ftitre.getText(),img,d1,Placeformation.getText(),Flieu.getText(),Desformation.getText()),cc.getId());
                
                afficher();
                JOptionPane.showMessageDialog(null, "formation modifier");
                Ftitre.clear();
                imgview.setImage(null);
                Fdate.setValue(null);

                Placeformation.clear();
                Flieu.clear();
                Desformation.clear();
               
                cc=null;
            } catch (SQLException ex) {
                Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }

    @FXML
    private void supprimer(ActionEvent event) {
         formationService cs = new formationService();
         formation cc = (formation)tableview999.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir eventformation");
                   
        }else{
            try {
                cs.delete(cc.getId());
                
                afficher();
                
                JOptionPane.showMessageDialog(null, "emploi supprimer");
                Ftitre.clear();
                imgview.setImage(null);
                Fdate.setValue(null);

                Placeformation.clear();
                Flieu.clear();
                Desformation.clear();
               
                cc=null;
            } catch (SQLException ex) {
                Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    }

    private void afficher() {
  try {
       formationService sp = new formationService();
       List formations =sp.readAll();
       ObservableList et=FXCollections.observableArrayList(formations);
       tableview999.setItems(et);
       
       titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
       image.setCellValueFactory(new PropertyValueFactory<>("photo"));

       date.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
       nbplaces.setCellValueFactory(new PropertyValueFactory<>("nbplaces"));
       lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
     
        } catch (SQLException ex) {
            Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    
}
