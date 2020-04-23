/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.models;

import java.util.Date;

/**
 *
 * @author Nitant
 */
public class Form {
    private int form_id;
    private String name;
    private String type;
    private int institute_id;
    private int department_id;
    private int subject_id;
    private int form_structure_id;
    private Date teaching_plan_start; 
    private Date teaching_plan_end; 
    private boolean is_enabled;
    private boolean is_admin_accepted;
    private boolean is_hod_accepted;
    private boolean is_dept_coord_accepted;
    private boolean is_inst_coord_accepted;
    private boolean is_submitted;

    public Form() {
        super();
    }
    
    public Form(int form_id) {
        this.form_id = form_id;
    }
    

    public Form(int form_id, String name, String type, int institute_id, int department_id, int subject_id, int form_structure_id, Date teaching_plan_start, Date teaching_plan_end, boolean is_enabled, boolean is_admin_accepted, boolean is_hod_accepted, boolean is_dept_coord_accepted, boolean is_inst_coord_accepted, boolean is_submitted) {
        this.form_id = form_id;
        this.name = name;
        this.type = type;
        this.institute_id = institute_id;
        this.department_id = department_id;
        this.subject_id = subject_id;
        this.form_structure_id = form_structure_id;
        this.teaching_plan_start = teaching_plan_start;
        this.teaching_plan_end = teaching_plan_end;
        this.is_enabled = is_enabled;
        this.is_admin_accepted = is_admin_accepted;
        this.is_hod_accepted = is_hod_accepted;
        this.is_dept_coord_accepted = is_dept_coord_accepted;
        this.is_inst_coord_accepted = is_inst_coord_accepted;
        this.is_submitted = is_submitted;
    }

    public Form(int form_id, String name,String type, int institute_id, int department_id, int subject_id, int form_structure_id, Date teaching_plan_start,Date teaching_plan_end) {
        this.form_id = form_id;
        this.name = name;
        this.type = type;
        this.institute_id = institute_id;
        this.department_id = department_id;
        this.subject_id = subject_id;
        this.form_structure_id = form_structure_id;
        this.teaching_plan_start = teaching_plan_start;
        this.teaching_plan_end = teaching_plan_end;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public Date getTeaching_plan_start() {
        return teaching_plan_start;
    }

    public void setTeaching_plan_start(Date teaching_plan_start) {
        this.teaching_plan_start = teaching_plan_start;
    }

    public Date getTeaching_plan_end() {
        return teaching_plan_end;
    }

    public void setTeaching_plan_end(Date teaching_plan_end) {
        this.teaching_plan_end = teaching_plan_end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(int institute_id) {
        this.institute_id = institute_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getForm_structure_id() {
        return form_structure_id;
    }

    public void setForm_structure_id(int form_structure_id) {
        this.form_structure_id = form_structure_id;
    }

    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    public boolean isIs_admin_accepted() {
        return is_admin_accepted;
    }

    public void setIs_admin_accepted(boolean is_admin_accepted) {
        this.is_admin_accepted = is_admin_accepted;
    }

    public boolean isIs_hod_accepted() {
        return is_hod_accepted;
    }

    public void setIs_hod_accepted(boolean is_hod_accepted) {
        this.is_hod_accepted = is_hod_accepted;
    }

    public boolean isIs_dept_coord_accepted() {
        return is_dept_coord_accepted;
    }

    public void setIs_dept_coord_accepted(boolean is_dept_coord_accepted) {
        this.is_dept_coord_accepted = is_dept_coord_accepted;
    }

    public boolean isIs_inst_coord_accepted() {
        return is_inst_coord_accepted;
    }

    public void setIs_inst_coord_accepted(boolean is_inst_coord_accepted) {
        this.is_inst_coord_accepted = is_inst_coord_accepted;
    }

    public boolean isIs_submitted() {
        return is_submitted;
    }

    public void setIs_submitted(boolean is_submitted) {
        this.is_submitted = is_submitted;
    }

    @Override
    public String toString() {
        return "Form{" + "form_id=" + form_id + ", name=" + name + ", subject_id=" + subject_id + '}';
    }
    
}
