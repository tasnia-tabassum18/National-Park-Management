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
public class Transaction extends UserClass implements Serializable {
    protected String name;
    protected String paymentmethod;
    protected Float amount;
    protected LocalDate date;

    public Transaction(String name, String paymentmethod, Float amount, LocalDate date) {
        this.name = name;
        this.paymentmethod = paymentmethod;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public Float getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
     public void display(){
        System.out.println("Name"+name+", Payment method="+paymentmethod+
                ", Amount"+amount+", Date="+date);
    }
     
    
    
}
