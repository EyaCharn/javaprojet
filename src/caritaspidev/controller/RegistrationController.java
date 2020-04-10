/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.entityUser.user;
import caritaspidev.services.Password;
import caritaspidev.services.ServiceNotification;
import caritaspidev.services.Serviceuser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Maissa
 */
public class RegistrationController implements Initializable{
    
     @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXComboBox<String> genre;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label labelusername;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelconfEmail;

    @FXML
    private JFXComboBox<String> roles;

    @FXML
    private ImageView ImporterImage;

    @FXML
    private Label inscrirLabel;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXButton annulerBtn;

    @FXML
    private Label labelPhone;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXButton ImporterImagePath;

    @FXML
    private Label labelImage;

    @FXML
    private ImageView usernameCheck;

    @FXML
    private ImageView emailCheck;

    @FXML
    private ImageView ccnfirmation_emailCheck;

    @FXML
    private ImageView nomCheck;

    @FXML
    private ImageView genreCheck;

    @FXML
    private ImageView passwordCheck;

    @FXML
    private ImageView phoneCheck;

    @FXML
    private ImageView prenomCheck;

    @FXML
    private ImageView rolesCheck;

    @FXML
    private ImageView Confirmation_passwordCheck;

    @FXML
    private ImageView date_naissanceCheck;

    @FXML
    private ImageView date_inscritCheck;

    @FXML
    private ImageView ImporterImageCheck;

    @FXML
    private Label labelnom;

    @FXML
    private Label labelprenom;

    @FXML
    private Label labeldate_inscrit;

    @FXML
    
    private Label labeldate_naissance;
        private Serviceuser Services = new Serviceuser();
     String path;
    File selectedFile;
      //liste des roles qu'on vas les remplir dans ini
    List<String> listeroles = new ArrayList<String>();
    ObservableList<String> observableListroles;
    
    //liste des genres qui ont va le remplir dans ini
    List<String> listegenre = new ArrayList<String>();
    ObservableList<String> observableListgenre;
        //les verification qui va faire pour confirmer la registration
    private boolean verificationUserName;
    private boolean verificationUserEmail;
    private boolean verificationUserPhone;
    private boolean verificationUserpasword;
    private boolean verificationImage;

    private boolean verificationUserNom;
    private boolean verificationUserPrenom;
    private boolean verificationUserSexe;
    private boolean verificationUserRole;
      //les verfication de la mot de passe
    boolean containsDigit = false;
    boolean containsLowerCaseLetter = false;
    boolean containsUpperCaseLetter = false;
    boolean containsSpecialCharacter = false;
    boolean length = false;
    

