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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class NotifyTouristSceneController implements Initializable {

    @FXML
    private DatePicker datepicker;
    @FXML
    private TextField timeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmButtonOnClick(ActionEvent event) {
        String n ="";
        String e="";
        Guide g = new Guide(n,e);
        if(timeTextField.getText().equals("")||datepicker.getValue().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Input Error!");
        a.setContentText("Please fill up all fields!");
        a.showAndWait();
        } 
        else{
            g.notifyTourist(datepicker.getValue(),timeTextField.getText());
        }
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
        try {
            System.out.println("Gping back to Guide Dashboard");
            
            Parent p = FXMLLoader.load(getClass().getResource("GuideDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Guide Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(NotifyTouristSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void timeTextFieldOnMouseClick(MouseEvent event) {
        timeTextField.clear();
    }
    
}
