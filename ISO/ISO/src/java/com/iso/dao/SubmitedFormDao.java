/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.SubmitedForm;
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
public class SubmitedFormDao implements Dao<SubmitedForm>{

    @Override
    public List<SubmitedForm> view() {
        List<SubmitedForm> list = new ArrayList<>();
        try {
            String query = "Select * from submited_form";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int submit_form_id = rs.getInt("i_submit_form_id");
                int user_id = rs.getInt("f_user_id");
                int form_id = rs.getInt("f_form_id");
                int form_field_data = rs.getInt("f_form_field_data");
                list.add(new SubmitedForm(submit_form_id ,user_id, form_id, form_field_data));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubmitedFormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int delete(SubmitedForm obj) {
         try {
            String sql = "Delete from submited_form where i_submit_form_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getSubmit_form_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubmitedFormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; 
    }

    @Override
    public int update(SubmitedForm obj) {
         try {
            String query = "Update submited_from set f_user_id = ?, f_form_id = ?,f_form_field_data=? where i_submit_form_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, obj.getUser_id());
            ps.setInt(2, obj.getForm_id());
            ps.setInt(3, obj.getForm_field_id()); 
            ps.setInt(4, obj.getSubmit_form_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubmitedFormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    
    }

    @Override
    public int insert(SubmitedForm obj) {
        try {
            String query = "Insert into submited_form (f_user_id, f_form_id, f_form_fied_data) values(?, ?,?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, obj.getUser_id());
            ps.setInt(2, obj.getForm_id());
            ps.setInt(3, obj.getForm_field_id()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubmitedFormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
