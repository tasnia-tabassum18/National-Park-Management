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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateProjectSceneController implements Initializable {

    @FXML
    private TextField plandurationTextField;
    @FXML
    private TextField costTextField;
    @FXML
    private TextField detailsofPlanTextField;
    @FXML
    private ComboBox<String> sectorComboBox;
    private ArrayList<String> filetypeList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sectorComboBox.getItems().addAll("Museum", "Safari Park", "Aquarium","Restaurant");
        filetypeList = new ArrayList<String>();
        filetypeList.add("*txt");
        filetypeList.add("*TXT");
        filetypeList.add("*docx");
        filetypeList.add("*doc");
        filetypeList.add("*DOCX");
        filetypeList.add("*DOC");
    }    

    @FXML
    private void plandurationTextFieldOnMouseClick(MouseEvent event) {
        plandurationTextField.clear();
    }

    @FXML
    private void costTextFieldOnMouseClick(MouseEvent event) {
        costTextField.clear();
    }

    @FXML
    private void detailsofPlanTextFieldOnMouseClick(MouseEvent event) {
        detailsofPlanTextField.clear();
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        String name= "";
        String email="";
        Supervisor s = new Supervisor(name,email);
        System.out.println("Checking fields of update plan..");
        if(detailsofPlanTextField.getText().equals("")||costTextField.getText().equals("")
            ||plandurationTextField.getText().equals("")||sectorComboBox.getValue().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Fatal Error!");
            a.setContentText("Please fill up all fields");
            a.showAndWait(); 
    }
        else{
            System.out.println("calling update plan method on supervisor class");
            s.updateplan(sectorComboBox.getValue(),plandurationTextField.getText(),
                    costTextField.getText(),detailsofPlanTextField.getText(),filetypeList);
        }
    }

    @FXML
    private void gobackButtononclick(ActionEvent event) {
        
        try {
            Parent p = FXMLLoader.load(getClass().getResource("SupervisorDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Supervisor Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateProjectSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
