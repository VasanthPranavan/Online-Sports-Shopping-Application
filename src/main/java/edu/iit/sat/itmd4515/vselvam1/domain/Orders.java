/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Vasanth Pranavan
 */
//@Entity
public class Orders  extends AbstractNamedEntity {

//    @ManyToMany
//    private List<Equipment> equipments = new ArrayList<>();
//    

    /**
     *
     */
    public Orders() {
        
    }

  

//    @JoinTable(name = "order_equipment",
//            joinColumns = @JoinColumn(name = "order_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Equipment_ID"))

    /**
     * Get the value of equipments
     *
     * @return the value of equipments
     */
//    public List<Equipment> getEquipments() {
//        return equipments;
//    }
//
//    /**
//     * Set the value of equipments
//     *
//     * @param equipments new value of equipments
//     */
//    public void setEquipments(List<Equipment> equipments) {
//        this.equipments = equipments;
//    }
}
