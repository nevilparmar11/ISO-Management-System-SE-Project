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
public class SubjectTeaches {
    private int subject_teach_id;
    private int user_id;
    private int subeject_id;

    public SubjectTeaches() {
    }

    public SubjectTeaches(int subject_teach_id, int user_id, int subeject_id) {
        this.subject_teach_id = subject_teach_id;
        this.user_id = user_id;
        this.subeject_id = subeject_id;
    }

    public int getSubject_teach_id() {
        return subject_teach_id;
    }

    public void setSubject_teach_id(int subject_teach_id) {
        this.subject_teach_id = subject_teach_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSubeject_id() {
        return subeject_id;
    }

    public void setSubeject_id(int subeject_id) {
        this.subeject_id = subeject_id;
    }

    @Override
    public String toString() {
        return "SubjectTeaches{" + "subject_teach_id=" + subject_teach_id + ", user_id=" + user_id + ", subeject_id=" + subeject_id + '}';
    }
    
    
}
