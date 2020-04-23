/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.faculty;

import com.iso.dao.FormDao;
import com.iso.dao.FormFieldDataDao;
import com.iso.dao.SubjectTeachesDao;
import com.iso.models.Form;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nitant
 */
@WebServlet(name = "FacultyDashboardServlet", urlPatterns = {"/faculty"})
public class FacultyDashboardServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user_id",2);
        int user_id = (int) session.getAttribute("user_id");
        SubjectTeachesDao subjectTeach = new SubjectTeachesDao();
        ArrayList<Integer> subjectIdList = (ArrayList<Integer>)subjectTeach.getSubjectList(user_id);
        ArrayList<Form> formList = (ArrayList<Form>)new FormDao().view();
        ArrayList<Form> subjectFormList = new ArrayList();
        
        for(Form form : formList){
            if(form.isIs_enabled()){
                if(subjectIdList.contains(form.getSubject_id())){
                    subjectFormList.add(form);
                }
            }
        }
        Logger.getLogger(FacultyDashboardServlet.class.getName()).log(Level.SEVERE, subjectIdList.toString());
        Logger.getLogger(FacultyDashboardServlet.class.getName()).log(Level.SEVERE, formList.toString());
        Logger.getLogger(FacultyDashboardServlet.class.getName()).log(Level.SEVERE, subjectFormList.toString());
        request.setAttribute("formList", subjectFormList);
        request.getRequestDispatcher("/templates/faculty/faculty_dashboard.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user_id",2);
        int user_id = (int) session.getAttribute("user_id");
        SubjectTeachesDao subjectTeach = new SubjectTeachesDao();
        ArrayList<Integer> subjectIdList = (ArrayList<Integer>)subjectTeach.getSubjectList(user_id);
        ArrayList<Form> formList = (ArrayList<Form>)new FormDao().view();
        ArrayList<Form> subjectFormList = new ArrayList();
        
        for(Form form : formList){
            if(form.isIs_enabled()){
                if(subjectIdList.contains(form.getSubject_id())){
                    subjectFormList.add(form);
                }
            }
        }
        Logger.getLogger(FacultyDashboardServlet.class.getName()).log(Level.SEVERE, subjectIdList.toString());
        Logger.getLogger(FacultyDashboardServlet.class.getName()).log(Level.SEVERE, formList.toString());
        Logger.getLogger(FacultyDashboardServlet.class.getName()).log(Level.SEVERE, subjectFormList.toString());
        request.setAttribute("formList", subjectFormList);
        request.getRequestDispatcher("/templates/faculty/faculty_dashboard.jsp").forward(request, response);
    }

    
  
}
