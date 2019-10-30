/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author Vasanth Pranavan
 */
//@NamedQuery(name = "Order.findAll", query = "select o from Order o")
//@NamedQuery(name="Order.findByName", query = "select o from Order o where o.name= :name")
//@Entity
public class Order extends AbstractNamedEntity {

//    @ManyToMany
//    @JoinTable(name = "order_equipment",
//            joinColumns = @JoinColumn(name = "order_ID"),
//            inverseJoinColumns = @JoinColumn(name = "Equipment_ID"))
//    private List<Equipment> equipments = new ArrayList<>();
    public Order() {
    }

    public Order(String name) {
        this.name = name;
    }

//    public void addEquipment(Equipment e) {
//        if (!this.equipments.contains(e)) {
//            this.equipments.add(e);
//        }
//        if (!e.getOrders().contains(this)) {
//            e.getOrders().add(this);
//        }
//    }
//
//    public void removeEquipment(Equipment e) {
//        if (this.equipments.contains(e)) {
//            this.equipments.remove(e);
//
//        }
//        if (e.getOrders().contains(this)) {
//            e.getOrders().remove(this);
//
//        }
//    }
//
//    /**
//     * Get the value of equipments
//     *
//     * @return the value of equipments
//     */
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
    @Override
    public String toString() {
        return "Order{" + '}';
    }

}
