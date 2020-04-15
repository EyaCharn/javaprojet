/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityUser.user;
import caritaspidev.entityHebergement.hebergement;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maissa
 */
public class Serviceuser {
      private Connection con;
    private Statement ste;
    private PreparedStatement pre;
    public Serviceuser(){
    con = DataSource.getInstance().getConnection();
    }
     /**
     * **************************Partie
     * Compte**********************************
     */
    public void ajouterUtilisateurs(user u) {
        try {
            System.out.println(u.toString());
            String requete = "INSERT INTO user (username,email,enabled,password,"
                    + "roles,firstname,lastname,profile_picture,phone,id_facebook) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            //pst.setString(2, u.getUsername());
            pst.setString(2, u.getEmail());
            //pst.setString(4, u.getEmail());
            pst.setInt(3, u.getEnabled());
            pst.setString(4, u.getPassword());
            pst.setString(5, u.getRoles());
            pst.setString(6, u.getFirstname());
            pst.setString(7, u.getLastname());
           pst.setString(8, u.getImage());
            pst.setString(9, u.getPhone());
            pst.setString(10, u.getId_facebook());
            
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void modifierUtilisateurs(user u) {
        try {
            System.out.println(u.toString());
            String requete = "update user set username=?,username_canonical=?,email=?,email_canonical=?,password=?,enabled=?,roles=?,"
                    + "firstname=?,lastname=?,profile_picture=? id=?";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername_canonical());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getEmail());
             pst.setString(5, u.getPassword());
            pst.setInt(6, u.getEnabled());
           
            pst.setString(7, u.getRoles());
            pst.setString(8, u.getFirstname());
            pst.setString(9, u.getLastname());
            pst.setString(10, u.getImage());
            pst.setInt(11, u.getId());
            pst.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    
       public void modifierEMAILUtilisateurs(user u,int id) {
        try {
            System.out.println(u.toString());
            String requete = "update user set email=?,email_canonical=? where id=?";
            PreparedStatement pst = con.prepareStatement(requete);
           pst.setString(1, u.getEmail());
           pst.setString(2, u.getEmail());
          
          
            pst.setInt(3, id);
            pst.executeUpdate();
            System.out.println("Modification de l'email effectuée avec succés"+u.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
       public void modifierPasswordUtilisateurs(user u,int id) {
        try {
            System.out.println(u.toString());
            String requete = "update user set password=? where id=?";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1, u.getPassword());
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Modification de password effectuée avec succés"+u.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
       public void modifierImageUtilisateurs(user u,int id) {
        try {
            System.out.println(u.toString());
            String requete = "update user set image=? where id=?";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1, u.getImage());
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Modification de l'image effectué avec succés"+u.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public void modifierUtilisateursInformationPersonnel(user u,int id) {
        try {
            System.out.println(u.toString());
            String requete = "update user set username=?,username_canonical=?,roles=?,"
                    + "firstname=?,lastname=? where id=?";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername());
         
           
            pst.setString(3, u.getRoles());
            pst.setString(4, u.getFirstname());
            pst.setString(5, u.getLastname());
        
            
            
            pst.setInt(6, id);
            pst.executeUpdate();
            System.out.println("Modification des information personnelles  effectuée avec succés"+u.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
   
                 
 
         public Boolean verifierpassword(String pword, String uname) {
        String s1 = "";
        String req = "Select password from user where username= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement =con.prepareStatement(req);
            preparedStatement.setString(1, uname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString(1);
               // String s2=uname+"{"+s1+"}";
 
                  
              
                System.out.println("ili 3malnelou deccryptage==>"+Password.checkPassword(pword,s1));
                  //   System.out.println(uname);
                   System.out.println(s1);
                 
         
                if ( (Password.checkPassword(pword,s1))) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    

    public void supprimerUtilisateur(user u) {
        try {
            String requete = "delete from user where id=?";
            PreparedStatement ps = con.prepareStatement(requete);
            ps.setInt(1, u.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<user> afficherlisteUtilisateurs() {
      

        List<user> myListe = new ArrayList<>();
        String requette2 = "select * from user";
        try {

            PreparedStatement pst2 = con.prepareStatement(requette2);
            ResultSet ResListe = pst2.executeQuery(requette2);

            while (ResListe.next()) {

                user p = new user();
                p.setId(ResListe.getInt(1));
                p.setUsername(ResListe.getString(2));
                p.setUsername_canonical(ResListe.getString(3));
                p.setEmail(ResListe.getString(4));
                p.setEmail_canonical(ResListe.getString(5));
                p.setPassword(ResListe.getString(7));
                p.setRoles(ResListe.getString(12));
                p.setFirstname(ResListe.getString(13));
                p.setLastname(ResListe.getString(14));
                p.setImage(ResListe.getString(15));
                p.setId_facebook(ResListe.getString(16));
                myListe.add(p);
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }


        return myListe;

    }
         
    
      public List<String> afficherlisteVolontaires(String r) {
        List<String> list = new ArrayList<String>();
        String req = "select username from user where roles =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
             user   user = new user();
             
      
             user.setUsername( resultSet.getString("username"));
             list.add(user.getUsername());
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public user chercherUtilisateurByUsername(String s) {
        user user = null;
     
        PreparedStatement preparedStatement;
        try {
         preparedStatement = con.prepareStatement("select * from user where username =?");
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  user = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("username_canonical"),
                        resultSet.getString("email"),
                        resultSet.getString("email_canonical"),
                        resultSet.getString("password"),
                        resultSet.getString("enabled"),
                        resultSet.getString("roles"),
                        resultSet.getString("Firstname"),
                        resultSet.getString("Lastname"),
                        resultSet.getString("phone"));
                      
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return null;
        }
        return user;
    }

    public user chercherUtilisateurByid(user U) {
        String sql = "SELECT * FROM user WHERE id=?";
           user user = null;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, U.getId());
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                 
                 user = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                       // resultSet.getString("username_canonical"),
                        resultSet.getString("email"),
                       // resultSet.getString("email_canonical"),
                        resultSet.getString("password"),
                     //   resultSet.getString("enabled"),
                        resultSet.getString("roles"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("profile_picture"),
                        resultSet.getString("phone"));
                 
                }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return user;
    }
    
    public user chercherUtilisateurByid(Integer r) {
        user user = null;
        String req = "select * from user where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
                user = new user( 
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                       // resultSet.getString("username_canonical"),
                        resultSet.getString("email"),
                        //resultSet.getString("email_canonical"),
                        resultSet.getString("password"),
                         
                        
                        
                        resultSet.getString("roles"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                         resultSet.getString("profile_picture"),
                        resultSet.getString("phone"));
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
      
    
      public user chercherUtilisateurByPhoneUsername(String r,String username) {
        user user = null;
        String req = "select * from user where phone =? and username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, r);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
                user = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                       
                        resultSet.getString("email"),
                      
                        resultSet.getString("password"),
            
                        resultSet.getString("roles"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("profile_picture"),
                        resultSet.getString("phone"));
                   
                     
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

     public boolean chercherUtilisateurBylogin(String s) {
        user user = null;
        String req = "select * from user where username =?";
        PreparedStatement preparedStatement;
        try {
         preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  user = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("username_canonical"),
                        resultSet.getString("email"),
                        resultSet.getString("email_canonical"),
                        resultSet.getString("password"),
                        resultSet.getString("enabled"),
                        resultSet.getString("roles"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"));
                        
              }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        return true;
    }
    
         public boolean chercherUtilisateurBypassword(String s, String p) {
        user user = null;
        String req = "select password from user where username =?";
        System.out.println(s + "     " + p);
        PreparedStatement preparedStatement;
        try {
         preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()) {
                  user = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("username_canonical"),
                        resultSet.getString("email"),
                        resultSet.getString("email_canonical"),
                        resultSet.getString("password"),
                        resultSet.getString("enabled"),
                        resultSet.getString("roles"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"));
                       
                    
            }
            System.out.println(user.getPassword());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        if (user.getPassword().equals(p)) {
            return true;

        }
        return false;
    }
    
    
    
     public boolean chercherUtilisateurByEmail(String s) {
        user user = null;
        String req = "select * from user where email =?";
        PreparedStatement preparedStatement;
        try {
         preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  user = new user(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("username_canonical"),
                        resultSet.getString("email"),
                        resultSet.getString("email_canonical"),
                        resultSet.getString("password"),
                        resultSet.getString("enabled"),
                        resultSet.getString("roles"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                       resultSet.getString("phone"));
                        
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        return true;
    }
      public boolean add(user User){
String req = "insert into user (username,email,password,roles,firstname,lastname,profile_picture,phone,id_facebook) values (?,?,?,?,?,?,?,?,?,?,?,?)";
       
   PreparedStatement ps;
try{
            ps = con.prepareStatement(req);
            ps.setString(1, User.getUsername());
            ps.setString(2, User.getEmail());
           ps.setString(3, User.getPassword());
            ps.setString(4, User.getRoles());
            ps.setString(5,User.getFirstname());
            ps.setString(6, User.getLastname());
            ps.setString(7, User.getImage());
            ps.setString(8, User.getPhone());
           
            ps.setString(9, User.getId_facebook());
           if (ps.executeUpdate()==1) {
            return true;
        }else return false;
            
        } catch (SQLException ex) {
            System.err.println("Error Code: " +
                    (ex).getErrorCode());
            System.err.println("Message: " + ex.getMessage());
        }return false;
          
} 

     
      public String Gettype(String s) {
        String s1 = "";
        String req = "select roles from user where username =?";
        PreparedStatement preparedStatement;
        try {
          preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString("roles");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s1;
    }
     
   
     public void changepassword(String s1, String email) {
        try {
            String requete = "update user set password=? where email=? ";
         PreparedStatement preparedStatement = con.prepareStatement(requete);
            preparedStatement.setString(1, s1);
            preparedStatement.setString(2, email);
        
            preparedStatement.executeUpdate();
            System.out.println("Modification effectuée avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
     
     public List<hebergement> rechercheAvanceeHeb(String type, String valeur) {
        Serviceuser myServices = new Serviceuser();
       
        List<hebergement> myList = new ArrayList<hebergement>();
        String requete = null;
 
        try { 
            if (type.equals("adresse")) {
                requete = "SELECT * from hebergement where adresse like '%" + valeur + "%'";
            } else if (type.equals("nbplaces")) {

                 
                
                requete = "SELECT * from hebergement where nbplaces like '%" + valeur + "%'";
            } else if (type.equals("dureemax")) {
                requete = "SELECT * from hebergemnt where dureemax like '%" + valeur + "%'";
            }  
              else if (valeur.equals("")) {
                requete = "SELECT * from hebergement ";
            }

            Statement pst = con.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                hebergement heb = new hebergement();

                heb.setId(rs.getLong(1));
                heb.setDureemax(rs.getString(2));
                heb.setNbplaces(rs.getString(3));
                heb.setAdresse(rs.getString(4));
                heb.setDescription(rs.getString(5));
                heb.setImage(rs.getString(6));
                heb.setReglement(rs.getString(7));

              myList.add(heb);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;

    }
     public List<hebergement> afficherlisteHeb() {
        

        List<hebergement> myListe = new ArrayList<>();
        String requette2 = "select * from hebergement";
        try {

            Statement pst2 = con.prepareStatement(requette2);
            ResultSet ResListe = pst2.executeQuery(requette2);

            while (ResListe.next()) {
                
            
                hebergement heb=new hebergement();

                hebergement p = new hebergement(ResListe.getLong(1), ResListe.getString(2), ResListe.getString(3), ResListe.getString(4),
                        ResListe.getString(5), ResListe.getString(6), ResListe.getString(7));
              
               myListe.add(p);
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }


        return myListe;

    }
     
     
     
      public void deleteUser(user u) {

        String requete2 = "DELETE FROM user WHERE id= ?";

        try {

            PreparedStatement pst = con.prepareStatement(requete2);
            pst.setInt(1, u.getId());

            pst.executeUpdate();
            System.out.println("User deleted");
            //if (SystemTray.isSupported()) {
              //  TrayIconDemo td = new TrayIconDemo();
                //td.displayTraysupprimerUser();
            //} else {
             //   System.err.println("Erreur!!!!");
         //   }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     
    
}
