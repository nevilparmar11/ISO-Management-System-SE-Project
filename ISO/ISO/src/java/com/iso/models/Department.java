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
public class Department {
    private int department_id;
    private String name;
    private int institute_id;

    public Department() {
        super();
    }
    
    
    public Department(int department_id, String name, int institute_id) {
        this.department_id = department_id;
        this.name = name;
        this.institute_id = institute_id;
    }
    
    
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(int institute_id) {
        this.institute_id = institute_id;
    }

    @Override
    public String toString() {
        return "Department{" + "name=" + name + '}';
    }
    
}
