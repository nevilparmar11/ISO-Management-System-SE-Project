/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.dao;

import com.iso.models.User;
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
public class UserDao implements Dao<User>{

    @Override
    public List<User> view() {
        List<User> list = new ArrayList<>();
        try {
            String query = "Select * from user";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int user_id = rs.getInt("i_user_id");
                String first_name = rs.getString("c_first_name");
                String last_name = rs.getString("c_last_name");
                String username = rs.getString("c_username");
                String email = rs.getString("e_email");
                String password = rs.getString("c_password");
                String role = rs.getString("c_role");
                int institute_id = rs.getInt("f_institute_id");
                int department_id = rs.getInt("f_department_data");
                list.add(new User(user_id, first_name, last_name, username, password, email, role, institute_id, department_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public User getUser(int id) {
        User user = new User();
        try {
            String query = "Select * from user where i_user_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int user_id = rs.getInt("i_user_id");
                String first_name = rs.getString("c_first_name");
                String last_name = rs.getString("c_last_name");
                String username = rs.getString("c_username");
                String email = rs.getString("e_email");
                String password = rs.getString("c_password");
                String role = rs.getString("c_role");
                int institute_id = rs.getInt("f_institute_id");
                int department_id = rs.getInt("f_department_id");
                
                user = new User(user_id, first_name, last_name, username, password, email, role, new InstituteDao().getSpecific(institute_id),new DepartmentDao().getSpecific(department_id));
                //Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,user.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    @Override
    public int delete(User obj) {
        try {
            String sql = "Delete from user where i_user_id = ?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getUser_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; 
    }

    @Override
    public int update(User obj) {
         try {
            String query = "Update user set c_first_name=?, c_last_name=?, c_username=?, c_password=?, e_email=?, "
                    +      "c_role=?, f_institute_id=?, f_department_id=? where i_user_id=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getFirst_name());
            ps.setString(2, obj.getLast_name());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getPassword());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getRole());
            ps.setInt(7, obj.getInstitute_id());
            ps.setInt(8, obj.getDepartment_id());
            ps.setInt(9, obj.getUser_id());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int insert(User obj) {
        try {
            String query = "Insert into user (c_first_name, c_last_name, c_username, c_password, e_email, "
                    +      "c_role, f_institute_id, f_department_id)"
                    +       " values(?,?,?,?,?,?,?,?)";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, obj.getFirst_name());
            ps.setString(2, obj.getLast_name());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getPassword());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getRole());
            ps.setInt(7, obj.getInstitute_id());
            ps.setInt(8, obj.getDepartment_id()); 
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
