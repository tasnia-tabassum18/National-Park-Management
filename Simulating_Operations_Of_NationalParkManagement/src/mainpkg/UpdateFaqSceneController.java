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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateFaqSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;
    private TextField faqTextField;
    @FXML
    private TextField q1TextField;
    @FXML
    private TextField ans1TextField;
    @FXML
    private TextField q2TextField;
    @FXML
    private TextField ans2TextField;
    @FXML
    private TextField q3TextField;
    @FXML
    private TextField ans3TextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nameTextFieldOnMouseClick(MouseEvent event) {
        nameTextField.clear();
    }

    @FXML
    private void emailTextFieldOnMouseClick(MouseEvent event) {
        emailTextField.clear();
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
         TicketingEmployee t =new TicketingEmployee(nameTextField.getText(),emailTextField.getText());
    System.out.println("Confirming feedback");
    if(nameTextField.getText().equals("")||emailTextField.getText().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Fatal Error!");
            a.setContentText("Please fill up all fields");
            a.showAndWait(); 
        
    }
    else{
   // String f= faqTextField.getText(); //gets the text written in txtfield 
    t.updateFaq(q1TextField.getText(),ans1TextField.getText(),
           q2TextField.getText(),ans2TextField.getText(),
           q3TextField.getText(),ans3TextField.getText()); //sends feedbacktxtfield as parameter on ticketing emp class to write faq
    System.out.println("going to ticketing emp class to write faq");
    JOptionPane.showMessageDialog(null, "FAQ has been saved successfuly!");
    }
    }

    @FXML
    private void gbackButtonOnClick(ActionEvent event) {
         try {
            System.out.println("Entering Ticketing Employee Dashboard from updateticket count scene");
            
            Parent p = FXMLLoader.load(getClass().getResource("TicketingEmpDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Ticketing Employee Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateFaqSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void q1TextFieldOnMouseClick(MouseEvent event) {
        q1TextField.clear();
    }

    @FXML
    private void ans1TextFieldOnMouseClick(MouseEvent event) {
        ans1TextField.clear();
    }

    @FXML
    private void q2TextFieldOnMouseClick(MouseEvent event) {
          q2TextField.clear();
    }

    @FXML
    private void ans2TextFieldOnMouseClick(MouseEvent event) {
        ans2TextField.clear();
    }

    @FXML
    private void q3TextFieldOnMouseClick(MouseEvent event) {
          q3TextField.clear();
    }

    @FXML
    private void ans3TextFieldOnMouseClick(MouseEvent event) {
        ans3TextField.clear();
    }

    
}
