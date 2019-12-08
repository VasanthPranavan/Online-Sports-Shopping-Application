/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import edu.iit.sat.itmd4515.vselvam1.domain.Equipment;
import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import edu.iit.sat.itmd4515.vselvam1.domain.Type;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Vasanth Pranavan
 */
@Named
@ApplicationScoped
public class AppConfig {

    /**
     *
     */
    public AppConfig() {
    }
    
    /**
     *
     * @return
     */
    public Type[] getAllEquipTypes(){
        return Type.values();
    }
    
    /**
     *
     * @param e
     * @return
     */
    public String getOrders(Equipment e){
        List<String> orderName= new ArrayList<>();
        for(ItemOrder o: e.getOrders()){
            orderName.add(o.getName());
        }
    return String.join(",",orderName);
    }
    
    public Type[] getAllPhysicians(){
        return Type.values();
    }
}
