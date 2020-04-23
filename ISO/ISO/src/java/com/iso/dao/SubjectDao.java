/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.Subject;
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
public class SubjectDao implements Dao<Subject>{

    @Override
    public List<Subject> view() {
        List<Subject> list = new ArrayList<>();
        try {
            String query = "Select * from subject";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int subject_id = rs.getInt("i_subject_id");
                String name = rs.getString("c_subject_name");
                int semester = rs.getInt("i_semester");
                list.add(new Subject(subject_id, name, semester));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Subject getSpecific(int subjectid) {
        Subject list = new Subject();
        try {
            String query = "Select * from subject where i_subject_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,subjectid);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int subject_id = rs.getInt("i_subject_id");
                String name = rs.getString("c_subject_name");
                int semester = rs.getInt("i_semester");
                list = new Subject(subject_id, name, semester);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int delete(Subject obj) {
        try {
            String sql = "Delete from subject where i_subject_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getSubject_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int update(Subject obj) {
        try {
            String query = "Update subject set c_subject_name = ?, i_semester = ? where i_subject_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getSubject_name());
            ps.setInt(2, obj.getSemester());
            ps.setInt(3, obj.getSubject_id()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int insert(Subject obj) {
       try {
            String query = "Insert into subject(c_subject_name, i_semester) values(?, ?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getSubject_name());
            ps.setInt(2, obj.getSemester());
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
