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
public class User {
    private int user_id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;
    private String role;
    private int institute_id;
    private int department_id;
    private Department department;
    private Institute institute;

    
    
    public User() {
    }

    public User(int user_id, String first_name, String last_name, String username, String password, String email, String role, int institute_id, int department_id) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.institute_id = institute_id;
        this.department_id = department_id;
    }
    public User(int user_id, String first_name, String last_name, String username, String password, String email, String role, Institute institute,Department department    ) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.institute = institute;
        this.department = department;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", username=" + username + ", password=" + password + ", email=" + email + ", role=" + role + ", institute_id=" + institute_id + ", department_id=" + department_id + '}';
    }
    
    
    
    
}
