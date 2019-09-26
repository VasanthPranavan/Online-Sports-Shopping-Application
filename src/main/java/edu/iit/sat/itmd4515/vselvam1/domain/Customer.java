/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Vasanth Pranavan
 */
public class Customer {
    @NotBlank(message = "Please enter the First Name")
    private String fName;
    @NotBlank(message = "Please enter the Last Name")
    private String lName;

    private Integer age;

    public Customer(String fName, String lName, Integer age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public Customer() {
    }



    /**
     * Get the value of fName
     *
     * @return the value of fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * Set the value of fName
     *
     * @param fName new value of fName
     */
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "fName=" + fName + ", lName=" + lName + ", age=" + age + '}';
    }

}
