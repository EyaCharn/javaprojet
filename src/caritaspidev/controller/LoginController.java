/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.entityUser.user;

import caritaspidev.controller.UserSession;
import caritaspidev.services.Serviceuser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Maissa
 */
public class LoginController implements Initializable {
      @FXML
    private Label inscrirLabel;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXTextField labelusername;

    @FXML
    private JFXPasswordField labelpassword;

    @FXML
    private Hyperlink labelmdo;
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton btnlogin;

    @FXML
    private ImageView imgProgress;
      private user loggedUser;
       private static LoginController instance;
 public static final Map<Integer, user> USERS = new HashMap<>();
    
     public static void loadWindow(URL loc, String title, Stage parentStage) {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
             Scene scene = new Scene(parent);
        
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }  

  

   
     public LoginController() {
        instance = this;
    }

    public static LoginController getInstance() {
        return instance;
    }
    
    
      public user getLoggedUser() {
        return loggedUser;
    }
      
      
  
          private void gotoLogin() {
        try {
             loadWindow(getClass().getResource("/caritaspidev/GUI/login.fxml"), "Dashboard", null);
 
  
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
          
          
         public void userLogout(){
        loggedUser = null;
         gotoLogin();
    }
 

    @FXML
    void Pagelogin(ActionEvent event) {

    }
 
    @FXML
    private void Pagerecupmdp(ActionEvent event) {
         labelusername.getScene().getWindow().hide();
            loadWindow(getClass().getResource("/caritaspidev/GUI/Resetmdp.fxml"), "Resetmdp", null);
        
    }

    @FXML
   
 void Pageregister(ActionEvent event) throws IOException {
        AnchorPane page=FXMLLoader.load(getClass().getResource("/caritaspidev/GUI/Registration.fxml"));
        pane.getChildren().setAll(page);

    }

    @FXML
    void Signup(MouseEvent event) {

    }

    @FXML
    void closeApplication(MouseEvent event) {

    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {
         Serviceuser myServices=new Serviceuser();
        String mdp=labelpassword.getText();
        String username=labelusername.getText();
        
 
         String errorMessage = "";

        if (username == null || username.length() == 0) {
            errorMessage += "Username invalide \n";
        }

        if (mdp  == null || mdp.length() == 0) {
            errorMessage += "Mot de passe invalide \n";
        }

        if (errorMessage.length() != 0) {

       Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error valeur");
            alert.setHeaderText("Invalide input");
            alert.setContentText(errorMessage);
            alert.show();
        } else {

           
        Boolean pas=myServices.verifierpassword(mdp, username);
          
       if (myServices.chercherUtilisateurBylogin(username) && pas==true) {

          if (myServices.Gettype(username).equals("a:1:{i:0;s:17:\"ROLE_ADMIN\";}")) {
         imgProgress.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(3));
        pauseTransition.setOnFinished(ev -> {
                System.out.println("hello Admin");
                
                
                user userConnecter=myServices.chercherUtilisateurByUsername(username);
                  UserSession.getInstace(userConnecter.getUsername(),userConnecter.getImage()); 
              loadWindow(getClass().getResource("/caritaspidev/main/Back.fxml"), "Dashboard", null);
                
                labelusername.getScene().getWindow().hide();
                    Notifications n = Notifications.create()
                        .title("Bienvenue")
                        .text("Vous étes connecté en tant que Administrateur!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5));
                      n.showInformation();
           });
               pauseTransition.play();
            }
          
          
          if (myServices.Gettype(username).equals("a:1:{i:0;s:11:\"ROLE_volontaire\";}")) {
        imgProgress.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(3));
        pauseTransition.setOnFinished(ev -> {
        System.out.println("hello Volontaire");
        user userConnecter=myServices.chercherUtilisateurByUsername(username);
        UserSession.getInstace(userConnecter.getUsername(),userConnecter.getImage());  
       loadWindow(getClass().getResource("/caritaspidev/main/Front.fxml"), "Dashboard", null);
         labelusername.getScene().getWindow().hide();
         Notifications n = Notifications.create()
        .title("Bienvenue")
        .text("Vous étes connecté en tant que Volontaire!")
        .graphic(null)
        .position(Pos.TOP_CENTER)
        .hideAfter(Duration.seconds(5));
          n.showInformation();
           
               });
               pauseTransition.play();
            }
          
          
           if (myServices.Gettype(username).equals("a:1:{i:0;s:11:\"ROLE_Refugie\";}")) {
             
        imgProgress.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(3));
        pauseTransition.setOnFinished(ev -> {
       

 
  
                System.out.println("hello Refugie");
                 user userConnecter=myServices.chercherUtilisateurByUsername(username);
              
                loadWindow(getClass().getResource("/caritaspidev/GUI/Front.fxml"), "Dashboard", null);
                   
                labelusername.getScene().getWindow().hide();
           Notifications n = Notifications.create()
                        .title("Bienvenue")
                        .text("Vous étes connecté en tant que Refugié!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5));
                n.showInformation();
           
                  });
           pauseTransition.play();
            }   
              if (myServices.Gettype(username).equals("a:1:{i:0;s:12:\"ROLE_Medecin\";}")) {
        imgProgress.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(3));
        pauseTransition.setOnFinished(ev -> {
        System.out.println("hello Medecin");
        user userConnecter=myServices.chercherUtilisateurByUsername(username);
    
         loadWindow(getClass().getResource("/caritaspidev/GUI/Front.fxml"), "Dashboard", null);
         labelusername.getScene().getWindow().hide();
         Notifications n = Notifications.create()
        .title("Bienvenue")
        .text("Vous étes connecté en tant que Medecin!")
        .graphic(null)
        .position(Pos.TOP_CENTER)
        .hideAfter(Duration.seconds(5));
          n.showInformation();
           
               });
               pauseTransition.play();
            }
       
  
      
       }else
       {
       
              Notifications n = Notifications.create()
                        .title("Bienvenue")
                        .text("Username ou mot de passe invalide!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5));
                n.showInformation();
           
        
       
       }
         }
    

    }
    
  
     @Override
    public void initialize(URL url, ResourceBundle rb) {
   imgProgress.setVisible(false);
 
    }


    
}
