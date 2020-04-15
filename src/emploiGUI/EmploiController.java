/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emploiGUI;

import caritaspidev.entity.emploi.emploi;
import caritaspidev.entity.formation.formation;
import caritaspidev.entityPublicite.publicite;
import caritaspidev.services.ServicePublicite;
import caritaspidev.services.emploiService;
import caritaspidev.services.formationService;
import formationGUI.FormationController;
import java.io.File;
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
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author EYA
 */
public class EmploiController implements Initializable {
    @FXML
    private TextField titreE;
    @FXML
    private ImageView imgview;
    @FXML
    private TextField expereience;
    @FXML
    private TextField lieuE;
    @FXML
    private DatePicker debutE;
    @FXML
    private DatePicker finE;
    @FXML
    private TextField desEmp;
    @FXML
    private TextField emailEmp;
    @FXML
    private Label error_name;
     @FXML
    private Label error_img;

    @FXML
    private Label error_lieu;
   @FXML
    private Label error_des;

    @FXML
    private Label error_an;
 @FXML
    private Label error_d;
 @FXML
    private Button imagee;
 @FXML
    private Label error_f;

    @FXML
    private TableView<emploi> tabemploi;
    @FXML
    private TableColumn<emploi,String> titre;
    @FXML
    private TableColumn<emploi,String> image;
    @FXML
    private TableColumn<emploi,String> exp;
    @FXML
    private TableColumn<emploi,String> des;
    @FXML
    private TableColumn<emploi,String> email;
    @FXML
    private TableColumn<emploi,String> lieu;
    @FXML
    private TableColumn<emploi,String> deb;
    
      @FXML
    private Label error_email;

