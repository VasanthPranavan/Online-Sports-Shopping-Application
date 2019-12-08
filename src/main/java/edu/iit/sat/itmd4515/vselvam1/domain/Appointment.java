/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
@Table(name = "Appointment")
@NamedQuery(name = "Appointment.findAll", query = "select a from Appointment a")
@NamedQuery(name = "Appointment.findByName", query = "select a from Appointment a where a.name= :name")
public class Appointment extends AbstractNamedEntity {

    @ManyToOne
    private Physician physician;

    @ManyToOne
    private Customer customer;
    
    private String brief;


    private LocalDate dateOfAppointment;


    /**
     *
     */
    public Appointment() {
    }

    public Appointment(String brief, LocalDate dateOfAppointment) {
        this.brief = brief;
        this.dateOfAppointment = dateOfAppointment;
    }

    
    /**
     * Get the value of physician
     *
     * @return the value of physician
     */
    public Physician getPhysician() {
        return physician;
    }

    /**
     * Set the value of physician
     *
     * @param physician new value of physician
     */
    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getBrief() {
        return brief;
    }
    public void setBrief(String brief) {
        this.brief = brief;
    }
    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }
    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    @Override
    public String toString() {
        return "Appointment{" + "physician=" + physician + ", customer=" + customer + ", brief=" + brief + ", dateOfAppointment=" + dateOfAppointment + '}';
    }

    

}
