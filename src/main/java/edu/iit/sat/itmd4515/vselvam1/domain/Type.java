/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.domain;

/**
 *
 * @author Vasanth Pranavan
 */
public enum Type {
    WEIGHTS("Dumbbells"),
    GYMNASTICS("Skipping Ropes"),
    BALLS("Medicine Ball"),
    ACCESSORIES("Head Band");

    private String label;

    private Type(String Label) {
        this.label = label;
    }

    /**
     * Get the value of label
     *
     * @return the value of label
     */
    public String getLabel() {
        return label;
    }

}
