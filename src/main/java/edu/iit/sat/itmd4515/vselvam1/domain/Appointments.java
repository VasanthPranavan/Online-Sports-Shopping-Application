/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
@Table(name = "Appointments")
@NamedQuery(name = "Appointments.findAll", query = "select a from Appointments a")
@NamedQuery(name = "Appointments.findByName", query = "select a from Appointments a where a.name= :name")
public class Appointments extends AbstractNamedEntity{
    
    

            private String brief;

    private String dateOfAppointment;

    public Appointments(String brief, String dateOfAppointment) {
        this.brief = brief;
        this.dateOfAppointment = dateOfAppointment;
    }

    public Appointments() {
    }




    public String getBrief() {
        return brief;
    }
    public void setBrief(String brief) {
        this.brief = brief;
    }
    public String getDateOfAppointment() {
        return dateOfAppointment;
    }
    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    @Override
    public String toString() {
        return "Appointments{" + "brief=" + brief + ", dateOfAppointment=" + dateOfAppointment + '}';
    }

}
