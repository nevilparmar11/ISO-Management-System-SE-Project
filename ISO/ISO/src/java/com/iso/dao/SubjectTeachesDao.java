/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.Subject;
import com.iso.models.SubjectTeaches;
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
public class SubjectTeachesDao implements Dao<SubjectTeaches> {

    @Override
    public List<SubjectTeaches> view() {
       List<SubjectTeaches> list = new ArrayList<>();
        try {
            String query = "Select * from subject_teaches";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int subject_teach_id = rs.getInt("i_subject_teach_id");
                int user_id = rs.getInt("f_user_id");
                int subject_id = rs.getInt("f_subject_id");
                list.add(new SubjectTeaches(subject_teach_id, user_id, subject_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectTeachesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<SubjectTeaches> getSubjectTeaches(int subjectId) {
       List<SubjectTeaches> list = new ArrayList<>();
        try {
            String query = "Select * from subject_teaches where f_subject_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int subject_teach_id = rs.getInt("i_subject_teach_id");
                int user_id = rs.getInt("f_user_id");
                int subject_id = rs.getInt("f_subject_id");
                list.add(new SubjectTeaches(subject_teach_id, user_id, subject_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectTeachesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Integer> getSubjectList(int user_id) {
       List<Integer> list = new ArrayList<>();
        try {
            String query = "Select * from subject_teaches where f_user_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
//                int subject_teach_id = rs.getInt("i_subject_teach_id");
//                int user_id = rs.getInt("f_user_id");
                int subject_id = rs.getInt("f_subject_id");
                list.add(subject_id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectTeachesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    @Override
    public int delete(SubjectTeaches obj) {
     try {
            String sql = "Delete from subject_teaches where i_subject_teach_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getSubject_teach_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectTeachesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;  
    }

    @Override
    public int update(SubjectTeaches obj) {
        try {
            String query = "Update subject set f_user_id = ?, f_subject_id = ? where i_subject_teach_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, obj.getUser_id());
            ps.setInt(2, obj.getSubeject_id());
            ps.setInt(3, obj.getSubject_teach_id()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectTeachesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    
    }

    @Override
    public int insert(SubjectTeaches obj) {
        try {
            String query = "Insert into subject_teaches(f_user_id, f_subject_id) values(?, ?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, obj.getUser_id());
            ps.setInt(2, obj.getSubeject_id());
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectTeachesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
