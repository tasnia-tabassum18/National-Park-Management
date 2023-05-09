/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class TicketingEmployee extends EmployeeClass implements Serializable {
    protected String email;

    public TicketingEmployee(String email, String name) {
        super(name);
        this.email = email;
    }
public void updateFaq(String q1, String ans1, String q2, String ans2, String q3, String ans3){
        File f=null;
        FileWriter fw= null;
        System.out.println("about to write faq");
        try {
            f= new File("FAQ.txt");
            
         if(f.exists()){
             fw = new FileWriter(f,true); //appends the text file
         }
         else{
             fw= new FileWriter(f);// writes file header for the first session
         }   
         fw.write("FAQ about National Park:\n"+"Q1:"+q1+"\n"+"Ans:"+ans1+"\n"+
                 "Q2:"+q2+"\n"+"Ans:"+ans2+"\n"+"Q3:"+q3+"\n"+"Ans:"+ans3+"\n");
        } catch (IOException ex) {
            Logger.getLogger(Tourist.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("Closing faq txt file");
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(TicketingEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
}
   
}
public void askforleave(String name, String email, String reason, LocalDate date){
  File f = null;
  FileOutputStream fos = null;
  ObjectOutputStream oos = null;
    try{
       f = new File("AskForLeaveApplications.bin");
      if(f.exists()){
        fos = new FileOutputStream(f,true);
        oos = new AppendableObjectOutputStream(fos);        
     }  
    else{
       fos= new FileOutputStream(f);
       oos = new ObjectOutputStream(fos);
     }
    AskforLeave a= new AskforLeave(date, reason, email,name);
    oos.writeObject(a);
        } catch (IOException ex) {
            Logger.getLogger(TicketingEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
      
}
public ObservableList viewWorkinghour(){
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
               // tableView.setItems(timeslotList);
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
        return timeslotList;
}   
}