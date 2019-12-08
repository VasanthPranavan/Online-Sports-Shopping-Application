/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import edu.iit.sat.itmd4515.vselvam1.domain.security.Group;
import edu.iit.sat.itmd4515.vselvam1.domain.security.GroupBean;
import edu.iit.sat.itmd4515.vselvam1.domain.security.User;
import edu.iit.sat.itmd4515.vselvam1.domain.security.UserBean;
import edu.iit.sat.itmd4515.vselvam1.service.GroupService;
import edu.iit.sat.itmd4515.vselvam1.service.UserService;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@SessionScoped
public class CustomerDetails implements  Serializable {
   
    @EJB
    private GroupBean groupBean;
    @EJB
    private UserBean userBean;
    
    
    @EJB
    UserService userSvc;

    @EJB
    GroupService groupSvc;
    
    private User user = new User();
    Logger logger = Logger.getLogger(getClass().getName());

        private ItemOrder itemorder= new ItemOrder();

    /**
     *
     * @return
     */
    public String doRegisterUser(){
        
        //add user to group
        
//        String username=user.getUserName();
//        String pwd = user.getPassword();
        
        User user1 = new User (user.getUserName(), user.getPassword(), Boolean.TRUE);             
         Group group1 = new Group("CUSTOMER_GROUP", "CUSTOMERS. This is demo identity store");
         
//         user1.addGroup(group1);
//                 logger.info("cust3333333333333omer created!!!");
//         groupSvc.create(group1);
//        logger.info("custom4444444444444er created!!!");

         userSvc.create(user1);
        
        logger.info("customer created!!!");
        return "/login.xhtml";
    }

    
//    
//    public String doAddToOrder(){
//        
//   
//        
//        ItemOrder itemorder1 = new ItemOrder (itemorder.getName());             
//        itemorder1.setUser(user);
//        
//        logger.info("order created!!!");
//        return "/login.xhtml";
//    }

    
    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public ItemOrder getItemorder() {
        return itemorder;
    }

    /**
     *
     * @param itemorder
     */
    public void setItemorder(ItemOrder itemorder) {
        this.itemorder = itemorder;
    }

}
