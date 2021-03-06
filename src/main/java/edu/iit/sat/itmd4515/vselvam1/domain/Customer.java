/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
public class Customer extends AbstractNamedEntity {
   
    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments= new ArrayList<>();;



   
    private LocalDate date;

    private Boolean priority;
    
    /**
     * Get the value of appointments
     *
     * @return the value of appointments
     */
    
    /**
     * Set the value of appointments
     *
     * @param appointments new value of appointments
     */
    

    /**
     *
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public Boolean isPriority() {
        return priority;
    }

    /**
     *
     * @param priority
     */
    public void setPriority(Boolean priority) {
        this.priority = priority;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

}
