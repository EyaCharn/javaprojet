/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.main;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityUser.UserSession;
import caritaspidev.controller.UserSession;
import caritaspidev.entityPublicite.likepublicite;
import caritaspidev.entityPublicite.publicite;
import caritaspidev.entityUser.user;
import caritaspidev.services.ServicePublicite;
import caritaspidev.services.Servicelikepublicite;
import com.jfoenix.controls.JFXToolbar;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.Parent;
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
     UserSession n = UserSession.getInstance();
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
   String s1="";
    @FXML
    private AnchorPane panne;

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
         UserSession n = UserSession.getInstance();
                                s1 = n.getUsername();
        try {
            user connecte=getUserConnecte();
            System.out.println("hello ya  "+connecte);
            start1();
            // TODO
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

   
  
    @FXML
    private void logout(ActionEvent event) throws IOException {
        
         n.cleanUserSession(); 
       
       
            AnchorPane page=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/login.fxml"));
        panne.getChildren().setAll(page);
    }

    @FXML
    private void gererhybergement(ActionEvent event) throws IOException {
      AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/AfficherHeb.fxml"));
        ap.getChildren().setAll(pane); 
    }

    @FXML
    private void gerersante(ActionEvent event)throws IOException  {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/servicesante.fxml"));
        ap.getChildren().setAll(pane); 
    }

    @FXML
    private void gererprofile(ActionEvent event) throws IOException {
          AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/Gererprofil.fxml"));
        ap.getChildren().setAll(pane); 
        
    }

    @FXML
    private void offreemploi(ActionEvent event) throws IOException {
         AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/AfficherEmploi.fxml"));
        ap.getChildren().setAll(pane); 
    }
    

    @FXML
    private void gererformation(ActionEvent event) throws IOException {
          AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/AfficherFormation.fxml"));
        ap.getChildren().setAll(pane); }
    

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
          Servicelikepublicite pa=new Servicelikepublicite();
   String req="select * from publicite  ";
   user connecte=getUserConnecte();
        List<VBox> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
             
                 publicite p=new publicite(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getBoolean(4));
                 user u=new user(rs.getInt(1));
              ImageView v=new ImageView(new Image(rs.getString(2)));
                 
        v.setFitHeight(129);
        v.setFitWidth(1125);
       Button bt1=new Button("like");
       if(rs.getBoolean(4)==true){
        if (pa.chercher_ajout(new likepublicite(p.getId(),connecte)))
                         {
                   bt1.setDisable(true);
              }

               VBox v1=new VBox();
               v1.setAlignment(Pos.CENTER);
               v1.setSpacing(10);
               v1.getChildren().addAll(v,bt1);
               list.add(v1);
               NUM_OF_IMGS=list.size();
                   bt1.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        
        System.out.println(p.getId());
        try {
            if (!pa.chercher_ajout(new likepublicite(p.getId(),new user(85)))){
               
                pa.ajouter(new likepublicite(p.getId(),connecte));
                bt1.setDisable(true);
            }else System.out.println("PUB DEJA AIMER");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
});
      
            }}
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

                   public user getUserConnecte() throws SQLException
{

      UserSession n = UserSession.getInstance();
      user cc=new user();
                               String s1 = n.getUsername();
                               Statement stmt1 = con.createStatement();
                              String SQL1 = "SELECT * FROM user  WHERE username ='" +s1+"'";
                               ResultSet rs1 = stmt1.executeQuery(SQL1);
                               while(rs1.next())
                                {
                                    cc.setId(rs1.getInt(1));
                                    cc.setUsername(rs1.getString(3));
                                   
                                           
                                }
        return cc;
                              
    
}

    @FXML
    private void dashboard(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/PubliciteFront.fxml"));
        ap.getChildren().setAll(page);
    }
   
    
}
