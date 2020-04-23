/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.Users.Login;

import com.iso.dao.UserDao;
import com.iso.models.User;
import com.iso.services.DatabaseConnectionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nevil
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String query = "Select * from user where e_email=? and c_password=?";
            Connection con = DatabaseConnectionService.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, request.getParameter("email"));
            ps.setString(2, request.getParameter("pass"));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserDao userdao = new UserDao();
                int id = rs.getInt("i_user_id");
                User user = userdao.getUser(id);
                request.getSession().setAttribute("user", user);
                String userrole = user.getRole();

                if (request.getParameter("role").equals("Faculty") && userrole.equals("Faculty")) {
                    request.getRequestDispatcher("faculty").forward(request, response);
                }

                else if (request.getParameter("role").equals("Admin") && userrole.equals("Admin")) {
                    request.getRequestDispatcher("admin/form").forward(request, response);
//                      response.sendRedirect("ISO/admin/form");
                } else {
                    String msg = "You did select incorrect role...!!!";
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                }
            } else {
                String msg = "Invalid username/password...!!!";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
