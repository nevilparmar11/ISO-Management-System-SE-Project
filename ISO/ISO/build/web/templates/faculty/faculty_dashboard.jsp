<%-- 
    Document   : faculty_dashboard
    Created on : 23 Apr, 2020, 12:15:46 AM
    Author     : Nitant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="/templates/users/dashboard/dashboard.jsp"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
   <body>
    <br>    
    <div class="container">
        <table border="1" class="table">
            <tr>
                <th>Document No</th>
                <th>Form Name</th>
                <th>Type</th>              
                <th colspan="1">Operation</th>
            </tr>
            
            <c:forEach var="form" items="${requestScope.formList}">
                 <tr>
                     <td><c:out value="${form.getForm_id()}"/></td>
                     <td><c:out value="${form.getName()}"/></td>
                     <td><c:out value="${form.getType()}"/></td>
                     <td><a href="/ISO/faculty/form?Document No=<c:out value="${form.getForm_id()}"/>">View</td>
                     
                 </tr>
            </c:forEach>
        </table>
    </div>
    
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</html>
