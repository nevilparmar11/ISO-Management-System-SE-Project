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
public class FormStructure {
    private int form_structure_id;
    private String field_1;
    private String field_2;
    private String name;
    
    public FormStructure() {
    }
    
    public FormStructure(int form_structure_id,String name, String field_1, String field_2) {
        this.form_structure_id = form_structure_id;
        this.field_1 = field_1;
        this.field_2 = field_2;
        this.name = name;
        
    }

   

    public int getForm_structure_id() {
        return form_structure_id;
    }

    public void setForm_structure_id(int form_structure_id) {
        this.form_structure_id = form_structure_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField_1() {
        return field_1;
    }

    public void setField_1(String field_1) {
        this.field_1 = field_1;
    }

    public String getField_2() {
        return field_2;
    }

    public void setField_2(String field_2) {
        this.field_2 = field_2;
    }

    @Override
    public String toString() {
        return "FormStructure{" + "form_structure_id=" + form_structure_id + ", field_1=" + field_1 + ", field_2=" + field_2 + '}';
    }
   
    
}
