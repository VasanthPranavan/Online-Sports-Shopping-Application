/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import edu.iit.sat.itmd4515.vselvam1.domain.security.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
@NamedQuery(name = "ItemOrder.findAll", query = "select o from ItemOrder o")
@NamedQuery(name="ItemOrder.findByName", query = "select o from ItemOrder o where o.name= :name")
@NamedQuery(name = "ItemOrder.findByUsername",query="select o from ItemOrder o where o.user.userName= :username")
public class ItemOrder extends AbstractNamedEntity{

    @ManyToMany
    @JoinTable(name = "itemorder_equipment",
    joinColumns = @JoinColumn(name = "order_ID"),
            inverseJoinColumns = @JoinColumn(name = "Equipment_ID"))
    private List<Equipment> equipments = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;
    
    /**
     *
     */
    public ItemOrder() {
    }
    
    /**
     *
     * @param name
     */
    public ItemOrder(String name) {
        this.name = name;
    }

    /**
     * Get the value of equip
     *
     * @param e
     */
        public void addEquipment(Equipment e) {
        if (!this.equipments.contains(e)) {
            this.equipments.add(e);
        }
        if (!e.getOrders().contains(this)) {
            e.getOrders().add(this);
        }
    }

    /**
     *
     * @param e
     */
    public void removeEquipment(Equipment e) {
        if (this.equipments.contains(e)) {
            this.equipments.remove(e);

        }
        if (e.getOrders().contains(this)) {
            e.getOrders().remove(this);

        }
    }

    /**
     *
     * @return
     */
    public List<Equipment> getEquipments() {
        return equipments;
    }

    /**
     * Set the value of equip
     *
     * @param equipments
     */
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
@Override
    public String toString() {
        return "ItemOrder{" + "id=" + id + ", name=" + name + '}';
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    
}
