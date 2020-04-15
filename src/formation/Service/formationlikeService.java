/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.Service;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.formationlike.formationlike;
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
 * @author EYA
 */
public class formationlikeService  implements Iservice<formationlike>{
    private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    
   public formationlikeService(){
    cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(formationlike t) throws SQLException {
        
                  pre=cnx.prepareStatement("INSERT INTO `caritass`.`formationlike` ( `formation`, `user`) VALUES ( ?, ?);");
      
          pre.setInt(1, t.getFormation());
    pre.setInt(2,t.getUser());

    pre.executeUpdate();
        System.out.println("cbn");
      }
    
    
    
   // public void incrementerjaime(int user,int formation) {
     //   try {
       //     PreparedStatement st = cnx.prepareStatement("update formationlike set valeur_jaime=valeur_jaime+1  WHERE Id_User='" +id_user +"'AND Id_Sujet='"+id_sujet+ "'");
         //   st.executeUpdate();
        //} 
        //catch (SQLException ex) {
          //  Logger.getLogger(JaimeService.class.getName()).log(Level.SEVERE, null, ex);
        //}
    //}
    
    
    
    
    
    

    @Override
    public boolean delete(int id) throws SQLException {
 if(chercher(id))
        {pre=cnx.prepareStatement("delete from `caritass`.`formationlike` where id  = (?);");
        pre.setInt(1,id);
       
                pre.execute();
                System.out.println("valide");
                 return true;}
        System.out.println("n'existe pas");
        return false;    }
    
    
      public boolean delete1(int id) throws SQLException {
      
        pre=cnx.prepareStatement("delete from `caritass`.`formationlike` where formation = (?);");
        pre.setInt(1,id);
       
                pre.execute();
                System.out.println("valide");
                 return true;
       
        
    }

    @Override
    public boolean chercher(int id) throws SQLException {
         String req="select * from formationlike";
        List<Integer> list = new ArrayList<>();
        
        try {
            st=cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(formationlikeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list.contains(id);
    }

    @Override
    public boolean chercher_ajout(formationlike t) throws SQLException {
 String req="select * from formationlike where formation= '"+t.getId()+ "' AND user ='"+t.getUser()+ "'";
        List<formationlike> list = new ArrayList<>();
       
        try {
            st=cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                 
                list.add(new formationlike(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(formationlikeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (list.size()!=0);    }

    @Override
    public boolean update(formationlike t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<formationlike> readAll() throws SQLException {
         String req="select * from formationlike  ";
        List<formationlike> list = new ArrayList<>();
        
        try {
            st=cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                
               
                list.add(new formationlike(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(formationlikeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    }
    
           public boolean chercher_formationLike(formationlike t) throws SQLException {
          String req="select * from formationlike where formation= '"+t.getFormation()+ "' AND user ='"+t.getUser()+ "'";
        List<formationlike> list = new ArrayList<>();
       
        try {
            st=cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                
                formationlike p = new formationlike(rs.getInt(2),rs.getInt(3));
                list.add(p);
               
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(participationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (list.size()!=0);
    }

    }



    

