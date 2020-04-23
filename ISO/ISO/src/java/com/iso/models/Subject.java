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
public class Subject {
    private int subject_id;
    private String subject_name;
    private int semester;

    public Subject() {
    }

    public Subject(int subject_id, String subject_name, int semester) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.semester = semester;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Subject{" + "subject_id=" + subject_id + ", subject_name=" + subject_name + ", semester=" + semester + '}';
    }
    
    
}
