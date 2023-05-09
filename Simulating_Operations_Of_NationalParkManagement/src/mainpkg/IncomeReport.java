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
public class IncomeReport extends UserClass implements Serializable{
    private String name;
    private String paymentmethod;
    private Float amount;
    private LocalDate date;
}
