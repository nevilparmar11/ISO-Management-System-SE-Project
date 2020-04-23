/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.Form;
import com.iso.services.DatabaseConnectionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nitant
 */
public class FormDao implements Dao<Form> {
    
    public FormDao(){
        super();
    }
    @Override
    public List<Form> view() {
        List<Form> list = new ArrayList<>();
        try {
            String query = "Select * from form";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){   
                int form_id = rs.getInt("i_form_id");
                String name = rs.getString("c_form_name");
                String type = rs.getString("c_type");
                int subject_id = rs.getInt("f_subject_id");
                int institute_id = rs.getInt("f_institute_id");
                int department_id = rs.getInt("f_department_id");
                int form_structure_id = rs.getInt("f_form_structure_id");
                Date teaching_plan_start = rs.getDate("dt_teaching_plan_start");
                Date teaching_plan_end = rs.getDate("dt_teaching_plan_end");
                boolean is_enabled = rs.getBoolean("b_is_enabled");
                boolean is_admin_accepted = rs.getBoolean("b_admin_accepted");
                boolean is_hod_accepted = rs.getBoolean("b_hod_accepted");
                boolean is_dept_coord_accepted = rs.getBoolean("b_dept_coord_accepted");
                boolean is_inst_coord_accepted = rs.getBoolean("b_inst_coord_accepted");
                boolean is_submitted = rs.getBoolean("b_is_submitted");
                list.add(new Form(form_id, name, type, institute_id, department_id, subject_id, form_structure_id, teaching_plan_start,teaching_plan_end, is_enabled, is_admin_accepted, is_hod_accepted, is_dept_coord_accepted, is_inst_coord_accepted, is_submitted));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Form viewSpecific(int id) {
        Form form = new Form();
        try {
            String query = "Select * from form where i_form_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){   
                int form_id = rs.getInt("i_form_id");
                String name = rs.getString("c_form_name");
                String type = rs.getString("c_type");
                int subject_id = rs.getInt("f_subject_id");
                int institute_id = rs.getInt("f_institute_id");
                int department_id = rs.getInt("f_department_id");
                int form_structure_id = rs.getInt("f_form_structure_id");
                Date teaching_plan_start = rs.getDate("dt_teaching_plan_start");
                Date teaching_plan_end = rs.getDate("dt_teaching_plan_end");
                boolean is_enabled = rs.getBoolean("b_is_enabled");
                boolean is_admin_accepted = rs.getBoolean("b_admin_accepted");
                boolean is_hod_accepted = rs.getBoolean("b_hod_accepted");
                boolean is_dept_coord_accepted = rs.getBoolean("b_dept_coord_accepted");
                boolean is_inst_coord_accepted = rs.getBoolean("b_inst_coord_accepted");
                boolean is_submitted = rs.getBoolean("b_is_submitted");
                form = new Form(form_id, name, type, institute_id, department_id, subject_id, form_structure_id, teaching_plan_start,teaching_plan_end, is_enabled, is_admin_accepted, is_hod_accepted, is_dept_coord_accepted, is_inst_coord_accepted, is_submitted);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return form;
    }

    @Override
    public int delete(Form obj) {
        try {
            String sql = "Delete from form where i_form_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getForm_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int update(Form obj) {
        try {
          String query = "Update form set c_form_name=?, c_type=?, f_subject_id=? , f_institute_id=?,"
                    +       "f_department_id=?, f_form_structure_id=?, dt_teaching_plan_start=?, b_is_enabled=?,"
                    +       "b_admin_accepted=?, b_hod_accepted=?, b_dept_coord_accepted=?, "
                    +       "b_inst_coord_accepted=?, b_is_submitted=?,dt_teaching_plan_end =?"
                    +       "where i_form_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getType());
            ps.setInt(3, obj.getSubject_id());
            ps.setInt(4, obj.getInstitute_id());
            ps.setInt(5, obj.getDepartment_id());
            ps.setInt(6, obj.getForm_structure_id());
            ps.setDate(7, new java.sql.Date(obj.getTeaching_plan_start().getTime()));
            ps.setBoolean(8, obj.isIs_enabled());
            ps.setBoolean(9, obj.isIs_admin_accepted());
            ps.setBoolean(10, obj.isIs_hod_accepted());
            ps.setBoolean(11, obj.isIs_dept_coord_accepted());
            ps.setBoolean(12, obj.isIs_inst_coord_accepted());
            ps.setBoolean(13, obj.isIs_submitted());
            ps.setDate(14, new java.sql.Date(obj.getTeaching_plan_end().getTime()));
            ps.setInt(15, obj.getForm_id());
           //ps.setInt(16, obj.getForm_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int insert(Form obj) {
        try {
            String query = "Insert into Form(i_form_id, c_form_name, c_type, f_subject_id, f_institute_id,"
                    +       "f_department_id, f_form_structure_id, dt_teaching_plan_start, b_is_enabled,"
                    +       "b_admin_accepted, b_hod_accepted, b_dept_coord_accepted, "
                    +       "b_inst_coord_accepted, b_is_submitted,dt_teaching_plan_end)"
                    +       "values(?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?,?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, obj.getForm_id());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getType());
            ps.setInt(4, obj.getSubject_id());
            ps.setInt(5, obj.getInstitute_id());
            ps.setInt(6, obj.getDepartment_id());
            ps.setInt(7, obj.getForm_structure_id());
            ps.setDate(8, new java.sql.Date(obj.getTeaching_plan_start().getTime()));
            ps.setBoolean(9, obj.isIs_enabled());
            ps.setBoolean(10, obj.isIs_admin_accepted());
            ps.setBoolean(11, obj.isIs_hod_accepted());
            ps.setBoolean(12, obj.isIs_dept_coord_accepted());
            ps.setBoolean(13, obj.isIs_inst_coord_accepted());
            ps.setBoolean(14, obj.isIs_submitted());
            ps.setDate(15, new java.sql.Date(obj.getTeaching_plan_end().getTime()));
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

   
}
