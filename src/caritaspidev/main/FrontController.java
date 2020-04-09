/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.main;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityPublicite.publicite;
import caritaspidev.services.ServicePublicite;
import com.jfoenix.controls.JFXToolbar;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FrontController implements Initializable {
    @FXML
    private JFXToolbar toolbar;
    @FXML
    private ImageView imglogo;
    @FXML
    private Pane pane;
    @FXML
    private Button ab5;
    @FXML
    private Button ab6;
    @FXML
    private Button ab3;
    @FXML
    private Button ab4;
    @FXML
    private Button ab2;
    @FXML
    private Button ab;
    @FXML
    private Button ab1;
    @FXML
    private AnchorPane ap;
    @FXML
    private Button singout;
    @FXML
    private Button ab51;
    @FXML
    private VBox vbox;
    @FXML
    private HBox imgslider;
 private Connection con;
    @FXML
    private ScrollPane scroller;
   

    public FrontController() {
        con = DataSource.getInstance().getConnection();
    }
List<String> type;
    String imgG="";
    int verif=0;
    publicite cc=null;
    
    int user_connectee=0;
      private final double IMG_WIDTH = 1125;
    private final double IMG_HEIGHT = 135;
 
    private int NUM_OF_IMGS ;
    private final int SLIDE_FREQ = 4; // in secs
         
    private Statement ste;
    private PreparedStatement pre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            start1();
            // TODO
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

   
  
    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void gererhybergement(ActionEvent event) {
    }

    @FXML
    private void gerersante(ActionEvent event) {
    }

    @FXML
    private void gererprofile(ActionEvent event) {
    }

    @FXML
    private void offreemploi(ActionEvent event) {
    }

    @FXML
    private void gererformation(ActionEvent event) {
    }

    @FXML
    private void gererevenement(ActionEvent event) {
    }

    @FXML
    private void gereractualite(ActionEvent event) throws IOException {
     AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/AfficherActualite.fxml"));
        ap.getChildren().setAll(pane); }
    

    @FXML
    private void gererreclamation(ActionEvent event) {
    }
    public void start1() throws Exception {
          
   String req="select * from publicite  ";
        List<VBox> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
               
                 publicite p=new publicite(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getBoolean(4));
              ImageView v=new ImageView(new Image(rs.getString(2)));
                 
        v.setFitHeight(129);
        v.setFitWidth(1125);
       
               VBox v1=new VBox();
               v1.setAlignment(Pos.CENTER);
               v1.setSpacing(10);
               v1.getChildren().addAll(v);
               list.add(v1);
               NUM_OF_IMGS=list.size();
      
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgslider.getChildren().addAll(list);
        startAnimation(imgslider);
      }
     private void startAnimation(final HBox hbox) {
        //error occured on (ActionEvent t) line
        //slide action
        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), hbox);
            trans.setByX(-IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
        //eventHandler
        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), hbox);
            trans.setByX((NUM_OF_IMGS - 1) * IMG_WIDTH);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };
 
        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_IMGS; i++) {
            if (i == NUM_OF_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * SLIDE_FREQ), slideAction));
            }
        }
//add timeLine
        Timeline anim = new Timeline(keyFrames.toArray(new KeyFrame[NUM_OF_IMGS]));
 
        anim.setCycleCount(Timeline.INDEFINITE);
        anim.playFromStart();
    } 

   
    
}
