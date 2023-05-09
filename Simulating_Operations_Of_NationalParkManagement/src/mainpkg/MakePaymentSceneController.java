/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MakePaymentSceneController implements Initializable {

    @FXML
    private TextField accountnumberTextField;
    @FXML
    private TextField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmPaymentButtonOnClick(ActionEvent event) {
        if(accountnumberTextField.getText().equals("") || passwordTextField.getText().equals("") ){
         Alert a = new Alert(Alert.AlertType.ERROR);
         a.setTitle("Error Alert");
         a.setHeaderText("Error!");
         a.setContentText("Please Enter All Fields");
         a.showAndWait();
            
        }
        else{
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirming payment...");
        a.setContentText("Do you want to proceed?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //if ok then they get the confirmaton alert 
            showCustomInformationAlert("Transaction Successful");
          Platform.exit(); //exits the entire platform
          System.exit(0);
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("Something went wrong, please try again.."); 
        }
    }
    }
      private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }  

    @FXML
    private void accountnumberTextFieldOnMouseClick(MouseEvent event) {
        accountnumberTextField.clear();
    }

    @FXML
    private void passwordTextFieldOnMouseClick(MouseEvent event) {
            passwordTextField.clear();
    }
}
