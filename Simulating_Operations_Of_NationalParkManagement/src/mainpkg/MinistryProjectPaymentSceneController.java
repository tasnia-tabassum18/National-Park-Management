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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MinistryProjectPaymentSceneController implements Initializable {

    @FXML
    private ComboBox<String> sectorComboBox;
    @FXML
    private CheckBox onlinepaymentCheckBox;
    @FXML
    private CheckBox offlinepaymentCheckBox;
    @FXML
    private TextField amountTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sectorComboBox.getItems().addAll("Museum", "Safari Park", "Aquarium","Restaurant");
    }    

    @FXML
    private void proceedButtonOnClick(ActionEvent event) {
       if(onlinepaymentCheckBox.isSelected()&&
               offlinepaymentCheckBox.isSelected()|| amountTextField.getText().equals("")){
//if both cb is selecteed error is shown, if no amount is given then error also
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Fatal Error!");
        a.setContentText("Please select a sector and select one checkbox at a time");
        a.showAndWait(); 
       }
       else{
           System.out.println("Entering payment scene for project to select bkash/nagad/dbbl");
           try {
               Parent p = FXMLLoader.load(getClass().getResource("TouristPaymentScene.fxml"));
               Scene newScene = new Scene(p);
               Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
               stg.setTitle(" ");
               stg.setScene(newScene);
               stg.show();
           } catch (IOException ex) {
               Logger.getLogger(MinistryProjectPaymentSceneController.class.getName()).log(Level.SEVERE, null, ex);
           }     
       }
    }
    
    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
        System.out.println("Going back to ministry of forest scene from ministryprojectpayment scene..");
        try {
            Parent p = FXMLLoader.load(getClass().getResource("MinistryofForestDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Ministry Of Forest Dashboard");
            stg.setScene(newScene);       
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(MinistryProjectPaymentSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void amountTextFieldOnMouseClick(MouseEvent event) {
        amountTextField.clear();
    }
    
}
