/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.entityevenement.evenement;
import caritaspidev.services.Serviceevenement;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class addevenementController implements Initializable {

    @FXML
    private Button imagee;
    @FXML
    private ImageView imageview;
      String img="";
    List<String> type;
    @FXML
    private DatePicker edate;
    @FXML
    private Button eaj;
    @FXML
    private Button emod;
    @FXML
    private Button esup;
    @FXML
    private TableColumn<evenement, Integer> id;
    @FXML
    private TableColumn<evenement, String> eenom;
    @FXML
    private TableColumn<evenement,  String> eeimag;
    @FXML
    private TableColumn<evenement,  String> eedes;
    @FXML
    private TableColumn<evenement, Integer> eenb;
    @FXML
    private TableColumn<evenement, String> eedate;
    @FXML
    private Button tri;
     private evenement cc=null;
    @FXML
    private TextField enom;
    @FXML
    private TableView<evenement> table_event;
    @FXML
    private TextField edes;
    @FXML
    private TextField enb;
    @FXML
    private TextField search;
    @FXML
    private Label error_name;
    @FXML
    private Label error_img;
    @FXML
    private Label error_des;
    @FXML
    private Label error_nb;

    @FXML
    private void ajoutere(ActionEvent event) throws SQLException {
        
           String NomEvenement = enom.getText();
        
            String description = edes.getText();
        
       
      
        int NbDeParticipants = Integer.parseInt(enb.getText());
        Serviceevenement se = new Serviceevenement();
          LocalDate localDate = edate.getValue();
              String strdate =localDate.toString(); 
        evenement e = new evenement(NomEvenement,img,description,NbDeParticipants,strdate);
       if(enom.getText().isEmpty() ||(img.isEmpty()&&cc.getImage().isEmpty()) || edes.getText().isEmpty() || enom.getText().isEmpty() || enb.getText().isEmpty() )
        
        {
         JOptionPane.showMessageDialog(null, "verifer les champs");}
            
                
            else{
                se.ajouter(e);
                JOptionPane.showMessageDialog(null, "ajout avec succes");
                enom.clear();
                imageview.setImage(null);
                 enom.clear();
                 enb.clear();
                 
                afficher();
                
            }
      
        }
    

    @FXML
    private void modifiere(ActionEvent event) {
    }

    @FXML
    private void supprimere(ActionEvent event) {
    }

    @FXML
    private void trier(ActionEvent event) {
    }

    @FXML
    private void rechercher(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afficher();
        type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
        table_event.setOnMouseClicked(new EventHandler<MouseEvent>()
                
        {
            @Override
            public void handle(MouseEvent event) {
                cc = (evenement)table_event.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                enom.setText(cc.getNomEvenement());
                imageview.setImage(new Image(cc.getImage()));
                 edes.setText(cc.getDescription());
                   int cprix=cc.getNbDeParticipants();
                String nb_PPP=String.valueOf(cprix);
                enb.setText(nb_PPP);
                  LocalDate localDate = edate.getValue();
              String strdate =localDate.toString(); 
            }
    });
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
                 if( edes.getText().length()==0)
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
                  if( edes.getText().length()==0)
                     error_des.setText("remplir champ titre");    
                    
                }
                
            });
                edes.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
             edes.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
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
            
            }
            
                
        
    


    private void afficher() {
    }
}
