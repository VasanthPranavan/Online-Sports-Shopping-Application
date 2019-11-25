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

    public CustomerController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside Customer Controller");
        equipment = new Equipment();
        itemOrder = itmOrderService.findByUsername(loginController.getRemoteUser());

    }

    //stage 1
    public String prepareViewEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside View with" + equipment.toString());
        return "/customer/viewEquipment.xhtml";

    }

    public String prepareUpdateEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside Update with" + equipment.toString());
        return "/customer/editEquipment.xhtml";
    }

    public String prepareCreateEquipment() {
        LOG.info("inside Create");
        return "/customer/editEquipment.xhtml";
    }
    
     public String prepareDeleteEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside Delete with" + equipment.toString());
        return "/welcome.xhtml";
    }
     
    public String doSaveEquipment() {
        LOG.info("inside save");
       equipmentService.update(equipment);
        return "/customer/welcome.xhtml" ;
    }

   
    public ItemOrder getItemorder() {
        return itemOrder;
    }

    public void setItemorder(ItemOrder itemorder) {
        this.itemOrder = itemorder;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
