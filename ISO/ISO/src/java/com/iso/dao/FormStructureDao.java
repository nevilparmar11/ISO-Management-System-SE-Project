/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.FormStructure;
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
public class FormStructureDao implements Dao<FormStructure>{

    @Override
    public List<FormStructure> view() {
      List<FormStructure> list = new ArrayList<>();
        try {
            String query = "Select * from form_structure";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int form_structure_id = rs.getInt("i_form_structure_id");
                String field_1 = rs.getString("c_field_1");
                String field_2 = rs.getString("c_field_2");
                String name = rs.getString("c_name");
             
                list.add(new FormStructure(form_structure_id, name, field_1, field_2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormStructureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public FormStructure getSpecificStructure(int id) {
      FormStructure form = new FormStructure();
        try {
            String query = "Select * from form_structure where i_form_structure_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int form_structure_id = rs.getInt("i_form_structure_id");
                String field_1 = rs.getString("c_field_1");
                String field_2 = rs.getString("c_field_2");
                String name = rs.getString("c_name");
               
                form = new FormStructure(form_structure_id, name, field_1, field_2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormStructureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return form;
    }
    
    @Override
    public int delete(FormStructure obj) {
     try {
            String sql = "Delete from form_structure where i_form_structure_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getForm_structure_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormStructureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int update(FormStructure obj) {
        try {
            String query = "Update form_structure set c_field_1 = ?, c_field_2 = ?, c_name=? where i_form_structure_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getField_1());
            ps.setString(2, obj.getField_2());
            ps.setString(3, obj.getName());
            ps.setInt(4, obj.getForm_structure_id()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormStructureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; 
    }

    @Override
    public int insert(FormStructure obj) {
      try {
            String query = "Insert into form_structure(c_name,c_field_1,c_field_2) values(?,?, ?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getField_1());
            ps.setString(3, obj.getField_2());
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormStructureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
 
    }
    
}
