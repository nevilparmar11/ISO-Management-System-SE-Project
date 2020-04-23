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
public class FormReview {
    private int form_review_id;
    private int user_id;
    private int form_id;
    private String remarks;

    public FormReview() {
    }

    public FormReview(int form_review_id, int user_id, int form_id, String remarks) {
        this.form_review_id = form_review_id;
        this.user_id = user_id;
        this.form_id = form_id;
        this.remarks = remarks;
    }

    public int getForm_review_id() {
        return form_review_id;
    }

    public void setForm_review_id(int form_review_id) {
        this.form_review_id = form_review_id;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "FormReview{" + "form_review_id=" + form_review_id + ", user_id=" + user_id + ", form_id=" + form_id + ", remarks=" + remarks + '}';
    }
    
    
}
