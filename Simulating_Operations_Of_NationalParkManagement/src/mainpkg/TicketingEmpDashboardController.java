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
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TicketingEmpDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void logIncomeReportButtonOnClick(ActionEvent event) {
       try {
            System.out.println("Entering log income report scene");
            Parent p = FXMLLoader.load(getClass().getResource("LogIncomeReportScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Log Income Report Scene");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(TicketingEmpDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @FXML
    private void askForLeaveButtonOnClick(ActionEvent event) {
         try {
            System.out.println("Entering ask for leave scene");
            
            Parent p = FXMLLoader.load(getClass().getResource("AskForLeaveScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg= new Stage(); 
            //Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Ask For Leave Scene");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(TicketingEmpDashboardController.class.getName()).log(Level.SEVERE, null, ex);
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
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Login Page");
            stg.setScene(newScene);
            stg.show();
            
        }
        else{
             
        }
         
    }
      private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }    


    @FXML
    private void updatecountTicketMenuItemOnClick(ActionEvent event) {
            try {
            System.out.println("Entering update ticket count scene");
            
            Parent p = FXMLLoader.load(getClass().getResource("UpdateAvailableTicket.fxml"));
            Scene newScene = new Scene(p);
            Stage stg= new Stage();
            //Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(TicketingEmpDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateFAQButtonOnClick(ActionEvent event) {// scene changes to update faq scene
        try {
            // TicketingEmployee t = new TicketingEmployee()
            Parent p = FXMLLoader.load(getClass().getResource("UpdateFaqScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("FAQ Scene");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(TicketingEmpDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void viewworkinghourMenuItemOnClick(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("WorkingHourScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = new Stage();
            stg.setTitle("Working hour slots");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(TicketingEmpDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
