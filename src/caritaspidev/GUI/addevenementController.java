/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.evenement.evenement;
import caritaspidev.entity.evenement.theme;
import caritaspidev.services.Serviceevenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class addevenementController implements Initializable {
  
    
    

    @FXML
    private TextField enom;
    @FXML
    private Label error_name;
    @FXML
    private Button imagee;
    @FXML
    private ImageView imageview;
     String img="";
    List<String> type;
    @FXML
    private Label error_des;
    @FXML
    private TextField edes;
    @FXML
    private TextField enb;
    
    @FXML
    private DatePicker edate;
    
      private evenement cc=null;
    @FXML
    private Button eaj;
    @FXML
    private Button emod;
    @FXML
    private Button esup;
    @FXML
    private TableView<evenement> table_event;
    @FXML
    private TableColumn<evenement, Integer> id;
    @FXML
    private TableColumn<evenement, String> eenom;
    @FXML
    private TableColumn<evenement, String> eeimag;
    @FXML
    private TableColumn<evenement, String> eedes;
    @FXML
    private TableColumn<evenement, String> eenb;
    @FXML
    private TableColumn<evenement, Date> eedate;
    @FXML
    private Button tri;
    private TextField search;
    
    @FXML
    private TableColumn<evenement,Integer> eetheme;
    @FXML
    private TextField etheme;
    @FXML
    private AnchorPane page;
    @FXML
    private Button gerer;
  
   

    @FXML
    private void importer(ActionEvent event) {
          FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png",type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imageview.setImage(i);
        }
    }

    @FXML
    private void ajoutere(ActionEvent event) throws SQLException {
           Serviceevenement sp = new Serviceevenement();
          
     
        int theme= Integer.parseInt(etheme.getText());
         String nom = enom.getText();
          String desc = edes.getText();
       
      
      
      int nb_place= Integer.parseInt(enb.getText());
       
        java.util.Date edate = java.sql.Date.valueOf(this.edate.getValue());
          evenement e = new evenement(theme,nom,img, desc,nb_place, (Date) edate);
            if(enom.getText().isEmpty() || edes.getText().isEmpty() )
             {
             
         JOptionPane.showMessageDialog(null, "verifer les champs");   }
        
             else{ 
       
       
       
       
           
      
       
        sp.ajouter(e);
         JOptionPane.showMessageDialog(null, "ajout avec succes");
         etheme.clear();
         enom.clear();
         edes.clear();
         imageview.setImage(null);
         edes.clear();
          enb.clear();
                
       
       
       
        afficher();}}
    

    @FXML
    private void modifiere(ActionEvent event) throws SQLException { 
         Serviceevenement cs = new Serviceevenement();
     System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir evenement");
                   
        }else{
              
                   
                
              try {
                  LocalDate dd=edate.getValue();
                evenement e = new evenement();
                  int theme = Integer.parseInt(etheme.getText());
                java.sql.Date d1=java.sql.Date.valueOf(dd);
                   int nb_place= Integer.parseInt(enb.getText());

                  
                 
                  
                  
                  if(img.length()==0)
                      cs.update(new evenement(theme,enom.getText(),img,edes.getText(),nb_place,d1),cc.getId());
                  else
                      cs.update(new evenement(theme,enom.getText(),img,edes.getText(),nb_place,d1),cc.getId());
                  
                  afficher();
                  
                  JOptionPane.showMessageDialog(null, "actualite modifier");
                  etheme.clear();
                   enom.clear();
                     imageview.setImage(null);
                   
                  edes.clear();
                  enb.clear();
                
                  edate.setValue(null);
          
                  
                  cc=null;
              } catch (SQLException ex) {
                  Logger.getLogger(ActualiteController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
   
    
          
    }

    @FXML
    private void supprimere(ActionEvent event) throws SQLException {
           Serviceevenement cs = new Serviceevenement();
         evenement cc = (evenement)table_event.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir event");
                   
        }else{
            cs.delete(cc.getId());
    
           afficher();
           
           JOptionPane.showMessageDialog(null, "event supprimer");
          
            enom.clear();
            imageview.setImage(null);
            edes.clear();
             enb.clear();
                
        edate.setValue(null);
       
       
        cc=null;
    }
    }

    @FXML
    private void trier(ActionEvent event) {
          Serviceevenement sp = new Serviceevenement();
       List events=sp.trieParnb();
       ObservableList et=FXCollections.observableArrayList(events);
       table_event.setItems(et);
         
       id.setCellValueFactory(new PropertyValueFactory<>("id_event"));
       eetheme.setCellValueFactory(new PropertyValueFactory<>("id_theme"));
       eeimag.setCellValueFactory(new PropertyValueFactory<>("image"));
       eedes.setCellValueFactory(new PropertyValueFactory<>("description"));
       eenb.setCellValueFactory(new PropertyValueFactory<>("NbDeParticipants"));
       eedate.setCellValueFactory(new PropertyValueFactory<>("dateEvenement"));
           
           
        
    }

    private void rechercher(ActionEvent event) throws SQLException {
           Serviceevenement cs = new Serviceevenement();
        ArrayList AL = (ArrayList) cs.readAll();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<evenement> filteredData = new FilteredList<>(OReservation, p -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getNomEvenement()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_event.comparatorProperty());
        table_event.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(addevenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
        table_event.setOnMouseClicked(new EventHandler<MouseEvent>()
                
        {
              @Override
              public void handle(MouseEvent event) {
                     cc = (evenement)table_event.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                 int ccprixx=cc.getId_theme();
                String nb_PPPP=String.valueOf(ccprixx);
                //etheme.getOnMouseClicked(nb_PPPP);
               enom.setText(cc.getNomEvenement());
                imageview.setImage(new Image(cc.getImage()));
                  edes.setText(cc.getDescription());
                    
                int cprix=cc.getNbDeParticipants();
                String nb_PPP=String.valueOf(cprix);
                enb.setText(nb_PPP);
                
                
                 LocalDate d1=cc.getDateEvenement().toLocalDate();
                 
               edate.setValue(d1);
               
                
              
            }
            
            
        }
                
                
                
        );
          enom.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
          enom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
       enb.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    enb.setText(oldValue);
                   
                }
              
                  
            }
            

              
        });
       enom.textProperty().addListener(new ChangeListener<String>()
            {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if(newValue.isEmpty())
                       error_name.setText("remplir champ titre");
                   else if(newValue.length()>25)
                       error_name.setText("Max champ titre 25");
                   else
                error_name.setText("");
                }
                
                
            });
        enom.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
            @Override
            public void handle(MouseEvent event) {  if(enom.getText().length()==0)
                     error_name.setText("remplir champ Nom");    
                    
                }
                
            });
                enom.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            enom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });

                
                 edes.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       error_des.setText("remplir champ titre");
                   else if(newValue.length()>25)
                       error_des.setText("Max champ titre 25");
                   else
                error_des.setText("");
                }
                
                
            });
             edes.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
            @Override
            public void handle(MouseEvent event) {
                 if(edes.getText().length()==0)
                     error_des.setText("remplir champ Description");    
                    
                }
                
            });
               edes.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
           edes.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });

                 edes.textProperty().addListener(new ChangeListener<String>()
            {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 if(newValue.isEmpty())
                       error_des.setText("remplir champ titre");
                   else if(newValue.length()>25)
                       error_des.setText("Max champ titre 25");
                   else
                error_name.setText("");
                }
                
                
            });
            edes.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
            @Override
            public void handle(MouseEvent event) {
                  if(edes.getText().length()==0)
                     error_des.setText("remplir champ titre");    
                    
                }
                
            });
                edes.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
             edes.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
                
    
    
       
       
     
                  
              }
              
        
    

    private void afficher() throws SQLException {
        Serviceevenement sp = new Serviceevenement();
      List events=sp.readAll();
       ObservableList et=FXCollections.observableArrayList(events);
       table_event.setItems(et);
       
       id.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id"));
        eetheme.setCellValueFactory(new PropertyValueFactory<evenement,Integer>("id_theme"));
       eenom.setCellValueFactory(new PropertyValueFactory<evenement,String>("NomEvenement"));
       eeimag.setCellValueFactory(new PropertyValueFactory<evenement,String>("photo"));
       eedes.setCellValueFactory(new PropertyValueFactory<evenement,String>("description"));
       eenb.setCellValueFactory(new PropertyValueFactory<evenement,String>("NbDeParticipants"));
      eedate.setCellValueFactory(new PropertyValueFactory<evenement,Date>("dateEvenement"));
        
    }

    @FXML
    private void gerer(ActionEvent event) throws IOException {
          AnchorPane pane=FXMLLoader.load(getClass().getResource("participation.fxml"));
        page.getChildren().setAll(pane);
        
    }
    
    
 
    
}

  