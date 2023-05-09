/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author ASUS
 */
public class Supervisor extends EmployeeClass implements Serializable{
    protected String email;
    private ObjectInputStream ois;
//private ArrayList<String> filetypeList;
public Supervisor(String email, String name) {
        super(name);
        this.email = email;
    }

  
 public String viewleaveapplications(){
     System.out.println("Viewing leave applications..");
            String content = null;
            File f= null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;
        try {
            //System.out.println("Viewing leave applications..");
           // String content = null;
           // File f= null;
           // FileInputStream fis = null;
           // ObjectInputStream ois = null;
            f= new File("AskForLeaveApplications.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AskforLeave a;
            while(true){
                try {
                    a= (AskforLeave)ois.readObject();
                } catch (IOException ex) {
                    Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
                 try {
                     if(ois != null) ois.close();
                 } catch (IOException ex) { }
 }
     return content;
 }

  public  void scheduletimeslot(ScheleduleTimeSlot s) {
       File f = new File("TimeSlotsForEmployee.bin");
        ObjectOutputStream oos=null;
        try {
        if(f.exists())
            oos = new AppendableObjectOutputStream(new FileOutputStream(f,true));
         else
            oos = new ObjectOutputStream(new FileOutputStream(f,true));
            oos.writeObject(s);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
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

 public void updateplan(String sector, String duration, String cost, String details, ArrayList filetype) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files",filetype));//adding filters
        File f= fc.showSaveDialog(null);
        while(f!=null){
        FileWriter fw= null;
        System.out.println("about to write plan...");
        try {    
         if(f.exists()){
             fw = new FileWriter(f,true); //appends the text file
         }
         else{
             fw= new FileWriter(f);// writes file header for the first session
         }   
       fw.write("Sector:"+sector+"Duration:"+duration+
               "Approximate cost:"+cost+"Details:"+details+"\n");
       break; // gave break as it was writing this repeteadly 
        } catch (IOException ex) {
            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("Closing plan txt file");
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        }
   public String notificationfromMinistry(ArrayList filetype){
    System.out.println("Using Filechooser to read faq");
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
    }
 