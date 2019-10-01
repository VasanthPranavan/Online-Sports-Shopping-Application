/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDate;
import javax.persistence.RollbackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Vasanth Pranavan
 */
public class EquipmentJPATest extends AbstractJPATest {

   
    public EquipmentJPATest() {
    }

    //crate Test
    @Test
    public void createEquipTestPass() {
        Equipment equipment = new Equipment("createEquipTest ", "Jock", "Flex", 12.0, LocalDate.of(2019, 9, 29));
        tx.begin();
        assertNull(equipment.getId());
        em.persist(equipment);
        //assertNotNull(equipment.getId());

        tx.commit();
        assertNotNull(equipment.getId());
        assertTrue(equipment.getId() >= 1l);
        System.out.println("New Record: " + equipment.toString());

    }

    @Test
    public void createEquipTestFail() {

        Equipment equipment = new Equipment("Skipping ropes", "Jock", "Flex", 12.0, LocalDate.of(2019, 9, 29));
        assertThrows(RollbackException.class, () -> {
            tx.begin();
            em.persist(equipment);
            tx.commit();
        });
    }

    //read Test
    @Test
    public void readEquipTest() {
        Equipment equipment
                = em.createQuery("select e from Equipment e where e.name = :name", Equipment.class)
                        .setParameter("name", "Skipping ropes").getSingleResult();

        assertNotNull(equipment);
        assertTrue(equipment.getId() >= 1l);
        System.out.println("Read Successful: " + equipment.toString());

    }

    //update Test
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
    //delte Test

    @Test
    public void deleteEquipTest() {
        Equipment equipment = new Equipment("delteeEquipTest", "Jock", "Flex", 12.0, LocalDate.of(2019, 9, 29));
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

}
