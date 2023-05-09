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
public class PlanClass extends UserClass implements Serializable{
    private String sector;
    private String duration;
    private String cost;
    private String details;

    public PlanClass(String sector, String duration, String cost, String details) {
        this.sector = sector;
        this.duration = duration;
        this.cost = cost;
        this.details = details;
    }

    public String getSector() {
        return sector;
    }

    public String getDuration() {
        return duration;
    }

    public String getCost() {
        return cost;
    }

    public String getDetails() {
        return details;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    
}
