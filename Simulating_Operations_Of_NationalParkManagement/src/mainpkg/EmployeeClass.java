/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class EmployeeClass extends UserClass implements Serializable{
    protected String name;
    private String address;
    private String phoneno;
    protected String typeofEmp;

    public EmployeeClass(String name) {
        this.name = name;
       // this.typeofEmp = typeofEmp;
    }

  

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    

    
}
