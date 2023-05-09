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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GiveFeedBackTouristSceneController implements Initializable {

    @FXML
    private TextField feedbacktextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField usernameTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmButtonOnClick(ActionEvent event) {
   
    Tourist t =new Tourist(emailTextField.getText(),
           phoneTextField.getText(),usernameTextField.getText(),nameTextField.getText());
    System.out.println("Confirming feedback");
    if(usernameTextField.getText().equals("")||nameTextField.getText().equals("")
            ||emailTextField.getText().equals("")||phoneTextField.getText().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Fatal Error!");
            a.setContentText("Please fill up all fields");
            a.showAndWait(); 
        
    }
    else{
    
    String f= feedbacktextField.getText(); //gets the text written in txtfield
    //doesnt work this code 
    t.giveFeedback(f,usernameTextField.getText(),emailTextField.getText(),
     nameTextField.getText(),phoneTextField.getText()); //sends feedbacktxtfield as parameter on tourist class to write the feedback
    System.out.println("here");
     JOptionPane.showMessageDialog(null, "Your review has been recorded, thank you!");
    }
    }
    @FXML
    private void goBackButtonOnClick(ActionEvent event) {
             try {
            System.out.println("going back to tourist dashboard from givefeedback scene");
            Parent p = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Tourist Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void nameTextFieldOnMouseClick(MouseEvent event) {
        nameTextField.clear();
    }

    @FXML
    private void phoneTextFieldOnMouseClick(MouseEvent event) {
        phoneTextField.clear();
    }

    @FXML
    private void emailTextFieldOnMouseClick(MouseEvent event) {
        emailTextField.clear();
    }

    @FXML
    private void usernameTextFieldOnMouseClick(MouseEvent event) {
        usernameTextField.clear();
    }
    
}
