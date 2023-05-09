/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ApproveLeaveSceneController implements Initializable {

//private ArrayList<String> fileTypeList;
private ArrayList<AskforLeave> leavearr= new ArrayList<AskforLeave>();
    @FXML
    private TextArea outputTextArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
        try {
        System.out.println("going back to Supervisor Dashboard from approveleave scene");
            
        Parent p = FXMLLoader.load(getClass().getResource("SupervisorDashboard.fxml"));
        Scene newScene = new Scene(p);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
        stg.setTitle("Supervisor Dashboard");
        stg.setScene(newScene);
        stg.show();
        } 
        catch (IOException ex) {
            Logger.getLogger(ApproveLeaveSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewapplicationsButtonOnClick(ActionEvent event) {
        
       String name= "";
       String email="";
       Supervisor s = new Supervisor(email, name);
       String content;
       content = s.viewleaveapplications();
     //   s.viewleaveapplications();
        //how do i read from bin file
     //   ObjectInputStream ois =null;
        
  //  try {
     //   AskforLeave l;
      //  ois = new ObjectInputStream(new FileInputStream("AskForLeaveApplications.bin"));
      //  outputTextArea.setText(null);
      //  while(true){
       //     l =(AskforLeave)ois.readObject();
       //     outputTextArea.appendText(l.toString()+"\n");
      //  }
        // }
   // } catch (Exception ex) {
        //Logger.getLogger(ApproveLeaveSceneController.class.getName()).log(Level.SEVERE, null, ex);
    //    try{
     //       if(ois!=null){
     //           ois.close();
     //       }
     //   }
     //   catch (IOException e){
     //       
   //     }
   // }   
   outputTextArea.setText("");//clears prev read from file 
     //   File f = null;
      //  FileInputStream fis = null;      
       // ObjectInputStream ois = null;
        
       /* try {
            f = new File("AskForLeaveApplications.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AskforLeave a;
            try{
                outputTextArea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    a = (AskforLeave)ois.readObject();//need to cast so that sup h can rep sub instance 
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    //emp.submitReport();
                   // System.out.println("HashCode="+a.toString());
                    outputTextArea.appendText(a.toString());
                }*/
          //  }//end of nested try
          //  catch(Exception e){
                //
           // }//nested catch     
         //  outputTextArea.appendText(a.toString());            
    //    } catch (IOException ex) { } 
      //  finally {
      //      try {
       //        if(ois != null) ois.close();
        //    } catch (IOException ex) { }
       // } 
       
    }

    @FXML
    private void declineButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Do you want to decline?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //you need to write the code to perform the actual task 
            showCustomInformationAlert("Declined leave applications");
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("Could not decline applications!"); 
        }
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
         Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Do you want to approve?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //you need to write the code to perform the actual task 
            showCustomInformationAlert("Approved leave applications");
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("Could not approve applications!"); 
        }
    }
     private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }      
}