    @FXML
    private TableColumn<emploi,String> fin;
    private emploi cc=null;
    String img="";
    List<String> type;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
         afficher();
         tabemploi.setOnMouseClicked(new EventHandler<MouseEvent>()
                
        {
            @Override
            public void handle(MouseEvent event) {
                cc = (emploi)tabemploi.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                titreE.setText(cc.getTitre());
                expereience.setText(cc.getExeperiance());
                desEmp.setText(cc.getDescription());
                emailEmp.setText(cc.getEmail());
                lieuE.setText(cc.getLieu());
                imgview.setImage(new Image(cc.getImage()));
                
                
                LocalDate d1=cc.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate d2=cc.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                debutE.setValue(d1);
                finE.setValue(d2);
             
                
            }
            
            
        }      
        );
         
          
       titreE.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            titreE.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
       expereience.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    expereience.setText(oldValue);
                   
                }
              
                  
            }
            

              
        });
       titreE.textProperty().addListener(new ChangeListener<String>()
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
            titreE.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(titreE.getText().length()==0)
                     error_name.setText("remplir champ titre");    
                    
                }
                
            });
                titreE.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            titreE.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
                
                
                 debutE.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(debutE.getValue()==null)
                     error_d.setText("remplir champ date debut");    
                   
                    
                    
                }
                
            });
            finE.valueProperty().addListener((ov, oldValue, newValue) -> {
                 if(newValue==null)
                       error_d.setText("remplir champ date debut");
                 
                   else
                error_d.setText("");
                
            
        });
            finE.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                   
                   
                    if(finE.getValue()==null)
                    {error_f.setText("remplir champ date fin");    
                    }
                    if(debutE.getValue()==null)
                      error_d.setText("remplir champ date debut");
                    
              
                    
                     
                  
                         
                }
                
            });
            finE.valueProperty().addListener((ov, oldValue, newValue) -> {
                 if(newValue==null)
                 {
                     error_f.setText("remplir champ date fin");
                }
                 
                
                  
                 else
                 error_f.setText("");
                
            
        });
         
            
             expereience.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       error_an.setText("remplir champ nombre place");
                   else if(newValue.length()>10)
                       error_an.setText("Max champ nombre place  10 nombre");
                   else
                error_an.setText("");
                }
                
                
            });
            expereience.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(expereience.getText().length()==0)
                     error_an.setText("remplir champ nombre d'année");    
                    
                }
                
            });
            
             imagee.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       error_img.setText("remplir champ image");
                   
                   else
                error_img.setText("");
                }
                
                
            });
            imagee.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(imagee.getText().length()==0)
                     error_img.setText("remplir champ image");    
                    
                }
                
            });
            
            
             emailEmp.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(emailEmp.getText().length()==0)
                     error_email.setText("remplir champ email");    
                    
                }
                
            });
             
              
              lieuE.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(lieuE.getText().length()==0)
                     error_lieu.setText("remplir champ lieu");    
                    
                }
                
            });
              
                 
              
              desEmp.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                    if(desEmp.getText().length()==0)
                     error_des.setText("remplir champ description");    
                    
                }
                
            });
              
            
            
            
            
         
         
         
         
    }

    @FXML
    private void importerEmploi(ActionEvent event) {
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
    private void ajouteremploi(ActionEvent event) {
        try {
            String titre = titreE.getText();
            String experience = expereience.getText();
            String description = desEmp.getText();
            String email = emailEmp.getText();
            String lieu = lieuE.getText();
            LocalDate dd =debutE.getValue();
            LocalDate df =finE.getValue();
            Date date_debutE = java.sql.Date.valueOf(dd);
            Date date_finE = java.sql.Date.valueOf(df);
            
            emploiService sp = new emploiService();
            emploi e = new emploi(titre,experience,img,description,email,lieu, date_debutE,date_finE);
            
            sp.ajouter(e);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            titreE.clear();
            expereience.clear();
            desEmp.clear();
            emailEmp.clear();
            lieuE.clear();
            imgview.setImage(null);
            
            debutE.setValue(null);
            finE.setValue(null);
            
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(EmploiController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
  private void afficher()
   {    try {
       emploiService sp = new emploiService();
       List emplois=sp.readAll();
       ObservableList et=FXCollections.observableArrayList(emplois);
       tabemploi.setItems(et);
       
       titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
       exp.setCellValueFactory(new PropertyValueFactory<>("exeperiance"));
       image.setCellValueFactory(new PropertyValueFactory<>("photo"));
       des.setCellValueFactory(new PropertyValueFactory<>("description"));
       email.setCellValueFactory(new PropertyValueFactory<>("email"));
       lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
       deb.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
       fin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        } catch (SQLException ex) {
            Logger.getLogger(EmploiController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   }
    @FXML
    private void modifieremploi(ActionEvent event) {
        emploiService cs = new emploiService();
        
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir emploi");
                   
        }else{
            try {
                LocalDate dd=debutE.getValue();
                LocalDate df=finE.getValue();
                java.util.Date d1=java.sql.Date.valueOf(dd);
                java.util.Date d2=java.sql.Date.valueOf(df);
                
                if(img.length()==0)
                    cs.update(new emploi(titreE.getText(),expereience.getText(),cc.getImage(),desEmp.getText(),emailEmp.getText(),lieuE.getText() , d1, d2),cc.getId());
                else
                    cs.update(new emploi(titreE.getText(),expereience.getText(),img,desEmp.getText(),emailEmp.getText(),lieuE.getText() , d1, d2),cc.getId());
                
                afficher();
                JOptionPane.showMessageDialog(null, "emploi modifier");
                titreE.clear();
                expereience.clear();
                desEmp.clear();
                emailEmp.clear();
                lieuE.clear();
                imgview.setImage(null);
                
                debutE.setValue(null);
                finE.setValue(null);
                cc=null;
            } catch (SQLException ex) {
                Logger.getLogger(EmploiController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }

    @FXML
    private void supprimeremploi(ActionEvent event) {
        emploiService cs = new emploiService();
         emploi cc = (emploi)tabemploi.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir eventemploi");
                   
        }else{
            try {
                cs.delete(cc.getId());
                
                afficher();
                
                JOptionPane.showMessageDialog(null, "emploi supprimer");
                titreE.clear();
                expereience.clear();
                desEmp.clear();
                emailEmp.clear();
                lieuE.clear();
                imgview.setImage(null);
                
                debutE.setValue(null);
                finE.setValue(null);
                cc=null;
            } catch (SQLException ex) {
                Logger.getLogger(EmploiController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
   
    
}