



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.trainingparticipation;
import java.util.Date;
import java.util.Objects;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormaid() {
        return formaid;
    }

    public void setFormaid(int formaid) {
        this.formaid = formaid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + this.formaid;
        hash = 31 * hash + this.userid;
        hash = 31 * hash + (this.confirm ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final traningparticipation other = (traningparticipation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.formaid != other.formaid) {
            return false;
        }
        if (this.userid != other.userid) {
            return false;
        }
        if (this.confirm != other.confirm) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "traningparticipation{" + "id=" + id + ", formaid=" + formaid + ", userid=" + userid + ", confirm=" + confirm + ", date=" + date + '}';
    }
    
    
}
