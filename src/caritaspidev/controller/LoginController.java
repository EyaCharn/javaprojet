/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.entityUser.user;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import caritaspidev.entityUser.UserSession;
import caritaspidev.services.Serviceuser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.openqa.selenium.chrome.ChromeOptions;

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
    private JFXButton btnlogin;
      @FXML
    private Label message;

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
    void Pageregister(ActionEvent event) {
        
          loadWindow(getClass().getResource("/caritaspidev/GUI/Registration.fxml"), "Registration", null);
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
              loadWindow(getClass().getResource("/caritaspidev/GUI/UserInterface.fxml"), "Dashboard", null);
                
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
       loadWindow(getClass().getResource("/caritaspidev/GUI/UserInterface.fxml"), "Dashboard", null);
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
              
                loadWindow(getClass().getResource("/caritaspidev/GUI/UserInterface.fxml"), "Dashboard", null);
                   
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
    
         loadWindow(getClass().getResource("/caritaspidev/GUI/UserInterface.fxml"), "Dashboard", null);
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
    
   @FXML
    void AuthUser(ActionEvent event) throws IOException {
        String domain = "https://google.com";
        String appId = "2514990381939040";
       // String appSecret="fd680e1b441e26a328a8554a8e494153";
        //String authUrl = "https://www.facebook.com/dialog/oauth?type=user_agent&client_id=" + appId + "&client_secret "+appSecret+ "&redirect_uri=" + domain + "&scope=public_profile";
          String authURL="https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain
                 +"&scope=ads_management,publish_actions";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        	ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		

        WebDriver driver = new ChromeDriver ();
        driver.get(authURL);
        String accessToken="fd680e1b441e26a328a8554a8e494153";
        while (true) {

            if (!driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                  System.out.println(accessToken);

                driver.quit();

                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                User user = fbClient.fetchObject("me", User.class);

                message.setText(user.getName());
                //changescene("/GUI/Menu_General.fxml",event); 
                Serviceuser MS = new Serviceuser();
                List<user> la = MS.afficherlisteUtilisateurs();
                Boolean test = false;
                for (user d : la) {
                    if (user.getId().equals(d.getId_facebook())) {
                       
                        UserSession.setId_Connected_Member(d.getId());
                        System.out.println(UserSession.getId_Connected_Member());
                        test = true;

                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("caritaspidev/GUI/Registration.fxml"));
                        Scene scene = new Scene(root);
                        //scene.getStylesheets().add("/CSS/register.css");
                       // stage = (Stage) RegisterButton.getScene().getWindow();
                        stage.close();
                        stage.setScene(scene);
                        stage.show();
                    }
                    if (!test) {

                        user M = new user(user.getFirstName());
                        MS.add(M);
                        List<user> la2 = MS.afficherlisteUtilisateurs();
                        for (user d2 : la2) {
                            if (user.getId().equals(d2.getId_facebook())) {
                                UserSession.setId_Connected_Member(d2.getId());
                            }
                        }
                        System.out.println(UserSession.getId_Connected_Member());

                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("caritaspidev/GUI/Registration.fxml"));
                        Scene scene = new Scene(root);
                       // scene.getStylesheets().add("/CSS/register.css");
                        //stage = (Stage) RegisterButton.getScene().getWindow();
                        stage.close();
                        stage.setScene(scene);
                        stage.show();
                    }

                }

            }
        }
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
   imgProgress.setVisible(false);
 
    }


    
}
