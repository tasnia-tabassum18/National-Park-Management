/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class WorkingHourSceneController implements Initializable {

    @FXML
    private TableColumn<ScheleduleTimeSlot, String> nameTableColumn;
    @FXML
    private TableColumn<ScheleduleTimeSlot, String> designationTableColumn;
    @FXML
    private TableColumn<ScheleduleTimeSlot, String> dateTableColumn;
    @FXML
    private TableView<ScheleduleTimeSlot> tableview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    nameTableColumn.setCellValueFactory(new PropertyValueFactory<ScheleduleTimeSlot, String>("name"));
    designationTableColumn.setCellValueFactory(new PropertyValueFactory<ScheleduleTimeSlot, String>("designation"));
    dateTableColumn.setCellValueFactory(new PropertyValueFactory<ScheleduleTimeSlot, String>("date"));
    }    

    @FXML
    private void viewbuttonOnClick(ActionEvent event) {
        ObservableList<ScheleduleTimeSlot> timeslot = FXCollections.observableArrayList();
        String a="";
        String b="";
        Guide g = new Guide(a,b);
        System.out.println("calling view working hour method");
        timeslot = g.viewWorkinghour();
        System.out.println("setting on tableview");
         tableview.setItems(timeslot);
    }
    
}
