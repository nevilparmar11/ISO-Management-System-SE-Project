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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nitant
 */
@WebServlet(name = "FormViewServlet", urlPatterns = {"/admin/form"})
public class FormViewServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Dao formDao = new FormDao();
        ArrayList<Form> formList = (ArrayList<Form>) formDao.view();
        Logger.getLogger(FormViewServlet.class.getName()).log(Level.SEVERE, formList.toString());
        request.setAttribute("formList", formList);
        request.getRequestDispatcher("/templates/admin/form/form_view.jsp").forward(request, response);
    }

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Dao formDao = new FormDao();
        ArrayList<Form> formList = (ArrayList<Form>) formDao.view();
        Logger.getLogger(FormViewServlet.class.getName()).log(Level.SEVERE, formList.toString());
        request.setAttribute("formList", formList);
        request.getRequestDispatcher("/templates/admin/form/form_view.jsp").forward(request, response);
    }
  
}
