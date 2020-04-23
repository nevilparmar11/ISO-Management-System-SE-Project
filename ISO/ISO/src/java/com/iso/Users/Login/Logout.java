/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.Users.Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nevil
 */

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String msg = "You are successfully logged out...!!!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").include(request, response);

            HttpSession session = request.getSession(false);
            session.invalidate();
            
            out.close();
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String msg = "You are successfully logged out...!!!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").include(request, response);

            HttpSession session = request.getSession(false);
            session.invalidate();
            
            out.close();
        }
    }
}
