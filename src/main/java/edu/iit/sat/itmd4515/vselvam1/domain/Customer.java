/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 *
 * @author Vasanth Pranavan
 */
public class Customer {

    @NotBlank(message = "Please enter the First Name")
    private String fName;
    @NotBlank(message = "Please enter the Last Name")
    private String lName;
    @Positive(message = "Please enter a Vaild Age")
    private Integer age;
    @NotBlank
    @Email(message = "Please enter the vaild email ID(Format: XXXX@yyy.com)")
    private String mail;

    public Customer() {
    }

    public Customer(String fName, String lName, Integer age, String mail) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer{" + "fName=" + fName + ", lName=" + lName + ", age=" + age + ", mail=" + mail + '}';
    }

}
