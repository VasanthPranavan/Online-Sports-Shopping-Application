/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import edu.iit.sat.itmd4515.vselvam1.domain.Equipment;
import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import edu.iit.sat.itmd4515.vselvam1.domain.Type;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vasanth Pranavan
 */
@Startup
@Singleton
public class StartupSeedDatabase {

    private static final Logger LOG = Logger.getLogger(StartupSeedDatabase.class.getName());

    @EJB
    EquipmentService equipSvc;

    @EJB
    ItemOrderService itmOrdSvc;

    public StartupSeedDatabase() {
    }

    @PostConstruct
    private void seedDatabase() {
        LOG.info("StartupSeedDatabase  was invoked");

        ItemOrder o1 = new ItemOrder("Order one");
        ItemOrder o2 = new ItemOrder("Order two");

        Equipment e1 = new Equipment("Jock", "John", Type.BALLS, 45.6, LocalDate.of(2019, Month.JANUARY, 31));
        Equipment e2 = new Equipment("Stretch ropes", "rops", Type.BALLS, 45.6, LocalDate.of(2019, Month.JANUARY, 31));
        Equipment e3 = new Equipment("Bats", "rops", Type.BALLS, 45.6, LocalDate.of(2019, Month.JANUARY, 31));

        equipSvc.create(e1);
        equipSvc.create(e2);
        equipSvc.create(e3);

        //  em.flush();
        LOG.info(e1.toString());
        LOG.info(e2.toString());
        LOG.info(e3.toString());

        o1.addEquipment(e1);
        o2.addEquipment(e2);
        o2.addEquipment(e3);

        itmOrdSvc.create(o1);
        itmOrdSvc.create(o2);

        System.out.println("PRDERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRr");

        LOG.info("Seeded Equipments");
        for (Equipment e : equipSvc.findAll()) {
            LOG.info(e.toString());
            for (ItemOrder o : e.getOrders()) {
                LOG.info("ItemOder  " + o.toString());
            }
        }
        LOG.info("Seeded ItemOrders");
        for (ItemOrder o : itmOrdSvc.findAll()) {
            LOG.info(o.toString());
            for (Equipment e : o.getEquipments()) {
                LOG.info("      Equipment name:   " + e.toString());

            }

        }
    }
}
