/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Maissa
 */
 public interface Dservice<D> {
 
    void delete(D d) throws SQLException;
    public List<D> afficher();
    void accepterrequest(D d);
}
