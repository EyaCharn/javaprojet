/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formationGUI;

import caritaspidev.entity.formation.participation;
import caritaspidev.entityUser.user;
import formation.Service.participationService;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author EYA
 */
public class AfficherparticipantsController implements Initializable {
    
    @FXML
    private TableColumn<participation, String> idP;

    @FXML
    private TableColumn<participation, String> confirmerP;

    @FXML
    private TableColumn<participation, String> idforamtion;

    @FXML
    private Button supprimerP;

    @FXML
    private TableColumn<participation, user> usernameP;

    @FXML
    private TableView<participation> table;

    @FXML
    private TableColumn<participation, String> DateP;
     private Connection cnx;

private participation cc=null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        try {
            addButtonToTable();
            afficher();
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherparticipantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void afficher() throws SQLException {
        
        
    
{participationService sp = new participationService();
   List participants=sp.readAll();
       ObservableList et=FXCollections.observableArrayList(participants);
       table.setItems(et);
       
       idP.setCellValueFactory(new PropertyValueFactory<>("id"));
       usernameP.setCellValueFactory(new PropertyValueFactory<>("username"));
       idforamtion.setCellValueFactory(new PropertyValueFactory<>("formaid"));
       DateP.setCellValueFactory(new PropertyValueFactory<>("date"));
       confirmerP.setCellValueFactory(new PropertyValueFactory<>("confirm"));
      
           }



    
}
    private void addButtonToTable() throws SQLException{
         TableColumn actionCol = new TableColumn("Confirmation");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<participation, Void>, TableCell<participation, Void>> cellFactory = new Callback<TableColumn<participation, Void>, TableCell<participation, Void>>() {
            public TableCell<participation, Void> call(final TableColumn<participation, Void> param) {
                final TableCell<participation, Void> cell = new TableCell<participation, Void>() {

                    private final Button btn = new Button("Confirmer");
                    

                    {
                       
                        btn.setOnAction((ActionEvent event) -> {
                       cc = getTableView().getItems().get(getIndex());
                            System.out.println(getTableView().getItems());
                            
                            participationService pa = new participationService();
                            try {
                                if (cc.isConfirm()==true) {
                                  JOptionPane.showMessageDialog(null, "vous avez deja confirmee cette particiapation");   
                                }
                                else
                                { pa.updateParticipationConfirm(cc.getId());
                                afficher();}
                            } catch (SQLException ex) {
                                Logger.getLogger(AfficherparticipantsController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                       
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        actionCol.setCellFactory(cellFactory);

        table.getColumns().add(actionCol);

    }

    @FXML
    private void supprimerP(ActionEvent event) throws SQLException {
        
         participationService cs = new participationService();
         participation cc;
        cc = (participation)table.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir participant");
                   
        }else{
            cs.delete(cc.getId());
    
           afficher();
           
           JOptionPane.showMessageDialog(null, "participant supprimer");
            
        cc=null;
    }
    }
    }
