/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AskForLeaveSceneController implements Initializable {

    @FXML
    private DatePicker leaveDatePicker;
    @FXML
    private TextField reasonforLeavetTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reasonforLeavetTextFieldonMouseClick(MouseEvent event) {
        reasonforLeavetTextField.clear();
    }

    @FXML
    private void confirmButtonOnClick(ActionEvent event) {
        System.out.println("Confirm button is clicked..");
    TicketingEmployee t = new TicketingEmployee(emailTextField.getText(),nameTextField.getText());
    System.out.println("Checking all fields..");
      if(emailTextField.getText().equals("")||nameTextField.getText().equals("")
        ||leaveDatePicker.getValue().equals("")||
        reasonforLeavetTextField.getText().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Fatal Error!");
        a.setContentText("Please fill up all fields");
        a.showAndWait(); 
         
        }
        else{
          System.out.println("ask for leave method in ticketing employee class is being called");
          t.askforleave(nameTextField.getText(),emailTextField.getText(),
            reasonforLeavetTextField.getText(),leaveDatePicker.getValue());
         // an alert to confirm
         Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirming payment...");
        a.setContentText("Do you want to proceed?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //if ok then they get the confirmaton alert 
            showCustomInformationAlert("Leave Application has been recorded.");
          Platform.exit(); //exits the entire platform
          System.exit(0);
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("Something went wrong, please try again.."); 
        }
            
        }
    }
    @FXML
    private void nameTextFieldOnMouseClick(MouseEvent event) {
        nameTextField.clear();
        
    }

    @FXML
    private void emailTextFieldOnMouseClick(MouseEvent event) {
        emailTextField.clear();
    }
       private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }  
}
