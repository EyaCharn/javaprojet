/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.entity.formationlike;

/**
 *
 * @author EYA
 */
public class formationlike {
    private int id;
    private int user;
    private int formation;

    public formationlike(int id, int user, int formation) {
        this.id = id;
        this.user = user;
        this.formation = formation;
    }

    public formationlike(int user, int formation) {
        this.user = user;
        this.formation = formation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getFormation() {
        return formation;
    }

    public void setFormation(int formation) {
        this.formation = formation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.user;
        hash = 71 * hash + this.formation;
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
        final formationlike other = (formationlike) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.user != other.user) {
            return false;
        }
        if (this.formation != other.formation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "formationlike{" + "id=" + id + ", user=" + user + ", formation=" + formation + '}';
    }
    
}
