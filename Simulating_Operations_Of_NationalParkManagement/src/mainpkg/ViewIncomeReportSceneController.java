/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewIncomeReportSceneController implements Initializable {

    @FXML
    private TableView<Transaction> tableView;
    @FXML
    private TableColumn<Transaction, String> nameColumn;
    @FXML
    private TableColumn<Transaction, String> paymentColumn;
    @FXML
    private TableColumn<Transaction, String> amountColumn;
    @FXML
    private TableColumn<Transaction, String> dateColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    nameColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("name"));
    paymentColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("paymentmethod"));
    amountColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("amount"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("date"));
    }    

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        ObjectInputStream ois=null;
        ObservableList<Transaction> transactionList = FXCollections.observableArrayList();
         try {
            Transaction t;
            ois = new ObjectInputStream(new FileInputStream("IncomeReport.bin"));
            while(true){
                t= (Transaction) ois.readObject();
                transactionList.add(t);
            } 
        } catch (Exception ex) {            
            try {
                tableView.setItems(transactionList);
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }        
    }

    @FXML
    private void viewOnPieChartButtonOnClick(ActionEvent event) {
         try {
            Parent p = FXMLLoader.load(getClass().getResource("ViewIncomeReportOnPieChart.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Pie Chart");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewIncomeReportSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
} 

