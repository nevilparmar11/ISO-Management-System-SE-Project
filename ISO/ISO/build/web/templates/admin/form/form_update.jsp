<%-- 
    Document   : form_update
    Created on : 22 Apr, 2020, 2:19:19 PM
    Author     : Nitant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="/templates/users/dashboard/dashboard.jsp"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <br><br>
        <div class="container">
        <form action="/ISO/admin/form/update" method="POST">
            <table class="table">
                <tr class="row">
                    <td width="40%" >Document Number</td>
                    <td><input class="form-control" type="number" name="document_no" value="<c:out value="${requestScope.form.getForm_id()}"/>"></td>
                </tr> 
                <tr class="row">
                    <td width="40%">Document Name</td>
                    <td><input class="form-control" type="text" name="name" value="<c:out value="${requestScope.form.getName()}"/>"></td>
                </tr>
                <tr class="row">
                    <td width="40%" >Institute</td>
                    <td class="dropdown">
                        <select class="dropdown-item" name="institute">
                            <c:forEach var="institute" items="${requestScope.instituteList}">
                               
                                <option value="${institute.getInstitute_id()}"><c:out value="${institute.getName()}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="row">
                    <td width="40%" >Department</td>
                    <td>
                        <select  class="dropdown-item" name="department">
                             <c:forEach var="department" items="${requestScope.departmentList}">
                                <option value="${department.getDepartment_id()}"><c:out value="${department.getName()}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="row">
                    <td width="40%" >Subject</td>
                    <td>
                        <select  class="dropdown-item" name="subject">
                            <c:forEach var="subject" items="${requestScope.subjectList}">
                                <option value="${subject.getSubject_id()}"><c:out value="${subject.getSubject_name()}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                  <tr class="row">
                    <td width="40%">Type</td>
                    <td>
                        <select  class="dropdown-item" name="type">
                            <option value="<c:out value="${requestScope.form.getForm_structure_id()}"/>" selected><c:out value="${requestScope.form.getType()}"/></option>
                            <c:forEach var="formStructure" items="${requestScope.formStructureList}">
                                <option value="${formStructure.getForm_structure_id() }"><c:out value="${formStructure.getName()}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="row">
                    <td width="40%">Starting Teaching Plan</td>
                    <td><input class="form-control" type="date" name="starting_plan" value="<c:out value="${requestScope.form.getTeaching_plan_start()}"/>"></td>
                </tr>
                <tr class="row">
                    <td width="40%">Ending Teaching Plan</td>
                    <td><input class="form-control" type="date" name="ending_plan" value="<c:out value="${requestScope.form.getTeaching_plan_end()}"/>"></td>
                </tr>
            </table>
            <br>
            <br>
            <input class="btn btn-primary" type="submit" value="Update">
        </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
    </body>
</html>
