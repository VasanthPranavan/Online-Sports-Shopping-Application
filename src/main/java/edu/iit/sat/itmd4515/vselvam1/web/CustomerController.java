/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import edu.iit.sat.itmd4515.vselvam1.domain.Equipment;
import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import edu.iit.sat.itmd4515.vselvam1.service.EquipmentService;
import edu.iit.sat.itmd4515.vselvam1.service.ItemOrderService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@RequestScoped
public class CustomerController {

    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());

    private ItemOrder itemOrder;

    private Equipment equipment;

    @EJB
    private ItemOrderService itmOrderService;
    
    @EJB
    private EquipmentService equipmentService; 

    @Inject
    private LoginController loginController;

    /**
     *
     */
    public CustomerController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside Customer Controller");
        equipment = new Equipment();
        itemOrder = itmOrderService.findByUsername(loginController.getRemoteUser());

    }

    //stage 1

    /**
     *
     * @param e
     * @return
     */
    public String prepareViewEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside View with" + equipment.toString());
        return "/customer/viewEquipment.xhtml";

    }

    /**
     *
     * @param e
     * @return
     */
    public String prepareUpdateEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside Update with" + equipment.toString());
        return "/customer/editEquipment.xhtml";
    }

    /**
     *
     * @return
     */
    public String prepareCreateEquipment() {
        this.equipment=new Equipment();
        this.equipment.getOrders().add(itemOrder);
        
        LOG.info("inside Create");
        return "/customer/editEquipment.xhtml";
    }
    
    /**
     *
     * @param e
     * @return
     */
    public String prepareDeleteEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside Delete with" + equipment.toString());
        return "customer/deteleEquipment.xhtml";
    }
     
    /**
     *
     * @return
     */
    public String doSaveEquipment() {
        LOG.info("inside save"+ equipment.toString());
        
        if(this.equipment.getId() != null){
            LOG.info("Executing an update on " + this.equipment.toString());
            equipmentService.update(equipment);
        } else {
            LOG.info("Creating " + this.toString());
            itemOrder.addEquipment(equipment);
            equipmentService.createAndAddOrders(equipment);
        }
        return "/customer/welcome.xhtml?faces-redirect=true" ;
    }

    /**
     *
     * @return
     */
    public String doDeleteEquipment() {
        LOG.info("inside Delete"+ this.toString());
        equipmentService.delete(equipment);
       // equipmentService.delete(equipment);
        return "/customer/welcome.xhtml?faces-redirect=true" ;
    }

    /**
     *
     * @return
     */
    public ItemOrder getItemorder() {
        return itemOrder;
    }

    /**
     *
     * @param itemorder
     */
    public void setItemorder(ItemOrder itemorder) {
        this.itemOrder = itemorder;
    }

    /**
     *
     * @return
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     *
     * @param equipment
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        
    }
    
}
