/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.models;

/**
 *
 * @author Nitant
 */
public class Institute {
    private int institute_id;
    private String name;

    public Institute() {
    }

    public Institute(int institute_id, String name) {
        this.institute_id = institute_id;
        this.name = name;
    }

    public int getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(int institute_id) {
        this.institute_id = institute_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Institute{" + "institute_id=" + institute_id + ", name=" + name + '}';
    }
    

    
}
