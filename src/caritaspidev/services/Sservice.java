/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.services;
import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Maissa
 * @param <S>
 */
public interface Sservice<S> {
       void ajouter(S s) throws SQLException;
    
       
   }
