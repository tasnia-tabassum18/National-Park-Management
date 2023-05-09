/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ViewFaqController implements Initializable {

    @FXML
private Label fileContentLabel;
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
    private void gobackButtonOnClick(ActionEvent event) {
         try {
            System.out.println("going back to tourist dashboard from viewfaq scene");
            Parent p = FXMLLoader.load(getClass().getResource("TouristDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Tourist Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewFaqController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadfaqButtononClick(ActionEvent event) {
        String a="";
        String b="";
        String c="";
        String d="";
        String content;
        
        
        Tourist t=new Tourist(a,b,c,d);
        content = t.viewFaq(fileTypeList); //this method on tourist class is called 
        fileContentLabel.setText(content);
  
}
}