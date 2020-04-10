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
public interface Hservice<H> {
    void ajouter(H h) throws SQLException;
    void delete(H h) throws SQLException;
  
    void update(H h) throws SQLException;
      public List<H> afficher();
}
