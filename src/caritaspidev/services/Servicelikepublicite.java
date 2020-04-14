/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;
import caritaspidev.connectionBD.DataSource;
import caritaspidev.entityPublicite.likepublicite;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author asus
 */
public class Servicelikepublicite implements Iservice<likepublicite>{
   private Connection con;
    private Statement ste;
    private PreparedStatement pre;
   
    
    public Servicelikepublicite(){
    con = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(likepublicite t) throws SQLException {
        
       
         String req=("INSERT INTO `caritass`.`likepublicite` ( `idpublicite`) VALUES ('"+t.getIdpublicite()+"');");
    try {
            
            ste=con.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(likepublicite.class.getName()).log(Level.SEVERE, null, ex);
        }   }

    @Override
    public boolean delete(int id) throws SQLException {
       if(chercher(id))
        {pre=con.prepareStatement("delete from `caritass`.`likepublicite` where id   = (?);");
        pre.setInt(1,id);
       
                pre.execute();
                System.out.println("valide");
                 return true;}
        System.out.println("n'existe pas");
        return false;
    }

    @Override
    public boolean chercher(int id) throws SQLException {
        String req="select * from likepublicite";
        List<Integer> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                list.add(rs.getInt(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicelikepublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list.contains(id);
    }

    @Override
    public boolean chercher_ajout(likepublicite t) throws SQLException {
         String req="select * from likepublicite where idpublicite= '"+t.getIdpublicite()+ "' AND idUser ='"+t.getIdUser()+ "'";
        List<likepublicite> list = new ArrayList<>();
       
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                 java.sql.Date d1 = new java.sql.Date(rs.getDate(3).getTime());
                list.add(new likepublicite(rs.getInt(1),rs.getInt(2),d1,rs.getInt(4)));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicelikepublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (list.size()!=0);
    }

    @Override
    public boolean update(likepublicite t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<likepublicite> readAll() throws SQLException {
             String req="select * from  likepublicite ";
        List<likepublicite> list = new ArrayList<>();
        
        try {
            ste=con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
                
              
                list.add(new likepublicite(rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicelikepublicite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list  ;
    }
 

    
}
