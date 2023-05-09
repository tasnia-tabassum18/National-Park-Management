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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateAvailableTicketController implements Initializable {

    @FXML
    private TextField numofticketsAvailTextField;
    @FXML
    private Label numofTicketscountshownTextField;
    int ticketcount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void numofticketsAvailTextFieldOnMouseClick(MouseEvent event) {
        numofticketsAvailTextField.clear();
    }

    @FXML
    private void updateButtonOnClick(ActionEvent event) {
        System.out.println("Updating ticket count now");
        if(numofticketsAvailTextField.getText().equals("")){
         Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Fatal Error!");
        a.setContentText("Please enter all fields");
        a.showAndWait();  
        
        }
        else{
            System.out.println("confirmed");
        ticketcount = Integer.parseInt(numofticketsAvailTextField.getText());
        //converts the no of tickets as int from str and storing in ticketcount
        // to use it in another classes if needed  
        numofTicketscountshownTextField.setText("Number of ticktes available now is:"
                +numofticketsAvailTextField.getText());
        //sets the label to show the input of ticket avail given by ticketimg emp
        }
      //  ticketcount = Integer.parseInt(numofticketsAvailTextField.getText());
    }

    public int getTicketcount() {
        return ticketcount;
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
        try {
            System.out.println("Entering Ticketing Employee Dashboard from updateticket count scene");
            
            Parent p = FXMLLoader.load(getClass().getResource("TicketingEmpDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Ticketing Employee Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateAvailableTicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
