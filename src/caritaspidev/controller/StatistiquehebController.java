/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caritaspidev.controller;

import caritaspidev.services.Servicehebergement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Maissa
 */
public class StatistiquehebController   implements Initializable {

    @FXML
    private PieChart piechartID;
    
    ObservableList piechartlist= FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //
            stat();
        } catch (SQLException ex) {
            Logger.getLogger(StatistiquehebController.class.getName()).log(Level.SEVERE, null, ex);
        }
        piechartID.getData().addAll(piechartlist);
    }

 public void stat() throws SQLException
    {
        Servicehebergement heb= new Servicehebergement();
    piechartlist= FXCollections.observableArrayList();
    ResultSet rs= heb.statistic();
    while (rs.next())
    {
    piechartlist.add(new PieChart.Data(rs.getString(2),rs.getLong(1)));
    
    }
    
    }     
}
