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
public class GroupBean {
       
    @PersistenceContext(unitName = "itmd4515PU")
  private  EntityManager em;
    
    /**
     *
     */
    public GroupBean() {
    }

    /**
     *
     * @param a
     */
    public void create(Group a) {
        //System.out.println("Customer Object"+a.toString());
        em.persist(a);
        
    }

    /**
     *
     * @param a
     */
    public void update(Group a) {
        em.merge(a);
    }

    /**
     *
     * @param a
     */
    public void remove(Group a) {
        em.remove(a);
    }

    /**
     *
     * @return
     */
    public List<Group> findAll() {
        return em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }

    /**
     *
     * @param groupName
     * @return
     */
    public Group find(String groupName) {
        return em.find(Group.class, groupName);
        
    }
}
