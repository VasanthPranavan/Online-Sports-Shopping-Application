/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import edu.iit.sat.itmd4515.vselvam1.domain.security.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
@NamedQuery(name = "Physician.findAll", query = "select p from Physician p")
@NamedQuery(name = "Physician.findByName", query = "select p from Physician p where p.name = :name")
@NamedQuery(name = "Physician.findByUsername",query="select p from Physician p where p.user.userName= :username")

public class Physician extends AbstractNamedEntity {

    @OneToMany(mappedBy = "physician")

//        @JoinTable(joinColumns = @JoinColumn(name = "PHYSICIAN_ID"), 
//                inverseJoinColumns = @JoinColumn(name = "appointment_ID") )
//                
    private List<Appointment> appointments = new ArrayList<>();
    private String name;

    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    /**
     *
     * @param name
     */
    public Physician(String name) {
    super(name);
    }

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
