/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.web;

import edu.iit.sat.itmd4515.vselvam1.domain.ItemOrder;
import edu.iit.sat.itmd4515.vselvam1.service.ItemOrderService;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Vasanth Pranavan
 */
@FacesConverter(managed = true, value = "customerConverter")
public class CustomerConverter implements Converter{
    
    @EJB
    private ItemOrderService itemOrderService;
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty()){
            return null;
        }
        return itemOrderService.find(Long.valueOf(value));

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if(value == null){
            return "";
        }
        return String.valueOf(((ItemOrder)value).getId());
    }
    
    
}
