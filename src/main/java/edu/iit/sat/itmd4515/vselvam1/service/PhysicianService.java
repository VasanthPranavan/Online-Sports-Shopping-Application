/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import edu.iit.sat.itmd4515.vselvam1.domain.Physician;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Vasanth Pranavan
 */
@Stateless
public class PhysicianService extends AbstractService<Physician>{

    public PhysicianService() {
        super(Physician.class);
    }
    
    @Override
    public List<Physician> findAll() {
        return em.createNamedQuery("Physician.findAll",entityClass).getResultList();

    }

   public Physician findByUsername(String username){
                return em.createNamedQuery("Physician.findByUsername", Physician.class)
                        .setParameter("username", username)
                        .getSingleResult();

    }
    
}
