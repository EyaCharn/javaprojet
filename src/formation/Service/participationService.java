/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.Service;

import caritaspidev.connectionBD.DataSource;
import caritaspidev.entity.formation.participation;
import caritaspidev.entityUser.user;
import caritaspidev.services.formationService;
import java.sql.Connection;
import java.sql.Date;
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
public class participationService implements Iservice<participation>{
     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    
     public participationService(){
    cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(participation e) throws SQLException {
          pre=cnx.prepareStatement("INSERT INTO `caritass`.`training_participation` ( `formaid`, `userid`,`confirm`) VALUES ( ?, ?,?);");
        System.out.println(e.getFormaid());
          pre.setInt(1, e.getFormaid());
    pre.setInt(2,e.getUserid().getId());
   pre.setInt(3,0);
    pre.executeUpdate();
             }

    @Override
    public boolean delete(int id) throws SQLException {
        pre=cnx.prepareStatement("delete from `caritass`.`training_participation` where id  = (?);");
        pre.setInt(1,id);
       
                pre.execute();
         return true;
    }

    @Override
    public boolean chercher(int id) throws SQLException {
String req ="select * from participation";
        List<Integer> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {       
        java.util.Date  df=new java.util.Date(rs.getDate(3).getTime()); 
        list.add(rs.getInt(1));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(formationService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list.contains(id);    }

    @Override
    public boolean chercher_ajout(participation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(participation p, int id) throws SQLException {
  if(chercher(id)){
              
        Date df=new java.sql.Date(p.getDate().getTime()); 
         try {
             pre=cnx.prepareStatement("UPDATE participation SET formaid =? ,date =? WHERE id=?");
            
             pre.setInt(1, p.getFormaid());
             pre.setDate(2, df);
             
             pre.setInt(3,id);
             pre.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(participationService.class.getName()).log(Level.SEVERE, null, ex);
         }
            System.out.println("update valide");
         return true;}
        System.out.println("update invalid: formation nexiste pas");
        return false;    }

    @Override
    public List<participation> readAll() throws SQLException {
String req ="select * from training_participation";
        List<participation> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {      
        java.util.Date  df=new java.util.Date(rs.getDate(5).getTime()); 
        System.out.println("user:"+chercher_usern(rs.getInt(3)));
         
               
              
              participation a = new participation(rs.getInt(1),chercher_usern(rs.getInt(3)),rs.getInt(2), df,rs.getBoolean(4));
              
              System.out.println(a);
               list.add(a);
               }
         } catch (SQLException ex) {
             Logger.getLogger(participationService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;    }
   
    
       public boolean chercher_participation(participation t) throws SQLException {
          String req="select * from training_participation where formaid= '"+t.getFormaid()+ "' AND userid ='"+t.getUserid().getId()+ "'";
        List<participation> list = new ArrayList<>();
       
        try {
            st=cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                
                participation p = new participation(rs.getInt(2),new user(rs.getInt(3)));
                list.add(p);
               
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(participationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (list.size()!=0);
    }
              public String chercher_usern(int t) throws SQLException {
          String req="select * from user where id = '"+t+ "'";
       String username="";
       
        try {
            st=cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                
               username=rs.getString(3);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(participationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (username);
    }
              
        public boolean updateParticipationConfirm(int id) throws SQLException {
  
              
       
         try {
             pre=cnx.prepareStatement("UPDATE training_participation SET confirm =?  WHERE id=?");
            
             pre.setInt(1,1); 
             pre.setInt(2,id);
             pre.executeUpdate();
             System.out.println("update valide");
         } catch (SQLException ex) {
             Logger.getLogger(participationService.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        
   
        return true;    }    

}
