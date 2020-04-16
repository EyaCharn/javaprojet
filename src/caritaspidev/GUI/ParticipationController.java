/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.controller.LoginController;
import caritaspidev.entity.evenement.evenement;
import caritaspidev.entity.evenement.participation;
import caritaspidev.entityUser.user;
import caritaspidev.services.Serviceevenement;
import caritaspidev.services.Servicesparticipation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ParticipationController implements Initializable {

    @FXML
    private Button supprimerP;
    @FXML
    private Button retourner;
    @FXML
    private TableView<participation> table;
    
    @FXML
    private BarChart<String, Integer> chart;
    @FXML
    private Button stat;
     private participation cc=null;
    @FXML
    private TableColumn< participation, Integer> id;
    @FXML
    private TableColumn<participation, Integer> id_event;
    @FXML
    private TableColumn<participation,Integer> id_user;
    @FXML
    private AnchorPane page;
     private Connection cnx;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         afficher();
        loadChart();
    }    
 private void afficher()
   {Servicesparticipation sp = new Servicesparticipation();
   List participants=sp.displayAll();
       ObservableList et=FXCollections.observableArrayList(participants);
       table.setItems(et);
       
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
       id_event.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
       id_user.setCellValueFactory(new PropertyValueFactory<>("idUtilisateur"));
       
    }    

    @FXML
    private void supprimerP(ActionEvent event) {
         Servicesparticipation cs = new Servicesparticipation();
         participation cc;
        cc = (participation)table.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir participant");
                   
        }else{
            cs.deletee(cc.getId());
    
           afficher();
           
           JOptionPane.showMessageDialog(null, "participant supprimer");
            
        cc=null;
    
     
     
         }
    }

    @FXML
    private void loadChart(ActionEvent event) {
          try {
            String query="select NomEvenement,NbDeParticipants FROM evenement ORDER BY   NbDeParticipants";
            XYChart.Series<String,Integer> series = new XYChart.Series<>();
         cnx = DataSource.getInstance().getConnection();
            ResultSet rss = null;
            try {
                rss = cnx.createStatement().executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (rss.next())
            {
                try {
                    series.getData().add(new XYChart.Data<>(rss.getString(1), rss.getInt(2)));
                } catch (SQLException ex) {
                    Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            chart.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void loadChart() {
          try {
            String query="select NomEvenement,NbDeParticipants FROM evenement ORDER BY   NbDeParticipants";
            XYChart.Series<String,Integer> series = new XYChart.Series<>();
         cnx = DataSource.getInstance().getConnection();
            ResultSet rss = null;
            try {
                rss = cnx.createStatement().executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (rss.next())
            {
                try {
                    series.getData().add(new XYChart.Data<>(rss.getString(1), rss.getInt(2)));
                } catch (SQLException ex) {
                    Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            chart.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    

   
    
    

    @FXML
    private void retourner(ActionEvent event) throws IOException {
          AnchorPane pane=FXMLLoader.load(getClass().getResource("addevenement.fxml"));
        page.getChildren().setAll(pane);
    }


  
    
}
