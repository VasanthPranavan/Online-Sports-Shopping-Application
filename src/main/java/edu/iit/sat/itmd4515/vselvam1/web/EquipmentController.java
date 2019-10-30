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
public class EquipmentController {

    @EJB
    private EquipmentService equipSvc;

    private static final Logger LOG = Logger.getLogger(EquipmentController.class.getName());

    private Equipment equipment;

    public EquipmentController() {
    }

    @PostConstruct
    private void postConstruct() {

        equipment = new Equipment();
    }

    public String doSaveEquipment() {
        LOG.info("Here in doSaveEquipment " + equipment.toString());
        equipSvc.create(equipment);
        return "equipmentconfirm.xhtml";
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
