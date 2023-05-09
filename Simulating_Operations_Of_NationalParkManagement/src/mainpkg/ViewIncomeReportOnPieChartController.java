/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewIncomeReportOnPieChartController implements Initializable {

    @FXML
    private PieChart piechart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadPieChartButtonOnClick(ActionEvent event) {
        try {
            ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
            String name = "";
            String email="";
            Supervisor s = new Supervisor(name,email);
            System.out.println("View income report method is being called on supervisor class..");
            list = s.viewIncomeReport();
            piechart.setData(list);
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(ViewIncomeReportOnPieChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
        System.out.println("Going back to view income report scene from piechart scene..");
        try {
            Parent p = FXMLLoader.load(getClass().getResource("ViewIncomeReportScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setTitle("Income Report Scene");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewIncomeReportOnPieChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
