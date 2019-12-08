/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Vasanth Pranavan
 */
public class EquipmentDemoTest extends AbstractJPATest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    /**
     *
     */
    public EquipmentDemoTest() {
    }

    //@Test

    /**
     *
     */
    public void demoTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //POJO
        Equipment equipment = new Equipment("Dubmbells", "Forton", Type.WEIGHTS, 12.0, LocalDate.of(1990, 10, 31));
        tx.begin();
        em.persist(equipment);

        tx.commit();
        em.close();
        emf.close();
    }
}
