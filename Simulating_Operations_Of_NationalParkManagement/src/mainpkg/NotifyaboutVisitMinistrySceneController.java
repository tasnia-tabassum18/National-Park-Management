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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class NotifyaboutVisitMinistrySceneController implements Initializable {

    @FXML
    private DatePicker visitDatePicker;
    @FXML
    private TextField numofvisitorsTextField;
    @FXML
    private CheckBox yesguideCheckBox;
    @FXML
    private CheckBox noguideCheckBox;
    @FXML
    private CheckBox yesparkcloseCheckBox1;
    @FXML
    private CheckBox noparkcloseCheckBox1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void numofvisitorsTextFieldOnMouseClick(MouseEvent event) {
        numofvisitorsTextField.clear();
    }

    @FXML
    private void confirmButtonOnClick(ActionEvent event) {
        String n="";
        String p="";
        MinistryofForest m= new MinistryofForest(n,p);
        
        if(visitDatePicker.getValue().equals(null)||numofvisitorsTextField.getText().equals("")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Fatal Error!");
            a.setContentText("Please fill up all fields");
            a.showAndWait();
        }
        else{
            if(yesguideCheckBox.isSelected()&&noguideCheckBox.isSelected()||
                yesparkcloseCheckBox1.isSelected()&& noparkcloseCheckBox1.isSelected()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Fatal Error!");
            a.setContentText("Please select only one checkbox at a time");
            a.showAndWait();   
            }
            else{
            
            String guidebook = null;
            String parkclose= null;
            if(yesguideCheckBox.isSelected()){
                guidebook= "Yes";
                System.out.println("Guide is booked");
            }
            else if(noguideCheckBox.isSelected()){
                guidebook="No";
                System.out.println("Guide is not booked");
            }
           if(yesparkcloseCheckBox1.isSelected()){
               parkclose="Yes";
               System.out.println("park closed");
           }
           else if(noparkcloseCheckBox1.isSelected()){
               parkclose= "No";
               System.out.println("park not closed");
           }
           m.notifyAboutVisit(visitDatePicker.getValue(),numofvisitorsTextField.getText(),
                   guidebook,parkclose); //calling method in ministry class to write txt file
        }
    }
    }
    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
        try {
            System.out.println("Going back to Ministry of Forest Dashboard from notify scene..");
            
            Parent p = FXMLLoader.load(getClass().getResource("MinistryofForestDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Ministry Of Forest Dashboard");
            stg.setScene(newScene);
            stg.show();  
        } catch (IOException ex) {
            Logger.getLogger(NotifyaboutVisitMinistrySceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
