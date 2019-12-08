/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import edu.iit.sat.itmd4515.vselvam1.domain.Appointment;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@Stateless
public class AppointmentService extends AbstractService<Appointment>{

    /**
     *
     */
    public AppointmentService() {
        super(Appointment.class);
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Appointment> findAll() {
        return em.createNamedQuery("Appointment.findAll",entityClass).getResultList();

    }

    /**
     *
     * @param username
     * @return
     */
    public Appointment findByUsername(String username){
                return em.createNamedQuery("Appointment.findByUsername", Appointment.class)
                        .setParameter("username", username)
                        .getSingleResult();

    }
    
}
