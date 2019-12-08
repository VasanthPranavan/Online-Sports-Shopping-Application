/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import edu.iit.sat.itmd4515.vselvam1.domain.Equipment;
import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@Stateless
public class EquipmentService extends AbstractService<Equipment> {

    /**
     *
     */
    public EquipmentService() {
        super(Equipment.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Equipment> findAll() {
        return em.createNamedQuery("Equipment.findAll", entityClass).getResultList();
    }

    /**
     *
     * @param equipmentFromUserForm
     */
    public void adminUpdate(Equipment equipmentFromUserForm) {

        Equipment equipmentFromDatabase = em.getReference(entityClass, equipmentFromUserForm.getId());

        equipmentFromDatabase.setName(equipmentFromUserForm.getName());
        equipmentFromDatabase.setCurrentDate(equipmentFromUserForm.getCurrentDate());
        equipmentFromDatabase.setType(equipmentFromUserForm.getType());

        List<ItemOrder> itemOrdersFromDatabase = new ArrayList<>(equipmentFromDatabase.getOrders());

        itemOrdersFromDatabase.forEach((ItemOrder o) -> {
            if (!equipmentFromUserForm.getOrders().contains(o)) {
                o.removeEquipment(equipmentFromDatabase);
            }
            em.merge(o);
        });

        List<ItemOrder> itemOrdersFromUserForm = new ArrayList<>(equipmentFromUserForm.getOrders());

        itemOrdersFromUserForm.forEach((ItemOrder o) -> {
            if (!equipmentFromDatabase.getOrders().contains(o)) {
                o.addEquipment(equipmentFromDatabase);
            }
            em.merge(o);
        });

        em.merge(equipmentFromDatabase);
    }
    
    /**
     *
     * @param equipmentFromUserForm
     */
    public void Update(Equipment equipmentFromUserForm) {

        Equipment equipmentFromDatabase = em.getReference(entityClass, equipmentFromUserForm.getId());

        equipmentFromDatabase.setName(equipmentFromUserForm.getName());
        equipmentFromDatabase.setCurrentDate(equipmentFromUserForm.getCurrentDate());
        equipmentFromDatabase.setType(equipmentFromUserForm.getType());
        
        
        
        em.merge(equipmentFromDatabase);
    }

    /**
     *
     * @param entity
     */
    @Override
    public void delete(Equipment entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param equipmentFromUserForm
     */
    public void createAndAddOrders(Equipment equipmentFromUserForm) {
        List<ItemOrder> itemOrders = new ArrayList<>(equipmentFromUserForm.getOrders());

        equipmentFromUserForm.setOrders(null);
        super.create(equipmentFromUserForm);
        em.flush();

        Equipment equipmentFromDatabase = em.getReference(entityClass, equipmentFromUserForm.getId());

        itemOrders.forEach((ItemOrder o) -> {
            o.addEquipment(equipmentFromDatabase);
            em.merge(o);
        });
    }

}
