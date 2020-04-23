/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.Department;
import com.iso.models.Institute;
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
public class InstituteDao implements Dao<Institute> {

    @Override
    public List<Institute> view() {
       List<Institute> list = new ArrayList<>();
        try {
            String query = "Select * from institute";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int institute_id = rs.getInt("i_institute_id");
                String name = rs.getString("c_name");
                list.add(new Institute(institute_id, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstituteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Institute getSpecific(int id) {
       Institute list = new Institute();
        try {
            String query = "Select * from institute where i_institute_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int institute_id = rs.getInt("i_institute_id");
                String name = rs.getString("c_name");
                list = new Institute(institute_id, name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstituteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int delete(Institute obj) {
       try {
            String sql = "Delete from institute where i_institute_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getInstitute_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InstituteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int update(Institute obj) {
       try {
            String query = "Update institute set c_name = ? where i_institute_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getInstitute_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InstituteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int insert(Institute obj) {
       try {
            String query = "Insert into institute(c_name) values(?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getName());
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InstituteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
