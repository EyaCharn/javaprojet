/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.trainingparticipation;
import java.util.Date;
/**
 *
 * @author EYA
 */
public class traningparticipation {
    private int id;
    private int formaid;
    private int userid;
    private boolean confirm;
    private Date date;
    
   public traningparticipation(int formaid,int userid){
       this.formaid=formaid;
       this.userid=userid;
    
   }
    
    
}
