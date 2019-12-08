/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain.security;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vasanth Pranavan
 */
@Stateless
public class UserBean {
    @PersistenceContext(unitName = "itmd4515PU")
  private  EntityManager em;
    
    /**
     *
     */
    public UserBean() {
    }

    /**
     *
     * @param a
     */
    public void create(User a) {
        //System.out.println("Customer Object"+a.toString());
        em.persist(a);
        
    }

    /**
     *
     * @param a
     */
    public void update(User a) {
        em.merge(a);
    }

    /**
     *
     * @param a
     */
    public void remove(User a) {
        em.remove(a);
    }

    /**
     *
     * @return
     */
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
    
}
