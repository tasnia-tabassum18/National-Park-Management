/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
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
public class Guide extends EmployeeClass implements Serializable {
    private String name;
    private String email;

    public Guide(String name, String email) {
        super(name);
        //this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
public ObservableList  viewWorkinghour(){
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
 //leave application method   
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
            Logger.getLogger(Guide.class.getName()).log(Level.SEVERE, null, ex);
        }
      
}

   public void notifyTourist(LocalDate date, String time) {
       File f=null;
        FileWriter fw= null;
        System.out.println("about to write feedback from tourist");
        try {
            f= new File("NotifyTouristaboutGuideArrivalTimeData.txt");
            
         if(f.exists()){
             fw = new FileWriter(f,true); //appends the text file
         }
         else{
             fw= new FileWriter(f);// writes file header for the first session
         }   
         fw.write("Date:"+date+"Time:"+time+"\n");
        } catch (IOException ex) {
            Logger.getLogger(Guide.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("Closing feedback txt file");
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Guide.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
