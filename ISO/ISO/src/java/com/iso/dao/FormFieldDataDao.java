/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.FormFieldData;
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
public class FormFieldDataDao implements Dao<FormFieldData>{

    @Override
    public List<FormFieldData> view() {
        List<FormFieldData> list = new ArrayList<>();
        try {
            String query = "Select * from form_field_data";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int form_field_id = rs.getInt("i_form_field_dataid");
                String field_1 = rs.getString("c_field_1");
                int field_2 = rs.getInt("c_field_2");
                int form_id = rs.getInt("f_form_id");
                int sequence = rs.getInt("sequence");
                list.add(new FormFieldData(form_field_id, field_1, field_2,form_id,sequence));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormFieldDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public List<FormFieldData> getFormData(int formId) {
        List<FormFieldData> list = new ArrayList<>();
        try {
            String query = "Select * from form_field_data where f_form_id =? order by sequence";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,formId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int form_field_id = rs.getInt("i_form_field_dataid");
                String field_1 = rs.getString("c_field_1");
                int field_2 = rs.getInt("c_field_2");
                int form_id = rs.getInt("f_form_id");
                int sequence = rs.getInt("sequence");
                list.add(new FormFieldData(form_field_id, field_1, field_2,form_id,sequence));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormFieldDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
    @Override
    public int delete(FormFieldData obj) {
       try {
            String sql = "Delete from form_field_data where i_form_field_dataid = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getForm_field_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormFieldDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int deleteAll() {
       try {
            String sql = "Delete from form_field_data";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormFieldDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    @Override
    public int update(FormFieldData obj) {
     try {
            String query = "Update form_field_data set c_field_1 = ?, c_field_2 = ? where i_form_field_dataid = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getField_1());
            ps.setInt(2, obj.getField_2());
            ps.setInt(3, obj.getForm_field_id()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormFieldDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int insert(FormFieldData obj) {
     try {
            String query = "Insert into form_field_data(c_field_1,c_field_2,f_form_id,sequence) values(?, ?,?,?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getField_1());
            ps.setInt(2, obj.getField_2());
            ps.setInt(3, obj.getForm_id());
            ps.setInt(4, obj.getSequence());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormFieldDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
