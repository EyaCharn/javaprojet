/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.formation;

import java.util.Date;
import java.util.Objects;
import caritaspidev.entityUser.user;
/**
 *
 * @author EYA
 */
public class participation {
     private int id;
    private int formaid;
    private user userid; 
    private String username;
    private boolean confirm ;
    private Date date;
    
    
    

    public participation(int id, int formaid, user userid, String nom, boolean confirm, Date date) {
        this.id = id;
        this.formaid = formaid;
        this.userid = userid;
        this.confirm = confirm;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public participation(int id, int formaid, boolean confirm, Date date) {
        this.id = id;
        this.formaid = formaid;
        this.confirm = confirm;
        this.date = date;
    }

    public participation(int formaid, user userid) {
        this.formaid = formaid;
        this.userid = userid;
        
    }

    public participation(int id, int formaid, Date date) {
        this.id = id;
        this.formaid = formaid;
        this.date = date;
    }
        public participation(int id,String user, int formaid, Date date,Boolean confirm) {
        this.id = id;
        this.username=user;
        this.formaid = formaid;
        this.date = date;
        this.confirm=confirm;
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

    public user getUserid() {
        return userid;
    }

    public void setUserid(user userid) {
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
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.formaid;
        hash = 37 * hash + Objects.hashCode(this.userid);
        hash = 37 * hash + (this.confirm ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.date);
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
        final participation other = (participation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.formaid != other.formaid) {
            return false;
        }
        if (!Objects.equals(this.userid, other.userid)) {
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
        return "participation{" + "id=" + id + ", formaid=" + formaid + ", userid=" + userid + ", username=" + username + ", confirm=" + confirm + ", date=" + date + '}';
    }

   
    
    
    
    
    
    
}