    @FXML
    void closeApplication(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vous allez quitter l'application");
        alert.setHeaderText("Vous allez quitter l'application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }

    }

    @FXML
    void controlMdp(KeyEvent event) {
 }

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

    @FXML
    void handleButtonCancelar(ActionEvent event) {
           labelusername.getScene().getWindow().hide();
        loadWindow(getClass().getResource("/caritaspidev/GUI/Login.fxml"), "Registration", null);

    }
     private boolean Signup() {
         if (roles.getValue() != null) {
             
            verificationUserRole = true;
        } else {  
            verificationUserRole = false;
        }
    
    
        if (ImporterImagePath.getText().equals("Ajouter Photo")) {
         verificationImage = false;
 
        } else {  
            
            
 
            verificationImage = true;
         
        }

        if (verificationImage && verificationUserName && verificationUserEmail  &&
                 verificationUserpasword  && verificationUserNom
                && verificationUserPrenom  && verificationUserRole
                ) {

            return true;
        } else {

            return false;
        }

    }

    @FXML
    void handleButtonConfirmar(ActionEvent event) {
           user u = new user();
        
                String passCrypt = Password.hashPassword(password.getText().trim());

                u.setUsername(username.getText().trim());
                u.setUsername_canonical(username.getText().trim());
                u.setEmail(email.getText().trim());
             
                u.setEnabled(1);
                u.setPassword(passCrypt);
                
          
                
                
                if ((String.valueOf(roles.getValue())).equals("volontaire")) {
                       u.setRoles("a:1:{i:0;s:11:\"ROLE_volontaire\";}");
                } else if ((String.valueOf(roles.getValue())).equals("Admin")) {
                    u.setRoles("a:1:{i:0;s:10:\"ROLE_ADMIN\";}");
                }
                else if ((String.valueOf(roles.getValue())).equals("Medecib")) {
                    u.setRoles("a:1:{i:0;s:10:\"ROLE_Medecin\";}");
                }
                
                else
                {
                u.setRoles("a:1:{i:0;s:17:\"ROLE_Refugie\";}");
                }
                u.setFirstname(nom.getText().trim());
                u.setLastname(prenom.getText().trim());
                //u.setDate_naissance(date_naissance.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));

                // u.setDate_inscription(date_inscrit.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));
               
                u.setImage(path);
                
                if (selectedFile != null)
            {
                
                    //System.out.println(selectedFile.toString());
                    File source = new File(selectedFile.toString());
                    File dest = new File("C:\\wamp64\\www\\javaprojet\\web\\uploads\\images");

                     
                 
            }
                
                Services.ajouterUtilisateurs(u);
                
                user user=new user();
                user.setId(1);
                        
                user= Services.chercherUtilisateurByUsername(u.getUsername());
                System.out.println(user.toString());
                
                System.out.println("Bienvenue");

                labelusername.getScene().getWindow().hide();
                loadWindow(getClass().getResource("/caritaspidev/GUI/login.fxml"), "Login", null);
                ServiceNotification.showNotif("Bienvenue", "Bienvenu dans notre site,Vous Pouvez s'Inscrir maintenant");

  }
    
    
     @FXML
    void image(ActionEvent event)throws MalformedURLException  {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image"); 
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            path = selectedFile.getName();
          Image image = new Image(selectedFile.toURI().toString());
           ImporterImage.setImage(image) ;
            ImporterImagePath.setText(path);
            labelImage.setText("Cliquez sur le button pour la changer!");
              if(path.equals(""))
            {
            verificationImage=false;
            }
            else 
                  
              { verificationImage=true;}  
               

        }

    }

    @FXML
    void typeuser(MouseEvent event) {

    }

    @FXML
    void verifEmail(KeyEvent event) {
         if (Services.chercherUtilisateurByEmail(email.getText().trim()) == true) {
            labelEmail.setText("Email Existe déja");
            verificationUserEmail = false;
        }
        if (Services.chercherUtilisateurByEmail(email.getText().trim()) == false) {//alphanumerique@alphanumerique.com
            String email_pattern = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+" + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
            Pattern pattern = Pattern.compile(email_pattern);
            Matcher matcher = pattern.matcher(email.getText().trim());

            if (matcher.matches()) {       //if   matcher ne contient pas la format   
                labelEmail.setVisible(false);
                labelEmail.setText("Email valide !");
                verificationUserEmail = true;

            } else {
                labelEmail.setVisible(true);
                labelEmail.setText("Email Format invalide !");
                verificationUserEmail = false;

            }
        }

    }

    @FXML
    void verifNom(KeyEvent event) {
                
        int nbNonChar = 0;
            for (int i = 1; i < nom.getText().trim().length(); i++) {
                char ch = nom.getText().charAt(i);
                if (!Character.isLetter(ch)) {
                    nbNonChar++;
                }
            }

            if (nbNonChar == 0 && nom.getText().trim().length() >=3) {
          
            
            verificationUserNom = true;
            } else {
                 verificationUserNom = false;

            }

    }

    @FXML
    void verifPrenom(KeyEvent event) {
         int nbNonChar = 0;
            for (int i = 1; i < prenom.getText().trim().length(); i++) {
                char ch = prenom.getText().charAt(i);
                if (!Character.isLetter(ch)) {
                    nbNonChar++;
                }
            }

            if (nbNonChar == 0 && prenom.getText().trim().length() >=3) {
            
            
            verificationUserPrenom = true;
            } else {
                 verificationUserPrenom = false;

            }

    }

    @FXML
    void verifusername(KeyEvent event) {
      if (Services.chercherUtilisateurBylogin(username.getText().trim()) == true) {
            labelusername.setText("Username existe déja");
            verificationUserName = false;
        }
        if (Services.chercherUtilisateurBylogin(username.getText().trim().trim()) == false) {
            labelusername.setText("Username n'existe pas");
            verificationUserName = true;
        }  

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeroles.add("Admin ");
        listeroles.add("volontaire");
        listeroles.add("Réfugié");
         listeroles.add("Medecin");
        observableListroles = FXCollections.observableList(listeroles);//convertir la liste 
        roles.setItems(observableListroles);

    }
}
