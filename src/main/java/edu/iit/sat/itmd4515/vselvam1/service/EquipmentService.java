/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import edu.iit.sat.itmd4515.vselvam1.domain.Equipment;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Vasanth Pranavan
 */
@Stateless
public class EquipmentService extends AbstractService<Equipment> {

    public EquipmentService() {
        super(Equipment.class);
    }

    @Override
    public List<Equipment> findAll() {
        return em.createNamedQuery("Equipment.findAll", entityClass).getResultList();
    }

}
