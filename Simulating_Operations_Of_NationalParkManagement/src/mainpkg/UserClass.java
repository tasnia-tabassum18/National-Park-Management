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
public class UserClass implements Serializable{
    protected String username;
    protected String email;

   // public UserClass(String username, String password) {
     //   this.username = username;
       // this.password = password;
    //}

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String email) {
        this.email = email;
    }
    
    
}
