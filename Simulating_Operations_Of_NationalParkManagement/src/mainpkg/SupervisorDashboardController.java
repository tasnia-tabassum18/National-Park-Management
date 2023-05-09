/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SupervisorDashboardController implements Initializable {

    @FXML
    private Button timeslotButton;
    @FXML
    private Button approveLeaveButton;
    @FXML
    private Button approveLeaveButton1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void updateGallerymenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void updateProjectMenuItemOnClick(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("UpdateProjectScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = new Stage();
            //Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setTitle("Project Scene");
            stg.setScene(newScene);        
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(SupervisorDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void timeslotButtonOnClick(ActionEvent event) {
         try {
            Parent p = FXMLLoader.load(getClass().getResource("ScheduleTimeSlotScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setTitle("Schedule Time Slot");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(SupervisorDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void approveLeaveButtonOnClick(ActionEvent event) {
        try {
          
            Parent p = FXMLLoader.load(getClass().getResource("ApproveLeaveScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setTitle("Approve Leave");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(SupervisorDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
               Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText(" ");
        a.setContentText("Do you want to log out from your account ?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //if ok is clicked then going back to login scene i.e homepage
            Parent p = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setTitle("Login Page");
            stg.setScene(newScene);
            stg.show();
            
        }
        else{
             
        }    
    }
      private void showCustomInformationAlert(String str) { //logout confirmation
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }    

    @FXML
    private void viewIncomeReportButtonOnClick(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("ViewIncomeReportScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setTitle("Income Report Scene");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(SupervisorDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 

    @FXML
    private void notificationButtonOnClick(ActionEvent event) {
        System.out.println("entering notification from ministry scene..");
        try {
            Parent p = FXMLLoader.load(getClass().getResource("NotificationFromMinistrytoSupervisor.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setTitle("Notification Scene");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(SupervisorDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    

