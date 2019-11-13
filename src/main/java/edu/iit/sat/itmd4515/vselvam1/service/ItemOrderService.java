/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@Stateless
public class ItemOrderService {

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;

    public ItemOrderService() {
    }

    public void create(ItemOrder o) {
        em.persist(o);

    }

    public ItemOrder find(Long id) {
        return em.find(ItemOrder.class, id);
    }

    public List<ItemOrder> findAll() {
        return em.createNamedQuery("ItemOrder.findAll", ItemOrder.class).getResultList();
    }

    public ItemOrder findByName(String name) {
        return em.createNamedQuery("ItemOrder.findByName", ItemOrder.class).getSingleResult();

    }

    public ItemOrder findByUsername(String username){
                return em.createNamedQuery("ItemOrder.findByUsername", ItemOrder.class)
                        .setParameter("username", username)
                        .getSingleResult();

    }
    public void update(ItemOrder o) {
        em.merge(o);
    }

    public void delete(ItemOrder o) {
        em.remove(em.merge(o));
    }

}
