/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Vasanth Pranavan
 */
@Entity
@Table(name = "Equipment")
@NamedQuery(name = "Equipment.findAll", query = "select e from Equipment e")
@NamedQuery(name = "Equipment.findByName", query = "select e from Equipment e where e.name= :name")
public class Equipment extends AbstractNamedEntity {

    private String brand;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Double price;

    private LocalDate currentDate;

    
    @ManyToMany(mappedBy = "equipments")
    private List<ItemOrder> orders = new ArrayList<>();


    
    
    public Equipment() {
    }

    public Equipment(String name, String brand, Type type, Double price, LocalDate currentDate) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.currentDate = currentDate;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return "Equipment{" + "id=" + id + ", name=" + name + ", brand=" + brand + ", type=" + type + ", price=" + price + ", currentDate=" + currentDate + '}';
    }   
    public List<ItemOrder> getOrders() {
        return orders;
    }
    public void setItemOrder(List<ItemOrder> orders) {
        this.orders = orders;
    }

}
