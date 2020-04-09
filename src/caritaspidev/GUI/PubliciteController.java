/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.entityPublicite.publicite;
import caritaspidev.services.ServicePublicite;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.CheckBox;
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
 * @author asus
 */
public class PubliciteController implements Initializable {
    @FXML
    private TextField description;
    @FXML
    private ImageView importeimage;
    @FXML
    private CheckBox enable;
    @FXML
    private CheckBox disable;
    @FXML
    private TableView<publicite> table;
    @FXML
    private TableColumn<publicite,String> image;
    @FXML
    private TableColumn<publicite,String> tabviewdescription;
    @FXML
    private TableColumn<publicite,String> etat;
    
    String img="";
    List<String> type;
    boolean eta = true;
    private publicite cc=null;
    ObservableList <publicite> data2 ;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
        type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
       
         
          table.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                cc = (publicite)table.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                description.setText(cc.getDescription());
                importeimage.setImage(new Image(cc.getImage()));
                System.out.println(cc.isEtat());
                if(cc.isEtat()==true) 
                {enable.isSelected();} 
                else{disable.isSelected();} 
                
            }
          });
    }    

    @FXML
    private void importer(ActionEvent event) {
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
     
     private void afficher()
   {    try {
       ServicePublicite sp = new ServicePublicite();
       List events=sp.readAll();
       ObservableList et=FXCollections.observableArrayList(events);
       table.setItems(et);
       
       image.setCellValueFactory(new PropertyValueFactory<>("photo"));
       tabviewdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
       etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
       
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
   }

    @FXML
    private void ajouter(ActionEvent event) {
        try {
            String descriptionP = description.getText();
            String etatt = enable.getText();
            if (enable.isSelected())
            {eta=true;}
            else {eta=false; }
            
            ServicePublicite sp = new ServicePublicite();
            publicite e = new publicite(img,descriptionP,eta);
            
            sp.ajouter(e);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            description.clear();
            importeimage.setImage(null);
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }


    @FXML
    private void modifier(ActionEvent event) {
        ServicePublicite cs = new ServicePublicite();
        
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir publicite");
                   
        }else{ 
            try {
                if (enable.isSelected())
                {eta=true;}
                else {eta=false; }
                if(img.length()==0)
                    cs.update(new publicite(img,description.getText(),eta),cc.getId());
                else
                    cs.update(new publicite(img,description.getText(),eta),cc.getId());
                
                afficher();
                JOptionPane.showMessageDialog(null, "publicite modifier");
                description.clear();
                importeimage.setImage(null);
                
                
                cc=null;
            } catch (SQLException ex) {
                Logger.getLogger(PubliciteController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        
    }
       
    }

    @FXML
    private void supprimer(ActionEvent event) {
         ServicePublicite cs = new ServicePublicite();
         publicite cc = (publicite)table.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir publicite");
                   
        }else{
             try {
                 cs.delete(cc.getId());
                 
                 afficher();
                 
                 JOptionPane.showMessageDialog(null, "publicite supprimer");
                 description.clear();
                 importeimage.setImage(null);
                 
                 
                 cc=null;
             } catch (SQLException ex) {
                 Logger.getLogger(PubliciteController.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
           
    }
    
}
