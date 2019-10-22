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
import javax.validation.Validator;
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
public abstract class AbstractJPATest {

    private static Validator validator;

    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;

    public AbstractJPATest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }

    @AfterAll
    public static void tearDownClass() {
        emf.close();
    }

    @BeforeEach
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        //POJO
        Equipment equipment = new Equipment("Skipping ropes", "Jock", Type.GYMNASTICS, 12.0, LocalDate.of(2019, 9, 29));
        tx.begin();
        em.persist(equipment);
        tx.commit();
    }

    @AfterEach
    public void tearDown() {
        Equipment equipment
                = em.createQuery("select e from Equipment e where e.name = :name", Equipment.class)
                        .setParameter("name", "Skipping ropes").getSingleResult();
        tx.begin();
        em.remove(equipment);
        tx.commit();
        em.close();
        System.out.println("Created: " + equipment.toString());

    }

}
