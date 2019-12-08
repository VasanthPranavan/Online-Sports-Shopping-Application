/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import edu.iit.sat.itmd4515.vselvam1.domain.Equipment;
import edu.iit.sat.itmd4515.vselvam1.service.EquipmentService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@RequestScoped
public class AdminController {

    private static final Logger LOG = Logger.getLogger(AdminController.class.getName());
    
    private Equipment equipment;

    @EJB
    private EquipmentService equipmentService;

    /**
     *
     */
    public AdminController() {
    }

    /**
     * Get the value of equipment
     *
     * @return the value of equipment
     */
    @PostConstruct
    private void postConstruct(){
        equipment= new Equipment();
    }

    /**
     *
     * @param e
     * @return
     */
    public String prepareViewEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside View with" + equipment.toString());
        return "/admin/viewEquipment.xhtml";

    }

    /**
     *
     * @param e
     * @return
     */
    public String prepareUpdateEquipment(Equipment e) {
        this.equipment = e;
        LOG.info("inside prepareUpdateEquipment with" + equipment.toString());
        return "/admin/editEquipment.xhtml";
    }
     
    /**
     *
     * @return
     */
    public String prepareCreateEquipment() {
        this.equipment=new Equipment();
        LOG.info("inside Create");
        return "/admin/editEquipment.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String doSaveEquipment() {
         
        LOG.info("inside save"+ equipment.toString());
        
        if(this.equipment.getId() != null){
            LOG.info("Executing an update on " + this.equipment.toString());
            equipmentService.adminUpdate(equipment);
        } else {
            LOG.info("Creating " + this.toString());
            equipmentService.createAndAddOrders(equipment);
        }
        return "/admin/welcome.xhtml?faces-redirect=true" ;
    
    }
    
    /**
     *
     * @return
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * Set the value of equipment
     *
     * @param equipment new value of equipment
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    
}
