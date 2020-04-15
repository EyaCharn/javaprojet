/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.GUI;
import caritaspidev.connectionBD.DataSource;
import caritaspidev.controller.UserSession;
import caritaspidev.entity.emploi.emploi;
import caritaspidev.entity.formation.participation;
import caritaspidev.entityUser.user;
import caritaspidev.main.CaritasPiDev;
import caritaspidev.services.emploiService;
import com.itextpdf.text.DocumentException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * FXML Controller class
 *
 * @author EYA
 */
public class AfficherEmploiController implements Initializable {
    
    
      @FXML
    private TextField search;

    @FXML
    private ScrollPane scroll;

    @FXML
    private VBox emploicontainer;
    
     private Connection con;
     
     
     
     public AfficherEmploiController() {
          con = DataSource.getInstance().getConnection();
    }
    private Statement ste;
    private PreparedStatement pre;
    String s1 = "";



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            // TODO
            emploicontainer.setSpacing(5);
            displayEmploi();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEmploiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        // TODO
    }    
    
    
   
    private void displayEmploi()  throws SQLException{
 emploiService pa = new emploiService();
        String req = "select * from offre_emplois  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
             java.sql.Date dd=new java.sql.Date(rs.getDate(8).getTime());
        java.sql.Date  df=new java.sql.Date(rs.getDate(9).getTime()); 
            
            
           
            

            emploi a1 = new emploi(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), dd, df);
            ImageView va = new ImageView(new Image(rs.getString(4)));
            va.setFitHeight(170);
            va.setFitWidth(200);
            Label nom = new Label("Titre : " + a1.getTitre());
            Label experience = new Label("Experience : " + a1.getExeperiance());
            Label description = new Label("DEscription du travail : " + a1.getDescription());
            Label email = new Label("Email: " + a1.getEmail());
            
            Label lieu = new Label("le lieu : " + a1.getLieu());

            Label dated = new Label("La date du debut d'embauchement : " + a1.getDateDebut());
            
            Label datef = new Label("La date de fin d'embauchement : " + a1.getDateFin());

            Button bt2=new Button("QR");
            
            
            
             bt2.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) { //bitha heki chas
                     
                         String details ="eyya";
        java.io.ByteArrayOutputStream out = QRCode.from(details).to(ImageType.PNG).stream();
        
        File f =new File ("C:\\Users\\EYA\\Pictures\\A_text,_your_name,_a_number_or_anything..._;)_as_QRcode.png");
        FileOutputStream fos = null;
                     try {
                         fos = new FileOutputStream(f);
                     } catch (FileNotFoundException ex) {
                         Logger.getLogger(AfficherEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                     }
        
                     try {
                         fos.write(out.toByteArray());
                     } catch (IOException ex) {
                         Logger.getLogger(AfficherEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     try { 
                         fos.flush();
                     } catch (IOException ex) {
                         Logger.getLogger(AfficherEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      
              


                      
                 }
             });

            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(experience);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(description);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(email);
             HBox h5 = new HBox();
            h5.setSpacing(10);
            h5.setAlignment(Pos.CENTER);
            h5.getChildren().addAll(lieu);
            HBox h6 = new HBox();
            h6.setSpacing(10);
            h6.setAlignment(Pos.CENTER);
            h6.getChildren().addAll(dated);
              HBox h7 = new HBox();
            h7.setSpacing(10);
            h7.setAlignment(Pos.CENTER);
            h7.getChildren().addAll(datef);
            
             bt2.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                 public void handle(ActionEvent event) { //bitha heki chas
                     
                         QRCodeGenerator qrcode  = new QRCodeGenerator();
                     System.out.println("c button mouhage tsir creation houniiii  ");
                      try {
                         
                         qrcode.qrcode(a1);
                     } catch (IOException ex) {
                         Logger.getLogger(AfficherActualiteController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                               bt2.setDisable(true); 
                      
              


                      
                 }
             });
             
            
            
              
            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            
            v.getChildren().addAll(h1, h2,h3,h4,h5,h6,h7,bt2);
            
            
            
            
                          

            VBox vv = new VBox();
            vv.setAlignment(Pos.CENTER);
            vv.setSpacing(10);
            vv.getChildren().addAll(va);
            HBox No = new HBox();
            No.setSpacing(10);
            No.setAlignment(Pos.CENTER);
            No.getChildren().addAll(vv, v);

            VBox v1 = new VBox();
            v1.setAlignment(Pos.CENTER);
            v1.setSpacing(10);
            v1.getChildren().addAll(No);
            list.add(v1);
            
            
        }
            

       
        
        
        emploicontainer.getChildren().addAll(list);    }   
    
    

    
 

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

             }
    

