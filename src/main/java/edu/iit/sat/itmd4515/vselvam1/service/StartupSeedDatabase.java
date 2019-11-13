/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import edu.iit.sat.itmd4515.vselvam1.domain.Equipment;
import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import edu.iit.sat.itmd4515.vselvam1.domain.Physician;
import edu.iit.sat.itmd4515.vselvam1.domain.Type;
import edu.iit.sat.itmd4515.vselvam1.domain.security.Group;
import edu.iit.sat.itmd4515.vselvam1.domain.security.User;
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

    @EJB
    PhysicianService phySvc;

    @EJB
    UserService userSvc;

    @EJB
    GroupService groupSvc;

    public StartupSeedDatabase() {
    }

    @PostConstruct
    private void seedDatabase() {
        LOG.info("StartupSeedDatabase  was invoked");
//security
        User admin = new User("admin", "admin", true);
        Group adminGroup = new Group("ADMIN_GROUP", "This is demo identity store");
        admin.addGroup(adminGroup);

        groupSvc.create(adminGroup);
        userSvc.create(admin);

        //Domain
        Group physicianGroup = new Group("PHYSICIAN_GROUP", "PHYSICAINS. This is demo identity store");
        Group customerGroup = new Group("CUSTOMER_GROUP", "CUSTOMERS. This is demo identity store");

        groupSvc.create(physicianGroup);
        groupSvc.create(customerGroup);

        User customer1 = new User("customer1", "customer1", true);
        customer1.addGroup(customerGroup);

        User customer2 = new User("customer2", "customer2", true);
        customer2.addGroup(customerGroup);

        User physician1 = new User("physician1", "physician1", true);
        physician1.addGroup(physicianGroup);
        physician1.addGroup(customerGroup);

        User physician2 = new User("physician2", "physician2", true);
        physician2.addGroup(physicianGroup);

        userSvc.create(customer1);
        userSvc.create(customer2);

        userSvc.create(physician1);

        userSvc.create(physician2);

//domain
        ItemOrder o1 = new ItemOrder("Order one");
        o1.setUser(customer1);
        ItemOrder o2 = new ItemOrder("Order two");
        o2.setUser(customer2);
        ItemOrder o3 = new ItemOrder("Physician 2 as Customer");
        o3.setUser(physician1);
        Physician p1 = new Physician("Physician one");
        p1.setUser(physician1);
        Physician p2 = new Physician("Physician two");
        p2.setUser(physician2);

        Equipment e1 = new Equipment("Jock", "John", Type.BALLS, 45.6, LocalDate.of(2019, Month.JANUARY, 31));
        Equipment e2 = new Equipment("Stretch ropes", "rops", Type.BALLS, 45.6, LocalDate.of(2019, Month.JANUARY, 31));
        Equipment e3 = new Equipment("Bats", "rops", Type.BALLS, 45.6, LocalDate.of(2019, Month.JANUARY, 31));
        Equipment e4 = new Equipment("Nets", "rops", Type.ACCESSORIES, 45.6, LocalDate.of(2019, Month.JANUARY, 31));
        Equipment e5 = new Equipment("Caps", "rops", Type.ACCESSORIES, 45.6, LocalDate.of(2019, Month.JANUARY, 31));
                Equipment e6 = new Equipment("skins", "strech", Type.ACCESSORIES, 45.6, LocalDate.of(2019, Month.JANUARY, 31));


        equipSvc.create(e1);
        equipSvc.create(e2);
        equipSvc.create(e3);
        equipSvc.create(e4);
        equipSvc.create(e5);
                equipSvc.create(e6);


        //  em.flush();
        LOG.info(e1.toString());
        LOG.info(e2.toString());
        LOG.info(e3.toString());

        o1.addEquipment(e1);
        o2.addEquipment(e2);
        o2.addEquipment(e3);
        o2.addEquipment(e4);
        o3.addEquipment(e5);
                o3.addEquipment(e6);


        itmOrdSvc.create(o1);
        itmOrdSvc.create(o2);
        itmOrdSvc.create(o3);

        phySvc.create(p1);
        phySvc.create(p2);

        System.out.println("PRDERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRr");

        LOG.info("Seeded Equipments");
        for (Equipment e : equipSvc.findAll()) {
            LOG.info(e.toString());
            for (ItemOrder o : e.getOrders()) {
                LOG.info("ItemOder  " + o.toString());
            }
        }

        LOG.info("Seeded Physicians:");
        for (Physician p : phySvc.findAll()) {
            LOG.info(p.toString());
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
