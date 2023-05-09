/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

/**
 *
 * @author ASUS
 */
public class Tourist extends UserClass implements Serializable{
  
    private String phone;
    private String password;

    Tourist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.phone = phone;
    }

    public Tourist(String email, String phone, String username, String password) {
      //  super(username, password);
        this.username=username;
        this.password=password;
        this.email = email;
        this.phone = phone;
    }

    public void giveFeedback(String feedback, String username,String email, String name, String phone){
        File f=null;
        FileWriter fw= null;
        System.out.println("about to write feedback from tourist");
        try {
            f= new File("FeedbacksfromTourist.txt");
            
         if(f.exists()){
             fw = new FileWriter(f,true); //appends the text file
         }
         else{
             fw= new FileWriter(f);// writes file header for the first session
         }   
         fw.write("Username:"+username+"Email:"+email+"Feedback:"+feedback+"\n");
        } catch (IOException ex) {
            Logger.getLogger(Tourist.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("Closing feedback txt file");
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Tourist.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public String viewFaq(ArrayList filetype){
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