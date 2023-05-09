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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GuidePaymentSceneController implements Initializable {

    @FXML
    private TextField visitorsNumTextField;
    @FXML
    private Label totalbillText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewBillButtonOnCick(ActionEvent event) {
        String y= "100";
        String visitorcount = visitorsNumTextField.getText();
        int bill;
        if(Integer.parseInt(visitorcount)<=25){
        bill= Integer.parseInt(visitorcount)*Integer.parseInt(y);
        totalbillText.setText("Total bill:"+bill); //updates the label saying total bill
        
    }
         else{
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Bill Processing Error!");
        a.setContentText("The maximum number of visitors per guide that is 25");
        a.showAndWait(); 
        }

    
}

    @FXML
    private void proceedButtonOnCick(ActionEvent event) throws IOException {
               String visitorcount= visitorsNumTextField.getText();
       if(Integer.parseInt(visitorcount)<=25){
     Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirming payment");
        a.setContentText("Do you want to proceed?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
                
            Parent p = FXMLLoader.load(getClass().getResource("TouristPaymentScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle(" ");
            stg.setScene(newScene);
            stg.show();
        }
        }
        else{
            //show appropriate cancellation message
              showCustomInformationAlert("Something went wrong..");    
        }
    }
    
      private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }    

    @FXML
    private void gobackButtonOnCick(ActionEvent event) {
         System.out.println("going back to tourist scene from ticketpayment scene");
        try {
            Parent p = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Tourist Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
           // Logger.getLogger(ViewGalleryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}