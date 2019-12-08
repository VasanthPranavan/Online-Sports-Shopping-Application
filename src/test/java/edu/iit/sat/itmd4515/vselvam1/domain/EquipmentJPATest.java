/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDate;
import java.time.Month;
import javax.persistence.RollbackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Vasanth Pranavan
 */
public class EquipmentJPATest extends AbstractJPATest {

    /**
     *
     */
    public EquipmentJPATest() {
    }

    //crate Test

    /**
     *
     */
    @Test
    public void createEquipTestPass() {
        Equipment equipment = new Equipment("createEquipTest", "Jock", Type.GYMNASTICS, 12.0, LocalDate.of(2019, 9, 29));
        tx.begin();
        assertNull(equipment.getId());
        em.persist(equipment);
        //assertNotNull(equipment.getId());

        tx.commit();
        assertNotNull(equipment.getId());
        assertTrue(equipment.getId() >= 1l);
        System.out.println("New Record: " + equipment.toString());
//em.remove(equipment);
    }

    /**
     *
     */
//    @Test
//    public void createEquipTestFail() {
//
//        Equipment equipment = new Equipment("Skipping ropes", "Jock", Type.GYMNASTICS, 12.0, LocalDate.of(2019, 9, 29));
//        assertThrows(RollbackException.class, () -> {
//            tx.begin();
//            em.persist(equipment);
//            tx.commit();
//        });
//    }

    //read Test

    /**
     *
     */
    @Test
    public void readEquipTest() {
//        Equipment equipment
//                = em.createQuery("select e from Equipment e where e.name = :name", Equipment.class)
//                        .setParameter("name", "Skipping ropes").getSingleResult();

        Equipment equipment = em.createNamedQuery("Equipment.findByName", Equipment.class)
                .setParameter("name", "Skipping ropes").getSingleResult();

        assertNotNull(equipment);
        assertTrue(equipment.getId() >= 1l);

        System.out.println("Read Successful: " + equipment.toString());

    }

    //update Test

    /**
     *
     */
    @Test
    public void updateEquipTest() {
        Equipment equipment
                = em.createQuery("select e from Equipment e where e.name = :name", Equipment.class)
                        .setParameter("name", "Skipping ropes").getSingleResult();

        tx.begin();
        equipment.setName("Clutcher");
        tx.commit();
        Equipment equipUpdate = em.find(Equipment.class, equipment.getId());
        System.out.println("Updated: " + equipment.toString());
        assertEquals(equipment.getName(), equipUpdate.getName());
        assertEquals(equipment.getType(), equipUpdate.getType());
        tx.begin();
        // setting the name to match with aftereach
        equipment.setName("Skipping ropes");

        tx.commit();

    }
   // delte Test

    /**
     *
     */
    @Test
    public void deleteEquipTest() {
        Equipment equipment = new Equipment("delteeEquipTest", "Jock", Type.GYMNASTICS, 12.0, LocalDate.of(2019, 9, 29));
        tx.begin();
        em.persist(equipment);
        tx.commit();
        System.out.println("To delete: " + equipment.toString());
        assertNotNull(equipment.getId());

        tx.begin();
        em.remove(equipment);
        tx.commit();

        System.out.println("removed:\t" + equipment.toString());

        Equipment removeEquipment = em.find(Equipment.class, equipment.getId());
        assertNull(removeEquipment);;

    }

    /**
     *
     */
    @Test
    public void testOrderEquipmentMtoMrelationship() {

        Equipment e = new Equipment("wrist Band", "Jock", Type.BALLS, 12.34, LocalDate.of(2019, Month.OCTOBER, 31));
        ItemOrder o = new ItemOrder("ordername");

        o.addEquipment(e);

        tx.begin();
        em.persist(e);
        em.persist(o);
        tx.commit();

        ItemOrder findOrder = em.find(ItemOrder.class, o.getId());
        assertEquals(o.getName(), findOrder.getName());
        System.out.println("Owning side " + findOrder.toString());
        System.out.println(findOrder.getEquipments().get(0).getName());

        assertEquals(1, findOrder.getEquipments().size());

        Equipment findEquipment = em.find(Equipment.class, e.getId());
        System.out.println("Inverse Side " + findEquipment.toString());
        System.out.println(findEquipment.getOrders().get(0).getName());

        assertEquals(1, findEquipment.getOrders().size());

        assertEquals(findOrder.getEquipments().get(0).getName(), findEquipment.getName());

        tx.begin();
        o.removeEquipment(e);
        em.remove(e);
        tx.commit();

        findOrder = em.find(ItemOrder.class, o.getId());
        System.out.println("Found the order after remove(equipment) " + findOrder.toString());

        System.out.println("findOrder has these Equipments: ");
        for (Equipment fe : findOrder.getEquipments()) {
            System.out.println(fe.toString());
        }
        assertTrue(findOrder.getEquipments().size() == 0);

        tx.begin();
        em    .remove(o);
        tx.commit();
    }
}
