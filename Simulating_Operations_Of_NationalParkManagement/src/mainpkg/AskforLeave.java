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
public class AskforLeave extends TicketingEmployee implements Serializable{
    protected LocalDate date;
    protected String reason;

    public AskforLeave(LocalDate date, String reason, String email, String name) {
        super(email, name);
        this.date = date;
        this.reason = reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "AskforLeave{" + "name="+ name+ "date=" + date + ", reason=" + reason + '}';
    }
   
    
    
}
