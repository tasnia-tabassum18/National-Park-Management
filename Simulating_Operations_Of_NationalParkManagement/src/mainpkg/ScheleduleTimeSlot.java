/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class ScheleduleTimeSlot extends UserClass implements Serializable {
    protected String name;
    protected String designation;
    protected LocalDate date;
    
    public ScheleduleTimeSlot(String name, String designation, LocalDate date) {
        this.name = name;
        this.designation = designation;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void display(){
        System.out.println("Name= "+name+", Designation="+designation+
                "Working Day="+date);
    } 
    
    
}
