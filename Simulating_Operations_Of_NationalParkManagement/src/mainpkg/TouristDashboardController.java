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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TouristDashboardController implements Initializable {

    @FXML
    private Menu galleryMenu;
    @FXML
    private Menu reservationMenu;
    @FXML
    private MenuItem ticketMenuItem;
    @FXML
    private MenuItem guideMenuItem;
    @FXML
    private Menu faqMenu;
    @FXML
    private Button givefeedbackButton;
    @FXML
    private Button givefeedbackButton1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  

    @FXML
    private void ticketMenuItemButtonOnClick(ActionEvent event) throws IOException {
         System.out.println("Entering Ticket Payment Scene");
            
            Parent p = FXMLLoader.load(getClass().getResource("TicketPaymentScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = new Stage();
           // Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("");
            stg.setScene(newScene);
            stg.show();
    }

    @FXML
    private void guideMenuItemButtonOnClick(ActionEvent event) throws IOException {
         System.out.println("Entering Guide Payment Scene");
            
            Parent p = FXMLLoader.load(getClass().getResource("GuidePaymentScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = new Stage();
           // Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("");
            stg.setScene(newScene);
            stg.show();
    }

    @FXML
    private void reservationMenuOnClick(ActionEvent event) {
    }


    @FXML
    private void givefeedbackButtonOnClick(ActionEvent event) {
        try {
            System.out.println("Entering givefeedback scene");
            
            Parent p = FXMLLoader.load(getClass().getResource("GiveFeedBackTouristScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("");
            stg.setScene(newScene);
            stg.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText(" ");
        a.setContentText("Do you want to log out from your account ?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //you need to write the code to perform the actual task 
            Parent p = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();//casting on same stg
            stg.setTitle("Login Page");
            stg.setScene(newScene);
            stg.show();
            
        }
        else{
             
        }
         
    }
      private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }    

    @FXML
    private void viewfaqMenuitemOnClick(ActionEvent event) {
         try {
            System.out.println("entering view faq scene..");
            
            Parent p = FXMLLoader.load(getClass().getResource("ViewFaq.fxml"));//viewfaq scene is loaded
            Scene newScene = new Scene(p);
            Stage newStage= new Stage();
            newStage.setTitle("FAQ");
            newStage.setScene(newScene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        
//gallery menu's menu items on click functions to view specific sector based gallery
    @FXML
    private void museumMenuitemOnClick(ActionEvent event) {
        try {
            System.out.println("entering museum gallery..");
            
            Parent p = FXMLLoader.load(getClass().getResource("MuseumGallery.fxml"));//musem gallery is loaded
            Scene newScene = new Scene(p);
            Stage newStage= new Stage();
            newStage.setTitle("Museum");
            newStage.setScene(newScene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void safariparkMenuitemOnClick(ActionEvent event) {
        try {
            System.out.println("entering safari park gallery..");
            
            Parent p = FXMLLoader.load(getClass().getResource("SafariParkGalleryScene.fxml"));//park gallery is loaded
            Scene newScene = new Scene(p);
            Stage newStage= new Stage();
            newStage.setTitle("Safari Park");
            newStage.setScene(newScene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    @FXML
    private void birdsMenuitemOnClick(ActionEvent event) {
        try {
            System.out.println("entering bird gallery..");
            
            Parent p = FXMLLoader.load(getClass().getResource("BirdGallery.fxml"));//park gallery is loaded
            Scene newScene = new Scene(p);
            Stage newStage= new Stage();
            newStage.setTitle("Bird Gallery");
            newStage.setScene(newScene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void aquariumMenuitemOnClick(ActionEvent event) {
        try {
            System.out.println("entering aquarium gallery..");
            
            Parent p = FXMLLoader.load(getClass().getResource("AquaGallery.fxml"));//aqua gallery is loaded
            Scene newScene = new Scene(p);
            Stage newStage= new Stage();
            newStage.setTitle("Aquarium");
            newStage.setScene(newScene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void restaurantMenuitemOnClick(ActionEvent event) {
        try {
            System.out.println("entering restaurant gallery..");
            
            Parent p = FXMLLoader.load(getClass().getResource("RestaurantGallery.fxml"));//restaurant gallery is loaded
            Scene newScene = new Scene(p);
            Stage newStage= new Stage();
            newStage.setTitle("Restaurant");
            newStage.setScene(newScene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TouristDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    

