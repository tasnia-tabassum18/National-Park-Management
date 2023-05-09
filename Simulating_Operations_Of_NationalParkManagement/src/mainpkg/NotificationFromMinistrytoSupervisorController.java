/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class NotificationFromMinistrytoSupervisorController implements Initializable {

    @FXML
    private Label filecontentLabel;
    private ArrayList<String> fileTypeList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fileTypeList= new ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*DOCX");
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        String n="";
        String e="";
        String content;
        
        
        Supervisor s=new Supervisor(n,e);
        content = s.notificationfromMinistry(fileTypeList); //this method on tourist class is called 
         System.out.println("setting the content of file to label on scene...");
        filecontentLabel.setText(content);
    }

    @FXML
    private void gobackbuttonOnClick(ActionEvent event) {
        System.out.println("going back to supervisor scene...");
        try {
            Parent p = FXMLLoader.load(getClass().getResource("SupervisorDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Supervisor Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(NotificationFromMinistrytoSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
