/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
public class Physician extends AbstractNamedEntity {

    @OneToMany(mappedBy = "physician")

//        @JoinTable(joinColumns = @JoinColumn(name = "PHYSICIAN_ID"), 
//                inverseJoinColumns = @JoinColumn(name = "appointment_ID") )
//                
    private List<Appointment> appointments = new ArrayList<>();
    private String name;

    public Physician() {
    }

    /**
     * Get the value of appointments
     *
     * @return the value of appointments
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Set the value of appointments
     *
     * @param appointments new value of appointments
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
