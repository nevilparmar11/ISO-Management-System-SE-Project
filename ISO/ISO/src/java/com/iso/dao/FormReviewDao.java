/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.Department;
import com.iso.models.FormReview;
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
public class FormReviewDao implements Dao<FormReview>{

    @Override
    public List<FormReview> view() {
         List<FormReview> list = new ArrayList<>();
        try {
            String query = "Select * from FormReview";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int form_review_id = rs.getInt("i_form_review_id");
                int user_id = rs.getInt("f_user_id");
                int form_id = rs.getInt("f_form_id");
                String remarks = rs.getString("c_remarks");
                list.add(new FormReview(form_review_id, user_id, form_id, remarks));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormReviewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public FormReview getReview(int formId) {
        FormReview list = new FormReview();
        try {
            String query = "Select * from form_review where f_form_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,formId);;
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int form_review_id = rs.getInt("i_form_review_id");
                int user_id = rs.getInt("f_user_id");
                int form_id = rs.getInt("f_form_id");
                String remarks = rs.getString("c_remarks");
                list = new FormReview(form_review_id, user_id, form_id, remarks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormReviewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
    @Override
    public int delete(FormReview obj) {
      try {
            String sql = "Delete from form_review where i_form_review_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getForm_review_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormReviewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int update(FormReview obj) {
        try {
            String query = "Update form_review set f_user_id=?, f_form_id=?, c_remarks=? where i_form_review_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, obj.getUser_id());
            ps.setInt(2, obj.getForm_id());
            ps.setString(3, obj.getRemarks());
            ps.setInt(4, obj.getForm_review_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormReviewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int insert(FormReview obj) {
       try {
            String query = "Insert into form_review(f_user_id, f_form_id, c_remarks) values(?, ?, ?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, obj.getUser_id());
            ps.setInt(2, obj.getForm_id());
            ps.setString(3, obj.getRemarks());            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormReviewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
 
    }
    
}
