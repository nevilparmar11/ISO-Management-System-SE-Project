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
public class SubmitedForm {
    private int submit_form_id;
    private int user_id;
    private int form_id;
    private int form_field_id;

    public SubmitedForm() {
    }

    public SubmitedForm(int submit_form_id, int user_id, int form_id, int form_field_id) {
        this.submit_form_id = submit_form_id;
        this.user_id = user_id;
        this.form_id = form_id;
        this.form_field_id = form_field_id;
    }

    public int getSubmit_form_id() {
        return submit_form_id;
    }

    public void setSubmit_form_id(int submit_form_id) {
        this.submit_form_id = submit_form_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public int getForm_field_id() {
        return form_field_id;
    }

    public void setForm_field_id(int form_field_id) {
        this.form_field_id = form_field_id;
    }

    @Override
    public String toString() {
        return "SubmitedForm{" + "submit_form_id=" + submit_form_id + ", user_id=" + user_id + ", form_id=" + form_id + ", form_field_id=" + form_field_id + '}';
    }
    
    
}
