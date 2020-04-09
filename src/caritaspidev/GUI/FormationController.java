/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;

import caritaspidev.entity.formation.formation;
import caritaspidev.entityPublicite.publicite;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author EYA
 */
public class FormationController implements Initializable {
    @FXML
    private TextField Ftitre;
    @FXML
    private ImageView importerimage;
    @FXML
    private DatePicker Fdate;
    @FXML
    private TextField disable;
    @FXML
    private TableView<formation> table;
    @FXML
    private TableColumn<formation,String> titre;
    @FXML
    private TableColumn<formation,String> nbplaces;
    @FXML
    private TableColumn<formation,String> date;
    @FXML
    private TableColumn<formation,String> lieu;
     @FXML
    private TableColumn<formation,String> description;
    String img="";
    List<String> type;
    boolean eta = true;
    private publicite cc=null;
    ObservableList <publicite> data2 ;
    @FXML
    private ImageView ss;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
