/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.entityPublicite.actualite;
import caritaspidev.services.ServiceActualite;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;

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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
 * FXML Controller class
 *
 * @author asus
 */
public class ActualiteController implements Initializable {
    @FXML
    private TableView<actualite> table1;
    @FXML
    private TableColumn<actualite,String> tabletitre;
    @FXML
    private TableColumn<actualite,String> tablecontenu;
    @FXML
    private TableColumn<actualite,String> tableimage;
    @FXML
    private TableColumn<actualite,String> tabledajout;
    @FXML
    private TableColumn<actualite,String> tabledmodif;
    @FXML
    private TextField titre;
    @FXML
    private TextField contenu;
    @FXML
    private ImageView importeimage;
    @FXML
    private DatePicker dateajout;
    @FXML
    private DatePicker datemodif;
      String img="";
    List<String> type;

    private actualite cc=null;
    @FXML
    private AnchorPane ap;
    
    @FXML
    private Label erreurcontenu;
    @FXML
    private Label erreurimg;
    @FXML
    private Label erreurdateajout;
    @FXML
    private Label erreurdatemodif;
    @FXML
    private Label erreurtitre;
    @FXML
    private Button imagee;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
           type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
         
          table1.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                cc = (actualite)table1.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                titre.setText(cc.getTitre());
                contenu.setText(cc.getContenu());
                importeimage.setImage(new Image(cc.getImage()));
                LocalDate d1=cc.getDateajout().toLocalDate();
                LocalDate d2=cc.getDatemodif().toLocalDate();
                dateajout.setValue(d1);
                datemodif.setValue(d2);
               
            }
          });
           titre.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            titre.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
           titre.textProperty().addListener(new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       erreurtitre.setText("remplir champ titre");
                   else if(newValue.length()>200)
                       erreurtitre.setText("Max champ titre 200");
                   else
                erreurtitre.setText("");
                }
                
                
            });
           titre.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(titre.getText().length()==0)
                     erreurtitre.setText("remplir champ titre");    
                    
                }
                
            });
            contenu.textProperty().addListener(new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       erreurcontenu.setText("remplir champ contenu");
                   else if(newValue.length()>200)
                       erreurcontenu.setText("Max champ contenu 200");
                   else
                erreurcontenu.setText("");
                }
                
                
            });
           contenu.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(contenu.getText().length()==0)
                     erreurcontenu.setText("remplir champ contenu");    
                    
                }
                
            });
           dateajout.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(dateajout.getValue()==null)
                     erreurdateajout.setText("remplir champ date debut");    
                   
                    
                    
                }
                
            });
            dateajout.valueProperty().addListener((ov, oldValue, newValue) -> {
                 if(newValue==null)
                       erreurdateajout.setText("remplir champ date debut");
                 
                   else
                erreurdateajout.setText("");
                
            
        });
        
            
          datemodif.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(datemodif.getValue()==null)
                     erreurdatemodif.setText("remplir champ date modification");    
                   
                    
                    
                }
                
            });
            datemodif.valueProperty().addListener((ov, oldValue, newValue) -> {
                 if(newValue==null)
                       erreurdatemodif.setText("remplir champ date modification");
                 
                   else
                erreurdatemodif.setText("");
                
            
        });
            imagee.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       erreurimg.setText("remplir champ image");
                   
                   else
                erreurimg.setText("");
                }
                
                
            });
            imagee.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(imagee.getText().length()==0)
                     erreurimg.setText("remplir champ image");    
                    
                }
                
            }); 
           
           
          
    }    

    @FXML
    private void importimage(ActionEvent event) {
          FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg,png",type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            importeimage.setImage(i);

        }
    }

    @FXML
    private void ajouter(ActionEvent event) {
         try {
              if(titre.getText().isEmpty() ||(img.isEmpty()&&cc.getImage().isEmpty())  || contenu.getText().isEmpty() )
        
        {
           
             
         JOptionPane.showMessageDialog(null, "verifer les champs");   
        }else{
            String titre1 = titre.getText();
            String contenu1 = contenu.getText();
            LocalDate dd =dateajout.getValue();
        LocalDate df =datemodif.getValue();
        Date dateajout1 = java.sql.Date.valueOf(dd);
        Date datemodif2 = java.sql.Date.valueOf(df);
            
            ServiceActualite sp = new ServiceActualite();
            actualite e = new actualite(titre1,contenu1,img,dateajout1,datemodif2);
            
            sp.ajouter(e);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            titre.clear();
            contenu.clear();
            dateajout.setValue(null);
            datemodif.setValue(null);
            importeimage.setImage(null);
            afficher();}
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void modifier(ActionEvent event) {
          ServiceActualite cs = new ServiceActualite();
     System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir actualite");
                   
        }else{
              
                   
                
              try {
                  LocalDate dd=dateajout.getValue();
                  LocalDate df=datemodif.getValue();
                  java.sql.Date d1=java.sql.Date.valueOf(dd);
                  java.sql.Date d2=java.sql.Date.valueOf(df);
                  
                  if(img.length()==0)
                      cs.update(new actualite(titre.getText(),contenu.getText(),img,d1,d2),cc.getId());
                  else
                      cs.update(new actualite(titre.getText(),contenu.getText(),img,d1,d2),cc.getId());
                  
                  afficher();
                  JOptionPane.showMessageDialog(null, "actualite modifier");
                  titre.clear();
                  contenu.clear();
                  importeimage.setImage(null);
                  dateajout.setValue(null);
            datemodif.setValue(null);
                  
                  cc=null;
              } catch (SQLException ex) {
                  Logger.getLogger(ActualiteController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
   
    
    }

    @FXML
    private void supprimer(ActionEvent event) {
          ServiceActualite cs = new ServiceActualite();
         actualite cc = (actualite)table1.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir actualite");
                   
        }else{
             try {
                 cs.delete(cc.getId());
                 
                 afficher();
                 
                 JOptionPane.showMessageDialog(null, "actualite supprimer");
                 titre.clear();
                 contenu.clear();
                 importeimage.setImage(null);
                 dateajout.setValue(null);
            datemodif.setValue(null);
                 
                 cc=null;
             } catch (SQLException ex) {
                 Logger.getLogger(ActualiteController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
           
    
    }
    
      private void afficher()
   {    try {
       ServiceActualite sp = new ServiceActualite();
       List events=sp.readAll();
       ObservableList et=FXCollections.observableArrayList(events);
       table1.setItems(et);
       
       tabletitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
       tablecontenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
       tableimage.setCellValueFactory(new PropertyValueFactory<>("photo"));
       tabledajout.setCellValueFactory(new PropertyValueFactory<>("dateajout"));
       tabledmodif.setCellValueFactory(new PropertyValueFactory<>("datemodif"));
       
       
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
   }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
           AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/main/Back.fxml"));
        ap.getChildren().setAll(pane);
    }
    
}
