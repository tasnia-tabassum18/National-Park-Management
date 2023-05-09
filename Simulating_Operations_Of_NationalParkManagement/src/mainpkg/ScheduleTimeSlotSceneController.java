/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ScheduleTimeSlotSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField desigTextField;
    @FXML
    private DatePicker workDatePicker;
    @FXML
    private TableView<ScheleduleTimeSlot> tableView;
    @FXML
    private TableColumn<ScheleduleTimeSlot, String> nameTableColumn;
    @FXML
    private TableColumn<ScheleduleTimeSlot, String> desigTableColumn;
    @FXML
    private TableColumn<ScheleduleTimeSlot, String> dateTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    nameTableColumn.setCellValueFactory(new PropertyValueFactory<ScheleduleTimeSlot, String>("name"));
    desigTableColumn.setCellValueFactory(new PropertyValueFactory<ScheleduleTimeSlot, String>("designation"));
    dateTableColumn.setCellValueFactory(new PropertyValueFactory<ScheleduleTimeSlot, String>("date"));
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
         if(nameTextField.getText().equals("")||desigTextField.getText().equals("")
            ||workDatePicker.getValue().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Fatal Error!");
        a.setContentText("Please Fill up all fields!");
        a.showAndWait(); 
        }
        else{
             String name= "Abir Ahmed";
             String email= "abir13@gmail.com";
           Supervisor t= new Supervisor(email,name);
          ScheleduleTimeSlot s = new ScheleduleTimeSlot(  
               nameTextField.getText(),
               desigTextField.getText(),                 
               workDatePicker.getValue()  
                );
        nameTextField.setText(null);    desigTextField.setText(null);        
        s.display();
        System.out.println("calling scheduletimeslot method in supervisor class");
        t.scheduletimeslot(s);
        }
    }

    @FXML
    private void loadtotableButtonOnClick(ActionEvent event) {
        ObjectInputStream ois=null;
        ObservableList<ScheleduleTimeSlot> timeslotList = FXCollections.observableArrayList();
         try {
            ScheleduleTimeSlot t;
            ois = new ObjectInputStream(new FileInputStream("TimeSlotsForEmployee.bin"));
            while(true){
                t= (ScheleduleTimeSlot) ois.readObject();
                timeslotList.add(t);
            }
        } catch (Exception ex) {            
            try {
                tableView.setItems(timeslotList);
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        } 
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
        try {
            System.out.println("Entering Supervisor Dashboard");
            
            Parent p = FXMLLoader.load(getClass().getResource("SupervisorDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Supervisor Dashboard");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(ScheduleTimeSlotSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void nameTextFieldOnMouseClick(MouseEvent event) {
        nameTextField.clear();
    }

    @FXML
    private void desigTextFieldOnMouseClick(MouseEvent event) {
        desigTextField.clear();
    }
    
}
