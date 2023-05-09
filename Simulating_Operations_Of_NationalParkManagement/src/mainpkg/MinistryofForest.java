/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.stage.FileChooser;

/**
 *
 * @author ASUS
 */
public class MinistryofForest extends UserClass implements Serializable {
    private String password;
    private String username;
    private ObjectInputStream ois;

    public MinistryofForest(String password, String username) {
        this.password = password;
        this.username = username;
    }

   public String viewProject(ArrayList filetype) {
    System.out.println("Using Filechooser to read project txt file");
     FileChooser fc = new FileChooser();
     fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", filetype));
     File f = fc.showOpenDialog(null);
      String str="";
        if(f != null){  
            try {
                Scanner sc = new Scanner(f);
               // String str="";
                while(sc.hasNextLine()){
                    str+=sc.nextLine()+"\n";
                }
                //return str;
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(FileChooserViewController.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        System.out.println("returning str to write on content...");
           return str;
    }

  public  void notifyAboutVisit(LocalDate date, String visitorcount, String guidebook, String parkclose) {
        File f=null;
        FileWriter fw= null;
        System.out.println("about to write visit details..");
        try {
         f= new File("NotificationAboutVisitofMinistry.txt");   
         if(f.exists()){
             fw = new FileWriter(f,true); //appends the text file
         }
         else{
             fw= new FileWriter(f);// writes file header for the first session
         }   
         fw.write("Date: "+date+"\n"+"Amount of visitors: "+visitorcount+"\n"+
                 "Is a guide booked? "+guidebook+"\n"+"Does the park need to be closed for tourists? "
                 +parkclose+"\n"); //writing all details 
        } catch (IOException ex) {
            Logger.getLogger(Tourist.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("Closing txt file");
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(MinistryofForest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }       
}
  public ObservableList viewIncomeReport() throws ClassNotFoundException{
    int i,j;
      i=0;
      j=0;
      File f = null;
      FileInputStream fis = null;
      ois = null;
    try {  
        f = new File("IncomeReport.bin");
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        Transaction t;
        while(true){
        System.out.println("checking payment methods..");
            t = (Transaction)ois.readObject();
            if(t.getPaymentmethod().equals("Offline")){
                System.out.println("counting offline now");
                i++;
            }
            else if(t.getPaymentmethod().equals("Online")){
                System.out.println("counting online now");
                j++;
            }          
        }
            
    } catch (IOException ex) {
        Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally {
        try {
            if(ois != null) ois.close();
        } catch (IOException ex) { 
        Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
  System.out.println("now loading data on piechart...");
 ObservableList <PieChart.Data> list = FXCollections.observableArrayList
        (new PieChart.Data("Offline Payments",i),new PieChart.Data("Online Payments",j)); //addong counts
    return list; //returning the list to ocntroller class 
}

}