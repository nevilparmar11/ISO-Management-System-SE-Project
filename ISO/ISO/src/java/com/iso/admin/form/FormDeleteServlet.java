/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.admin.form;

import com.iso.dao.Dao;
import com.iso.dao.FormDao;
import com.iso.models.Form;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nitant
 */
@WebServlet(name = "FormDeleteServlet", urlPatterns = {"/admin/form/delete"})
public class FormDeleteServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          int document_number = Integer.parseInt(request.getParameter("Document No"));
          
          Dao formDao = new FormDao();
          formDao.delete(new Form(document_number));
          response.sendRedirect("/ISO/admin/form");
    }

}
