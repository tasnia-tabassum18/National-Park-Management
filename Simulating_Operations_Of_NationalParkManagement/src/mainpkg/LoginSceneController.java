/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> usertypeComboBox;
    @FXML
    private Label usertypeLabel;
    @FXML
    private Button loginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usertypeComboBox.getItems().addAll("Tourist", "Supervisor","Ticketing Employee",
                                "Ministry Of Forest","Guide");
        
        
    }    

    @FXML
    private void usernameTextFieldOnMouseClick(MouseEvent event) {
        usernameTextField.clear();
    }

    @FXML
    private void passwordTextFieldOnMouseClick(MouseEvent event) {
        passwordTextField.clear();
    }

    @FXML
    private void usertypeComboBoxIsUpdated(ActionEvent event) {
        this.usertypeLabel.setText("Selected user is: "+ usertypeComboBox.getValue().toString());
        System.out.print("Updating user type..");
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        System.out.println("Checking username and password inputs..");
        
        if(usernameTextField.getText().equals("") || passwordTextField.getText().equals("")){
         Alert a = new Alert(Alert.AlertType.ERROR);
         a.setTitle("Error Alert");
         a.setHeaderText("Error!");
         a.setContentText("Please Enter All Fields");
         a.showAndWait();
        }
        else{
        if(usertypeComboBox.getValue().equals("Tourist")) {
            System.out.println("Entering Tourist Dashboard");
            
            Parent p = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Tourist Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
        if(usertypeComboBox.getValue().equals("Ticketing Employee")) {
            System.out.println("Entering Ticketing Employee Dashboard");
            
            Parent p = FXMLLoader.load(getClass().getResource("TicketingEmpDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Ticketing Employee Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
        if(usertypeComboBox.getValue().equals("Supervisor")) {
            System.out.println("Entering Supervisor Dashboard");
            
            Parent p = FXMLLoader.load(getClass().getResource("SupervisorDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Supervisor Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
        if(usertypeComboBox.getValue().equals("Guide")) {
            System.out.println("Entering Guide Dashboard");
            
            Parent p = FXMLLoader.load(getClass().getResource("GuideDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Guide Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
       if(usertypeComboBox.getValue().equals("Ministry Of Forest")) {
        System.out.println("Entering Ministry of Forest Dashboard");
            
        Parent p = FXMLLoader.load(getClass().getResource("MinistryofForestDashboard.fxml"));
        Scene newScene = new Scene(p);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
        stg.setTitle("Ministry Of Forest Dashboard");
        stg.setScene(newScene);
        stg.show();
        }
            
        } 
    }

    public ComboBox<String> getUsertypeComboBox() {
        return usertypeComboBox;
    }
}
