<%-- 
    Document   : faculty_form
    Created on : 23 Apr, 2020, 12:15:58 AM
    Author     : Nitant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="/templates/users/dashboard/dashboard.jsp"/>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="crossorigin="anonymous"></script>
        <title>Lab planning</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <center>
            <div>
                <h4>Dharmsinh Desai University, Nadiad<br>
                        Faculty of Technology, <br>
                    Department of Computer Engineering </h4>
                <br>
                <table width="76%">
                    <tr>
                        <td>
                            Department Document No 6
                        </td>
                        <td>
                            Document Version No. 0
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Document Name:<c:out value="${requestScope.form.getName()}"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            Date: <c:out value="${requestScope.form.getTeaching_plan_start()}"/> to <c:out value="${requestScope.form.getTeaching_plan_end()}"/>
                        </td>
                        <td>
                            Department name: <c:out value="${requestScope.department.getName()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>    
                            Subject Name : <c:out value="${requestScope.subject.getSubject_name()}"/>
                        </td>
                        <td>
                            Semester :<c:out value="${requestScope.subject.getSemester()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Hardware/Software required : -
                        </td>
                    </tr>
                </table>
                
                <table border="2">
                    <c:forEach var="user" items="${requestScope.faculty}">
                       <tr>
                        <th>Faculty name:</th>
                        <td><c:out value="${user.getFirst_name()}"/></td>
                        <th>Designation:</th>
                        <td><c:out value="${user.getRole()}"/></td>
                        <th>Department: </th    >
                        <td><c:out value="${user.getDepartment().getName()}"/></td>
                        </tr>  
                    </c:forEach>
                   
                </table>
            </div>
            <br><br>
            <form action="/ISO/faculty/form" method="POST">
            <div>
                <table width="76%" border="1" id="myTable">
                    <tr>
                        <th>
                            Sr. No.
                        </th>
                        <th>
                            <c:out value="${requestScope.formStructure.getField_1()}"/>
                        </th>
                        <th>
                            <c:out value="${requestScope.formStructure.getField_2()}"/>
                        </th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach var="row" items="${requestScope.formField}" varStatus="sr">
                    <tr>
                        <td>
                            <input type="number" min="1" name="sequence[]" value="<c:out value="${row.getSequence()}"/>">
                            
                        </td>
                        <td>
                            <textarea cols="100" rows="3" name="topics[]">
                                <c:out value="${row.getField_1()}"/>
                            </textarea>
                        </td>
                        <td>
                            <input type="text" name="hours[]" value="<c:out value="${row.getField_2()}"/>">
                        </td>
                        <td><input type="button" value="Delete" /></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
<!--            <p><b>Document submitted by:</b></p>
            <div>
                <table width="76%">
                    <tr>
                        <td>
                            1) Name of the prof: <select name="faculty">
                                                    <option value="">Prof...</option>
                                                    <option value="">Prof...</option>
                                                    <option value="">Prof...</option>
                                                </select>
                        </td>
                        <td>
                            Designation: <select name="designation">
                                            <option value="">Asst. Prof.</option>
                                            <option value="">Associate Prof.</option>
                                        </select>
                        </td>
                        <td>
                            Date: <input type="date">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            2) Name of the prof: <select name="faculty">
                                                    <option value="">Prof...</option>
                                                    <option value="">Prof...</option>
                                                    <option value="">Prof...</option>
                                                </select>
                        </td>
                        <td>
                            Designation: <select name="designation">
                                            <option value="">Asst. Prof.</option>
                                            <option value="">Associate Prof.</option>
                                        </select>
                        </td>
                        <td>
                            Date: <input type="date">
                        </td>
                    </tr>
                </table>-->
                
                
               <input type="hidden" value="${requestScope.form.getForm_id()}" name="form">
               <input type="submit" value="Update">
            </div>
            <p>
                <input type="button" value="Insert row">
            </p>
            </form>
            
            <table width="76%">
                    <tr>
                        <td>Remarks (if any):<c:out value="${requestScope.review.getRemarks()}"/> 
                        <td></td>
                    </tr>
                    
            </table>
        </center>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</html>

<script>
  $('#myTable').on('click', 'input[type="button"]', function () {
      $(this).closest('tr').remove();
  })
  $('p input[type="button"]').click(function () {
      $('#myTable').append('<tr><td><input type="number" min="1" name="sequence[]"/></td> <td><textarea name="topics[]"  cols="100" rows="3"></textarea></td><td><input type="text" name="hours[]"/></td><td><input type="button" value="Delete" /></td></tr>')
  });
</script>

