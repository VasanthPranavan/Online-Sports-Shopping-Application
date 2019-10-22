/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Vasanth Pranavan
 */
public class EquipmentValidationTest extends AbstractValidationTest {

    public EquipmentValidationTest() {
    }

    //sunny day test case
    @Test
    public void testNameNullFailure() {

        Equipment badEquipment = new Equipment("", "Jock", Type.GYMNASTICS, 12.0, LocalDate.of(2019, 9, 29));
        Set<ConstraintViolation<Equipment>> constraintViolations
                = validator.validate(badEquipment);

        assertEquals(1, constraintViolations.size());
        assertEquals(
                "must not be blank",
                constraintViolations.iterator().next().getMessage()
        );
        //rainy day test case

    }

    @Test
    public void testNameNullFailureFail() {

        Equipment badEquipment = new Equipment("", "Jock", Type.GYMNASTICS, 12.0, LocalDate.of(2019, 9, 29));
        Set<ConstraintViolation<Equipment>> constraintViolations
                = validator.validate(badEquipment);

        String err = constraintViolations.iterator().next().getMessage();
//        assertEquals(0, constraintViolations.size());
        if (err.matches("must not be blank")) {
            assertTrue(true);
        }

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
