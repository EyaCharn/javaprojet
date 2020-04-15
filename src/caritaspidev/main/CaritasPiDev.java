/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.main;

import caritaspidev.entityServicesante.servicesante;
import caritaspidev.entityHebergement.hebergement;
import caritaspidev.services.ServiceDoctorrequest;
import caritaspidev.services.Serviceservicesante;
import caritaspidev.services.Servicehebergement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author asus
 */
public class CaritasPiDev extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
      //  Parent root = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/publicite.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/login.fxml"));
        
                              // Parent root = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/AfficherActualite.fxml"));

        
             Parent root = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/login.fxml"));
        
                //Parent root = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/publicite.fxml"));
                          //Parent root = FXMLLoader.load(getClass().getResource("/formationGUI/formation.fxml"));
                           // Parent root = FXMLLoader.load(getClass().getResource("/formationGUI/Afficherparticipants.fxml"));
                            
                         
                        // Parent root = FXMLLoader.load(getClass().getResource("/emploiGUI/Emploi.fxml"));


               //Parent root = FXMLLoader.load(getClass().getResource("/caritaspidev/main/Front.fxml"));
               Parent root = FXMLLoader.load(getClass().getResource("Back.fxml"));
               
                       // Parent root = FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/AfficherFormation.fxml"));
                
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        //Servicehebergement sh = new Servicehebergement();
        //sh.ajouter(new hebergement("6", "7", "sousse", "large", "NULL", "hhh"));
        
        //sh.afficher().forEach(System.out::println);
        //ServiceDoctorrequest dr= new ServiceDoctorrequest();
        //dr.afficher().forEach(System.out::println);
          launch(args);
    }
    
}
