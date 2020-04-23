/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.faculty;

import com.iso.dao.DepartmentDao;
import com.iso.dao.FormDao;
import com.iso.dao.FormFieldDataDao;
import com.iso.dao.FormReviewDao;
import com.iso.dao.FormStructureDao;
import com.iso.dao.SubjectDao;
import com.iso.dao.SubjectTeachesDao;
import com.iso.dao.UserDao;
import com.iso.models.Department;
import com.iso.models.Form;
import com.iso.models.FormFieldData;
import com.iso.models.FormReview;
import com.iso.models.FormStructure;
import com.iso.models.Subject;
import com.iso.models.SubjectTeaches;
import com.iso.models.User;
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

/**
 *
 * @author Nitant
 */

@WebServlet(name = "FacultyFormServlet", urlPatterns = {"/faculty/form"})
public class FacultyFormServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int form_id = Integer.parseInt(request.getParameter("Document No"));
       
       FormDao formDao = new FormDao();
       DepartmentDao departmentDao = new DepartmentDao();
       SubjectTeachesDao subjectTeachesDao = new SubjectTeachesDao();
       SubjectDao subjectDao = new SubjectDao();
       FormFieldDataDao formFieldDataDao = new FormFieldDataDao();
       UserDao userDao = new UserDao();
       FormReviewDao reviewDao = new FormReviewDao();
       
       Form form = formDao.viewSpecific(form_id);
       Subject subject = subjectDao.getSpecific(form.getSubject_id());
       Department department = departmentDao.getSpecific(form.getDepartment_id());
       ArrayList<SubjectTeaches> subjectTeaches = (ArrayList<SubjectTeaches>) subjectTeachesDao.getSubjectTeaches(form.getSubject_id());
       ArrayList<FormFieldData> formField = (ArrayList<FormFieldData>)formFieldDataDao.getFormData(form.getForm_id());
       FormStructure formStructure = new FormStructureDao().getSpecificStructure(form.getForm_structure_id());
       ArrayList<User> facultyList = new ArrayList<>();
       FormReview review = reviewDao.getReview(form.getForm_id());
       for(int i=0; i<subjectTeaches.size(); i++){
           SubjectTeaches subjectTeach = subjectTeaches.get(i);
           //Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,subjectTeach.getUser_id()+""); 
           User user = userDao.getUser(subjectTeach.getUser_id());
           facultyList.add(user);
       }
       
//       Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,subjectTeaches.toString());
//       Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,facultyList.toString());
//       
       request.setAttribute("form", form);
       request.setAttribute("subject", subject);
       request.setAttribute("department", department);
//       request.setAttribute("subjectTeach", subjectTeaches);
       request.setAttribute("formField", formField);
       request.setAttribute("faculty", facultyList);
       request.setAttribute("formStructure", formStructure);
       request.setAttribute("review", review);
       Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,review.getRemarks());
//       Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,formStructure.toString());
       request.getRequestDispatcher("/templates/faculty/faculty_form.jsp").forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = false;
        int form = 0;
        try{
            String sequence[] = req.getParameterValues("sequence[]");
            String hours[] = req.getParameterValues("hours[]");
            String topics[] = req.getParameterValues("topics[]");
            form = Integer.parseInt(req.getParameter("form"));
            
            if(sequence==null || sequence.length==0){
                new FormFieldDataDao().deleteAll();
            }
            Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,topics.length+"");
            Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,hours.length+"");
            Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,sequence.length+"");
            FormFieldDataDao fieldDataDao = new FormFieldDataDao();
            fieldDataDao.deleteAll();
            for(int i=0; i<sequence.length; i++){
                int seq=0,hour=0;
                if(!(sequence[i].trim().isEmpty() || hours[i].trim().isEmpty() || topics[i].trim().isEmpty())){
                    seq = Integer.parseInt(sequence[i]);
                    hour = Integer.parseInt(hours[i]);
                    String topic = topics[i].trim();
                    FormFieldData row = new FormFieldData(topic,hour,form,seq);
                    fieldDataDao.insert(row);
                }
            }
            
        }catch(Exception e){
            flag=true;
        }
        if(!flag){
            resp.sendRedirect("/ISO/faculty/form?Document No="+form);
        }else{
             resp.sendRedirect("/ISO/faculty");
        }
        //Logger.getLogger(FacultyFormServlet.class.getName()).log(Level.SEVERE,req.getRequestURL().toString());
        //resp.sendRedirect(req.getRequestURL().toString())
       
        
        
    }
    
    

}
