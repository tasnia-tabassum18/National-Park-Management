/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LogIncomeReportSceneController implements Initializable {

    @FXML
    private TextField touristnameTextField;
    @FXML
    private TextField paymentmethodTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private DatePicker paymentDatePicker;
    @FXML
    private TableView<Transaction> tableView;
    @FXML
    private TableColumn<Transaction, String> nameColumn;
    @FXML
    private TableColumn<Transaction, String> paymentmethodColumn;
    @FXML
    private TableColumn<Transaction, String> amountColumn;
    @FXML
    private TableColumn<Transaction, String> dateColumn;
    
private ArrayList<Transaction> transactionArr= new ArrayList<Transaction>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    nameColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("name"));
    paymentmethodColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("paymentmethod"));
    amountColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("amount"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<Transaction, String>("date"));
    }    

    @FXML
    private void touristnameTextFieldOnMouseClick(MouseEvent event) {
        touristnameTextField.clear();
    }

    @FXML
    private void paymentmethodTextFieldOnMouseClick(MouseEvent event) {
        paymentmethodTextField.clear();
    }

    @FXML
    private void amountTextFieldOnMouseClick(MouseEvent event) {
        amountTextField.clear();
    }

    @FXML
    private void logButtonOnClick(ActionEvent event) {
        if(touristnameTextField.getText().equals("")||paymentmethodTextField.getText().equals("")
            ||amountTextField.getText().equals("")||paymentDatePicker.getValue().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Fatal Error!");
        a.setContentText("Please Fill up all fields!");
        a.showAndWait(); 
        }
        else{
          Transaction t = new Transaction(  
               touristnameTextField.getText(),
               paymentmethodTextField.getText(),
               Float.parseFloat(amountTextField.getText()),                 
               paymentDatePicker.getValue()  
                );
        touristnameTextField.setText(null);    paymentmethodTextField.setText(null);
        amountTextField.setText(null);  
        t.display();
        File f = new File("IncomeReport.bin");
        ObjectOutputStream oos=null;
        try {
            if(f.exists())
                oos = new AppendableObjectOutputStream(new FileOutputStream(f,true));
            else
                oos = new ObjectOutputStream(new FileOutputStream(f,true));
            //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Stud.bin"));
            oos.writeObject(t);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
    }

    @FXML
    private void loadreportButtonOnClick(ActionEvent event) {
         ObjectInputStream ois=null;
        ObservableList<Transaction> transactionList = FXCollections.observableArrayList();
         try {
            Transaction t;
            ois = new ObjectInputStream(new FileInputStream("IncomeReport.bin"));
            while(true){
                t= (Transaction) ois.readObject();
                transactionList.add(t);
            }
            //s.display();
            //tableView.getItems().add(s);
           // tableView.setItems(studList);
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
    private void gobackButtonOnClick(ActionEvent event) {
        try {
            System.out.println("going back to ticketing emp scene from log income report scene");
            Parent p = FXMLLoader.load(getClass().getResource("TicketingEmpDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Ticketing Employee Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(LogIncomeReportSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
