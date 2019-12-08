/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import edu.iit.sat.itmd4515.vselvam1.domain.Appointment;
import edu.iit.sat.itmd4515.vselvam1.service.PhysicianService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@RequestScoped
public class AppointmentController {


    private Appointment appointment;
    
    
    
    public AppointmentController() {
    }

    /**
     * Get the value of appointment
     *
     * @return the value of appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * Set the value of appointment
     *
     * @param appointment new value of appointment
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

}
