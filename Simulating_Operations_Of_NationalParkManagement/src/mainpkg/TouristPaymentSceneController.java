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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TouristPaymentSceneController implements Initializable {

    @FXML
    private RadioButton bkashRadioButton;
    @FXML
    private RadioButton nagadRadioButton;
    @FXML
    private RadioButton dbblRadioButton;
 
    /**
     * Initializes the controller class.
     */
    private ToggleGroup tg;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tg = new ToggleGroup();
        bkashRadioButton.setToggleGroup(tg);
        nagadRadioButton.setToggleGroup(tg);
        dbblRadioButton.setToggleGroup(tg);
    }    

    @FXML
    private void radioButtonOnCick(ActionEvent event) {
        if(bkashRadioButton.isSelected()){
            System.out.println("bkash has been selected..");
            try {
                Parent p = FXMLLoader.load(getClass().getResource("MakePaymentScene.fxml"));
                Scene newScene = new Scene(p);
                Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
                stg.setTitle(" ");
                stg.setScene(newScene);
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(TouristPaymentSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(nagadRadioButton.isSelected()){
             System.out.println("nagad has been selected..");
            try {
                Parent p = FXMLLoader.load(getClass().getResource("MakePaymentScene.fxml"));
                Scene newScene = new Scene(p);
                Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
                stg.setTitle(" ");
                stg.setScene(newScene);
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(TouristPaymentSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(dbblRadioButton.isSelected()){
             System.out.println("dbbl has been selected..");
            try {
                Parent p = FXMLLoader.load(getClass().getResource("MakePaymentScene.fxml"));
                Scene newScene = new Scene(p);
                Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
                stg.setTitle(" ");
                stg.setScene(newScene);
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(TouristPaymentSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
