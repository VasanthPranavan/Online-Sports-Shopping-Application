/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
public class Appointment extends AbstractNamedEntity {

    @ManyToOne
    private Physician physician;

    @ManyToOne
    private Customer customer;

    public Appointment() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
