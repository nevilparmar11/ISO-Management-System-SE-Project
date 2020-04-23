/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.Department;
import com.iso.services.DatabaseConnectionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nitant
 */
public class DepartmentDao implements Dao<Department> {

    @Override
    public List<Department> view() {
        List<Department> list = new ArrayList<>();
        try {
            String query = "Select * from department";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int department_id = rs.getInt("i_department_id");
                String name = rs.getString("c_name");
                int institute_id = rs.getInt("f_institute_id");
                list.add(new Department(department_id, name, institute_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Department getSpecific(int departmentId) {
        Department list = new Department();
        try {
            String query = "Select * from department where i_department_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,departmentId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int department_id = rs.getInt("i_department_id");
                String name = rs.getString("c_name");
                int institute_id = rs.getInt("f_institute_id");
                list = new Department(department_id, name, institute_id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public int delete(Department obj) {
        try {
            String sql = "Delete from department where i_department_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getDepartment_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int update(Department obj) {
        try {
            String query = "Update department set c_name = ?, f_institute_id = ? where i_department_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getInstitute_id());
            ps.setInt(3, obj.getDepartment_id()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int insert(Department obj) {
        try {
            String query = "Insert into department(c_name, f_institute_id) values(?, ?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getInstitute_id());
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
