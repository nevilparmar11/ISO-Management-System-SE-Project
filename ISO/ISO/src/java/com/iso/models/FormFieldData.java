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
public class FormFieldData {
    private int form_field_dataid;
    private String field_1;
    private int field_2;
    private int form_id;
    private int sequence;
    public FormFieldData() {
    }

    public FormFieldData(int form_field_id, String field_1, int field_2,int form_id,int sequence) {
        this.form_field_dataid = form_field_id;
        this.field_1 = field_1;
        this.field_2 = field_2;
        this.form_id = form_id;
        this.sequence = sequence;
    }
     public FormFieldData(String field_1, int field_2,int form_id,int sequence) {
        this.field_1 = field_1;
        this.field_2 = field_2;
        this.form_id = form_id;
        this.sequence = sequence;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getForm_field_id() {
        return form_field_dataid;
    }

    public void setForm_field_id(int form_field_id) {
        this.form_field_dataid = form_field_id;
    }

    public String getField_1() {
        return field_1;
    }

    public void setField_1(String field_1) {
        this.field_1 = field_1;
    }

    public int getField_2() {
        return field_2;
    }

    public void setField_2(int field_2) {
        this.field_2 = field_2;
    }

    @Override
    public String toString() {
        return "FormFieldData{" + "form_field_id=" + form_field_dataid + ", field_1=" + field_1 + ", field_2=" + field_2 + '}';
    }
  
    
}
